package PART02;

import java.util.*;
public class Chapter11_01 {

	public static int N;
	public static int[] arr; 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		int cnt = 0;
		ArrayList<Integer> group = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			group.add(arr[i]);
			if(group.size() == arr[i])
			{
				group.removeAll(group);
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}

}
