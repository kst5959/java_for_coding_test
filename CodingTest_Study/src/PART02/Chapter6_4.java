package PART02;

import java.util.*;

class Chapter6_4 {

	public int solution(int n, int k, int[] a, int b[]) {
		int answer = 0;
		int[] tempB = new int[n];
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		for (int i = b.length-1; i >= 0; i--) {
			tempB[i] = b[i];
		}
	
		for (int i = 0; i < n; i++) {
			if(i <= k)	a[i] = tempB[i];
			answer += a[i];
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int k = 3;
		int[] a = {1,2,5,4,3};
		int[] b = {5,5,6,6,5};
		
		Chapter6_4 c = new Chapter6_4();
		int answer = c.solution(n, k, a, b);
		System.out.println(answer);
	}

}
