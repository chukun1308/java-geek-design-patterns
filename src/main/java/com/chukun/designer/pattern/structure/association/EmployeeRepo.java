package com.chukun.designer.pattern.structure.association;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chukun
 *  员工数据库访问
 */
public class EmployeeRepo {

    /**
     * 获取部门下的员工编号
     * @param deptId
     * @return
     */
    public List<Long> getDepartmentEmployeeIds(long deptId){
        return new ArrayList<>();
    }

    /**
     * 获取员工的薪水
     * @param empId
     * @return
     */
    public double getEmployeeSalary(long empId) {
        return 0d;
    }
}
