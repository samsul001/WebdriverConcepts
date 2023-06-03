package com.Test.Part3;

import java.util.Scanner;

import org.sikuli.natives.SysUtil;
import org.testng.annotations.Test;

public class JavaPrgrms {

	//@Test
	public void findAsciiNumber() {
		char c = 'e';
		int ascii = c;
		int asciiNumber = (int) c;

		System.out.println(ascii);
		System.out.println(asciiNumber);
	}

	//@Test
	public void checkVowelsAndConsonant() {
		char ch = 't';

		if(ch == 'a' ||ch == 'e' ||ch == 'i' ||ch == 'o' ||ch == 'u' ) {
			System.out.println(ch +" is vowel");
		}
		else {
			System.out.println(ch +" is consonant");
		}

		switch(ch) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
			System.out.println(ch + " is vowel");
			break;
		default:
			System.out.println(ch + " is consonant");
		}
	}

	//@Test
	public void leapYear() {
		//Year should be divisible by 4
		//if century year, it should be divisible by 100 and 400

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter year: ");
		int year = sc.nextInt();

		boolean leap=false;

		if(year%4 == 0) {
			if(year%100 ==0) {
				if(year%400 == 0) {
					leap=true;
				}
				else {
					leap=false;
				}	
			}
			else {
				leap=true;
			}
		}
		else {
			leap=false;
		}
		if(leap) {
			System.out.println(year+" is leap year");
		}
		else {
			System.out.println(year+" is not a leap year");
		}

	}

	//@Test
	public void isNumberNegativeOrPositive() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter number: ");
		int intNum=sc.nextInt();
		//double doubleNum = sc.nextDouble();

		if(intNum<0) {
			System.out.println(intNum+" is negative value");
		}
		else if(intNum>0) {
			System.out.println(intNum+" is positive value");
		}
		else {
			System.out.println(intNum+" is ZERO");
		}
	}

	//@Test
	public void alphabetCheck() {
		char c = '&';

		if((c>='a' && c<='z') || (c>='A' && c<='Z')) {
			System.out.println(c+" is alphabet");
		}
		else {
			System.out.println(c+" is not alphabet");
		}
	}

	//@Test
	public void sumOfNaturalNumbers() {

		//approach 1 - For loop
		int num = 100;
		int sum1 = 0;

		for(int i=1;i<=num;i++) {
			sum1=sum1+i;
		}
		System.out.println("sum of natural numbers till 100: "+sum1);

		//approach 2 - While Loop
		int sum2 =0;
		int i=1;
		while(i<=100) {
			sum2=sum2+i;
			i++;
		}	
		System.out.println("Sum of narural numbers till 100: "+sum2);	
	}

	//@Test
	public void TableMultiplication() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number");
		int num = sc.nextInt();

		for(int i=1;i<=10;i++) {
			System.out.println(i+" * "+num+" = "+(num*i));
		}
	}

	//@Test
	public void displayCharUsingLoop() {
		for(char c='a'; c<='z';c++) {
			System.out.print(c+" ");
		}	
	}

	//@Test
	public void powerConcept() {
		//approach 1
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter base = ");
		int base = sc.nextInt();

		System.out.println("Enter exponent = ");
		int exponent = sc.nextInt();

		int result = 1;

		while(exponent != 0) {
			result = result*base;
			exponent--;
		}
		System.out.println("power of "+base+" :"+result);

		//approach2
		System.out.println(Math.pow(3, 2));

	}

	//@Test
	public void isPrimeNumber() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int num=sc.nextInt();
		boolean flag=false;
		for(int i=2; i<=num/2; i++) {
			if(num%i ==0) {
				flag = true;
				break;
			}
		}
		if(!flag) {
			System.out.println(num+" is a prime number");
		}
		else{
			System.out.println(num+" is not a prime number");
		}

	}	

	//@Test
	public void intervalsBetweenPrimeNumbers() {
		//Primer Number should
		// Greater than "1"
		// should have 2 factors, 1 and by itself

		Scanner sc = new Scanner(System.in);

		System.out.println("number start from: ");
		int low = sc.nextInt();

		System.out.println("number ends with: ");
		int high = sc.nextInt();


		while(low < high) {
			boolean flag =false;
			for(int i=2; i< low/2; i++) {
				if(low%i == 0) {
					flag=true;
					break;
				}
			}
			if(!flag) {
				System.out.println(low);
			}
			low++;
		}
	}

	//@Test
	public void armstrongNumber() {
		//Armstrong number is the number in any given number base, which forms the same number when each of it's
		//digits is raised to the power of number of digits in the number.

		int num =370;
		int original_num=num;

		double result =0;

		while(num !=0) {

			int rem = num%10;			
			result = result+Math.pow(rem, 3);
			num=num/10;

		}
		if(original_num == result) {
			System.out.println(original_num+" is an armstrong number");
		}
		else {
			System.out.println(original_num+" is not an armstrong number");
		}
	}

	//@Test
	public void armstrongNumberBetweenIntervals() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a number: ");
		int num1 = sc.nextInt();

		System.out.println("Enter a number: ");
		int num2 = sc.nextInt();

		for(int i=num1;i<num2;i++) {
			int check,rem,sum=0;
			check =i;
			while(check != 0) {
				rem = check % 10;
				sum = sum+(rem*rem*rem);
				check=check/10;
			}
			if(sum == i) {
				System.out.println(""+i+" is an armstrong number");
			}
		}

	}

	//@Test
	public void factorsOfNumber() {
		int num = 60;

		for(int i=1;i<=60;i++) {
			if(num%i == 0) {
				System.out.println(i);
			}
		}
	}

	//@Test
	public void calculator() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter a number: ");
		double num1 = sc.nextDouble();

		System.out.println("Enter a number: ");
		double num2 = sc.nextDouble();

		System.out.println("Enter any charactors: +, -, *, / ");
		char operator = sc.next().charAt(0);

		switch (operator) {
		case '+':
			System.out.println(num1+num2);
			break;

		case '-':
			System.out.println(num1-num2);
			break;
		case '*':
			System.out.println(num1*num2);
			break;
		case '/':
			System.out.println(num1/num2);
			break;

		default:
			System.out.println("Select valid operator");
			break;
		}

	}
	
	//@Test
	public void checkNumberExpressedAsSumOfPrimeNum() {
		int num=34;
		boolean flag=false;
		for(int i=2;i<=num/2;i++) {
			if(isPrimeNum(i)) {
				if(isPrimeNum(num-i)) {
					System.out.println(num+" = "+i+" + "+(num-i));
					flag=true;
				}
			}
		}
		if(!flag) {
			System.out.println("the given number can not be expressed as the sum of Two Prime numbers");
		}
	}
	public boolean isPrimeNum(int num) {
		boolean isPrime=true;
		for(int i=2;i<=num/2;i++) {
			if(num%i == 0) {
				isPrime=false;
				break;
			}
		}	
		return isPrime;
	}
	
	//@Test
	public void naturalNumberSumUsingRecursion(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int nat_num = sc.nextInt();
		
		int sum = addNum(nat_num);
		System.out.println("Sum is: "+sum);
		
	}
	public int addNum(int num) {
		
		if(num != 0) {
			return num + addNum(num-1);
		}
		else {
			return num;
		}
	}
	
	//@Test
	public void  factorialRecursive() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int num = sc.nextInt();
		
		System.out.println("facctorial of "+num+" is "+multiplyNum(num));
	}
	
	public int multiplyNum(int num) {
		if(num >=1) {
			return num = num * multiplyNum(num-1);
		}
		else {
			return 1;
		}
	}
	
	//@Test
	public void binaryToDecimal() {
		long num=1001100111;
		int decimal = convertBinaryToDecimal(num);
		System.out.println(decimal);
	}
	
	public int convertBinaryToDecimal(long binaryNum) {
		int decimal_num = 0;
		long reminder;
		int i=0;
		while(binaryNum >0) {
			reminder = binaryNum%10;
			decimal_num += reminder*Math.pow(2, i);
			binaryNum=binaryNum/10;
			i++;
		}
		return decimal_num;
	}
	
	//@Test
	public void decimalToBinary() {
		int num = 156;
		long binary = covertDecimalToBinary(num);
		System.out.println(binary);
	}
	
	public long covertDecimalToBinary(int decimal) {
		long binaryNumber = 0;
		int i=1;
		int reminder=1;
		
		while(decimal != 0) {
			reminder = decimal%2;
			decimal = decimal/2;
			binaryNumber += reminder*i;
			i *=10;
		}
		return binaryNumber;
	}
	
	@Test
	public void octalToDecimal() {
		int octalNum = 116;
		System.out.println(convertOctalToDecimal(octalNum));
	}
	public int convertOctalToDecimal(int octalNum) {
		
		int decimalNumber =0;
		int i = 0;
		int remainder;
		while(octalNum >0) {
			remainder = octalNum%10;
			decimalNumber += remainder * Math.pow(8, i);
			octalNum = octalNum/10;
			i++;			
		}
		return decimalNumber;
		
	}
	
	@Test
	public void decimalToOctal() {
		int num = 100;
		System.out.println(convertDecimalToOctal(num));
	}
	public int convertDecimalToOctal(int decimal) {
		int octalNum = 0;
		int rem;
		int i=1;
		while(decimal >0) {
			rem = decimal%8;
			decimal = decimal/8;
			octalNum += rem*i;
			i *=10;			
		}
		return octalNum;
	}


}
