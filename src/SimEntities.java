import java.awt.Color;


public abstract class SimEntities {
	int xPos;
	int yPos;
	int range;
	Color color;
	SimEntities[][] view;

	public SimEntities(int r){
		this.range = r;
	}
	
 public abstract void update(World w);
 public abstract void move();
 

}
