package com.chukun.designer.pattern.behaviour.responsibility.chain;

public class SexyWordFilter implements SensitiveWordFilter {


    @Override
    public boolean doFilter(Content content) {
        boolean legal = false;
        // 省略处理逻辑
        System.out.println("SexyWordFilter filter content...." + content.getWord());
        return true;
    }
}
