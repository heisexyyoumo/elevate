package com.humorous.elevate.basis;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

/**
 * FileUtils工具类的测试使用
 */
public class FileUtilsTest {

    public static void main(String[] args) throws IOException {
//        File file = new File("C:\\Users\\humorous\\Desktop\\buildPrj\\buildPrj-int.txt");
//        String content = FileUtils.readFileToString(file);
//        System.out.println(content);
//
//        content = content.replace("#(IDEPATH)", "testhahha").replace("#(TEST)", "hahha");
//
//        System.out.println(content);
//
////        FileUtils.writeStringToFile(file, content);
//
//        String[] split = content.split("\\s+");
//        System.out.println(split.length);
//        ArrayList<String> strings = new ArrayList<>(Arrays.asList(split));
//        int index = strings.indexOf("TYPE");
//        System.out.println(strings.get(index + 1));
////        System.out.println(strings.indexOf("TYPE"));

//        test1();
        test2();
    }


    public static void test1() {
        File f = new File("C:\\Users\\humorous\\Desktop\\buildPrj\\a.txt");
        File dir = new File("C:\\Users\\humorous\\Desktop\\buildPrj\\test");
        try {
            FileUtils.copyFileToDirectory(f, dir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test2() {
        File f = new File("C:\\Users\\humorous\\Desktop\\buildPrj\\a.txt");
        TreeSet<String> set = new TreeSet<>();
        set.add("1" + f.getAbsolutePath());
        set.add("0" + f.getAbsolutePath());
        for (String s: set){
            System.out.println(s);
        }
    }
}
