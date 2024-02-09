package za.co.protogen.security;

public class AuthorizationServerEndpointsConfigurer {
    public OAuth2AuthorizationServerConfig tokenStore(JwtTokenStore jwtTokenStore) {

        return new OAuth2AuthorizationServerConfig();}

    private JwtTokenStore customJwtTokenStore() {
        return new CustomJwtTokenStore();
    }
}
