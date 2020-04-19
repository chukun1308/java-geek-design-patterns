package com.chukun.designer.pattern.structure.adapter.replace;

/**
 * @author chukun
 *  B 系统的调用实例
 *
 *  当把项目中依赖的一个外部系统替换为另一个外部系统的时候，利用适配器模式，可以减少对代码的改动
 */
public class BDemoRunner {

    private IASystem iaSystem;

    public BDemoRunner(IASystem iaSystem) {
        this.iaSystem = iaSystem;
    }

    public static void main(String[] args) {
        // 借助BAdaptor，Demo的代码中，调用IA接口的地方都无需改动，只需要将BDemoRunner如下注入到Demo即可。
        BDemoRunner runner = new BDemoRunner(new BSystemAdapter(new BSystem()));
    }
}
