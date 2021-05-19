package PART02;

import java.util.*;

public class Chapter16_31 {

	public static int t;
	public static int n;
	public static int m;
	
	public static int[][] arr = new int[20][20];
	public static int[][] dp = new int[20][20];
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		t = sc.nextInt();
		
		//테스트케이스 횟수 만큼 실행
		for (int tc = 0; tc < t; tc++) 
		{
			n = sc.nextInt();
			m = sc.nextInt();
			
			//arr 값 입력
			for (int i = 0; i < n; i++) 
			{
				for (int j = 0; j < m; j++) 
				{					
					arr[i][j] = sc.nextInt();
				}
			}
			
			//dp배열에 옮기기
			for (int i = 0; i < n; i++) 
			{
				for (int j = 0; j < m; j++) 
				{
					dp[i][j] = arr[i][j];
				}
			}
			
			//제일 처음 열 말고 다음 열 부터 진행해서 왼쪽에서 오는 값을 더하는 식으로 진행
			for (int j = 1; j < m; j++) 
			{
				for (int i = 0; i < n; i++) 
				{
					//왼쪽 위에서 오는 경우
					int leftUp = 0;
					//행이 가장 위의 행 (0)이 아닌 경우에만 왼쪽 위의 값이 존재하기 때문에 체크하면서 진행
					if(i != 0)
					{
						leftUp = dp[i-1][j-1];
					}
					
					//바로 왼쪽은 체크할 필요가 없음
					int left = dp[i][j-1];
					
					//왼쪽 아래에서 오는 경우
					int leftDown = 0;
					//가장 아래 행 (n-1) 보다 위에 있어야 왼쪽 아래 값이 존재하기 때문에 체크
					if(i < n-1)
					{
						leftDown = dp[i+1][j-1];
					}
					
					dp[i][j] = dp[i][j] + Math.max(leftUp, Math.max(left, leftDown)); 
				}
				
			}
			
			int res = 0;
			for (int i = 0; i < n; i++) 
			{
				//큰 값을 찾을 때는 마지막 열 (m-1)만 보면 됨
				res = Math.max(res, dp[i][m-1]);
			}
			System.out.println(res);
		}
		
		
	}

}
