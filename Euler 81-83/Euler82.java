import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Solution to Project Euler problem 82, using a graph-based solution using
 * Dijkstra's algorithm to find the shortest path between two points of a n x n
 * matrix.
 * @author Kyle
 *
 */

public class Euler82 {
	
	public static void main(String[] args) throws FileNotFoundException{
		DirectedGraph g = buildMatrixGraph();
		int minPathSum = 1000000; 
		
		//For each left-most node, find the min cost from that node to each right-most node and
		//find the minimum left-to-right path that can be taken
		for(int i=0;i<g.size();i+=Math.sqrt(g.size())){
			g.Dijkstra(i);
			for(int j=79;j<g.size();j+=Math.sqrt(g.size())){
				if(g.getNode(j).cost < minPathSum)
					minPathSum = g.getNode(j).cost;
			}
		}
		System.out.println(minPathSum);
	}
	
	public static DirectedGraph buildMatrixGraph() throws FileNotFoundException{
		File f = new File("matrix2.txt");
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
