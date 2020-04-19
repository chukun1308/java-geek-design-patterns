package com.chukun.designer.pattern.structure.adapter.replace;

/**
 * 将外部系统A替换成外部系统B
 */
public class BSystemAdapter implements IASystem {

    private IBSystem ibSystem;

    public BSystemAdapter(IBSystem ibSystem) {
        this.ibSystem = ibSystem;
    }

    @Override
    public void functA() {
       // 调用 B 系统的相关实现
        ibSystem.functB();
    }
}
