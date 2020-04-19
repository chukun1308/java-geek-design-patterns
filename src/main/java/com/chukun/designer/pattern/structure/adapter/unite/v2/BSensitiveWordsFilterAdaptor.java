package com.chukun.designer.pattern.structure.adapter.unite.v2;

import com.chukun.designer.pattern.structure.adapter.unite.v1.BSensitiveWordsFilter;

/**
 * @author chukun
 *  B过滤词的适配器
 */
public class BSensitiveWordsFilterAdaptor implements ISensitiveWordsFilter {

    private BSensitiveWordsFilter aFilter;

    @Override
    public String filter(String text) {
        String filterWord = aFilter.filter(text);
        return filterWord;
    }
}
