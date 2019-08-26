package com.google.program;

public class Welcome2 {
	public static void main(String[] args) {
		System.out.println("Hello, World");
		displaytotal();
	}
	public static int total(int sal1, int sal2)	{
		return sal1+sal2;
	}
	public static void displaytotal() {
		System.out.println(total (5000,7000));
	}

}
