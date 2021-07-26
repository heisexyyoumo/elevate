package com.humorous.elevate.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 692. 前K个高频单词
 */
public class TopKFrequent {

    public static void main(String[] args) {
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        List<String> list = new TopKFrequent().topKFrequent(words, 4);
        list.forEach(System.out::println);
    }

    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int length = map.size();
        StringIntegerNode[] nodes = new StringIntegerNode[length];
        int index = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            StringIntegerNode node = new StringIntegerNode(entry.getKey(), entry.getValue());
            nodes[index++] = node;
        }

        for (int i = length / 2 - 1; i >= 0; i--) {
            adjust(i, length, nodes);
        }

        for (int j = length - 1; j >= 0; j--) {
            res.add(nodes[0].str);
            StringIntegerNode temp = nodes[0];
            nodes[0] = nodes[j];
            nodes[j] = temp;
            adjust(0, j, nodes);
            if (res.size() < k) {
            } else {
                break;
            }
        }

        return res;

    }

    private void adjust(int i, int len, StringIntegerNode[] nodes) {
        StringIntegerNode temp = nodes[i];
        for (int k = 2 * i + 1; k < len; k = 2 * k + 1) {
            if (k + 1 < len && nodes[k + 1].compareTo(nodes[k])) {
                k++;
            }
            if (nodes[k].compareTo(temp)) {
                nodes[i] = nodes[k];
                i = k;
            } else {
                break;
            }
        }
        nodes[i] = temp;
    }
}

class StringIntegerNode {
    String str;
    Integer num;

    public StringIntegerNode(String str, Integer num) {
        this.str = str;
        this.num = num;
    }

    /**
     * 判断当前元素和传入元素的大小
     * true ==> 大于
     * false ==> 小于
     */
    public boolean compareTo(StringIntegerNode node) {
        if (node.num < this.num) {
            return true;
        } else if (node.num > this.num) {
            return false;
        } else {
            return this.str.compareTo(node.str) < 0;
        }
    }
}
