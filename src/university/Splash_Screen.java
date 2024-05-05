package university;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;

public class Splash_Screen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Login_Screen ms = new Login_Screen();


	//main method
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Splash_Screen frame = new Splash_Screen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

     //GUI Logic
	public Splash_Screen() {
		setForeground(new Color(0, 0, 0));
		setTitle("Shah Abdul Latif Bhitai University");
		setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Splash_Screen.class.getResource("/Images/shah-abdul-latif-university-logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 887, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel imgLbl = new JLabel("");
		//Screen Change While Clicking Anywhere on screen
		imgLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				ms.setVisible(true);
			}
		});
		imgLbl.setForeground(new Color(0, 0, 0));
		imgLbl.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 17));
		imgLbl.setIcon(new ImageIcon(Splash_Screen.class.getResource("/Images/uniImg.jpg")));
		imgLbl.setBounds(0, 0, 871, 511);
		contentPane.add(imgLbl);
		
		JButton continueBtn = new JButton("Press Anywhere To Continue");
		continueBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ms.setVisible(true);
			}
		});
		continueBtn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		continueBtn.setForeground(new Color(0, 0, 0));
		continueBtn.setBackground(new Color(192, 192, 192));
		continueBtn.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		continueBtn.setBounds(73, 77, 229, 34);
		contentPane.add(continueBtn);
		

		
		
		

		
	}
}
