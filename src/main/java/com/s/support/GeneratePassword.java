package com.s.support;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by liuhaiyang on 2017/5/26.
 *
 * Bcrypt 加密
 */
public class GeneratePassword {

    public static String generatePw(String pw){
        //String pw = "neusoft";
        BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
        String hashPass = encode.encode(pw);
        System.out.println(hashPass);
        return hashPass;
    }

    public static void dePw(String rawPW,String encodedPassword){
        BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
        boolean b = encode.matches(rawPW,encodedPassword);
        System.out.println(b);
    }
    public  static void main(String a[]) {
        generatePw("neusoft");
        //dePw("neusoft","$2a$10$mvor6Gc21QENyewOEBNBnuE9TZNdtz8dK093/qJQyZCBzbPOP4Pym");
    }
}
