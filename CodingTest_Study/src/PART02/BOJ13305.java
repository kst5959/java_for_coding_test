package PART02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ13305 {

	public static long N;
	public static long[] road;
	public static long[] city;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		road = new long[(int) (N-1)];
		city = new long[(int) N];
		
		long remainRoadLength = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < road.length; i++) 
		{			
			road[i] = Integer.parseInt(st.nextToken());
			remainRoadLength = remainRoadLength + road[i];
		}
		
		long min_city = (long)1e9;
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < city.length; i++) 
		{
			
			city[i] = Integer.parseInt(st2.nextToken());
			if(i != city.length-1)
			{
				min_city = Math.min(min_city, city[i]);				
			}
		}
		
		long result = 0;
		for (int i = 0; i < city.length-1; i++) 
		{
			if(city[i] == min_city)
			{
				result = result + (city[i] * remainRoadLength);
				break;
			}
			else
			{
				int count = 0;
				result = result + (city[i] * road[i]);
				remainRoadLength = remainRoadLength - road[i];
				
				for (int j = i+1; j < city.length-1; j++) 
				{
					if(city[i] < city[j])
					{
						result = result + (city[i] * road[j]);
						remainRoadLength = remainRoadLength - road[j];
						count++;
					}
					else
					{
						i = i + count;
						break;
					}
				}
			}
		}
		
		System.out.println(result);
		
	}

}
