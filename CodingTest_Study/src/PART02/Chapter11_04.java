package PART02;

import java.util.Scanner;
import java.util.*;

public class Chapter11_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] coins = new int[N];
		
		int x = 0;
		int total = 0;
		boolean isAvail = false;
		for (int i = 0; i < coins.length; i++) {
			coins[i] = sc.nextInt();
			total += coins[i];
		}
		
		Arrays.parallelSort(coins);
		int sum = 0;
		while(total >= x)
		{
			x ++;
			System.out.println(x + "원을 만들 수 있는가 ?");
			sum = 0;
			isAvail = false;
			//1 1 2 3 9
			for (int i = 0; i < coins.length; i++) 
			{
				if(x == coins[i])
				{
					System.out.println(x);
					isAvail = true;
					break;
				}
				
				if(x < coins[i])
				{
					break;
				}
				
				if(x <= sum)
				{
					System.out.println(sum);
					isAvail = true;
					break;
				}
				
				sum += coins[i];
				
			}
			
			if(isAvail == false)
			{
				System.out.println(x + "원이 만들 수 없는 최저의 수");
				break;
			}
			
		}
	}

}
