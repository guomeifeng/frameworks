package test.org.example.service.impl;

import org.springframework.security.core.GrantedAuthority;

/*
 * Created by kelly on 14/10/2020.
 */
public class GrantedAuthorityImpl implements GrantedAuthority {
    @Override
    public String getAuthority() {
        return "ROLE_INVALID";
    }
}
