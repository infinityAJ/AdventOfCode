package day5;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) throws IOException {
        Scanner cargo = new Scanner(new File(args[0]));
        Scanner mover = new Scanner(new File(args[1]));
        ArrayList<StringBuilder> ship = new ArrayList<>();
        int nol = 9;
        for(int i=0;i<nol;i++) {
            ship.add(new StringBuilder());
        }
        while(cargo.hasNextLine()) {
            String s = cargo.nextLine();
            for(int i=0;i<nol;i++) {
                if(s.charAt(i)=='-') continue;
                ship.get(i).append(s.charAt(i));
            }
        }
        cargo.close();
        while(mover.hasNextLine()) {
            int no = mover.nextInt();
            int from = mover.nextInt()-1;
            int to = mover.nextInt()-1;
            int n = ship.get(from).length();
            ship.get(to).append(ship.get(from).substring(n-no));
            ship.get(from).delete(n-no, n);
        }
        String res = "";
        for(int i=0;i<nol;i++) {
            res += ship.get(i).charAt(ship.get(i).length()-1);
        }
        System.out.println(res);
        mover.close();
    }
}

