package com.demo.no06;

/**
 * 678. 有效的括号字符串
 */
public class No678 {
    public boolean checkValidString(String s) {
        //最少左括号的数量
        int minLeftCount = 0;
        //最多左括号的数量
        int maxLeftCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                minLeftCount++;
                maxLeftCount++;
            } else if (s.charAt(i) == ')') {
                //如果只剩下右括号了，直接返回false
                if (maxLeftCount <= 0) {
                    return false;
                }
                if (minLeftCount > 0) {
                    minLeftCount--;
                }
                maxLeftCount--;
            } else {
                if (minLeftCount > 0) {
                    minLeftCount--;
                }
                maxLeftCount++;
            }
        }

        System.out.println(minLeftCount);
        System.out.println(maxLeftCount);

        return minLeftCount == 0 || maxLeftCount == 0;
    }


    public static void main(String[] args) {
        No678 no678 = new No678();
//        System.out.println(no678.checkValidString("()"));
//        System.out.println(no678.checkValidString("()()"));
//        System.out.println(no678.checkValidString("())"));

//        System.out.println(no678.checkValidString("***"));
        System.out.println(no678.checkValidString("(*)"));
//        System.out.println(no678.checkValidString("((**"));
//        System.out.println(no678.checkValidString("())**"));
    }
}
