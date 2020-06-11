package com.chukun.designer.action.idempotent;

/**
 * @author chukun
 *  幂等实现
 */
public class Idempotence {

    private IdempotenceStorage storage;

    public Idempotence(IdempotenceStorage storage) {
        this.storage = storage;
    }

    public boolean saveIfAbsent(String idempotenceId) {
        boolean isSuccess = false;
        try{
            isSuccess = storage.saveIfAbsent(idempotenceId);
        }catch (Exception e) {

        }
        return isSuccess;
    }

    public boolean delete(String idempotenceId) {
        boolean isSuccess = false;
        try{
            isSuccess = storage.delete(idempotenceId);
        }catch (Exception e) {

        }
        return isSuccess;

    }
}
