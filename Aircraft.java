import java.awt.Color;
import java.awt.Graphics;

public class Aircraft {
	// за точку отсчета взята "мишень" в самолете - условный центр самолета, в который целится ракета
	int x; 	// координата по x	
	int y;	// координата по y

	// конструктор "по умолчанию"
	public Aircraft() {
		x = 0;
		y = 0;
	}

	// установить стартовую позицию самолета
	public void setStartPosition(int xStart, int yStart) {			
		x = xStart - 60;
		y = yStart;			
	}
	
		
	// сместить позицию влево
	public void move() {
		x = x - 10;	
        if (y<30) y=y+30;
        else if (y>400) y=y-25;
        if (x>400)y=y-10;
        else if (x>300) y=y+10;
        else if (x>200) y=y-10;
        else if (x>70) y=y+10;
	}
	
	public void moveBoom()
	{
		x=x-20;
		y=y+30;
	}

	// получить X координату положения мишени самолета
	public int getX() {
		return x;
	}

	// получить Y координату положения мишени самолета
	public int getY() {
		return y;
	}
		
	
	// рисуем самолет
	public void draw(Graphics g) {
		
		g.setColor(Color.BLACK);
				
		// фюзеляж
		g.drawLine(x - 60, y + 20, x - 30, y - 10);
		g.drawLine(x - 30, y - 10, x + 40, y - 10);
		g.drawLine(x + 40, y - 10, x + 60, y - 30);		
		g.drawLine(x + 60, y - 30, x + 60, y - 0);
		g.drawLine(x + 60, y - 0, x - 60, y + 20);
		
		// кабина пилота
		g.drawLine(x - 40, y - 0, x - 5, y - 10);
		
				
		// левое крыло
		g.drawLine(x + 10, y + 2, x + 60, y + 20);
		g.drawLine(x + 60, y + 20, x + 43, y - 2);

		// правое крыло		
		g.drawLine(x + 10, y - 10, x + 35, y - 30);
		g.drawLine(x + 35, y - 30, x + 40, y - 10);
		
		// мишень - сюда целится ракета
		g.setColor(Color.RED);
		g.fillOval(x-2, y-2, 5, 5);
		

	}
	
public void drawBoom(Graphics g) {	
		g.setColor(Color.RED);
		g.drawLine(x + 40, y, x -40, y);
		g.drawLine(x, y +40, x, y -40);
	}

}
