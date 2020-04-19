package com.chukun.designer.pattern.create.builder;

/**
 * @author 初坤
 * 普通对象生成
 *
 * 缺点:
 *   用 set() 函数来给成员变量赋值，以替代冗长的构造函数
 */
public class ResourcePoolConfigV2 {
    private String name;
    private static final int DEFAULT_MAX_TOTAL = 8;
    private static final int DEFAULT_MAX_IDLE = 8;
    private static final int DEFAULT_MIN_IDLE = 0;
    private int maxTotal = DEFAULT_MAX_TOTAL;
    private int maxIdle = DEFAULT_MAX_IDLE;
    private int minIdle = DEFAULT_MIN_IDLE;

    public ResourcePoolConfigV2(String name) {
        if (null == name || "".equals(name)) {
            throw new IllegalArgumentException("name must not be empty");
        }
        this.name = name;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        if (maxTotal < 0) {
                throw new IllegalArgumentException("maxTotal should be positive");
        }
        this.maxTotal = maxTotal;

    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        if (maxIdle < 0) {
            throw new IllegalArgumentException("maxIdle should be positive");
        }
        this.maxIdle = maxIdle;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        if (minIdle < 0) {
            throw new IllegalArgumentException("minIdle should be positive");
        }
        this.minIdle = minIdle;
    }

    public static void main(String[] args) {

        // ResourcePoolConfig使用举例
        ResourcePoolConfigV2 config = new ResourcePoolConfigV2("dbconnectionpool");
        config.setMaxTotal(16);
        config.setMaxIdle(8);
    }
}
