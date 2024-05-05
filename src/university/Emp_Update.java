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
import java.beans.DesignMode;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.Choice;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Emp_Update extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtFName;
	private JTextField txtPhone;
	private JTextField txtDesignation;
	private JTextField txtCnic;
	private JComboBox comboGender;
	private JTextField txtCity;
	private JLabel lblIdAns;
	private JComboBox comboEmpTypes;
	String empID;
	DBConnection con = new DBConnection();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Emp_Update frame = new Emp_Update("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Emp_Update(String empID) {
		this.empID = empID;
		setTitle("Update Employe");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Emp_Update.class.getResource("/Images/uniLogo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, -13, 706, 531);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblHeading = new JLabel("UPDATE EMPLOYE DETAILS");
		lblHeading.setForeground(new Color(255, 255, 255));
		lblHeading.setFont(new Font("Verdana", Font.BOLD, 19));
		lblHeading.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(105, 105, 105), new Color(105, 105, 105),
				new Color(255, 255, 255), new Color(255, 255, 255)));
		lblHeading.setBounds(194, 40, 302, 36);
		contentPane.add(lblHeading);

		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblName.setBounds(54, 140, 45, 21);
		contentPane.add(lblName);

		txtName = new JTextField();
		txtName.setForeground(new Color(0, 0, 0));
		txtName.setFont(new Font("SansSerif", Font.BOLD, 14));
		txtName.setColumns(10);
		txtName.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		txtName.setBackground(new Color(255, 255, 255));
		txtName.setBounds(54, 162, 264, 28);
		contentPane.add(txtName);

		JLabel lblDesignation = new JLabel("Deisgnation");
		lblDesignation.setForeground(Color.WHITE);
		lblDesignation.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDesignation.setBounds(54, 206, 90, 21);
		contentPane.add(lblDesignation);

		JLabel lblType = new JLabel("Type");
		lblType.setForeground(Color.WHITE);
		lblType.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblType.setBounds(372, 273, 33, 21);
		contentPane.add(lblType);

		JLabel lblFName = new JLabel("Father's Name");
		lblFName.setForeground(Color.WHITE);
		lblFName.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblFName.setBounds(372, 140, 100, 21);
		contentPane.add(lblFName);

		txtFName = new JTextField();
		txtFName.setForeground(new Color(0, 0, 0));
		txtFName.setFont(new Font("SansSerif", Font.BOLD, 14));
		txtFName.setColumns(10);
		txtFName.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		txtFName.setBackground(new Color(255, 255, 255));
		txtFName.setBounds(372, 162, 264, 28);
		contentPane.add(txtFName);

		JLabel lblPhoneNo = new JLabel("Phone No.");
		lblPhoneNo.setForeground(Color.WHITE);
		lblPhoneNo.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblPhoneNo.setBounds(54, 273, 83, 21);
		contentPane.add(lblPhoneNo);

		txtPhone = new JTextField();
		txtPhone.setForeground(new Color(0, 0, 0));
		txtPhone.setFont(new Font("SansSerif", Font.BOLD, 14));
		txtPhone.setColumns(10);
		txtPhone.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		txtPhone.setBackground(new Color(255, 255, 255));
		txtPhone.setBounds(54, 295, 264, 28);
		contentPane.add(txtPhone);

		JLabel lblCnicNo = new JLabel("CNIC No.");
		lblCnicNo.setForeground(Color.WHITE);
		lblCnicNo.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCnicNo.setBounds(372, 206, 71, 21);
		contentPane.add(lblCnicNo);

		lblIdAns = new JLabel("");
		lblIdAns.setForeground(Color.WHITE);
		lblIdAns.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblIdAns.setBounds(92, 92, 77, 21);
		contentPane.add(lblIdAns);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateText();
			}
		});
		btnUpdate.setForeground(new Color(245, 255, 250));
		btnUpdate.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		btnUpdate.setBorder(
				new BevelBorder(BevelBorder.LOWERED, new Color(245, 255, 250), new Color(245, 255, 250), null, null));
		btnUpdate.setBackground(Color.BLACK);
		btnUpdate.setBounds(291, 431, 107, 28);
		contentPane.add(btnUpdate);

		txtDesignation = new JTextField();
		txtDesignation.setForeground(Color.BLACK);
		txtDesignation.setFont(new Font("SansSerif", Font.BOLD, 14));
		txtDesignation.setColumns(10);
		txtDesignation
				.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		txtDesignation.setBackground(Color.WHITE);
		txtDesignation.setBounds(54, 227, 264, 28);
		contentPane.add(txtDesignation);

		txtCnic = new JTextField();
		txtCnic.setForeground(Color.BLACK);
		txtCnic.setFont(new Font("SansSerif", Font.BOLD, 14));
		txtCnic.setColumns(10);
		txtCnic.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		txtCnic.setBackground(Color.WHITE);
		txtCnic.setBounds(372, 227, 264, 28);
		contentPane.add(txtCnic);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblGender.setBounds(372, 334, 83, 21);
		contentPane.add(lblGender);

		JLabel lblId = new JLabel("ID :");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblId.setBounds(54, 92, 30, 21);
		contentPane.add(lblId);

	

		comboGender = new JComboBox();
		comboGender.setModel(new DefaultComboBoxModel(new String[] { "None", "Male", "Female" }));
		comboGender.setForeground(Color.BLACK);
		comboGender.setFont(new Font("SansSerif", Font.BOLD, 14));
		comboGender.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		comboGender.setBackground(SystemColor.inactiveCaptionBorder);
		comboGender.setBounds(372, 357, 139, 28);
		contentPane.add(comboGender);

		txtCity = new JTextField();
		txtCity.setForeground(Color.BLACK);
		txtCity.setFont(new Font("SansSerif", Font.BOLD, 14));
		txtCity.setColumns(10);
		txtCity.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		txtCity.setBackground(Color.WHITE);
		txtCity.setBounds(54, 358, 264, 28);
		contentPane.add(txtCity);

		JLabel lblCity = new JLabel("City");
		lblCity.setForeground(Color.WHITE);
		lblCity.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCity.setBounds(54, 339, 90, 21);
		contentPane.add(lblCity);

		comboEmpTypes = new JComboBox();
		comboEmpTypes.setForeground(Color.BLACK);
		comboEmpTypes.setFont(new Font("SansSerif", Font.BOLD, 14));
		comboEmpTypes
				.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		comboEmpTypes.setBackground(new Color(245, 255, 250));
		comboEmpTypes.setBounds(372, 295, 264, 28);
		contentPane.add(comboEmpTypes);

		JButton backBtn = new JButton("");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		backBtn.setIcon(new ImageIcon(Emp_Update.class.getResource("/Images/backSmall.png")));
		backBtn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		backBtn.setBorder(null);
		backBtn.setBackground(new Color(105, 105, 105));
		backBtn.setBounds(10, 11, 28, 28);
		contentPane.add(backBtn);

		JLabel lblBack = new JLabel("Back");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				back();
			}
		});
		lblBack.setForeground(Color.WHITE);
		lblBack.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblBack.setBounds(41, 16, 40, 18);
		contentPane.add(lblBack);

		getEmpType();
		setText();

	}

	private void setText() {
		try {

			String query = "select EMP_ID , Employee,Designation,Gender , Father_Name , CNIC , Phone,city from employee where emp_ID  = '"
					+ empID + "'";
			ResultSet rs = con.statement.executeQuery(query);
			while (rs.next()) {
				lblIdAns.setText(rs.getString("Emp_ID"));
				txtName.setText(rs.getString("Employee"));
				txtDesignation.setText(rs.getString("Designation"));
				comboGender.setName(rs.getString("Gender"));
				txtFName.setText(rs.getString("Father_Name"));
				txtCnic.setText(rs.getString("Cnic"));
				txtPhone.setText(rs.getString("Phone"));
				txtCity.setText(rs.getString("city"));

			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	private void updateText() {
		try {
			String name = txtName.getText();
			String fName = txtFName.getText();
			String cnic = txtCnic.getText();
			String phone = txtPhone.getText();
			String designation = txtDesignation.getText();
			String gender = (String) comboGender.getSelectedItem();
			String type = (String) comboEmpTypes.getSelectedItem();
			String city = txtCity.getText();
			String query = "update Employee  set employee = '" + name + "', designation ='" + designation
					+ "', gender = '" + gender + "', father_name ='" + fName + "', cnic ='" + cnic + "', phone = '"
					+ phone + "', city = '" + city + "' where emp_id = '"+empID+"'";
			con.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Employe Details Successfully Updated!");

			setVisible(false);
			new Emp_Screen().setVisible(true);
		}

		catch (Exception e1) {
			e1.printStackTrace();

		}
	}

	private void getEmpType() {
		List<String> empType = new ArrayList<>();
		//  Getting type from DB and insert into JComboBox
		try {
			String query1 = "select emp_type from employee_type";
			ResultSet rs = con.statement.executeQuery(query1);
			while (rs.next()) {
				empType.add(rs.getString("emp_type"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String arr[] = new String[empType.size()];
		int i = 0;
		for (String type : empType) {
			arr[i] = type;
			i++;
		}
		comboEmpTypes.setModel(new DefaultComboBoxModel(arr));

	}

	private void back() {
		setVisible(false);
		Emp_Screen es = new Emp_Screen();
		es.setVisible(true);
	}
}
