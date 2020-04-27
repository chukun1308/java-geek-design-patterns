package com.chukun.designer.pattern.behaviour.responsibility.chain;

public class PoliticalWordFilter implements SensitiveWordFilter {


    @Override
    public boolean doFilter(Content content) {
        boolean legal = false;
        // 省略处理逻辑
        System.out.println("PoliticalWordFilter filter content...." + content.getWord());
        return true;
    }
}
