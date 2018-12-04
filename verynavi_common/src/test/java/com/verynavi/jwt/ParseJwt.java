package com.verynavi.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.text.SimpleDateFormat;


public class ParseJwt {
    public static void main(String[] args) {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2NiIsInN1YiI6IuWTiOWTiCIsImlhdCI6MTU0MzkyNTIyMiwiZXhwIjoxNTQzOTI1MjgyLCJyb2xlIjoiYWRtaW4ifQ.Xt_jtzt37CRP_6ygPwrYTJFb0sZoO4jF9RTXUErH7sc";
        final Claims claims = Jwts.parser()
                .setSigningKey("geekerstar")
                .parseClaimsJws(token)
                .getBody();
        System.out.println("用户id：" + claims.getId());
        System.out.println("用户名：" + claims.getSubject());
        System.out.println("登录时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getIssuedAt()));
        System.out.println("过期时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getExpiration()));
        System.out.println("登录时间：" + claims.get("role"));

    }
}
