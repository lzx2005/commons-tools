package io.github.lzx2005.string;

import org.apache.commons.lang.StringUtils;

/**
 * 字符串工具扩展包
 * Created by hzlizx on 2018/6/20 0020
 */
public class StringUtilsExt {

    public static boolean hasEmpty(String... strings) {
        for (String str : strings) {
            if (StringUtils.isEmpty(str))
                return true;
        }
        return false;
    }

    public static boolean hasBlank(String... strings) {
        for (String str : strings) {
            if (StringUtils.isBlank(str))
                return true;
        }
        return false;
    }

    public static boolean hasNotBlank(String... strings) {
        for (String str : strings) {
            if (StringUtils.isNotBlank(str))
                return true;
        }
        return false;
    }

    public static boolean notBlank(String... strings) {
        for (String str : strings) {
            if (StringUtils.isBlank(str))
                return false;
        }
        return true;
    }


}
