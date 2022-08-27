package dats.manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dats.dbutils.DbConnection;
import dats.gui.CustomLookAndFeel;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import javax.swing.SwingConstants;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JScrollPane;
import java.awt.Button;
import javax.swing.JButton;

public class AddDoctor extends JFrame implements ActionListener, WindowListener, KeyListener
{
 
	private JPanel contentPane;
	private JTextField txtid;
	private final ButtonGroup gender_group = new ButtonGroup();
	private JTextField txtphone;
	private JTextField txtemail;
	private JTextField txttiming;
	private JTextField txtfield;
	private JTextField txtqualification;
	private JTextField txtexperience;
	private JTextField txtname;
	private JTextArea txtaddress;
	private JRadioButton rdmale, rdfemale, rdtransgender;
	private JCheckBox cbmon, cbtue, cbwed, cbthu, cbfri, cbsat, cbsun;
	JButton btnadd;
	String daysStatus="";

	private Connection con;
	
	/** 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomLookAndFeel.setLookAndFeel();
					
					AddDoctor frame = new AddDoctor();
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
	public AddDoctor() 
	{
		createComponents();
	}

	void createComponents()
	{
		con=DbConnection.openConnection();
		this.addWindowListener(this);
		
		setTitle("Add Doctor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 686, 677);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbldoctorid = new JLabel("Doctor ID");
		lbldoctorid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbldoctorid.setBounds(100, 54, 116, 33);
		contentPane.add(lbldoctorid);
		
		txtid = new JTextField();
		txtid.setBounds(249, 54, 313, 33);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JLabel lblgender = new JLabel("Gender");
		lblgender.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblgender.setBounds(100, 142, 116, 33);
		contentPane.add(lblgender);
		
		rdmale = new JRadioButton("Male");
		gender_group.add(rdmale);
		rdmale.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdmale.setBounds(249, 147, 67, 23);
		contentPane.add(rdmale);
		
		rdfemale = new JRadioButton("Female");
		gender_group.add(rdfemale);
		rdfemale.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdfemale.setBounds(325, 147, 96, 23);
		contentPane.add(rdfemale);
		
		rdtransgender = new JRadioButton("Transgender");
		gender_group.add(rdtransgender);
		rdtransgender.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdtransgender.setBounds(423, 147, 139, 23);
		contentPane.add(rdtransgender);
		
		JLabel lblphone = new JLabel("Phone");
		lblphone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblphone.setBounds(100, 186, 116, 33);
		contentPane.add(lblphone);
		
		txtphone = new JTextField();
		txtphone.addKeyListener(this);
		txtphone.setColumns(10);
		txtphone.setBounds(249, 186, 313, 33);
		contentPane.add(txtphone);
		
		JLabel lbladdress = new JLabel("Address");
		lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbladdress.setBounds(100, 507, 116, 33);
		contentPane.add(lbladdress);
		
		txtaddress = new JTextArea();
		txtaddress.addKeyListener(this);
		txtaddress.setBounds(249, 507, 313, 79);
		contentPane.add(txtaddress);
		
		JLabel lblemail = new JLabel("Email");
		lblemail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblemail.setBounds(100, 230, 116, 33);
		contentPane.add(lblemail);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(249, 230, 313, 33);
		contentPane.add(txtemail);
		
		JLabel lbltiming = new JLabel("Timing");
		lbltiming.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbltiming.setBounds(100, 274, 116, 33);
		contentPane.add(lbltiming);
		
		txttiming = new JTextField();
		txttiming.setColumns(10);
		txttiming.setBounds(249, 274, 313, 33);
		contentPane.add(txttiming);
		
		JLabel lblDays = new JLabel("Days");
		lblDays.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDays.setBounds(100, 318, 116, 33);
		contentPane.add(lblDays);
		
		cbmon = new JCheckBox("Mon");
		cbmon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbmon.setBounds(249, 314, 67, 33);
		contentPane.add(cbmon);
		
		cbfri = new JCheckBox("Fri");
		cbfri.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbfri.setBounds(249, 340, 67, 33);
		contentPane.add(cbfri);
		
		cbsat = new JCheckBox("Sat");
		cbsat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbsat.setBounds(335, 340, 67, 33);
		contentPane.add(cbsat);
		
		cbtue = new JCheckBox("Tue");
		cbtue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbtue.setBounds(335, 314, 67, 33);
		contentPane.add(cbtue);
		
		cbwed = new JCheckBox("Wed");
		cbwed.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbwed.setBounds(413, 314, 67, 33);
		contentPane.add(cbwed);
		
		cbsun = new JCheckBox("Sun");
		cbsun.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbsun.setBounds(413, 340, 67, 33);
		contentPane.add(cbsun);
		
		cbthu = new JCheckBox("Thu");
		cbthu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbthu.setBounds(500, 314, 67, 33);
		contentPane.add(cbthu);
		
		txtfield = new JTextField();
		txtfield.setColumns(10);
		txtfield.setBounds(249, 375, 313, 33);
		contentPane.add(txtfield);
		
		JLabel lblfield = new JLabel("Field");
		lblfield.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblfield.setBounds(100, 375, 116, 33);
		contentPane.add(lblfield);
		
		JLabel lblqualification = new JLabel("Qualification");
		lblqualification.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblqualification.setBounds(100, 419, 139, 33);
		contentPane.add(lblqualification);
		
		txtqualification = new JTextField();
		txtqualification.setColumns(10);
		txtqualification.setBounds(249, 419, 313, 33);
		contentPane.add(txtqualification);
		
		JLabel lblexperience = new JLabel("Experience");
		lblexperience.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblexperience.setBounds(100, 463, 116, 33);
		contentPane.add(lblexperience);
		
		txtexperience = new  JTextField();
		txtexperience.addKeyListener(this);
		txtexperience.setColumns(10);
		txtexperience.setBounds(249, 463, 313, 33);
		contentPane.add(txtexperience);
		
		JLabel lbldoctordetails = new JLabel("ADD DOCTOR DETAILS");
		lbldoctordetails.setHorizontalAlignment(SwingConstants.CENTER);
		lbldoctordetails.setFont(new Font("Calibri", Font.BOLD, 25));
		lbldoctordetails.setBounds(100, 11, 462, 32);
		contentPane.add(lbldoctordetails);
		
		JLabel lblfullname = new JLabel("Full Name");
		lblfullname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblfullname.setBounds(100, 98, 116, 33);
		contentPane.add(lblfullname);
		
		txtname = new JTextField();
		txtname.addKeyListener(this);
		txtname.setColumns(10);
		txtname.setBounds(249, 98,  313, 33);
		contentPane.add(txtname);
		
		btnadd = new JButton("ADD");
		btnadd.addActionListener(this);
		btnadd.addKeyListener(this);
		btnadd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnadd.setBounds(249, 597, 313, 34);
		contentPane.add(btnadd);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("Clicked");
		
		addDoctor();
		daysStatus="";
	}
	
	//CheckBox Status using mehtod
//	String daysStatus="";
	void daysStatus(JCheckBox checkbox)
	{	
		if(checkbox.isSelected()) {
			daysStatus= daysStatus + checkbox.getText() + "," ;
//			System.out.println(daysStatus);
		}
	}
	
	//+++++++++++++++++++++++++++++++++++++++++
	void addDoctor()
	{
		String id= txtid.getText();
		String name= txtname.getText();
		String phone= txtphone.getText();
		String email= txtemail.getText();
		String timing= txttiming.getText();
		String field= txtfield.getText();
		String qualification= txtqualification.getText();
		String experience= txtexperience.getText();
		String address= txtaddress.getText();
		
		// RadioButton Status
		String genderStatus="";
		if(rdmale.isSelected()) {
			genderStatus=rdmale.getText();
//			System.out.println(genderStatus);
		}
		if(rdfemale.isSelected()) {
			genderStatus=rdfemale.getText();
//			System.out.println(genderStatus);
		}
		if(rdtransgender.isSelected()) {
			genderStatus=rdtransgender.getText();
//			System.out.println(genderStatus);
		}
		
		
		//CheckBox Status
		daysStatus(cbmon);
		daysStatus(cbtue);
		daysStatus(cbwed);
		daysStatus(cbthu);
		daysStatus(cbfri);
		daysStatus(cbsat);
		daysStatus(cbsun);	
		
		//textField Status
		if(id.isEmpty()||name.isEmpty()||phone.isEmpty()||email.isEmpty()||
				timing.isEmpty()||daysStatus.isEmpty() ||field.isEmpty()||qualification.isEmpty()||
				experience.isEmpty()|| address.isEmpty()|| genderStatus.isEmpty()|| daysStatus.isEmpty()) 
		{
			JOptionPane.showMessageDialog(this, "All Fields Are Mandatory", "Mandatory Fields", JOptionPane.ERROR_MESSAGE)
;
		}
		
		else if (phone.length() < 10 || phone.length() > 10) 
		{
			JOptionPane.showMessageDialog(this, "Only Ten Digit Phone Number Is Allowed", "Inncorect", JOptionPane.ERROR_MESSAGE);
			
		}
		
		//Database 
		else
		{
			PreparedStatement ps=null;
			String str_insert= "insert into doctor_details (DoctorID, Name, Address, Email, Gender, Phone, Days, Timing, Qualification, Field, Experience) values (?,?,?,?,?,?,?,?,?,?,?)"; 
			
			try 
			{
				ps=con.prepareStatement(str_insert);
				
				ps.setString(1, id);
				ps.setString(2, name);
				ps.setString(3, address);
				ps.setString(4, email);
				ps.setString(5, genderStatus);
				ps.setString(6, phone);
				ps.setString(7, daysStatus);
				ps.setString(8, timing);
				ps.setString(9, qualification);
				ps.setString(10, field);
				ps.setString(11, experience+" Years");				
				
				int row_status= ps.executeUpdate();
//				System.out.println("Insert status " + row_status);
				
				if(row_status>0)
				{
					JOptionPane.showMessageDialog(this, "Doctor Details Added Successfully");
		
					//to clear text field 
					txtid.setText("");
					txtname.setText("");
					gender_group.clearSelection();
					txtphone.setText("");
					txtemail.setText("");
					txttiming.setText("");
					
					txtfield.setText("");
					txtqualification.setText("");
					txtexperience.setText("");
					txtaddress.setText("");
					
					cbmon.setSelected(false);
					cbtue.setSelected(false);
					cbwed.setSelected(false);
					cbthu.setSelected(false);
					cbfri.setSelected(false);
					cbsat.setSelected(false);
					cbsun.setSelected(false);

				}
				
								
			}
			
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally 
			{
				if(ps!=null)
					try {
						ps.close();
					} 
				catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		DbConnection.closeConnection();
//		System.out.println("Connect is being close");
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==txtname)
		{
			char c= e.getKeyChar();
//			System.out.println(c);
			
			if( !( Character.isLetter(c) || (c==KeyEvent.VK_BACK_SPACE ) ||  c==KeyEvent.VK_DELETE || c== KeyEvent.VK_SPACE  ))
			{
				e.consume();
				JOptionPane.showMessageDialog(this, "Only Character Allowed", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource()==txtphone)
		{
			char c= e.getKeyChar();
//			System.out.println(c);
			
			if( !( Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE ) ||  c==KeyEvent.VK_DELETE ))
			{
				e.consume();
				JOptionPane.showMessageDialog(this, "Only Digit Allowed", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource()==txtexperience)
		{
			char c= e.getKeyChar();
//			System.out.println(c);
			
			if( !( Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE ) ||  c==KeyEvent.VK_DELETE  ))
			{
				e.consume();
				JOptionPane.showMessageDialog(this, "Only Digit Allowed", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int code= e.getKeyCode();  
		
		if(e.getSource()==txtaddress)
		{
			if(code==10)
//				addDoctor(); 
			btnadd.requestFocus();
				
			
		}
		if(e.getSource()==btnadd)
		{
			if(code==10)
			{
				addDoctor(); 
			}
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}














