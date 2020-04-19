package com.chukun.designer.pattern.structure.adapter.replace;

/**
 * @author chukun
 *  A系统的调用实例
 */
public class ADemoRunner {

    private IASystem iaSystem;

    public ADemoRunner(IASystem iaSystem) {
        this.iaSystem = iaSystem;
    }

    public static void main(String[] args) {
        ADemoRunner runner = new ADemoRunner(new ASystem());
    }
}
