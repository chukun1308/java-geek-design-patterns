package com.chukun.designer.pattern.prototype;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chukun
 *  有一个特殊的要求：任何时刻，系统 A 中的所有数据都必须是同一个版本的，要么都是版本 a，要么都是版本 b，
 *  不能有的是版本 a，有的是版本 b。那刚刚的更新方式就不能满足这个要求了。除此之外，
 *  还要求：在更新内存数据的时候，系统 A 不能处于不可用状态，也就是不能停机更新数据。
 *
 *  解决思路:
 *    把正在使用的数据的版本定义为 "服务版本"，当我们要更新内存中的数据的时候，
 *    并不是直接在服务版本（假设是版本 a 数据）上更新，而是重新创建另一个版本数据（假设是版本 b 数据），
 *    等新的版本数据建好之后，再一次性地将服务版本从版本 a 切换到版本 b。这样既保证了数据一直可用，又避免了中间状态的存在
 *
 *  缺点:
 *    需要将这 10 万条数据从数据库中读出，然后计算哈希值，构建 newKeywords。
 *    这个过程显然是比较耗时。为了提高效率，原型模式就派上用场了。
 */
public class PrototypeDemo02 {

    private Map<String,SearchWord> currentKeyWords = new HashMap<>();
    private int  version = -1;

    public void refresh() {
        Map<String,SearchWord> newKeyWordMap = new HashMap<>();
        List<SearchWord> searchWords = getSearchWords(version);
        for (SearchWord searchWord : searchWords) {
            newKeyWordMap.put(searchWord.getKeyWord(),searchWord);
        }
        currentKeyWords = newKeyWordMap;
    }

    private List<SearchWord> getSearchWords(long version) {
        // 从数据库里面查询更新时间 指定版本的数据
        return new ArrayList<>();
    }
}
