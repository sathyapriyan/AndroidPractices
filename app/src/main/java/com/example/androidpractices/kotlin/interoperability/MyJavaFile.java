package com.example.androidpractices.kotlin.interoperability;

public class MyJavaFile {
    public static void main(String[] args) {

        int sum = MyKotlinFileKt.addNumbers(3, 4);
        System.out.println("Printing sum from Java file :" + sum);
    }

    public static int getArea(int l, int b) {
        return l * b;
    }
}
