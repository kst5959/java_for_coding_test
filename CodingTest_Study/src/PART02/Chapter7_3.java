package PART02;

import java.util.*;

class Chapter7_3 {

	public int solution(int n, int m, int[] arr) {
		int answer = 0;
		Arrays.sort(arr);
		
		answer = findTarget(arr, m, 0, arr[arr.length-1]);
		
		return answer;
	}
	
	public int findTarget(int[] arr, int target, int start, int end){
		int mid = (start + end) / 2;
		int sum = 0;
		System.out.println("시작점 : " + start + " 중간점 : " + mid);
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] > mid)
			{
				int cut = arr[i] - mid;
				sum += cut;
			}
		}
		if(sum == target) return start;
		else if(sum > target)
		{
			return findTarget(arr, target, mid+1, end);
		}
		
		return start;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int m = 6;
		int[] arr = {19, 15, 10, 17};
		
		Chapter7_3 c= new Chapter7_3();
		int answer = c.solution(n, m, arr);
		System.out.println(answer);
	}

}
