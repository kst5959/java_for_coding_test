package PART02;

import java.util.*;

class Chapter6_2 {

	public int[] solution(int[] n) {

		Arrays.sort(n);
		
		return n;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n = {3, 15, 27, 12};
		
		Chapter6_2 c = new Chapter6_2();
		int[] answer = c.solution(n);
		
		for (int i = answer.length-1; i >= 0; i--) {
			System.out.println(answer[i]);
		}
		
	}

}
