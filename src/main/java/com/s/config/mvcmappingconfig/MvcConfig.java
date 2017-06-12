package com.s.config.mvcmappingconfig;

/**
 * Created by liuhaiyang on 2017/5/25.
 */

import com.s.config.interceptor.ControlMethodInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    /**  可以写一个@Controller+@RequestMapping效果是一样的。
     *  registry.addViewController("/ctl/xxx").setViewName("/t/xxx");
     *  /ctl/xxx 类似一个requestMapping ，这里可以再controll中没有对应的url
     *  /t/xxx  对应一个html资源
     *  只是想通过一个URL Mapping然后不经过Controller处理直接跳转到页面上的需求
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("loginPage");
        registry.addViewController("/ctl/xxx").setViewName("/t/xxx");
        registry.addViewController("/ctl/yyy").setViewName("/t/yyy");
    }

    /**
     * 添加一个拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor(new ControlMethodInterceptor());

        // Exclusion path  不拦截的url
        addInterceptor.excludePathPatterns("/");
        addInterceptor.excludePathPatterns("/testangular1");
        addInterceptor.excludePathPatterns("/toLogin");
        addInterceptor.excludePathPatterns("/sessionExpried");

        // Inclusion path
        addInterceptor.addPathPatterns("/**");
    }

}
