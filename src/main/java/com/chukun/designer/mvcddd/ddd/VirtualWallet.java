package com.chukun.designer.mvcddd.ddd;

import java.math.BigDecimal;

/**
 * 虚拟钱包
 * DDD
 * Domain领域模型(充血模型)
 */
public class VirtualWallet {

    private Long id;
    private Long createTime = System.currentTimeMillis();
    //余额
    private BigDecimal balance = BigDecimal.ZERO;
    //是否允许透支
    private boolean isAllowedOverdraft = true;
    //透支金额
    private BigDecimal overdraftAmount = BigDecimal.ZERO;
    //冻结金额
    private BigDecimal frozenAmount = BigDecimal.ZERO;

    public VirtualWallet(Long preAllocatedId){
        this.id = preAllocatedId;
    }

    public BigDecimal balance(){
        return this.balance;
    }

    /**
     * 冻结金额
     * @param amount
     */
    public void freeze(BigDecimal amount) {
        //...
    }

    /**
     * 解封金额
     * @param amount
     */
    public void unfreeze(BigDecimal amount) {
        //...

    }

    /**
     * 增加透支金额
     * @param amount
     */
    public void increaseOverdraftAmount(BigDecimal amount) {
        //...
    }

    /**
     * 减少透支金额
     * @param amount
     */
    public void decreaseOverdraftAmount(BigDecimal amount) {
        //...
    }

    /**
     * 关闭是否可以透支金额
     */
    public void closeOverdraft() {
        //...
    }

    /**
     * 打开是否可以透支金额
     */
    public void openOverdraft() {
        //...
    }

    /**
     * 出账
     * @param amount
     */
    public void debit(BigDecimal amount){
       if(this.balance.compareTo(amount)<0){
           throw new RuntimeException("余额不足");
       }
       this.balance.subtract(amount);
    }

    /**
     * 充值
     * @param amount
     */
    public void credit(BigDecimal amount){
        if(BigDecimal.ZERO.compareTo(amount)>0){
            throw new RuntimeException("充值金额不能为负数");
        }
        this.balance.add(amount);
    }

    /**
     * 获取可用的金额
     * @return
     */
    public BigDecimal getAvailableBalance(){
        BigDecimal totalAvailableBalance = this.balance.subtract(frozenAmount);
        if(isAllowedOverdraft){
            totalAvailableBalance.add(overdraftAmount);
        }
        return totalAvailableBalance;
    }



}
