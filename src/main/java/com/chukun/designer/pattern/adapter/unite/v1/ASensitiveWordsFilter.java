package com.chukun.designer.pattern.adapter.unite.v1;

/**
 * @author chukun
 *   A敏感词过滤系统提供的接口
 */
public class ASensitiveWordsFilter {

    /**
     * text是原始文本，函数输出用***替换敏感词之后的文本
     * @param word
     * @return
     */
    public String filterSexyWords(String word) {
        return "";
    }

    public String filterPoliticalWords(String word) {
        return "";
    }

}
