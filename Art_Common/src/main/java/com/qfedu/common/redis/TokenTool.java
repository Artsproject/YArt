package com.qfedu.common.redis;

import com.qfedu.common.util.CookieUtil;

import javax.servlet.http.HttpServletRequest;

public class TokenTool {
    public static String getToken(HttpServletRequest request){
        String token = CookieUtil.getCk(request, "token");
        if (token==null||token.length()<1){
            String t = (String) request.getAttribute("token");
            if (t==null||t.length()<1){
                return null;
            }else{
                return t;
            }
        }
        return token;
    }
}
