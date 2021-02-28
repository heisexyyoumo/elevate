package com.humorous.elevate.datastructure.tree;

import java.util.*;

/**
 * 赫夫曼编码
 */
public class HuffmanCodeDemo {

    public static void main(String[] args) {
        String content = "i like like like java do you like a java";

        byte[] contentBytes = content.getBytes();
        System.out.println(contentBytes.length); //40


        List<HuffmanNode> nodes = getNodes(contentBytes);
        System.out.println("nodes=" + nodes);
        //测试一把，创建的赫夫曼树
        System.out.println("赫夫曼树");
        HuffmanNode huffmanTreeRoot = createHuffmanTree(nodes);
        System.out.println("前序遍历");
        huffmanTreeRoot.preOrder();

        //测试一把是否生成了对应的赫夫曼编码
//        Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
        getCodes(huffmanTreeRoot, "", stringBuilder);
        System.out.println("~生成的赫夫曼编码表= " + huffmanCodes);
    }


    static Map<Byte, String> huffmanCodes = new HashMap<Byte, String>();
    static StringBuilder stringBuilder = new StringBuilder();


    private static Map<Byte, String> getCodes(HuffmanNode root) {
        if (root == null) {
            return null;
        }
        //处理root的左子树
        getCodes(root.left, "0", stringBuilder);
        //处理root的右子树
        getCodes(root.right, "1", stringBuilder);
        return huffmanCodes;
    }

    /**
     * 功能：将传入的node结点的所有叶子结点的赫夫曼编码得到，并放入到huffmanCodes集合
     *
     * @param node          传入结点
     * @param code          路径： 左子结点是 0, 右子结点 1
     * @param stringBuilder 用于拼接路径
     */
    private static void getCodes(HuffmanNode node, String code, StringBuilder stringBuilder) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(code);
        if (node != null) {
            if (node.data == null) {
                getCodes(node.left, "0", sb2);
                getCodes(node.right, "1", sb2);
            } else {
                huffmanCodes.put(node.data, sb2.toString());
            }
        }
    }

    //前序遍历的方法
    private static void preOrder(HuffmanNode root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("赫夫曼树为空");
        }
    }

    private static List<HuffmanNode> getNodes(byte[] bytes) {
        Map<Byte, Integer> map = new HashMap<>();
        for (byte b : bytes) {
            Integer count = map.get(b);
            if (count == null) {
                map.put(b, 1);
            } else {
                map.put(b, count + 1);
            }
        }
        List<HuffmanNode> list = new ArrayList<>();
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            list.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }
        return list;
    }

    private static HuffmanNode createHuffmanTree(List<HuffmanNode> list) {
        while (list.size() > 1) {
            Collections.sort(list);

            HuffmanNode leftNode = list.get(0);
            HuffmanNode rightNode = list.get(1);
            HuffmanNode parent = new HuffmanNode(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;

            list.remove(leftNode);
            list.remove(rightNode);
            list.add(parent);
        }
        return list.get(0);
    }
}

class HuffmanNode implements Comparable<HuffmanNode> {
    Byte data;   //字符
    int weight;  //字符对应的权重
    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    //前序遍历
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
    public int compareTo(HuffmanNode o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "HuffmanNode{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }
}
