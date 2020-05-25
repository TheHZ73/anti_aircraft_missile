import java.awt.Color;
import java.awt.Graphics;

public class Aircraft {
	// �� ����� ������� ����� "������" � �������� - �������� ����� ��������, � ������� ������� ������
	int x; 	// ���������� �� x	
	int y;	// ���������� �� y

	// ����������� "�� ���������"
	public Aircraft() {
		x = 0;
		y = 0;
	}

	// ���������� ��������� ������� ��������
	public void setStartPosition(int xStart, int yStart) {			
		x = xStart - 60;
		y = yStart;			
	}
	
		
	// �������� ������� �����
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

	// �������� X ���������� ��������� ������ ��������
	public int getX() {
		return x;
	}

	// �������� Y ���������� ��������� ������ ��������
	public int getY() {
		return y;
	}
		
	
	// ������ �������
	public void draw(Graphics g) {
		
		g.setColor(Color.BLACK);
				
		// �������
		g.drawLine(x - 60, y + 20, x - 30, y - 10);
		g.drawLine(x - 30, y - 10, x + 40, y - 10);
		g.drawLine(x + 40, y - 10, x + 60, y - 30);		
		g.drawLine(x + 60, y - 30, x + 60, y - 0);
		g.drawLine(x + 60, y - 0, x - 60, y + 20);
		
		// ������ ������
		g.drawLine(x - 40, y - 0, x - 5, y - 10);
		
				
		// ����� �����
		g.drawLine(x + 10, y + 2, x + 60, y + 20);
		g.drawLine(x + 60, y + 20, x + 43, y - 2);

		// ������ �����		
		g.drawLine(x + 10, y - 10, x + 35, y - 30);
		g.drawLine(x + 35, y - 30, x + 40, y - 10);
		
		// ������ - ���� ������� ������
		g.setColor(Color.RED);
		g.fillOval(x-2, y-2, 5, 5);
		

	}
	
public void drawBoom(Graphics g) {	
		g.setColor(Color.RED);
		g.drawLine(x + 40, y, x -40, y);
		g.drawLine(x, y +40, x, y -40);
	}

}
