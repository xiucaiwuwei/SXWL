package com.database;

public class code {
    /**
     * 生成一个随机的6位数字代码。
     *
     * @return 返回一个包含6位随机数字的字符串。
     */
    public static String getcode()
    {
        String code=""; // 初始化代码字符串为空
        for(int i=0;i<6;i++) // 循环生成6位数字
        {
            int num=(int)(Math.random()*10); // 生成0到9之间的随机整数
            code+=num; // 将随机数添加到代码字符串中
        }
        return code; // 返回生成的代码字符串
    }
}
