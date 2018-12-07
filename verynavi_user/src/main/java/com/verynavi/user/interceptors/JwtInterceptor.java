package com.verynavi.user.interceptors;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtil jwtUtil;

    /**
     * 放行， 当返回true的时候放行
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception 通过往请求域中存入参数，来实现权限的甄别
     *                   如果是普通用户存入：request.setAttribute("user_claims",claims)
     *                   如果是管理员用户存入：request.setAttribute("admin_claims",claims)
     *                   如果没有登录，就什么都不存
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws RuntimeException {
        System.out.println("经过了拦截器");
        //无论如何都放行，具体能不能操作还是在具体的操作中去判断
        //拦截器只是负责把请求头中包含token的令牌进行一个解析验证
        String header = request.getHeader("Authorization");

        if (header != null && !"".equals(header)) {
            //如果有包含Authorization头信息，就对其进行解析
            if (header.startsWith("Bearer ")) {
                //得到token
                String token = header.substring(7);
                //对令牌进行验证
                try {
                    Claims claims = jwtUtil.parseJWT(token);
                    String roles = (String) claims.get("roles");
                    if (roles != null && roles.equals("admin")) {
                        request.setAttribute("claim_admin", claims);
                    }
                    if (roles != null && roles.equals("user")) {
                        request.setAttribute("claim_user", claims);
                    }
                } catch (Exception e) {
                    throw new RuntimeException("令牌不正确！");
                }
            }
        }
        return true;
    }
}
