package com.demo.no08;

/**
 * 860. 柠檬水找零
 */
public class No860 {
    public boolean lemonadeChange(int[] bills) {
        int fiveCount = 0;
        int tenCount = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                fiveCount++;
            }
            if (bills[i] == 10) {
                if (fiveCount < 1) {
                    return false;
                }
                fiveCount--;
                tenCount++;
            }
            if (bills[i] == 20) {
                //没有10元的
                if (tenCount < 1) {
                    if (fiveCount < 3) {
                        return false;
                    }
                    fiveCount = fiveCount - 3;
                } else {
                    if (fiveCount < 1) {
                        return false;
                    }
                    tenCount--;
                    fiveCount--;
                }
            }


        }
        return true;
    }

    public static void main(String[] args) {
        No860 no860 = new No860();
        System.out.println(no860.lemonadeChange(new int[]{20}));
        System.out.println(no860.lemonadeChange(new int[]{5, 5, 5, 10, 20}));
        System.out.println(no860.lemonadeChange(new int[]{5, 5, 10, 10, 20}));
    }
}
