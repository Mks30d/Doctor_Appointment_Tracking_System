package dats.receptionist;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dats.gui.AllDoctors;
import dats.gui.AllPatients;
import dats.gui.CustomLookAndFeel;
import dats.gui.DateWiseAppointment;
import dats.gui.DoctorIDWiseAppointment;
import dats.gui.Login;
import dats.manager.AddDoctor;
import dats.manager.DeleteDoctor;
import dats.manager.UpdateDoctor;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Frame;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Receptionist extends JFrame implements WindowListener, ActionListener
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
					
					Receptionist frame = new Receptionist();
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
	JMenuItem mi_add, mi_update, mi_tokenwise, mi_PatientList, mi_doctorlist;
	private JMenu m_view;
	private JMenuItem mi_phonewise;
	private JMenuItem mi_delete;
	private JMenu mnAppointment;
	private JMenuItem mi_doctoridwise;
	private JMenuItem mi_datewise;
	
	public Receptionist()  //constructor
	{
		setExtendedState(Frame.MAXIMIZED_BOTH);
		createComponents();
	}
	
	
	void createComponents()
	{
		this.addWindowListener(this);
		
		setTitle("Receptionist");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu m_patient = new JMenu("Patient");
		m_patient.setFont(new Font("Arial", Font.BOLD, 15));
		menuBar.add(m_patient);
		
		mi_add = new JMenuItem("Add");
		mi_add.addActionListener(this);
		m_patient.add(mi_add);
		
		mi_update = new JMenuItem("Update");
		mi_update.addActionListener(this);
		m_patient.add(mi_update);
		
		mi_delete = new JMenuItem("Delete");
		mi_delete.addActionListener(this);
		m_patient.add(mi_delete);
		
		JMenu m_search = new JMenu("Search Patient");
		m_search.setFont(new Font("Arial", Font.BOLD, 15));
		menuBar.add(m_search);
		
		mi_tokenwise = new JMenuItem("TokenWise");
		mi_tokenwise.addActionListener(this);
		m_search.add(mi_tokenwise);
		
		mi_phonewise = new JMenuItem("PhoneWise");
		mi_phonewise.addActionListener(this);
		m_search.add(mi_phonewise);
		
		mnAppointment = new JMenu("Appointment");
		mnAppointment.setFont(new Font("Arial", Font.BOLD, 15));
		menuBar.add(mnAppointment);
		
		mi_doctoridwise = new JMenuItem("DoctorIDWise");
		mi_doctoridwise.addActionListener(this);
		mnAppointment.add(mi_doctoridwise);
		
		mi_datewise = new JMenuItem("DateWise");
		mi_datewise.addActionListener(this);
		mnAppointment.add(mi_datewise);
		
		m_view = new JMenu("View");
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
//		setResizable(false);
		contentPane.setLayout(null);
		
		
		
		ImageIcon ic=new ImageIcon(Receptionist.class.getResource("/dats/images/4860151.jpg"));
		Image i = ic.getImage().getScaledInstance(1350, 639, Image.SCALE_SMOOTH);
		ImageIcon ic1 = new ImageIcon(i);
		
		JLabel lblNewLabel = new JLabel(ic1);
		lblNewLabel.setBounds(0, 0, 1350, 639);
		contentPane.add(lblNewLabel);
	

	}	

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String caption= e.getActionCommand();
		//////System.out.println(caption);
		
		switch (caption) 
		{
		case "Add": {
			AddPatient ap= new AddPatient(); 
			ap.setVisible(true);
			break;
		}
		case "Update": {
			UpdatePatient up= new UpdatePatient(); 
			up.setVisible(true);
			break;
		}
		case "Delete": {
			DeletePatient dp= new DeletePatient();
			dp.setVisible(true);
			break;
		}
		
		case"TokenWise":
		{
			TokenWisePatient tw= new TokenWisePatient();
			tw.setVisible(true);
			break;
		}
		case"PhoneWise":
		{
			PhoneWisePatient pw= new PhoneWisePatient();
			pw.setVisible(true);
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
