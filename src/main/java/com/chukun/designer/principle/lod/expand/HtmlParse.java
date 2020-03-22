package com.chukun.designer.principle.lod.expand;

import com.chukun.designer.principle.lod.Html;

/**
 * @author chukun
 *  html 解析实现
 */
public class HtmlParse implements Parse<Html> {
    @Override
    public String parse(Html html) {
        return html.getContent();
    }
}
