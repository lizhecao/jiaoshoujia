package cn.billy.common.utils;

import org.springframework.context.MessageSource;

import cn.billy.common.exceptions.CheckException;

/**
 * 校验工具类
 * 
 *
 */
public class CheckUtil {
	private static MessageSource resources;

	public static void setResources(MessageSource resources) {
		CheckUtil.resources = resources;
	}

	public static void check(boolean condition, String msgKey, Object... args) {
		if (!condition) {
			fail(msgKey, args);
		}
	}

	public static void check(boolean condition) {
		if (!condition) {
			fail("field.invalid");
		}
	}

	public static void notEmpty(String str, String msgKey, Object... args) {
		if (str == null || str.isEmpty()) {
			fail(msgKey, args);
		}
	}

	public static void notNull(Object obj, String msgKey, Object... args) {
		if (obj == null) {
			fail(msgKey, args);
		}
	}

	public static void notNull(Object obj) {
		if (obj == null) {
			notNull(obj, "param.is.null");
		}
	}

	private static void fail(String msgKey, Object... args) {
		throw new CheckException(resources.getMessage(msgKey, args, UserUtil.getLocale()));
	}
}
