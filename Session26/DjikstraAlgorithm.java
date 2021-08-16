package Session26;

import java.util.Arrays;

public class DjikstraAlgorithm {

	static class Graph {
		int numV;
		int[][] costMatrix;

		class Edge {
			int u, v;

			public Edge(int u, int v) {
				// TODO Auto-generated constructor stub
				this.u = u;
				this.v = v;
			}

			@Override
			public String toString() {
				// TODO Auto-generated method stub
				return "{" + u + ", " + v + "}";
			}
		}

		public Graph(int[][] conn) {
			// TODO Auto-generated constructor stub
			this.numV = conn.length;

			this.costMatrix = new int[conn.length][conn.length];

			// jahan 0 hai wahan edge ni hai to cost Infinity

			for (int i = 0; i < numV; i++) {
				for (int j = 0; j < numV; j++) {
					if (conn[i][j] == 0) {// no edge
						costMatrix[i][j] = 999999;
					} else {
						costMatrix[i][j] = conn[i][j];
					}
				}
			}

			for (int i = 0; i < numV; i++) {
				for (int j = 0; j < numV; j++) {

					if (costMatrix[i][j] == 999999)
						System.out.print("X ");
					else
						System.out.print(costMatrix[i][j] + " ");
				}
				System.out.println();
			}
		}
		
		private void djikstra(int src) {
			// TODO Auto-generated method stub

			boolean[] vis = new boolean[this.numV];
			vis[src] = true;
			
			System.out.println("Node chosen is : " + src);
			int[] dis = new int[this.numV]; //src to ith node
			
			for(int node = 0; node < this.numV ; node++) {
				dis[node] = this.costMatrix[src][node];
			}
			
			System.out.println(Arrays.toString(dis));
			
			int nextChosen;
			for(int count = 1; count < this.numV; count++) {
				
				for(nextChosen = 0; nextChosen < this.numV; nextChosen++) {
					if(!vis[nextChosen]) {
						break;
					}
				}
				
				for(int k = nextChosen + 1; k < this.numV; k++) {
					if(!vis[k] && dis[k] < dis[nextChosen]) {
						nextChosen = k;
					}
				}
				vis[nextChosen] = true;
				System.out.println("Node chosen is : " + nextChosen);
				for(int neigh = 0; neigh < this.numV; neigh++) {
					
					if(!vis[neigh] && dis[neigh] > dis[nextChosen] + this.costMatrix[nextChosen][neigh]) {
						dis[neigh] = dis[nextChosen] + this.costMatrix[nextChosen][neigh];
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
				{ 0, 8, 0, 7, 0, 4, 0, 0, 2 }, { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
				{ 0, 0, 4, 14, 10, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
				{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

		Graph g = new Graph(graph);
		g.djikstra(0);
	}

}
