package university;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Fee_Pay_Form extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox comboDept;
	private JComboBox comboSems;
	private JComboBox comboRollNo;
	private JLabel lblFNameA;
	private JLabel lblNameA;
	private JLabel lblAmountA;
	private JDateChooser dateChooser;
	DBConnection con = new DBConnection();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fee_Pay_Form frame = new Fee_Pay_Form();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Fee_Pay_Form() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Fee_Pay_Form.class.getResource("/Images/uniLogo.png")));
		setTitle("Pay Fee");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 588);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);

		JLabel lblAmount = new JLabel("Total Payable :");
		lblAmount.setForeground(Color.WHITE);
		lblAmount.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblAmount.setBounds(232, 446, 103, 21);
		contentPane.add(lblAmount);

		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setForeground(Color.WHITE);
		lblDepartment.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblDepartment.setBounds(232, 260, 83, 21);
		contentPane.add(lblDepartment);

		JLabel lblHeading = new JLabel("PAY FEE");
		lblHeading.setForeground(Color.WHITE);
		lblHeading.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblHeading.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(105, 105, 105), new Color(105, 105, 105),
				new Color(255, 255, 255), new Color(255, 255, 255)));
		lblHeading.setBounds(328, 31, 83, 36);
		contentPane.add(lblHeading);

		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertData();
			}

		});
		btnSubmit.setBounds(329, 498, 107, 28);
		contentPane.add(btnSubmit);
		btnSubmit.setForeground(new Color(245, 255, 250));
		btnSubmit.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		btnSubmit.setBorder(
				new BevelBorder(BevelBorder.LOWERED, new Color(245, 255, 250), new Color(245, 255, 250), null, null));
		btnSubmit.setBackground(Color.BLACK);

		comboDept = new JComboBox();
		comboDept.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				setAmountAccordingToDept();
			}
		});
		comboDept.setForeground(Color.BLACK);
		comboDept.setFont(new Font("SansSerif", Font.BOLD, 14));
		comboDept.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		comboDept.setBackground(SystemColor.inactiveCaptionBorder);
		comboDept.setBounds(232, 281, 237, 28);
		contentPane.add(comboDept);

		JButton backBtn = new JButton("");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Receipts_Screen fs = new Receipts_Screen();
				fs.setVisible(true);
			}
		});
		backBtn.setForeground(UIManager.getColor("Button.darkShadow"));
		backBtn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		backBtn.setBorder(null);
		backBtn.setBackground(new Color(245, 255, 250));
		backBtn.setBounds(10, 11, 30, 30);
		backBtn.setIcon(new ImageIcon(Stu_Update.class.getResource("/Images/backSmall.png")));
		contentPane.add(backBtn);

		JLabel lblBack = new JLabel("Back");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				Receipts_Screen fs = new Receipts_Screen();
				fs.setVisible(true);
			}
		});
		lblBack.setForeground(new Color(0, 0, 0));
		lblBack.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblBack.setBounds(46, 17, 40, 18);
		contentPane.add(lblBack);

		JLabel lblSems = new JLabel("Semester");
		lblSems.setForeground(Color.WHITE);
		lblSems.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblSems.setBounds(232, 320, 68, 21);
		contentPane.add(lblSems);

		comboSems = new JComboBox();
		comboSems.setForeground(Color.BLACK);
		comboSems.setFont(new Font("SansSerif", Font.BOLD, 14));
		comboSems.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		comboSems.setBackground(SystemColor.inactiveCaptionBorder);
		comboSems.setBounds(232, 341, 237, 28);
		contentPane.add(comboSems);

		JLabel lblRollNo = new JLabel("Roll No");
		lblRollNo.setForeground(Color.WHITE);
		lblRollNo.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblRollNo.setBounds(232, 98, 60, 21);
		contentPane.add(lblRollNo);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 255, 250));
		panel.setBounds(0, 0, 207, 549);
		contentPane.add(panel);
		panel.setLayout(null);

		comboRollNo = new JComboBox();
		comboRollNo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				setDataIntoLabel();
			}
		});
		comboRollNo.setForeground(Color.BLACK);
		comboRollNo.setFont(new Font("SansSerif", Font.BOLD, 14));
		comboRollNo.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		comboRollNo.setBackground(SystemColor.inactiveCaptionBorder);
		comboRollNo.setBounds(232, 119, 237, 28);
		contentPane.add(comboRollNo);

		JLabel lblName = new JLabel("Name :");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblName.setBounds(232, 170, 60, 21);
		contentPane.add(lblName);

		JLabel lblFName = new JLabel("Father's Name :");
		lblFName.setForeground(Color.WHITE);
		lblFName.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblFName.setBounds(232, 216, 110, 21);
		contentPane.add(lblFName);

		lblFNameA = new JLabel("");
		lblFNameA.setForeground(Color.WHITE);
		lblFNameA.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblFNameA.setBounds(346, 212, 149, 28);
		contentPane.add(lblFNameA);

		lblNameA = new JLabel("");
		lblNameA.setForeground(Color.WHITE);
		lblNameA.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNameA.setBounds(287, 166, 149, 28);
		contentPane.add(lblNameA);

		lblAmountA = new JLabel("");
		lblAmountA.setForeground(Color.WHITE);
		lblAmountA.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblAmountA.setBounds(339, 442, 110, 28);
		contentPane.add(lblAmountA);

		dateChooser = new JDateChooser();
		dateChooser.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		dateChooser.setBounds(232, 401, 204, 28);
		contentPane.add(dateChooser);

		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblDate.setBounds(232, 380, 40, 21);
		contentPane.add(lblDate);

		getRollNo();
		getDept();
		getSemester();
		setDataIntoLabel();
		setAmountAccordingToDept();

	}

	private void getDept() {
		List<String> dept = new ArrayList<>();
		// Getting Department from DB and insert into JComboBox
		try {
			String query1 = "select department from department";
			ResultSet rs = con.statement.executeQuery(query1);
			while (rs.next()) {
				dept.add(rs.getString("department"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String arr[] = new String[dept.size()];
		int i = 0;
		for (String type : dept) {
			arr[i] = type;
			i++;
		}

		comboDept.setModel(new DefaultComboBoxModel(arr));

	}

	private void getSemester() {
		List<String> sems = new ArrayList<>();
		// Getting Semester from DB and insert into JComboBox
		try {
			String query1 = "select semester_no from semester";
			ResultSet rs = con.statement.executeQuery(query1);
			while (rs.next()) {
				sems.add(rs.getString("semester_no"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String arr[] = new String[sems.size()];
		int i = 0;
		for (String type : sems) {
			arr[i] = type;
			i++;
		}

		comboSems.setModel(new DefaultComboBoxModel(arr));

	}
	
	private void getRollNo() {
		List<String> rollNo = new ArrayList<>();
		// Getting RollNo from DB and insert into JComboBox
		try {
			String query1 = "select Roll_No from student";
			ResultSet rs = con.statement.executeQuery(query1);
			while (rs.next()) {
				rollNo.add(rs.getString("Roll_No"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String arr[] = new String[rollNo.size()];
		int i = 0;
		for (String type : rollNo) {
			arr[i] = type;
			i++;
		}

		comboRollNo.setModel(new DefaultComboBoxModel(arr));

	}

	private void insertData() {
		String amount = lblAmountA.getText();
		String dept = (String) comboDept.getSelectedItem();
		String sems = (String) comboSems.getSelectedItem();
		String rollNo = (String) comboRollNo.getSelectedItem();
		String date = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();

		try {
			String query = "insert into Fees(amount,fee_date,roll_no,Semester,department) values ('" + amount + "','" + date
					+ "','" + rollNo + "','"+sems+"','"+dept+"')";
			con.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Fee Successfully Paid!");
			setVisible(false);
			Receipts_Screen fs = new Receipts_Screen();
			fs.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	private void setDataIntoLabel() {
		try {
			String query = "select student,Father_Name from student where roll_no = '"+comboRollNo.getSelectedItem()+"'" ;
					
			ResultSet rs = con.statement.executeQuery(query);
			while (rs.next()) {
				lblNameA.setText(rs.getString("student"));
				lblFNameA.setText(rs.getString("Father_Name"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private void setAmountAccordingToDept() {
		try {
			
			String query = "select amount_per_sems from fee_structure where department = '"+comboDept.getSelectedItem()+"'";
			ResultSet rs = con.statement.executeQuery(query);
			while (rs.next()) {
				lblAmountA.setText(rs.getString("amount_per_sems"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
