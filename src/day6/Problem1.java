package day6;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File(args[0]));
        String str = sc.next();
        int[] count = new int[26];
        for (int i = 0; i < 3; i++) {
            count[str.charAt(i) - 'a']++;
        }
        for (int i = 4; i < str.length(); i++) {
            if (isUnique(count)) {
                System.out.println(i);
                break;
            } else {
                count[str.charAt(i) - 'a']++;
                count[str.charAt(i - 4) - 'a']--;
            }
        }
    }

    private static boolean isUnique(int[] count) {
        for (int i : count)
            if (i >= 2)
                return false;
        return true;
    }
}