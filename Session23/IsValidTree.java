package Session23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class IsValidTree {

	static class Graph {

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
		
		private boolean IsValidTree(int numV) {
			// TODO Auto-generated method stub

			Queue<Integer> bfs = new LinkedList<>();
			int[] parent = new int[numV];
			
			for(int i = 0; i < numV; i++) {
				parent[i] = i;
			}
			Set<Integer> vis = new HashSet<>();
			
			bfs.add(0);
			vis.add(0);
			
			while(!bfs.isEmpty()) {
				int frontV = bfs.poll();
				
				for(int neighbour : this.adjList.getOrDefault(frontV, new ArrayList<>())) {
					if(!vis.contains(neighbour)) {
						bfs.add(neighbour);
						vis.add(neighbour);
						parent[neighbour] = frontV;
					} else if(parent[frontV] != neighbour) { //neighbour is visited but is not a parent of our frontV(curr vertex) so cycle
						return false;
					}
				}
			}
			
			// no cycle
			System.out.println(vis);
			return vis.size() == numV;
		}
	}
	
	public static void main(String[] args) {
		int[][] edgeList = {{1, 2}, {2, 3}, {1, 3}};
		int numV = 4;
		
		if(edgeList.length < numV - 1) {
			System.out.println(false);
			return;
		}
		Graph g = new Graph();
		for(int i = 0; i < edgeList.length; i++) {
			int u = edgeList[i][0];
			int v = edgeList[i][1];
			
			g.addEdge(u, v, true);
		}
		
		g.display();
		System.out.println(g.IsValidTree(numV));
	}
}
