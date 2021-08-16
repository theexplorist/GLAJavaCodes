package Session26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisjointSetUnionOptimisations {

	static class EdgeList {

		class Edge {
			int u;
			int v;

			public Edge(int u, int v) {
				this.u = u;
				this.v = v;
			}
			
			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "{" + this.u + ", " + this.v + "}";
			}
		}

		int numV;
		List<Edge> edgeList;

		public EdgeList(int numV) {
			// TODO Auto-generated constructor stub
			this.numV = numV;
			this.edgeList = new ArrayList<>();
		}

		private void addEdge(int u, int v) {
			// TODO Auto-generated method stub

			Edge edge = new Edge(u, v);
			this.edgeList.add(edge);
		}
		
		//u ka godfather dhundo, aisa vertex jiks parent -1
		private int find(int[]parent, int u) {
			// TODO Auto-generated method stub

			if(parent[u] == -1) {//godfather, leader, parent of itself
				return u;
			}
			
			return parent[u] = find(parent, parent[u]);
		}
		
		private void union(int[] parent, int u, int v, int[] rank) {
			// TODO Auto-generated method stub

			
			//find godfather of u and v both
			int godFatherU = this.find(parent, u);
			int godFatherV = this.find(parent, v);
			
			if(godFatherU != godFatherV) {
				
				if(rank[godFatherU] < rank[godFatherV]) {
					parent[godFatherU] = godFatherV;
					rank[godFatherV] += rank[godFatherU];
				} else {
					parent[godFatherV] = godFatherU;
					rank[godFatherU] += rank[godFatherV];
				}
			}
			
		}
		private void display() {
			
			// TODO Auto-generated method stub
			System.out.println(this.edgeList);
		}
		
		private boolean hasCycle(int[] parent, int[] rank) {
			// TODO Auto-generated method stub

			for(Edge edge : this.edgeList) {
				int u = edge.u;
				int v = edge.v;
				
				int godfatherU = this.find(parent, u);
				int godfatherV = this.find(parent, v);
				
				if(godfatherU != godfatherV) {
					this.union(parent, godfatherU, godfatherV, rank);
				} else { //cycle
					return true;
				}
			}
			
			return false;
		}
	}
	
	public static void main(String[] args) {
		EdgeList graph = new EdgeList(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(1, 4);
		//graph.addEdge(4, 2);
		int[] parent = new int[5];
		Arrays.fill(parent, -1);
		graph.display();
		//graph.find(parent, 0);
		int[] rank = new int[5];
		Arrays.fill(rank, 1);
		System.out.println(graph.hasCycle(parent, rank));
	}
}
