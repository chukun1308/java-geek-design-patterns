package com.chukun.designer.pattern.structure.adapter.defect;

/**
 * @author chukun
 * 依赖的外部系统在接口设计方面有缺陷（比如包含大量静态方法），引入之后会影响到自身代码的可测试性。
 * 为了隔离设计上的缺陷，希望对外部系统提供的接口进行二次封装，抽象出更好的接口设计，这个时候就可以使用适配器模式了
 *
 *  封装有缺陷的接口设计
 */
public class InterfaceDefect extends CD implements ITarget {

    @Override
    public void funct01() {
        staticFunc01();
    }

    @Override
    public void funct02(ParamsWrapperDefinition paramsWrapperDefinition) {
        super.toManyParamsFunction(paramsWrapperDefinition.getParam01(),
                paramsWrapperDefinition.getParam02(), paramsWrapperDefinition.getArgs());
    }
}

