package com.dsa.hashtable.usecase.containing;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    private static Map<Integer, Integer> num_counts;

    private TwoSum() {
        this.num_counts = new HashMap<>();
    }

    private static void add(int number) {
        num_counts.put(number, num_counts.getOrDefault(number, 0) + 1);
    }

    // Find if there exists any pair of numbers which sum is equal to the target.
    private static boolean find(int target) {
        for (Map.Entry<Integer, Integer> entry : num_counts.entrySet()) {
            int complement = target - entry.getKey();
            if (complement != entry.getKey()) {
                if (num_counts.containsKey(complement)) return true;
            } else {
                // duplicate case
                if (entry.getValue() > 1) return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        if (num_counts.isEmpty()) return "[]";
        else {
            StringBuilder sb = new StringBuilder().append("[");
            for (Map.Entry<Integer, Integer> entry : num_counts.entrySet()) {
                int key = entry.getKey();
                int val = entry.getValue();
                for (int i = 0; i < val; i++) {
                    sb.append(key + ", ");
                }
            }
            sb.delete(sb.length() - 2, sb.length());
            return sb.append("]").toString();
        }
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        ts.add(1);
        ts.add(3);
        ts.add(5);
        ts.add(5);
        System.out.println(ts);
    }

}
