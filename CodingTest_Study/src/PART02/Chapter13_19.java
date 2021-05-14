package PART02;

import java.util.*;

public class Chapter13_19 {

	
	public static int N;
	public static int[] arr;
	//¿¬»êÀÚ ¹è¿­ : µ¡¼À / »¬¼À / °ö¼À / ³ª´°¼À °³¼ö
	public static int[] operates = new int[4];
	
	public static int MIN = Integer.MAX_VALUE;
	public static int MAX = Integer.MIN_VALUE;
	
	public static void dfs(int sum, int arrIndex)
	{
		if(arrIndex == N)
		{
			MAX = Math.max(MAX, sum);
			MIN = Math.min(MIN, sum);
			return;
		}
		
		for (int i = 0; i < 4; i++) 
		{			
			
			if(operates[i] > 0)
			{
				
				if(i == 0)
				{
					operates[i]--;
					dfs(sum + arr[arrIndex], arrIndex + 1);
					operates[i]++;
				}
				else if(i == 1)
				{
					operates[i]--;
					dfs(sum - arr[arrIndex], arrIndex + 1);
					operates[i]++;
				}
				else if(i == 2)
				{
					operates[i]--;
					dfs((sum * arr[arrIndex]), arrIndex + 1);
					operates[i]++;
				}
				else if(i == 3)
				{
					operates[i]--;
					dfs((sum / arr[arrIndex]), arrIndex + 1);
					operates[i]++;
				}
				
				
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int[N];
		
		for (int i = 0; i < N; i++) 
		{
			arr[i] = sc.nextInt();
		}
		
		for (int i = 0; i < 4; i++) 
		{
			operates[i] = sc.nextInt();
		}
		
		dfs(arr[0], 1);
			
		System.out.println(MAX);
		System.out.println(MIN);
		
	}

}
