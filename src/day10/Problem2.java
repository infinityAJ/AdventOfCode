package day10;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class Problem2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File(args[0]));
        int cycle = 0;
        int x = 1;
        while(sc.hasNextLine()) {
            String s = sc.nextLine();
            if(s.charAt(0)=='n') {
                print(x, cycle);
                cycle++;
            } else {
                print(x, cycle);
                cycle++;
                print(x, cycle);
                cycle++;
                x += Integer.parseInt(s.split(" ")[1]);
            }
        }
    }

    private static void print(int x, int cycle) {
        int c = cycle%40;
        if(c==0) System.out.print('\n');
        if(c>=x-1 && c<=x+1) {
            System.out.print('#');
        } else {
            System.out.print('.');
        }
    }
}
