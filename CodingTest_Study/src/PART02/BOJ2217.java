package PART02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2217 {

	public static int N;
	
	public static ArrayList<Integer> list = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		
		for (int i = 0; i < N; i++) 
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int rope = Integer.parseInt(st.nextToken()); 
			list.add(rope);
		}
		
		Collections.sort(list);
		
		int w = 0;
		int result = 0;
		
		for (int i = 0; i < list.size(); i++) 
		{
			w =  list.get(i);
			
			for (int j = i + 1; j < list.size(); j++) 
			{
				w = w + list.get(i);
			}
			
			result = Math.max(result, w);
		}
		
		System.out.println(result);
		
	}

}
