package com.chukun.designer.pattern.proxy.v2;

import com.chukun.designer.mvcddd.mvc.UserVo;

public interface IUserController {

    UserVo login(String telephone, String password);

    UserVo register(String telephone, String password);
}
