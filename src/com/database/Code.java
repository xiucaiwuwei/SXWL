package com.database;

public class Code {
    /**
     * 生成一个随机的6位数字代码。
     *
     * @return 返回一个包含6位随机数字的字符串。
     */
    public static String getCode() {
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int num = (int) (Math.random() * 10);
            code.append(num);
        }
        return code.toString();
    }
}
