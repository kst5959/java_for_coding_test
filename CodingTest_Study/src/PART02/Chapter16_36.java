package PART02;

import java.util.*;

public class Chapter16_36 {

	public static String A;
	public static String B;
	
	public static int[][] dp;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		A = sc.nextLine();
		B = sc.nextLine();
		
		//편집 거리 : 문자열 A를 문자열 B로 바꾸기 위해서 최소 몇 번의 편집을 거쳐야 하는가?
		//편집 내역은 3가지가 있다
		//1. 삽입 
		//2. 삭제
		//3. 교체 A의 문자 하나를 B의 문자 하나로 교체
		
		//인덱스를 1부터 시작하기 위해 크기를 한 칸 늘려주어 앞에 null공간을 만든다
		dp = new int[A.length() + 1][B.length() + 1];
		//DP테이블 채우기 : DP테이블의 구석자리는 기본적으로 문자열의 길이대로 가기 때문에 차례로 우선 채워준다
		dp[0][0] = 0;
		for (int i = 1; i < A.length()+1; i++) 
		{
			dp[i][0] = i;
		}
		for (int i = 0; i < B.length()+1; i++) 
		{
			dp[0][i] = i;
		}
		
		
		//DP테이블을 만드는 과정으로 점화식을 세우면 dp[i][j] = Math.min(삽입, 삭제, 교체) + 1 이 되겠다
		//삽입 : dp[i][j-1]
		//삭제 : dp[i-1][j]
		//교체 : dp[i-1][i-1]
		//DP테이블로 봤을 때 왼쪽, 위쪽, 왼쪽위 가 되겠다.
		
		//인덱스 1부터 시작
		for (int i = 1; i < A.length()+1; i++) 
		{
			for (int j = 1; j < B.length()+1; j++) 
			{
				//두 문자열의 문자가 같은 경우
				if(A.substring(i-1, i).equals(B.substring(j-1, j)))
				{
					//변경이 없기 때문에 전의 편집거리 값을 그대로 가져온다
					dp[i][j] = dp[i-1][j-1];
				}
				//다를 경우
				else
				{					
					int insert = dp[i][j-1];
					int delete = dp[i-1][j];
					int replace = dp[i-1][j-1];
					
					dp[i][j] = Math.min(insert, Math.min(delete, replace)) + 1;
				}
			}
		}
	
		//dp테이블의 가장 마지막 인덱스의 값이 편집거리
		System.out.println(dp[A.length()][B.length()]);
	}

}
