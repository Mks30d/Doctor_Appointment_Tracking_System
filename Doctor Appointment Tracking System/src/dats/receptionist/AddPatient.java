package dats.receptionist;

import java.awt.BorderLayout;
import dats.dbutils.DbConnection;
import dats.gui.CustomLookAndFeel;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Random;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.SystemColor;

public class AddPatient extends JFrame implements ActionListener, WindowListener, ItemListener, KeyListener {

	private JPanel contentPane;
	private JTextField txttoken;
	private JButton btngenerate, btnAdd;
	private JLabel lblNewLabel;
	private JLabel lblName;
	private JTextField txtname;
	private JLabel lblAge;
	private JTextField txtage;
	private JLabel lblPhone;
	private JTextField txtphone;
	private JLabel lblProblem;
	private JTextField txtproblem;
	private JTextField txtAppointmentNo;
	private JLabel lblAppointmentno;
	private JLabel lblAppointmentmode;
	private JRadioButton rdPhone, rdMannual;
	private JDateChooser datechooserappointment;
	private JComboBox cmbid;
	private final ButtonGroup modeGroup = new ButtonGroup();
	JRadioButton rdmale, rdfemale, rdtransgender;
	private final ButtonGroup genderGroup = new ButtonGroup();
	private JTextField txtcurdate;
	private Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomLookAndFeel.setLookAndFeel();
					
					AddPatient frame = new AddPatient();
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
	public AddPatient() {
		createComponents();
	}

	void createComponents() {
		con = DbConnection.openConnection();
		this.addWindowListener(this);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 693, 612);
		contentPane =  new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(this);
		contentPane.setLayout(null);

		JLabel lbltoken = new JLabel("Token");
		lbltoken.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbltoken.setBounds(90, 395, 181, 31);
		contentPane.add(lbltoken);

		txttoken = new JTextField();
		txttoken.setBackground(SystemColor.controlHighlight);
		txttoken.setEditable(false);
		txttoken.setBounds(285, 395, 140, 31);
		contentPane.add(txttoken);
		txttoken.setColumns(10);

		btngenerate = new JButton("GENERATE");
		btngenerate.addActionListener(this);
		btngenerate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btngenerate.setBounds(435, 416, 129, 31);
		setLocationRelativeTo(this);
		contentPane.add(btngenerate);

		lblNewLabel = new JLabel("Add Patient Details");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(90, 0, 474, 32);
		contentPane.add(lblNewLabel);

		lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(90, 43, 116, 33);
		contentPane.add(lblName);

		txtname = new JTextField();
		txtname.addKeyListener(this);
		txtname.setColumns(10);
		txtname.setBounds(285, 43, 279, 33);
		contentPane.add(txtname);

		lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAge.setBounds(90, 131, 116, 33);
		contentPane.add(lblAge);

		txtage = new JTextField();
		txtage.addKeyListener(this);
		txtage.setColumns(10);
		txtage.setBounds(285, 131, 279, 33);
		contentPane.add(txtage);

		lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhone.setBounds(90, 175, 116, 33);
		contentPane.add(lblPhone);

		txtphone = new JTextField();
		txtphone.addKeyListener(this);
		txtphone.setColumns(10);
		txtphone.setBounds(285, 175, 279, 33);
		contentPane.add(txtphone);

		lblProblem = new JLabel("Problem");
		lblProblem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblProblem.setBounds(90, 219, 116, 33);
		contentPane.add(lblProblem);

		txtproblem = new JTextField();
		txtproblem.setColumns(10);
		txtproblem.setBounds(285, 219, 279, 33);
		contentPane.add(txtproblem);

		JLabel lblDoctorId = new JLabel("Doctor ID");
		lblDoctorId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDoctorId.setBounds(90, 263, 116, 33);
		contentPane.add(lblDoctorId);

