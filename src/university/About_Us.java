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
import javax.swing.JSeparator;

public class About_Us extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	DBConnection con = new DBConnection();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About_Us frame = new About_Us();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public About_Us() {
		
		setTitle("About us!");
		setIconImage(Toolkit.getDefaultToolkit().getImage(About_Us.class.getResource("/Images/uniLogo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, -13, 571, 650);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCnicNo = new JLabel("CNIC No :  43205-9605352-7");
		lblCnicNo.setForeground(new Color(255, 255, 255));
		lblCnicNo.setFont(new Font("Monospaced", Font.BOLD, 18));
		lblCnicNo.setBounds(62, 236, 292, 21);
		contentPane.add(lblCnicNo);

		JLabel lblRollNo = new JLabel("Roll No :  01");
		lblRollNo.setForeground(new Color(255, 255, 255));
		lblRollNo.setFont(new Font("Stencil", Font.PLAIN, 20));
		lblRollNo.setBounds(62, 196, 124, 21);
		contentPane.add(lblRollNo);

		JLabel lblSalu = new JLabel("Shah Abdul Latif Bhitai");
		lblSalu.setForeground(new Color(255, 255, 255));
		lblSalu.setFont(new Font("Stencil", Font.PLAIN, 29));
		lblSalu.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 128, 128), new Color(0, 128, 128), new Color(255, 255, 255), new Color(255, 255, 255)));
		lblSalu.setBounds(145, 46, 372, 30);
		contentPane.add(lblSalu);

		JLabel uniLogo = new JLabel("");
		uniLogo.setIcon(new ImageIcon(About_Us.class.getResource("/Images/uniLogo.png")));
		uniLogo.setBounds(20, 26, 109, 97);
		contentPane.add(uniLogo);

		JLabel lblPhone = new JLabel("Phone No :  +923003299713");
		lblPhone.setForeground(new Color(255, 255, 255));
		lblPhone.setFont(new Font("Monospaced", Font.BOLD, 18));
		lblPhone.setBounds(62, 268, 292, 21);
		contentPane.add(lblPhone);

		JLabel lblAddress = new JLabel("Address 1 :  Defence Phase View Housing Society");
		lblAddress.setForeground(new Color(255, 255, 255));
		lblAddress.setFont(new Font("Monospaced", Font.BOLD, 17));
		lblAddress.setBounds(62, 300, 470, 21);
		contentPane.add(lblAddress);

		JLabel lblName = new JLabel("DEVELOPED BY :  AFTAB ALI SHAH");
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setFont(new Font("Stencil", Font.PLAIN, 21));
		lblName.setBorder(null);
		lblName.setBounds(62, 158, 331, 27);
		contentPane.add(lblName);
		
		JLabel lblUniversityPortal = new JLabel("UNIVERSITY PORTAL");
		lblUniversityPortal.setForeground(new Color(255, 255, 255));
		lblUniversityPortal.setFont(new Font("Stencil", Font.PLAIN, 24));
		lblUniversityPortal.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, new Color(255, 255, 255), new Color(255, 255, 255)));
		lblUniversityPortal.setBounds(278, 74, 239, 30);
		contentPane.add(lblUniversityPortal);
		
		JLabel lblAddress2 = new JLabel("Address 2 :  Korangi, Near Iqra Uni Main Campus");
		lblAddress2.setForeground(new Color(255, 255, 255));
		lblAddress2.setFont(new Font("Monospaced", Font.BOLD, 17));
		lblAddress2.setBounds(62, 332, 470, 21);
		contentPane.add(lblAddress2);
		
		JLabel lblAboutHeading = new JLabel("About Application");
		lblAboutHeading.setForeground(new Color(255, 255, 255));
		lblAboutHeading.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 18));
		lblAboutHeading.setBounds(179, 387, 196, 21);
		contentPane.add(lblAboutHeading);
		
		JLabel lblAbout1 = new JLabel("A project is built with java swing could include features like student");
		lblAbout1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbout1.setForeground(new Color(255, 255, 255));
		lblAbout1.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblAbout1.setBounds(20, 420, 525, 21);
		contentPane.add(lblAbout1);
		
		JLabel lblAbout2 = new JLabel("registration, course enrollment, grade tracking, faculty management, and");
		lblAbout2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbout2.setForeground(new Color(255, 255, 255));
		lblAbout2.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblAbout2.setBounds(20, 439, 525, 21);
		contentPane.add(lblAbout2);
		
		JLabel lblAbout3 = new JLabel("administrative functions. It would likely have a user-friendly interface");
		lblAbout3.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbout3.setForeground(new Color(255, 255, 255));
		lblAbout3.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblAbout3.setBounds(20, 460, 525, 21);
		contentPane.add(lblAbout3);
		
		JLabel lblAbout6 = new JLabel("student and course information, as well as authentication.");
		lblAbout6.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbout6.setForeground(new Color(255, 255, 255));
		lblAbout6.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblAbout6.setBounds(20, 520, 525, 21);
		contentPane.add(lblAbout6);
		
		JLabel lblAbout5 = new JLabel(" The system would also need to include database management for storing");
		lblAbout5.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbout5.setForeground(new Color(255, 255, 255));
		lblAbout5.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblAbout5.setBounds(20, 499, 525, 21);
		contentPane.add(lblAbout5);
		
		JLabel lblAbout4 = new JLabel("allowing users to navigate easily through different functionalities.");
		lblAbout4.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbout4.setForeground(new Color(255, 255, 255));
		lblAbout4.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblAbout4.setBounds(20, 480, 525, 21);
		contentPane.add(lblAbout4);
		
		JLabel lblThanks = new JLabel("THANKS FOR USING OUR APP!");
		lblThanks.setForeground(new Color(255, 255, 255));
		lblThanks.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 16));
		lblThanks.setBounds(135, 563, 285, 21);
		contentPane.add(lblThanks);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBackground(new Color(224, 255, 255));
		separator.setBounds(179, 407, 196, 10);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(255, 255, 255));
		separator_1.setBackground(new Color(224, 255, 255));
		separator_1.setBounds(137, 585, 280, 10);
		contentPane.add(separator_1);


	}
}
