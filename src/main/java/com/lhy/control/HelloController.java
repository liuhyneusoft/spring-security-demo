package com.lhy.control;

import com.s.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;

/**
 * Created by liuhaiyang on 2017/5/25.
 */
@Controller
@RequestMapping("/ctl")
public class HelloController {

    @Autowired
    private  UserService userService;

    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @RequestMapping("/test")
    public String dddd( @RequestParam(value ="param1") String acc_nbr ) {
        return "index";
    }

    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("host", "xxxxxx");

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "index";
    }



    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseBody
    @RequestMapping(value = "/anntest",method = RequestMethod.GET)
    public String anno() {
        return "annotation test";
    }

    @PreAuthorize("@userService.check()")  //这里支持 spring EL表达式，不熟悉不知道如何给check方法传参数。如果check返回false那么就403错误
    @ResponseBody
    @RequestMapping(value = "/anntest22/{xx}",method = RequestMethod.GET)
    public String anno2(@PathVariable("xx") String str) {
        return "annotation test="+str;
    }


    @ResponseBody
    @RequestMapping(value = "/anntest33/{xx}",method = RequestMethod.GET)
    public String anno3(@PathVariable("xx") String str) {
        userService.checksEL(str);
        return "annotation test="+str;
    }

    @PermitAll
    @ResponseBody
    @RequestMapping(value = "/anntest11",method = RequestMethod.GET)
    public String annox(){
        return "anno1";
    }

}
