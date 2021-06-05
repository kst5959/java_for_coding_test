package PART02;

import java.util.*;

public class BOJ1541 {

	public static String input;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		input = sc.nextLine();
		
		String[] S = input.split("-");
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < S.length; i++) 
		{	
			int sum = 0;
			
			if(S[i].contains("+"))
			{
				String[] S2 = S[i].split("\\+");
				for (int j = 0; j < S2.length; j++) 
				{
					sum = sum + Integer.parseInt(S2[j]);
				}				
			}
			else
			{
				sum = Integer.parseInt(S[i]);
			}
			
			list.add(sum);
		}
		
		int result = list.get(0);
		for (int i = 1; i < list.size(); i++) 
		{
			result = result - list.get(i);
		}
		
		System.out.println(result);
		
		
	}

}
