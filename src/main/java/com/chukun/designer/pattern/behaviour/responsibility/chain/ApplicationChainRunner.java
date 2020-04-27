package com.chukun.designer.pattern.behaviour.responsibility.chain;

/**
 * @author chukun
 *
 *  对于支持 UGC（User Generated Content，用户生成内容）的应用（比如论坛）来说，
 *  用户生成的内容（比如，在论坛中发表的帖子）可能会包含一些敏感词（比如涉黄、广告、反动等词汇）。
 *  针对这个应用场景，可以利用职责链模式来过滤这些敏感词
 */
public class ApplicationChainRunner {

    public static void main(String[] args) {
        SensitiveWordFilterChain chain = new SensitiveWordFilterChain();
        chain.addFilter(new SexyWordFilter());
        chain.addFilter(new PoliticalWordFilter());
        Content content = new Content();
        content.setWord("sexy girl******");
        chain.filter(content);
    }
}
