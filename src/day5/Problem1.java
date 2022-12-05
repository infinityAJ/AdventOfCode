package day5;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;

public class Problem1 {
    public static void main(String[] args) throws IOException {
        Scanner cargo = new Scanner(new File(args[0]));
        Scanner mover = new Scanner(new File(args[1]));
        ArrayList<Stack<Character>> ship = new ArrayList<>();
        for(int i=0;i<9;i++) {
            ship.add(new Stack<Character>());
        }
        while(cargo.hasNextLine()) {
            String s = cargo.nextLine();
            for(int i=0;i<s.length();i++) {
                if(s.charAt(i)!='-') {
                    ship.get(i).push(s.charAt(i));
                }
            }
        }
        cargo.close();
        while(mover.hasNextLine()) {
            int no = mover.nextInt();
            int from = mover.nextInt()-1;
            int to = mover.nextInt()-1;
            while(no>0) {
                ship.get(to).push(ship.get(from).pop());
                no--;
            }
        }
        String res = "";
        for(int i=0;i<9;i++) {
            res += ship.get(i).peek();
        }
        System.out.println(res);
        mover.close();
    }
}