package com.chukun.designer.pattern.association;

public abstract class HumanResource {

    protected long id;
    protected double salary;

    public HumanResource(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    /**
     * 计算薪水
     * @return
     */
    public abstract double calculateSalary();
}
