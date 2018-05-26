import java.util.ArrayList;


public class Player extends GamePiece{
	private int carryWeight=0;
	public int getCarryWeight() {
		return carryWeight;
	}


	public void setCarryWeight(int carryWeight) {
		this.carryWeight = carryWeight;
	}
	ArrayList<String> al = new ArrayList<String>();
	 
	public char charRepresentation() {
		return 'X';
	}
	
	
	public void addWeight(int wt){
		setCarryWeight(getCarryWeight() + wt);
			
	}
	public void removeWeight(int wt){
		setCarryWeight(getCarryWeight() - wt);
	}


	
	}

	

