package za.co.protogen.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public abstract class OAuth2AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter implements OAuth2AuthorizationServerConfigInt {

    @Bean
    public JwtTokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public <JwtAccessTokenConverter> JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("your-signing-key");
        return converter;
    }

    @Bean
    public <TokenEnhancer> TokenEnhancer tokenEnhancer() {
        return new YourCustomTokenEnhancer();
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .tokenStore(tokenStore())
                .accessTokenConverter(accessTokenConverter())
                .tokenEnhancer(tokenEnhancer());
    }

    @Override
    public <AuthorizationServerEndpointsConfigurer> void configure(za.co.protogen.security.AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

    }
    private OAuth2AuthorizationServerConfig accessTokenConverter(Object accessTokenConverter) {
        return null;
    }
}



