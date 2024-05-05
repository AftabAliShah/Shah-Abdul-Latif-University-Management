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

public class Course_Update extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JComboBox comboDept;
	private JComboBox comboTypes;
	private JComboBox comboSemester;
	private JComboBox comboDuration;
	private JLabel lblIdAns;
	DBConnection con = new DBConnection();
	String id;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Course_Update frame = new Course_Update("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Course_Update(String id) {
		this.id = id;
		setTitle("Update Course");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Course_Update.class.getResource("/Images/uniLogo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, -13, 457, 581);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblHeading = new JLabel("UPDATE COURSE");
		lblHeading.setForeground(new Color(255, 255, 255));
		lblHeading.setFont(new Font("Verdana", Font.BOLD, 19));
		lblHeading.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(105, 105, 105), new Color(105, 105, 105),
				new Color(255, 255, 255), new Color(255, 255, 255)));
		lblHeading.setBounds(125, 40, 191, 36);
		contentPane.add(lblHeading);

		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblName.setBounds(88, 125, 47, 21);
		contentPane.add(lblName);

		txtName = new JTextField();
		txtName.setForeground(new Color(0, 0, 0));
		txtName.setFont(new Font("SansSerif", Font.BOLD, 14));
		txtName.setColumns(10);
		txtName.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		txtName.setBackground(new Color(255, 255, 255));
		txtName.setBounds(88, 145, 264, 28);
		contentPane.add(txtName);

		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setForeground(Color.WHITE);
		lblDuration.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDuration.setBounds(88, 189, 69, 21);
		contentPane.add(lblDuration);

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
		btnUpdate.setBounds(167, 471, 107, 28);
		contentPane.add(btnUpdate);

		JLabel lblDept = new JLabel("Department");
		lblDept.setForeground(Color.WHITE);
		lblDept.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDept.setBounds(88, 310, 82, 21);
		contentPane.add(lblDept);

		comboDept = new JComboBox();
		comboDept.setForeground(Color.BLACK);
		comboDept.setFont(new Font("SansSerif", Font.BOLD, 14));
		comboDept.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		comboDept.setBackground(SystemColor.inactiveCaptionBorder);

		comboDept.setBounds(88, 333, 264, 28);
		contentPane.add(comboDept);

		JLabel lblType = new JLabel("Type");
		lblType.setForeground(Color.WHITE);
		lblType.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblType.setBounds(88, 249, 33, 21);
		contentPane.add(lblType);

		JButton backBtn = new JButton("");
		backBtn.setIcon(new ImageIcon(Course_Update.class.getResource("/Images/backSmall.png")));
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
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
				back();
			}
		});
		lblBack.setForeground(Color.WHITE);
		lblBack.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblBack.setBounds(41, 16, 40, 18);
		contentPane.add(lblBack);

		comboTypes = new JComboBox();
		comboTypes.setForeground(new Color(0, 0, 0));
		comboTypes.setFont(new Font("SansSerif", Font.BOLD, 14));
		comboTypes.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		comboTypes.setBackground(SystemColor.inactiveCaptionBorder);
		comboTypes.setBounds(88, 271, 264, 28);
		contentPane.add(comboTypes);

		comboSemester = new JComboBox();
		comboSemester.setForeground(Color.BLACK);
		comboSemester.setFont(new Font("SansSerif", Font.BOLD, 14));
		comboSemester
				.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		comboSemester.setBackground(new Color(245, 255, 250));
		comboSemester.setBounds(88, 393, 264, 28);
		contentPane.add(comboSemester);

		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setForeground(Color.WHITE);
		lblSemester.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblSemester.setBounds(88, 371, 69, 21);
		contentPane.add(lblSemester);

		comboDuration = new JComboBox();
		comboDuration.setModel(new DefaultComboBoxModel(new String[] { "None", "1 Month", "1.5 Months", "2 Months",
				"2.5 Months", "3 Months", "3.5 Months", "4 Months" }));
		comboDuration.setForeground(Color.BLACK);
		comboDuration.setFont(new Font("SansSerif", Font.BOLD, 14));
		comboDuration
				.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		comboDuration.setBackground(SystemColor.inactiveCaptionBorder);
		comboDuration.setBounds(88, 210, 264, 28);
		contentPane.add(comboDuration);

		JLabel lblId = new JLabel("ID :");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblId.setBounds(42, 87, 30, 21);
		contentPane.add(lblId);

		lblIdAns = new JLabel("");
		lblIdAns.setForeground(Color.WHITE);
		lblIdAns.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblIdAns.setBounds(80, 87, 77, 21);
		contentPane.add(lblIdAns);

		setText();
		getTypes();
		getDept();
		getSemester();
	}

	private void setText() {
		try {

			String query = "select course_id ,course_name from courses where course_id   = '" + id + "'";
			ResultSet rs = con.statement.executeQuery(query);
			while (rs.next()) {
				lblIdAns.setText(rs.getString("course_id"));
				txtName.setText(rs.getString("course_name"));
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	private void updateText() {
		try {
			String name = txtName.getText();
			String duration = (String) comboDuration.getSelectedItem();
			String dept = (String) comboDept.getSelectedItem();
			String type = (String) comboTypes.getSelectedItem();
			String semester = (String) comboSemester.getSelectedItem();

			String query = "update Courses set  Course_name = '" + name + "', course_duration = '" + duration
					+ "', semester = '" + semester + "', department = '" + dept + "', course_type = '" + type + "' where course_id = '"+id+"'";
			con.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Details Successfully Updated!");

			setVisible(false);
			new Courses_Screen().setVisible(true);
		}

		catch (Exception e1) {
			e1.printStackTrace();

		}
	}

	public void getTypes() {
		List<String> types = new ArrayList<>();
		try {
			String query1 = "select course_type from course_type;";
			ResultSet rs = con.statement.executeQuery(query1);
			while (rs.next()) {
				types.add(rs.getString("course_type"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String arr[] = new String[types.size()];
		int i = 0;
		for (String type : types) {
			arr[i] = type;
			i++;
		}
		comboTypes.setModel(new DefaultComboBoxModel(arr));

	}

	public void getDept() {
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

	public void getSemester() {

		List<String> semesters = new ArrayList<>();
		// Getting Semester from DB and insert into JComboBox
		try {
			String query1 = "select semester_no from semester";
			ResultSet rs = con.statement.executeQuery(query1);
			while (rs.next()) {
				semesters.add(rs.getString("semester_no"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String arr[] = new String[semesters.size()];
		int i = 0;
		for (String type : semesters) {
			arr[i] = type;
			i++;
		}

		comboSemester.setModel(new DefaultComboBoxModel(arr));

	}

	private void back() {
		setVisible(false);
		Courses_Screen cs = new Courses_Screen();
		cs.setVisible(true);
	}
}