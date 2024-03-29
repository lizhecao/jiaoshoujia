package cn.billy.common.utils;

import java.util.List;
import java.util.Locale;

import cn.billy.common.consts.Roles;
import cn.billy.common.rbac.Role;
import org.apache.log4j.MDC;

import cn.billy.common.rbac.User;
import cn.billy.common.exceptions.UnloginException;

/**
 * 用户工具类
 *
 */
public class UserUtil {

    private final static ThreadLocal<User> tlUser = new ThreadLocal<User>();

    private final static ThreadLocal<Locale> tlLocale = new ThreadLocal<Locale>() {
        protected Locale initialValue() {
            // 语言的默认值
            return Locale.CHINESE;
        }

        ;
    };

    public static final String KEY_LANG = "lang";

    public static final String KEY_USER = "user";

    public static void setUser(User user) {
        tlUser.set(user);

        // 把用户信息放到log4j
        MDC.put(KEY_USER, user.getName());
    }

    /**
     * 如果没有登录，返回null
     *
     * @return
     */
    public static User getUserIfLogin() {
        return tlUser.get();
    }

    /**
     * 如果没有登录会抛出异常
     *
     * @return
     */
    public static User getUser() {
        User user = tlUser.get();

        if (user == null) {
            throw new UnloginException();
        }

        return user;
    }

    public static long getUserId() {
        return getUser().getId();
    }

    public static void setLocale(String locale) {
        setLocale(new Locale(locale));
    }

    public static void setLocale(Locale locale) {
        tlLocale.set(locale);
    }

    public static Locale getLocale() {
        return tlLocale.get();
    }

    public static void clearAllUserInfo() {
        tlUser.remove();
        tlLocale.remove();

        MDC.remove(KEY_USER);
    }

    /**
     * 是否管理员
     *
     * @return
     */
    public static boolean isAdmin() {
        List<Role> roles = getUser().getRoles();

        for (Role role : roles) {
            if (Roles.ADMIN .equals(role.getName())) {
                return true;
            }
        }

        return false;

    }
}
