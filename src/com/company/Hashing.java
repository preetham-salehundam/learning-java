package com.company;

public class Hashing {
    public static void main(String[] args) {
        int h = 63;
         h ^= (h >>> 20) ^ (h >>> 12);

        System.out.println(h ^ (h >>> 7) ^ (h >>> 4));

    }
}
