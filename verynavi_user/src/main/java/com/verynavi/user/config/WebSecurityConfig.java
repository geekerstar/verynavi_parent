package com.verynavi.user.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 安全配置类
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * HttpSecurity就好比当初ssm中web.xml中的委派过滤器
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //authorizeRequests所有security全注释配置实现的开端，表示开始说明需要的权限
        //需要的权限分为两部分，第一部分是拦截的路径，第二部分访问该路径需要的权限
        //antMatchers表示拦截什么路径，permitAll任何权限都可以访问
        http.authorizeRequests()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable();
    }
}
