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

public class Stu_Leave_Update extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox comboRollNo;
	private JComboBox comboDuration;
	private JDateChooser dateChooser;
	private JLabel lblNameA;
	private JLabel lblIDA;
	String id;
	DBConnection con = new DBConnection();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stu_Leave_Update frame = new Stu_Leave_Update("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Stu_Leave_Update(String id) {
		this.id = id;
		setTitle("Update Leave Details");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Stu_Leave_Update.class.getResource("/Images/uniLogo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, -13, 457, 508);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblHeading = new JLabel("UPDATE LEAVE");
		lblHeading.setForeground(new Color(255, 255, 255));
		lblHeading.setFont(new Font("Verdana", Font.BOLD, 19));
		lblHeading.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(105, 105, 105), new Color(105, 105, 105),
				new Color(255, 255, 255), new Color(255, 255, 255)));
		lblHeading.setBounds(135, 40, 171, 36);
		contentPane.add(lblHeading);

		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setForeground(Color.WHITE);
		lblDuration.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDuration.setBounds(88, 311, 69, 21);
		contentPane.add(lblDuration);

		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					updateLeave();
			}
		});
		btnUpdate.setForeground(new Color(245, 255, 250));
		btnUpdate.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		btnUpdate.setBorder(
				new BevelBorder(BevelBorder.LOWERED, new Color(245, 255, 250), new Color(245, 255, 250), null, null));
		btnUpdate.setBackground(Color.BLACK);
		btnUpdate.setBounds(158, 399, 107, 28);
		contentPane.add(btnUpdate);

		JButton backBtn = new JButton("");
		backBtn.setIcon(new ImageIcon(Stu_Leave_Update.class.getResource("/Images/backSmall.png")));
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

		comboRollNo = new JComboBox();
		comboRollNo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				setStudentName();
			}
		});
		comboRollNo.setForeground(Color.BLACK);
		comboRollNo.setFont(new Font("SansSerif", Font.BOLD, 14));
		comboRollNo.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		comboRollNo.setBackground(new Color(245, 255, 250));
		comboRollNo.setBounds(88, 149, 264, 28);
		contentPane.add(comboRollNo);

		JLabel lblRollNo = new JLabel("Roll No");
		lblRollNo.setForeground(Color.WHITE);
		lblRollNo.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblRollNo.setBounds(88, 127, 50, 21);
		contentPane.add(lblRollNo);

		comboDuration = new JComboBox();
		comboDuration.setModel(new DefaultComboBoxModel(
				new String[] { "1 Day", "2 Days", "3 Days", "4 Days", "For A Week", "For A Month" }));
		comboDuration.setForeground(Color.BLACK);
		comboDuration.setFont(new Font("SansSerif", Font.BOLD, 14));
		comboDuration
				.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		comboDuration.setBackground(SystemColor.inactiveCaptionBorder);
		comboDuration.setBounds(88, 332, 264, 28);
		contentPane.add(comboDuration);

		dateChooser = new JDateChooser();
		dateChooser.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		dateChooser.setBounds(88, 262, 264, 28);
		contentPane.add(dateChooser);

		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDate.setBounds(88, 240, 40, 21);
		contentPane.add(lblDate);

		JLabel lblName = new JLabel("Name :");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblName.setBounds(88, 197, 50, 21);
		contentPane.add(lblName);

		lblNameA = new JLabel("");
		lblNameA.setForeground(Color.WHITE);
		lblNameA.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNameA.setBounds(142, 193, 194, 28);
		contentPane.add(lblNameA);
		
		JLabel lblID = new JLabel("ID :");
		lblID.setForeground(Color.WHITE);
		lblID.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblID.setBounds(41, 91, 22, 21);
		contentPane.add(lblID);
		
		lblIDA = new JLabel("");
		lblIDA.setForeground(Color.WHITE);
		lblIDA.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblIDA.setBounds(73, 87, 56, 29);
		contentPane.add(lblIDA);

		setStudentName();
		setDate();
		getRollNo();

	}

	public void getRollNo() {

		List<String> rollNo = new ArrayList<>();
		// Getting roll no from DB and insert into JComboBox
		try {
			String query1 = "select roll_no from student";
			ResultSet rs = con.statement.executeQuery(query1);
			while (rs.next()) {
				rollNo.add(rs.getString("roll_no"));
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

	private void updateLeave() {
		String duration = (String) comboDuration.getSelectedItem();
		String rollNo = (String) comboRollNo.getSelectedItem();
		String date = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
		try {
			String query = "update student_leave set date = '" + date + "', duration = '" + duration + "',roll_no = '"
					+ rollNo + "' where l_id = '" + id + "'";
			con.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Leave Details Updated Successfully!");
		} catch (Exception e1) {
			e1.printStackTrace();

		}
		setVisible(false);
		new Stu_Leave_Screen().setVisible(true);
	}

	private void setDate() {
		try {
			String query = "select l_id,date from student_leave where l_id = '" + id + "'";
			ResultSet rs = con.statement.executeQuery(query);
			while (rs.next()) {
				lblIDA.setText(rs.getString("l_id"));
				((JTextField) dateChooser.getDateEditor().getUiComponent()).setText(rs.getString("date"));
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	private void setStudentName() {
		try {
			String query = "select student from student where roll_no = '" + comboRollNo.getSelectedItem() + "'";
			ResultSet rs = con.statement.executeQuery(query);
			while (rs.next()) {
				lblNameA.setText(rs.getString("student"));

			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	private void back() {
		setVisible(false);
		Stu_Leave_Screen sls = new Stu_Leave_Screen();
		sls.setVisible(true);
	}
}
