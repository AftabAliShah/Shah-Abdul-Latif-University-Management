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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.DesignMode;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Choice;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Result_Delete extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblGradeA;
	private JLabel lblAvgA;
	private JLabel lblCgpaA;
	private JLabel lblMarksA;
	private JComboBox comboID;
	private JLabel lblRollNoA;
	DBConnection con = new DBConnection();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Result_Delete frame = new Result_Delete();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Result_Delete() {
		setTitle("Delete Result");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Result_Delete.class.getResource("/Images/uniLogo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, -13, 469, 531);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblHeading = new JLabel("DELETE RESULT");
		lblHeading.setForeground(new Color(255, 255, 255));
		lblHeading.setFont(new Font("Verdana", Font.BOLD, 19));
		lblHeading.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(105, 105, 105), new Color(105, 105, 105),
				new Color(255, 255, 255), new Color(255, 255, 255)));
		lblHeading.setBounds(137, 44, 178, 36);
		contentPane.add(lblHeading);

		JLabel lblMarks = new JLabel("Marks");
		lblMarks.setForeground(Color.WHITE);
		lblMarks.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblMarks.setBounds(205, 147, 43, 21);
		contentPane.add(lblMarks);

		JLabel lblCgpa = new JLabel("CGPA");
		lblCgpa.setForeground(Color.WHITE);
		lblCgpa.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCgpa.setBounds(206, 276, 40, 21);
		contentPane.add(lblCgpa);

		JLabel lblAvg = new JLabel("Average");
		lblAvg.setForeground(Color.WHITE);
		lblAvg.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblAvg.setBounds(196, 218, 61, 21);
		contentPane.add(lblAvg);

		JLabel lblGrade = new JLabel("Grade");
		lblGrade.setForeground(Color.WHITE);
		lblGrade.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblGrade.setBounds(205, 335, 43, 21);
		contentPane.add(lblGrade);

		JButton btnDlt = new JButton("DELETE");
		btnDlt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteData();
			}
		});
		btnDlt.setForeground(new Color(245, 255, 250));
		btnDlt.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		btnDlt.setBorder(
				new BevelBorder(BevelBorder.LOWERED, new Color(245, 255, 250), new Color(245, 255, 250), null, null));
		btnDlt.setBackground(Color.BLACK);
		btnDlt.setBounds(173, 421, 107, 28);
		contentPane.add(btnDlt);

		JLabel lblId = new JLabel("ID :");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblId.setBounds(42, 114, 30, 21);
		contentPane.add(lblId);

		lblMarksA = new JLabel("");
		lblMarksA.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarksA.setForeground(Color.WHITE);
		lblMarksA.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblMarksA.setBounds(90, 168, 273, 28);
		contentPane.add(lblMarksA);

		lblCgpaA = new JLabel("");
		lblCgpaA.setHorizontalAlignment(SwingConstants.CENTER);
		lblCgpaA.setForeground(Color.WHITE);
		lblCgpaA.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblCgpaA.setBounds(90, 296, 273, 28);
		contentPane.add(lblCgpaA);

		lblAvgA = new JLabel("");
		lblAvgA.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvgA.setForeground(Color.WHITE);
		lblAvgA.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblAvgA.setBounds(90, 237, 273, 28);
		contentPane.add(lblAvgA);

		lblGradeA = new JLabel("");
		lblGradeA.setHorizontalAlignment(SwingConstants.CENTER);
		lblGradeA.setForeground(Color.WHITE);
		lblGradeA.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblGradeA.setBounds(90, 354, 273, 28);
		contentPane.add(lblGradeA);

		comboID = new JComboBox();
		comboID.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				setDataIntoLabel();
			}
		});
		comboID.setForeground(Color.BLACK);
		comboID.setFont(new Font("SansSerif", Font.BOLD, 14));
		comboID.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		comboID.setBackground(SystemColor.inactiveCaptionBorder);
		comboID.setBounds(72, 112, 84, 25);
		contentPane.add(comboID);

		JButton backBtn = new JButton("");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Results_Screen rs = new Results_Screen();
				rs.setVisible(true);
			}
		});
		backBtn.setIcon(new ImageIcon(Result_Delete.class.getResource("/Images/backSmall.png")));
		backBtn.setForeground(UIManager.getColor("Button.darkShadow"));
		backBtn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		backBtn.setBorder(null);
		backBtn.setBackground(new Color(105, 105, 105));
		backBtn.setBounds(10, 11, 30, 30);
		contentPane.add(backBtn);

		JLabel lblBack = new JLabel("Back");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				Results_Screen rs = new Results_Screen();
				rs.setVisible(true);
			}
		});
		lblBack.setForeground(Color.WHITE);
		lblBack.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblBack.setBounds(42, 17, 40, 18);
		contentPane.add(lblBack);
		
		JLabel lblRollNo = new JLabel("Roll_No :");
		lblRollNo.setForeground(Color.WHITE);
		lblRollNo.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblRollNo.setBounds(279, 114, 68, 21);
		contentPane.add(lblRollNo);
		
		lblRollNoA = new JLabel("");
		lblRollNoA.setForeground(Color.WHITE);
		lblRollNoA.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblRollNoA.setBounds(357, 114, 75, 21);
		contentPane.add(lblRollNoA);

		getID();
		// For Set Text into label
		setDataIntoLabel();

	}

	private void deleteData() {
		try {
			String query = "delete from results where result_id = '" + comboID.getSelectedItem() + "'";
			con.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Results Details Deleted Successfully!");
			setVisible(false);
			Results_Screen rs = new Results_Screen();
			rs.setVisible(true);

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	private void setDataIntoLabel() {
		try {
			String query = "select roll_no,remarks,cgpa,average,grade from results where result_id = '"
					+ comboID.getSelectedItem() + "'";
			ResultSet rs = con.statement.executeQuery(query);
			while (rs.next()) {
				lblMarksA.setText(rs.getString("remarks"));
				lblCgpaA.setText(rs.getString("cgpa"));
				lblAvgA.setText(rs.getString("average"));
				lblGradeA.setText(rs.getString("grade"));
				lblRollNoA.setText(rs.getString("roll_no"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void getID() {
		List<String> id = new ArrayList<>();
		// Getting ID from DB and insert into JComboBox
		try {
			String query1 = "select result_ID from results";
			ResultSet rs = con.statement.executeQuery(query1);
			while (rs.next()) {
				id.add(rs.getString("result_ID"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String arr[] = new String[id.size()];
		int i = 0;
		for (String type : id) {
			arr[i] = type;
			i++;
		}

		comboID.setModel(new DefaultComboBoxModel(arr));

	}

}
