package dats.receptionist;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;

public class UpdatePatient extends JFrame implements ActionListener, ItemListener, WindowListener, KeyListener
{

	private JPanel contentPane;
	private JTextField txtPhone;
	private JTextField txtName;
	private final ButtonGroup visitGroup = new ButtonGroup();
	JButton btnUpdate;
	JComboBox cmbToken, cmbPhone;
	JRadioButton rdYes, rdNo;
	private Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomLookAndFeel.setLookAndFeel();
					
					UpdatePatient frame = new UpdatePatient();
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
	public UpdatePatient() 
	{
		createComponents();
	}
	
	
	public void createComponents()
	{
		con=DbConnection.openConnection();
		this.addWindowListener(this);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 567, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(this);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Patient Details");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(55, 11, 462, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblToken = new JLabel("Token Number");
		lblToken.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblToken.setBounds(55, 57, 160, 33);
		contentPane.add(lblToken);
		
		cmbToken = new JComboBox();
		cmbToken.addItemListener(this);
		
		cmbToken.setModel(new DefaultComboBoxModel(new String[] {"Select Token"}));
		cmbToken.setBounds(225, 57, 257, 33);
		contentPane.add(cmbToken);
		
		JLabel lblYouCanUpdate = new JLabel("You can update the following details....");
		lblYouCanUpdate.setFont(new Font("Calibri", Font.BOLD, 25));
		lblYouCanUpdate.setBounds(55, 152, 462, 32);
		contentPane.add(lblYouCanUpdate);
		
		txtPhone = new JTextField();
		txtPhone.addKeyListener(this);
		txtPhone.setColumns(10);
		txtPhone.setBounds(225, 195, 257, 33);
		contentPane.add(txtPhone);
		
		JLabel lblphone = new JLabel("Phone Number");
		lblphone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblphone.setBounds(55, 195, 160, 33);
		contentPane.add(lblphone);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(55, 101, 168, 33);
		contentPane.add(lblName);
		
		txtName = new JTextField();
		txtName.setBackground(SystemColor.controlHighlight);
		txtName.setEditable(false);
		txtName.setColumns(10);
		txtName.setBounds(225, 101, 257, 33);
		contentPane.add(txtName);
		
		JLabel lblPatientvisit = new JLabel("Patient Visit");
		lblPatientvisit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPatientvisit.setBounds(55, 239, 181, 33);
		contentPane.add(lblPatientvisit);
		
		rdYes = new JRadioButton("Yes");
		visitGroup.add(rdYes);
		rdYes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdYes.setBounds(273, 239, 68, 32);
		contentPane.add(rdYes);
		
		rdNo = new JRadioButton("No");
		visitGroup.add(rdNo);
//		rdNo.setSelected(true);
		rdNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdNo.setBounds(371, 239, 105, 32);
		contentPane.add(rdNo);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(this);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnUpdate.setBounds(225, 283, 257, 32);
		contentPane.add(btnUpdate);
		
		fillComboBox();
	}
	
	
	public void fillComboBox() 
	{
		PreparedStatement ps = null;
		ResultSet rs = null;

		String strsql = "select Token from patient_details where PatientVisit='No'";

		try {
			ps = con.prepareStatement(strsql); 
			rs = ps.executeQuery();
			
			while (rs.next()) {
				String token = rs.getString("Token");
				//System.out.println(token);
				cmbToken.addItem(token);   
				

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
		
		updatePatient();
	}
	
	
	//++++++++++++++++++++++++++++++++++++++
	
	public void updatePatient()
	{
		String phone = txtPhone.getText().trim();		

		if(phone.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Please Provide Valid Data");
			
		}
		
		else if (phone.length() < 10 || phone.length() > 10) 
		{
			JOptionPane.showMessageDialog(this, "Only Ten Digit Phone Number Is Allowed", "Inncorect", JOptionPane.ERROR_MESSAGE);
			
		}
		
		//Database
		else
		{
			PreparedStatement ps = null;
			String strupdate = "update patient_details set Phone=?, PatientVisit=? where Token=?";
			
			String yes="No";
			if(rdYes.isSelected())
			{
				yes="Yes";
			}
			
			try 
			{
				ps = con.prepareStatement(strupdate);
				
				ps.setString(1, phone);
				ps.setString(2, yes);
				ps.setString(3, tokenselected);
				

				int status = ps.executeUpdate();
				//System.out.println("status executeUpdate()="+status);
				
				if (status > 0)
					JOptionPane.showMessageDialog(this, "Patient Details Updated Successfully");
				txtName.setText("");
				txtPhone.setText("");
				visitGroup.clearSelection();

			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			finally {
				try {
				if(ps!=null)
					ps.close();
				}
			
				catch(SQLException se)
				{
					se.printStackTrace();
				}
			
			
			}
			
		}
	}
	

	//++++++++++++++++++++++++++++++++++++++++++
	
	String tokenselected=null;
	@Override
	public void itemStateChanged(ItemEvent e) 
	{

		int state = e.getStateChange();
		//System.out.println("State getStateChange()="+state);
		
		
		if (state == 1) {
			tokenselected = (String) cmbToken.getSelectedItem();
			
			
			if (tokenselected.equalsIgnoreCase("Select Token")) {
				JOptionPane.showMessageDialog(this, "Invalid Selection");
				
				txtName.setText("");
				txtPhone.setText("");
				visitGroup.clearSelection();
			}
		
			else 
			{
				//System.out.println("tokenselected="+tokenselected);
				
				PreparedStatement ps = null;
				ResultSet rs = null;
				
				//###############################################################

				String strsql = "select * from patient_details where Token=? ";
				
				try {
					ps = con.prepareStatement(strsql);
					
					ps.setString(1, tokenselected);					
					
					rs = ps.executeQuery();
					rs.next();

					String phone = rs.getString("Phone");
					String name= rs.getString("PatientName");
					String visit= rs.getString("PatientVisit");
//					//System.out.println("visit="+visit);

					txtPhone.setText(phone);
					txtName.setText(name);
					
					if(visit.equalsIgnoreCase("Yes"))
					{
						rdYes.setSelected(true);
					}
					if(visit.equalsIgnoreCase("No"))
					{
						rdNo.setSelected(true);
					}
					
					
					
					
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

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtPhone) {
			char c = e.getKeyChar();
			//System.out.println(c);

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
