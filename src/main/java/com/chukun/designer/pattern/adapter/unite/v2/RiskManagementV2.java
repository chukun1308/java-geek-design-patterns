package com.chukun.designer.pattern.adapter.unite.v2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chukun
 *
 *  假设系统要对用户输入的文本内容做敏感词过滤，为了提高过滤的召回率，引入了多款第三方敏感词过滤系统，
 *  依次对用户输入的内容进行过滤，过滤掉尽可能多的敏感词。但是，每个系统提供的过滤接口都是不同的。
 *  这就意味着没法复用一套逻辑来调用各个系统。这个时候，就可以使用适配器模式，将所有系统的接口适配为统一的接口定义，
 *  这样可以复用调用敏感词过滤的代码
 *
 *  扩展性更好，更加符合开闭原则，如果添加一个新的敏感词过滤系统，
 *  这个类完全不需要改动；而且基于接口而非实现编程，代码的可测试性更好。
 *
 *  统一多个类的接口设计
 */
public class RiskManagementV2 {

    private List<ISensitiveWordsFilter> filters = new ArrayList<>();

    public void addFilter(ISensitiveWordsFilter filter) {
        filters.add(filter);
    }

    public String filterSensitiveWords(String word) {
        if (filters.size() == 0) {
            return "";
        }
        String maskedText = word;
        for (ISensitiveWordsFilter filter : filters) {
            maskedText = filter.filter(maskedText);
        }
        return maskedText;
    }
}
