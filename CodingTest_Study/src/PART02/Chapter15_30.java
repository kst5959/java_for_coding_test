package PART02;

import java.util.*;

public class Chapter15_30 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
}

class Solution
{

    //모든 단어들을 길이마다 나누어서 저장하기 위한 리스트
    public ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
    //모든 단어들을 길이마다 나누어서 뒤집어서 저장하기 위한 리스트
    public ArrayList<ArrayList<String>> reverseArr = new ArrayList<ArrayList<String>>();

    //이진 탐색
    public int left(ArrayList<String> arr, String target, int start, int end)
    {
    	while(start < end)
    	{
    		int mid = (start + end) / 2;
    		
    		//arr.get(mid)(배열의 중간에 있는 값이) target(쿼리) 보다 사전 순으로 같거나 뒤에 있는 경우
    		if(arr.get(mid).compareTo(target) >= 0)
    		{
    			end = mid;
    		}
    		else
    		{
    			start = mid + 1;
    		}
    	}
    	
    	return end;
    }
    
    public int right(ArrayList<String> arr, String target, int start, int end)
    {
    	while(start < end)
    	{
    		int mid = (start + end) / 2;
    		
    		//arr.get(mid)(배열의 중간에 있는 값이) target(쿼리) 보다 사전 순으로  뒤에 있는 경우
    		if(arr.get(mid).compareTo(target) > 0)
    		{
    			//중간점을 기준으로 오른쪽 방향으로 탐색하기 때문에 범위 밖에 있는 target을 탐색 하기 위해 mid
    			end = mid;
    		}
    		else
    		{
    			start = mid + 1;
    		}
    		
    	}
    	
    	return end;
    }
    
    //단어의 개수를 반환하기 위해 만든 함수
    public int countByRange(ArrayList<String> arr, String leftValue, String rightValue)
    {
    	int leftIndex = left(arr, leftValue, 0, arr.size());
    	int rightIndex = right(arr, rightValue, 0, arr.size());
    	
    	return rightIndex - leftIndex;
    }
    
    public int[] solution(String[] words, String[] queries) 
    {
    	ArrayList<Integer> answer = new ArrayList<Integer>();
        
	    //2중 ArrayList 초기화
	    for(int i=0; i<10001; i++)
	    {
	    	arr.add(new ArrayList<String>());
	        reverseArr.add(new ArrayList<String>());
	    }
	    
	    //모든 단어들을 각 ArrayList에 삽입
	    for (int i = 0; i < words.length; i++) 
	    {
			String word = words[i];
			//각 단어의 길이에 맞는 배열에 삽입
			arr.get(word.length()).add(word);
			//단어 뒤집기
			word = (new StringBuffer(word)).reverse().toString();
			//각 단어의 길이에 맞는 배열에 삽입
			reverseArr.get(word.length()).add(word);
		}
	    
	    //이진탐색 전 ArrayList 정렬
	    for (int i = 0; i < arr.size(); i++) 
	    {
			Collections.sort(arr.get(i));
			Collections.sort(reverseArr.get(i));
		}
	    
	    //쿼리를 하나씩 확인하며 처리
	    for (int i = 0; i < queries.length; i++) 
	    {
			String q = queries[i];
			//쿼리에 해당되는 단어의 개수
			int count = 0;
			
			//쿼리가 ? 부터 시작하지 않는 경우 
			if(q.charAt(0) != '?')
			{
				//가사는 모두 소문자로만 되어있으며, ? 모든 영어 알파벳이 포함 될 수 있음
				//현재 쿼리 q의 길이에 맞는 ArrayList와 q의 ? 를 사전순으로 제일 앞인 a와 제일 뒤인 z로 바꾸어서 전달
				count = countByRange(arr.get(q.length()), q.replaceAll("\\?", "a") , q.replaceAll("\\?", "z"));
			}
			//쿼리가 ? 부터 시작하는 경우 : 단어들을 뒤집어서 확인해야하는 경우
			else
			{
				//쿼리 또한 뒤집어서
				q = (new StringBuffer(q)).reverse().toString();
				count = countByRange(reverseArr.get(q.length()),q.replaceAll("\\?", "a") , q.replaceAll("\\?", "z"));
			}
			
			//단어의 개수 저장
			answer.add(count);
			
		}
	    
	    int[] ans = new int[answer.size()];
	    for (int i = 0; i < ans.length; i++) 
	    {
			ans[i] = answer.get(i);
		}
	    
	    return ans;
	    
    }
}