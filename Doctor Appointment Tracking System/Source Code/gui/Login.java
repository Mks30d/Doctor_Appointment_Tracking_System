package dats.gui;

// Doctor Appointment Tracking System
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dats.gui.CustomLookAndFeel;
import dats.manager.Manager;
import dats.receptionist.Receptionist;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Login extends JFrame implements ActionListener , KeyListener
{

	private JPanel contentPane;
	private JTextField txtid;
	private JPasswordField txtpass;
	JButton btnlogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					CustomLookAndFeel.setLookAndFeel();
					
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() // constructor
	{
		createComponents();
	}

	public void createComponents() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 837, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setLocationRelativeTo(this); // to make frame in center
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblloginid = new JLabel("User ID");
		lblloginid.setFont(new Font("Arial", Font.PLAIN, 20));
		lblloginid.setBounds(517, 129, 247, 35);
		contentPane.add(lblloginid);
		
		txtid = new JTextField();
		txtid.addKeyListener(this);
		txtid.setColumns(10);
		txtid.setBounds(517, 158, 247, 28);
		contentPane.add(txtid);
		
		JLabel lblpass = new JLabel("Password");
		lblpass.setFont(new Font("Arial", Font.PLAIN, 20));
		lblpass.setBounds(517, 195, 247, 35);
		contentPane.add(lblpass);
		
		txtpass = new JPasswordField();
		txtpass.addKeyListener(this);
		txtpass.setBounds(517, 225, 247, 28);
		contentPane.add(txtpass);
		
		btnlogin = new JButton("Login");
		btnlogin.addKeyListener(this);
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnlogin.setFont(new Font("Arial", Font.PLAIN, 20));
		btnlogin.addActionListener(this);
		btnlogin.setBounds(517, 275, 247, 30);
		contentPane.add(btnlogin);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBounds(-11, 0, 441, 463);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/dats/images/login1.jpg")));
		lblNewLabel.setBounds(-91, 0, 550, 463);
		panel.add(lblNewLabel);
		
		JLabel lblWelcomeBack = new JLabel("Welcome Back");
		lblWelcomeBack.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeBack.setFont(new Font("Arial", Font.PLAIN, 20));
		lblWelcomeBack.setBounds(517, 71, 247, 35);
		contentPane.add(lblWelcomeBack);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("Clicked");
		login();
	}

	void login() {

		String id = txtid.getText().trim();
		char[] password = txtpass.getPassword();
		String pass = String.valueOf(password);

		if (id.isEmpty() || pass.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Empty Field", "Empty Fields", JOptionPane.ERROR_MESSAGE);
		} 
		
		else 
		{
			if (id.equalsIgnoreCase("m") && pass.equalsIgnoreCase("123")) {
				//System.out.println("Doctor frame");
				Manager m= new Manager();
				m.setVisible(true);
				this.dispose();;
			}

			else if (id.equalsIgnoreCase("r") && pass.equalsIgnoreCase("123")) {
				//System.out.println("Receptionist frame");
				Receptionist r= new Receptionist();
				r.setVisible(true);
				this.dispose();
			}
			else {
				JOptionPane.showMessageDialog(this, "Invalid User ID or Password", "Invalid Details", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override 
	public void keyPressed(KeyEvent e) 
	{
		int code= e.getKeyCode();
		
		if(e.getSource()==txtid) {
			if(code==10) {
			txtpass.requestFocus();
			}
		}
		if(e.getSource()==txtpass) {
			if(code==10) {
			login();
			}
		}
		
		if(e.getSource()==btnlogin)
		{
			if(code==10) {
				login();
			}
		}
//		if(code==10)
//		{
//			login();
//		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
