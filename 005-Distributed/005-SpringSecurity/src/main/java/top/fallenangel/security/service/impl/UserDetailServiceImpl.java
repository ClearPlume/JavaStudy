package top.fallenangel.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.fallenangel.security.model.entity.User;
import top.fallenangel.security.service.IUserService;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User dbUser = userService.get(username);

        if (dbUser == null) {

            throw new UsernameNotFoundException("用户不存在！");
        }

        return new org.springframework.security.core.userdetails.User(username, dbUser.getUserPwd(), AuthorityUtils.commaSeparatedStringToAuthorityList("/auth/auth/list,ROLE_admin"));
    }
}
