package com.chukun.designer.action.idempotent;

/**
 * @author chukun
 * redis 存储幂等号
 */
public class RedisStoreIdempotenceStorage implements IdempotenceStorage{

    private RedisOperation redisOperation;

    public RedisStoreIdempotenceStorage(RedisOperation redisOperation) {
        this.redisOperation = redisOperation;
    }

    @Override
    public boolean saveIfAbsent(String idempotenceId) {
        Long setnx = redisOperation.jedisClient().setnx(idempotenceId, "1");
        return setnx == 1;
    }

    @Override
    public boolean delete(String idempotenceId) {
        Long del = redisOperation.jedisClient().del(idempotenceId);
        return del == 1;
    }
}
