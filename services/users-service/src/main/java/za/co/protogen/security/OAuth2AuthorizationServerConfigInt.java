package za.co.protogen.security;

public interface OAuth2AuthorizationServerConfigInt {
    <AuthorizationServerEndpointsConfigurer> void configure(za.co.protogen.security.AuthorizationServerEndpointsConfigurer endpoints) throws Exception;

    <AuthorizationServerEndpointsConfigurer> void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception;
}
