package day1;

import edu.princeton.cs.algs4.In;

public class Problem1 {
    public static void main(String[] args) {
        In file = new In(args[0]);
        int bestRes = 0;
        int curRes = 0;
        while(file.hasNextLine()) {
            String str = file.readLine();
            if(str.length()==0) {
                bestRes = Math.max(bestRes, curRes);
                curRes = 0;
            } else {
                curRes += Integer.parseInt(str);
            }
        }
        System.out.println(bestRes);
    }
}
