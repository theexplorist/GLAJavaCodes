package Session21;

import java.util.ArrayList;
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
		//iterate over adjList map
		
		for(var entry : this.adjList.entrySet()) {
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
		for(int neighbour : neighbourList) {
			if(!vis.contains(neighbour))
			dfsHelper(neighbour, vis);
		}
	}
	private void dFS(int src) {
		// TODO Auto-generated method stub

		Set<Integer> vis = new HashSet<>();
		dfsHelper(src, vis);
	}
	
	private void bFS(int src) {
		// TODO Auto-generated method stub

		Queue<Integer> bfs = new LinkedList<>();
		bfs.add(src);
		
		Set<Integer> vis = new HashSet<>();
		vis.add(src);
		
		while(!bfs.isEmpty()) {
			int frontV = bfs.poll();
			System.out.print(frontV + " ");
			List<Integer> neighbourList = this.adjList.getOrDefault(frontV, new ArrayList<>());
			for(int neighbour : neighbourList) {
				if(!vis.contains(neighbour)) {
					bfs.add(neighbour);
					vis.add(neighbour);
				}
			}
		}
	}
	public static void main(String[] args) {
		Graph g = new Graph();
		g.addEdge(1, 2, true);
		g.addEdge(1, 3, true);
		g.addEdge(2, 4, true);
		g.addEdge(3, 4, true);
		
		g.addEdge(3, 5, true);
		g.addEdge(5, 6, true);
		
		g.display();
		g.bFS(2);
	}

}
