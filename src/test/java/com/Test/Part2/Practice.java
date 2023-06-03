package com.Test.Part2;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Practice {
	
	//@Test
	public void swappingTwoNumber() {

	Scanner sc = new Scanner(System.in);
	System.out.println("Enter number1: ");
	int num1 = sc.nextInt();
	System.out.println("Enter number2: ");
	int num2 = sc.nextInt();

	System.out.println("num 1 = "+num1);
	System.out.println("num 2 = "+num2);

	int t;

	t = num1;
	num1 = num2;
	num2 = t;

	System.out.println("after swapping number");

	System.out.println("num 1 = "+num1);
	System.out.println("num 2 = "+num2);

	}
	
	//@Test
	public void reverseNumberAlgorithm() {

	Scanner sc = new Scanner(System.in);
	System.out.println("Enter a number: ");
	int num = sc.nextInt();

	int rev =0;

	while(num != 0) {

	rev =rev*10 + num%10;
	num =num/10;

	}

	System.out.println("reverse number: "+rev);

	}

	//@Test
	public void reverseNumberUsingStrBuffer() {

	Scanner sc = new Scanner(System.in);
	System.out.println("Enter a number: ");
	int num = sc.nextInt();

	StringBuffer sb = new StringBuffer(String.valueOf(num));
	StringBuffer rev = sb.reverse();

	System.out.println("reverse number: "+rev); 

	}

	//@Test
	public void reverseNumberStringBuilder() {

	Scanner sc = new Scanner(System.in);
	System.out.println("Enter a number: ");
	int num = sc.nextInt();

	StringBuilder sb = new StringBuilder();
	sb.append(num);
	StringBuilder rev = sb.reverse();

	System.out.println("reverse number: "+ rev);

	}
	
	//@Test
	public void reverseStringAlgorithm() {

	Scanner sc = new Scanner(System.in);
	System.out.println("Enter a String: ");
	String str = sc.next();

	String rev ="";

	int len = str.length();

	for(int i=len-1;i>=0;i--) {

	rev = rev+str.charAt(i);

	}

	System.out.println("reverse string: "+ rev);

	}
	
	//@Test
	public void reverseStringUsingStringBuffer() {

	Scanner sc = new Scanner(System.in);
	System.out.println("Enter a String: ");
	String str = sc.next();

	StringBuffer sb = new StringBuffer(str);
	StringBuffer rev = sb.reverse();

	System.out.println("After reverse String: " + rev);

	}
	
	//@Test
	public void reverseStringUsingStringBuilder() {

	Scanner sc = new Scanner(System.in);
	System.out.println("Enter a String: ");
	String str = sc.next();

	StringBuilder sbl = new StringBuilder();
	sbl.append(str);
	StringBuilder rev = sbl.reverse();

	System.out.println("After reverse String: " + rev);

	}
	
	//@Test
	public void palindromeNumber() {

	Scanner sc = new Scanner(System.in);
	System.out.println("Enter a number: ");
	int num = sc.nextInt();

	int original_num = num;

	int rev=0;

	while(num !=0) {

	rev = rev*10 + num%10;
	num = num/10;

	}

	if(rev == original_num) {

	System.out.println(rev+" is a palindrome number");

	}

	else {

	System.out.println(rev+" is not a palindrome number");

	}

	}
	
	//@Test
	public void palindromeString() {

	Scanner sc = new Scanner(System.in);
	System.out.println("Enter a String: ");
	String str = sc.next();

	String original_string = str;

	String rev ="";

	int len = str.length();

	for(int i=len-1;i>=0;i--) {

	rev = rev + str.charAt(i);

	}

	if(rev.equals(original_string)) {

	System.out.println(rev + " is palindrom string");

	}

	else {

	System.out.println(rev + " is not palindrom string");

	}

	}
	
	//@Test
	public void countNoOfDigits() {

	Scanner sc = new Scanner(System.in);
	System.out.println("Enter a number: ");
	int num = sc.nextInt();

	int original_num = num;

	int count =0;

	while(num !=0) {

	num = num/10;
	count = count+1;

	}

	System.out.println("digits count of "+ original_num +" is"+count);

	}
	
	//@Test
	public void countEvenOddNum() {

	Scanner sc = new Scanner(System.in);
	System.out.println("Enter a Number: ");
	int num = sc.nextInt();

	int evenNum = 0;
	int oddNum = 0;

	while(num !=0) {

	int rem = num%10;

	if(rem%2 ==0) {

	evenNum = evenNum +1;

	}

	else {

	oddNum = oddNum +1;

	}

	num = num/10;

	}
	
	System.out.println("total evenNum: "+evenNum);
	System.out.println("total oddNum: "+oddNum);

	}
	
	//@Test
	public void sumOfDigits() {

	Scanner sc = new Scanner(System.in);
	System.out.println("Enter a Number: ");
	int num = sc.nextInt();

	int temp_num = num;

	int sum=0;

	while(num !=0) {

	sum = sum + num%10;
	num = num/10;

	}

	System.out.println("sum of digits of "+ temp_num + " is "+sum);

	}
	//@Test
	public void fibonacciSeries() {

	Scanner sc = new Scanner(System.in);
	System.out.println("Enter a Number: ");
	int num1 = sc.nextInt();
	System.out.println("Enter a Number: ");
	int num2 = sc.nextInt();

	int sum =0;

	for(int i=1;i<=10;i++) {

	sum = num1 + num2;
	num1 = num2;
	num2 = sum;

	System.out.print(sum+ " , ");

	}

	}
	
	//@Test
	public void isPrimeNumber() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Number: ");
		int num = sc.nextInt();
		
		int count =0;
		
		if(num > 1) {
			for(int i=1;i<=num;i++) {
				if(num%i == 0) {
					count = count+1;
				}
			}
			if(count == 2) {
				System.out.println(num+" is a prime number");
			}
			else {
				System.out.println(num+" is not a prime number");
			}
		}
		else {
			System.out.println(num+" is not prime number");
		}
	}
	
	@Test
	public void isPrimeNumber1() {

	Scanner sc = new Scanner(System.in);
	System.out.println("Enter a number: ");
	int num = sc.nextInt();

	int count =0;

	if(num >1) {

	for(int i=1;i<=num;i++) {

	if(num%i == 0) {

	count = count+1;

	}

	}
	if(count == 2) {

	System.out.println(num+" is a prime number");

	}

	else {

	System.out.println(num+ " is not a prime number");

	}

	}

	else {

	System.out.println(num+ " is not a prime number");

	}

	}
}
