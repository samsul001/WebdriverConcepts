package com.Test.Part2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import org.sikuli.natives.SysUtil;
import org.testng.annotations.Test;

public class Practice3 {
	
	public static ArrayList<Integer> removeDupFromArray(int a[]){
		HashSet<Integer> removeDup = new HashSet<Integer>();
		for(int val:a) {
			removeDup.add(val);
		}
		ArrayList<Integer> al = new ArrayList<Integer>(removeDup);
		Collections.sort(al);
		return al;
	}
	
	//@Test
	public void removeDupElementsFromArray() {
		int a[] = {10,20,30,40,10,40,40,30,50};
		System.out.println("Elements stored in Array: "+removeDupFromArray(a));
	}
	
	public static void linearSearch(int a[],int key) {
		boolean flag = false;
		for(int i=0;i<a.length;i++) {
			if(a[i]==key) {
				System.out.println("Element found at: "+i);
				flag = true;
			}
		}
		if(flag=false) {
			System.out.println("Element not found...!");
		}
	}
	
	//@Test
	public void linearSearchAlgorithm() {
		int arr[]= {10,20,30,40,50};
		int key =40;
		linearSearch(arr, key);
	}
	
	public static void binarySearch(int a[],int l, int h,int key) {
		boolean flag = false;
		while(l<=h) {
			int mid =(l+h)/2;
			
			if(a[mid]==key) {
				System.out.println("Element found at: "+mid);
				flag=true;
				break;
			}
			
			if(a[mid]>key) {
				h=mid-1;
			}
			if(a[mid]<key) {
				l=mid+1;
			}
		}
		if(flag=false) {
			System.out.println("Element not found...!");
		}
	}
	
	//@Test
	public void binarySearchAlgorithm() {
		int arr[]= {1,2,3,5,7,9,10,11,13,15};
		int l=0;
		int h=arr.length-1;
		int key = 9;
		binarySearch(arr, l, h, key);
	}
	
	public static void swappNum(int a, int b) {
		int t=a;
		a=b;
		b=t;
		
		System.out.println(a+" "+b);
	}
	//@Test
	public void swappuingNumber() {
		int a = 10;
		int b = 20;
		swappNum(a, b);
	}
	
	public static int reverseNum(int num) {
		int rev=0;
		while(num != 0) {
			rev = rev*10 + num%10;
			num = num/10;
		}
		return rev;
	}
	//@Test
	public void reverseNumberProgram() {
		System.out.println("reverse number of "+"1234 is :"+reverseNum(1234));
	}
	
	public static void reverseintWithStringBuffer(int num) {
		StringBuffer sb = new StringBuffer(String.valueOf(num));
		System.out.println(sb.reverse());
	}
	
	//@Test 
	public void reverseNumWithStrBuffer() {
		reverseintWithStringBuffer(4569);
	}
	
	public static void reverseNumWithStringBuilder(int num) {
		StringBuilder sbl = new StringBuilder();
		sbl.append(num);
		System.out.println(sbl.reverse());
	}
	
	//@Test
	public void reverseNumber() {
		reverseNumWithStringBuilder(1234);
	}
	
	public static void reverseStringWithAlogorithm(String str) {
		String rev = "";
		int len = str.length();
		
		for(int i=len-1;i>=0;i--) {
			rev = rev + str.charAt(i);
		}
		System.out.println(rev);
	}
	
	public static StringBuffer reverseStringwithStringBuffer(String str) {
		StringBuffer sb = new StringBuffer(str);
		return sb.reverse();
	}
	
	public static void reverseStringWithStrBuilder(String str) {
		StringBuilder sbl = new StringBuilder();
		sbl.append(str);
		System.out.println(sbl.reverse());
	}
	
	
	//@Test
	public void reverseString() {
		reverseStringWithAlogorithm("abcd");
		System.out.println(reverseStringwithStringBuffer("alam"));
		reverseStringWithStrBuilder("faleela");
	}
	
