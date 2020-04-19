package com.chukun.designer.pattern.structure.proxy.v2;

import com.chukun.designer.mvcddd.mvc.UserVo;

public class UserController02 implements IUserController {


    @Override
    public UserVo login(String telephone, String password) {
        //...返回UserVo数据...
        return new UserVo();
    }

    @Override
    public UserVo register(String telephone, String password) {
        // 省略注册的流程
        return new UserVo();
    }
}
