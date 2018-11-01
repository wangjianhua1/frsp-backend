package com.frsp.intercepter;

import com.alibaba.fastjson.JSON;
import com.frsp.utils.IPAddressUtils;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestDispatchServlet extends DispatcherServlet {

    @Override
    protected void doDispatch(HttpServletRequest request, HttpServletResponse response) {
        StringBuffer sb = new StringBuffer();
        long start = System.currentTimeMillis();
        try {

            String ipAddress = IPAddressUtils.getClientIPAddress(request);
            String requestURI = request.getRequestURI();//只有GET请求才能被捕获到

            sb.append("Method[").append(requestURI).append("]IP[").append(ipAddress).append("]");
            response.setHeader("Access-Control-Allow-Origin", request.getHeader("origin"));
            response.setHeader("Access-Control-Allow-Methods", "GET,POST");//请求放行
            response.setHeader("Access-Control-Allow-Credentials", "true");
            super.doDispatch(request, response);
        } catch (Exception e) {
            logger.error("=doDispatch=error", e);
        } finally {
            long end = System.currentTimeMillis();
            sb.append("time=").append(end - start);
            Object returnVal = ResponseAdvice.JSON_RESPONSE.get();
            ResponseAdvice.JSON_RESPONSE.remove();
            sb.append("ms=resp[").append(JSON.toJSONString(returnVal)).append("]");
            logger.info(sb.toString());

        }
    }

}