	public static void palindromeNumber(int num) {
		int original_num = num;
		int rev = 0;
		while(num != 0) {
			rev = rev*10 + num%10;
			num = num/10;
		}
		
		if(rev==original_num) {
			System.out.println(original_num+" is a palindrome number");
		}
		else {
			System.out.println(original_num+" is not a palindrome number");
		}
	}
	
	public static void palindromeString(String str) {
		String original_str = str;
		String rev = "";
		int len = str.length();
		
		for(int i=len-1;i>=0;i--) {
			rev = rev+str.charAt(i);
		}
		
		if(rev.equals(original_str)) {
			System.out.println(str+" is a palindrome String");
		}
		else {
			System.out.println(str+" is not a palindrome String");
		}
	}
	
	//@Test
	public void palindromePrograms() {
		palindromeNumber(1234321);
		palindromeString("samas");
	}
	
	public static void digitsCount(int num) {
		int count =0;
		while(num !=0) {
			num=num/10;
			count = count+1;
		}
		System.out.println(count);
	}
	
	public static void evenOddDigitsCount(int num) {
		int evenNum =0;
		int oddNum =0;
		
		while(num !=0) {
			int rem = num%10;
			if(rem%2==0) {
				evenNum = evenNum+1;
			}
			else {
				oddNum = oddNum+1;
			}
			num=num/10;
		}
		System.out.println("Even count digits: "+evenNum);
		System.out.println("Odd count digits: "+oddNum);
	}
	
	public static void sumOfDigits(int num) {
		int sum = 0;
		while(num != 0) {
			sum = sum+num%10;
			num=num/10;
		}
		System.out.println(sum);
	}
	
	//@Test
	public void digitsProgram() {
		digitsCount(900);
		evenOddDigitsCount(12355978);
		sumOfDigits(2458);
	}
	
	public static void largestNum(int num1, int num2, int num3) {
		if((num1>num2)&&(num1>num3)) {
			System.out.println(num1+" is a greatest number");
		}
		if((num2>num1)&&(num2>num3)) {
			System.out.println(num2+" is a greatest number");
		}
		if((num3>num1)&&(num3>num2)) {
			System.out.println(num3+" is a greatest number");
		}
	}
	
	//@Test
	public void largestOfThreeNumber() {
		largestNum(111, 5, 19);
	}
	
	public static void fibonacciSeries(int num1, int num2) {
		int sum;
		for(int i=0;i<=5;i++) {
			sum = num1+num2;
			num1=num2;
			num2=sum;
			System.out.println(" "+sum);
		}
	}
	//@Test
	public void fibonacciSeriesProgram() {
		fibonacciSeries(1, 2);
	}
	
