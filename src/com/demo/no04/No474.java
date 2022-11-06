package com.demo.no04;

import com.demo.no00.No47;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 474. 一和零
 */
public class No474 {
    public int findMaxForm(String[] strs, int m, int n) {
        //dp[i][j]表示i个0和j个1时的最大子集
        int[][] dp = new int[m + 1][n + 1];
        int oneNum, zeroNum;
        for (String str : strs) {
            oneNum = 0;
            zeroNum = 0;
            for (char ch : str.toCharArray()) {
                if (ch == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }
            //倒序遍历
            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[m][n];

}
    public static void main(String[] args) {
        No474 no474 = new No474();
//        System.out.println(no474.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
//        System.out.println(no474.findMaxForm(new String[]{"10", "0", "1"}, 1, 1));
        System.out.println(no474.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 4, 3));
    }
}
