package com.humorous.elevate.datastructure.tree;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 赫夫曼树
 * <p>
 * 假设有n个权值，则构造出的哈夫曼树有n个叶子结点。 n个权值分别设为 w1、w2、…、wn，则哈夫曼树的构造规则为：
 * (1) 将w1、w2、…，wn看成是有n 棵树的森林(每棵树仅有一个结点)；
 * (2) 在森林中选出两个根结点的权值最小的树合并，作为一棵新树的左、右子树，且新树的根结点权值为其左、右子树根结点权值之和；
 * (3)从森林中删除选取的两棵树，并将新树加入森林；
 * (4)重复(2)、(3)步，直到森林中只剩一棵树为止，该树即为所求得的哈夫曼树。
 */
public class HuffmanTreeDemo {

    public static void main(String[] args) {
        int arr[] = {13, 7, 8, 3, 29, 6, 1};
        Node root = create(arr);

        //测试一把
        preOrder(root); //

    }

    //创建赫夫曼树
    public static Node create(int[] arr) {
        //先将数组装入节点中
        List<Node> list = new ArrayList<>();
        for (int val : arr) {
            list.add(new Node(val));
        }
        //从小到大排序
        Collections.sort(list);

        while (list.size() > 1) {
            //选出两个根结点的权值最小的树合并
            Node leftNode = list.get(0);
            Node rightNode = list.get(1);
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

            //删除选取的两棵树，并将新生成的树加入
            list.remove(leftNode);
            list.remove(rightNode);
            list.add(parent);

            Collections.sort(list);
        }
        return list.get(0);
    }

    //编写一个前序遍历的方法
    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("是空树，不能遍历~~");
        }
    }

}

class Node implements Comparable<Node> {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    //写一个前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //从小到大排序
        return this.value - o.value;
    }
}
