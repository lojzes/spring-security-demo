package com.lojzes.demo1.userdetail;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 描述：TODO
 *
 * @author lyyitit@foxmail.com
 * @date 2019/10/22 10:10
 */
@Service
public class SysUserDetailService implements SysDetailsService {
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

      if(!"user".equals(username)){
          throw new UsernameNotFoundException("用户不存在");
      }

    //    SimpleGrantedAuthority admin = new SimpleGrantedAuthority("ROLE_ADMIN");
    //    SimpleGrantedAuthority aba = new SimpleGrantedAuthority("ROLE_DBA");

    // User user = new User("user", "123", Arrays.asList(admin, aba));

    AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_DBA");

    User user =
        new User("user", "123", AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_DBA"));
    return user;
  }

    @Override
    public UserDetails loadUserByMobile(String mobile) throws UsernameNotFoundException {

        if(!"18920698288".equals(mobile)){
            throw new UsernameNotFoundException("用户不存在");
        }

        AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_DBA");

        User user =
                new User("18920698288", "", AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_DBA"));
        return user;
    }
}
