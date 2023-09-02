package com.demo.no25;

/**
 * 2511. 最多可以摧毁的敌人城堡数目
 *
 * @Date：2023/9/2 13:10
 * @Description
 */
//方法一
public class No2511 {

    int resCount = 0;
    //当前的敌人城堡的数量
    int curCount = 0;
    int start = -1;

    //求1和-1之间的0的数量
    public int captureForts(int[] forts) {
        for (int i = 0; i < forts.length; i++) {
            getCurCount(forts, i);
        }

        for (int i = forts.length - 1; i >= 0; i--) {
            getCurCount(forts, i);
        }
        return resCount;
    }


    public void getCurCount(int[] forts, int index) {
        if (forts[index] == -1) {
            resCount = Math.max(resCount, curCount);
            start = -1;
        }//起点
        else if (forts[index] == 1) {
            curCount = 0;
            start = 1;
        }//敌人的位置
        else if (forts[index] == 0 && start == 1) {
            curCount++;
        }
    }


    public static void main(String[] args) {
        No2511 test = new No2511();
        int res = test.captureForts(new int[]{1, 0, 0, -1, 0, 0, 0, 0, 1});
//        int res = test.captureForts(new int[]{0, 0, 1, -1});
        System.out.println(res);
    }
}
