import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;




public class AirPanel extends JPanel {
/**
	 * 
	 */
	private static final long serialVersionUID = 5630738531684343217L;

	private Missile missile = null;
	private Aircraft aircraft = null;
	private Aircraft aircraft1 = null;
	
	public AirPanel() {
	
	}
	
	public void setMissile(Missile _missile) {
		missile = _missile;
	}	
	
	public void setAircraft(Aircraft _aircraft) {
		aircraft = _aircraft;
	}
	public void setAircraft1(Aircraft _aircraft) {
		aircraft1 = _aircraft;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		AntiaircraftMissileMainWin antiaircraftMissileMainWin=new AntiaircraftMissileMainWin();
		if (missile != null) {
			missile.draw(g);		
		}
		if (aircraft != null) {
			if (antiaircraftMissileMainWin.air!=true)
			{
				aircraft.draw(g);	
			}
			else
				{
				aircraft.drawBoom(g);
				}
				
		}
		if (aircraft!=null)
		{aircraft1.draw(g);}
		
		
	}
}

