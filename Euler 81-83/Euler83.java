import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Solution to Project Euler problem 83, using a graph-based solution using
 * Dijkstra's algorithm to find the shortest path between two points of a n x n
 * matrix.
 * @author Kyle
 *
 */

public class Euler83 {
	
	public static void main(String[] args) throws FileNotFoundException{
		DirectedGraph g = buildMatrixGraph();
		
		//Get the shortest path sum from the top-left to bottom-right node
		g.Dijkstra(0);
		System.out.println(g.getNode(g.size()-1).cost);
	}
	
	public static DirectedGraph buildMatrixGraph() throws FileNotFoundException{
		File f = new File("matrix.txt");
		Scanner s = new Scanner(f);
		DirectedGraph g = new DirectedGraph();
		
		//Initialise adjaency lists
		while(s.hasNextLine()){
			String[] line = s.nextLine().split(",");
			for(int i=0;i<line.length;i++){
				g.add(Integer.parseInt(line[i]));
				if(i > 0){
					g.createEdge(g.size()-1, g.size()-2);
					g.createEdge(g.size()-2, g.size()-1);}
				if(g.size() >= line.length+1){
					g.createEdge(g.size()-line.length-1, g.size()-1);
					g.createEdge(g.size()-1, g.size()-line.length-1);}
			}
		}
		s.close();
		return g;
	}


}