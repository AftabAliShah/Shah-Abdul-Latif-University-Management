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

public class Result_View extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblC4A;
	private JLabel lblC2A;
	private JLabel lblC3A;
	private JLabel lblC1A;
	private JLabel lblRollNoA;
	private JLabel lblIdA;
	private JLabel lblMarksA;
	private JLabel lblGradeA;
	private JLabel lblCgpaA;
	private JLabel lblAvgA;
	private JLabel lblC1ma;
	private JLabel lblC2ma;
	private JLabel lblC3ma;
	private JLabel lblC4ma;

	String id;
	DBConnection con = new DBConnection();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Result_View frame = new Result_View("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Result_View(String id) {
		this.id = id;
		setTitle("Result View");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Result_View.class.getResource("/Images/uniLogo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, -13, 571, 538);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblC1 = new JLabel("Course 1 :");
		lblC1.setForeground(new Color(0, 0, 0));
		lblC1.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblC1.setBounds(62, 224, 75, 21);
		contentPane.add(lblC1);

		JLabel lblC3 = new JLabel("Course 3 :");
		lblC3.setForeground(new Color(0, 0, 0));
		lblC3.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblC3.setBounds(62, 288, 75, 21);
		contentPane.add(lblC3);

		JLabel lblC2 = new JLabel("Course 2 :");
		lblC2.setForeground(new Color(0, 0, 0));
		lblC2.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblC2.setBounds(62, 256, 75, 21);
		contentPane.add(lblC2);

		JLabel lblC4 = new JLabel("Course 4 :");
		lblC4.setForeground(new Color(0, 0, 0));
		lblC4.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblC4.setBounds(62, 320, 75, 21);
		contentPane.add(lblC4);

		JLabel lblId = new JLabel("ID :");
		lblId.setForeground(new Color(0, 0, 0));
		lblId.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblId.setBounds(62, 187, 40, 21);
		contentPane.add(lblId);

		lblC1A = new JLabel("");
		lblC1A.setHorizontalAlignment(SwingConstants.LEFT);
		lblC1A.setForeground(new Color(0, 0, 0));
		lblC1A.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblC1A.setBounds(147, 224, 216, 21);
		contentPane.add(lblC1A);

		lblC3A = new JLabel("");
		lblC3A.setHorizontalAlignment(SwingConstants.LEFT);
		lblC3A.setForeground(new Color(0, 0, 0));
		lblC3A.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblC3A.setBounds(147, 288, 216, 21);
		contentPane.add(lblC3A);

		lblC2A = new JLabel("");
		lblC2A.setHorizontalAlignment(SwingConstants.LEFT);
		lblC2A.setForeground(new Color(0, 0, 0));
		lblC2A.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblC2A.setBounds(147, 256, 216, 21);
		contentPane.add(lblC2A);

		lblC4A = new JLabel("");
		lblC4A.setHorizontalAlignment(SwingConstants.LEFT);
		lblC4A.setForeground(new Color(0, 0, 0));
		lblC4A.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblC4A.setBounds(147, 320, 216, 21);
		contentPane.add(lblC4A);

		JButton backBtn = new JButton("");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		backBtn.setIcon(new ImageIcon(Result_View.class.getResource("/Images/backSmall.png")));
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
		lblIdA.setBounds(112, 187, 65, 21);
		contentPane.add(lblIdA);

		JLabel lblSalu = new JLabel("Shah Abdul Latif Bhitai University Portal");
		lblSalu.setForeground(Color.BLACK);
		lblSalu.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblSalu.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0),

				new Color(245, 255, 250), new Color(245, 255, 250)));
		lblSalu.setBounds(123, 53, 422, 30);
		contentPane.add(lblSalu);

		JLabel uniLogo = new JLabel("");
		uniLogo.setIcon(new ImageIcon(Result_View.class.getResource("/Images/uniLogo.png")));
		uniLogo.setBounds(10, 39, 109, 97);
		contentPane.add(uniLogo);

		JLabel lblAvg = new JLabel("Average :");
		lblAvg.setForeground(Color.BLACK);
		lblAvg.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblAvg.setBounds(62, 384, 75, 21);
		contentPane.add(lblAvg);

		lblAvgA = new JLabel("");
		lblAvgA.setHorizontalAlignment(SwingConstants.LEFT);
		lblAvgA.setForeground(new Color(0, 0, 0));
		lblAvgA.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblAvgA.setBounds(147, 384, 216, 21);
		contentPane.add(lblAvgA);

		JLabel lblMarks = new JLabel("Remarks :");
		lblMarks.setForeground(Color.BLACK);
		lblMarks.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblMarks.setBounds(62, 416, 75, 21);
		contentPane.add(lblMarks);

		lblMarksA = new JLabel("");
		lblMarksA.setHorizontalAlignment(SwingConstants.LEFT);
		lblMarksA.setForeground(new Color(0, 0, 0));
		lblMarksA.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblMarksA.setBounds(147, 416, 216, 21);
		contentPane.add(lblMarksA);

		JLabel lblGrade = new JLabel("Grade :");
		lblGrade.setForeground(Color.BLACK);
		lblGrade.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblGrade.setBounds(62, 452, 65, 21);
		contentPane.add(lblGrade);

		lblGradeA = new JLabel("");
		lblGradeA.setHorizontalAlignment(SwingConstants.LEFT);
		lblGradeA.setForeground(new Color(0, 0, 0));
		lblGradeA.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblGradeA.setBounds(147, 452, 216, 21);
		contentPane.add(lblGradeA);

		JLabel lblCgpa = new JLabel("CGPA :");
		lblCgpa.setForeground(Color.BLACK);
		lblCgpa.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCgpa.setBounds(62, 352, 53, 21);
		contentPane.add(lblCgpa);

		lblCgpaA = new JLabel("");
		lblCgpaA.setHorizontalAlignment(SwingConstants.LEFT);
		lblCgpaA.setForeground(new Color(0, 0, 0));
		lblCgpaA.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCgpaA.setBounds(147, 352, 216, 21);
		contentPane.add(lblCgpaA);

		JLabel lblRollNo = new JLabel("Roll No :");
		lblRollNo.setForeground(Color.BLACK);
		lblRollNo.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblRollNo.setBounds(354, 187, 58, 21);
		contentPane.add(lblRollNo);

		lblRollNoA = new JLabel("");
		lblRollNoA.setHorizontalAlignment(SwingConstants.LEFT);
		lblRollNoA.setForeground(new Color(0, 0, 0));
		lblRollNoA.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblRollNoA.setBounds(417, 187, 84, 21);
		contentPane.add(lblRollNoA);

		JLabel lblStudentInformation = new JLabel("Result Information");
		lblStudentInformation.setForeground(Color.BLACK);
		lblStudentInformation.setFont(new Font("Stencil", Font.PLAIN, 21));
		lblStudentInformation.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0),
				new Color(0, 0, 0), new Color(0, 0, 0)));
		lblStudentInformation.setBounds(224, 95, 223, 27);
		contentPane.add(lblStudentInformation);

		lblC1ma = new JLabel("");
		lblC1ma.setHorizontalAlignment(SwingConstants.LEFT);
		lblC1ma.setForeground(Color.BLACK);
		lblC1ma.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblC1ma.setBounds(386, 224, 71, 21);
		contentPane.add(lblC1ma);

		lblC2ma = new JLabel("");
		lblC2ma.setHorizontalAlignment(SwingConstants.LEFT);
		lblC2ma.setForeground(Color.BLACK);
		lblC2ma.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblC2ma.setBounds(386, 256, 71, 21);
		contentPane.add(lblC2ma);

		lblC3ma = new JLabel("");
		lblC3ma.setHorizontalAlignment(SwingConstants.LEFT);
		lblC3ma.setForeground(Color.BLACK);
		lblC3ma.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblC3ma.setBounds(386, 288, 71, 21);
		contentPane.add(lblC3ma);

		lblC4ma = new JLabel("");
		lblC4ma.setHorizontalAlignment(SwingConstants.LEFT);
		lblC4ma.setForeground(Color.BLACK);
		lblC4ma.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblC4ma.setBounds(386, 320, 71, 21);
		contentPane.add(lblC4ma);

		setDataIntoLabel();

	}

	private void setDataIntoLabel() {
		try {
			String query = "select * from results where result_id =  '" + id + "'";
			ResultSet rs = con.statement.executeQuery(query);
			while (rs.next()) {
				lblC1A.setText(rs.getString("Course1"));
				lblC2A.setText(rs.getString("Course2"));
				lblC4A.setText(rs.getString("Course3"));
				lblC3A.setText(rs.getString("Course4"));
				lblIdA.setText(rs.getString("result_id"));
				lblMarksA.setText(rs.getString("remarks"));
				lblGradeA.setText(rs.getString("grade"));
				lblCgpaA.setText(rs.getString("cgpa"));
				lblRollNoA.setText(rs.getString("roll_no"));
				lblAvgA.setText(rs.getString("Average"));
				 lblC1ma.setText(rs.getString("course1_marks"));
				 lblC2ma.setText(rs.getString("course2_marks"));
				 lblC3ma.setText(rs.getString("course3_marks"));
				 lblC4ma.setText(rs.getString("course4_marks"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void back() {
		this.setVisible(false);
		Results_Screen as = new Results_Screen();
		as.setVisible(true);
	}
}
