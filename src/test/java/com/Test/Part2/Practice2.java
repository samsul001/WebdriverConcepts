package com.Test.Part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

import org.testng.annotations.Test;

public class Practice2 {
	
	//@Test
	public void factorial() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int num = sc.nextInt();
		
		int factorial = 1;
		
		for(int i=1;i<=num;i++) {
			factorial = factorial *i;
		}
		System.out.println("factorial of "+num+" is "+factorial);
	}
	
	//@Test
	public void sumOfElementsInArray() {
		int a[] = {10,20,30,40,50};
		int len = a.length;
		int sum =0;
		
		for(int i=0;i<len;i++) {
			sum = sum+a[i];
		}
		System.out.println("sum of elements in array: "+sum);
	}
	
	//@Test
	public void sumOfEleArray() {
		int a[] = {10,20,30,40,50};
		int sum =0;
		
		for(int val:a) {
			sum=sum+val;
		}
		System.out.println("sum of elements in array: "+sum);
	}
	
	//@Test
	public void evenOddNumInArray() {
		int a[] = {10,2,3,41,50,11};
		int evenNum =0;
		int oddNum =0;
		
		for(int val:a) {
			if(val%2 ==0) {
				evenNum =evenNum+1;
			}
			else if(val%2 ==1) {
				oddNum = oddNum+1;
			}
		}
		System.out.println("even numbers in array: "+evenNum);
		System.out.println("odd numbers in array: "+oddNum);
	}
	
	//@Test
	public void arraysAreEqualOrNot() {
		int a[] = {10,2,3,41,50,11};
		int b[] = {10,2,3,40,50,11};
		
		boolean status = Arrays.equals(a, b);
		
		if(status == true) {
			System.out.println("Arrays are equal");
		}
		else {
			System.out.println("Arrays are not equal");
		}
	
	}
	
	//@Test
	public void arraysAreEqualOrNo1t() {
		int a[] = {10,2,3,40,50,11};
		int b[] = {10,2,3,40,50,11};
		
		boolean status = true;
		
		if(a.length == b.length) {
			for(int i=0;i<a.length;i++) {
				if(a[i] != b[i]) {
					status =false;
				}
			}
		}		
		else {
			status =false;
		}		
		if(status == true) {
			System.out.println("Arrays are equal");
		}
		else {
			System.out.println("Arrays are not equal");
		}
	
	}
	
	//@Test
	public void findingMissingNumberOfArray() {
		int a[] = {1,2,3,5,6};
		
		int sum1 = 0;
		int sum2 = 0;
		
		for(int i:a) {
			sum1 = sum1+i;
		}
		System.out.println("total sum of elements in array: "+sum1);
		
		for(int i=1;i<=6;i++) {
			sum2 = sum2+i;
		}
		
		System.out.println("missing element from array "+(sum2-sum1));
	}
	
	//@Test
	public void maxMinEleInArray() {
		int a[] = {12,41,13,201,25,25,1};
		
		int max = a[0];
		int min = a[0];
		
		for(int i=1;i<a.length;i++) {
			if(a[i]>max) {
				max=a[i];
			}
			if(a[i]<min) {
				min=a[i];
			}
		}
		
		System.out.println("max element in array: "+max);
		System.out.println("min element in array: "+min);
	}
	
	//@Test
	public void findDuplicateEleInArray() {
		int a[] = {10,11,10,12,11,13,14,12};
		int len = a.length;
		boolean flag = false;
		
		for(int i=0;i<len;i++) {
			for(int j=i+1;j<len;j++) {
				if(a[i] == a[j]) {
					System.out.println("duplicate element in array: "+a[i]);
					flag = true;
				}
			}
		}
		if(flag=false) {
			System.out.println("duplicate elements not present in Array");
		}
	}
	
	//@Test
	public void identifyDuplicatesElementUsingHashSet() {
		String b[] = {"JAVA","C","C++","SWIFT","C","JAVASCRIPT","GOLANG","C++"};
		
		HashSet lang = new HashSet();
		ArrayList lang1 = new ArrayList();
		
		for(String val:b) {
			lang.add(val);
		}
		System.out.println(lang);
		
		for(String val:b) {
			lang1.add(val);
		}
		System.out.println(lang1);
	}
	
	public static HashSet removeDuplicates(int a[]) {
		HashSet removeDup = new HashSet();
		for(int val:a) {
			removeDup.add(val);
		}
		//System.out.println("elements stored in array: "+removeDup);
		return removeDup;
	}
	
	@Test
	public void removeDuplicatesElementFromArray() {
		int a[] = {10,11,12,13,10,12,15};
		
		System.out.println(removeDuplicates(a));
	}
		
	
	
	//@Test
	public void linearSearch() {
		int a[] = {10,20,30,40,50,60,70,150,50,10};
		
		int searchEle = 50;
		boolean flag = false;
		int len = a.length;
		
		for(int i=0;i<len;i++) {
			if(a[i]==searchEle) {
				System.out.println("Element found at "+i+"th position");
				flag = true;
			}
		}
		if(flag=false) {
			System.out.println("Element is not found");
		}
	}
	
	//@Test
	public void binarySearchAlgorithm() {
		//Array should be in sorted order
		//lower value and higher value should be noted down and mid value should be calculated by using them.
		//if key value is greater than mid => l=mid+1;
		//if key value is lesser than mid => h=mid-1
		
		int a[] = {1,2,3,4,5,6,7,8,9,10};
		int len = a.length;
		int l = 0;
		int h = len-1;
		int key = 5;
		boolean flag = false;
		while(l<=h) {
			int mid = (l+h)/2;
			
			if(a[mid]==key) {
				System.out.println("Element found at "+mid);
				flag =true;
				break;
			}
			
			if(a[mid]>key) {
				l=mid+1;
			}
			
			if(a[mid]<key) {
				h=mid-1;
			}
		}
		
		if(flag=false) {
			System.out.println("Element is not found!");
		}
	}
	
	//@Test
	public void bubbleSortUsingLogic() {
		int a[] = {2,4,14,5,1,6,21,2,10,3,81,51};
		int len = a.length;
		System.out.println("Before sorting element: "+Arrays.toString(a));

		for(int i=0;i<len;i++) {
			for(int j=0;j<len-1;j++) {
				if(a[j] > a[j+1]) {
					int temp =a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		System.out.println("After sorting element: "+Arrays.toString(a));

	}



}
