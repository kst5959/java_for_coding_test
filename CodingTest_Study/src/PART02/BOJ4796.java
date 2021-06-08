package PART02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ4796 {
	
	public static int L;
	public static int P;
	public static int V;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = 0;
		
		while(true)
		{			
			count++;
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			L = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());
				
			if(L + P + V == 0)
			{
				break;
			}
			
			int result = 0;
			while(V != 0)
			{
				if(V >= P)
				{
					result = (V / P) * L;
					V = V % P;
				}
				else
				{
					if(V > L)
					{
						result = result + L;						
					}
					else
					{
						result = result + V;
					}
					
					V = 0;
				}
			}
			
			System.out.println("Case "+ count + ": " + result);
		}
		
	}

}
