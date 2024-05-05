package university;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JSeparator;

public class Login_Screen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtU_Name;
	private JPasswordField txtPass;
	JLabel hideIcn;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Screen frame = new Login_Screen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Screen Logic
	public Login_Screen() {
		setTitle("Login");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Login_Screen.class.getResource("/Images/shah-abdul-latif-university-logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 718, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(245, 255, 250), new Color(245, 255, 250),
				new Color(245, 255, 250), new Color(245, 245, 245)));
		contentPane.setBackground(new Color(105, 105, 105));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblU_Name = new JLabel("Username/Phone No.");
		lblU_Name.setForeground(new Color(245, 255, 250));
		lblU_Name.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblU_Name.setBounds(313, 131, 147, 18);
		contentPane.add(lblU_Name);

		txtU_Name = new JTextField();
		txtU_Name.setColumns(10);
		txtU_Name.setBackground(new Color(105, 105, 105));
		txtU_Name.setForeground(new Color(255, 255, 255));
		txtU_Name.setBorder(null);
		txtU_Name.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtU_Name.setBounds(313, 158, 292, 30);
		contentPane.add(txtU_Name);

		JLabel lblPass = new JLabel("Password");
		lblPass.setForeground(new Color(245, 255, 250));
		lblPass.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblPass.setBounds(313, 210, 68, 23);
		contentPane.add(lblPass);

		txtPass = new JPasswordField();
		txtPass.setEchoChar('*');
		txtPass.setBackground(new Color(105, 105, 105));
		txtPass.setForeground(new Color(255, 255, 255));
		txtPass.setBorder(null);
		txtPass.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtPass.setBounds(313, 239, 254, 30);
		contentPane.add(txtPass);

		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkCredientials();
			}
		});
		btnLogin.setForeground(new Color(224, 255, 255));
		btnLogin.setFont(new Font("SansSerif", Font.BOLD, 14));
		btnLogin.setBackground(new Color(0, 0, 0));
		btnLogin.setBounds(313, 314, 89, 30);
		btnLogin.setBorder(
				new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(255, 255, 255), null, null));
		contentPane.add(btnLogin);
		// Show Password
		JLabel visibleIcn = new JLabel("");
		visibleIcn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				visibleIcn.setVisible(false);
				hideIcn.setVisible(true);
				txtPass.setEchoChar((char) 0);
			}
		});
		visibleIcn.setIcon(new ImageIcon(Login_Screen.class.getResource("/Images/show.png")));
		visibleIcn.setBounds(577, 239, 25, 25);
		contentPane.add(visibleIcn);

		hideIcn = new JLabel("");
		hideIcn.setIcon(new ImageIcon(Login_Screen.class.getResource("/Images/hide.png")));
		hideIcn.setBounds(577, 239, 25, 25);
		hideIcn.setVisible(false);
		hideIcn.addMouseListener(new MouseAdapter() {
			// Hide Password
			@Override
			public void mousePressed(MouseEvent e) {
				visibleIcn.setVisible(true);
				hideIcn.setVisible(false);
				txtPass.setEchoChar('*');
			}
		});
		contentPane.add(hideIcn);

		JLabel lblNoAcc = new JLabel("Don't have an account?");
		lblNoAcc.setBackground(new Color(255, 255, 255));
		lblNoAcc.setForeground(new Color(255, 255, 255));
		lblNoAcc.setFont(new Font("SansSerif", Font.BOLD, 13));
		lblNoAcc.setBounds(472, 374, 165, 19);
		contentPane.add(lblNoAcc);

		JButton btnRegister = new JButton("Sign up");
		btnRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegister.setForeground(new Color(0, 255, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnRegister.setForeground(new Color(0, 255, 255));
			}
		});
		// changing the screen while pressing register button.
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Signup_Screen sup = new Signup_Screen();
				sup.setVisible(true);
			}
		});
		btnRegister.setBackground(new Color(105, 105, 105));
		btnRegister.setBorder(null);
		btnRegister.setForeground(new Color(0, 255, 255));
		btnRegister.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 13));
		btnRegister.setBounds(623, 374, 60, 19);
		contentPane.add(btnRegister);
		// turning off the program while pressing exit button.
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnExit.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		btnExit.setForeground(new Color(224, 255, 255));
		btnExit.setBackground(new Color(0, 0, 0));
		btnExit.setBounds(606, 404, 75, 23);
		btnExit.setBorder(
				new BevelBorder(BevelBorder.LOWERED, new Color(255, 255, 255), new Color(255, 255, 255), null, null));
		contentPane.add(btnExit);

		JLabel lblHeading = new JLabel("SIGN IN");
		lblHeading.setForeground(new Color(245, 255, 250));
		lblHeading.setBorder(null);
		lblHeading.setFont(new Font("Myanmar Text", Font.BOLD, 19));
		lblHeading.setBounds(313, 39, 81, 37);
		contentPane.add(lblHeading);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(245, 255, 250), new Color(245, 255, 250),
				new Color(245, 255, 250), new Color(245, 255, 250)));
		panel.setBackground(new Color(245, 255, 250));
		panel.setBounds(0, 0, 282, 444);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel uniLogo = new JLabel("");
		uniLogo.setBounds(77, 0, 120, 120);
		panel.add(uniLogo);
		uniLogo.setIcon(new ImageIcon(Login_Screen.class.getResource("/Images/uniLogo.png")));

		JLabel lblSalu = new JLabel("Shah Abdul Latif Bhitai");
		lblSalu.setBounds(10, 114, 248, 24);
		lblSalu.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0),
				new Color(245, 255, 250), new Color(245, 255, 250)));
		lblSalu.setForeground(new Color(0, 0, 0));
		lblSalu.setFont(new Font("Stencil", Font.PLAIN, 19));
		panel.add(lblSalu);

		JLabel lblSalu2 = new JLabel("University Portal");
		lblSalu2.setForeground(Color.BLACK);
		lblSalu2.setFont(new Font("Stencil", Font.PLAIN, 19));
		lblSalu2.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), new Color(0, 0, 0),
				new Color(245, 255, 250), new Color(245, 255, 250)));
		lblSalu2.setBounds(66, 140, 191, 24);
		panel.add(lblSalu2);

		JLabel icn1 = new JLabel("");
		icn1.setIcon(new ImageIcon(Login_Screen.class.getResource("/Images/bachelors.png")));
		icn1.setBounds(25, 355, 60, 60);
		panel.add(icn1);

		JLabel icn2 = new JLabel("");
		icn2.setIcon(new ImageIcon(Login_Screen.class.getResource("/Images/STUD.png")));
		icn2.setBounds(110, 355, 60, 60);
		panel.add(icn2);

		JLabel icn3 = new JLabel("New label");
		icn3.setIcon(new ImageIcon(Login_Screen.class.getResource("/Images/info.png")));
		icn3.setBounds(195, 355, 60, 60);
		panel.add(icn3);

		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(255, 255, 255));
		separator.setForeground(new Color(255, 255, 255));
		separator.setBounds(313, 191, 292, 8);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(255, 255, 255));
		separator_1.setForeground(new Color(255, 255, 255));
		separator_1.setBounds(313, 273, 292, 8);
		contentPane.add(separator_1);

	}

	private void checkCredientials() {
		try {
			String user = txtU_Name.getText();
			String pass = txtPass.getText();
			String query = "select * from login_data where user_name = '" + user + "' or phone = '" + user
					+ "' and password = '" + pass + "' ";
			DBConnection conn = new DBConnection();
			ResultSet rs = conn.statement.executeQuery(query);
			if (rs.next()) {

				setVisible(false);
				Main_Screen ms = new Main_Screen();
				ms.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "UserName OR Password Is Incorrect");

			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
