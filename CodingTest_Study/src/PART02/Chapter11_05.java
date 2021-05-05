package PART02;

import java.util.Scanner;

public class Chapter11_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		int cnt = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				if(arr[i] == arr[j])
				{
					continue;
				}
				else
				{
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		
	}

}
