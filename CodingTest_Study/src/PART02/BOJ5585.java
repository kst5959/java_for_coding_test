package PART02;

import java.util.*;

public class BOJ5585 {

	public static int K;
	public static int[] coins = {500, 100, 50, 10, 5, 1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		
		int count = 0;
		int coinIndex = 0;
		
		K = 1000 - K;
		
		while(K > 4) 
		{
			if(K >= coins[coinIndex])
			{
				int temp = (K / coins[coinIndex]);
				//System.out.println(coins[coinIndex] + "원 짜리 " + temp + "개 사용");
				count = count + temp;
				K = K % coins[coinIndex];
			}
			else
			{
				coinIndex++;
			}
		}
		
		if(K != 0)
		{
			System.out.println(count + K);
		}
		else
		{
			System.out.println(count);
		}
	}

}
