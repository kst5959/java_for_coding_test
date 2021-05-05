package PART02;

import java.util.Scanner;
import java.util.Stack;

public class Chapter11_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine();
		
		int zero = 0;
		int one = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < S.length(); i++) {
			int temp = Integer.parseInt(Integer.toString(S.charAt(i)-'0'));
			if(!stack.isEmpty())
			{
				if(stack.peek() == temp)
				{
					continue;			
				}
				else
				{
					if(temp == 1)
					{
						zero++;
					}
					else
					{
						one++;
					}
					
					stack.removeAll(stack);
				}
				
			}
			stack.push(temp);
		}
		if(!stack.isEmpty())
		{
			if(stack.pop() == 1)
			{
				one++;
			}
			else
				zero++;
		}
		System.out.println(Math.min(zero, one));
		
	}

}
