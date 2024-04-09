package com.demo.no00;

import java.util.Objects;

/**
 *
 *
 * 14. 最长公共前缀
 * @Date：2024/4/9 14:41
 * @Description
 */
public class No14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        String s = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String curStr = strs[i];
            for (int j = 0; j < curStr.length(); j++) {
                //如果是空字符串，就提前跳出来，下面的判断包含了这种情况，这里可以注释掉
//                if (Objects.equals(s, "")) {
//                    return s;
//                }
                //如果s的length大于curStr的len的情况
                if (j < s.length() && s.charAt(j) != curStr.charAt(j)) {
                    s = curStr.substring(0, j);
                    break;
                }

            }
            //把较短的赋值给s
            s = curStr.length() > s.length() ? s : curStr;

        }
        return s;
    }


    public static void main(String[] args) {
        No14 no14 = new No14();
//        String s = no14.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
//        String s = no14.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
//        String s = no14.longestCommonPrefix(new String[]{"ab", "a"});
        String s = no14.longestCommonPrefix(new String[]{"aaa", "aa", "aaa"});
        System.out.println(s);

    }
}
