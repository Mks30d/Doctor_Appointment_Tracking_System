package dats.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dats.gui.CustomLookAndFeel;
import dats.dbutils.DbConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JTable;

public class AllPatients extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomLookAndFeel.setLookAndFeel();
					
					AllPatients frame = new AllPatients();
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
	public AllPatients() 
	{
		con= DbConnection.openConnection();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 821, 594);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(this);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 58, 787, 488);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblAllDoctorDetails = new JLabel("ALL PATIENT DETAILS");
		lblAllDoctorDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllDoctorDetails.setFont(new Font("Calibri", Font.BOLD, 25));
		lblAllDoctorDetails.setBounds(10, 11, 787, 32);
		contentPane.add(lblAllDoctorDetails);
		
		showTable();
	}
	
	public void showTable()
	{
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		String strsql= "select * from patient_details";
		
		try {
			ps= con.prepareStatement(strsql);
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
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
	}

}
