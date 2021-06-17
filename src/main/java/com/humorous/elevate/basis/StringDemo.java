package com.humorous.elevate.basis;

/**
 * 测试String类的用法
 */
public class StringDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        String str = "abc";
//        String str2 = new String(new char[]{'a','b','c'});
//        System.out.println(str == str2);
//        Class<? extends String> strClass = str.getClass();
//        Field value = strClass.getDeclaredField("value");
//        value.setAccessible(true);
//        Object o1 = value.get(str);
//        Object o2 = value.get(str2);
//        System.out.println(o1);
//        System.out.println(o2);
//
//        value.set(str2,new char[]{'a','a','a'});
//        Object o3 = value.get(str2);
//        System.out.println(o3);
//        System.out.println(str);
//        System.out.println(str2);
//        String s1 = "abc" + "def";
//        String s2 = "adc";
//        String s3 = s1 + "s2";
//        String s4 = new String("adc");
//        String s5 = s4.intern();
//        System.out.println(s5 == s2);
//        System.out.println(s3);
        String str = new String("a" + "b");
        System.out.println(str);
    }
}
