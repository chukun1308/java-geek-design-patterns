package com.chukun.designer.pattern.structure.adapter.unite.v2;

import com.chukun.designer.pattern.structure.adapter.unite.v1.CSensitiveWordsFilter;

/**
 * @author chukun
 *  C过滤词的适配器
 */
public class CSensitiveWordsFilterAdaptor implements ISensitiveWordsFilter {

    private CSensitiveWordsFilter aFilter;

    @Override
    public String filter(String text) {
        String filterWord = aFilter.filter(text,"");
        return filterWord;
    }
}
