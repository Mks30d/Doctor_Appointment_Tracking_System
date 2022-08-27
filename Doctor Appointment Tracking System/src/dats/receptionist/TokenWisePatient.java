package dats.receptionist;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import dats.dbutils.DbConnection;
import dats.gui.CustomLookAndFeel;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class TokenWisePatient extends JFrame implements ActionListener, WindowListener
{

	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtage;
	private JTextField txtphone;
	private JTextField txtproblem;
	private JTextField txtappointmentno;
	private JTextField txttoken;
	private JTextField txtid;
	private JTextField txtdate;
	private JTextField txtappointmentdate;
	private JTextField txtappointmentmode;
	private JTextField txtvisit;
	JButton btnsearch;
	private Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomLookAndFeel.setLookAndFeel();
					
					TokenWisePatient frame = new TokenWisePatient();
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
	public TokenWisePatient() 
	{

		createComponents();
	}
	
	void createComponents()
	{
		con = DbConnection.openConnection();
		this.addWindowListener(this);
		
		setTitle("Token");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 603, 610);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(this);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Patient Details Using Token Number");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(71, 11, 429, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Token Number");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(71, 79, 147, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(71, 120, 116, 33);
		contentPane.add(lblName);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAge.setBounds(71, 164, 116, 33);
		contentPane.add(lblAge);
		
		txtname = new JTextField();
		txtname.setEditable(false);
		txtname.setColumns(10);
		txtname.setBounds(266, 120, 234, 33);
		contentPane.add(txtname);
		
		txtage = new JTextField();
		txtage.setEditable(false);
		txtage.setColumns(10);
		txtage.setBounds(266, 164, 234, 33);
		contentPane.add(txtage);
		
		txtphone = new JTextField();
		txtphone.setEditable(false);
		txtphone.setColumns(10);
		txtphone.setBounds(266, 208, 234, 33);
		contentPane.add(txtphone);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhone.setBounds(71, 208, 116, 33);
		contentPane.add(lblPhone);
		
		JLabel lblProblem = new JLabel("Problem");
		lblProblem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblProblem.setBounds(71, 252, 116, 33);
		contentPane.add(lblProblem);
		
		txtproblem = new JTextField();
		txtproblem.setEditable(false);
		txtproblem.setColumns(10);
		txtproblem.setBounds(266, 252, 234, 33);
		contentPane.add(txtproblem);
		
		JLabel lblDoctorId = new JLabel("Doctor ID");
		lblDoctorId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDoctorId.setBounds(71, 296, 116, 33);
		contentPane.add(lblDoctorId);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDate.setBounds(71, 340, 116, 33);
		contentPane.add(lblDate);
		
		JLabel lblAppointmentdate = new JLabel("AppointmentDate");
		lblAppointmentdate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAppointmentdate.setBounds(71, 384, 181, 33);
		contentPane.add(lblAppointmentdate);
		
		JLabel lblAppointmentno = new JLabel("AppointmentNo.");
		lblAppointmentno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAppointmentno.setBounds(71, 428, 181, 33);
		contentPane.add(lblAppointmentno);
		
		JLabel lblAppointmentmode = new JLabel("AppointmentMode");
		lblAppointmentmode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAppointmentmode.setBounds(71, 468, 181, 33);
		contentPane.add(lblAppointmentmode);
		
		JLabel lblPatientvisit = new JLabel("PatientVisit");
		lblPatientvisit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPatientvisit.setBounds(71, 512, 181, 33);
		contentPane.add(lblPatientvisit);
		
		txtappointmentno = new JTextField();
		txtappointmentno.setEditable(false);
		txtappointmentno.setColumns(10);
		txtappointmentno.setBounds(266, 428, 234, 33);
		contentPane.add(txtappointmentno);
		
		txttoken = new JTextField();
		txttoken.setText("Tok");
		txttoken.setColumns(10);
		txttoken.setBounds(266, 76, 117, 33);
		contentPane.add(txttoken);
		
		txtid = new JTextField();
		txtid.setEditable(false);
		txtid.setColumns(10);
		txtid.setBounds(266, 296, 234, 33);
		contentPane.add(txtid);
		
		txtdate = new JTextField();
		txtdate.setEditable(false);
		txtdate.setColumns(10);
		txtdate.setBounds(266, 340, 234, 33);
		contentPane.add(txtdate);
		
		txtappointmentdate = new JTextField();
		txtappointmentdate.setEditable(false);
		txtappointmentdate.setColumns(10);
		txtappointmentdate.setBounds(266, 384, 234, 33);
		contentPane.add(txtappointmentdate);
		
		//button
		btnsearch = new JButton("Search");
		btnsearch.addActionListener(this);
		btnsearch.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnsearch.setBounds(393, 77, 107, 33);
		contentPane.add(btnsearch);
		
		txtappointmentmode = new JTextField();
		txtappointmentmode.setEditable(false);
		txtappointmentmode.setColumns(10);
		txtappointmentmode.setBounds(266, 472, 234, 33);
		contentPane.add(txtappointmentmode);
		
		txtvisit = new JTextField();
		txtvisit.setEditable(false);
		txtvisit.setColumns(10);
		txtvisit.setBounds(266, 516, 234, 33);
		contentPane.add(txtvisit);
		
	}

	
	//+++++++++++++++++++++++++++++++++++++++++++++
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		searchPatient();
	}
	
	
	void searchPatient()
	{
		
		String token= txttoken.getText().trim();
		
		if(token.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Please Provide Token Number", "Empty Field", JOptionPane.WARNING_MESSAGE);
		}
		
		
		else 
		{
			PreparedStatement ps = null;
			ResultSet rs = null;

			String strsearch = "select * from patient_details where Token=?";

			try {
				ps = con.prepareStatement(strsearch);
				ps.setString(1, token);
				rs = ps.executeQuery();
				
				if(rs.next())
				{
					String name=rs.getString("PatientName");
					String age=rs.getString("Age");
					String phone=rs.getString("Phone");
					String problem=rs.getString("Problem");
					String id=rs.getString("DoctorID");
					String date=rs.getString("Date");
					
					String appointmentdate=rs.getString("AppointmentDate");
					String appointmentno=rs.getString("AppointmentNo");
					String appointmentmode=rs.getString("AppointmentMode");
					String visit=rs.getString("PatientVisit");
					
					
					txtname.setText(name);
					txtage.setText(age);
					txtphone.setText(phone);
					txtproblem.setText(problem);
					txtid.setText(id);
					txtdate.setText(date);
					txtappointmentdate.setText(appointmentdate);
					txtappointmentno.setText(appointmentno);
					txtappointmentmode.setText(appointmentmode);
					txtvisit.setText(visit);
					
					
				}
				
				else
				{	
//					txttoken.setBackground(Color.red);
					JOptionPane.showMessageDialog(this, "Invalid Token Number","Error",JOptionPane.ERROR_MESSAGE);
				}

			} catch (SQLException se) {
				se.printStackTrace();
			} finally {

				try {
					if (ps != null)
						ps.close();

					if (rs != null)
						rs.close();
				} catch (SQLException e) {
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


	

	
	
	
	
	
	
}
