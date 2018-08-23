import java.awt.Color;


public class SwarmAgent extends SimEntities {

	public int awarenessLevel = 0;
	int rangeIterate;
	
	public SwarmAgent(int r) {
		super(r);
		this.rangeIterate =2*r+1;
		this.xPos = (int) (Math.random()*World.xSize);
		this.yPos = (int) (Math.random()*World.ySize);
		this.color = Color.BLACK;
		this.view = World.getView(xPos,yPos,r);
	}

	@Override
	public void update(World w) {
		view = World.getView(xPos, yPos, range);
		
		move();
		
	}

	@Override
	public void move() {
		
		disperse();
		
	}

	private void track(){
		
	}
	private void disperse(){
//		if(xPos < 98){
//			xPos ++;
//		}
		char direction;
		
		int xScore =0;
		int yScore = 0;
		
		for(int i = 0; i < 2*range +1; i++){
			for(int j = 0; j < 2*range +1; j++){
				//System.out.println(i + " , " + j);
				if(view[i][j] instanceof SwarmAgent &&( i != range && j != range)){
					xScore = xScore + range -(Math.abs(range - i));
					yScore = yScore + range -(Math.abs(range - j));
					//System.out.println(i + " , " + j);
					direction = 'o';
				}
			}
			
		}
		for(int i = 0; i < 2*range +1; i++){
			for(int j = 0; j < 2*range +1; j++){
				
			}
			
		}
		
	}
}
