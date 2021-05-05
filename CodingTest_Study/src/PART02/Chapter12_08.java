package PART02;

import java.util.Arrays;
import java.util.Scanner;

public class Chapter12_08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		char[] arr = new char[s.length()];
		int sum = 0;
		for(int i=0; i < s.length(); i++)
		{
			if(s.charAt(i) > '9')
			{
				arr[i] = s.charAt(i);
			}
			else
			{
				sum += s.charAt(i)-'0'; 
			}
		}
		
		Arrays.parallelSort(arr);
		String answer = "";
		for (int i = 0; i < arr.length; i++) 
		{
			if(arr[i] > '9')
			{
				answer += arr[i];
			}
		}
		
		System.out.print(answer);
		System.out.println(sum);
		
	}

}
