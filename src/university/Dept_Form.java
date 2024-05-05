package university;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Choice;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class Dept_Form extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JComboBox comboHOD;
	DBConnection con = new DBConnection();
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dept_Form frame = new Dept_Form();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Dept_Form() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Dept_Form.class.getResource("/Images/uniLogo.png")));
		setTitle("Add Department");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 411);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);

		txtName = new JTextField();
		txtName.setForeground(Color.BLACK);
		txtName.setFont(new Font("SansSerif", Font.BOLD, 14));
		txtName.setColumns(10);
		txtName.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		txtName.setBackground(Color.WHITE);
		txtName.setBounds(125, 149, 204, 28);
		contentPane.add(txtName);

		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblName.setBounds(204, 127, 47, 21);
		contentPane.add(lblName);

		JLabel lblHOD = new JLabel("Head Of Dept");
		lblHOD.setForeground(Color.WHITE);
		lblHOD.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblHOD.setBounds(177, 202, 100, 21);
		contentPane.add(lblHOD);

		JLabel lblHeading = new JLabel("REGISTRATION");
		lblHeading.setForeground(Color.WHITE);
		lblHeading.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblHeading.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(105, 105, 105), new Color(105, 105, 105),new Color(255, 255, 255), new Color(255, 255, 255)));
		lblHeading.setBounds(154, 47, 146, 36);
		contentPane.add(lblHeading);

		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertData();
			}

		});
		btnSubmit.setBounds(174, 307, 107, 28);
		contentPane.add(btnSubmit);
		btnSubmit.setForeground(new Color(245, 255, 250));
		btnSubmit.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		btnSubmit.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(245, 255, 250), new Color(245, 255, 250), null, null));
		btnSubmit.setBackground(Color.BLACK);

		comboHOD = new JComboBox();
		comboHOD.setForeground(Color.BLACK);
		comboHOD.setFont(new Font("SansSerif", Font.BOLD, 14));
		comboHOD.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		comboHOD.setBackground(SystemColor.inactiveCaptionBorder);
		comboHOD.setBounds(125, 223, 204, 28);
		contentPane.add(comboHOD);

		JButton backBtn = new JButton("");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Dept_Screen ds = new Dept_Screen();
				ds.setVisible(true);

			}
		});
		backBtn.setForeground(UIManager.getColor("Button.darkShadow"));
		backBtn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		backBtn.setBorder(null);
		backBtn.setBackground(new Color(105, 105, 105));
		backBtn.setBounds(10, 11, 30, 30);
		backBtn.setIcon(new ImageIcon(Stu_Update.class.getResource("/Images/backSmall.png")));
		contentPane.add(backBtn);

		JLabel lblBack = new JLabel("Back");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				Dept_Screen ds = new Dept_Screen();
				ds.setVisible(true);

			}
		});
		lblBack.setForeground(Color.WHITE);
		lblBack.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblBack.setBounds(46, 17, 40, 18);
		contentPane.add(lblBack);
		
		getHOD();

	}

	private void getHOD() {
		List<String> hod = new ArrayList<>();
		//  Getting headofdept from DB and insert into JComboBox
		try {
			String query1 = "select employee from employee where emp_Type = 'Head Of Dept'";
			ResultSet rs = con.statement.executeQuery(query1);
			while (rs.next()) {
				hod.add(rs.getString("employee"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String arr[] = new String[hod.size()];
		int i = 0;
		for (String type : hod) {
			arr[i] = type;
			i++;
		}

		comboHOD.setModel(new DefaultComboBoxModel(arr));

	}

	private void insertData() {
		String name = txtName.getText();
		String hod = (String) comboHOD.getSelectedItem();
		try {
			String query = "insert into department(Department,HOD) values ('" + name + "','" + hod + "')";
			con.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Details Successfully Added!");
			setVisible(false);
			Dept_Screen ds = new Dept_Screen();
			ds.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
