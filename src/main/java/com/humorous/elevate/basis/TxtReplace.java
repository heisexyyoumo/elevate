package com.humorous.elevate.basis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TxtReplace {

    public static String read(String path) {
        File file = new File(path);
        StringBuffer res = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                res.append(line + "\n");
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res.toString();
    }

    public static boolean write(String cont, File dist) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(dist));
            writer.write(cont);
            writer.flush();
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
//        File tar = new File("C:\\Users\\humorous\\Desktop\\newbuildPrj.txt");
//        String cont = TxtReplace.read("C:\\Users\\humorous\\Desktop\\buildPrj.txt");
//        System.out.println(cont);
//        //对得到的内容进行处理
//        cont = cont.replace("#(IDEPATH)", "D:/software/DingDing");
//        cont = cont.replace("#(STATICPATH)", "D:/logs/devops");
//        System.out.println(cont);
//        //更新源文件
//        System.out.println(TxtReplace.write(cont, tar));

        File tar = new File("C:\\Users\\humorous\\Desktop\\newbuildPrj.txt");
        String cont = TxtReplace.read("C:\\Users\\humorous\\Desktop\\buildPrj.txt");
        System.out.println(cont);
        //对得到的内容进行处理
        cont = cont.replace("#(IDEPATH)", "D:/software/DingDing");
        cont = cont.replace("#(STATICPATH)", "D:/logs/devops");
        System.out.println(cont);
        //更新源文件
        System.out.println(TxtReplace.write(cont, tar));



    }
}

