import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;


public class World {

	public static int xSize = 100;
	public static int ySize = 100;
	public static SimEntities[][] board = new SimEntities[xSize][ySize];
	
	ArrayList<SwarmAgent> swarmList;
	ArrayList<Prey> preyList;
	
	public static double time;
	JFrame frame = new JFrame();
	
	World(ArrayList<SwarmAgent> a, ArrayList<Prey> p){
		this.swarmList = a;
		this.preyList = p;
		
		populate_world();
	}
	
	private void populate_world(){
		for(int i = 0; i< swarmList.size(); i++){
			board[swarmList.get(i).xPos][swarmList.get(i).yPos] =swarmList.get(i);
		}
		for(int i = 0; i<preyList.size(); i++){
			board[preyList.get(i).xPos][preyList.get(i).yPos] = preyList.get(i);
		}
	}
	
	private void update(){
		clear();
		for(int i = 0; i<swarmList.size(); i++){
			board[swarmList.get(i).xPos][swarmList.get(i).yPos] =swarmList.get(i);
		}
		for(int i = 0; i<preyList.size(); i++){
			board[preyList.get(i).xPos][preyList.get(i).yPos] = preyList.get(i);
		}
		
	}
	private void clear(){
		for(int i =0; i< xSize; i++){
			for(int j =0; j<ySize; j++){
				board[i][j] = null;
			}
		}
	}
	
	void drawframe() { 
		 
	  	frame.getContentPane().add(new DrawSim(this));
	  	frame.setBackground(Color.GRAY);
	  	frame.setSize(800, 800);
	  	frame.setLocationRelativeTo(null);
	  	frame.setVisible(true); 
	  	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	

	  }
	
	public static SimEntities[][] getView(int x, int y, int range){
		SimEntities[][] view = new SimEntities[2*range +1][2* range +1];
		for(int i = x -range; i <= x +range; i++){
			for(int j = y -range; j <= y + range; j++){
				if(i>= 0 && i <100 && j>= 0 && j <100){
					board[i][j] = view[i - x +range][j -y + range];
				}
				else{
					view[i - x +range][j -y + range] =new Wall(0);
				}
			}
		}
		
		return board;
	}
	
	public static void main(String[] args) {
		int agentRange =5;
		int preyRange = 5;
		int num_agents = 50;
		
		time = System.currentTimeMillis();
		Prey p = new Prey(preyRange);

		ArrayList<Prey> M = new ArrayList<Prey>();
		M.add(p);

		
		ArrayList<SwarmAgent> A = new ArrayList<SwarmAgent>();
		for(int i = 0; i <num_agents; i++){
			A.add(new SwarmAgent(agentRange));
		}
		
		World w = new World(A,M);
		w.drawframe();
		
		while(1 < 2){
			
			double t = (System.currentTimeMillis()-time);
			
	  		if(t > 150){
		        time = System.currentTimeMillis();
				for(int i = 0; i <w.swarmList.size(); i++){
					w.swarmList.get(i).update(w);
					w.update();				
				}
				for(int i = 0; i <w.preyList.size(); i++){
					w.preyList.get(i).update(w);
					w.update();					
				}				
	  		}
	  		
	  		else{
	  			 try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	  		}
		}

	}
	
}
