package com.study.shangguigu.basic.usualClass.exer;


import org.junit.Test;

/**
 * @description: 关于String的练习
 * @date: 2020/2/19 20:50
 * @author: lizhenhong
 */
public class StringExer {
    
    String str = new String("good");
    char[] ch = {'t', 'e', 's', 't'};

    public void change(String str, char[] ch) {
        str = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringExer exer = new StringExer();
        exer.change(exer.str, exer.ch);
        //值传递的时候传的是地址，String有不可变性，重新赋值的话需要重新开辟空间
        System.out.println(exer.str);   //good
        System.out.println(exer.ch);    //best
    }

    /**
     * 将字符串中的指定部分进行反转，如abcdefg反转为abfedcg
     * 除了下面的方法，还能进行拼接（这里就不写了）
     */
    @Test
    public void reverse() {
        int startIndex = 2;
        int endIndex = 5;
        String str = "abcdefg";
        char[] array = str.toCharArray();
        for (int i = startIndex, j = endIndex; i < j; i++, j--) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        System.out.println(array);
    }

    /**
     * 获取一个字符串在另一个字符串中出现的次数（比如"ab"在"abkkcadkabkebfkabkskab"中出现的次数）
     */
    public int getCount(String mainStr, String subStr) {
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int count = 0;
        int index;
        if (mainLength >= subLength) {   //如果mainLength < subLength的话，count一定是0
            while ((index = mainStr.indexOf(subStr)) != -1) {
                count++;
                mainStr = mainStr.substring(index + subStr.length());
            }
        }
        return count;
    }

    @Test
    public void testCount() {
        String mainStr = "abkkcadkabkebfkabkskab";
        String subStr = "ab";
        int count = getCount(mainStr, subStr);
        System.out.println("==========>得到的count的值是：" + count);
    }

    /**
     * 获取两个字符串中的相同的子字符串(只考虑两个字符串中只有一个相同子串)
     * str1 = "abcwerthelloyuiidef", str2 = "cvhellobnm"
     */
    public String getSameStr(String str1, String str2) {
        if (str1 != null && str2 != null) {
            //先判断str1和str2的长度，较大的叫maxStr，较小的叫minStr
            String maxStr = (str1.length() >= str2.length()) ? str1 : str2;
            String minStr = (str1.length() < str2.length()) ? str1 : str2;
            //声明一个length，让他是较小的字符串的长度
            int length = minStr.length();
            for (int i = 0; i < length; i++) {  //循环较小长度的字符串
                //截取较小字符串index=j 到k之间的部分和maxStr比较，如果maxStr包含截取的字符串，则将该截取的字符串返回
                for (int j = 0, k = length - i; k <= length - j; j++, k++) {
                    String subStr = minStr.substring(j, k);
                    if (maxStr.contains(subStr)) {
                        return subStr;
                    }
                }
            }
        }
        return null;
    }

    @Test
    public void testGetSameStr() {
        String str1 = "abcwerthelloyuiidef";
        String str2 = "cvhellobnm";
        String resultStr = getSameStr(str1, str2);
        System.out.println("=========>最大相同子字符串为：" + resultStr);
    }
    
    


}
