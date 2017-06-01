import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		Die d1 = new Die(4);
		Die d2 = new Die(4);
		int position = 0;
		ArrayList<Square> Board = new ArrayList<Square>();
		
		LinkedList<Integer> chestCard = new LinkedList<Integer>(Arrays.asList(-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,0,10));
		Collections.shuffle(chestCard);
		
		LinkedList<Integer> chanceCard = new LinkedList<Integer>(Arrays.asList(-1,-1,-1,-1,-1,-1,0,10,11,24,39,5,-2,-2,-3,-4));
		Collections.shuffle(chanceCard);
		
		for(int i=0;i<40;i++)
			Board.add(new Square(i));
		
		for(int i=0;i<10000000;i++){
			position = (position + d1.rollDie() + d2.rollDie())%40;
			switch(position){
				case 30:
					position = 10;
					break;
				case 2: case 17: case 33:
					int chestCardResult = chestCard.removeLast();
					if(chestCardResult != -1)
						position = chestCardResult;
					chestCard.addFirst(chestCardResult);
					break;
				case 7: case 22: case 36:
					int chanceCardResult = chanceCard.removeLast();
					if(chanceCardResult >= 0)
						position = chanceCardResult;
					else if(chanceCardResult == -3)
						position = (position-3)%40;
					else if(chanceCardResult == -4){
						if(position == 22) position = 28;
						else position = 12;
					}
					else if(chanceCardResult == -2){
						if(position == 2) position = 5;
						else if(position == 17) position = 25;
						else position = 35;
					}
					chanceCard.addFirst(chanceCardResult);
					break;
			}
			Board.get(position).visit();
		}
		
		
		for(int i=0;i<Board.size();i++){
			if(Board.get(i).getVisits() > 300000)
				System.out.println(i + "\t" + Board.get(i).getVisits());
		}
	}

}
