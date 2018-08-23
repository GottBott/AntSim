import java.awt.Graphics;

import javax.swing.JPanel;


public class DrawSim extends JPanel{

	private static final long serialVersionUID = 1L;
	World world;
	
	DrawSim(World W){
		this.world = W;
	}
    
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    
    for(int i = 0; i < world.swarmList.size(); i++){
    	g.setColor(world.swarmList.get(i).color);
    	g.fillRect(world.swarmList.get(i).xPos*8, world.swarmList.get(i).yPos*8, 8, 8);
    	//g.drawRect(world.agents.get(i).x*12 - 12*world.agents.get(i).range, world.agents.get(i).y*12 -12*world.agents.get(i).range, 24*world.agents.get(i).range, 24*world.agents.get(i).range);
    }
    for(int i = 0; i < world.preyList.size(); i++){
    	g.setColor(world.preyList.get(i).color);
        g.fillRect(world.preyList.get(i).xPos*8, world.preyList.get(i).yPos*8, 8, 8);
    }
    
    
    repaint();
  
    
  }
}
