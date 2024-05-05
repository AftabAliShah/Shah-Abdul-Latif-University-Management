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

public class Receipt_View extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblSemesA;
	private JLabel lblDateA;
	private JLabel lblDeptAns;
	private JLabel lblAmountA;
	private JLabel lblIdA;
	private JLabel lblRollNoA;

	String id;
	DBConnection con = new DBConnection();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Receipt_View frame = new Receipt_View("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Receipt_View(String id) {
		this.id = id;
		setTitle("Receipt View");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Receipt_View.class.getResource("/Images/uniLogo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, -13, 487, 404);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAmount = new JLabel("Amount :");
		lblAmount.setForeground(new Color(0, 0, 0));
		lblAmount.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblAmount.setBounds(62, 224, 75, 21);
		contentPane.add(lblAmount);

		JLabel lblDept = new JLabel("Department :");
		lblDept.setForeground(new Color(0, 0, 0));
		lblDept.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDept.setBounds(62, 288, 96, 21);
		contentPane.add(lblDept);

		JLabel lblDate = new JLabel("Date :");
		lblDate.setForeground(new Color(0, 0, 0));
		lblDate.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDate.setBounds(62, 256, 75, 21);
		contentPane.add(lblDate);

		JLabel lblSemes = new JLabel("Semester :");
		lblSemes.setForeground(new Color(0, 0, 0));
		lblSemes.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblSemes.setBounds(62, 320, 75, 21);
		contentPane.add(lblSemes);

		JLabel lblId = new JLabel("ID :");
		lblId.setForeground(new Color(0, 0, 0));
		lblId.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblId.setBounds(61, 187, 30, 21);
		contentPane.add(lblId);

		lblAmountA = new JLabel("");
		lblAmountA.setHorizontalAlignment(SwingConstants.LEFT);
		lblAmountA.setForeground(new Color(0, 0, 0));
		lblAmountA.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblAmountA.setBounds(168, 224, 264, 21);
		contentPane.add(lblAmountA);

		lblDeptAns = new JLabel("");
		lblDeptAns.setHorizontalAlignment(SwingConstants.LEFT);
		lblDeptAns.setForeground(new Color(0, 0, 0));
		lblDeptAns.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDeptAns.setBounds(168, 288, 264, 21);
		contentPane.add(lblDeptAns);

		lblDateA = new JLabel("");
		lblDateA.setHorizontalAlignment(SwingConstants.LEFT);
		lblDateA.setForeground(new Color(0, 0, 0));
		lblDateA.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDateA.setBounds(168, 256, 264, 21);
		contentPane.add(lblDateA);

		lblSemesA = new JLabel("");
		lblSemesA.setHorizontalAlignment(SwingConstants.LEFT);
		lblSemesA.setForeground(new Color(0, 0, 0));
		lblSemesA.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblSemesA.setBounds(168, 320, 264, 21);
		contentPane.add(lblSemesA);

		JButton backBtn = new JButton("");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		backBtn.setIcon(new ImageIcon(Receipt_View.class.getResource("/Images/backSmall.png")));
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
		lblIdA.setBounds(101, 187, 65, 21);
		contentPane.add(lblIdA);

		JLabel lblSalu = new JLabel("Shah Abdul Latif Bhitai University Portal");
		lblSalu.setForeground(Color.BLACK);
		lblSalu.setFont(new Font("Stencil", Font.PLAIN, 14));
		lblSalu.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0),

				new Color(245, 255, 250), new Color(245, 255, 250)));
		lblSalu.setBounds(123, 53, 337, 30);
		contentPane.add(lblSalu);

		JLabel uniLogo = new JLabel("");
		uniLogo.setIcon(new ImageIcon(Receipt_View.class.getResource("/Images/uniLogo.png")));
		uniLogo.setBounds(10, 39, 109, 97);
		contentPane.add(uniLogo);

		JLabel lblStudentInformation = new JLabel("Receipt Information");
		lblStudentInformation.setForeground(Color.BLACK);
		lblStudentInformation.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblStudentInformation.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0),
				new Color(0, 0, 0), new Color(0, 0, 0)));
		lblStudentInformation.setBounds(190, 94, 203, 27);
		contentPane.add(lblStudentInformation);
		
		JLabel lblRollNo = new JLabel("Roll No :");
		lblRollNo.setForeground(Color.BLACK);
		lblRollNo.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblRollNo.setBounds(308, 187, 58, 21);
		contentPane.add(lblRollNo);
		
		lblRollNoA = new JLabel("");
		lblRollNoA.setHorizontalAlignment(SwingConstants.LEFT);
		lblRollNoA.setForeground(Color.BLACK);
		lblRollNoA.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblRollNoA.setBounds(376, 187, 65, 21);
		contentPane.add(lblRollNoA);

		setDataIntoLabel();

	}

	private void setDataIntoLabel() {
		try {
			String query = "select * from fees where fee_id =  '"
					+ id + "'";
			ResultSet rs = con.statement.executeQuery(query);
			while (rs.next()) {
				lblAmountA.setText(rs.getString("amount"));
				lblDateA.setText(rs.getString("fee_date"));
				lblSemesA.setText(rs.getString("semester"));
				lblDeptAns.setText(rs.getString("department"));
				lblIdA.setText(rs.getString("fee_id"));
				lblRollNoA.setText(rs.getString("roll_no"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void back() {
		this.setVisible(false);
		Receipts_Screen rs = new Receipts_Screen();
		rs.setVisible(true);
	}
}
