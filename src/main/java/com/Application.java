package com;

import com.s.Appctx;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by liuhaiyang on 2017/5/25.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication app=new SpringApplication(Application.class);
        Appctx.ctx=app.run(args);
    }

}
