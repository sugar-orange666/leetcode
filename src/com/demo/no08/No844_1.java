package com.demo.no08;

/**
 * 844. 比较含退格的字符串
 */
public class No844_1 {
    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    public String build(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        int len = stringBuilder.length();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (stringBuilder.charAt(i) != '#') {
                res.append(stringBuilder.charAt(i));
            } else {
                if (res.length() > 0) {
                    res.deleteCharAt(res.length() - 1);
                }
            }
        }
//        System.out.println("res:"+res.toString());
        return res.toString();
    }

    public static void main(String[] args) {
        No844_1 no844_1 = new No844_1();
        System.out.println(no844_1.backspaceCompare("ab#c", "ad#c"));
        System.out.println(no844_1.backspaceCompare("ab##", "c#d#"));
        System.out.println(no844_1.backspaceCompare("a#c", "b"));
    }

}
