package university;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class Leave_Options extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Leave_Options frame = new Leave_Options();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Leave_Options() {
		setTitle("Leave Options");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Leave_Options.class.getResource("/Images/uniLogo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 408, 302);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JLabel lblHeading = new JLabel("Options");
		lblHeading.setForeground(Color.WHITE);
		lblHeading.setFont(new Font("Verdana", Font.BOLD, 17));
		lblHeading.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(105, 105, 105), new Color(105, 105, 105),
				new Color(255, 255, 255), new Color(255, 255, 255)));
		lblHeading.setBounds(154, 30, 83, 36);
		contentPane.add(lblHeading);

		JButton backBtn = new JButton("");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Main_Screen ms = new Main_Screen();
				ms.setVisible(true);
			}
		});
		backBtn.setIcon(new ImageIcon(Leave_Options.class.getResource("/Images/backSmall.png")));
		backBtn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		backBtn.setBorder(null);
		backBtn.setBackground(new Color(105, 105, 105));
		backBtn.setBounds(10, 11, 28, 28);
		contentPane.add(backBtn);

		JLabel lblBack = new JLabel("Back");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Main_Screen ms = new Main_Screen();
				ms.setVisible(true);
			}
		});
		lblBack.setForeground(Color.WHITE);
		lblBack.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblBack.setBounds(41, 16, 40, 18);
		contentPane.add(lblBack);

		JButton btnStudent = new JButton("");
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Stu_Leave_Screen sls = new Stu_Leave_Screen();
				sls.setVisible(true);
			}
		});
		btnStudent.setIcon(new ImageIcon(Leave_Options.class.getResource("/Images/stuLeave.png")));
		btnStudent.setForeground(new Color(255, 255, 224));
		btnStudent.setBorder(null);
		btnStudent.setBackground(new Color(105, 105, 105));
		btnStudent.setBounds(239, 97, 100, 100);
		contentPane.add(btnStudent);

		JButton btnEmploye = new JButton("");
		btnEmploye.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Emp_Leave_Screen els = new Emp_Leave_Screen();
				els.setVisible(true);
			}
		});
		btnEmploye.setIcon(new ImageIcon(Leave_Options.class.getResource("/Images/lave.png")));
		btnEmploye.setBorder(null);
		btnEmploye.setBackground(new Color(105, 105, 105));
		btnEmploye.setBounds(65, 97, 100, 100);
		contentPane.add(btnEmploye);

		JLabel lblEmp = new JLabel("Employe");
		lblEmp.setForeground(new Color(245, 255, 250));
		lblEmp.setFont(new Font("SansSerif", Font.BOLD, 17));
		lblEmp.setBounds(82, 204, 67, 23);
		contentPane.add(lblEmp);

		JLabel lblStudent = new JLabel("Student");
		lblStudent.setForeground(new Color(245, 255, 250));
		lblStudent.setFont(new Font("SansSerif", Font.BOLD, 17));
		lblStudent.setBounds(258, 201, 62, 28);
		contentPane.add(lblStudent);

	}

}
