package PART02;

public class Chapter8_1 {

	public int solution(int x) {
		int[] dp = new int[30000];
		
		for (int i = 2; i < x + 1; i++) {
			//������ ������ 1�� ���� ���
			dp[i] = dp[i-1] + 1;
			//������ ���� 2�� ���������� ���
			if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			//������ ���� 3���� ���������� ���
			if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			//������ ���� 5���� ���������� ���
			if(i % 5 == 0) dp[i] = Math.min(dp[i], dp[i / 5] + 1);
			
			System.out.println(dp[i]);
		}
		
		return dp[x];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 26;
				
		Chapter8_1 c = new Chapter8_1();
		int answer = c.solution(x);
		System.out.println(answer);
	}

}
