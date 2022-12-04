package day1;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;

public class Problem2 {
    public static void main(String[] args) {
        In file = new In(args[0]);
        int[] bestRes = new int[3];
        int curRes = 0;
        while(file.hasNextLine()) {
            String str = file.readLine();
            if(str.length()==0) {
                Arrays.sort(bestRes);
                bestRes[0] = Math.max(bestRes[0], curRes);
                curRes = 0;
            } else {
                curRes += Integer.parseInt(str);
            }
        }
        Arrays.sort(bestRes);
        bestRes[0] = Math.max(bestRes[0], curRes);
        System.out.println(bestRes[0]+bestRes[1]+bestRes[2]);
    }
}
