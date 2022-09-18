import javax.swing.tree.TreeNode;
import java.util.*;
import java.io.*;



class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();
        String str = scanner.next();
        System.out.println("djjdjdjdj");
        System.out.println("djfijdoifjosdj");
        String[] strArray = str.split("");
        String str1 = strArray[0] + "-";
        StringBuffer sb = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        for (int i = 1; i < strArray.length; i++) {
            char[] ch = strArray[i].toCharArray();
            for (char c : ch) {
                sb.append(c);
            }
        }
        char[] ch2 = sb.toString().toCharArray();
        for (int i = 0; i < ch2.length; i = K + i) {
            int UpperCaseNums = 0;
            int LowerCaseNums = 0;
            if (K + i > ch2.length) {
                for (int j = i; j < ch2.length; j++) {
                    if (Character.isLowerCase(ch2[j])) {
                        LowerCaseNums++;
                    }
                    if (Character.isUpperCase(ch2[j])) {
                        UpperCaseNums++;
                    }
                }
                if (LowerCaseNums < UpperCaseNums) {
                    for (int j = i; j < ch2.length; j++) {
                        if (Character.isLowerCase(ch2[j])) {
                            ch2[j]= Character.toUpperCase(ch2[j]);
                        }
                    }
                } else if (LowerCaseNums > UpperCaseNums) {
                    for (int j = i; j < ch2.length; j++) {
                        if (Character.isUpperCase(ch2[j])) {
                            ch2[j]= Character.toLowerCase(ch2[j]);
                        }
                    }
                }
                for (int j = i; j < ch2.length; j++) {
                    sb2.append(ch2[j]);
                }
            } else {
                for (int j = i; j < K + i; j++) {
                    if (Character.isLowerCase(ch2[j])) {
                        LowerCaseNums++;
                    }
                    if (Character.isUpperCase(ch2[j])) {
                        UpperCaseNums++;
                    }
                }
                if (LowerCaseNums < UpperCaseNums) {
                    for (int j = i; j < K + i; j++) {
                        if (Character.isLowerCase(ch2[j])) {
                            ch2[j]= Character.toUpperCase(ch2[j]);
                        }
                    }
                } else if (LowerCaseNums > UpperCaseNums) {
                    for (int j = i; j < K + i; j++) {
                        if (Character.isUpperCase(ch2[j])) {
                            ch2[j]= Character.toLowerCase(ch2[j]);
                        }
                    }
                }
                for (int j = i; j < K + i; j++) {
                    sb2.append(ch2[j]);
                }
                sb2.append("-");
            }
        }
        String result = str1+sb2.toString();
        System.out.println(result);
    }
}




