package PART02;

import java.util.*;

class Chapter6_3 {

	public String[] solution(int n, String[] scores) {
		String[] answer = new String[2];
		HashMap<Integer, String> hash = new HashMap<>();
		
		for (int i = 0; i < scores.length; i++) {
			String[] sp = scores[i].split(" ");
			hash.put(Integer.parseInt(sp[1]), sp[0]);
		}
		
		Arrays.sort(hash.keySet().toArray());
		int cnt = 0;
		for (Map.Entry<Integer, String> entry : hash.entrySet()) {
            System.out.println("[key]:" + entry.getKey() + ", [value]:" + entry.getValue());
            answer[cnt] = entry.getValue();
            cnt++;
        }
		
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2;
		String[] scores = {"홍길동 95", "이순신 77"};
		
		Chapter6_3 c = new Chapter6_3();
		String[] answer = c.solution(n, scores);
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

}
