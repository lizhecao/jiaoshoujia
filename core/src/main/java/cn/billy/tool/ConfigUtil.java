package cn.billy.tool;

import cn.billy.beans.Config;
import cn.billy.daos.ConfigDao;
import org.springframework.beans.factory.annotation.Autowired;

import static cn.billy.common.utils.CheckUtil.check;

public class ConfigUtil {

    private static ConfigDao configDao;

    public static void setConfigDao(ConfigDao configDao) {
        ConfigUtil.configDao = configDao;
    }

    public static  String get(String name){
        Config config =  configDao.findByName(name);

        check(config != null, "config.not.exist", name);

        return config.getValue();
    }

    public static  String get(String name, String defaultValue){
        Config config =  configDao.findByName(name);
        return config != null ? config.getValue() : defaultValue;
    }

    public static  String getInt(String name){
        throw new UnsupportedOperationException("等你实现");
    }
}
