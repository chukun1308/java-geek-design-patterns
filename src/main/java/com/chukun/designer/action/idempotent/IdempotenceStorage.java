package com.chukun.designer.action.idempotent;

/**
 * @author chukun
 *   幂等号的存储相关操作
 */
public interface IdempotenceStorage {

    /**
     * 保存幂等号
     * @param idempotenceId
     * @return
     */
    boolean saveIfAbsent(String idempotenceId);

    /**
     * 删除幂等号
     * @param idempotenceId
     * @return
     */
    boolean delete(String idempotenceId);
}
