package com.chukun.designer.pattern.association;

import java.util.ArrayList;
import java.util.List;

public class Department extends HumanResource {

    private List<HumanResource> subEmployees = new ArrayList<>();

    public Department(long id) {
        super(id);
    }

    @Override
    public double calculateSalary() {
        double totalSalary = 0d;
        for (HumanResource subEmployee : subEmployees) {
            totalSalary +=subEmployee.calculateSalary();
        }
        this.salary = totalSalary;
        return salary;
    }

    public void addSubNode(HumanResource hr) {
        subEmployees.add(hr);
    }

}
