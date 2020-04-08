package com.chukun.designer.pattern.proxy;

import com.chukun.designer.mvcddd.mvc.UserVo;
import com.chukun.designer.pattern.proxy.v2.IUserController;

public class UserController implements IUserController {


    @Override
    public UserVo login(String telephone, String password) {
        return new UserVo();
    }

    @Override
    public UserVo register(String telephone, String password) {
        return new UserVo();
    }
}
