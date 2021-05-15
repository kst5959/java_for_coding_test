package PART02;

import java.util.*;


public class Chapter14_26 {
	
	public static int N;
	public static int[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int[N];
		
		for (int i = 0; i < N; i++) 
		{
			arr[i] = sc.nextInt();
			
		}
		
		Arrays.sort(arr);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for (int i = 0; i < N; i++) 
		{
			pq.offer(arr[i]);
		}
	
		int count = 0;
		int answer = 0;
		while(!pq.isEmpty())
		{
			if(count == N-1)
			{
				break;
			}
			int n1 = pq.poll();
			int n2 = pq.poll();
			
			answer = answer + (n1 + n2);
			
			pq.offer(n1 + n2);
			count++;
		}
		
		System.out.println(answer);
		
	}

}
