import java.util.Random;

public class Die {

	private int sides;
	private Random r;
	
	public Die(int s){
		sides = s;
		r = new Random();
	}
	
	public int rollDie(){
		return r.nextInt(sides)+1;
	}
}
