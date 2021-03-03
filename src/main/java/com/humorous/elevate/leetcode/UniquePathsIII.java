package com.humorous.elevate.leetcode;


/**
 * 980. 不同路径 III
 * 在二维网格 grid 上，有 4 种类型的方格：
 * <p>
 * 1 表示起始方格。且只有一个起始方格。
 * 2 表示结束方格，且只有一个结束方格。
 * 0 表示我们可以走过的空方格。
 * -1 表示我们无法跨越的障碍。
 * 返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目。
 * <p>
 * 每一个无障碍方格都要通过一次，但是一条路径中不能重复通过同一个方格。
 */
public class UniquePathsIII {

    public static void main(String[] args) {
//        int[][] grid = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}};
//        int[][] grid = {{1, 0}, {-1, 2}};
        int[][] grid = {{1}, {2}};
        System.out.println(new UniquePathsIII().uniquePathsIII(grid));
    }

    int count = 0;
    // 起始方格的横纵坐标
    int startx = -1, endx = -1;
    // 结束方格的横纵坐标
    int starty = -1, endy = -1;

    public int uniquePathsIII(int[][] grid) {

        int step = 0;  //从起点到终点需要走多少步，即0的个数

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    step++;
                }
                if (grid[i][j] == 1) {
                    startx = i;
                    starty = j;
                }
                if (grid[i][j] == 2) {
                    endx = i;
                    endy = j;
                }
            }
        }

        //考虑特殊情况
        if (startx == -1 || starty == -1 || endx == -1 || endy == -1
                || (startx == endx && starty == endy)) {
            return 0;
        }

        int[][] dire = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};  // 移动的方向：右 -> 下 -> 左 -> 上
        move(grid, dire, step, 0, startx, starty);
        return count;
    }


    /**
     * @param grid
     * @param step  需要走的步数
     * @param index 这是第几步
     * @param x     当前的x坐标
     * @param y     当前的y坐标
     * @return
     */
    public void move(int[][] grid, int[][] dire, int step, int index, int x, int y) {
        if (index > step) {
            if (x == endx && y == endy) {
                boolean flag = false;
                for (int i = 0; i < grid.length; i++) {
                    for (int j = 0; j < grid[0].length; j++) {
                        if (grid[i][j] == 0) {
                            flag = true;
                        }
                    }
                }
                if (!flag) {
                    count++;
                }
//                System.out.println("=======================");
//                for (int[] arr : grid) {
//                    System.out.println(Arrays.toString(arr));
//                }
//                System.out.println("=======================");

            }
            return;
        }

        for (int i = 0; i < dire.length; i++) {
            int newx = x + dire[i][0];
            int newy = y + dire[i][1];
            if (isArea(newx, newy, grid)) {
                if (grid[newx][newy] == 2) {
                    move(grid, dire, step, index + 1, newx, newy);
                } else if (grid[newx][newy] == 0) {
                    grid[newx][newy] = 3;  // 3表示已经走过的格子
                    move(grid, dire, step, index + 1, newx, newy);
                    grid[newx][newy] = 0;
                }
            }
        }
    }

    /**
     * 判断 {x,y}是否在数组grid中
     * true表示在数组中，false表示不在，已越界
     *
     * @param x
     * @param y
     * @param grid
     * @return
     */
    public boolean isArea(int x, int y, int[][] grid) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }
}
