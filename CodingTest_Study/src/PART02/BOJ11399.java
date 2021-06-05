package PART02;

import java.util.*;

public class BOJ11399 {

	public static int N;
	public static int[] P;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		P = new int[N+1];
		
		for (int i = 1; i <= N; i++) 
		{
			P[i] = sc.nextInt();
			
		}
		
		Arrays.parallelSort(P);
		
		int result = 0;
		for (int i = 1; i <= N; i++) 
		{
			for (int j = 1; j <= i; j++) 
			{
				result = result + P[j];
			}
		}
		
		System.out.println(result);
		
	}

}
