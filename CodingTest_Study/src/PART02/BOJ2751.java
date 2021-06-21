package PART02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ2751 {

	public static int N;
	
	public static ArrayList<Integer> list = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) 
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			
			list.add(x);
		}
		
		Collections.sort(list);
		
		for (int i = 0; i < list.size(); i++) 
		{
			bw.write(list.get(i));
		}
		
		bw.flush();
		bw.close();
		
	}

}
