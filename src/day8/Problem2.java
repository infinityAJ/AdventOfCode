package day8;

import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class Problem2 {
    public static long calculateScore(int r, int c, int n, int[][] grid) {
        if (r == 0 || c == 0 || r == n - 1 || c == n - 1)
            return 0;
        int right = 0;
        int left = 0;
        int up = 0;
        int down = 0;
        for (int x = r+1; x < n; x++) {
            right++;
            if(grid[x][c] >= grid[r][c]) break;
        }
        for (int x = r-1; x > -1; x--) {
            left++;
            if(grid[x][c] >= grid[r][c]) break;
        }
        for (int x = c+1; x < n; x++) {
            down++;
            if(grid[r][x] >= grid[r][c]) break;
        }
        for (int x = c-1; x > -1; x--) {
            up++;
            if(grid[r][x] >= grid[r][c]) break;
        }
        return right * left * up * down;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File(args[0]));
//        int n = 5; // demo
        int n = 99; // real
        int[][] grid = new int[n][n];
        int x = 0;
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            for (int i = 0; i < n; i++) {
                grid[x][i] = s.charAt(i) - '0';
            }
            x++;
        }
        long best = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long temp = calculateScore(i, j, n, grid);
                best = Math.max(temp, best);
            }
        }
        System.out.println(best);
    }
}