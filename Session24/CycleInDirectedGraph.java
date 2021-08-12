package Session24;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CycleInDirectedGraph {

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
		
		private boolean helper(int src, List<Integer> path, Set<Integer> vis) {
			// TODO Auto-generated method stub

			vis.add(src);
			path.add(src);
			
			System.out.println(path);
			boolean hasCycle = false;
			for(int neighbour : this.adjList.getOrDefault(src, new ArrayList<>())) {
				if(!vis.contains(neighbour)) {
					hasCycle = helper(neighbour, path, vis);
					//return hasCycle;
				} else if(path.contains(neighbour)) { //visited and in path -> back edge
					return true;
				}
			}
			
			path.remove(path.size() - 1);
			System.out.println("*" + path);
			return hasCycle;
		}
		private void hasCycle() {
			// TODO Auto-generated method stub

			Set<Integer> vis = new HashSet<>();
			List<Integer> path = new ArrayList<>();
			
			System.out.println(helper(0, path, vis));
		}
	}
	
	public static void main(String[] args) {
		Graph g = new Graph();
		g.addEdge(0, 1, false);
		g.addEdge(1, 5, false);
		g.addEdge(5, 6, false);
		g.addEdge(1, 2, false);
		g.addEdge(2, 3, false);
		g.addEdge(3, 4, false);
		//g.addEdge(4, 2, false);
		g.addEdge(4, 5, false);
		g.display();
		
		g.hasCycle();
	}
}
