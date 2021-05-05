package PART02;

public class Chapter8_1 {

	public int solution(int x) {
		int[] dp = new int[30000];
		
		for (int i = 2; i < x + 1; i++) {
			//현재의 수에서 1을 빼는 경우
			dp[i] = dp[i-1] + 1;
			//현재의 수가 2로 나누어지는 경우
			if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			//현재의 수가 3으로 나누어지는 경우
			if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			//현재의 수가 5으로 나누어지는 경우
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
