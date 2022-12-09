package day7;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Problem1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File(args[0]));
        HashMap<String, ArrayList<String>> children = new HashMap<>();
        HashMap<String, Long> size = new HashMap<>();
        String path = sc.nextLine().split(" ")[2];
        children.put(path, new ArrayList<>());
        size.put(path, (long) 0);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            if (str.charAt(0) == '$') {
                String[] strs = str.split(" ");
                if (strs[1].equals("cd")) {
                    if (strs[2].equals("..")) {
                        path = path.substring(0, path.lastIndexOf('/'));
                    } else {
                        path = path+'/'+strs[2];
                        children.put(path, new ArrayList<>());
                        size.put(path, (long) 0);
                    }
                }
            } else {
                if (str.charAt(0) == 'd') {
                    children.get(path).add(path+'/'+str.split(" ")[1]);
                } else {
                    size.put(path, size.get(path) + Long.parseLong(str.split(" ")[0]));
                }
            }
        }
        updateSize("/", children, size);
//        System.out.println(size);
        long ans = Long.MAX_VALUE;
        for (long s : size.values()) {
            if (s <= 100000) {
                ans += s;
            }
        }
        System.out.println(ans);
    }

    private static void updateSize(String root, HashMap<String, ArrayList<String>> children,
            HashMap<String, Long> size) {
        ArrayList<String> child = children.get(root);
        if (child.size() == 0)
            return;
        else {
            for (String s : child) {
                updateSize(s, children, size);
                size.put(root, size.get(root) + size.get(s));
            }
        }
    }
}