package com.w77996.user.service.impl;

import com.w77996.user.dataobject.UserInfo;
import com.w77996.user.repository.UserInfoRepository;
import com.w77996.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    public UserInfo findByOpenid(String openid) {
        return userInfoRepository.findByOpenid(openid);
    }
}
