package com.dsa.array.usecase.dynamicprogramming;

public class BuySellStock {
    public static void main(String[] args) {
        int[] pricePath = {7,3,6,1,5,4};
        int sol = maxProfit(pricePath);
        System.out.println("Ans: "+sol);
    }

    private static int maxProfit(int[] pricePath) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < pricePath.length; i++) {
            if (pricePath[i] < minPrice) {
                minPrice = pricePath[i];
            } else if (maxProfit < pricePath[i] - minPrice) {
                maxProfit = pricePath[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
