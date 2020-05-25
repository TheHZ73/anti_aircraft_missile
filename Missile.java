import java.awt.Color;
import java.awt.Graphics;


public class Missile {
		// за точку отсчета взят "взрыватель" находящийся в самой верхней точке ракеты
			
		int x; 	// координата по x	
		int y;	// координата по y
		
		// у ракеты на старте скорость нулевая
		int vy = 0; 

		// конструктор "по умолчанию"
		public Missile() {
			x = 0;
			y = 0;
		}
		
		// установить ракету на стартовую позицию
		public void installToStart(int xStart, int yStart) {			
			x = xStart;
			y = yStart - 61;			
		}
			
		// сместить позицию влево
		public void toLeft() {
			x = x - 10;
		}
		
		// сместить позицию вправо
		public void toRight() {
			x = x + 10;
		}
			
		// стартовать ракету
		public void start() {
			vy = 10; // пристарте скорость сразу задается 10
			y = y - vy;	// ракета пошла!		
		}
				
		// сместить позицию вверх
		public void up() {
			vy += 2; // по мере подъема ракета ускоряется
			y = y - vy; // собственно перемещение вверх
		}
		
		// проверка попадания ракеты в цель
		public boolean targetIsHit(int targetX, int targetY) {
						
			// считается ракета попавшей если ее взрыватель оказался в пределах 40 пунктов левее или правее цели
			// и при этом взрыватель ниже цели но не ниже чем на 50 пунктов
			if (x >= (targetX - 40)  && x <= (targetX + 40) 
					&&					
					y >= targetY  && y < (targetY + 50)
					) { 
				return true;	
			}				
			// иначе ракета в цель не попала	
			return false;
		}
		
		// рисуем ракету
		public void draw(Graphics g) {
			
			// фюзеляж
			g.setColor(Color.DARK_GRAY);
			g.drawLine(x, y, x + 10, y + 20);
			g.drawLine(x + 10, y + 20, x + 10, y + 60);
			g.drawLine(x, y, x - 10, y + 20);
			g.drawLine(x - 10, y + 20, x - 10, y + 60);
			g.drawLine(x + 10, y + 60, x - 10, y + 60);
			
			// правое крыло 
			g.drawLine(x + 10, y + 60, x + 30, y + 60);
			g.drawLine(x + 30, y + 60, x + 10, y + 40);

			// левое крыло
			g.drawLine(x - 10, y + 60, x - 30, y + 60);
			g.drawLine(x - 30, y + 60, x - 10, y + 40);
		
			// взрыватель	
			g.setColor(Color.RED);
			g.fillOval(x-2, y-2, 5, 5);
		}	
}
