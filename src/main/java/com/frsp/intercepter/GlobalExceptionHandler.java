package com.frsp.intercepter;


import com.alibaba.fastjson.JSON;
import com.frsp.common.error.FrspException;
import com.frsp.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 全局异常处理类
 */
@Slf4j
@Order(-1000)
public class GlobalExceptionHandler implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ResultVO result = new ResultVO();
        result.setStatus(0);
        result.setData(null);
        //处理异常
        if(ex instanceof FrspException) {
            result.setErrcode(1);
            result.setMsg("系统错误：" + ex.getMessage());
        } else if (ex instanceof ClassCastException) {
            result.setErrcode(2);
            result.setMsg("参数类型错误：" + ex.getMessage());
        } else if (ex instanceof AuthorizationException) {
            result.setErrcode(3);
            result.setMsg("认证错误：" + ex.getMessage());
        }else if (ex instanceof HttpMessageConversionException) {
            result.setErrcode(2);
            result.setMsg("参数缺失：" + ex.getMessage());
        }else if (ex instanceof HttpRequestMethodNotSupportedException) {
            result.setErrcode(4);
            result.setMsg("请求方式错误：" + ex.getMessage());
        } else {
            result.setErrcode(1);
            result.setMsg("系统错误：" + ex.getMessage());
        }

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Cache-Control", "no-cache, must-revalidate");
        try {
            response.getWriter().write(JSON.toJSONString(result));
        } catch (IOException e) {
            log.error("与客户端通讯异常：" + e.getMessage(), e);
        }
        log.error("异常：" + ex.getMessage(), ex);
        return new ModelAndView();
    }

}
