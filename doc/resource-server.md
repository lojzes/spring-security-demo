   
    resource server 认证流程
   
     ResourceServerSecurityConfigurer
        OAuth2AuthenticationProcessingFilter
         PreAuthenticatedAuthenticationToken authentication 
         OAuth2AuthenticationManager.authenticate(Authentication authentication)
     
              RemoteTokenServices
               loadAuthentication（accessToken）
     
             CheckTokenEndpoint  /oauth/check_token
            checkToken（）
              ResourceServerTokenServices[DefaultTokenServices]
                  loadAuthentication(tokenValue)
                RedisTokenStore.readAccessToken(tokenValue) access:tokenValue
                RedisTokenStore.readAuthentication(tokenValue)  auth:tokenValue
     
             OAuth2Authentication authentication