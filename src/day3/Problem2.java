package day3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File(args[0]));
        int priority = 0;
        while (sc.hasNextLine()) {
            priority += solve(sc.nextLine(), sc.nextLine(), sc.nextLine());
        }
        sc.close();
        System.out.println(priority);
    }
    
    private static boolean[] count(String s) {
        int n = s.length();
        boolean[] ans = new boolean[58];
        for(int i=0;i<n;i++) {
            ans[s.charAt(i)-65] = true;
        }
        return ans;
    }

    private static int solve(String x, String y, String z) {
        boolean[] c1 = count(x);
        boolean[] c2 = count(y);
        boolean[] c3 = count(z);
        for(int i=0;i<58;i++) {
            if(c1[i] && c2[i] && c3[i]) {
                char ch = (char) (i+65);
                if(ch>=65 && ch<=90) {
                    return ch-38;
                } else return ch-96;
            }
        }
        return 0;
    }
}