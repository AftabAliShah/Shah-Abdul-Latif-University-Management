package university;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Employee_View extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblCnicAns;
	private JLabel lblFNameAns;
	private JLabel lblTypeA;
	private JLabel lblNameAns;
	private JLabel lblIdA;
	private JLabel lblDesigA;
	private JLabel lblGenderA;
	private JLabel lblCityA;
	private JLabel lblPhoneA;

	String id;
	DBConnection con = new DBConnection();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee_View frame = new Employee_View("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Employee_View(String id) {
		this.id = id;
		setTitle("Employe View");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Employee_View.class.getResource("/Images/uniLogo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, -13, 571, 536);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblName = new JLabel("Name :");
		lblName.setForeground(new Color(0, 0, 0));
		lblName.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblName.setBounds(62, 224, 54, 21);
		contentPane.add(lblName);

		JLabel lblType = new JLabel("Type :");
		lblType.setForeground(new Color(0, 0, 0));
		lblType.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblType.setBounds(62, 288, 59, 21);
		contentPane.add(lblType);

		JLabel lblFName = new JLabel("Father's Name :");
		lblFName.setForeground(new Color(0, 0, 0));
		lblFName.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblFName.setBounds(62, 256, 114, 21);
		contentPane.add(lblFName);

		JLabel lblCnicNo = new JLabel("CNIC No :");
		lblCnicNo.setForeground(new Color(0, 0, 0));
		lblCnicNo.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCnicNo.setBounds(62, 320, 65, 21);
		contentPane.add(lblCnicNo);

		JLabel lblId = new JLabel("ID :");
		lblId.setForeground(new Color(0, 0, 0));
		lblId.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblId.setBounds(62, 187, 40, 21);
		contentPane.add(lblId);

		lblNameAns = new JLabel("");
		lblNameAns.setHorizontalAlignment(SwingConstants.LEFT);
		lblNameAns.setForeground(new Color(0, 0, 0));
		lblNameAns.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNameAns.setBounds(197, 224, 334, 21);
		contentPane.add(lblNameAns);

		lblTypeA = new JLabel("");
		lblTypeA.setHorizontalAlignment(SwingConstants.LEFT);
		lblTypeA.setForeground(new Color(0, 0, 0));
		lblTypeA.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTypeA.setBounds(197, 288, 334, 21);
		contentPane.add(lblTypeA);

		lblFNameAns = new JLabel("");
		lblFNameAns.setHorizontalAlignment(SwingConstants.LEFT);
		lblFNameAns.setForeground(new Color(0, 0, 0));
		lblFNameAns.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblFNameAns.setBounds(197, 256, 334, 21);
		contentPane.add(lblFNameAns);

		lblCnicAns = new JLabel("");
		lblCnicAns.setHorizontalAlignment(SwingConstants.LEFT);
		lblCnicAns.setForeground(new Color(0, 0, 0));
		lblCnicAns.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCnicAns.setBounds(197, 320, 334, 21);
		contentPane.add(lblCnicAns);

		JButton backBtn = new JButton("");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		backBtn.setIcon(new ImageIcon(Employee_View.class.getResource("/Images/backSmall.png")));
		backBtn.setForeground(new Color(245, 255, 250));
		backBtn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		backBtn.setBorder(null);
		backBtn.setBackground(new Color(245, 255, 250));
		backBtn.setBounds(10, 11, 30, 30);
		contentPane.add(backBtn);

		JLabel lblBack = new JLabel("Back");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				back();
			}
		});
		lblBack.setForeground(new Color(0, 0, 0));
		lblBack.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblBack.setBounds(42, 17, 40, 18);
		contentPane.add(lblBack);

		lblIdA = new JLabel("");
		lblIdA.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdA.setForeground(new Color(0, 0, 0));
		lblIdA.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblIdA.setBounds(99, 187, 65, 21);
		contentPane.add(lblIdA);

		JLabel lblSalu = new JLabel("Shah Abdul Latif Bhitai University Portal");
		lblSalu.setForeground(Color.BLACK);
		lblSalu.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblSalu.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0),

				new Color(245, 255, 250), new Color(245, 255, 250)));
		lblSalu.setBounds(123, 53, 422, 30);
		contentPane.add(lblSalu);

		JLabel uniLogo = new JLabel("");
		uniLogo.setIcon(new ImageIcon(Employee_View.class.getResource("/Images/uniLogo.png")));
		uniLogo.setBounds(10, 39, 109, 97);
		contentPane.add(uniLogo);

		JLabel lblPhone = new JLabel("Phone No :");
		lblPhone.setForeground(Color.BLACK);
		lblPhone.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblPhone.setBounds(62, 384, 84, 21);
		contentPane.add(lblPhone);

		lblPhoneA = new JLabel("");
		lblPhoneA.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhoneA.setForeground(new Color(0, 0, 0));
		lblPhoneA.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblPhoneA.setBounds(197, 384, 334, 21);
		contentPane.add(lblPhoneA);

		JLabel lblDesignation = new JLabel("Designaion :");
		lblDesignation.setForeground(Color.BLACK);
		lblDesignation.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDesignation.setBounds(62, 416, 102, 21);
		contentPane.add(lblDesignation);

		lblDesigA = new JLabel("");
		lblDesigA.setHorizontalAlignment(SwingConstants.LEFT);
		lblDesigA.setForeground(new Color(0, 0, 0));
		lblDesigA.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDesigA.setBounds(197, 416, 334, 21);
		contentPane.add(lblDesigA);

		JLabel lblGender = new JLabel("Gender :");
		lblGender.setForeground(Color.BLACK);
		lblGender.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblGender.setBounds(62, 448, 65, 21);
		contentPane.add(lblGender);

		lblGenderA = new JLabel("");
		lblGenderA.setHorizontalAlignment(SwingConstants.LEFT);
		lblGenderA.setForeground(new Color(0, 0, 0));
		lblGenderA.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblGenderA.setBounds(197, 448, 334, 21);
		contentPane.add(lblGenderA);

		JLabel lblCity = new JLabel("City :");
		lblCity.setForeground(Color.BLACK);
		lblCity.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCity.setBounds(62, 352, 54, 21);
		contentPane.add(lblCity);

		lblCityA = new JLabel("");
		lblCityA.setHorizontalAlignment(SwingConstants.LEFT);
		lblCityA.setForeground(new Color(0, 0, 0));
		lblCityA.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCityA.setBounds(197, 352, 334, 21);
		contentPane.add(lblCityA);

		JLabel lblStudentInformation = new JLabel("Employe Information");
		lblStudentInformation.setForeground(Color.BLACK);
		lblStudentInformation.setFont(new Font("Stencil", Font.PLAIN, 21));
		lblStudentInformation.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0),
				new Color(0, 0, 0), new Color(0, 0, 0)));
		lblStudentInformation.setBounds(216, 94, 237, 27);
		contentPane.add(lblStudentInformation);

		setDataIntoLabel();

	}

	private void setDataIntoLabel() {
		try {
			String query = "select * from employee where emp_id =  '"
					+ id + "'";
			ResultSet rs = con.statement.executeQuery(query);
			while (rs.next()) {
				lblNameAns.setText(rs.getString("employee"));
				lblFNameAns.setText(rs.getString("Father_Name"));
				lblCnicAns.setText(rs.getString("Cnic"));
				lblTypeA.setText(rs.getString("emp_type"));
				lblIdA.setText(rs.getString("emp_id"));
				lblDesigA.setText(rs.getString("designation"));
				lblGenderA.setText(rs.getString("gender"));
				lblCityA.setText(rs.getString("city"));
				lblPhoneA.setText(rs.getString("phone"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void back() {
		this.setVisible(false);
		Admission_Screen as = new Admission_Screen();
		as.setVisible(true);
	}
}