		JLabel lblDate = new JLabel("Current Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDate.setBounds(90, 307, 155, 33);
		contentPane.add(lblDate);

		JLabel lblAppointmentdate = new JLabel("AppointmentDate");
		lblAppointmentdate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAppointmentdate.setBounds(90, 351, 181, 33);
		contentPane.add(lblAppointmentdate);

		datechooserappointment = new JDateChooser();
		datechooserappointment.setBounds(285, 351, 279, 33);
		contentPane.add(datechooserappointment);

		txtAppointmentNo = new JTextField();
		txtAppointmentNo.setEditable(false);
		txtAppointmentNo.setForeground(Color.RED);
		txtAppointmentNo.setBackground(SystemColor.controlHighlight);
		txtAppointmentNo.setToolTipText("Auto Generated");
		txtAppointmentNo.setColumns(10);
		txtAppointmentNo.setBounds(285, 437, 140, 33);
		contentPane.add(txtAppointmentNo);

		lblAppointmentno = new JLabel("AppointmentNo.");
		lblAppointmentno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAppointmentno.setBounds(90, 437, 181, 33);
		contentPane.add(lblAppointmentno);

		lblAppointmentmode = new JLabel("AppointmentMode");
		lblAppointmentmode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAppointmentmode.setBounds(90, 481, 181, 33);
		contentPane.add(lblAppointmentmode);

		rdPhone = new JRadioButton("Phone");
		modeGroup.add(rdPhone);
		rdPhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdPhone.setBounds(318, 481, 105, 32);
		contentPane.add(rdPhone);

		rdMannual = new JRadioButton("Mannual");
		modeGroup.add(rdMannual);
		rdMannual.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdMannual.setBounds(425, 481, 105, 32);
		contentPane.add(rdMannual);

		btnAdd = new JButton("ADD");
		btnAdd.addActionListener(this);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAdd.setBounds(285, 520, 279, 31);
		contentPane.add(btnAdd);

		cmbid = new JComboBox();
		cmbid.addItemListener(this);
		cmbid.setModel(new DefaultComboBoxModel(new String[] { "Select DoctorID" }));
		fillComboBox();
		cmbid.setBounds(285, 263, 279, 33);
		contentPane.add(cmbid);
		
		JLabel lblgender = new JLabel("Gender");
		lblgender.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblgender.setBounds(90, 87, 116, 33);
		contentPane.add(lblgender);
		
		rdmale = new JRadioButton("Male");
		genderGroup.add(rdmale);
		rdmale.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdmale.setBounds(285, 92, 63, 23);
		contentPane.add(rdmale);
		
		rdfemale = new JRadioButton("Female");
		genderGroup.add(rdfemale);
		rdfemale.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdfemale.setBounds(355, 92, 83, 23);
		contentPane.add(rdfemale);
		
		rdtransgender = new JRadioButton("Transgender");
		genderGroup.add(rdtransgender);
		rdtransgender.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdtransgender.setBounds(441, 92, 139, 23);
		contentPane.add(rdtransgender);
		
		txtcurdate = new JTextField();
		txtcurdate.setEditable(false);
		java.util.Date dt=new java.util.Date();
		java.sql.Date sd=new java.sql.Date(dt.getTime());
		txtcurdate.setText(String.valueOf(sd));
		txtcurdate.setBounds(285, 307, 279, 33);
		contentPane.add(txtcurdate);
		txtcurdate.setColumns(10);
	}

