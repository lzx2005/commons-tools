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

    /**
     * 下划线转驼峰
     *
     * @param str   下划线字符串
     * @return      转换后的字符串
     */
    public static String underLineToCamelCase(String str) {
        return StringUtilsExt.toCamelCase(str, '_');
    }

    /**
     * 中划线转驼峰
     * @param str   中划线字符串
     * @return      转换后的字符串
     */
    public static String midLineToCamelCase(String str) {
        return StringUtilsExt.toCamelCase(str, '-');
    }

    private static String toCamelCase(String str, char c) {
        if (StringUtils.isEmpty(str)) {
            throw new NullPointerException("string is null");
        }
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean nextUpper = false;
        for (char aChar : chars) {
            if (aChar == c) {
                nextUpper = true;
                continue;
            } else if (nextUpper) {
                aChar -= 32;
                nextUpper = false;
            }
            sb.append(aChar);
        }
        return sb.toString();
    }
}
