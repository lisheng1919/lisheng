package com.admin.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author lisheng
 * @version RequestUtil, v0.1 2018/8/30 10:59
 */
public class RequestUtil {

	/**
	 * 获取请求basePath
	 * 
	 * @param request
	 * @return
	 */
	public static String getBasePath(HttpServletRequest request) {
		StringBuffer basePath = new StringBuffer();
		String scheme = request.getScheme();
		String domain = request.getServerName();
		int port = request.getServerPort();
		basePath.append(scheme);
		basePath.append("://");
		basePath.append(domain);
		if ("http".equalsIgnoreCase(scheme) && 80 != port) {
			basePath.append(":").append(String.valueOf(port));
		} else if ("https".equalsIgnoreCase(scheme) && port != 443) {
			basePath.append(":").append(String.valueOf(port));
		}
		return basePath.toString();
	}

	/**
	 * 获取ip工具类，除了getRemoteAddr，其他ip均可伪造
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("Cdn-Src-Ip"); // 网宿cdn的真实ip
		if (ip == null || ip.length() == 0 || " unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP"); // 蓝讯cdn的真实ip
		}
		if (ip == null || ip.length() == 0 || " unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-Forwarded-For"); // 获取代理ip
		}
		if (ip == null || ip.length() == 0 || " unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP"); // 获取代理ip
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP"); // 获取代理ip
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr(); // 获取真实ip
		}
		return ip;
	}

	/**
	 * 获取post请求参数字符串
	 * 
	 * @param request
	 * @return
	 */
	public static String getPostMethodParameter(HttpServletRequest request) {
		Map<String, String[]> paramsMap = request.getParameterMap();
		// 返回一个包含请求消息中的所有参数名的Enumeration对象。通过遍历这个Enumeration对象，就可以获取请求消息中所有的参数名。
		if (!CollectionUtils.isEmpty(paramsMap)) {
			StringBuilder stringBuilder = new StringBuilder();
			for (Map.Entry<String, String[]> entry : paramsMap.entrySet()) {
				stringBuilder.append(entry.getKey()).append(": ").append(StringUtils.join(entry.getValue()))
						.append("; ");
			}
			return stringBuilder.toString();
		}
		return null;
	}
}
