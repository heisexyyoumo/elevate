package com.humorous.elevate.datastructure.queue;

// 约瑟夫环问题
//Josephus有过的故事：39 个犹太人与Josephus及他的朋友躲到一个洞中，39个犹太人决定宁愿死也不要被敌人抓。
//于是决定了自杀方式，41个人排成一个圆圈，由第1个人开始报数，每报数到第3人该人就必须自杀。
//然后下一个重新报数，直到所有人都自杀身亡为止。然而Josephus 和他的朋友并不想遵从，Josephus要他的朋友先假装遵从，
//他将朋友与自己安排在第16个与第31个位置，于是逃过了这场死亡游戏。

// n : 表示总数， k ：表示报k个数
public class Josephus {


    public static void main(String[] args) {
        //先通过尾插法构建单向环形列表
        int k = 3;
        int n = 41;
        ListNode head = null;  //第一个节点
        ListNode cur = null;
        for (int i = 1; i <= n; i++) {
            ListNode node = new ListNode(i);
            if (i == 1) {
                head = node;
                cur = head;
            } else {
                cur.next = node;
                cur = node;
            }
        }
        cur.next = head;

        ListNode temp = head;
        while (temp.next != temp) {
            for (int i = 1; i < k - 1; i++) {
                temp = temp.next;
            }
            //删除
            temp.next = temp.next.next;
            temp = temp.next;
        }

        System.out.println(temp.val);

    }

}

