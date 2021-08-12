package Session23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UndirectedDFSCycle {

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
		
		private boolean isCycle(int src, int parent, Set<Integer> vis) {
			// TODO Auto-generated method stub

			vis.add(src);
			
			boolean hasCycle = false;
			for(int neighbour : this.adjList.getOrDefault(src, new ArrayList<>())) {
				if(!vis.contains(neighbour)) {
					hasCycle = isCycle(neighbour, src, vis);
					return hasCycle;
				} else if(parent != neighbour) {
					return true;
				}
			}
			
			return hasCycle;
		}
		private void dFS() {
			// TODO Auto-generated method stub
			Set<Integer> vis = new HashSet<>();
			
			for(int vertex : this.adjList.keySet()) {
				boolean hasCycle = isCycle(vertex, vertex, vis);
				if(hasCycle) {
					System.out.println(true);
					return;
				}
			}
			
		}
	}
	
	public static void main(String[] args) {
		Graph g = new Graph();
		g.addEdge(0, 1, true);
		g.addEdge(2, 3, true);
		g.addEdge(3, 4, true);
		g.addEdge(4, 2, true);
		g.display();
		g.dFS();
	}
}
