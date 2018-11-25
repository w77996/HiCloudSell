package com.w77996.user.controller;

import com.w77996.user.constants.CookieConstant;
import com.w77996.user.constants.RedisConstant;
import com.w77996.user.dataobject.UserInfo;
import com.w77996.user.enums.ResultEnum;
import com.w77996.user.enums.RoleEnum;
import com.w77996.user.service.UserService;
import com.w77996.user.utils.CookieUtil;
import com.w77996.user.utils.ResultVOUtil;
import com.w77996.user.vo.ResultVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 买家登录
     * @param openid
     * @param response
     * @return
     */
    @RequestMapping("/buyer")
    public ResultVO buyer(@RequestParam("openid") String openid,
                          HttpServletResponse response){
        // 1. 判断 openid 和数据库里的数据进行是否匹配
        UserInfo userInfo = userService.findByOpenid(openid);
        if(userInfo == null){
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }
        // 2. 判断角色是否匹配
        if(RoleEnum.BUYER.getCode() != userInfo.getRole()){
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }
        // 3. cookie 里设置 openid = abc
        CookieUtil.set(response, CookieConstant.OPENID, openid, CookieConstant.expire);
        return ResultVOUtil.success();
    }

    /**
     * 卖家登录
     * @return
     */
    @RequestMapping("/seller")
    public ResultVO seller(@RequestParam("openid") String openid,
                           HttpServletResponse response,
                           HttpServletRequest request){

        // 判断是否已登录
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if(cookie != null &&
                !StringUtils.isEmpty(stringRedisTemplate.opsForValue().
                        get(String.format(RedisConstant.TOKEN_TEMPLATE, cookie.getValue())))){
            return ResultVOUtil.success();
        }

        // 1. 判断 openid 和数据库里的数据进行是否匹配
        UserInfo userInfo = userService.findByOpenid(openid);
        if(userInfo == null){
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }
        // 2. 判断角色是否匹配
        if(RoleEnum.SELLER.getCode() != userInfo.getRole()){
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }
        // 3. redis 设置 key=UUID, value = xyz ， xyz其实就是openid
        String token = UUID.randomUUID().toString().replaceAll("-" , "");
        Integer expire = CookieConstant.expire;
        stringRedisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_TEMPLATE, token),
                openid, expire, TimeUnit.SECONDS);
        // 4. cookie 里设置 token = UUID
        CookieUtil.set(response, CookieConstant.TOKEN, token, CookieConstant.expire);
        return ResultVOUtil.success();
    }
}
