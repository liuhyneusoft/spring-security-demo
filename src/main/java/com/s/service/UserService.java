package com.s.service;


import com.s.domain.SysUser;
import com.s.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liuhaiyang on 2017/5/25.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public SysUser findByName(String username){
        List<SysUser> sysUser = repository.findByNameLike(username);
        return sysUser.get(0);
    }

    public boolean check(){
        return true;
    }

    public boolean checks(String xx){
        System.out.println(xx);
        return false;
    }

    //@PreAuthorize("#xx.equals('abc')")
    public void checksEL(String xx){
        System.out.println(xx);
    }

}
