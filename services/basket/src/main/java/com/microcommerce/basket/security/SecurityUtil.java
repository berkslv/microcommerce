package com.microcommerce.basket.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

import static com.microcommerce.basket.security.SecurityConstants.CUSTOMER;
import static com.microcommerce.basket.security.SecurityConstants.MANAGER;

@Component
public class SecurityUtil {


    public String getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    public Boolean isManager() {
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        return authorities.stream().anyMatch(predicate -> Objects.equals(predicate.getAuthority(), MANAGER));
    }

    public Boolean isCustomer() {
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)    SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        return authorities.stream().anyMatch(predicate -> Objects.equals(predicate.getAuthority(), CUSTOMER));
    }

}
