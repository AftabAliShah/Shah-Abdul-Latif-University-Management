
package university;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

public class Signup_Screen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_F_Name;
	private JTextField txtL_Name;
	private JTextField txtU_Name;
	private JTextField txtPhone;
	private JPasswordField txtPass;
	private JLabel hideIcn;
	private JLabel accLbl;
	private JLabel phIcon;
	boolean phoneIsValid = false;
	boolean passIsValid = false;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup_Screen frame = new Signup_Screen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//	GUI 
	public Signup_Screen() {
		setTitle("Create an account");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(Signup_Screen.class.getResource("/Images/shah-abdul-latif-university-logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 548);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(245, 255, 250), new Color(245, 255, 250),
				new Color(245, 255, 250), new Color(245, 255, 250)));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		txt_F_Name = new JTextField();
		txt_F_Name.setBackground(new Color(245, 255, 250));
		txt_F_Name.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		txt_F_Name.setForeground(new Color(0, 0, 0));
		txt_F_Name.setFont(new Font("SansSerif", Font.BOLD, 14));
		txt_F_Name.setBounds(320, 81, 264, 28);
		contentPane.add(txt_F_Name);
		txt_F_Name.setColumns(10);

		txtL_Name = new JTextField();
		txtL_Name.setBackground(new Color(245, 255, 250));
		txtL_Name.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		txtL_Name.setFont(new Font("SansSerif", Font.BOLD, 14));
		txtL_Name.setForeground(new Color(0, 0, 0));
		txtL_Name.setBounds(320, 146, 264, 28);
		contentPane.add(txtL_Name);
		txtL_Name.setColumns(10);

		txtU_Name = new JTextField();
		txtU_Name.setBackground(new Color(245, 255, 250));
		txtU_Name.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		txtU_Name.setFont(new Font("SansSerif", Font.BOLD, 14));
		txtU_Name.setForeground(new Color(0, 0, 0));
		txtU_Name.setColumns(10);
		txtU_Name.setBounds(320, 214, 264, 28);
		contentPane.add(txtU_Name);

		txtPhone = new JTextField();
		txtPhone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				phonePattern();
			}
		});
		txtPhone.setBackground(new Color(245, 255, 250));
		txtPhone.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		txtPhone.setForeground(new Color(0, 0, 0));
		txtPhone.setFont(new Font("SansSerif", Font.BOLD, 14));
		txtPhone.setColumns(10);
		txtPhone.setBounds(320, 337, 264, 28);
		contentPane.add(txtPhone);

		JLabel txtF_Name = new JLabel("First Name");
		txtF_Name.setForeground(new Color(255, 255, 255));
		txtF_Name.setFont(new Font("SansSerif", Font.BOLD, 14));
		txtF_Name.setBounds(320, 59, 76, 21);
		contentPane.add(txtF_Name);

		txtPass = new JPasswordField();

		txtPass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				passPattern();

			}
		});
		txtPass.setBackground(new Color(245, 255, 250));
		txtPass.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		txtPass.setForeground(new Color(0, 0, 0));
		txtPass.setFont(new Font("SansSerif", Font.BOLD, 14));
		txtPass.setBounds(320, 275, 264, 28);
		contentPane.add(txtPass);

		JLabel lblL_Name = new JLabel("Last Name");
		lblL_Name.setForeground(new Color(255, 255, 255));
		lblL_Name.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblL_Name.setBounds(320, 125, 76, 21);
		contentPane.add(lblL_Name);

		JLabel lblU_Name = new JLabel("User Name");
		lblU_Name.setForeground(new Color(255, 255, 255));
		lblU_Name.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblU_Name.setBounds(320, 192, 76, 21);
		contentPane.add(lblU_Name);

		JLabel lblPass = new JLabel("Password");
		lblPass.setForeground(new Color(255, 255, 255));
		lblPass.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblPass.setBounds(320, 253, 71, 21);
		contentPane.add(lblPass);

		JLabel lblPhone = new JLabel("Phone No.");
		lblPhone.setForeground(new Color(255, 255, 255));
		lblPhone.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblPhone.setBounds(320, 314, 76, 21);
		contentPane.add(lblPhone);

		JLabel visibleIcn = new JLabel("");
		visibleIcn.setIcon(new ImageIcon(Signup_Screen.class.getResource("/Images/show.png")));

		visibleIcn.addMouseListener(new MouseAdapter() {
			// Showing password
			@Override
			public void mousePressed(MouseEvent e) {
				visibleIcn.setVisible(false);
				hideIcn.setVisible(true);
				txtPass.setEchoChar((char) 0);

			}
		});
		visibleIcn.setBounds(594, 277, 24, 24);
		contentPane.add(visibleIcn);

		hideIcn = new JLabel("");
		// Hiding password
		hideIcn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				visibleIcn.setVisible(true);
				hideIcn.setVisible(false);
				txtPass.setEchoChar('*');
			}
		});
		hideIcn.setVisible(false);
		hideIcn.setIcon(new ImageIcon(Signup_Screen.class.getResource("/Images/hide.png")));
		hideIcn.setBounds(594, 277, 24, 24);
		contentPane.add(hideIcn);

		accLbl = new JLabel("I've an account");
		accLbl.setForeground(new Color(255, 255, 255));
		accLbl.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		accLbl.setBounds(426, 463, 98, 14);
		contentPane.add(accLbl);
