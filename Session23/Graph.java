package Session23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Graph {

	// vertex - list of neighboours

	Map<Integer, List<Integer>> adjList;

	int numV;

	public Graph(int numV) {
		this.numV = numV;
		adjList = new HashMap<>();
	}

	public Graph() {
		adjList = new HashMap<>();
	}

	private void addEdge(int u, int v, boolean biDir) {
		// TODO Auto-generated method stub

		// u se v edge banana hai, u -> v

		List<Integer> uNeighbour = this.adjList.getOrDefault(u, new ArrayList<>());
		uNeighbour.add(v);
		this.adjList.put(u, uNeighbour);

		if (biDir) {
			// v se u edge banana hai, v -> u
			List<Integer> vNeighbour = this.adjList.getOrDefault(v, new ArrayList<>());
			vNeighbour.add(u);
			this.adjList.put(v, vNeighbour);
		}
	}

	private void display() {
		// TODO Auto-generated method stub
		// iterate over adjList map

		for (var entry : this.adjList.entrySet()) {
			int vertex = entry.getKey();
			List<Integer> neighbourList = entry.getValue();

			System.out.println(vertex + " -> " + neighbourList);
		}
	}

	private void dfsHelper(int src, Set<Integer> vis) {
		// TODO Auto-generated method stub\
		System.out.print(src + " ");
		vis.add(src);

		List<Integer> neighbourList = this.adjList.getOrDefault(src, new ArrayList<>());
		for (int neighbour : neighbourList) {
			if (!vis.contains(neighbour))
				dfsHelper(neighbour, vis);
		}
	}

	private void dFS(int src) {
		// TODO Auto-generated method stub

		Set<Integer> vis = new HashSet<>();
		dfsHelper(src, vis);
	}

	private void connectedComponent() {
		// TODO Auto-generated method stub

		Set<Integer> vis = new HashSet<>();
		int count = 1;
		for (int vertex : this.adjList.keySet()) {
			if (!vis.contains(vertex)) {
				System.out.print("Connected Component " + count + " -> ");
				this.dfsHelper(vertex, vis);
				count++;
				System.out.println();
			}
		}
	}

	private void bFS(int src) {
		// TODO Auto-generated method stub

		Queue<Integer> bfs = new LinkedList<>();
		bfs.add(src);

		Set<Integer> vis = new HashSet<>();
		vis.add(src);

		while (!bfs.isEmpty()) {
			int frontV = bfs.poll();
			System.out.print(frontV + " ");
			List<Integer> neighbourList = this.adjList.getOrDefault(frontV, new ArrayList<>());
			for (int neighbour : neighbourList) {
				if (!vis.contains(neighbour)) {
					bfs.add(neighbour);
					vis.add(neighbour);
				}
			}
		}
	}

	private int[] indegree() {
		// TODO Auto-generated method stub
		int[] indegree = new int[this.numV];
		
		for(List<Integer> neighbour : this.adjList.values()) {
			for(int vertex :  neighbour) {
				indegree[vertex]++;
			}
		}
		
		System.out.println(Arrays.toString(indegree));
		return indegree;
	}
	
	private boolean topologicalSorting(int total) {
		// TODO Auto-generated method stub

		int[] indegree = this.indegree();
		
		int count = 0;
		Queue<Integer> bfs = new LinkedList<>();
		for(int i = 0; i < this.numV; i++) {
			if(indegree[i] == 0) {
				count++;
				bfs.add(i);
			}
		}
		
		System.out.println(bfs);
		
		while(!bfs.isEmpty()) {
			int frontV = bfs.poll(); //0
			System.out.print(frontV + " ");
			
			for(int neighbour : this.adjList.getOrDefault(frontV, new ArrayList<>())) {
				
				indegree[neighbour]--;
				if(indegree[neighbour] == 0) {
					count++;
					bfs.add(neighbour);
				}
			}
		}
		
		return count == total;
	}

	private void sSSP(int src) {
		// TODO Auto-generated method stub
		Queue<Integer> bfs = new LinkedList<>();
		bfs.add(src);

		Map<Integer, Integer> dis = new HashMap<>();
		for (int vertex : this.adjList.keySet()) {
			dis.put(vertex, Integer.MAX_VALUE);
		}
		dis.put(src, 0);

		while (!bfs.isEmpty()) {
			int frontV = bfs.poll();
			// System.out.print(frontV + " ");
			List<Integer> neighbourList = this.adjList.getOrDefault(frontV, new ArrayList<>());
			for (int neighbour : neighbourList) {
				if (dis.get(neighbour) == Integer.MAX_VALUE) { // unvisited

					int newDistance = dis.get(frontV) + 1;
					dis.put(neighbour, newDistance);
					System.out.println(neighbour + " is at a distance " + newDistance + " from source " + src);
					bfs.add(neighbour);
				}
			}
		}
	}

	public static void main(String[] args) {
		Graph g = new Graph(4);
//		g.addEdge(1, 2, true);
//		g.addEdge(1, 3, true);
//		g.addEdge(2, 4, true);
//		g.addEdge(3, 4, true);
//		
//		g.addEdge(3, 5, true);
//		g.addEdge(5, 6, true);
//		//g.addEdge(7, 8, true);
//		g.display();
//		//g.dFS(7);
//		//g.connectedComponent();
//		g.sSSP(4);
//		g.addEdge(0, 1, false);
//		g.addEdge(0, 2, false);
//		g.addEdge(2, 3, false);
//		g.addEdge(2, 4, false);
//		g.addEdge(3, 1, false);
//		g.addEdge(4, 6, false);
//		g.addEdge(5, 3, false);
//		g.addEdge(5, 6, false);
//		g.display();
//		g.indegree();
//		g.topologicalSorting();
		
		int[][] matrix = {{1, 0}, {0, 1}, {0, 2}, {3, 1}, {3, 2}};
		
		for(int i = 0; i < matrix.length; i++) {
			int u = matrix[i][1], v = matrix[i][0]; //u -> v
			g.addEdge(u, v, false);
		}
		
		g.display();
		System.out.println(g.topologicalSorting(4));
		
	}

}
