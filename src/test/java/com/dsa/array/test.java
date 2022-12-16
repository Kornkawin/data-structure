package com.dsa.array;

public class test {
    public static void main(String[] args) {
        int[] array = new int[2];
        array[0] = 1;
        System.out.println("init: \t\tsize="+array.length); // 2
        IntArray arr = new IntArray(array);
        System.out.println("After Init: size,cap="+arr.size()+","+arr.getCapacity()); // (2,2)
        System.out.println(arr.get(0)+","+arr.get(1)); // [1,0]
        arr.add(1);
        System.out.println("After Add 1: size,cap="+arr.size()+","+arr.getCapacity()); // (3,4)
        System.out.println(arr.get(0)+","+arr.get(1)+","+arr.get(2)+","+arr.get(3)); // [1,0,1,0]
        arr.removeAt(1);
        System.out.println("After Remove At index 1: size,cap="+arr.size()+","+arr.getCapacity()); // (2,4)
        System.out.println(arr.get(0)+","+arr.get(1)+","+arr.get(2)+","+arr.get(3)); // [1,1,0,0]
        System.out.println("Search 1: index="+arr.binarySearch(1));
        System.out.println("Search 2: index="+arr.binarySearch(2));
        System.out.println("toString(): "+arr); // [1,1]
        System.out.print("iterator(): ");
        for(int val : arr) {
            System.out.print(val+"\t");
        }
    }
}
