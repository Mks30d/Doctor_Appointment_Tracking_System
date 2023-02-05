package dats.manager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dats.gui.AllDoctors;
import dats.gui.AllPatients;
import dats.gui.CustomLookAndFeel;
import dats.gui.DateWiseAppointment;
import dats.gui.DoctorIDWiseAppointment;
import dats.gui.Login;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.Frame;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Manager extends JFrame implements WindowListener, ActionListener
{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomLookAndFeel.setLookAndFeel();
					
					Manager frame = new Manager();
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
	JMenuItem mi_add, mi_update, mi_delete, mi_doctorlist;
	private JMenuItem mi_PatientList;
	private JMenu m_appointment;
	private JMenuItem mi_doctoridwise;
	private JMenuItem mi_datewise;
	
	public Manager() //constructor
	{
		setExtendedState(Frame.MAXIMIZED_BOTH);
		
		createComponents();
	}
	
	
	void createComponents()
	{
		this.addWindowListener(this);
		
		setTitle("Manager");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 956, 695);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu m_doctor = new JMenu("Doctor");
		m_doctor.setFont(new Font("Arial", Font.BOLD, 15));
		menuBar.add(m_doctor);
		
		 mi_add = new JMenuItem("Add");
		 mi_add.addActionListener(this);
		m_doctor.add(mi_add);
		
		 mi_update = new JMenuItem("Update");
		 mi_update.addActionListener(this);
		m_doctor.add(mi_update);
		
		 mi_delete = new JMenuItem("Delete");
		 mi_delete.addActionListener(this);
		m_doctor.add(mi_delete);
		
		m_appointment = new JMenu("Appointment");
		m_appointment.setFont(new Font("Arial", Font.BOLD, 15));
		menuBar.add(m_appointment);
		
		mi_doctoridwise = new JMenuItem("DoctorIDWise");
		mi_doctoridwise.addActionListener(this);
		m_appointment.add(mi_doctoridwise);
		
		mi_datewise = new JMenuItem("DateWise");
		mi_datewise.addActionListener(this);
		m_appointment.add(mi_datewise);
		
		JMenu m_view = new JMenu("View");
		m_view.setFont(new Font("Arial", Font.BOLD, 15));
		menuBar.add(m_view);
		
		mi_doctorlist = new JMenuItem("DoctorList");
		mi_doctorlist.addActionListener(this);
		m_view.add(mi_doctorlist);
		
		mi_PatientList = new JMenuItem("PatientList");
		mi_PatientList.addActionListener(this);
		m_view.add(mi_PatientList);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(this);
		contentPane.setLayout(null);
		
		ImageIcon ic=new ImageIcon(Login.class.getResource("/dats/images/doctor_office-wallpaper-1920x1080.jpg"));
		Image i2 = ic.getImage().getScaledInstance(1286, 633, Image.SCALE_DEFAULT);
		ImageIcon ic1 = new ImageIcon(i2);
		
		JLabel lblNewLabel = new JLabel(ic1);
		lblNewLabel.setBounds(0, 0, 1286, 633);
		contentPane.add(lblNewLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String caption= e.getActionCommand();
//		System.out.println(caption);
		
		switch (caption) 
		{
		case "Add": {
			AddDoctor ad= new AddDoctor(); 
			ad.setVisible(true);
			break;
		}
		case "Update": {
			UpdateDoctor ud= new UpdateDoctor(); 
			ud.setVisible(true);
			break;
		}
		case "Delete": {
			DeleteDoctor dd= new DeleteDoctor();
			dd.setVisible(true);
			break;
		}
		case "DoctorList": {
			AllDoctors ad= new AllDoctors();
			ad.setVisible(true);
			break;
		}
		
		case "PatientList": {
			AllPatients ap= new AllPatients();
			ap.setVisible(true);
			break;
		}
		
		case "DoctorIDWise": {
			DoctorIDWiseAppointment did= new DoctorIDWiseAppointment();
			did.setVisible(true);
			break;
		}
		
		case "DateWise": {
			DateWiseAppointment dw= new DateWiseAppointment();
			dw.setVisible(true);
			break;
		}
		
		
		}
		
		
	}
	
	
	
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		Login l= new Login();
		l.setVisible(true);
		
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
