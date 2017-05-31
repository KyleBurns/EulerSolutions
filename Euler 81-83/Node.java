import java.util.LinkedList;

public class Node {

	private LinkedList<Integer> adjacencyList;
	private int value;
	@SuppressWarnings("unused")
	private int index;
	
	//Dijkstra variables
	public int cost;
	public boolean visited;
    public int predecessor;
    
    
	public Node(int v){
		adjacencyList = new LinkedList<Integer>();
		value = v;
	}
	
	public void addToAdjList(int n){
		adjacencyList.add(n);
	}
	
	public LinkedList<Integer> getAdjList(){
		return adjacencyList;
	}

	public int getValue(){
		return value;
	}
}
