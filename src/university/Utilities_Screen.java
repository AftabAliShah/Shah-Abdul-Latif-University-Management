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

public class Utilities_Screen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Utilities_Screen frame = new Utilities_Screen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Utilities_Screen() {
		setTitle("Utilties");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Utilities_Screen.class.getResource("/Images/uniLogo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 408, 302);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JButton backBtn = new JButton("");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Main_Screen ms = new Main_Screen();
				ms.setVisible(true);
			}
		});
		backBtn.setIcon(new ImageIcon(Utilities_Screen.class.getResource("/Images/backSmall.png")));
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

		JButton btnCalculcator = new JButton("");
		btnCalculcator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Runtime.getRuntime().exec("calc.exe");
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCalculcator.setIcon(new ImageIcon(Utilities_Screen.class.getResource("/Images/calc.png")));
		btnCalculcator.setForeground(new Color(255, 255, 224));
		btnCalculcator.setBorder(null);
		btnCalculcator.setBackground(new Color(105, 105, 105));
		btnCalculcator.setBounds(239, 77, 100, 100);
		contentPane.add(btnCalculcator);

		JButton btnNotepad = new JButton("");
		btnNotepad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Runtime.getRuntime().exec("notepad.exe");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNotepad.setIcon(new ImageIcon(Utilities_Screen.class.getResource("/Images/notepad.png")));
		btnNotepad.setBorder(null);
		btnNotepad.setBackground(new Color(105, 105, 105));
		btnNotepad.setBounds(65, 77, 100, 100);
		contentPane.add(btnNotepad);

		JLabel lblNotepad = new JLabel("Notepad");
		lblNotepad.setForeground(new Color(245, 255, 250));
		lblNotepad.setFont(new Font("SansSerif", Font.BOLD, 17));
		lblNotepad.setBounds(75, 188, 67, 23);
		contentPane.add(lblNotepad);

		JLabel lblCalc = new JLabel("Calculator");
		lblCalc.setForeground(new Color(245, 255, 250));
		lblCalc.setFont(new Font("SansSerif", Font.BOLD, 17));
		lblCalc.setBounds(249, 185, 81, 28);
		contentPane.add(lblCalc);

	}

}
