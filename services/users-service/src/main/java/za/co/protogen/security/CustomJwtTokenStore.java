package za.co.protogen.security;

public class CustomJwtTokenStore extends JwtTokenStore {
    public <JwtAccessTokenConverter> CustomJwtTokenStore(JwtAccessTokenConverter jwtAccessTokenConverter) {
        super(jwtAccessTokenConverter);
    }
}
