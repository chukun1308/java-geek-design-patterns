package com.chukun.designer.pattern.adapter.unite.v2;

import com.chukun.designer.pattern.adapter.unite.v1.BSensitiveWordsFilter;
import com.chukun.designer.pattern.adapter.unite.v1.CSensitiveWordsFilter;

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
