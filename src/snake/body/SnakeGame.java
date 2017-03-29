package snake.body;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class SnakeGame extends JFrame implements KeyListener{

	private int stat = 1,direction = 0,bodylen = 6,headx =7,heady=8,tailx =1,taily=8,tail,foodx,foody,food;
	public final int EAST =1,WEST =2,SOUTH =3,NORTH=4;
	int[][] fillblock = new int[20][20];
	
	public SnakeGame(){
		super("贪吃蛇");
		setSize(510,510);
		setVisible(true);
		addKeyListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for(int i =1;i<=7;i++){
			fillblock[i][8]=EAST;
		}
		direction=EAST;
		FoodLocate();
		while(stat ==1){
			fillblock[headx][heady]=direction;
			switch (direction) {
			case 1:headx++;
				   break;
			case 2:headx--;
			   break;
			case 3:heady++;
			   break;
			case 4:heady--;
			   break;			   
			}
		}
	}
	
	private void FoodLocate() {
		
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
