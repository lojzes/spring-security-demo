package com.lojzes.demo1.userdetail;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 描述：TODO
 *
 * @author lyyitit@foxmail.com
 * @date 2019/10/22 20:15
 */
public interface SysDetailsService extends UserDetailsService {
    /**
     * 备注: 通过手机号码查询用户
     * @Date 2019-10-22 20:16
     * @param mobile
     * @return org.springframework.security.core.userdetails.UserDetails
    */
    UserDetails loadUserByMobile(String mobile) throws UsernameNotFoundException;
}
