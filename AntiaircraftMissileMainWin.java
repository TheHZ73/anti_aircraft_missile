import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;


public class AntiaircraftMissileMainWin {

	private JFrame frmAntiaircraftMissile;

	private Missile missile = null;
	private Aircraft aircraft = new Aircraft();
	private Aircraft aircraft1 = new Aircraft();
	private AirPanel panel;
	
	
	
	private javax.swing.Timer timerMissile;
	private javax.swing.Timer timerAircraft;
	private javax.swing.Timer timerAircraft1;
	private JButton buttonLeft;
	private JButton buttonRight;
	private JButton btnFire;
	
	int numHitTargets = 0;
	public boolean air=false,air1=false;
	private JLabel labelTargetIsHit;
	private JPanel panelTargetIsHit;
	private JButton buttonSelfDestroy;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AntiaircraftMissileMainWin window = new AntiaircraftMissileMainWin();
					window.frmAntiaircraftMissile.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AntiaircraftMissileMainWin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAntiaircraftMissile = new JFrame();
		frmAntiaircraftMissile.setTitle("Antiaircraft missile");
		frmAntiaircraftMissile.setBounds(100, 100, 794, 599);
		frmAntiaircraftMissile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAntiaircraftMissile.getContentPane().setLayout(null);
		
		panel = new AirPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(12, 13, 752, 382);
		frmAntiaircraftMissile.getContentPane().add(panel);
		
		buttonLeft = new JButton("<<");
		buttonLeft.setEnabled(false);
		buttonLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (missile != null) {
					missile.toLeft();
				}
				panel.repaint();
			}
			
		});
		buttonLeft.setBounds(242, 449, 57, 51);
		frmAntiaircraftMissile.getContentPane().add(buttonLeft);
		
		btnFire = new JButton("Fire!");
		btnFire.setEnabled(false);
		btnFire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 timerMissile.start();
				 missile.start();
				 panel.repaint();
				 btnFire.setEnabled(false);
				 buttonSelfDestroy.setEnabled(true);
				 
				 
			}
		});
		btnFire.setBounds(311, 449, 84, 51);
		frmAntiaircraftMissile.getContentPane().add(btnFire);
		
		buttonRight = new JButton(">>");
		buttonRight.setEnabled(false);
		buttonRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (missile != null) {
					missile.toRight();
				}
				panel.repaint();
			}
		});
		buttonRight.setBounds(407, 449, 57, 51);
		frmAntiaircraftMissile.getContentPane().add(buttonRight);
		
		JButton btnMissileToStart = new JButton("Missile to start!");
		btnMissileToStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timerMissile.stop();
				missile = new Missile();
				panel.setMissile(missile);
				missile.installToStart(panel.getWidth() / 2, panel.getHeight());
				panel.repaint();
				
				buttonLeft.setEnabled(true);
				buttonRight.setEnabled(true);
				btnFire.setEnabled(true);

				
			}
		});
		btnMissileToStart.setBounds(12, 449, 172, 51);
		frmAntiaircraftMissile.getContentPane().add(btnMissileToStart);
		
		
		
		//Будет вызываться каждые 500 мсек
		 timerMissile=new Timer(500, new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	//Do work!
					missile.up();
					if (missile.targetIsHit(aircraft.getX(), aircraft.getY()))  {
						air=true;
						targetIsBeingHit();
					}
					
					if  (missile.targetIsHit(aircraft1.getX(), aircraft1.getY()))
					{	air1=true;
						targetIsBeingHit();}

					panel.repaint();
			    }
			  } );
		 
		 
		 
		 panel.setAircraft(aircraft);
		 panel.setAircraft1(aircraft1);
		 
		 panelTargetIsHit = new JPanel();
		 panelTargetIsHit.setBackground(Color.CYAN);
		 panelTargetIsHit.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		 panelTargetIsHit.setBounds(659, 427, 94, 73);
		 frmAntiaircraftMissile.getContentPane().add(panelTargetIsHit);
		 panelTargetIsHit.setLayout(null);
		 
		 labelTargetIsHit = new JLabel("0");
		 labelTargetIsHit.setFont(new Font("Tahoma", Font.PLAIN, 17));
		 labelTargetIsHit.setHorizontalAlignment(SwingConstants.CENTER);
		 labelTargetIsHit.setBounds(12, 33, 70, 34);
		 panelTargetIsHit.add(labelTargetIsHit);
		 
		 JLabel lblHitTargets = new JLabel("Hit targets:");
		 lblHitTargets.setBounds(12, 13, 70, 16);
		 panelTargetIsHit.add(lblHitTargets);
		 
		 buttonSelfDestroy = new JButton("Self Destroy");
		 buttonSelfDestroy.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		
		 		
		 		
				missile = null;
				panel.setMissile(null);
				timerMissile.stop();
				panel.repaint();
				
				buttonLeft.setEnabled(false);
				buttonRight.setEnabled(false);
				btnFire.setEnabled(false);
				buttonSelfDestroy.setEnabled(false);

		 	}
		 });
		 buttonSelfDestroy.setEnabled(false);
		 buttonSelfDestroy.setBounds(242, 516, 222, 25);
		 frmAntiaircraftMissile.getContentPane().add(buttonSelfDestroy);
		 aircraft.setStartPosition(panel.getWidth(), panel.getHeight()/4);
		 aircraft1.setStartPosition(panel.getWidth()+300, panel.getHeight()/4);
		//Будет вызываться каждые 500 мсек
		 timerAircraft = new Timer(500, new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			    	//Do work!
			    	if (air!=true)
			    	{
			    		
			    	aircraft.move();	
					
			    	}
			    	else
			    	{
			    		timerAircraft.stop();
						aircraft=new Aircraft();
						panel.setAircraft(aircraft);
						aircraft.setStartPosition(aircraft.getX(), aircraft.getY());
  					    panel.repaint();
//						aircraft.moveBoom();
						timerAircraft.start();
			    	}
			    	if (air1!=true)
			    	{
			    	aircraft1.move();	
			    	}
			    	else
			    	{
						aircraft1.moveBoom();
			    	}
			    	panel.repaint();
			    }
			  } );
		 timerAircraft.start();

	}
	
	
	void targetIsBeingHit() {
		missile = null;
		panel.setMissile(null);
		timerMissile.stop();			
		panel.repaint();
		
		buttonLeft.setEnabled(false);
		buttonRight.setEnabled(false);
		btnFire.setEnabled(false);
		buttonSelfDestroy.setEnabled(false);

		numHitTargets++;
		
		panelTargetIsHit.setBackground(Color.RED);
		labelTargetIsHit.setText(Integer.toString(numHitTargets));		
		
	}
	
}