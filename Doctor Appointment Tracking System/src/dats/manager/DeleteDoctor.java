package dats.manager;

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
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DeleteDoctor extends JFrame implements ActionListener, WindowListener
{

	private JPanel contentPane;
	private JTextField txtid;
	private JButton btndelete;
	private Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomLookAndFeel.setLookAndFeel();
					
					DeleteDoctor frame = new DeleteDoctor();
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
	public DeleteDoctor() 
	{
		createComponent();
	}
	
	
	void createComponent()
	{
		this.addWindowListener(this);
		con = DbConnection.openConnection();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(this);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delete Doctor Details");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(10, 11, 416, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblDoctorID = new JLabel("DoctorID");
		lblDoctorID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDoctorID.setBounds(85, 53, 116, 31);
		contentPane.add(lblDoctorID);
		
		txtid = new JTextField();
		txtid.setBounds(85, 81, 167, 31);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		btndelete = new JButton("Delete");
		btndelete.addActionListener(this);
		btndelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btndelete.setBounds(262, 81, 97, 31);
		contentPane.add(btndelete);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		deleteDoctor();
	}
	
	void deleteDoctor()
	{
		String id = txtid.getText().trim();
		if (id.isEmpty())
			JOptionPane.showMessageDialog(this, "Please Provide Doctor ID");
		
		else
		{
			int message = JOptionPane.showConfirmDialog(this, "Do You Want To Delete");
//			System.out.println(message);
			
			PreparedStatement ps = null;
			String str_delete = "delete from doctor_details where DoctorID=?";
			
			if(message==0)
			{
				try
				{
					ps=con.prepareStatement(str_delete);
					ps.setString(1, id);
					int row_status = ps.executeUpdate();
					
					if (row_status > 0) {
						JOptionPane.showMessageDialog(this, "Doctor Details Deleted Successfully", "Deletion", JOptionPane.CLOSED_OPTION);
						txtid.setText("");
					}
					
					else {
						JOptionPane.showMessageDialog(this, "Invalid Doctor ID", "Unavailable", JOptionPane.ERROR_MESSAGE);
						
					}
					
				} 
				
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally {
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
