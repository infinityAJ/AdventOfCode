package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(args[0]));
        int ans = 0;
        while(sc.hasNextLine()) {
            ans += solve(sc.nextLine());
        }
        sc.close();
        System.out.println(ans);
    }

    private static int solve(String s) {
        int ranges[] = new int[4];
        int i = 0;
        for(String x:s.split("[,-]")) {
            ranges[i++] = Integer.parseInt(x);
        }
        if(!((ranges[1]<ranges[2]) || (ranges[3]<ranges[0]))) {
            return 1;
        }
        return 0;
    }
}