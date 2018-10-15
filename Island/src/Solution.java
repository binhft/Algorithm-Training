import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	private int amountColumns;
	private boolean[][] matrix;
	private boolean[][] connected;
	int currentMin = Integer.MAX_VALUE;

	private int solve() {
		// define the first starting point. All lakes have to be connected in the end so
		// it doesn't matter which one is first
		// but it removes some choice, less runtime
		outer: for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < amountColumns; col++) {
				if (matrix[row][col]) {
					markConnected(row, col);
					break outer;
				}
			}
		}
		return solve(0);
	}

	private int solve(int fieldsAdded) {
		// implementation for first row. we know that the first thing we will find, will
		// already be marked as connected
		// Option 1, do nothing:
		int minSolution = solve(1, fieldsAdded, 0, 0, 0);

		// Option 2, connect two lakes:
		int lastNode = -1;// the last filled node
		for (int col = 0; col < amountColumns; col++) {
			if (matrix[0][col]) {
				if (lastNode == -1) {
					// no lastNode yet, don't do anything
				} else if (!connected[0][col]) {
					// Here again an option
					minSolution = evaluateOptionConnect(0, lastNode, col, fieldsAdded, minSolution, 0, 0, 0);
				} else {
					// if we found an already connected node, no need to further connect it with
					// other connected ones
					// but we can connect it with not connected ones
					if (!connected[0][lastNode]) {
						// Here again an option
						minSolution = evaluateOptionConnect(0, col, lastNode, fieldsAdded, minSolution, 0, 0, 0);
					}
				}
				// set the current node as last lake
				lastNode = col;
			}
		}
		return minSolution;
	}

	private int solve(int row, int fieldsAdded, int l1Progress, int l2Progress, int l3Progress) {
		if (fieldsAdded >= currentMin) {
			return currentMin;
		}
		// stop if row is greater than allowed
		if (row == matrix.length) {
			// check if the solution connected all lakes
			if (Arrays.deepEquals(matrix, connected)) {
				currentMin = fieldsAdded;
				return fieldsAdded;
			}
			return Integer.MAX_VALUE;
		}

		// try solving next layer, maybe it already works
		int minSolution = solve(row + 1, fieldsAdded, 0, 0, 0);

		// first and foremost if there are any not connected lakes that ended last row,
		// here is the last chance to connect them.
		// However since the same lake can end to this layer multiple times, we have to
		// see for each if it is enough
		for (int col = l1Progress; col < amountColumns; col++) {
			if (matrix[row - 1][col] && !matrix[row][col] && !connected[row - 1][col]) {
				if ((col > 0 && matrix[row - 1][col - 1] && matrix[row][col - 1])
						|| (col < amountColumns - 1 && matrix[row - 1][col + 1] && matrix[row][col + 1]))
					continue;// if the previous layer is already connected through a neighbour, no need to do
								// it
				matrix[row][col] = true;
				minSolution = Math.min(minSolution, solve(row, fieldsAdded + 1, col, l2Progress, l3Progress));
				matrix[row][col] = false;
			}
		}

		// if there are any connected lakes before, they can get connected through this
		// layer
		// There may be multiple ways to make the connection through this layer, we need
		// to try all
		for (int col = l2Progress; col < amountColumns; col++) {
			if (matrix[row - 1][col] && !matrix[row][col] && connected[row - 1][col]) {
				if ((col > 0 && matrix[row - 1][col - 1] && matrix[row][col - 1])
						|| (col < amountColumns - 1 && matrix[row - 1][col + 1] && matrix[row][col + 1]))
					continue;// if the previous layer is already connected through a neighbour, no need to do
								// it
				matrix[row][col] = true;
				boolean[][] copyConnected = copyConnected();
				markConnected(row, col);
				minSolution = Math.min(minSolution, solve(row, fieldsAdded + 1, amountColumns, col, 0));
				// undo again for the next option
				connected = copyConnected;
				matrix[row][col] = false;
			}
		}
		// maybe we can connect two lakes on this layer
		int lastNode = -1;// the last lake
		for (int col = l3Progress; col < amountColumns; col++) {
			if (matrix[row][col]) {
				if (lastNode == -1) {
					// no lastNode yet, don't do anything
				} else if (!connected[row][col]) {
					// Here again an option
					minSolution = evaluateOptionConnect(row, lastNode, col, fieldsAdded, minSolution, amountColumns,
							amountColumns, col);
				} else {
					// if we found an already connected node, no need to further connect it with
					// other connected ones
					// but we can connect it with not connected ones
					if (!connected[row][lastNode]) {
						// Here again an option
						minSolution = evaluateOptionConnect(row, col, lastNode, fieldsAdded, minSolution, amountColumns,
								amountColumns, col);
					}
				}
				// set the current node as last lake
				lastNode = col;
			}
		}
		return minSolution;
	}

	private int evaluateOptionConnect(int row, int startNode, int targetNode, int fieldsAdded, int minSolution,
			int l1Progress, int l2Progress, int l3Progress) {
		if (Math.abs(startNode - targetNode) < 2)
			return minSolution;// no need to try to connect two neighbouring nodes
		boolean[][] copyConnected = copyConnected();
		int newFields = connect(row, startNode, targetNode);
		if (newFields < 0) {
			// connecting was refused, will be handled by another branch
			return minSolution;
		}
		fieldsAdded += newFields;
		if (fieldsAdded < minSolution) {
			if (row > 0)
				minSolution = Math.min(solve(row, fieldsAdded, l1Progress, l2Progress, l3Progress), minSolution);
			else
				minSolution = Math.min(solve(fieldsAdded), minSolution);
		}
		// undo it again
		undoConnect(row, startNode, targetNode);
		connected = copyConnected;
		return minSolution;
	}

	private boolean[][] copyConnected() {
		boolean[][] copy = new boolean[connected.length][];
		for (int row = 0; row < connected.length; row++)
			copy[row] = Arrays.copyOf(connected[row], amountColumns);
		return copy;
	}

	/**
	 * Connects the startField with the targetField and marks all fields as
	 * connected if startField was connected It assumes TargetFields is not yet
	 * connected
	 * 
	 * @return how many new fields were marked. If -1 is returned the connection was
	 *         refused because it will be solved by a different branch
	 */
	private int connect(int row, int startField, int targetField) {
		int newFieldsMarked;
		// only mark new fields as connected if the startField is connected
		boolean isConnected = connected[row][startField];
		// connect the fields
		if (startField < targetField) {
			for (int i = startField + 1; i < targetField; i++) {
				matrix[row][i] = true;
				if (isConnected)
					markConnected(row, i);
				else if (row > 0 && connected[row - 1][i]) {
					// there is the special case that it is not connected, but previous row has a
					// connected field
					// in this case refuse the connecting, this case is handled by a different
					// branch
					// need to undo connecting so far
					for (int j = startField + 1; j <= i; j++)
						matrix[row][j] = false;
					return -1;
				}
			}
			newFieldsMarked = targetField - startField - 1;
		} else {
			for (int i = startField - 1; i > targetField; i--) {
				matrix[row][i] = true;
				if (isConnected)
					markConnected(row, i);
				else if (row > 0 && connected[row - 1][i]) {
					// there is the special case that it is not connected, but previous row has a
					// connected field
					// in this case refuse the connecting, this case is handled by a different
					// branch
					// need to undo connecting so far
					for (int j = startField - 1; j >= i; j--)
						matrix[row][j] = false;
					return -1;
				}
			}
			newFieldsMarked = startField - targetField - 1;
		}

		// mark all targetFields as connected
		if (isConnected)
			markConnected(row, targetField);
		return newFieldsMarked;
	}

	private void markConnected(int row, int column) {
		if (connected[row][column])
			return;
		connected[row][column] = true;
		if (row - 1 >= 0 && matrix[row - 1][column])
			markConnected(row - 1, column);
		if (row + 1 < matrix.length && matrix[row + 1][column])
			markConnected(row + 1, column);
		if (column - 1 >= 0 && matrix[row][column - 1])
			markConnected(row, column - 1);
		if (column + 1 < amountColumns && matrix[row][column + 1])
			markConnected(row, column + 1);
	}

	// undo functions for the two previous:

	private void undoConnect(int row, int startField, int targetField) {
		// the fields inbetween were added, undo them
		// removing connected mark doesn't work, so that is solved by copying the
		// connected array.
		if (startField < targetField) {
			for (int i = startField + 1; i < targetField; i++) {
				matrix[row][i] = false;
			}
		} else {
			for (int i = startField - 1; i > targetField; i--) {
				matrix[row][i] = false;
			}
		}
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

	int bridgesCost(String[] nationalMap) {
		if (nationalMap == null || nationalMap.length == 0) {
			return 0;
		}
		int nRow = nationalMap[0].length();
		int nCol = nationalMap.length;
		boolean[][] map = new boolean[nCol][nRow];
		int[][] map2 = new int[nRow][nCol];
		for (int col = 0; col < nationalMap.length; col++) {
			for (int row = 0; row < nRow; row++) {
				map[col][row] = (nationalMap[col].charAt(row) == '1');
				map2[row][col] = (nationalMap[col].charAt(row) - '0');

			}
		}

		boolean visited[][] = new boolean[nRow][nCol];
		List<Graph> graphList = new ArrayList<Graph>();
		for (int i = 0; i < nRow; ++i)
			for (int j = 0; j < nCol; ++j)
				if (map2[i][j] == 1 && !visited[i][j]) // If a cell with
				{ // value 1 is not
					// visited yet, then new island found, Visit all
					// cells in this island and increment island count
					Graph graph = new Graph();
					graph.addNode(new Node(i, j));
					DFS(map2, i, j, visited, nRow, nCol, graph);
					graphList.add(graph);
				}

		if (graphList.size() <= 1) {
			return 0;
		} else if (graphList.size() == 2) {
			return graphList.get(0).minDistance(graphList.get(1));
		}

		int[][] matrix2 = new int[graphList.size()][graphList.size()];
		for (int i = 0; i < matrix2.length; i++) {
			for (int j = 0; j < matrix2.length; j++) {
				matrix2[i][j] = 0;
			}
		}
		for (int i = 0; i < graphList.size(); i++) {
			for (int j = i + 1; j < graphList.size(); j++) {
				matrix2[i][j] = graphList.get(i).minDistance(graphList.get(j));
				matrix2[j][i] = graphList.get(i).minDistance(graphList.get(j));
			}
		}
		currentMin = primMST(matrix2);

		matrix = map;
		this.connected = new boolean[matrix.length][nationalMap[0].length()];
		amountColumns = nRow;

		return solve();
	}

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

	public static void main(String[] args) {
//		System.out.println(
//				new Solution().bridgesCost(new String[] { "11000", "11000", "00100", "00010", "00111", "00111" }));
//		System.out.println(new Solution().bridgesCost(
//				new String[] { "10010010", "00000000", "00100001", "00000010", "01010000", "00000000", "01010001" }));
		System.out.println(new Solution().bridgesCost(
				new String[] { "10000000", "00000000", "00000000", "00000000", "00000000", "00000000", "10000001" }));
	}

}
