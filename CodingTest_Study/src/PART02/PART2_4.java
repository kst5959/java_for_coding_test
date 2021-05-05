package PART02;

public class PART2_4 {

	public int solution(int n, int k) {
		int answer = 0;
		
		while(n >= k)
		{
			while(n % k == 0)
			{
				n /= k;
				answer++;
				System.out.println(n);
			}
			
			n--;
			answer++;
			System.out.println(n);
			
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 25;
		int k = 3;
		
		PART2_4 p = new PART2_4();
		int answer = p.solution(n, k);
		System.out.println(answer);
	}

}
