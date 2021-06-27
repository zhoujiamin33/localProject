package com.trkj.thirdproject.util;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/***
 * @author 大熊
 * @date 2020-07-03
 * @Description:JWT工具类。
 * @version 1.0
 */
@Slf4j
@Data
@ConfigurationProperties(prefix = "jwt")
@Component
public class JwtTokenUtil {

    private String secret;
    private Long expire;
    private String header;


    /**
     * 生成token令牌
     *
     * @param userName 用户
     * @return 令token牌
     */
    public String generateToken(String userName,String userId) {
        Map<String, Object> claims = new HashMap<>(2);
        claims.put("sub", "jwtdemo");
        claims.put("uname",userName);
        claims.put("uid",userId);

        Date iatDate=new Date();
        claims.put("iat", iatDate);
        return generateToken(claims);
    }

    /**
     * 从令牌中获取用户名
     *
     * @param token 令牌
     * @return 用户名
     */
    public String getUsernameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.get("uname").toString();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }
    /**
     * 从令牌中获取用户ID
     *
     * @param token 令牌
     * @return 用户编号
     */
    public String getUserIdFromToken(String token) {
        String userId;
        try {
            Claims claims = getClaimsFromToken(token);
            userId = claims.get("uid").toString();
        } catch (Exception e) {
            userId = null;
        }
        return userId;
    }

    /**
     * 判断令牌是否过期
     *
     * @param token 令牌
     * @return 是否过期
     */
    public Boolean isTokenExpired(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            Date expiration = claims.getExpiration();
            log.info("in isTokenExpired date:{}",expiration.toLocaleString());
            Date date=new Date();
            log.info("in isTokenExpired now:{},exp:{} ,{}",date.toLocaleString(),expiration.toLocaleString(),expiration.before(date));
            return expiration.before(date);
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    /**
     * 得到token的过期时间，测试用
     * @param token
     * @return
     */
    public Date  expirationDate(String token){
        Claims claims = getClaimsFromToken(token);
        Date expiration = claims.getExpiration();
        return expiration;
    }

    /**
     * 刷新令牌
     * @param token 原令牌
     * @return 新令牌
     */
    public String refreshToken(String token) {
        String refreshedToken;
        try {
            Claims claims = getClaimsFromToken(token);
            Date iatDate=new Date();
            claims.put("iat", iatDate);
            refreshedToken = generateToken(claims);
        } catch (Exception e) {
            e.printStackTrace();
            refreshedToken = null;
        }
        return refreshedToken;
    }

    /**
     * 验证令牌
     *
     * @param token       令牌
     * @param userName 用户
     * @return 是否有效
     */
    public Boolean validateToken(String token, String userName) {

        String uname = getUsernameFromToken(token);
        return (uname.equals(userName) && !isTokenExpired(token));
    }


    /**
     * 从claims生成令牌
     * @param claims 数据声明
     * @return 令牌
     */
    private String generateToken(Map<String, Object> claims) {
        Date expirationDate = new Date(System.currentTimeMillis() + expire);
        /**
         * signWith() 签名方法。两个参数分别是签名算法和自定义的签名Key（盐）。
         * 签名key可以byte[] 、String及Key的形式传入。
         * 前两种形式均存入builder的keyBytes属性，后一种形式存入builder的key属性。
         * 如果是第二种（及String类型）的key，则将其进行base64解码获得byte[] 。
         * compact() 生成JWT
         */

        Date iatDate= (Date) claims.get("iat");
        log.debug("创建时间:{},过期时间:{}",iatDate.toLocaleString(),expirationDate.toLocaleString());
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setClaims(claims)
                //.setId("")
                .setExpiration(expirationDate)
                //.setIssuedAt((Date)claims.get("created"))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 从令牌中获取数据声明
     *
     * @param token 令牌
     * @return 数据声明
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

}
