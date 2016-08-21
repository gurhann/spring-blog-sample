package com.gurhan.blogsample.util;

import java.security.Principal;

public class ControllerUtil {
	public static String getActiveUserName(Principal principal) {
		if (principal == null) {
			return null;
		}
		return principal.getName();
	}
}
