package com.verynavi.jwt;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @author geekerstar
 * @date 2018/12/4
 * description
 */
public class CreateJwt {
    public static void main(String[] args) {
        JwtBuilder jwtBuilder = Jwts.builder()
                .setId("66")
                .setSubject("哈哈")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "geekerstar")
                .setExpiration(new Date(new Date().getTime() + 60000))
                .claim("role", "admin");
        System.out.println(jwtBuilder.compact());

    }
}
