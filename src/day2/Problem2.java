package day2;

import java.util.Scanner;

public class Problem2 {
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
            totalScore += score(s.charAt(0), response(s.charAt(0),s.charAt(2)));
        }
        System.out.println(totalScore);
        sc.close();
    }

    private static char response(char elf, char req) {
        if(req=='X') {
            if(elf=='A') return 'C';
            else if(elf=='B') return 'A';
            else return 'B';
        } else if(req=='Z') {
            if(elf=='A') return 'B';
            else if(elf=='B') return 'C';
            else return 'A';
        } else return elf;
    }
}



