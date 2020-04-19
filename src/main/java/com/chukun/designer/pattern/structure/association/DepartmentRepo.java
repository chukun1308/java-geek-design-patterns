package com.chukun.designer.pattern.structure.association;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chukun
 *  部门访问数据库类
 */
public class DepartmentRepo {

    /**
     * 获取子部门的编号
     * @param id
     * @return
     */
    public List<Long> getSubDepartmentIds(long id){
        return new ArrayList<>();
    }
}
