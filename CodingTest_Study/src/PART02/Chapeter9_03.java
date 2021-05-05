package PART02;

import java.util.*;
import java.lang.Comparable;

//class Node implements Comparable<Node> {
	private int index;
	private int distance;
	
	public Node(int index, int distance) {
		this.index = index;
		this.distance = distance;
	}
	
	public int getIndex() {
		return this.index;
	}
	
	public int getDistance() {
		return this.distance;
	}
	
	//�Ÿ��� ª�� ���� �켱������ �������� ����
	@Override
	public int compareTo(Node other)
	{
		if(this.distance < other.distance)
		{
			return -1;
		}
		return 1;
	}
}

public class Chapeter9_03 {

	public static int INF = Integer.MAX_VALUE;
	 // ����� ����(N), ������ ����(M), ���� ��� ��ȣ(Start)
    // ����� ������ �ִ� 100,000����� ����
	public static int n;
	public static int m;
	public static int start;
	//�׷���
	public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
	//�ִܰŸ� ���̺�
	public static int[] dist = new int[200001];
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.offer(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty())
		{
			//�Ÿ��� ª�� ����� ���� ��������
			Node node = pq.poll();
			//���� ��� ������ ���
			int currentDistance = node.getDistance();
			int currentIndex = node.getIndex();
			
			//�̹� ó���� ���� �ִ� ������� �˻�
			if(dist[currentIndex] < currentDistance)
			{
				continue;
			}
			//���� ���� ����� �ٸ� ������ ������ Ȯ��
			for (int i = 0; i < graph.get(currentIndex).size(); i++) {
				int cost = dist[currentIndex] + graph.get(currentIndex).get(i).getDistance();
				//���� ��带 ���ļ� �ٸ� ���� �̵��ϴ� �Ÿ��� �� ª�� ���
				if(cost < dist[graph.get(currentIndex).get(i).getIndex()])
				{
					dist[graph.get(currentIndex).get(i).getIndex()] = cost;
					pq.offer(new Node(graph.get(currentIndex).get(i).getIndex(), cost));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);

	        n = sc.nextInt();
	        m = sc.nextInt();
	        start = sc.nextInt();
	        
	        //System.out.println(start + "/" + dist.length);

	        // �׷��� �ʱ�ȭ
	        for (int i = 0; i <= n; i++) {
	            graph.add(new ArrayList<Node>());
	        }
	        
	        // ��� ���� ������ �Է¹ޱ�
	        for (int i = 0; i < m; i++) {
	            int a = sc.nextInt();
	            int b = sc.nextInt();
	            int c = sc.nextInt();
	            // a�� ��忡�� b�� ���� ���� ����� c��� �ǹ�
	            graph.get(a).add(new Node(b, c));
	        }
	        
	        Arrays.fill(dist, INF);
	        dijkstra(start);
	        
	        int city = 0;
	        int time = 0;
	        
	        for (int i = 1; i <= n; i++) {
				if(dist[i] != INF)
				{
					city++;
					time = Math.max(time, dist[i]);
				}
				
			}
	        System.out.println(city-1 +" " + time);
	}

}
