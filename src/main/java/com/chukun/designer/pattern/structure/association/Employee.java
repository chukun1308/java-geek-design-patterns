package com.chukun.designer.pattern.structure.association;

/**
 * @author chukun
 *  计算员工的薪水
 */
public class Employee extends HumanResource {

    public Employee(long id,double salary) {
        super(id);
        this.salary = salary;
    }
    @Override
    public double calculateSalary() {
        return salary;
    }
}
