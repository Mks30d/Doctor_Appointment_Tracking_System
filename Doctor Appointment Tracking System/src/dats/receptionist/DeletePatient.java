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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DeletePatient extends JFrame implements ActionListener, WindowListener, KeyListener
{

	private JPanel contentPane;
	private JTextField txtAppointmentNo;
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
					
					DeletePatient frame = new DeletePatient();
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
	public DeletePatient() 
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
		
		JLabel lblNewLabel = new JLabel("Delete Patient Details");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel.setBounds(10, 11, 416, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblAppointmentNo = new JLabel("Appointment Number");
		lblAppointmentNo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAppointmentNo.setBounds(56, 53, 219, 31);
		contentPane.add(lblAppointmentNo);
		
		txtAppointmentNo = new JTextField();
		txtAppointmentNo.addKeyListener(this);
		txtAppointmentNo.setBounds(56, 81, 219, 31);
		contentPane.add(txtAppointmentNo);
		txtAppointmentNo.setColumns(10);
		
		btndelete = new JButton("Delete");
		btndelete.addActionListener(this);
		btndelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btndelete.setBounds(285, 81, 96, 31);
		contentPane.add(btndelete);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		deleteDoctor();
	}
	
	void deleteDoctor()
	{
		String appointmentno = txtAppointmentNo.getText().trim();
		if (appointmentno.isEmpty())
			JOptionPane.showMessageDialog(this, "Please Provide Appointment Number");
		
		else
		{
			int message = JOptionPane.showConfirmDialog(this, "Do You Want To Delete");
//			System.out.println(message);
			
			PreparedStatement ps = null;
			String str_delete = "delete from patient_details where AppointmentNo=?";
			
			if(message==0)
			{
				try
				{
					ps=con.prepareStatement(str_delete);
					ps.setInt(1, Integer.parseInt(appointmentno));
					int row_status = ps.executeUpdate();
					
					if (row_status > 0) {
						JOptionPane.showMessageDialog(this, "Patient Details Deleted Successfully", "Deletion", JOptionPane.CLOSED_OPTION);
						txtAppointmentNo.setText("");
					}
					
					else {
						JOptionPane.showMessageDialog(this, "No Such Appointment Number Present", "Unavailable", JOptionPane.ERROR_MESSAGE);
						
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

	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getSource()==txtAppointmentNo)
		{
			char c= e.getKeyChar();
//			System.out.println(c);
			
			if( !( Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE ) ||  c==KeyEvent.VK_DELETE ))
			{
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
