//package com.lojzes.oauth.client.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.oauth2.client.registration.ClientRegistration;
//import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
//import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
//import org.springframework.security.oauth2.core.AuthorizationGrantType;
//import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
//import org.springframework.security.oauth2.core.oidc.IdTokenClaimNames;
//
//@Configuration
//public class OAuth2LoginConfig {
//
//  @EnableWebSecurity
//  public static class OAuth2LoginSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//      http.authorizeRequests().anyRequest().authenticated().and().oauth2Login();
//    }
//  }
//
//  @Bean
//  public ClientRegistrationRepository clientRegistrationRepository() {
//    return new InMemoryClientRegistrationRepository(this.gitHubClientRegistration());
//  }
//
//  private ClientRegistration gitHubClientRegistration() {
//    return ClientRegistration.withRegistrationId("github")
//        .clientId("e0f8275c33d525ef8a3d")
//        .clientSecret("da37800a28cfc9fe755c35f7155d4f3350ff0aff")
//        .clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
//        .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//        .redirectUriTemplate("{baseUrl}/login/oauth2/code/{registrationId}")
//        .scope("openid", "profile", "email", "address", "phone")
//        .authorizationUri("https://github.com/login/oauth/authorize")
//        .tokenUri("https://github.com/login/oauth/access_token")
//        .userInfoUri("https://api.github.com/user")
//        .userNameAttributeName(IdTokenClaimNames.SUB)
//        .clientName("github")
//        .build();
//  }
//}
