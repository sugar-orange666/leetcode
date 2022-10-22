package com.jz_offer;

/**
 * JZ5 替换空格
 */
public class LZ05 {
    public String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                res.append(s.charAt(i));
            } else {
                res.append("%20");
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        LZ05 lz05 = new LZ05();
        System.out.println(lz05.replaceSpace("We are happy."));
    }

}
