package dats.manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.PreparableStatement;

import dats.dbutils.DbConnection;
import dats.gui.CustomLookAndFeel;

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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class UpdateDoctor extends JFrame implements ActionListener, WindowListener, ItemListener, KeyListener
{

	private JPanel contentPane;
	private JTextField txtphone, txtemail, txttiming;
	private JButton btnupdate;
	private JTextArea txtaddress;
	private JCheckBox cbmon, cbtue, cbwed, cbthu, cbfri, cbsat, cbsun;
	JComboBox cmbid;
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
					
					UpdateDoctor frame = new UpdateDoctor();
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
	public UpdateDoctor() {
		createComponents();

	}

	public void createComponents() {
		con = DbConnection.openConnection();
		this.addWindowListener(this);

		setTitle("Update");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 642, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblupdatedetails = new JLabel("Update Doctor Details");
		lblupdatedetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblupdatedetails.setFont(new Font("Calibri", Font.BOLD, 25));
		lblupdatedetails.setBounds(161, 11, 291, 32);
		contentPane.add(lblupdatedetails);

		JLabel lblid = new JLabel("Doctor ID");
		lblid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblid.setBounds(72, 54, 116, 33);
		contentPane.add(lblid);

		JLabel lblphone = new JLabel("Phone (+91)");
		lblphone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblphone.setBounds(72, 153, 127, 33);
		contentPane.add(lblphone);

		txtphone = new JTextField();
		txtphone.addKeyListener(this);
		txtphone.setColumns(10);
		txtphone.setBounds(221, 153, 313, 33);
		contentPane.add(txtphone);

		JLabel lbladdress = new JLabel("Address");
		lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbladdress.setBounds(72, 357, 116, 33);
		contentPane.add(lbladdress);

		txtaddress = new JTextArea();
		txtaddress.setBounds(221, 357, 313, 79);
		contentPane.add(txtaddress);

		JLabel lblemail = new JLabel("Email");
		lblemail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblemail.setBounds(72, 197, 116, 33);
		contentPane.add(lblemail);

		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(221, 197, 313, 33);
		contentPane.add(txtemail);

		JLabel lbltiming = new JLabel("Timing");
		lbltiming.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbltiming.setBounds(72, 241, 116, 33);
		contentPane.add(lbltiming);

		txttiming = new JTextField();
		txttiming.setColumns(10);
		txttiming.setBounds(221, 241, 313, 33);
		contentPane.add(txttiming);

		JLabel lblDays = new JLabel("Days");
		lblDays.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDays.setBounds(72, 285, 116, 33);
		contentPane.add(lblDays);

		cbmon = new JCheckBox("Mon");
		cbmon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbmon.setBounds(221, 281, 67, 33);
		contentPane.add(cbmon);

		cbfri = new JCheckBox("Fri");
		cbfri.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbfri.setBounds(221, 317, 67, 33);
		contentPane.add(cbfri);

		cbsat = new JCheckBox("Sat");
		cbsat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbsat.setBounds(307, 317, 67, 33);
		contentPane.add(cbsat);

		cbtue = new JCheckBox("Tue");
		cbtue.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbtue.setBounds(307, 281, 67, 33);
		contentPane.add(cbtue);

		cbwed = new JCheckBox("Wed");
		cbwed.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbwed.setBounds(385, 281, 67, 33);
		contentPane.add(cbwed);

		cbsun = new JCheckBox("Sun");
		cbsun.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbsun.setBounds(385, 317, 67, 33);
		contentPane.add(cbsun);

		cbthu = new JCheckBox("Thu");
		cbthu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbthu.setBounds(472, 281, 62, 33);
		contentPane.add(cbthu);

		JLabel lblYouCanUpdate = new JLabel("You can update the following details....");
		lblYouCanUpdate.setFont(new Font("Calibri", Font.BOLD, 25));
		lblYouCanUpdate.setBounds(72, 110, 462, 32);
		contentPane.add(lblYouCanUpdate);

		btnupdate = new JButton("UPDATE");
		btnupdate.addActionListener(this);
		btnupdate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnupdate.setBounds(221, 447, 313, 36);
		contentPane.add(btnupdate);

		cmbid = new JComboBox();
		cmbid.setModel(new DefaultComboBoxModel(new String[] { "Select Doctor ID" }));
		cmbid.setBounds(221, 54, 313, 33);
		
		cmbid.addItemListener(this);
		contentPane.add(cmbid);

		fillComboBox(); // method to fill data from database
	}

	public void fillComboBox() 
	{

		PreparedStatement ps = null;
		ResultSet rs = null;

		String strsql = "select DoctorID from doctor_details";

		try {
			ps = con.prepareStatement(strsql);

			rs = ps.executeQuery();
//			System.out.println("rs="+rs);
			while (rs.next()) {
				String doctorID = rs.getString("DoctorID");
//				System.out.println(doctorID);
				cmbid.addItem(doctorID);
				
			}
		} 
		catch (SQLException se) {
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
		// TODO Auto-generated method stub
//		System.out.println("clicked");
		updateDoctor();
		daysStatus="";
	}

	public void updateDoctor() {

		String phone = txtphone.getText().trim();
		String email = txtemail.getText().trim();
		String timing = txttiming.getText().trim();
		String address = txtaddress.getText().trim();

		// CheckBox Status
		daysStatus(cbmon);
		daysStatus(cbtue);
		daysStatus(cbwed);
		daysStatus(cbthu);
		daysStatus(cbfri);
		daysStatus(cbsat);
		daysStatus(cbsun);

		
		if (phone.isEmpty() || email.isEmpty() || timing.isEmpty() || address.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "All Fields Are Mandatory", "Mandatory Fields", JOptionPane.ERROR_MESSAGE);
		}
		
		else if (phone.length() < 10 || phone.length() > 10) 
		{
			JOptionPane.showMessageDialog(this, "Only Ten Digit Phone Number Is Allowed", "Inncorect", JOptionPane.ERROR_MESSAGE);
			
		}
		
		else {
			PreparedStatement ps = null;

			String strupdate = "update doctor_details set Phone=?,Email=?,Timing=?,Address=?, Days=? where DoctorID=?";

			try {

				ps = con.prepareStatement(strupdate);
				ps.setString(1, phone);
				ps.setString(2, email);
				ps.setString(3, timing);
				ps.setString(4, address);
				ps.setString(5, daysStatus);
				ps.setString(6, idselected);
				

				int status = ps.executeUpdate();
				if (status > 0)

					JOptionPane.showMessageDialog(this, " Doctor Details Updated Successfully");

				//to clear text field 
				cbmon.setSelected(false);
				cbtue.setSelected(false);
				cbwed.setSelected(false);
				cbthu.setSelected(false);
				cbfri.setSelected(false);
				cbsat.setSelected(false);
				cbsun.setSelected(false);
				
				txtphone.setText("");
				txtemail.setText("");
				txttiming.setText("");
				txtaddress.setText("");
				
				
			}

			catch (SQLException se) {
				se.printStackTrace();
			} finally {
				try {
					if (ps != null)
						ps.close();
				}

				catch (SQLException se) {
					se.printStackTrace();
				}

			}

		}

	}

	
	// CheckBox Status using mehtod
//	String daysStatus="";
	void daysStatus(JCheckBox checkbox) {
		if (checkbox.isSelected()) {
			daysStatus= daysStatus + checkbox.getText() + "," ;
//			System.out.println("daysStatus="+daysStatus);
		}
	}

	//+++++++++++++++++++++++++++++++++++++++++++++++++++
	
	String idselected=null;
	@Override
	public void itemStateChanged(ItemEvent e) {
 
		int state = e.getStateChange();
		

		if (state == 1)
		{
//			System.out.println("State =" + state);
			
			idselected = (String) cmbid.getSelectedItem();
			
			if (idselected.equalsIgnoreCase("Select Doctor ID")) {
				JOptionPane.showMessageDialog(this, "Please Select Valid Doctor ID");
				cbmon.setSelected(false);
				cbtue.setSelected(false);
				cbwed.setSelected(false);
				cbthu.setSelected(false);
				cbfri.setSelected(false);
				cbsat.setSelected(false);
				cbsun.setSelected(false);
				
				txtphone.setText("");
				txtemail.setText("");
				txttiming.setText("");
				txtaddress.setText("");
			}

			else {
					
//				System.out.println("idselected="+idselected);

				
				cbmon.setSelected(false);
				cbtue.setSelected(false);
				cbwed.setSelected(false);
				cbthu.setSelected(false);
				cbfri.setSelected(false);
				cbsat.setSelected(false);
				cbsun.setSelected(false);
				
				txtphone.setText("");
				txtemail.setText("");
				txttiming.setText("");
				txtaddress.setText("");
				
				
				
				
				PreparedStatement ps = null;
				ResultSet rs = null;
				String strsql = "select * from doctor_details where DoctorID=?";
				
				try {
					ps = con.prepareStatement(strsql);
					ps.setString(1, idselected);
					rs = ps.executeQuery();
					rs.next();

					String phone = rs.getString("Phone");
					String email = rs.getString("Email");
					String timing = rs.getString("Timing");
					String address = rs.getString("Address");

					String days=rs.getString("Days");
					
					String[] days_arr=days.split(",");
					for (int i=0;i<days_arr.length;i++)
					{
//						System.out.println(days_arr[i]);
						
						if(cbmon.getText().equalsIgnoreCase(days_arr[i]))
							cbmon.setSelected(true);
						
						if(cbtue.getText().equalsIgnoreCase(days_arr[i]))
							cbtue.setSelected(true);
						
						if(cbwed.getText().equalsIgnoreCase(days_arr[i]))
							cbwed.setSelected(true);
						
						if(cbthu.getText().equalsIgnoreCase(days_arr[i]))
							cbthu.setSelected(true);
						
						if(cbfri.getText().equalsIgnoreCase(days_arr[i]))
							cbfri.setSelected(true);
						
						if(cbsat.getText().equalsIgnoreCase(days_arr[i]))
							cbsat.setSelected(true);
						
						if(cbsun.getText().equalsIgnoreCase(days_arr[i]))
							cbsun.setSelected(true);
						
						
					}
					
					txtphone.setText(phone);
					txtemail.setText(email);
					txttiming.setText(timing);
					txtaddress.setText(address);
					
					
										

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
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub

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
		if (e.getSource() == txtphone) {
			char c = e.getKeyChar();
//			System.out.println(c);

			if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
				e.consume();
				JOptionPane.showMessageDialog(this, "Only digit", "Error", JOptionPane.ERROR_MESSAGE);
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
