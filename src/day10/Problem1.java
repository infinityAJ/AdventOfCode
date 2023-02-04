package day10;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class Problem1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File(args[0]));
        int cycle = 0;
        int x = 1;
        int ans = 0;
        while(sc.hasNextLine()) {
            String s = sc.nextLine();
            if(s.charAt(0)=='n') {
                cycle++;
                ans = add(x, ans, cycle);
            } else {
                cycle++;
                ans = add(x, ans, cycle);
                cycle++;
                ans = add(x, ans, cycle);
                x += Integer.parseInt(s.split(" ")[1]);
            }
        }
        System.out.println(ans);
    }

    private static int add(int x, int ans, int cycle) {
        if(cycle==20 || cycle==60 || cycle==100 || cycle==140 || cycle==180 || cycle==220) {
            ans += cycle * x;
        }
        return ans;
    }
}
