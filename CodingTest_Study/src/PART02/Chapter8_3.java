package PART02;

public class Chapter8_3 {
	
	public int solution(int n, int[] food) {
		int[] dp = new int[n+1];
		dp[0] = food[0];
		dp[1] = Math.max(food[0], food[1]);
		
		for (int i = 2; i < n; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + food[i]);
			System.out.println(i+1+ "번 째 창고를 기준으로  바로 뒤 쪽 창고인 " + dp[i-1] + "를 터는게 나은가 vs 두 칸 뒤의 창고 "+ dp[i - 2] + "와 현재 창고 " + food[i] +"를 같이 터는게 나은가 비교");
		}
	
		return dp[n-1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int[] food = {1,3,1,5};
		
		Chapter8_3 c = new Chapter8_3();
		int answer = c.solution(n , food);
		System.out.println(answer);
		
	}

}
