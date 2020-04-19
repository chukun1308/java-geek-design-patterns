package com.chukun.designer.pattern.create.prototype.v3;

import com.chukun.designer.pattern.create.prototype.SearchWord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chukun
 * <p>
 * 需要将这 10 万条数据从数据库中读出，然后计算哈希值，构建 newKeywords。
 * 这个过程显然是比较耗时。为了提高效率，原型模式就派上用场了。
 * <p>
 * 拷贝 currentKeywords 数据到 newKeywords 中，然后从数据库中只捞出新增或者有更新的关键词，更新到 newKeywords 中。
 * 而相对于 10 万条数据来说，每次新增或者更新的关键词个数是比较少的，所以，这种策略大大提高了数据更新的效率
 */
public class PrototypeDemo03 {

    private Map<String, SearchWord> currentKeyWords = new HashMap<>();
    private long lastUpdateTime = -1;

    /**
     * 浅拷贝代码示例
     */
    public void refresh01() {
        // 这样只是浅拷贝，SearchWord对象不会被copy
        Map<String, SearchWord> newKeyWordMap = currentKeyWords;
        // 从数据库中取出更新时间>lastUpdateTime的数据，放入到newKeywords中
        List<SearchWord> searchWords = getSearchWords(lastUpdateTime);
        long maxNewUpdatedTime = lastUpdateTime;
        for (SearchWord searchWord : searchWords) {
            if (searchWord.getLastUpdateTime() > maxNewUpdatedTime) {
                maxNewUpdatedTime = searchWord.getLastUpdateTime();
            }
            if (newKeyWordMap.containsKey(searchWord.getKeyWord())) {
                SearchWord oldSearchWord = newKeyWordMap.get(searchWord.getKeyWord());
                oldSearchWord.setCount(searchWord.getCount());
                oldSearchWord.setLastUpdateTime(searchWord.getLastUpdateTime());
            } else {
                newKeyWordMap.put(searchWord.getKeyWord(), searchWord);
            }
        }
        lastUpdateTime = maxNewUpdatedTime;
        currentKeyWords = newKeyWordMap;
    }

    /**
     * 深拷贝代码示例
     */
    public void refresh02() {
        Map<String, SearchWord> newKeyWordMap = new HashMap<>();
        SearchWord newSearchWord = null;
        SearchWord currentSearchWord = null;
        // 深拷贝
        for (Map.Entry<String, SearchWord> entry : currentKeyWords.entrySet()) {
            currentSearchWord = entry.getValue();
            newSearchWord = new SearchWord();
            newSearchWord.setKeyWord(entry.getKey());
            newSearchWord.setCount(currentSearchWord.getCount());
            newSearchWord.setLastUpdateTime(currentSearchWord.getLastUpdateTime());
            newKeyWordMap.put(entry.getKey(),newSearchWord);
        }

        // 从数据库中取出更新时间>lastUpdateTime的数据，放入到newKeywords中
        List<SearchWord> searchWords = getSearchWords(lastUpdateTime);
        long maxNewUpdatedTime = lastUpdateTime;
        for (SearchWord searchWord : searchWords) {
            if (searchWord.getLastUpdateTime() > maxNewUpdatedTime) {
                maxNewUpdatedTime = searchWord.getLastUpdateTime();
            }
            if (newKeyWordMap.containsKey(searchWord.getKeyWord())) {
                SearchWord oldSearchWord = newKeyWordMap.get(searchWord.getKeyWord());
                oldSearchWord.setCount(searchWord.getCount());
                oldSearchWord.setLastUpdateTime(searchWord.getLastUpdateTime());
            } else {
                newKeyWordMap.put(searchWord.getKeyWord(), searchWord);
            }
        }
        lastUpdateTime = maxNewUpdatedTime;
        currentKeyWords = newKeyWordMap;
    }

    /**
     * 可以先采用浅拷贝的方式创建 newKeywords。对于需要更新的 SearchWord 对象，
     * 再使用深度拷贝的方式创建一份新的对象，替换 newKeywords 中的老对象。
     * 毕竟需要更新的数据是很少的。这种方式即利用了浅拷贝节省时间、空间的优点，
     * 又能保证 currentKeywords 中的中数据都是老版本的数据
     */
    public void refresh03() {
        Map<String, SearchWord> newKeyWordMap = currentKeyWords;
        // 从数据库中取出更新时间>lastUpdateTime的数据，放入到newKeywords中
        List<SearchWord> searchWords = getSearchWords(lastUpdateTime);
        long maxNewUpdatedTime = lastUpdateTime;
        for (SearchWord searchWord : searchWords) {
            if (searchWord.getLastUpdateTime() > maxNewUpdatedTime) {
                maxNewUpdatedTime = searchWord.getLastUpdateTime();
            }
            // 先删除，在放入
            if (newKeyWordMap.containsKey(searchWord.getKeyWord())) {
               newKeyWordMap.remove(searchWord.getKeyWord());
            }
            newKeyWordMap.put(searchWord.getKeyWord(), searchWord);
        }
        lastUpdateTime = maxNewUpdatedTime;
        currentKeyWords = newKeyWordMap;
    }



    private List<SearchWord> getSearchWords(long lastUpdateTime) {
        // 从数据库里面查询更新时间 大于 lastUpdateTime 的数据
        return new ArrayList<>();
    }
}
