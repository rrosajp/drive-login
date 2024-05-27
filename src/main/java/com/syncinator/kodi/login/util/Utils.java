package com.syncinator.kodi.login.util;

import jakarta.servlet.http.HttpServletRequest;

import java.util.stream.Stream;

public class Utils {
	public static String getRemoteAddress(final HttpServletRequest request) {
		String remote = request.getHeader("x-forwarded-for");
		if (remote == null) {
			remote = request.getRemoteAddr();
		}
		return remote;
	}
	public static String getSourceId(final HttpServletRequest request) {
		final String ip = getRemoteAddress(request);
		try {
			return String.valueOf(Stream.of(ip.contains(".")?ip.split("\\."):ip.split(":"))
					.mapToInt(Integer::parseInt).sum());
		} catch(Exception e) {
			return "-1";
		}
	}
	
}
