package com.chukun.designer.action.idempotent;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;
import org.redisson.config.TransportMode;
import redis.clients.jedis.Jedis;

/**
 * @author chukun
 *  jedis/redisson客户端
 */
public class RedisOperation {

    private static String redissonServer = "redis://192.168.60.100:6379";

    private static final RedissonClient redissonClient;

    private static final Jedis jedis;

    static {
        Config config = new Config();
        config.setTransportMode(TransportMode.NIO);
        config.useSingleServer().setAddress(redissonServer);
        config.setCodec(new JsonJacksonCodec());
        redissonClient = Redisson.create(config);
        // 初始化 redis
        jedis = new Jedis("192.168.60.100",6379);
    }

    /**
     * 普通客户端
     * @return
     */
    public  RedissonClient redissonClient() {
        return redissonClient;
    }

    /**
     * jedis客户端
     * @return
     */
    public  Jedis jedisClient() {
        return jedis;
    }


}
