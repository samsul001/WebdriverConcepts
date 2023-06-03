package JavaStringPrograms;

import java.util.Arrays;

public class StringPrograms {

	public static void main(String[] args) {
		int count =countCharctersInAString("Samsul Alam");
		System.out.println(count);
		
		int punCount = countPunctuationsInString("Fathima ! you love me ?, I actually love you !, (Falee chellam) ");
		System.out.println(punCount);
		
		countVowelsConsonant("Samsul falee");
		
		compareString("samsul", "samsul");
		
		anagramOfString("alqam", "qmala");

	}
	
	public static void anagramOfString(String str1, String str2) {
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		if(str1.length() != str2.length()) {
			System.out.println("These two strings are not anagram");
		}
		else {
			char[] string1 = str1.toCharArray();
			char[] string2 = str2.toCharArray();
			
			Arrays.sort(string1);
			Arrays.sort(string2);
			
			if(Arrays.equals(string1, string2)) {
				System.out.println("These two strings are an anagram");
			}
			else {
				System.out.println("These two strings are not an anagram");
			}
		}
	}
	
	public static void compareString(String str1, String str2) {
		boolean flag =false;
		flag = str1.equals(str2);
		
		if(flag = true) {
			System.out.println(str1+" , "+str2+" are equal");
		}
		else {
			System.out.println(str1+" , "+str2+" are not equal string");
		}
	}
	
	public static int countCharctersInAString(String str) {
		int count = 0;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i) != ' ') {
				count = count+1;
			}
		}
		return count;
	}
	
	public static int countPunctuationsInString(String str) {
		int count =0;
		for(int i=0;i<str.length();i++) {
			if((str.charAt(i)=='!') || (str.charAt(i)=='@') || (str.charAt(i)=='(') || (str.charAt(i)=='(')
					|| (str.charAt(i)==')') || (str.charAt(i)==':') || (str.charAt(i)==';') || (str.charAt(i)=='\'')
					|| (str.charAt(i)=='\"') || (str.charAt(i)==',') || (str.charAt(i)=='.') || (str.charAt(i)=='?')) {
				count = count+1;
			}
		}
		return count;
	}
	
	public static void countVowelsConsonant(String str) {
		int vCount = 0;
		int cCount = 0;
		str = str.toLowerCase();
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='a' || str.charAt(i)=='e' || str.charAt(i)=='i' || str.charAt(i)=='o' || str.charAt(i)=='u') {
				vCount = vCount+1;
			}
			
			else if((str.charAt(i)> 'a') && (str.charAt(i)<='z')) {
				cCount = cCount+1;
			}
		}
		System.out.println("vowels count in the String: "+vCount);
		System.out.println("Consonant count in the string: "+cCount);
	}

}
