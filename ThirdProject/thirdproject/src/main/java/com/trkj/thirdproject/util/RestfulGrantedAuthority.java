package com.trkj.thirdproject.util;

import org.springframework.security.core.GrantedAuthority;

/***
 * @author 大熊
 * @date 2020-07-03
 * @Description:自定义处理restful风格的权限描述类
 * @version 1.0
 */
public class RestfulGrantedAuthority implements GrantedAuthority {
    //权限url
    private String permissionUrl;
    //允许访问的权限的请求方法(get,post,delete,put,all,其中all表示所有请求或是允许某个模块下所有权限)
    private String method;

    public String getPermissionUrl() {
        return permissionUrl;
    }

    public void setPermissionUrl(String permissionUrl) {
        this.permissionUrl = permissionUrl;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * 该方法重写GrantedAuthority接口中的getAuthority方法，
     * 主要就是用于描述权限的字符串
     * @return
     */
    @Override
    public String getAuthority() {
        return this.permissionUrl + ";" + this.method;
    }

    /**
     * 必须需要定义一个空的构造函数，否则无法正常redis中反序列化对象
     */
    public RestfulGrantedAuthority() {
    }
    public RestfulGrantedAuthority(String authority) {
        String []s=authority.split(";");
        this.permissionUrl=s[0];
        this.method=s[1];
    }
    public RestfulGrantedAuthority(String permissionUrl, String method) {
        this.permissionUrl = permissionUrl;
        this.method = method;
    }


}
