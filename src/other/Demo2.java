package other;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JFrame;

import sun.font.EAttribute;

public class Demo2 extends JFrame{
	int[][] snake = new int[20][20]; 
	int headx =8,heady = 5;
	int tailx =0,taily = 5;
	public final int EAST =1,WEST =2,SOUTH =3,NORTH=4;
	int diretion = 0;
	boolean start = true;
	public void Demo2(){
		this.setSize(400, 400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		for(int i = 1;i<=7;i++){
			snake[i][5]=1;
		}
		diretion=EAST;
		
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e){
				switch (e.getKeyCode()) {
				case KeyEvent.VK_DOWN:
					diretion=SOUTH;
					break;
				case KeyEvent.VK_UP:
					diretion=NORTH;
					break;
				case KeyEvent.VK_LEFT:
					diretion=WEST;
					break;
				case KeyEvent.VK_RIGHT:
					diretion=EAST;
					break;
				default:
					break;
				}
			}
		});
		
		new Thread(new PaintThread()).start();
	}
	
	
	public void paint(Graphics g){
		g.setColor(Color.RED);
		for(int i=0;i<20;i++){
			for(int j = 0;j<20;j++){
				if(snake[i][j]==1){
					g.fillRect(i*25, j*25, 20, 20);
				}
			}
		}
	}
	 private class PaintThread implements Runnable {

	        @Override
	        public void run() {
	            while(start) {
	            	try {
						Thread.sleep(5000);
							snake[headx][heady]=EAST;
							snake[tailx][taily]=0;
							switch (diretion) {
							case 1:
								headx++;
								tailx++;
								break;
							case 2:
								headx--;
								tailx--;
								break;
							case 3:
								heady++;
								taily++;
								break;
							case 4:
								heady--;
								taily--;
								break;				
							default:
								break;
							}
						
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
	                repaint();
	                if(headx>=19||heady>=19||headx<0||heady<0){
	                	start=false;
	                }
	            }
	        }

	    }
	public static void main(String[] args) {
		Demo2 demo2 = new Demo2();
		demo2.Demo2();

	}

}
