import java.util.LinkedList;

public class DirectedGraph {
	private LinkedList<Node> Nodes;
	
	public DirectedGraph(){
		Nodes = new LinkedList<Node>();
	}
	
	public void add(int value){
		Node n = new Node(value);
		Nodes.add(n);
	}
	
	public Node getNode(int n){
		return Nodes.get(n);
	}
	
	public void createEdge(int a, int b){
		Nodes.get(a).addToAdjList(b);
	}
	
	public int size(){
		return Nodes.size();
	}

	/**
	 carry out Dijkstra's algorithm on the graph, finding the minimum distance from the given
	 node to each other node in the graph.
	 */
	public void Dijkstra(int start){
		
		//Initialise Node pointer
		Node cursor = null;
	
		//Initialise (find starting node and set cost to zero, set cost of others to infinite)
		for(int i=0;i<size();i++){
			if(i == start){
				cursor = Nodes.get(i);
				cursor.visited = true;
				cursor.predecessor = 0;
				cursor.cost = cursor.getValue();
			}
			else{
				Nodes.get(i).visited = false;
				Nodes.get(i).cost = 1000000;
			}
		}
		
		//Loop a maximum of (numVertices) times:
		for(int i=0;i<size();i++){
			
			//Perform relaxation
			LinkedList<Integer> l = cursor.getAdjList();
			//For each node in the adjacent list of the current node:
			for (int index : l){
				//Get the corresponding node
				Node n = Nodes.get(index);
				//If it hasn't been visited and its current cost can be reduced:
				if(!n.visited && n.cost > cursor.cost+n.getValue()){
					//Reduce the cost of the node and set its predecessor to the cursor node
					n.predecessor = Nodes.indexOf(cursor);
					n.cost = cursor.cost+n.getValue();
				}
			}
			
			//Find the node of minimum cost
			Node minNode = null;
			int mini = 1000000;
			
			for (Node n : Nodes){					
				if(!n.visited && n.cost < mini){		
					minNode = n;
					mini = minNode.cost;
				}
			}
			
			//If every remaining node has infinite cost, then no more nodes can be reached
			if(minNode == null)
				break;
			
			//Visit the node of minimum cost and set the cursor to point to it
			minNode.visited = true;
			cursor = minNode;	
		}
	}
}
