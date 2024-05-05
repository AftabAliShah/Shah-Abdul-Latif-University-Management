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

public class Student_View extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblCnicAns;
	private JLabel lblFNameAns;
	private JLabel lblDeptAns;
	private JLabel lblNameAns;
	private JLabel lblBatchA;
	private JLabel lblRollNoA;
	private JLabel lblHscA;
	private JLabel lblDobA;
	private JLabel lblGenderA;
	private JLabel lblAddressA;
	private JLabel lblPhoneA;

	String rollNo;
	DBConnection con = new DBConnection();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student_View frame = new Student_View("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Student_View(String rollNo) {
		this.rollNo = rollNo;
		setTitle("Student View");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Student_View.class.getResource("/Images/uniLogo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, -13, 571, 586);
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

		JLabel lblDept = new JLabel("Department :");
		lblDept.setForeground(new Color(0, 0, 0));
		lblDept.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDept.setBounds(62, 288, 96, 21);
		contentPane.add(lblDept);

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

		JLabel lblRollNo = new JLabel("Roll No :");
		lblRollNo.setForeground(new Color(0, 0, 0));
		lblRollNo.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblRollNo.setBounds(62, 187, 65, 21);
		contentPane.add(lblRollNo);

		lblNameAns = new JLabel("");
		lblNameAns.setHorizontalAlignment(SwingConstants.LEFT);
		lblNameAns.setForeground(new Color(0, 0, 0));
		lblNameAns.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNameAns.setBounds(174, 224, 357, 21);
		contentPane.add(lblNameAns);

		lblDeptAns = new JLabel("");
		lblDeptAns.setHorizontalAlignment(SwingConstants.LEFT);
		lblDeptAns.setForeground(new Color(0, 0, 0));
		lblDeptAns.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDeptAns.setBounds(174, 288, 357, 21);
		contentPane.add(lblDeptAns);

		lblFNameAns = new JLabel("");
		lblFNameAns.setHorizontalAlignment(SwingConstants.LEFT);
		lblFNameAns.setForeground(new Color(0, 0, 0));
		lblFNameAns.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblFNameAns.setBounds(174, 256, 357, 21);
		contentPane.add(lblFNameAns);

		lblCnicAns = new JLabel("");
		lblCnicAns.setHorizontalAlignment(SwingConstants.LEFT);
		lblCnicAns.setForeground(new Color(0, 0, 0));
		lblCnicAns.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCnicAns.setBounds(174, 320, 357, 21);
		contentPane.add(lblCnicAns);

		JButton backBtn = new JButton("");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		backBtn.setIcon(new ImageIcon(Student_View.class.getResource("/Images/backSmall.png")));
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

		lblRollNoA = new JLabel("");
		lblRollNoA.setHorizontalAlignment(SwingConstants.LEFT);
		lblRollNoA.setForeground(new Color(0, 0, 0));
		lblRollNoA.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblRollNoA.setBounds(122, 187, 65, 21);
		contentPane.add(lblRollNoA);

		JLabel lblSalu = new JLabel("Shah Abdul Latif Bhitai University Portal");
		lblSalu.setForeground(Color.BLACK);
		lblSalu.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblSalu.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0),

				new Color(245, 255, 250), new Color(245, 255, 250)));
		lblSalu.setBounds(123, 53, 422, 30);
		contentPane.add(lblSalu);

		JLabel uniLogo = new JLabel("");
		uniLogo.setIcon(new ImageIcon(Student_View.class.getResource("/Images/uniLogo.png")));
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
		lblPhoneA.setBounds(174, 384, 357, 21);
		contentPane.add(lblPhoneA);

		JLabel lblHsc = new JLabel("Class 10th(%) :");
		lblHsc.setForeground(Color.BLACK);
		lblHsc.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblHsc.setBounds(62, 416, 100, 21);
		contentPane.add(lblHsc);

		lblHscA = new JLabel("");
		lblHscA.setHorizontalAlignment(SwingConstants.LEFT);
		lblHscA.setForeground(new Color(0, 0, 0));
		lblHscA.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblHscA.setBounds(174, 416, 357, 21);
		contentPane.add(lblHscA);

		JLabel lblDob = new JLabel("Date Of Birth :");
		lblDob.setForeground(Color.BLACK);
		lblDob.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDob.setBounds(62, 452, 100, 21);
		contentPane.add(lblDob);

		lblDobA = new JLabel("");
		lblDobA.setHorizontalAlignment(SwingConstants.LEFT);
		lblDobA.setForeground(new Color(0, 0, 0));
		lblDobA.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDobA.setBounds(174, 452, 357, 21);
		contentPane.add(lblDobA);

		JLabel lblGender = new JLabel("Gender :");
		lblGender.setForeground(Color.BLACK);
		lblGender.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblGender.setBounds(62, 484, 65, 21);
		contentPane.add(lblGender);

		lblGenderA = new JLabel("");
		lblGenderA.setHorizontalAlignment(SwingConstants.LEFT);
		lblGenderA.setForeground(new Color(0, 0, 0));
		lblGenderA.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblGenderA.setBounds(174, 484, 357, 21);
		contentPane.add(lblGenderA);

		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setForeground(Color.BLACK);
		lblAddress.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblAddress.setBounds(62, 352, 75, 21);
		contentPane.add(lblAddress);

		lblAddressA = new JLabel("");
		lblAddressA.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddressA.setForeground(new Color(0, 0, 0));
		lblAddressA.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblAddressA.setBounds(174, 352, 357, 21);
		contentPane.add(lblAddressA);

		JLabel lblBatch = new JLabel("Batch :");
		lblBatch.setForeground(Color.BLACK);
		lblBatch.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblBatch.setBounds(324, 187, 48, 21);
		contentPane.add(lblBatch);

		lblBatchA = new JLabel("");
		lblBatchA.setHorizontalAlignment(SwingConstants.LEFT);
		lblBatchA.setForeground(new Color(0, 0, 0));
		lblBatchA.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblBatchA.setBounds(378, 187, 84, 21);
		contentPane.add(lblBatchA);

		JLabel lblStudentInformation = new JLabel("Student Information");
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
			String query = "select Roll_no,Student,father_name,address,dateofbirth,Hsc_per,Phone_no,cnic,batch,gender,department from student where Roll_No =  '"
					+ rollNo + "'";
			ResultSet rs = con.statement.executeQuery(query);
			while (rs.next()) {
				lblNameAns.setText(rs.getString("student"));
				lblFNameAns.setText(rs.getString("Father_Name"));
				lblCnicAns.setText(rs.getString("Cnic"));
				lblDeptAns.setText(rs.getString("department"));
				lblRollNoA.setText(rs.getString("roll_no"));
				lblHscA.setText(rs.getString("hsc_per"));
				lblDobA.setText(rs.getString("dateofbirth"));
				lblGenderA.setText(rs.getString("gender"));
				lblAddressA.setText(rs.getString("address"));
				lblBatchA.setText(rs.getString("batch"));
				lblPhoneA.setText(rs.getString("phone_no"));
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
