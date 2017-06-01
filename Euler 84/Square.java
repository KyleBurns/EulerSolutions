public class Square {

	@SuppressWarnings("unused")
	private int visits;
	@SuppressWarnings("unused")
	private int index;
	
	public Square(int i){
		visits = 0;
		index = i;
	}
	
	public void visit(){
		visits++;
	}
	
	public int getVisits(){
		return visits;
	}
}
