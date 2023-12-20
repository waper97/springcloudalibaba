package com.waper.common.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.waper.common.entity.User;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Map;

/**
 * token工具列
 * @author wangpeng
 * @ClassName TokenUitil
 * @description TODO
 * @date 2023/12/20 11:21
 */
@Slf4j
public class TokenUitil {
    private static final String SECRET = "jwtSECRET"; // 密钥

    private static final long EXPIRATION = 3600L; // 3600 秒

    /**
     * 创建token
     * @param user
     * @return
     */
    public static String createToken (User user) {
        Date expireDate = new Date(System.currentTimeMillis() + EXPIRATION * 1000);
        return JWT.create()
                .withClaim("id", user.getId())
                .withClaim("account", user.getAccount())
                .withClaim("password", user.getPassword())
                .withExpiresAt(expireDate)
                .withIssuedAt(new Date())
                .sign(Algorithm.HMAC256(SECRET));
    }


    // 校验 token
    public static Map<String, Claim> verifyToken(String token) {
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            jwt = verifier.verify(token);
        } catch (Exception e) {
            return null;
        }
        return jwt.getClaims();
    }

    public static void main(String[] args) {

        String token = createToken(User.builder().id("1").account("waper97").password("123456").build());
        Map<String, Claim> stringClaimMap = verifyToken(token);
        log.info("token: " + token);
        log.info("verifyToken: " + stringClaimMap);
    }


}
