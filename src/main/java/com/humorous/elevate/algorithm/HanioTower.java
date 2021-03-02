package com.humorous.elevate.algorithm;

/**
 * 汉诺塔问题
 * 分治法解决
 */
public class HanioTower {

    public static void main(String[] args) {
        hanioTower(5, 'A', 'B', 'C');
    }


    /**
     * @param num 塔的数量
     * @param a   移动的起始塔
     * @param b   移动的辅助塔
     * @param c   移动到的目标塔
     */
    public static void hanioTower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("移动：" + a + "->" + c);
        } else {
            hanioTower(num - 1, a, c, b);
//            System.out.println("第" + num + "个盘移动：" + a + "->" + c);
            hanioTower(1, a, b, c);
            hanioTower(num - 1, b, a, c);
        }
    }
}
