package PART02;

import java.util.*;

public class Chapter15_30 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
}

class Solution
{

    //��� �ܾ���� ���̸��� ����� �����ϱ� ���� ����Ʈ
    public ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
    //��� �ܾ���� ���̸��� ����� ����� �����ϱ� ���� ����Ʈ
    public ArrayList<ArrayList<String>> reverseArr = new ArrayList<ArrayList<String>>();

    //���� Ž��
    public int left(ArrayList<String> arr, String target, int start, int end)
    {
    	while(start < end)
    	{
    		int mid = (start + end) / 2;
    		
    		//arr.get(mid)(�迭�� �߰��� �ִ� ����) target(����) ���� ���� ������ ���ų� �ڿ� �ִ� ���
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
    		
    		//arr.get(mid)(�迭�� �߰��� �ִ� ����) target(����) ���� ���� ������  �ڿ� �ִ� ���
    		if(arr.get(mid).compareTo(target) > 0)
    		{
    			//�߰����� �������� ������ �������� Ž���ϱ� ������ ���� �ۿ� �ִ� target�� Ž�� �ϱ� ���� mid
    			end = mid;
    		}
    		else
    		{
    			start = mid + 1;
    		}
    		
    	}
    	
    	return end;
    }
    
    //�ܾ��� ������ ��ȯ�ϱ� ���� ���� �Լ�
    public int countByRange(ArrayList<String> arr, String leftValue, String rightValue)
    {
    	int leftIndex = left(arr, leftValue, 0, arr.size());
    	int rightIndex = right(arr, rightValue, 0, arr.size());
    	
    	return rightIndex - leftIndex;
    }
    
    public int[] solution(String[] words, String[] queries) 
    {
    	ArrayList<Integer> answer = new ArrayList<Integer>();
        
	    //2�� ArrayList �ʱ�ȭ
	    for(int i=0; i<10001; i++)
	    {
	    	arr.add(new ArrayList<String>());
	        reverseArr.add(new ArrayList<String>());
	    }
	    
	    //��� �ܾ���� �� ArrayList�� ����
	    for (int i = 0; i < words.length; i++) 
	    {
			String word = words[i];
			//�� �ܾ��� ���̿� �´� �迭�� ����
			arr.get(word.length()).add(word);
			//�ܾ� ������
			word = (new StringBuffer(word)).reverse().toString();
			//�� �ܾ��� ���̿� �´� �迭�� ����
			reverseArr.get(word.length()).add(word);
		}
	    
	    //����Ž�� �� ArrayList ����
	    for (int i = 0; i < arr.size(); i++) 
	    {
			Collections.sort(arr.get(i));
			Collections.sort(reverseArr.get(i));
		}
	    
	    //������ �ϳ��� Ȯ���ϸ� ó��
	    for (int i = 0; i < queries.length; i++) 
	    {
			String q = queries[i];
			//������ �ش�Ǵ� �ܾ��� ����
			int count = 0;
			
			//������ ? ���� �������� �ʴ� ��� 
			if(q.charAt(0) != '?')
			{
				//����� ��� �ҹ��ڷθ� �Ǿ�������, ? ��� ���� ���ĺ��� ���� �� �� ����
				//���� ���� q�� ���̿� �´� ArrayList�� q�� ? �� ���������� ���� ���� a�� ���� ���� z�� �ٲپ ����
				count = countByRange(arr.get(q.length()), q.replaceAll("\\?", "a") , q.replaceAll("\\?", "z"));
			}
			//������ ? ���� �����ϴ� ��� : �ܾ���� ����� Ȯ���ؾ��ϴ� ���
			else
			{
				//���� ���� �����
				q = (new StringBuffer(q)).reverse().toString();
				count = countByRange(reverseArr.get(q.length()),q.replaceAll("\\?", "a") , q.replaceAll("\\?", "z"));
			}
			
			//�ܾ��� ���� ����
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