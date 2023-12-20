package com.waper.auth.filter;


import com.auth0.jwt.interfaces.Claim;
import com.waper.auth.uitl.JWTUtil;
import com.waper.common.util.TokenUitil;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

/**
 * @author wangpeng
 * @ClassName JwtFilter
 * @description TODO
 * @date 2023/12/20 11:42
 */

public class JwtFilter implements Filter {


    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest )req;
        HttpServletResponse response = (HttpServletResponse )resp;

        response.setCharacterEncoding("UTF-8");
        String token = request.getHeader("token");

        if (StringUtils.isEmpty(token)) {
            response.getWriter().write("no token");
        }

        Map<String, Claim> stringClaimMap = TokenUitil.verifyToken(token);
        if (stringClaimMap == null) {
            response.getWriter().write("token illegal");

        }

    }
}
