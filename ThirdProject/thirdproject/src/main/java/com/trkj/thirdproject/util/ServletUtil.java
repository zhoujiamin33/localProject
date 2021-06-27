package com.trkj.thirdproject.util;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * JSON返回结果工具类
**/
@Slf4j
public class ServletUtil {

    /**
     * 私有化构造器
     */
    private ServletUtil(){}

    /**
     * 使用response向前端输出JSON
    **/
    public static void responseJson(HttpServletResponse response, String data){
        try
        {
            response.setStatus(200);
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(data);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

   /* *//**
     * 返回成功示例
     * @author zwq
     * @date 2020/4/4
     * @param resultMap
     * @return
     **//*
    public static Map<String, Object> resultSuccess(Map<String, Object> resultMap){
       // ObjectMapper objectMapper = new ObjectMapper();
        resultMap.put("message","操作成功");
        resultMap.put("code", 200);
        return resultMap;
    }

    *//**
     * 返回失败示例
     * @author zwq
     * @date 2020/4/4
     * @param resultMap
     * @return
     **//*
    public static Map<String, Object> resultError(Map<String, Object> resultMap){
        resultMap.put("message","操作失败");
        resultMap.put("code",500);
        return resultMap;
    }

    *//**
     * 通用示例
     * @author zwq
     * @date 2020/4/4
     * @param code
     * @param msg
     * @return
     **//*
    public static Map<String, Object> resultCode(Integer code,String msg){
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("message",msg);
        resultMap.put("code",code);
        return resultMap;
    }
*/
}