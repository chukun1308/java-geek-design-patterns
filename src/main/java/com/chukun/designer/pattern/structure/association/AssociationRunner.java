package com.chukun.designer.pattern.structure.association;

import java.util.List;

/**
 * @author chukun
 *  开发一个 OA 系统（办公自动化系统）。
 *  公司的组织结构包含部门和员工两种数据类型。
 *  其中，部门又可以包含子部门和员工,详见 organization.jpg
 *
 *  1.在内存中构建整个公司的人员架构图（部门、子部门、员工的隶属关系），
 *  并且提供接口计算出部门的薪资成本（隶属于这个部门的所有员工的薪资和）。
 *
 *  2. 部门包含子部门和员工，这是一种嵌套结构，可以表示成树这种数据结构。
 *  计算每个部门的薪资开支这样一个需求，也可以通过在树上的遍历算法来实现
 */
public class AssociationRunner {

    private static final long ORGANIZATION_ROOT_ID = 1001;
    private DepartmentRepo departmentRepo; // 依赖注入
    private EmployeeRepo employeeRepo; // 依赖注入

    public void buildOrganization() {
        Department rootDepartment = new Department(ORGANIZATION_ROOT_ID);
        buildOrganization(rootDepartment);
    }

    /**
     * 创建部门组织
     * @param department
     */
    private void buildOrganization(Department department) {
        // 获取该部门的子部门
        List<Long> subDepartmentIds = departmentRepo.getSubDepartmentIds(department.getId());
        for (Long subDepartmentId : subDepartmentIds) {
            Department subDepartment = new Department(subDepartmentId);
            department.addSubNode(subDepartment);
            buildOrganization(subDepartment);
        }
        // 获取该部门下的员工
        List<Long> employeeIds = employeeRepo.getDepartmentEmployeeIds(department.getId());
        for (Long employeeId : employeeIds) {
            double employeeSalary = employeeRepo.getEmployeeSalary(employeeId);
            Employee employee = new Employee(employeeId,employeeSalary);
            department.addSubNode(employee);
        }
    }

}
