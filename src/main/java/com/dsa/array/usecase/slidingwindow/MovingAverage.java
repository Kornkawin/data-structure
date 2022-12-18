package com.dsa.array.usecase.slidingwindow;

public class MovingAverage {

    private static class SMA {
        private int[] window;
        private int count;
        private int sum;
        private int firstIndex;

        //Space: O(n)
        public SMA(int size) {
            window = new int[size];
            count = 0;
            firstIndex = 0;
        }

        //Time: O(1)
        public double next(int val) {
            if (count < window.length) {
                window[count++] = val;
                sum += val;
            } else {
                sum -= window[firstIndex];
                window[firstIndex] = val;
                sum += window[firstIndex];
                firstIndex = nextIndex(firstIndex);
            }
            return (double) sum/count;
        }

        private int nextIndex(int index) {
            return (index + 1 >= window.length) ? 0 : index + 1; // faster
            // return (index + 1) % window.length;
        }
    }

    public static void main(String[] args) {
        SMA sma = new SMA(3);
        System.out.println(sma.next(1)); // return 1.0 = 1 / 1
        System.out.println(sma.next(10)); // return 5.5 = (1 + 10) / 2
        System.out.println(sma.next(3)); // return 4.66667 = (1 + 10 + 3) / 3
        System.out.println(sma.next(5)); // return 6.0 = (10 + 3 + 5) / 3
    }
}
