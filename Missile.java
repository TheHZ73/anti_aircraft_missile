import java.awt.Color;
import java.awt.Graphics;


public class Missile {
		// �� ����� ������� ���� "����������" ����������� � ����� ������� ����� ������
			
		int x; 	// ���������� �� x	
		int y;	// ���������� �� y
		
		// � ������ �� ������ �������� �������
		int vy = 0; 

		// ����������� "�� ���������"
		public Missile() {
			x = 0;
			y = 0;
		}
		
		// ���������� ������ �� ��������� �������
		public void installToStart(int xStart, int yStart) {			
			x = xStart;
			y = yStart - 61;			
		}
			
		// �������� ������� �����
		public void toLeft() {
			x = x - 10;
		}
		
		// �������� ������� ������
		public void toRight() {
			x = x + 10;
		}
			
		// ���������� ������
		public void start() {
			vy = 10; // ��������� �������� ����� �������� 10
			y = y - vy;	// ������ �����!		
		}
				
		// �������� ������� �����
		public void up() {
			vy += 2; // �� ���� ������� ������ ����������
			y = y - vy; // ���������� ����������� �����
		}
		
		// �������� ��������� ������ � ����
		public boolean targetIsHit(int targetX, int targetY) {
						
			// ��������� ������ �������� ���� �� ���������� �������� � �������� 40 ������� ����� ��� ������ ����
			// � ��� ���� ���������� ���� ���� �� �� ���� ��� �� 50 �������
			if (x >= (targetX - 40)  && x <= (targetX + 40) 
					&&					
					y >= targetY  && y < (targetY + 50)
					) { 
				return true;	
			}				
			// ����� ������ � ���� �� ������	
			return false;
		}
		
		// ������ ������
		public void draw(Graphics g) {
			
			// �������
			g.setColor(Color.DARK_GRAY);
			g.drawLine(x, y, x + 10, y + 20);
			g.drawLine(x + 10, y + 20, x + 10, y + 60);
			g.drawLine(x, y, x - 10, y + 20);
			g.drawLine(x - 10, y + 20, x - 10, y + 60);
			g.drawLine(x + 10, y + 60, x - 10, y + 60);
			
			// ������ ����� 
			g.drawLine(x + 10, y + 60, x + 30, y + 60);
			g.drawLine(x + 30, y + 60, x + 10, y + 40);

			// ����� �����
			g.drawLine(x - 10, y + 60, x - 30, y + 60);
			g.drawLine(x - 30, y + 60, x - 10, y + 40);
		
			// ����������	
			g.setColor(Color.RED);
			g.fillOval(x-2, y-2, 5, 5);
		}	
}
