package com.chukun.designer.principle.lod.simple;

import com.chukun.designer.principle.lod.HtmlRequest;

/**
 * @author chukun
 *  代码缺陷：
 *    send方法，依赖HtmlRequest，这样就会导致，只能发送html格式的request
 */
public class NetworkTransporterV1 {

    public byte[] send(HtmlRequest htmlRequest) {
        byte[] content = new byte[1024 * 2];
        return content;
    }

}
