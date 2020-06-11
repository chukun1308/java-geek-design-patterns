package com.chukun.designer.action.idempotent;

import java.util.UUID;

/**
 * @author chukun
 *  幂等号的生成算法
 */
public class IdempotenceIdGenerator {

    /**
     * 幂等号的生成算法
     * @return
     */
    public String generateId() {
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
