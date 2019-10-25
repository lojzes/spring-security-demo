//package com.lojzes.oauth.client.config;
//
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@EnableWebSecurity
//public class OAuth2ClientSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .oauth2Client()
//                .clientRegistrationRepository(this.clientRegistrationRepository())
//                .authorizedClientRepository(this.authorizedClientRepository())
//                .authorizedClientService(this.authorizedClientService())
//                .authorizationCodeGrant()
//                    .authorizationRequestRepository(this.authorizationRequestRepository())
//                    .authorizationRequestResolver(this.authorizationRequestResolver())
//                    .accessTokenResponseClient(this.accessTokenResponseClient());
//    }
//}
//
