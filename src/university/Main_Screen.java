package university;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main_Screen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Screen frame = new Main_Screen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main_Screen() {
		setTitle("Dashboard");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main_Screen.class.getResource("/Images/uniLogo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 991, 557);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(245, 255, 250), new Color(245, 255, 250),
				new Color(245, 255, 250), new Color(245, 255, 250)));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(new Color(245, 255, 250));
		panel.setBounds(0, 0, 271, 518);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel uniLogo = new JLabel("New label");
		uniLogo.setIcon(new ImageIcon(Main_Screen.class.getResource("/Images/uniLogo.png")));
		uniLogo.setBounds(81, 11, 109, 97);
		panel.add(uniLogo);

		JLabel lblSalu = new JLabel("Shah Abdul Latif Bhitai");
		lblSalu.setForeground(Color.BLACK);
		lblSalu.setFont(new Font("Stencil", Font.PLAIN, 19));
		lblSalu.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0),
				new Color(245, 255, 250), new Color(245, 255, 250)));
		lblSalu.setBounds(11, 116, 248, 24);
		panel.add(lblSalu);

		JLabel lblSalu2 = new JLabel("University Portal");
		lblSalu2.setForeground(Color.BLACK);
		lblSalu2.setFont(new Font("Stencil", Font.PLAIN, 19));
		lblSalu2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0),
				new Color(245, 255, 250), new Color(245, 255, 250)));
		lblSalu2.setBounds(70, 138, 191, 24);
		panel.add(lblSalu2);

		JButton btnAbout = new JButton("");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About_Us au = new About_Us();
				au.setVisible(true);		
			}
		});
		btnAbout.setIcon(new ImageIcon(Main_Screen.class.getResource("/Images/i.png")));
		btnAbout.setForeground(new Color(245, 255, 250));
		btnAbout.setBorder(null);
		btnAbout.setBackground(new Color(245, 255, 250));
		btnAbout.setBounds(11, 472, 28, 28);
		panel.add(btnAbout);

		JLabel lblAbout = new JLabel("About us");
		lblAbout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAbout.setForeground(new Color(0, 0, 205));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblAbout.setForeground(new Color(0, 0, 0));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				About_Us au = new About_Us();
				au.setVisible(true);			}
		});

		lblAbout.setForeground(new Color(0, 0, 0));
		lblAbout.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblAbout.setBounds(45, 474, 66, 24);
		panel.add(lblAbout);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(105, 105, 105));
		panel_2.setBounds(272, 0, 703, 519);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JButton btnAdmission = new JButton("");
		btnAdmission.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAdmission.setBackground(SystemColor.activeCaption);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAdmission.setBackground(new Color(105, 105, 105));
			}

		});
		btnAdmission.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Admission_Screen as = new Admission_Screen();
				as.setVisible(true);
			}
		});
		btnAdmission.setBorder(null);
		btnAdmission.setIcon(new ImageIcon(Main_Screen.class.getResource("/Images/stu.png")));
		btnAdmission.setForeground(new Color(255, 255, 224));
		btnAdmission.setBackground(new Color(105, 105, 105));
		btnAdmission.setBounds(60, 130, 100, 100);
		panel_2.add(btnAdmission);

		JButton btnStaff = new JButton("");
		btnStaff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnStaff.setBackground(SystemColor.activeCaption);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnStaff.setBackground(new Color(105, 105, 105));
			}
		});
		btnStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Emp_Screen es = new Emp_Screen();
				es.setVisible(true);
			}
		});
		btnStaff.setBorder(null);
		btnStaff.setBackground(new Color(105, 105, 105));
		btnStaff.setIcon(new ImageIcon(Main_Screen.class.getResource("/Images/emp.png")));
		btnStaff.setBounds(220, 130, 100, 100);
		panel_2.add(btnStaff);

		JButton btnLeave =  new JButton("");
		btnLeave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLeave.setBackground(SystemColor.activeCaption);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnLeave.setBackground(new Color(105, 105, 105));
			}
		});
		btnLeave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Leave_Options lo = new Leave_Options();
				lo.setVisible(true);
			}
		});
		btnLeave.setBorder(null);
		btnLeave.setIcon(new ImageIcon(Main_Screen.class.getResource("/Images/leavee.png")));
		btnLeave.setBackground(new Color(105, 105, 105));
		btnLeave.setBounds(380, 320, 100, 100);
		panel_2.add(btnLeave);

		JButton btnPay = new JButton("");
		btnPay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPay.setBackground(SystemColor.activeCaption);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnPay.setBackground(new Color(105, 105, 105));
			}
		});
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Receipts_Screen fs = new Receipts_Screen();
				fs.setVisible(true);
			}
		});
		btnPay.setBorder(null);
		btnPay.setIcon(new ImageIcon(Main_Screen.class.getResource("/Images/fee.png")));
		btnPay.setBackground(new Color(105, 105, 105));
		btnPay.setBounds(220, 320, 100, 100);
		panel_2.add(btnPay);

		JButton btnUtilities = new JButton("");
		btnUtilities.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utilities_Screen us = new Utilities_Screen();
				us.setVisible(true);

			}
		});
		btnUtilities.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnUtilities.setBackground(SystemColor.activeCaption);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnUtilities.setBackground(new Color(105, 105, 105));
			}
		});
		btnUtilities.setBorder(null);

		btnUtilities.setBackground(new Color(105, 105, 105));
		btnUtilities.setIcon(new ImageIcon(Main_Screen.class.getResource("/Images/utilities.png")));
		btnUtilities.setBounds(540, 320, 100, 100);
		panel_2.add(btnUtilities);

		JButton btnDept = new JButton("");
		btnDept.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDept.setBackground(SystemColor.activeCaption);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnDept.setBackground(new Color(105, 105, 105));
			}
		});
		btnDept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Dept_Screen ds = new Dept_Screen();
				ds.setVisible(true);
			}
		});
		btnDept.setBorder(null);
		btnDept.setBackground(new Color(105, 105, 105));
		btnDept.setIcon(new ImageIcon(Main_Screen.class.getResource("/Images/department.png")));
		btnDept.setBounds(380, 130, 100, 100);
		panel_2.add(btnDept);

		JButton btnResults = new JButton("");
		btnResults.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnResults.setBackground(SystemColor.activeCaption);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnResults.setBackground(new Color(105, 105, 105));
			}
		});
		btnResults.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Results_Screen rs = new Results_Screen();
				rs.setVisible(true);
			}
		});
		btnResults.setBorder(null);
		btnResults.setBackground(new Color(105, 105, 105));
		btnResults.setIcon(new ImageIcon(Main_Screen.class.getResource("/Images/results.png")));
		btnResults.setBounds(60, 320, 100, 100);
		panel_2.add(btnResults);

		JLabel lblAdmission = new JLabel("Admission");
		lblAdmission.setForeground(new Color(245, 255, 250));
		lblAdmission.setFont(new Font("SansSerif", Font.BOLD, 17));
		lblAdmission.setBounds(70, 228, 81, 36);
		panel_2.add(lblAdmission);

		JLabel lblStaff = new JLabel("Staff");
		lblStaff.setForeground(new Color(245, 255, 250));
		lblStaff.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblStaff.setBounds(247, 228, 47, 36);
		panel_2.add(lblStaff);

		JLabel lblResults = new JLabel("Results");
		lblResults.setForeground(new Color(245, 255, 250));
		lblResults.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblResults.setBounds(77, 419, 66, 36);
		panel_2.add(lblResults);

		JLabel lblDept = new JLabel("Department");
		lblDept.setForeground(new Color(245, 255, 250));
		lblDept.setFont(new Font("SansSerif", Font.BOLD, 17));
		lblDept.setBounds(384, 229, 92, 36);
		panel_2.add(lblDept);

		JLabel lblUtilities = new JLabel("Utilies");
		lblUtilities.setForeground(new Color(245, 255, 250));
		lblUtilities.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblUtilities.setBounds(562, 419, 56, 36);
		panel_2.add(lblUtilities);

		JLabel lblLeave = new JLabel("Leave");
		lblLeave.setForeground(new Color(245, 255, 250));
		lblLeave.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblLeave.setBounds(403, 419, 54, 36);
		panel_2.add(lblLeave);

		JLabel lblPay = new JLabel("Payment");
		lblPay.setForeground(new Color(245, 255, 250));
		lblPay.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblPay.setBounds(230, 419, 80, 36);
		panel_2.add(lblPay);

		JLabel lblHeading = new JLabel("DASHBOARD");
		lblHeading.setForeground(new Color(245, 255, 250));
		lblHeading.setFont(new Font("Verdana", Font.BOLD, 19));
		lblHeading.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(105, 105, 105), new Color(105, 105, 105),
				new Color(255, 255, 255), new Color(255, 255, 255)));
		lblHeading.setBounds(278, 50, 146, 36);
		panel_2.add(lblHeading);

		JButton btnCourse = new JButton("");
		btnCourse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCourse.setBackground(SystemColor.activeCaption);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnCourse.setBackground(new Color(105, 105, 105));
			}
		});
		btnCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Courses_Screen cs = new Courses_Screen();
				cs.setVisible(true);
			}
		});
		btnCourse.setBounds(540, 130, 100, 100);
		panel_2.add(btnCourse);
		btnCourse.setBorder(null);
		btnCourse.setBackground(new Color(105, 105, 105));
		btnCourse.setIcon(new ImageIcon(Main_Screen.class.getResource("/Images/courses.png")));

		JLabel lblCourse = new JLabel("Courses");
		lblCourse.setBounds(557, 229, 66, 36);
		panel_2.add(lblCourse);
		lblCourse.setForeground(new Color(245, 255, 250));
		lblCourse.setFont(new Font("SansSerif", Font.BOLD, 17));

	}
}
