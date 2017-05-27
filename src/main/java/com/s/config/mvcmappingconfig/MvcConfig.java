package com.s.config.mvcmappingconfig;

/**
 * Created by liuhaiyang on 2017/5/25.
 */
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    /**  可以写一个@Controller+@RequestMapping效果是一样的。
     *  registry.addViewController("/ctl/xxx").setViewName("/t/xxx");
     *  /ctl/xxx 对应一个requestMapping
     *  /t/xxx  对应一个html资源
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

}
