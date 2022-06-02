package com.alaswad.userservice.service;

import com.alaswad.userservice.domain.AppUser;
import com.alaswad.userservice.domain.Role;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    AppUser saveUser(AppUser user);
    Role saveRole(Role role);
    void addRoleToUser(String username,String roleName);
    AppUser getUser(String username);
    List<AppUser> getUsers(); //TODO: replace with a page instead of a list of all Users
}
