package com.humorous.elevate.datastructure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {

    List<String> vertexList;  //顶点的集合
    int[][] edges;  //图的邻接表
    int numOfEdges;  //边的数量
    boolean[] isVisited;

    public static void main(String[] args) {
        int n = 8;  //结点的个数
        String Vertexs[] = {"A", "B", "C", "D", "E"};
        //String Vertexs[] = {"1", "2", "3", "4", "5", "6", "7", "8"};

        //创建图对象
        Graph graph = new Graph(n);
        //循环的添加顶点
        for (String vertex : Vertexs) {
            graph.insertVertex(vertex);
        }

        //添加边
//        A-B A-C B-C B-D B-E
        graph.insertEdge(0, 1, 1); // A-B
        graph.insertEdge(0, 2, 1); //
        graph.insertEdge(1, 2, 1); //
        graph.insertEdge(1, 3, 1); //
        graph.insertEdge(1, 4, 1); //

        //更新边的关系
//        graph.insertEdge(0, 1, 1);
//        graph.insertEdge(0, 2, 1);
//        graph.insertEdge(1, 3, 1);
//        graph.insertEdge(1, 4, 1);
//        graph.insertEdge(3, 7, 1);
//        graph.insertEdge(4, 7, 1);
//        graph.insertEdge(2, 5, 1);
//        graph.insertEdge(2, 6, 1);
//        graph.insertEdge(5, 6, 1);

        //显示一把邻结矩阵
        graph.showGraph();
        System.out.println("深度遍历");
        graph.dfs(); // A->B->C->D->E [1->2->4->8->5->3->6->7]

    }

    public Graph(int n) {
        vertexList = new ArrayList<>(n);
        edges = new int[n][n];
        numOfEdges = 0;
        isVisited = new boolean[n];
    }

    //得到邻接节点的下标
    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[index][j] > 0) {
                return j;
            }
        }
        return -1;
    }


    //根据前一个邻接节点的下标来获取下一个邻接节点
    public int getNextNeighbor(int v1, int v2) {
        for (int j = v2 + 1; j < vertexList.size(); j++) {
            if (edges[v1][v2] > 0) {
                return j;
            }
        }
        return -1;
    }

    public void dfs(boolean[] isVisited, int i) {
        System.out.print(getValueByIndex(i) + "->");
        isVisited[i] = true;

        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) {
                dfs(isVisited, w);
            }
            w = getNextNeighbor(i, w);
        }
    }


    public void dfs() {
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }


    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    public int getNumOfVertex() {
        return vertexList.size();
    }

    public int getNumOfEdges() {
        return numOfEdges;
    }

    //返回下标对应的数据 0 -> 'A', 1 ->'B'
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    public void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }
}

