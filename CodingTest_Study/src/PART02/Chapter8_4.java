package PART02;

public class Chapter8_4 {

	public int solution(int n) {
		int[] dp = new int[1001];
		
		dp[1] = 1;
		dp[2] = 3;
		
		for (int i = 3; i < n + 1; i++) {
			dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 796796;
		}
				
		return dp[n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2;
		
		Chapter8_4 c = new Chapter8_4();
		int answer = c.solution(n);
		System.out.println(answer);
		
	}

}
