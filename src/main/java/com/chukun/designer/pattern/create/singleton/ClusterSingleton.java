package com.chukun.designer.pattern.create.singleton;

import java.io.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 集群环境 单例对象大概思路
 */
public class ClusterSingleton {

    private static Map<String,ClusterSingleton> cacheMap = new ConcurrentHashMap<>();

    private ClusterSingleton() {}

    private static class ClusterSingletonHolder {
        private static final  ClusterSingleton  CLUSTER_SINGLETON = readSingleFromFile("clusterSingleton");
    }

    public static ClusterSingleton getInstance() {
        return ClusterSingletonHolder.CLUSTER_SINGLETON;
    }

    /**
     * 初始化一次
     */
    public void writeSingleton2File() {
        // 使用分布锁
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("singleton.bin"));
            ClusterSingleton clusterSingleton = new ClusterSingleton();
            out.writeObject(clusterSingleton);
        }catch (IOException | SecurityException e) {
            e.printStackTrace();
        }finally {
            // 释放锁
        }
    }

    private static ClusterSingleton readSingleFromFile(String key) {
        ClusterSingleton clusterSingleton = null;
        try {
            if (cacheMap.containsKey(key)) {
                return cacheMap.get(key);
            }
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("singleton.bin"));
            Object object = in.readObject();
            if (object instanceof ClusterSingleton) {
                clusterSingleton = (ClusterSingleton) object;
                cacheMap.put(key,clusterSingleton);
            }
            return clusterSingleton;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
