package za.co.protogen.controller;

import org.springframework.security.oauth2.core.OAuth2AccessToken;

public class TokenStore {
    private TokenStore tokenStore;
    public OAuth2AccessToken readAccessToken(String refreshToken) {
            OAuth2AccessToken accessToken = tokenStore.readAccessToken(refreshToken);

            return accessToken;
    }

    public DefaultOAuth2AccessToken createAccessToken(Object authentication) {
            DefaultOAuth2AccessToken accessToken = new DefaultOAuth2AccessToken("your-access-token-value");
            
            accessToken.setTokenType("bearer");
//            accessToken.setExpiration

             
                    tokenStore.storeAccessToken(accessToken, authentication);

            return accessToken;
        }

    private void storeAccessToken(DefaultOAuth2AccessToken accessToken, Object authentication) {
    }

    public <OAuth2Authentication> OAuth2Authentication readAuthentication(String refreshToken) {
            OAuth2Authentication authentication = tokenStore.readAuthentication(refreshToken);

            return authentication;
    }
}
  

