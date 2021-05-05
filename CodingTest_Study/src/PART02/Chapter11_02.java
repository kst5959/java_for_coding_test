package PART02;

import java.util.Scanner;

public class Chapter11_02 {

	public static String S;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		S = sc.nextLine();
		int sum = 0;
		int[] arr = new int[S.length()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(Integer.toString(S.charAt(i) - '0'));
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(i == 0)
			{
				if((arr[i] * arr[i+1]) > (arr[i] + arr[i+1]))
				{
					sum = (arr[i] * arr[i+1]);
				}
				else
				{
					sum = (arr[i] + arr[i+1]);
				}
				i++;
			}
			else
			{
				sum = sum * arr[i];				
			}
		}
		
		System.out.println(sum);
	}

}
