package com.w77996.user.service;


import com.w77996.user.dataobject.UserInfo;

public interface UserService {

    /**
     * 根据 openid 查询用户信息
     * @param openid
     * @return
     */
    UserInfo findByOpenid(String openid);

}
