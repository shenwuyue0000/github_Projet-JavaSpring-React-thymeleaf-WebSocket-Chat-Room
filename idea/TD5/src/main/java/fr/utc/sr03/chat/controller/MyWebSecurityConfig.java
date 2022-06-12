package fr.utc.sr03.chat.controller;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 注入一个自定义的配置
 */
@EnableWebSecurity
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {
    //配置安全拦截策略
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","/login", "admin/**", "utilisateur/**").permitAll()
                .antMatchers("/js/**","/css/**").authenticated();

        /*
        http.formLogin()
                //当发现login时认为是登录需要执行我们自定义的登录逻辑 >里面的url是登录页面表单的提交地址
                .loginProcessingUrl("/login")
                //登录成功后请求地址 请求方法必须是post的 这里是跳转控制器
                //.successForwardUrl("/login")
                //登录失败后请求访问的地址 >这里访问的是控制器
                //.failureForwardUrl("/failLogin")
                //设置登录页面
                .loginPage("/login")
                .usernameParameter("mail")
                .passwordParameter("password")
        ;

        http.authorizeRequests()
                //设置不需要拦截的页面
                .antMatchers("/login.html").permitAll()
                //.antMatchers("/fail.html").permitAll()
                //所有请求都必须被认真,必须登录后才能访问
                .anyRequest().authenticated();

        http.csrf().disable();



         */


    }
}

