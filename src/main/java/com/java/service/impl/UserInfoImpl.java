package com.java.service.impl;

import com.java.domain.UserInfo;
import com.java.service.IUserInfoService;
import com.java.utils.CookieUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/8/17.
 */
@Service
public class UserInfoImpl implements IUserInfoService{

    public void insertUserInfo(UserInfo userInfo) {

    }

    public List<UserInfo> findByCookie(String cookie) {
        return null;
    }

    public void updateETime(Date eTime, String time, Long id) {

    }

    public void recordETimeInfo(HttpServletRequest request,String cookieName) {
        //以当前时间为页面关闭时间
        Date eTime=new Date();
        String cookie= CookieUtils.getCookie(request,cookieName);
    }
}
