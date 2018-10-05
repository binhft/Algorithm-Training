import java.util.ArrayList;
import java.util.List;

public class Solution {
	class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		int distance(Node node) {
			return Math.abs(this.x - node.x) + Math.abs(this.y - node.y) - 1;
		}

		void print() {
			System.out.println("(" + this.x + "," + this.y + ")");
		}
	}

	class Graph {
		List<Node> nodeList;

		public Graph() {
			this.nodeList = new ArrayList<Node>();
		}

		void addNode(Node node) {
			this.nodeList.add(node);
		}

		int minDistance(Graph graph) {
			int min = Integer.MAX_VALUE;
			for (Node n : nodeList) {
				for (Node n2 : graph.nodeList) {
					min = Math.min(min, n.distance(n2));
				}
			}
			return min;
		}

		void print() {
			for (Node node : nodeList) {
				node.print();
			}
		}
	}

	boolean isSafe(int M[][], int row, int col, boolean visited[][], int numRow, int numCol) {
		// row number is in range, column number is in range
		// and value is 1 and not yet visited
		return (row >= 0) && (row < numRow) && (col >= 0) && (col < numCol) && (M[row][col] == 1 && !visited[row][col]);
	}

	void DFS(int M[][], int row, int col, boolean visited[][], int numRow, int numCol, Graph graph) {
		// These arrays are used to get row and column numbers
		// of 8 neighbors of a given cell
		int rowNbr[] = new int[] { -1, 0, 0, 1 };
		int colNbr[] = new int[] { 0, -1, 1, 0 };

		// Mark this cell as visited
		visited[row][col] = true;

		// Recur for all connected neighbours
		for (int k = 0; k < 4; ++k) {
			if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited, numRow, numCol)) {
				graph.addNode(new Node(row + rowNbr[k], col + colNbr[k]));
				DFS(M, row + rowNbr[k], col + colNbr[k], visited, numRow, numCol, graph);
			}
		}

	}

	int bridgesCost(String[] nationalMap) {
		int nRow = nationalMap[0].length();
		int nCol = nationalMap.length;
		int[][] map = new int[nRow][nationalMap.length];
		for (int col = 0; col < nationalMap.length; col++) {
			for (int row = 0; row < nRow; row++) {
				map[row][col] = nationalMap[col].charAt(row) - '0';
			}
		}
		boolean visited[][] = new boolean[nRow][nCol];

		// Initialize count as 0 and travese through the all cells
		// of given matrix
		List<Graph> graphList = new ArrayList<Graph>();
		for (int i = 0; i < nRow; ++i)
			for (int j = 0; j < nCol; ++j)
				if (map[i][j] == 1 && !visited[i][j]) // If a cell with
				{ // value 1 is not
					// visited yet, then new island found, Visit all
					// cells in this island and increment island count
					Graph graph = new Graph();
					graph.addNode(new Node(i, j));
					DFS(map, i, j, visited, nRow, nCol, graph);
					graphList.add(graph);
				}

		int[][] matrix = new int[graphList.size()][graphList.size()];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = 0;
			}
		}
//		System.out.println(graphList.get(0).minDistance(graphList.get(1)));
//		System.out.println();
		for (int i = 0; i < graphList.size(); i++) {
			System.out.println("Component " + i);
			graphList.get(i).print();
		}
		for (int i = 0; i < graphList.size(); i++) {
			for (int j = i + 1; j < graphList.size(); j++) {
				matrix[i][j] = graphList.get(i).minDistance(graphList.get(j));
				matrix[j][i] = graphList.get(i).minDistance(graphList.get(j));
			}
		}
		System.out.println("Numer of connected component: " + graphList.size());
		return primMST(matrix);
	}

	int minKey(int key[], Boolean mstSet[]) {
		// Initialize min value
		int min = Integer.MAX_VALUE, min_index = -1;

		for (int v = 0; v < key.length; v++)
			if (mstSet[v] == false && key[v] < min) {
				min = key[v];
				min_index = v;
			}

		return min_index;
	}

	// A utility function to print the constructed MST stored in
	// parent[]
	int calMST(int parent[], int n, int graph[][]) {
		int res = 0;
//		System.out.println("Edge \tWeight");
		for (int i = 1; i < graph.length; i++) {
			res += graph[i][parent[i]];
			System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
		}
		return res;
//			
	}

	// Function to construct and print MST for a graph represented
	// using adjacency matrix representation
	int primMST(int graph[][]) {
		// Array to store constructed MST
		int parent[] = new int[graph.length];

		// Key values used to pick minimum weight edge in cut
		int key[] = new int[graph.length];

		// To represent set of vertices not yet included in MST
		Boolean mstSet[] = new Boolean[graph.length];

		// Initialize all keys as INFINITE
		for (int i = 0; i < graph.length; i++) {
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}

		// Always include first 1st vertex in MST.
		key[0] = 0; // Make key 0 so that this vertex is
					// picked as first vertex
		parent[0] = -1; // First node is always root of MST

		// The MST will have V vertices
		for (int count = 0; count < graph.length - 1; count++) {
			// Pick thd minimum key vertex from the set of vertices
			// not yet included in MST
			int u = minKey(key, mstSet);

			// Add the picked vertex to the MST Set
			mstSet[u] = true;

			// Update key value and parent index of the adjacent
			// vertices of the picked vertex. Consider only those
			// vertices which are not yet included in MST
			for (int v = 0; v < graph.length; v++)

				// graph[u][v] is non zero only for adjacent vertices of m
				// mstSet[v] is false for vertices not yet included in MST
				// Update the key only if graph[u][v] is smaller than key[v]
				if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
					parent[v] = u;
					key[v] = graph[u][v];
				}
		}

		// print the constructed MST
		return calMST(parent, graph.length, graph);
	}

	public static void main(String[] args) {
//		System.out.println(
//				new Solution().bridgesCost(new String[] { "11000", "11000", "00100", "00010", "00111", "00111" }));
		System.out.println(new Solution().bridgesCost(new String[] { "1001", "0000", "0010", "0000", "0101" }));
	}

}
