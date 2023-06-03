package com.Test.Part2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

public class JavaPrograms {
	
	//@Test(description = "swapping numbers")
	public void swappingNumbers() {
		
		//1.Swapping Numbers:
		// Interchanges values of two variables
		
		int a=10, b=20;		
		System.out.println("before swapping value are: "+a+"  "+b);		
		int t; //Third variable		
		t=a;
		a=b;
		b=t;		
		System.out.println("after swapping value are: "+a+"  "+b);		
	}
	
	//@Test(description = "reverse string using algorithm")
	public void reverseNumberUsingAlgorithm() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number: ");
		int num = sc.nextInt();
		
		int rev=0;
		
		while(num!=0) {
			rev = rev*10 + num%10;
			num=num/10;
		}
		System.out.println("Reverse Number: "+ rev);
	}
	
	//@Test(description = "reverse number using StringBuffer")
	public void reverseNumberUsingStrBuffer() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter number: ");
		int num = sc.nextInt();
		
		StringBuffer sb = new StringBuffer(String.valueOf(num));
		StringBuffer rev = sb.reverse();
		System.out.println("Reverse Number: "+ rev);		
	}
	
	//@Test(description = "reverse number using StringBuilder")
	public void reverseNumberUsingStrBuilder() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int num = sc.nextInt();
		
		StringBuilder sbl = new StringBuilder();
		sbl.append(num);
		StringBuilder rev = sbl.reverse();
		System.out.println("Reverse Number: "+rev);
	}
	
	//@Test(description = "reverse string using concat")
	public void reverseStringUsingConcat() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String: ");
		String str = sc.next();
		
		String rev = "";
		
		int len = str.length();
		
		for(int i=len-1;i>=0;i--) {
			rev = rev+str.charAt(i);
		}
		System.out.println("Reverse String: "+rev);
	}
	
	//@Test(description = "reverse string using charArray method")
	public void reverseStringCharArray() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String: ");
		String str = sc.next();
		
		String rev = "";
		
		char arr[] = str.toCharArray();
		
		int len = arr.length;
		
		for(int i=len-1;i>=0;i--) {
			rev = rev+str.charAt(i);
		}
		
		System.out.println("reverse string: "+rev);		
		
	}
	
	//@Test(description = "reverse string using String buffer")
	public void reverseStringUsingStringBuffer() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String: ");
		String str = sc.next();
		
		StringBuffer sb = new StringBuffer(str);
		StringBuffer rev = sb.reverse();
		System.out.println("Reverse String: "+rev);
	}
	
	//@Test(description = "palindrome number")
	public void palindromeNumber() {
		//Palindrome number is a number that remains same when its digits are reversed
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number: ");
		int num = sc.nextInt();
		
		int original_num=num;
		
		int rev=0;
		
		while(num!=0) {
			rev = rev*10 + num%10;
			num = num/10;
		}
		
		if(original_num==rev) {
			System.out.println(rev+" is palindrome number");
		}
		else {
			System.out.println(rev+" is not a palindrome number");
		}
	}
	
	//@Test(description = "palindrome String")
	public void palindromeString() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter String");
		String str = sc.next();
		
		String original_Str = str;		
		String rev="";
		
		int len=str.length();
		for(int i=len-1;i>=0;i--) {
			
			rev = rev + str.charAt(i);
			
		}
		if(original_Str==rev) {
			System.out.println(rev+" is palindrome String");
		}
		else {
			System.out.println(rev+" is not palindrome String");
		}
	}
	
	
	//@Test
	public void countNoOfDigitsInNumber() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number: ");
		int num = sc.nextInt();
		
		int count=0;
		
		while(num>0) {
			num=num/10;
			count = count+1;
		}
		System.out.println("Digit count of Number: "+count);
	}
	
	//@Test
	public void countNoOfEvenAndOddNumber() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number: ");
		int num = sc.nextInt();
		
		int evenNum = 0;
		int oddNum = 0;
		
		while(num>0) {
			int rem = num%10;
			if(rem%2==0) {
				evenNum = evenNum+1;
			}
			else {
				oddNum = oddNum+1;
			}
			num=num/10;
		}
		System.out.println("count of even number: "+evenNum);
		System.out.println("count of odd number: "+oddNum);
		
	}
	
	//@Test
	public void sumOfDigits() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Number: ");
		int num = sc.nextInt();
		
		int sum=0;
		
		while(num>0) {
			sum = sum + num%10;
			num=num/10;
		}
		
		System.out.println("Sum of Digits of enter number is: "+ sum);
	}
	
	//@Test
	public void largestOfGivenNumbers() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a Number: ");
		int num1 = sc.nextInt();
		
		System.out.println("Enter a Number: ");
		int num2 = sc.nextInt();
		
		System.out.println("Enter a Number: ");
		int num3 = sc.nextInt();
		
		if(num1>num2 && num1>num3) {
			System.out.println(num1+" is largest number");
		}
		else if(num2>num1 && num2>num3) {
			System.out.println(num2+" is largest number");
		}
		else if(num3>num1 && num3>num2) {
			System.out.println(num3+" is largest number");
		}
	}
	
	//@Test
	public void largestofGivenNumberUsingTernary() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a Number: ");
		int num1 = sc.nextInt();
		
		System.out.println("Enter a Number: ");
		int num2 = sc.nextInt();
		
		System.out.println("Enter a Number: ");
		int num3 = sc.nextInt();
		
		int largest1 = num1>num2 ? num1:num2;
		int largest2 = largest1>num3 ? largest1:num3;
		
		System.out.println("largest number is: "+largest2);
	}
	
	//@Test
	public void fibonacciSeries() {
		//Fibonacci series is a series of numbers in which each number is sum of two preceding numbers
		
		int num1=0, num2=1, sum=0;
		
		System.out.println("Fibonacci series of: "+num1+" , "+num2+" is :");
		
		for(int i=1;i<10;i++) {
			sum = num1+num2;
			num1=num2;
			num2=sum;
			
			System.out.print(" ,"+sum);
		}
	}
	
	//@Test
	public void isPrimeNumber() {
		//Primer Number should
		// Greater than "1"
		// should have 2 factors, 1 and by itself
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int num = sc.nextInt();
		int count =0;
		
		if(num>1) {
			for(int i=1;i<=num;i++) {
				if(num%i==0) {
					count++;
				}
			}
			if(count==2) {
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
	public void randomNumericAndString() {
		
		//Approach1
		Random random = new Random();
		
		int randomNum = random.nextInt(100);
		System.out.println(randomNum);
		
		double randomDouble = random.nextDouble();
		System.out.println(randomDouble);
		
		//Approach2 - Apache commons lang API
		String randomNum1 = RandomStringUtils.randomNumeric(5);
		System.out.println(randomNum1);
		
		String randomString = RandomStringUtils.randomAlphabetic(5);
		System.out.println(randomString);
			
	}
	
	//@Test
	public void factorial() {
		int num = 6;
		int factorial = 1;
		
		for(int i=num;i>=1;i--) {
			factorial = factorial*i;
		}
		
		System.out.println("Factorial of 5 is: "+factorial);
	}
	
	//@Test
		public void sumOfElementsInArray() {
			int a[] = {2,5,6,4,2};
			int sum =0;
			int len = a.length;
			for(int i=0;i<len;i++) {
				sum = sum+a[i];
			}
			System.out.println("sum of Array: "+sum);
		}
		
		//@Test
		public void sumOfEleArray() {
			int a[]= {1,2,3,4,5};
			int sum =0;
			
			for(int value:a) {
				sum=sum+value;
				
			}
			System.out.println("sum of Array: "+sum);
		}
		
		//@Test
		public void evenOddELementInArray() {
			int a[] = {10,29,33,40,50,21};
			int len = a.length;
			
			System.out.println("Even Number...............");
			for(int i=0;i<len;i++) {
				if(a[i]%2 == 0) {
					System.out.println(a[i]);
				}
			}
			System.out.println("Odd Number...............");
			for(int i=0;i<len;i++) {
				if(a[i]%2 != 0) {
					System.out.println(a[i]);
				}
			}
		}
		
		//@Test
		public void evenOddEleInArrayForEach() {
			int a[] = {1,23,65,66,20,21,17};
			
			System.out.println("Even Number.................");
			for(int i:a) {
				if(i%2 == 0) {
					System.out.println(" "+i);
				}
			}
			System.out.println("Odd Number.................");
			for(int i:a) {
				if(i%2 != 0) {
					System.out.println(" "+i);
				}
			}
		}
		
		//@Test
		public void checkArrayAreEqual() {
			//approach1
			int a[] = {10,20,21,30,40};
			int b[] = {10,20,21,32,40};
			
			boolean status =Arrays.equals(a, b);
			System.out.println("Arrays are Equal: "+status);
		}
		
		//@Test
		public void checkArraysAreEqual() {
			int a[] = {10,20,21,30,40};
			int b[] = {10,20,21,32,40};
			
			boolean status = true;
			
			if(a.length == b.length) {
				
				for(int i=0;i<a.length;i++) {
					
					if(a[i] != b[i]) {
						status=false;
					}
				}
			}
			else {
				status = false;
			}
			
			if(status==true) {
			System.out.println("Arrays are equal");
			}
			
			else {
			System.out.println("Arrays are not equal");
			}
		}
		
		//@Test
		public void findingMissingNumInArray() {
			//Arrays should not have duplicates
			//Arrays need not to be in sorted order
			//Arrays should be in a range
			int a[] = {1,2,4,5};
			
			int len = a.length;
			int sum1 =0;
			for(int i=0;i<len;i++) {
				sum1 =sum1+a[i];
			}
			System.out.println("Sum of elements in Array: "+sum1);
			
			int sum2 =0;
			for(int i=0;i<=5;i++) {
				sum2 = sum2+i;
			}
			System.out.println("Sum of range of 5: "+sum2);
			
			
			System.out.println("Missing element from array: "+(sum2-sum1));
			
		}
		
		//@Test
		public void maxMinElementInArray() {
			int a[] = {10,25,101,355,20,1};
			int len = a.length;
			int max = a[0];
			int min = a[0];
			for(int i=1;i<len;i++) {
				if(a[i] > max) {
					max = a[i];
				}
				if(a[i] < min) {
					min = a[i];
				}
			}
			System.out.println("max of element: "+max);
			System.out.println("min of element: "+min);
		}
		
		//@Test
		public void findDuplicateElementsFromArray() {
			String a[] = {"java","python","C","C++","SWIFT","C","java"};
			int len = a.length;
			boolean flag= false;
			for(int i=0;i<len;i++) {
				for(int j=i+1;j<len;j++) {
					if(a[i] == a[j]) {
						System.out.println("Duplicate element found: "+a[i]);
						flag = true;
					}
				}
			}
			if(flag==false) {
				System.out.println("Duplicate element not found");
			}
		}
		
		//@Test
		public void IdentifyDuplicateElementsUsingHashSet() {
			String a[] = {"java","python","C","C","SWIFT","C++","java"};
			
			HashSet <String> lang = new HashSet<String>();
			
			for(String val:a) {
				if(lang.add(val)==false) {
					System.out.println("duplicate element found :"+val);
				}
			}
		}
		
		//@Test
		public void linearSearch() {
			//In Linear search, each an every values will be searched with on element
			int a[] = {10,50,20,30,40,60,50};
			int searchEle = 50;
			int len = a.length;
			boolean flag = false;
			for(int i=0;i<len;i++) {
				if(searchEle == a[i]) {
					System.out.println("Element found at "+i);
					flag =true;
				}
			}
			if(flag==false) {
				System.out.println("Element not found");
			}
		}
		
		//@Test
		public void binarySearchUsingAlgorithm() {
			//Arrays should be in sorted order
			//lower value and higer value should be noted down and mid value will be calculated using them
			//if key value is equal to mid value , mid value will be considered as key
			//if key value is greater than mid value, L = MID+1
			//if key value is lesser than mid value, H = MID-1
			
			int a[] = {1,2,3,4,5,6,7,8,9,10};
			int len = a.length;
			int l = 0;
			int h = len-1;
			boolean flag = false;
			
			int key = 11;
			while(l<=h){
				
				int mid = (l+h)/2;
				
				if(a[mid] == key) {
					System.out.println("Element found at..."+mid);
					flag =true;
					break;				
				}
				if(a[mid] < key) {
					l = mid+1;
				}
				if(a[mid] > key) {
					h = mid-1;
				}
			}
			if(flag==false) {
				System.out.println("Element not found");
			}
		}
		
		//@Test
		public void binarySearhUsingBuiltIn() {
			int a[] = {1,2,3,4,5,6,7,8,9,10};
			System.out.println(Arrays.binarySearch(a, 8));
		}
		
		//@Test
		public void bubbleSortUsingLogic() {
			int a[] = {28,4,14,5,1,6,21,2,10,3,8,5};
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
		
		//@Test
		public void sortingArraysUsingBuiltInMethods() {
			Integer a[] = {28,4,14,5,1,6,21,2,10,3,8,5};
			System.out.println("Before sorting element: "+Arrays.toString(a));
			
			//approach1
			Arrays.sort(a);
			System.out.println("After sorting element using Sort: "+Arrays.toString(a));
			
			//aproach2
			Arrays.parallelSort(a);
			System.out.println("After sorting element using ParallelSort: "+Arrays.toString(a));
			
			//sorting in reverse order
			Arrays.sort(a,Collections.reverseOrder());
			System.out.println("After sorting element using reverse order: "+Arrays.toString(a));
		}
		
		//@Test
		public void removeJunkSpclCharacter() {
			String s = "!@#$$%^&*()&$$ Sam@#$$%sul @#$*!^%##Ala@##$m@@$)(*&Fale@#$ela";
			s= s.replaceAll("[^a-zA-Z0-9]", "");
			System.out.println(s);
			
		}
		
		//@Test
		public void removingTheWhiteSpaces() {
			String s = "Soft ware_ tes  ing_  is_      bes t_ indus try";
			String str= s.replaceAll("\\s", "");
			System.out.println(str);
		}
		
		//@Test
		public void countCharOccurences() {
			String s ="Java for Selenium testing";
			
			int totalCount = s.length();
			int countOfChar = s.replace("e", "").length();
			
			int countOfOccurrences = totalCount - countOfChar;
			
			System.out.println("Count of charcter a occurences are: "+countOfOccurrences);
			
		}
		
		//@Test
		public void countNoOfWordsInAstring() {
			String s ="Java for Selenium testing";
			int len = s.length();
			int count =1;
			for(int i=0; i<len;i++) {
				if((s.charAt(i)==' ') && (s.charAt(i+1) != ' ')) {
					count++;
				}
			}
			System.out.println("Count no of words in String: "+count);
		}
		
		//@Test
		public void reverseEachWordInString() {
			//split the words and store into an String array
			//reverse string of each array element
			String s ="Java for Selenium testing";
			String arr[] =s.split("\\s");
			String reverseString="";
			for(String words:arr) {
				String reverseWords="";
				for(int i=words.length()-1;i>=0;i--) {
					reverseWords=reverseWords+words.charAt(i);
				}
				reverseString=reverseString+reverseWords+" ";
			}
			System.out.println(reverseString);
			
		}
		
		//@Test
		public void reverseEachWordsInStringUsingStringBuffer() {
			//split the words and store into an String array
			//reverse string of each array element
			String s ="Java for Selenium testing";
			String arr[] =s.split(" ");
			String reverseString="";
			for(String words:arr) {
				StringBuffer sb = new StringBuffer(words);
				reverseString= reverseString+sb.reverse().toString()+" ";
			}
			System.out.println(reverseString);
			
		}
		
		//@Test
		public void reverseEachWordsInStringUsingStringBuilder() {
			//split the words and store into an String array
			//reverse string of each array element
			String s ="Java for Selenium testing";
			String arr[] =s.split(" ");
			String reverseString="";
			for(String words:arr) {
				StringBuilder sbl = new StringBuilder(words);
				reverseString= reverseString+sbl.reverse().toString()+" ";
			}
			System.out.println(reverseString);
			
		}
		
		//@Test
		public void readDataFromTextFile() throws IOException {
			//Approach1 FileReader & Buffer Reader
			/*FileReader file = new FileReader("D:\\SeleniumFiles\\ActorsDetails.txt");
			BufferedReader br = new BufferedReader(file);
			
			String str;
			
			while((str=br.readLine())!=null) {
				System.out.println(str);
			}
			br.close(); */
			
			//Approach2 File & Scanner
			/*File f = new File("D:\\SeleniumFiles\\ActorsDetails.txt");
			Scanner sc = new Scanner(f);
			
			while(sc.hasNextLine()) {
				System.out.print(sc.nextLine());
				System.out.println();
			}*/
			
			//Approach3 Delimiter
			File f = new File("D:\\SeleniumFiles\\ActorsDetails.txt");
			Scanner sc = new Scanner(f);
			
			sc.useDelimiter("\\Z");		
			System.out.println(sc.next());
		}
		
		//@Test
		public void writeDataToTextFile() throws IOException {
			FileWriter f = new FileWriter("D:\\SeleniumFiles\\ActorsDetails.txt");
			BufferedWriter bw = new BufferedWriter(f);
			bw.write("Hi I am samsul");
			System.out.println();
			bw.write("Hi I am Alam");
			System.out.println();
			bw.write("Hi I am Murugan");
			bw.close();
			
		}
		
		
		
}
