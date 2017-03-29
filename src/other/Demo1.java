package other;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFrame;

public class Demo1 extends JFrame{
	int[][] snake = new int[20][20]; 
	public void Demo1(){
		this.setSize(400, 400);
		this.setVisible(true);
		for(int i = 0;i<=7;i++){
			snake[i][8]=1;
		}
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e){
				switch (e.getKeyCode()) {
				case KeyEvent.VK_DOWN:
					snake[10][8]=1;
					break;
				case KeyEvent.VK_UP:
					System.out.println("up");
					break;
				case KeyEvent.VK_LEFT:
					System.out.println("left");
					break;
				case KeyEvent.VK_RIGHT:
					System.out.println("right");
					break;
				default:
					break;
				}
			}
		});
	}

	public void paint(Graphics g){
		g.setColor(Color.RED);
		for(int i=0;i<20;i++){
			for(int j = 0;j<20;j++){
				if(snake[i][j]==1){
					g.fillRect(i*20+200, j*20+100, 20, 20);
				}
			}
		}
	}
	
	public void run(){
		
	}
	
	public static void main(String[] args){
		Demo1 demo1 = new Demo1();
		demo1.Demo1();
	}

}
