package PART02;

import java.util.*;

public class Chapter14_24 {

	public static int N;
	public static int[] house;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		house = new int[N];
		
		for (int i = 0; i < N; i++) 
		{
			house[i] = sc.nextInt();
		}
		
		Arrays.parallelSort(house);
			
		System.out.println(house[(house.length / 2) -1]);
		
		
	}

}
