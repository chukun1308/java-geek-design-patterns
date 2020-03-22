package com.chukun.designer.principle.lod.expand;

/**
 * @author
 *  示例类
 */
public class MainRunner {

    public static void main(String[] args) {
        // 封装document对象
        DocumentV2 document = DocumentFactory.getInstance().createDownloader("html","www.baidu.com");

    }
}
