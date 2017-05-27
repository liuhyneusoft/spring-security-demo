package com.s.jwtpkg;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by liuhaiyang on 2017/5/25.
 */
public class GrantedAuthorityImpl implements GrantedAuthority {
    private String authority;

    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
