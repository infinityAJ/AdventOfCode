package day2;

import java.util.Scanner;

public class Problem1 {
    public static int score(char col1, char col2) {
        if((col1=='A' && col2=='B') || (col1=='B' && col2=='C') || (col1=='C' && col2=='A')) {
            return 6+col2-64;
        } else if(col1==col2) {
            return 3+col2-64;
        }
        return col2-64;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalScore = 0;
        while(sc.hasNextLine()) {
            String s = sc.nextLine();
//            System.out.println(s.charAt(0) + ", " + (char)(s.charAt(2)-23));
            totalScore += score(s.charAt(0), (char)(s.charAt(2)-23));
        }
        System.out.println(totalScore);
        sc.close();
    }
}
