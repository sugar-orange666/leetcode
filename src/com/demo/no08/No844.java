package com.demo.no08;

public class No844 {
    public boolean backspaceCompare(String s, String t) {

        s = deleteStr(new StringBuilder(s));
        t = deleteStr(new StringBuilder(t));
//        System.out.println("s:" + s);
//        System.out.println("t:" + t);
        return s.equals(t);
    }

    public String deleteStr(StringBuilder s) {
        int i = 0;
        int temp = i;
        while (i < s.length()) {
            if (s.charAt(i) == '#') {
                s.deleteCharAt(i);
                temp--;
                if (i >= 1) {
                    s.deleteCharAt(i - 1);
                    temp--;
                }

            } else {
                temp++;
            }
            temp = temp >= 0 ? temp : 0;
            i = temp;
        }
        return s.toString();
    }

    public static void main(String[] args) {
        No844 no844 = new No844();
//        System.out.println(no844.backspaceCompare("ab#c", "ad#c"));
//        System.out.println(no844.backspaceCompare("ab##", "c#d#"));
//        System.out.println(no844.backspaceCompare("a#c", "b"));
        System.out.println(no844.backspaceCompare("j##xfix", "j###xfix"));
//        System.out.println(no844.deleteStr(new StringBuilder("j###xfix")));
    }
}
