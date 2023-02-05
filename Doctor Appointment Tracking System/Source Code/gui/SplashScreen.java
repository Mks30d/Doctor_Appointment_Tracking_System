package dats.gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;

public class SplashScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SplashScreen window = new SplashScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SplashScreen() {
		initialize();
		showFrame();
	}

	
	public void showFrame()
	{
		Thread t=new Thread(
				
				new Runnable() {
					
					@Override
					public void run() {
						
						try 
						{
							Thread.sleep(2500);  //to hold the frame 2500 ms.
							
							Login login= new Login();
							login.setVisible(true);
							
//							SplashScreen.this.frame.dispose();
							frame.dispose();
							
						} 
						catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				}
				
				);
		t.start();
		
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 732, 462);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("We Welcomes You");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(0, 34, 723, 54);
		
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("");
		
		
		ImageIcon ic=new ImageIcon(SplashScreen.class.getResource("/dats/images/splash1.jpg"));
		Image i = ic.getImage().getScaledInstance(724, 432, Image.SCALE_SMOOTH);
		ImageIcon ic1 = new ImageIcon(i);
		lblNewLabel = new JLabel(ic1);
		lblNewLabel.setBounds(0, 0, 724, 432);
		frame.getContentPane().add(lblNewLabel); 
		
		
		
//		lblNewLabel.setIcon(new ImageIcon(SplashScreen.class.getResource("/dats/images/splash1.jpg")));
//		lblNewLabel.setBounds(0, 0, 718, 425); 
//		frame.getContentPane().add(lblNewLabel); 		
	}
} 









