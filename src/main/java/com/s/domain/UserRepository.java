package com.s.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by liuhaiyang on 2017/5/25.
 */

public interface UserRepository extends JpaRepository<SysUser, Integer> {
    public List<SysUser> findByNameLike(String name);
}
