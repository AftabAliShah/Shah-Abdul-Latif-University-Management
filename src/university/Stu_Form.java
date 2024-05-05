package university;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.toedter.calendar.JDateChooser;

import employe.management.system.AddScreen;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Stu_Form extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtFName;
	private JTextField txtPhone;
	private JTextField txtPercentage;
	private JTextField txtCnic;
	private JTextField txtBatch;
	private JComboBox comboGender;
	private JDateChooser dateChooser;
	private JComboBox comboDeptTypes;

	DBConnection con = new DBConnection();
	Admission_Screen as = new Admission_Screen();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stu_Form frame = new Stu_Form();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Stu_Form() {

		setTitle("Admission form");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Stu_Form.class.getResource("/Images/uniLogo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, -13, 765, 613);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblHeading = new JLabel("ADMISSION FORM");
		lblHeading.setForeground(new Color(255, 255, 255));
		lblHeading.setFont(new Font("Verdana", Font.BOLD, 19));
		lblHeading.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(105, 105, 105), new Color(105, 105, 105),
				new Color(255, 255, 255), new Color(255, 255, 255)));
		lblHeading.setBounds(270, 40, 208, 36);
		contentPane.add(lblHeading);

		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblName.setBounds(70, 144, 47, 21);
		contentPane.add(lblName);

		txtName = new JTextField();
		txtName.setForeground(new Color(0, 0, 0));
		txtName.setFont(new Font("SansSerif", Font.BOLD, 14));
		txtName.setColumns(10);
		txtName.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		txtName.setBackground(new Color(255, 255, 255));
		txtName.setBounds(70, 166, 264, 28);
		contentPane.add(txtName);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblAddress.setBounds(70, 210, 71, 21);
		contentPane.add(lblAddress);

		txtAddress = new JTextField();
		txtAddress.setForeground(new Color(0, 0, 0));
		txtAddress.setFont(new Font("SansSerif", Font.BOLD, 14));
		txtAddress.setColumns(10);
		txtAddress.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		txtAddress.setBackground(new Color(255, 255, 255));
		txtAddress.setBounds(70, 231, 264, 28);
		contentPane.add(txtAddress);

		JLabel lblPercentage = new JLabel("Class X(%)");
		lblPercentage.setForeground(Color.WHITE);
		lblPercentage.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblPercentage.setBounds(70, 277, 71, 21);
		contentPane.add(lblPercentage);

		comboDeptTypes = new JComboBox();
		comboDeptTypes.setForeground(Color.BLACK);
		comboDeptTypes.setFont(new Font("SansSerif", Font.BOLD, 14));
		comboDeptTypes
				.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		comboDeptTypes.setBackground(new Color(245, 255, 250));
		comboDeptTypes.setBounds(70, 365, 264, 28);
		contentPane.add(comboDeptTypes);

		JLabel lblDept = new JLabel("Department");
		lblDept.setForeground(Color.WHITE);
		lblDept.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDept.setBounds(70, 343, 83, 21);
		contentPane.add(lblDept);

		JLabel lblFName = new JLabel("Father's Name");
		lblFName.setForeground(Color.WHITE);
		lblFName.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblFName.setBounds(407, 144, 100, 21);
		contentPane.add(lblFName);

		txtFName = new JTextField();
		txtFName.setForeground(new Color(0, 0, 0));
		txtFName.setFont(new Font("SansSerif", Font.BOLD, 14));
		txtFName.setColumns(10);
		txtFName.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		txtFName.setBackground(new Color(255, 255, 255));
		txtFName.setBounds(407, 166, 264, 28);
		contentPane.add(txtFName);

		JLabel lblDOB = new JLabel("Date Of Birth");
		lblDOB.setForeground(Color.WHITE);
		lblDOB.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDOB.setBounds(407, 343, 100, 21);
		contentPane.add(lblDOB);

		JLabel lblPhoneNo = new JLabel("Phone No.");
		lblPhoneNo.setForeground(Color.WHITE);
		lblPhoneNo.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblPhoneNo.setBounds(407, 277, 83, 21);
		contentPane.add(lblPhoneNo);

		txtPhone = new JTextField();
		txtPhone.setForeground(new Color(0, 0, 0));
		txtPhone.setFont(new Font("SansSerif", Font.BOLD, 14));
		txtPhone.setColumns(10);
		txtPhone.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		txtPhone.setBackground(new Color(255, 255, 255));
		txtPhone.setBounds(407, 299, 264, 28);
		contentPane.add(txtPhone);

		JLabel lblCnicNo = new JLabel("CNIC No.");
		lblCnicNo.setForeground(Color.WHITE);
		lblCnicNo.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCnicNo.setBounds(407, 210, 71, 21);
		contentPane.add(lblCnicNo);

		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addStudentDetails();
			}
		});
		btnSubmit.setForeground(new Color(245, 255, 250));
		btnSubmit.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		btnSubmit.setBorder(
				new BevelBorder(BevelBorder.LOWERED, new Color(245, 255, 250), new Color(245, 255, 250), null, null));
		btnSubmit.setBackground(Color.BLACK);
		btnSubmit.setBounds(318, 491, 107, 28);
		contentPane.add(btnSubmit);

		txtPercentage = new JTextField();
		txtPercentage.setForeground(Color.BLACK);
		txtPercentage.setFont(new Font("SansSerif", Font.BOLD, 14));
		txtPercentage.setColumns(10);
		txtPercentage
				.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		txtPercentage.setBackground(Color.WHITE);
		txtPercentage.setBounds(70, 299, 264, 28);
		contentPane.add(txtPercentage);

		txtCnic = new JTextField();
		txtCnic.setForeground(Color.BLACK);
		txtCnic.setFont(new Font("SansSerif", Font.BOLD, 14));
		txtCnic.setColumns(10);
		txtCnic.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		txtCnic.setBackground(Color.WHITE);
		txtCnic.setBounds(407, 231, 264, 28);
		contentPane.add(txtCnic);

		JLabel lblBatch = new JLabel("Batch");
		lblBatch.setForeground(Color.WHITE);
		lblBatch.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblBatch.setBounds(70, 408, 83, 18);
		contentPane.add(lblBatch);

		txtBatch = new JTextField();
		txtBatch.setText("2k");
		txtBatch.setForeground(Color.BLACK);
		txtBatch.setFont(new Font("SansSerif", Font.BOLD, 14));
		txtBatch.setColumns(10);
		txtBatch.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		txtBatch.setBackground(Color.WHITE);
		txtBatch.setBounds(70, 427, 139, 28);
		contentPane.add(txtBatch);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblGender.setBounds(407, 408, 83, 18);
		contentPane.add(lblGender);

		comboGender = new JComboBox();
		comboGender.setModel(new DefaultComboBoxModel(new String[] { "None", "Male", "Female" }));
		comboGender.setForeground(Color.BLACK);
		comboGender.setFont(new Font("SansSerif", Font.BOLD, 14));
		comboGender.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		comboGender.setBackground(SystemColor.inactiveCaptionBorder);
		comboGender.setBounds(407, 427, 139, 28);
		contentPane.add(comboGender);

		JButton backBtn = new JButton("");
		backBtn.setForeground(new Color(105, 105, 105));
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backBtn();
			}
		});
		backBtn.setIcon(new ImageIcon(Stu_Form.class.getResource("/Images/backSmall.png")));
		backBtn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		backBtn.setBorder(null);
		backBtn.setBackground(new Color(105, 105, 105));
		backBtn.setBounds(10, 11, 27, 27);
		contentPane.add(backBtn);

		JLabel lblBack = new JLabel("Back");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				backBtn();
			}
		});
		lblBack.setForeground(Color.WHITE);
		lblBack.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblBack.setBounds(43, 15, 40, 18);
		contentPane.add(lblBack);

		dateChooser = new JDateChooser();
		dateChooser.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		dateChooser.setBounds(407, 365, 175, 28);
		contentPane.add(dateChooser);

		getDepartment();

	}

	private void getDepartment() {
		List<String> deptTypes = new ArrayList<>();
		// Getting Department from DB and insert into JComboBox
		try {
			con = new DBConnection();
			String query1 = "select department from department";
			ResultSet rs = con.statement.executeQuery(query1);
			while (rs.next()) {
				deptTypes.add(rs.getString("Department"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String arr[] = new String[deptTypes.size()];
		int i = 0;
		for (String type : deptTypes) {
			arr[i] = type;
			i++;
		}

		comboDeptTypes.setModel(new DefaultComboBoxModel(arr));

	}

	private void backBtn() {
		setVisible(false);
		as.setVisible(true);

	}

	private void addStudentDetails() {
		String name = txtName.getText();
		String fName = txtFName.getText();
		String address = txtAddress.getText();
		String cnic = txtCnic.getText();
		String phone = txtPhone.getText();
		String percent = txtPercentage.getText();
		String batch = txtBatch.getText();
		String gender = (String) comboGender.getSelectedItem();
		String dept = (String) comboDeptTypes.getSelectedItem();
		String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();

		try {

			String query = "insert into student (student,Father_Name,Address,DateOfBirth,HSC_Per,Phone_No,CNIC,Batch,gender,Department)"
					+ "values ('" + name + "','" + fName + "','" + address + "','" + dob + "','" + percent + "','"
					+ phone + "','" + cnic + "','" + batch + "','" + gender + "','" + dept + "')";
			con.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Student Successfully Enrolled!");

			setVisible(false);
			as.setVisible(true);
		}

		catch (Exception e) {
			e.printStackTrace();

		}
	}
}
