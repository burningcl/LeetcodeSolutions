package com.skyline.leetcode.solution.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by chenliang on 2017/2/23.
 */
public class Test {

    public static void main(String... strings) {
//        Pattern pattern = Pattern.compile("\\[url[ ]*=[ ]*(\"|')(.*)(\"|')](.*)\\[\\/url]");
//        String text = "1.请确认您的网银账户已开通并激活，可在电脑上正常登录\n" +
//                "2.同一张银行卡可能有多种类型的密码，请按提示输入相应的密码，[url = \"moneykeeper://assetcharge\"]查看详情[/url]\n" +
//                "3.您还可以先[url=\"http://qian.163.com\"]手动添加银行卡[/url]，再开通同步";
//        Matcher matcher = pattern.matcher(text);
//        int start = 0;
//
////        while (matcher.find()) {
////            System.out.println("matcher.start(): " + matcher.start());
////            System.out.println("matcher.end(): " + matcher.end());
////            System.out.println("matcher.group(): " + matcher.group());
////        }
//
//        while (matcher.find()) {
//            System.out.println(text.substring(start, matcher.start()));
//            System.out.println(matcher.group());
//            System.out.println("url:"+ matcher.group(2));
//            System.out.println("text:"+ matcher.group(4));
//            start = matcher.end();
//        }
//        System.out.println(text.substring(start, text.length()));
        System.out.println(1 & -1);
        System.out.println(2 & -2);
        System.out.println(4 & -4);
        System.out.println(8 & -8);
    }
}