//	    Login validation from database.
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login_Screen ls = new Login_Screen();
				setVisible(false);
				ls.setVisible(true);
			}
		});
		btnLogin.setForeground(new Color(245, 255, 250));
		btnLogin.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnLogin.setBackground(new Color(0, 0, 0));
		btnLogin.setBounds(529, 459, 91, 23);
		btnLogin.setBorder(
				new BevelBorder(BevelBorder.LOWERED, new Color(245, 255, 250), new Color(245, 255, 250), null, null));
		contentPane.add(btnLogin);

		phIcon = new JLabel("");
		phIcon.setBounds(582, 339, 24, 24);
		contentPane.add(phIcon);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(245, 255, 250), new Color(245, 255, 250),
				new Color(245, 255, 250), new Color(245, 255, 250)));
		panel.setBackground(new Color(245, 255, 250));
		panel.setBounds(0, 0, 289, 509);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel icn2 = new JLabel("");
		icn2.setIcon(new ImageIcon(Signup_Screen.class.getResource("/Images/signu2.png")));
		icn2.setBounds(31, 241, 97, 97);
		panel.add(icn2);

		JLabel icn3 = new JLabel("");
		icn3.setIcon(new ImageIcon(Signup_Screen.class.getResource("/Images/signu.png")));
		icn3.setBounds(157, 252, 97, 97);
		panel.add(icn3);

		JLabel icn1 = new JLabel("");
		icn1.setIcon(new ImageIcon(Signup_Screen.class.getResource("/Images/unii.png")));
		icn1.setBounds(94, 115, 97, 97);
		panel.add(icn1);
		// Registration logic from DB
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getTextAndStoreIntoDB();

			}
		});
		btnRegister.setForeground(new Color(245, 255, 250));
		btnRegister.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnRegister.setBorder(
				new BevelBorder(BevelBorder.LOWERED, new Color(245, 255, 250), new Color(245, 255, 250), null, null));
		btnRegister.setBackground(Color.BLACK);
		btnRegister.setBounds(320, 385, 91, 28);
		contentPane.add(btnRegister);
	}

	private void getTextAndStoreIntoDB() {
		String fName = txt_F_Name.getText();
		String lName = txtL_Name.getText();
		String uName = txtU_Name.getText();
		String pass = txtPass.getText();
		String phone = txtPhone.getText();
//			if validation is not correct than show error message.
		try {
			if (!phoneIsValid) {
				JOptionPane.showMessageDialog(Signup_Screen.this, "Phone Number Is not valid", "Message",
						JOptionPane.ERROR_MESSAGE);
			} else if (!passIsValid) {
				JOptionPane.showMessageDialog(Signup_Screen.this,
						"Password contains minimum 8 chars and 1 Captial and 1 Number ", "Message",
						JOptionPane.ERROR_MESSAGE);
			} else {

				DBConnection con = new DBConnection();
				String query = "insert into login_data (first_name,last_name,user_name,password,phone) values ('"
						+ fName + "','" + lName + "','" + uName + "','" + pass + "','" + phone + "')";
				con.statement.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Details Successfully Added!");
				setVisible(false);
				Login_Screen ls = new Login_Screen();
				ls.setVisible(true);
			}

		} catch (Exception e1) {
			e1.printStackTrace();

		}

	}

	private void passPattern() {
//		Password Validation
//		must contain A capital letter and a number and password should be minimum 8 characters long
		String regex = "^(?=.*[A-Z])(?=.*[0-9]).{8,}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(txtPass.getText());
		if (!matcher.matches()) {
			passIsValid = false;
		} else {
			passIsValid = true;
		}
	}

	private void phonePattern() {
//		Phone number validation (923134322286) OR (03134322286) if number starts with 92 then 13 digits 
//		if number starts with 03 then number should be 11 digits.
//		also number should starting from this (030,031,032,033,034) 035 is incorrect
//		and this condition is also for starting number with 92.
		

		String regex = "^923[0-4]\\d{8}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(txtPhone.getText());
		String regex1 = "^03[0-4]\\d{8}$";
		Pattern pattern1 = Pattern.compile(regex1);
		Matcher matcher1 = pattern1.matcher(txtPhone.getText());
		if (!matcher.matches() && !matcher1.matches()) {
			phIcon.setIcon(new ImageIcon(Signup_Screen.class.getResource("/Images/wr2.png")));

		} else {
			phIcon.setIcon(new ImageIcon(Signup_Screen.class.getResource("/Images/yes1.png")));
			phoneIsValid = true;
		}
	}
}
