package dats.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
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

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import dats.gui.CustomLookAndFeel;
import dats.dbutils.DbConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.sql.*;


public class DateWiseAppointment extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JTable table;
	JButton btnsearch;
	JDateChooser dateChooser;
	private Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomLookAndFeel.setLookAndFeel();
					
					DateWiseAppointment frame = new DateWiseAppointment();
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
	public DateWiseAppointment() {
		createComponents();
	}
	
	
	void createComponents()
	{
		con=DbConnection.openConnection();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 693, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(this);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Date Wise Appointment");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(10, 11, 659, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Appointment Date");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(175, 64, 166, 30);
		contentPane.add(lblNewLabel_1);
		
		btnsearch = new JButton("Search");
		btnsearch.addActionListener(this);
		btnsearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnsearch.setBounds(376, 94, 124, 33);
		contentPane.add(btnsearch);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(175, 97, 191, 30);
		contentPane.add(dateChooser);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 138, 659, 351);
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
		
		Date date = null; 
		String date1 = null;
		try {
		SimpleDateFormat d = new SimpleDateFormat("dd-MM-yyyy");
//		dateChooser.setDate(null);
		date=dateChooser.getDate();
		date1 = d.format(date);
		////System.out.println("Date=" + date1);
		}
		
		catch(Exception e)
		{
//			JOptionPane.showMessageDialog(this, "Please Enter Date");
		}
		
		if(date==null) {
			JOptionPane.showMessageDialog(this, "Please Enter Date");
		}
		
		
		else
		{			
			PreparedStatement ps=null;
			ResultSet rs=null;
			String strsql= "select * from patient_details where AppointmentDate=?";
			try
				{
					ps=con.prepareStatement(strsql);
					ps.setString(1, date1);
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