	//filing comobBox
	public void fillComboBox() {

		PreparedStatement ps = null;
		ResultSet rs = null;
		String strsql = "select DoctorID from doctor_details";

		try {
			ps = con.prepareStatement(strsql);

			rs = ps.executeQuery();
			while (rs.next()) {
				String doctorID = rs.getString("DoctorID");
				cmbid.addItem(doctorID);

			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {

			try {

				if (ps != null)
					ps.close();
				if (rs != null)
					rs.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

//		System.out.println("source=" + e.getActionCommand());
		
		if (e.getActionCommand() == "GENERATE") {
			
			//for generating token No
			Random r = new Random();
			int result = r.nextInt(1000, 9999);
//			System.out.println(result);
			txttoken.setText("Tok" + String.valueOf(result));
			
			
			//for generating appointment No
			Statement stat=null;
			ResultSet rs=null;
			int appno=0;
			try {
				stat=con.createStatement();
				String sql="select AppointmentNo from patient_details order by AppointmentNo desc";
				rs= stat.executeQuery(sql);
				
				if(rs.next())
				{
//					System.out.println("rs.getInt(1)="+rs.getInt(1));
					appno =rs.getInt(1) + 1;
					txtAppointmentNo.setText(String.valueOf(appno));
				}
			}
			
			catch (SQLException e1) {
				e1.printStackTrace();
			}

		}
		
		
		else 
		{
			addPatient();
		}

	}

	void addPatient() 
	{

		String name = txtname.getText();
		String age = txtage.getText();
		String phone = txtphone.getText();
		String problem = txtproblem.getText();
		String token = txttoken.getText();
		String appointmentno=txtAppointmentNo.getText();

		String genderStatus = "";
		if (rdmale.isSelected()) {
			genderStatus = rdmale.getText();
//			System.out.println(genderStatus); 
		}
		if (rdfemale.isSelected()) {
			genderStatus = rdfemale.getText();
//			System.out.println(genderStatus);
		}
		if (rdtransgender.isSelected()) {
			genderStatus = rdtransgender.getText();
//			System.out.println(genderStatus);
		}
		
		
		String modeStatus = "";
		if (rdPhone.isSelected()) {
			modeStatus = rdPhone.getText();
//			System.out.println(modeStatus);
		}
		if (rdMannual.isSelected()) {
			modeStatus = rdMannual.getText();
//			System.out.println(modeStatus);
		}
		
		
		String date ="",today_date="", appointmentdate="";
		try 
		{
			// date
			java.util.Date present_date=null;
		
			 SimpleDateFormat d = new SimpleDateFormat("dd-MM-yyyy");
			 today_date=txtcurdate.getText();
			
			
			/*
			 * SimpleDateFormat d = new SimpleDateFormat("dd-MM-yyyy");
			 * 
			 * present_date= d.parse(today_date); java.sql.Date sd_present_date=new
			 * java.sql.Date(present_date.getTime());
			 */
					
					

			// AppointmentDate
			appointmentdate = d.format(datechooserappointment.getDate());
//			System.out.println("Date1=" + appointmentdate);
		}
		catch(Exception e){
		}		
		
		int age1=0;
		try {
		age1 = Integer.parseInt(age);
		}
		catch(Exception e) {
			}
		
		if (name.isEmpty() || age.isEmpty() || phone.isEmpty() || problem.isEmpty() || token.isEmpty()
				 || modeStatus.isEmpty()|| genderStatus.isEmpty() || appointmentdate.isEmpty()  ) 
		{
			JOptionPane.showMessageDialog(this, "All Fields Are Mandatory", "Mandatory Fields", JOptionPane.ERROR_MESSAGE);
		}

		else if (age1 <= 0 || age1 > 100) {
			JOptionPane.showMessageDialog(this, "Invalid Age", "Age", JOptionPane.ERROR_MESSAGE);
			
		}
		
		else if (phone.length() < 10 || phone.length() > 10) 
		{
			JOptionPane.showMessageDialog(this,  "Only Ten Digit Phone Number Is Allowed", "Inncorect", JOptionPane.ERROR_MESSAGE);

		}
		
		else if (idselected.equalsIgnoreCase("Select DoctorID")) {
			JOptionPane.showMessageDialog(this, "Please Select Valid DoctorID");
		}


		
		// Database
		else {
//			//select doctorid from doctor where doctorid=?
//			
//			SELECT * FROM doctor_db.doctor_details order by Doctorid desc    for last record
//			if(rs1.next())
//			{
//				JOptionPane.showMessageDialog(this, "id already exisis")
//			}
//			else {
			
			PreparedStatement ps = null;
			String str_insert = "insert into patient_details (PatientName, Gender, Age, Phone, Problem, DoctorID, Date, AppointmentDate, Token, AppointmentNo, AppointmentMode,PatientVisit) values (?,?,?,?,?,?,?,?,?,?,?,?)";

			try {
				      //Statement.RETURN_GENERATED_KEYS -> is for fetching generated appointment No. from database
//				ps = con.prepareStatement(str_insert, Statement.RETURN_GENERATED_KEYS);
				
				ps = con.prepareStatement(str_insert); 
								
				ps.setString(1, name);
				ps.setString(2, genderStatus);
				ps.setString(3, age);
				ps.setString(4, phone);
				ps.setString(5, problem);
				ps.setString(6, idselected);
				ps.setString(7, today_date);//present date
				ps.setString(8, appointmentdate);
				ps.setString(9, token);
				ps.setInt(10, Integer.parseInt(appointmentno));
				ps.setString(11, modeStatus);
				ps.setString(12, "No");		

				
				int row_status = ps.executeUpdate();
//				System.out.println("Insert status " + row_status);
				
				
//============= to get the next appointment no. from database
				ResultSet rs = ps.getGeneratedKeys();
				String appointment_no;

				if (row_status > 0) {
					
//					if(rs.next())
//					{
//						appointment_no= rs.getString(1);
////						System.out.println("AppointmentNo ="+appointment_no);
//						txtAppointmentNo.setText(appointment_no);
//						JOptionPane.showMessageDialog(this, "Appointment Number = "+appointment_no);
//					}					
					
					JOptionPane.showMessageDialog(this, "Patient Details Added Succesfully");

//=============== // to clear text field

					txtname.setText("");
					txtage.setText("");
					txtphone.setText("");
					txtproblem.setText("");
					cmbid.setSelectedIndex(-1);
					datechooserappointment.setDate(null);
					txttoken.setText("");
					txtAppointmentNo.setText("");
					modeGroup.clearSelection();
					genderGroup.clearSelection();

				}

			}

			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (ps != null)
					try {
						ps.close();
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

	String idselected=null;
	
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		int state = e.getStateChange();
//		System.out.println("getStateChange =" + state);

		idselected = (String) cmbid.getSelectedItem();
		if (state == 1) {
			if (idselected.equalsIgnoreCase("Select DoctorID")) {
				JOptionPane.showMessageDialog(this, "Please Select Valid DoctorID");
			}

			else {

				// fetch the value from JcomboBox
//				System.out.println("idselected=" + idselected);

				PreparedStatement ps = null;
				ResultSet rs = null;
				String strsql = "select * from doctor_details where DoctorID=?";
				try {
					ps = con.prepareStatement(strsql);
					ps.setString(1, idselected);
					rs = ps.executeQuery();
					rs.next();


				}

				catch (SQLException se) {
					se.printStackTrace();
				}

				finally {
					try {
						if (ps != null)
							ps.close();

						if (rs != null)
							rs.close();
					} catch (SQLException se) {
						se.printStackTrace();
					}

				}
			}
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == txtname)
		{
			char c = e.getKeyChar();
//			System.out.println(c);

			if (!(Character.isLetter(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE
					|| c == KeyEvent.VK_SPACE)) {
				e.consume();
				JOptionPane.showMessageDialog(this, "Only character", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource() == txtage) {
			char c = e.getKeyChar();
//			System.out.println(c);

			if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
				e.consume();
				JOptionPane.showMessageDialog(this, "Only Digit Allowed", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource() == txtphone) {
			char c = e.getKeyChar();
//			System.out.println(c);

			if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
				e.consume();
				JOptionPane.showMessageDialog(this, "Only Digit Allowed", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
