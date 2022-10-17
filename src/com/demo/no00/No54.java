package com.demo.no00;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 */
public class No54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return null;
        }
        int startI = 0, endI = matrix[0].length - 1;
        int startJ = 0, endJ = matrix.length - 1;
        int numEle = matrix.length * matrix[0].length;

        while (startI <= endI && startJ <= endJ) {
//            System.out.println("startI:" + startI + ",endI:" + endI);
//            System.out.println("startJ:" + startJ + ",endJ:" + endJ);
            //1
            for (int i = startI; i <= endI && numEle >= 1; i++) {
                list.add(matrix[startJ][i]);
                numEle--;
            }
//            System.out.println(list);
            //2
            for (int i = startJ + 1; i <= endJ && numEle >= 1; i++) {
                list.add(matrix[i][endI]);
                numEle--;
            }
//            System.out.println(list);
            //3
            for (int i = endI - 1; i >= startI && numEle >= 1; i--) {
                list.add(matrix[endJ][i]);
                numEle--;
            }
//            System.out.println(list);
            //4
            for (int i = endJ - 1; i >= startJ + 1 && numEle >= 1; i--) {
                list.add(matrix[i][startJ]);
                numEle--;
            }
//            System.out.println(list);

            startI++;
            endI--;
            startJ++;
            endJ--;
        }

        return list;
    }

    public static void main(String[] args) {
        No54 no54 = new No54();
//        System.out.println(no54.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}).toString());
//        System.out.println(no54.spiralOrder(new int[][]{{6, 7}}).toString());
        System.out.println(no54.spiralOrder(new int[][]{{6}}).toString());
//        System.out.println(no54.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}).toString());
    }
}
