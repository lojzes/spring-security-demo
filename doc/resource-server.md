   
   
    login username password 登录：
 
          TokenEndpoint
	        ResourceOwnerPasswordTokenGranter
		                   UsernamePasswordAuthenticationToken
	        DaoAuthenticationProvider.authenticate
		   PigxUserDetailsService.loadUserByUsername
  

    token 访问接口

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
             
             
             //配置属性
             ResourceServerTokenServicesConfiguration