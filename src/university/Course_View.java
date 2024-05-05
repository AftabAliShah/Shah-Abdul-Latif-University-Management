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

public class Course_View extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblSemesA;
	private JLabel lblDurationA;
	private JLabel lblDeptAns;
	private JLabel lblNameAns;
	private JLabel lblIdA;
	private JLabel lblTypeA;

	String id;
	DBConnection con = new DBConnection();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Course_View frame = new Course_View("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Course_View(String id) {
		this.id = id;
		setTitle("Course View");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Course_View.class.getResource("/Images/uniLogo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, -13, 487, 452);
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

		JLabel lblDuration = new JLabel("Duration :");
		lblDuration.setForeground(new Color(0, 0, 0));
		lblDuration.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDuration.setBounds(62, 256, 75, 21);
		contentPane.add(lblDuration);

		JLabel lblSemes = new JLabel("Semester :");
		lblSemes.setForeground(new Color(0, 0, 0));
		lblSemes.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblSemes.setBounds(62, 320, 75, 21);
		contentPane.add(lblSemes);

		JLabel lblId = new JLabel("ID :");
		lblId.setForeground(new Color(0, 0, 0));
		lblId.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblId.setBounds(62, 187, 30, 21);
		contentPane.add(lblId);

		lblNameAns = new JLabel("");
		lblNameAns.setHorizontalAlignment(SwingConstants.LEFT);
		lblNameAns.setForeground(new Color(0, 0, 0));
		lblNameAns.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNameAns.setBounds(160, 224, 287, 21);
		contentPane.add(lblNameAns);

		lblDeptAns = new JLabel("");
		lblDeptAns.setHorizontalAlignment(SwingConstants.LEFT);
		lblDeptAns.setForeground(new Color(0, 0, 0));
		lblDeptAns.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDeptAns.setBounds(160, 288, 287, 21);
		contentPane.add(lblDeptAns);

		lblDurationA = new JLabel("");
		lblDurationA.setHorizontalAlignment(SwingConstants.LEFT);
		lblDurationA.setForeground(new Color(0, 0, 0));
		lblDurationA.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDurationA.setBounds(160, 256, 287, 21);
		contentPane.add(lblDurationA);

		lblSemesA = new JLabel("");
		lblSemesA.setHorizontalAlignment(SwingConstants.LEFT);
		lblSemesA.setForeground(new Color(0, 0, 0));
		lblSemesA.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblSemesA.setBounds(160, 320, 287, 21);
		contentPane.add(lblSemesA);

		JButton backBtn = new JButton("");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		backBtn.setIcon(new ImageIcon(Course_View.class.getResource("/Images/backSmall.png")));
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
		lblIdA.setBounds(122, 187, 65, 21);
		contentPane.add(lblIdA);

		JLabel lblSalu = new JLabel("Shah Abdul Latif Bhitai University Portal");
		lblSalu.setForeground(Color.BLACK);
		lblSalu.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblSalu.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0),

				new Color(245, 255, 250), new Color(245, 255, 250)));
		lblSalu.setBounds(123, 53, 337, 30);
		contentPane.add(lblSalu);

		JLabel uniLogo = new JLabel("");
		uniLogo.setIcon(new ImageIcon(Course_View.class.getResource("/Images/uniLogo.png")));
		uniLogo.setBounds(10, 39, 109, 97);
		contentPane.add(uniLogo);

		JLabel lblType = new JLabel("Type :");
		lblType.setForeground(Color.BLACK);
		lblType.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblType.setBounds(62, 352, 54, 21);
		contentPane.add(lblType);

		lblTypeA = new JLabel("");
		lblTypeA.setHorizontalAlignment(SwingConstants.LEFT);
		lblTypeA.setForeground(new Color(0, 0, 0));
		lblTypeA.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblTypeA.setBounds(160, 352, 287, 21);
		contentPane.add(lblTypeA);

		JLabel lblStudentInformation = new JLabel("Course Information");
		lblStudentInformation.setForeground(Color.BLACK);
		lblStudentInformation.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblStudentInformation.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0),
				new Color(0, 0, 0), new Color(0, 0, 0)));
		lblStudentInformation.setBounds(193, 94, 196, 27);
		contentPane.add(lblStudentInformation);

		setDataIntoLabel();

	}

	private void setDataIntoLabel() {
		try {
			String query = "select course_id,course_name,course_duration,semester,department,course_type from courses where course_id =  '"
					+ id + "'";
			ResultSet rs = con.statement.executeQuery(query);
			while (rs.next()) {
				lblNameAns.setText(rs.getString("course_name"));
				lblDurationA.setText(rs.getString("course_duration"));
				lblSemesA.setText(rs.getString("semester"));
				lblDeptAns.setText(rs.getString("department"));
				lblIdA.setText(rs.getString("course_id"));
				lblTypeA.setText(rs.getString("course_type"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void back() {
		this.setVisible(false);
		Courses_Screen cs = new Courses_Screen();
		cs.setVisible(true);
	}
}
