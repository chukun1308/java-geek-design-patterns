package com.chukun.designer.pattern.adapter.unite.v2;

import com.chukun.designer.pattern.adapter.unite.v1.ASensitiveWordsFilter;

/**
 * @author chukun
 *  A过滤词的适配器
 */
public class ASensitiveWordsFilterAdaptor implements ISensitiveWordsFilter {

    private ASensitiveWordsFilter aFilter;

    @Override
    public String filter(String text) {
        String filterWord = aFilter.filterSexyWords(text);
        filterWord = aFilter.filterPoliticalWords(filterWord);
        return filterWord;
    }
}