	public static void isPrimeNumber(int num) {
		int count =0;
		if(num>1) {
			for(int i=1;i<=num;i++) {
				if(num%i == 0) {
					count=count+1;
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
			System.out.println(num+" is not a prime number");
		}
	}
	
	//@Test
	public void primeNumber() {
		isPrimeNumber(132);
	}
	
	public static void factorialOfNumber(int num) {
		int factorial = 1;
		for(int i=num;i>=1;i--) {
			factorial=factorial*i;
		}
		System.out.println("factorial of "+num+" is "+factorial);
	}
	
	//@Test
	public void factorial() {
		factorialOfNumber(5);
	}
	
	public static void sumOfElementsInArray(int a[]) {
		int sum=0;
		for(int i=0;i<a.length;i++) {
			sum=sum+a[i];
		}
		System.out.println("Sum of elements in array: "+sum);
	}
	
	public static void sumOfElementsInArrayWithForEach(int a[]) {
		int sum=0;
		for(int val:a) {
			sum=sum+val;
		}
		System.out.println("Sum of elements in array: "+sum);
	}
	
	public static void evenOddNumInArray(int a[]) {
		int evenNum=0;
		int oddNum=0;
		
		for(int i=0;i<a.length;i++) {
			if(a[i]%2 == 0) {
				evenNum =evenNum+1;
			}
			else {
				oddNum=oddNum+1;
			}
		}
		System.out.println("Even number count: "+evenNum);
		System.out.println("Odd number count: "+oddNum);
	}
	
	public static void evenOddNumInArrayWithForEach(int a[]) {
		int evenNum = 0;
		int oddNum = 0;
		
		for(int val:a) {
			if(val%2 == 0) {
				evenNum=evenNum+1;
			}
			else {
				oddNum=oddNum+1;
			}
		}
		
		System.out.println("Even number count: "+evenNum);
		System.out.println("Odd number count: "+oddNum);
	}
	
	public static void arraysAreEqual(int a[], int b[]) {
		boolean flag = true;
		
		if(a.length == b.length) {
			for(int i=0;i<a.length;i++) {
				if(a[i] != b[i]) {
					flag =false;
				}
			}
			if(flag = true) {
				System.out.println("arrays are equal");
			}
			else {
				System.out.println("arrays are not equal");
			}
		}
		else {
			System.out.println("arrays are not equal");
		}
	}
	
	
	public static void findMissingEleInArray(int a[], int range) {
		int sum1=0;
		for(int val:a) {
			sum1 = sum1+val;
		}
		int sum2=0;
		for(int i=1;i<=range;i++) {
			sum2 = sum2+i;
		}
		int missingEle = sum2-sum1;
		System.out.println("Missing element from Array: "+missingEle);
	}
	
	public static void findMaxMinElementFromArray(int a[]) {
		int max = a[0];
		int min = a[0];
		
		for(int i=1;i<a.length;i++) {
			if(a[i]>max) {
				max=a[i];
			}
			if(a[i]<min){
				min=a[i];
			}
		}
		System.out.println("Max element in the array: "+max);
		System.out.println("Min element in the array: "+min);
	}
	
	public static void findDuplicateEleInArray(int a[]) {
		boolean flag = true;
		
		for(int i=0;i<a.length;i++) {
			for(int j=i+1;j<a.length;j++) {
				if(a[i]==a[j]) {
					System.out.println("Duplicate element in array: "+a[i]);
					flag=true;
				}
			}
		}
		if(flag=false) {
			System.out.println("Duplicate element is not found...!");
		}
	}
	
	public static HashSet removeDuplicateElementFromArray(Object a[]) {
		HashSet removeDup = new HashSet();
		for(Object val:a) {
			removeDup.add(val);
		}
		return removeDup;
	}
	
	public static void linearSearch1(int a[],int key) {
		boolean flag = false;
		for(int i=0;i<a.length;i++) {
			if(a[i]==key) {
				System.out.println("Element is found at: "+i);
				flag =true;
			}
		}
		if(flag=false) {
			System.out.println("Element is not found..!!");
		}
	}
	
	public static void binarySearch1(int a[], int key) {
		boolean flag = false;
		int l=0;
		int h = a.length-1;
		while(l<=h) {
			int mid = (l+h)/2;
			
			if(a[mid]==key) {
				System.out.println("Element is found at: "+mid);
				flag = true;
				break;
			}
			
			if(a[mid]<key) {
				l=mid+1;
			}
			
			if(a[mid]>key) {
				h=mid-1;
			}
		}
		if(flag = false) {
			System.out.println("Element is not found...!");
		}
	}
	
	
	@Test
	public void arrayPrograms() {
		int arr[] = {1,3,4,7,8,1};
		int arr1[] = {1,4,7,5,8,12,33};
		int arr2[] = {1,2,4,5,6};
		Object arr3[] = {"String",1,2,1.255,'a','a',2}; 
		//sumOfElementsInArray(arr);
		//sumOfElementsInArrayWithForEach(arr);
		evenOddNumInArray(arr);
		evenOddNumInArrayWithForEach(arr1);
		arraysAreEqual(arr, arr1);
		findMissingEleInArray(arr2, 6);
		findMaxMinElementFromArray(arr1);
		findDuplicateEleInArray(arr);
		System.out.println(removeDuplicateElementFromArray(arr3));
		linearSearch1(arr, 8);
		binarySearch1(arr2, 6);
	}
	
	

}
