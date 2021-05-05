package PART02;

import java.util.Arrays;

class Chapter7_2 {

	public String solution(int n, String arr1, int m, String arr2) {
		String answer = "";
		int[] store = new int[n];
		int[] need = new int[m];
		
		String[] sp = arr1.split(" ");
		for (int i = 0; i < n; i++) {
			store[i] = Integer.parseInt(sp[i]);
		}
		sp = arr2.split(" ");
		for (int i = 0; i < m; i++) {
			need[i] = Integer.parseInt(sp[i]);
		}
		
		Arrays.sort(store);
		Arrays.sort(need);
		
		for (int i = 0; i < m; i++) {
			String find = findTarget(store, need[i], 0, n-1);
			answer += find + " ";
		}
		
		return answer;
	}
	
	
	public String findTarget(int[] arr, int target, int start, int end) {
		if(start > end) return "no";
		int midIndex = (start + end) / 2;
		
		if(arr[midIndex] == target)
		{
			return "yes";
		}
		// 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
		else if(arr[midIndex] > target)
		{
			return findTarget(arr, target, start, midIndex-1);
		}
		// 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
		else if(arr[midIndex] < target)
		{
			return findTarget(arr, target, midIndex+1, end);
		}
		
		return "no";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		String arr1 = "8 3 7 9 2";
		int m = 3;
		String arr2 = "5 7 9";
		
		Chapter7_2 c = new Chapter7_2();
		String answer = c.solution(n, arr1, m , arr2);
		System.out.println(answer);
	}

}
