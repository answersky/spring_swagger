package com.java.controller;

import io.swagger.annotations.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author answer
 *         2018/4/12
 */
@Controller
@Api(tags = "一：用户登录") //swagger分类标题注解
public class LoginController {

    @RequestMapping("/login")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "0 成功,其它为错误,返回格式：{code:0,data[{}]},data中的属性参照下方Model") })
    @ApiOperation(httpMethod = "POST", value = "登录接口")//swagger 当前接口注解
    public String login(Model model, @ApiParam(required = true, name = "username", value = "用户名") String username,
                        @ApiParam(required = true, name = "password", value = "密码") String password){
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // shiro登陆验证
        try {
            SecurityUtils.getSubject().login(token);
        } catch (UnknownAccountException ex) {
            model.addAttribute("message","用户不存在");
            return "fail";
        } catch (IncorrectCredentialsException ex) {
            model.addAttribute("message","密码错误");
            return "fail";
        } catch (AuthenticationException ex) {
            model.addAttribute("message","系统异常");
            ex.printStackTrace();
            return "fail";// 自定义报错信息
        } catch (Exception ex) {
            ex.printStackTrace();
            return "fail";
        }
        model.addAttribute("message","登陆成功");
        return "success";
    }
}
