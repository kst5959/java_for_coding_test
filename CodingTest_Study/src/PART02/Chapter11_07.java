package PART02;

import java.util.Scanner;

public class Chapter11_07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = Integer.parseInt(sc.nextLine());
		String s = Integer.toString(N);
		
		int sum1 = 0;
		int sum2 = 0;
		for (int i = 0; i < s.length(); i++) {
			if(i < s.length()/2)
			{
				sum1 += (s.charAt(i) - '0');
			}
			else
			{
				sum2 += (s.charAt(i) - '0');
			}
		}
		
		if(sum1 == sum2) System.out.println("LUCKY");
		else System.out.println("READY");

	}

}
