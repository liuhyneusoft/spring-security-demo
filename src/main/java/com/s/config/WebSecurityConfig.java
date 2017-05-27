package com.s.config;

/**
 * Created by liuhaiyang on 2017/5/25.
 */


import com.s.support.CustomUserDetailsService;
import com.s.support.LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
//@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http .authorizeRequests().antMatchers("/home", "/ctl/test").permitAll()//访问：/home 无需登录认证权限
                .antMatchers("/hello").hasAuthority("ADMIN") // 添加权限检测,登陆后之后拥有“ADMIN”权限才可以访问/hello方法，否则系统会出现“403”权限不足的提示
                .antMatchers("/ctl/xxx").hasRole("role_xxx") // 角色检测
                .antMatchers("/ctl/yyy").hasAnyAuthority("ADMIN", "NEUSOFT") // 权限检测
                .antMatchers("/url/**").hasAnyAuthority("ADMIN", "NEUSOFT") // 权限检测
                .anyRequest().authenticated() //其他所有资源登陆后都可以访问，无关角色、权限.
                .and()
                .formLogin()
                .loginPage("/login")  // 登录页的control”/login”
                .permitAll()
                .successHandler(loginSuccessHandler()) //登录成功后可使用loginSuccessHandler()存储用户信息，可选。
                .and()
                .logout()
                .logoutSuccessUrl("/home") //退出登录后的默认网址是”/home”
                .permitAll()
                .invalidateHttpSession(true)
                .and()
                .rememberMe()//登录后记住用户，下次自动登录,数据库中必须存在名为persistent_logins的表
                .tokenValiditySeconds(1209600);
    }

    /**
     * 指定密码加密所使用的加密器为passwordEncoder()
       需要将密码加密后写入数据库
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
        auth.eraseCredentials(false); //不删除凭据，以便记住用户
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(4);
    }

    @Bean
    public LoginSuccessHandler loginSuccessHandler() {
        return new LoginSuccessHandler();
    }

    /**
     *   用来启用注解方式的权限验证，参照  HelloController的anno方法。
     */
    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
