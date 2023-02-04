package day3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File(args[0]));
        int priority = 0;
        while (sc.hasNextLine()) {
            priority += solve(sc.nextLine());
        }
        sc.close();
        System.out.println(priority);
    }

    private static int solve(String s) {
        int n = s.length();
        int[] count = new int[58];
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i)-65;
            int team = (i/(n/2))+1;
            if(count[index]!=0 && count[index]!=team) {
                if(s.charAt(i)>=65 && s.charAt(i)<=90) {
                    return s.charAt(i)-'A'+27;
                } else return s.charAt(i)-'a'+1;
            }
            count[index] = team;
        }
        return 0;
    }
}