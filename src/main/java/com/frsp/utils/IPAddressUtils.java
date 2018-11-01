package com.frsp.utils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPAddressUtils {

    /**
     * 从发的request请求的头信息里获取客户端IP地址
     *
     * @param request
     * @return ip 客户端IP地址
     */

    public static String getClientIPAddress(HttpServletRequest request) {

        String ip = request.getHeader("x-forwarded-for");
        //在apache+WebLogic整合系统中,apache会对request对象进行再包装，附加一些WLS要用的头信息
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if (ip.equals("127.0.0.1")) {
                //根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ip = inet != null ? inet.getHostAddress() : null;
            }
        }

        /*
         * 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割 "***.***.***.***".length() = 15
         */
        if (ip != null && ip.length() > 15) {
            if (ip.indexOf(",") > 0) {
                ip = ip.substring(0, ip.indexOf(","));
            }
        }

        return ip;
    }

    /**
     * 获取本地机器IP地址
     *
     * @return 本地IP地址
     */
    public static String getLocalIPAddress() {

        InetAddress inet = null;

        try {
            inet = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return inet != null ? inet.getHostAddress() : null;
    }

    /**
     * IP包括IP段校验
     *
     * @param sourceIp
     * @param targetIp
     * @return
     */
    public static boolean validateIp(String sourceIp, String targetIp) {
        try {
            String[] sourceIps = sourceIp.split("\\.");
            String[] targetIps = targetIp.split("\\.");
            for (int i = 0; i < 2; i++) {
                if (!sourceIps[i].equals(targetIps[i])) {
                    return false;
                }
            }
            String[] ip_last = sourceIps[3].split("-");
            String targetIp_last = targetIps[3];
            if (ip_last.length == 2) {
                Integer ip_start = Integer.valueOf(ip_last[0]);
                Integer ip_end = Integer.valueOf(ip_last[1]);
                Integer int_targetIp_last = Integer.valueOf(targetIp_last);
                if (int_targetIp_last >= ip_start && int_targetIp_last <= ip_end) {
                    return true;
                }
            } else {
                if (ip_last[0].equals(targetIp_last)) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //测试使用
    public static void main(String[] args) {
        System.out.println(getLocalIPAddress());
        System.out.println(validateIp("127.0.0.1-123", "127.0.0.0"));
        System.out.println(validateIp("127.0.0.1-123", "127.0.0.1"));
        System.out.println(validateIp("127.0.0.1-123", "127.0.0.123"));
        System.out.println(validateIp("127.0.0.1-123", "127.0.0.34"));
        System.out.println(validateIp("127.0.2.1-123", "127.0.0.34"));
        System.out.println(validateIp("127.3.2.1-123", "127.0.0.34"));
        System.out.println(validateIp("15.3.2.1-123", "127.0.0.34"));
        System.out.println(validateIp("15.3.2.123", "127.0.0.34"));
    }

}