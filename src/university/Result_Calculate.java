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
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Result_Calculate extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox comboC3;
	private JComboBox comboC2;
	private JComboBox comboC4;
	private JComboBox comboC1;
	DBConnection con = new DBConnection();
	private JTextField txtC1;
	private JTextField txtC2;
	private JTextField txtC3;
	private JTextField txtC4;
	private JComboBox comboRollNo;
	private JLabel lblNameAns;
	private JLabel lblMarksA;
	private JLabel lblCgpaA;
	private JLabel lblAverageA;
	private JLabel lblGradeA;
	private JButton btnSubmit;
	private JButton btnCalculate;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Result_Calculate frame = new Result_Calculate();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Result_Calculate() {
		setTitle("Calculate Result");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Result_Calculate.class.getResource("/Images/uniLogo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, -13, 733, 581);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblHeading = new JLabel("CALCULATE THE RESULT");
		lblHeading.setForeground(new Color(255, 255, 255));
		lblHeading.setFont(new Font("Verdana", Font.BOLD, 19));
		lblHeading.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(105, 105, 105), new Color(105, 105, 105),
				new Color(255, 255, 255), new Color(255, 255, 255)));
		lblHeading.setBounds(223, 40, 271, 36);
		contentPane.add(lblHeading);

		JLabel lblRollNo = new JLabel("Roll_No");
		lblRollNo.setForeground(Color.WHITE);
		lblRollNo.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblRollNo.setBounds(63, 124, 54, 21);
		contentPane.add(lblRollNo);

		JLabel lblC1 = new JLabel("Course 1");
		lblC1.setForeground(Color.WHITE);
		lblC1.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblC1.setBounds(63, 239, 69, 21);
		contentPane.add(lblC1);

		btnCalculate = new JButton("CALCULATE");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculation();

			}
		});
		btnCalculate.setForeground(new Color(245, 255, 250));
		btnCalculate.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		btnCalculate.setBorder(
				new BevelBorder(BevelBorder.LOWERED, new Color(245, 255, 250), new Color(245, 255, 250), null, null));
		btnCalculate.setBackground(Color.BLACK);
		btnCalculate.setBounds(434, 464, 117, 28);
		contentPane.add(btnCalculate);

		JLabel lblC3 = new JLabel("Course 3");
		lblC3.setForeground(Color.WHITE);
		lblC3.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblC3.setBounds(63, 360, 69, 21);
		contentPane.add(lblC3);

		comboC3 = new JComboBox();
		comboC3.setForeground(Color.BLACK);
		comboC3.setFont(new Font("SansSerif", Font.BOLD, 14));
		comboC3.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		comboC3.setBackground(SystemColor.inactiveCaptionBorder);

		comboC3.setBounds(63, 383, 264, 28);
		contentPane.add(comboC3);

		JLabel lblC2 = new JLabel("Course 2");
		lblC2.setForeground(Color.WHITE);
		lblC2.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblC2.setBounds(63, 299, 69, 21);
		contentPane.add(lblC2);

		JButton backBtn = new JButton("");
		backBtn.setIcon(new ImageIcon(Result_Calculate.class.getResource("/Images/backSmall.png")));
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Results_Screen cs = new Results_Screen();
				cs.setVisible(true);
			}
		});
		backBtn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		backBtn.setBorder(null);
		backBtn.setBackground(new Color(105, 105, 105));
		backBtn.setBounds(10, 11, 28, 28);
		contentPane.add(backBtn);

		JLabel lblBack = new JLabel("Back");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				Results_Screen cs = new Results_Screen();
				cs.setVisible(true);
			}
		});
		lblBack.setForeground(Color.WHITE);
		lblBack.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblBack.setBounds(41, 16, 40, 18);
		contentPane.add(lblBack);

		comboC2 = new JComboBox();
		comboC2.setForeground(new Color(0, 0, 0));
		comboC2.setFont(new Font("SansSerif", Font.BOLD, 14));
		comboC2.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		comboC2.setBackground(SystemColor.inactiveCaptionBorder);
		comboC2.setBounds(63, 321, 264, 28);
		contentPane.add(comboC2);

		comboC4 = new JComboBox();
		comboC4.setForeground(Color.BLACK);
		comboC4.setFont(new Font("SansSerif", Font.BOLD, 14));
		comboC4.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		comboC4.setBackground(new Color(245, 255, 250));
		comboC4.setBounds(374, 145, 264, 28);
		contentPane.add(comboC4);

		JLabel lblC4 = new JLabel("Course 4 ");
		lblC4.setForeground(Color.WHITE);
		lblC4.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblC4.setBounds(374, 124, 69, 21);
		contentPane.add(lblC4);

		comboC1 = new JComboBox();
		comboC1.setForeground(Color.BLACK);
		comboC1.setFont(new Font("SansSerif", Font.BOLD, 14));
		comboC1.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		comboC1.setBackground(SystemColor.inactiveCaptionBorder);
		comboC1.setBounds(63, 260, 264, 28);
		contentPane.add(comboC1);

		comboRollNo = new JComboBox();
		comboRollNo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				setStudentName();
			}
		});
		comboRollNo.setForeground(Color.BLACK);
		comboRollNo.setFont(new Font("SansSerif", Font.BOLD, 14));
		comboRollNo.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		comboRollNo.setBackground(SystemColor.inactiveCaptionBorder);
		comboRollNo.setBounds(63, 145, 264, 28);
		contentPane.add(comboRollNo);

		JLabel lblName = new JLabel("Name :");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblName.setBounds(63, 199, 54, 21);
		contentPane.add(lblName);

		lblNameAns = new JLabel("");
		lblNameAns.setForeground(Color.WHITE);
		lblNameAns.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNameAns.setBounds(127, 191, 200, 36);
		contentPane.add(lblNameAns);

		txtC1 = new JTextField();
		txtC1.setForeground(Color.BLACK);
		txtC1.setFont(new Font("SansSerif", Font.BOLD, 14));
		txtC1.setColumns(10);
		txtC1.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		txtC1.setBackground(new Color(245, 255, 250));
		txtC1.setBounds(337, 260, 43, 28);
		contentPane.add(txtC1);

		txtC2 = new JTextField();
		txtC2.setForeground(Color.BLACK);
		txtC2.setFont(new Font("SansSerif", Font.BOLD, 14));
		txtC2.setColumns(10);
		txtC2.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		txtC2.setBackground(new Color(245, 255, 250));
		txtC2.setBounds(337, 321, 43, 28);
		contentPane.add(txtC2);

		txtC3 = new JTextField();
		txtC3.setForeground(Color.BLACK);
		txtC3.setFont(new Font("SansSerif", Font.BOLD, 14));
		txtC3.setColumns(10);
		txtC3.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		txtC3.setBackground(new Color(245, 255, 250));
		txtC3.setBounds(337, 383, 43, 28);
		contentPane.add(txtC3);

		txtC4 = new JTextField();
		txtC4.setForeground(Color.BLACK);
		txtC4.setFont(new Font("SansSerif", Font.BOLD, 14));
		txtC4.setColumns(10);
		txtC4.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		txtC4.setBackground(new Color(245, 255, 250));
		txtC4.setBounds(648, 145, 43, 28);
		contentPane.add(txtC4);

		JLabel lblMarks = new JLabel("Remarks :");
		lblMarks.setForeground(Color.WHITE);
		lblMarks.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblMarks.setBounds(471, 246, 69, 21);
		contentPane.add(lblMarks);

		JLabel lblCgpa = new JLabel("CGPA : ");
		lblCgpa.setForeground(Color.WHITE);
		lblCgpa.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCgpa.setBounds(471, 281, 54, 21);
		contentPane.add(lblCgpa);

		JLabel lblAverage = new JLabel("Average :");
		lblAverage.setForeground(Color.WHITE);
		lblAverage.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblAverage.setBounds(471, 320, 69, 21);
		contentPane.add(lblAverage);

		JLabel lblGrade = new JLabel("Grade :");
		lblGrade.setForeground(Color.WHITE);
		lblGrade.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblGrade.setBounds(471, 357, 54, 21);
		contentPane.add(lblGrade);

		lblMarksA = new JLabel("");
		lblMarksA.setForeground(new Color(0, 255, 0));
		lblMarksA.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		lblMarksA.setBounds(550, 242, 69, 28);
		contentPane.add(lblMarksA);

		lblCgpaA = new JLabel("");
		lblCgpaA.setForeground(Color.GREEN);
		lblCgpaA.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		lblCgpaA.setBounds(527, 277, 69, 28);
		contentPane.add(lblCgpaA);

		lblAverageA = new JLabel("");
		lblAverageA.setForeground(Color.GREEN);
		lblAverageA.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		lblAverageA.setBounds(550, 316, 69, 28);
		contentPane.add(lblAverageA);

		lblGradeA = new JLabel("");
		lblGradeA.setForeground(Color.GREEN);
		lblGradeA.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		lblGradeA.setBounds(527, 353, 69, 28);
		contentPane.add(lblGradeA);

		btnSubmit = new JButton("SUBMIT");
		btnSubmit.setEnabled(false);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertData();
			}
		});
		btnSubmit.setForeground(new Color(245, 255, 250));
		btnSubmit.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		btnSubmit.setBorder(
				new BevelBorder(BevelBorder.LOWERED, new Color(245, 255, 250), new Color(245, 255, 250), null, null));
		btnSubmit.setBackground(Color.BLACK);
		btnSubmit.setBounds(166, 464, 102, 28);
		contentPane.add(btnSubmit);

		setStudentName();
		getCourses();
		getRollNo();

	}

	public void getRollNo() {
		List<String> rollNo = new ArrayList<>();
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

	public void getCourses() {
		List<String> dept = new ArrayList<>();
		// Getting Courses from DB and insert into JComboBox
		try {
			String query1 = "select course_name from courses";
			ResultSet rs = con.statement.executeQuery(query1);
			while (rs.next()) {
				dept.add(rs.getString("course_name"));
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
		comboC1.setModel(new DefaultComboBoxModel(arr));
		comboC2.setModel(new DefaultComboBoxModel(arr));
		comboC3.setModel(new DefaultComboBoxModel(arr));
		comboC4.setModel(new DefaultComboBoxModel(arr));

	}

	private void calculation() {

		double co1, co2, co3, co4, marks, avg, gpa;
		String grade;

		co1 = Integer.parseInt(txtC1.getText());
		co2 = Integer.parseInt(txtC2.getText());
		co3 = Integer.parseInt(txtC3.getText());
		co4 = Integer.parseInt(txtC4.getText());

		marks = co1 + co2 + co3 + co4;
		avg = marks / 4;

		if (avg >= 85 && avg <= 100) {
			grade = "A1";
			gpa = 4.0;

		} else if (avg >= 75 && avg < 85) {
			grade = "A";
			gpa = 3.5;

		} else if (avg >= 65 && avg < 75) {
			grade = "B";
			gpa = 3.0;

		} else if (avg >= 50 && avg < 65) {
			grade = "C";
			gpa = 2.5;

		} else if (avg >= 45 && avg < 65) {
			grade = "D";
			gpa = 2.0;

		} else if (avg < 45 && avg > 0) {
			grade = "F";
			gpa = 1.5;
		} else {
			grade = "Invalid Entry";
			gpa = 0;
		}

		lblMarksA.setText(String.valueOf(marks));
		lblCgpaA.setText(String.valueOf(gpa));
		lblAverageA.setText(String.valueOf(avg));
		lblGradeA.setText(grade);
		btnSubmit.setEnabled(true);

	}

	

	private void insertData() {

		try {

			String rollNo = (String) comboRollNo.getSelectedItem();
			String c1 = (String) comboC1.getSelectedItem();
			String c2 = (String) comboC3.getSelectedItem();
			String c3 = (String) comboC2.getSelectedItem();
			String c4 = (String) comboC4.getSelectedItem();
			String cgpa = lblCgpaA.getText();
			String grade = lblGradeA.getText();
			String avg = lblAverageA.getText();
			String marks = lblMarksA.getText();
			String txt1 = txtC1.getText();
			String txt2 = txtC2.getText();
			String txt3 = txtC3.getText();
			String txt4 = txtC4.getText();

			String query = "insert into results( course1,course2,course3,course4,Roll_No,cgpa,grade,average,remarks,course1_marks,Course2_Marks,Course3_Marks,Course4_Marks) "
					+ "values ('" + c1 + "','" + c2 + "','" + c3 + "','" + c4 + "','" + rollNo + "','" + cgpa + "','"
					+ grade + "','" + avg + "','" + marks + "','" + txt1 + "','" + txt2 + "','" + txt3 + "','" + txt4
					+ "')";
			con.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Details Successfully Added!");

			setVisible(false);
			new Results_Screen().setVisible(true);
		}

		catch (Exception e1) {
			e1.printStackTrace();

		}
		
	}
	
	private void setStudentName() {
		try {

			String query = "select student from student where roll_no  = '" + comboRollNo.getSelectedItem() + "'";
			ResultSet rs = con.statement.executeQuery(query);
			while (rs.next()) {
				lblNameAns.setText(rs.getString("student"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
