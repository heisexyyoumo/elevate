package com.humorous.elevate.basis;

import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFile {

    public static File[] getFiles(String s) {
        return getFiles("./", s);
    }

    /**
     * 获取文件
     * 可以根据正则表达式查找
     *
     * @param dir String 文件夹名称
     * @param s   String 查找文件名，可带*.?进行模糊查询
     * @return File[] 找到的文件
     */
    public static File[] getFiles(String dir, String s) {
        //开始的文件夹
        File file = new File(dir);

        s = s.replace('.', '#');
        s = s.replaceAll("#", "\\\\.");
        s = s.replace('*', '#');
        s = s.replaceAll("#", ".*");
        s = s.replace('?', '#');
        s = s.replaceAll("#", ".?");
        s = "^" + s + "$";

//        System.out.println(s);
        Pattern p = Pattern.compile(s);
        ArrayList list = filePattern(file, p);

        File[] rtn = new File[list.size()];
        list.toArray(rtn);
        return rtn;
    }

    /**
     * @param file File 起始文件夹
     * @param p    Pattern 匹配类型
     * @return ArrayList 其文件夹下的文件夹
     */

    private static ArrayList filePattern(File file, Pattern p) {
        if (file == null) {
            return null;
        } else if (file.isFile()) {
            Matcher fMatcher = p.matcher(file.getName());
            if (fMatcher.matches()) {
                ArrayList list = new ArrayList();
                list.add(file);
                return list;
            }
        } else if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null && files.length > 0) {
                ArrayList list = new ArrayList();
                for (int i = 0; i < files.length; i++) {
                    ArrayList rlist = filePattern(files[i], p);
                    if (rlist != null) {
                        list.addAll(rlist);
                    }
                }
                return list;
            }
        }
        return null;
    }

    /**
     * 测试
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        String dir = "C:\\Users\\humorous\\Desktop\\buildPrj";
        String s = "a.txt";
        File[] files = MatchFile.getFiles(dir, s);
        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}

