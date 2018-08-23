import java.awt.Color;


public class Prey extends SimEntities{

	public Prey(int r) {
		super(r);
		this.xPos = (int) (Math.random()*World.xSize);
		this.yPos = (int) (Math.random()*World.ySize);
		this.color = Color.RED;
	}

	@Override
	public void update(World w) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}

}
