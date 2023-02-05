package dats.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.toedter.calendar.JDateChooser;

import dats.gui.CustomLookAndFeel;
import dats.dbutils.DbConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DoctorIDWiseAppointment extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JTextField txtid;
	private JTable table;
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
					
					DoctorIDWiseAppointment frame = new DoctorIDWiseAppointment();
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
	public DoctorIDWiseAppointment() {
		createComponents();
	}
	
	void createComponents()
	{
		con=DbConnection.openConnection();
		
		setTitle("Doctor ID Wise Appointment");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 721, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(this);
		contentPane.setLayout(null);
		
		JLabel lblid = new JLabel("Doctor ID");
		lblid.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblid.setBounds(198, 56, 99, 30);
		contentPane.add(lblid);
		
		JLabel lblDoctorIdWise = new JLabel("Doctor ID Wise Appointment");
		lblDoctorIdWise.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoctorIdWise.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblDoctorIdWise.setBounds(10, 11, 687, 34);
		contentPane.add(lblDoctorIdWise);
		
		btnsearch = new JButton("Search");
		btnsearch.addActionListener(this);
		btnsearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnsearch.setBounds(382, 91, 124, 29);
		contentPane.add(btnsearch);
		
		txtid = new JTextField();
		txtid.setBounds(198, 91, 154, 29);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 131, 687, 343);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		showTable();
	}
	
	
	void showTable()
	{
		String id= txtid.getText();
		
		if(id.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please Enter Doctor ID");
		}
		
		
		else
		{			
			PreparedStatement ps=null;
			ResultSet rs=null;
			String strsql= "select * from patient_details where DoctorID=?";
			try
				{
					ps=con.prepareStatement(strsql);
					ps.setString(1, id);
					rs=ps.executeQuery();
						
			
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}
			
			catch(SQLException se)
			{
				se.printStackTrace();
			}
			finally {

				try {
					if (ps != null)
						ps.close();

					if (rs != null)
						rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}		
			
			
		}
				
		
		
	}
	
	
	
	
}















