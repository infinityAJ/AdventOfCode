package day8;

import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class Problem1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File(args[0]));
//        int n = 5; // demo
        int n = 99; // real
        int[][] grid = new int[n][n];
        int x = 0;
        while(sc.hasNextLine()) {
            String s = sc.nextLine();
            for(int i = 0;i<n;i++) {
                grid[x][i] = s.charAt(i)-'0';
            }
            x++;
        }
        boolean[][] visible = new boolean[n][n];
        for(int i=1;i<n-1;i++) {
            int tallest_tree = grid[i][0];
            for(int j=1;j<n-1;j++) {
                if(tallest_tree<grid[i][j]) {
                    visible[i][j] = true;
                    tallest_tree = grid[i][j];
                }
            }
        }
        for(int i=1;i<n-1;i++) {
            int tallest_tree = grid[i][n-1];
            for(int j=n-1;j>0;j--) {
                if(tallest_tree<grid[i][j]) {
                    visible[i][j] = true;
                    tallest_tree = grid[i][j];
                }
            }
        }
        for(int i=1;i<n-1;i++) {
            int tallest_tree = grid[0][i];
            for(int j=1;j<n-1;j++) {
                if(tallest_tree<grid[j][i]) {
                    visible[j][i] = true;
                    tallest_tree = grid[j][i];
                }
            }
        }
        for(int i=1;i<n-1;i++) {
            int tallest_tree = grid[n-1][i];
            for(int j=n-1;j>0;j--) {
                if(tallest_tree<grid[j][i]) {
                    visible[j][i] = true;
                    tallest_tree = grid[j][i];
                }
            }
        }
        int ans = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(visible[i][j] || i==0 || j==0 || i==n-1 || j==n-1) ans++;
            }
        }
        System.out.println(ans);
    }
}