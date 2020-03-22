package com.chukun.designer.principle.lod.expand;


import java.util.HashMap;
import java.util.Map;

/**
 * @author chukun
 *  parse工厂方法实现
 */
public class ParseFactory {

    private static final Map<String,Parse> parseFactoryMap = new HashMap<>();

    static {
        parseFactoryMap.put("html",new HtmlParse());
    }

    private ParseFactory(){
        throw new RuntimeException("singleton is not initialized....");
    }

    private static class ParseFactoryHolder {
        final  static ParseFactory parseFactory = new ParseFactory();
    }

    public static ParseFactory getInstance() {
        return ParseFactoryHolder.parseFactory;
    }

    public  Parse createParse (String key) {
        return parseFactoryMap.getOrDefault(key,new HtmlParse());
    }

}
