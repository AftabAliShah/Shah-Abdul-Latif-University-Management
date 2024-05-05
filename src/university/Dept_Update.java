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

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class Dept_Update extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JComboBox comboHOD;
	private JLabel lblIdAns;
	String deptID;
	DBConnection con = new DBConnection();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dept_Update frame = new Dept_Update("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Dept_Update(String deptID) {
		setTitle("Update Department");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Dept_Update.class.getResource("/Images/uniLogo.png")));
		this.deptID = deptID;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 439);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtName = new JTextField();
		txtName.setForeground(Color.BLACK);
		txtName.setFont(new Font("SansSerif", Font.BOLD, 14));
		txtName.setColumns(10);
		txtName.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		txtName.setBackground(Color.WHITE);
		txtName.setBounds(125, 181, 204, 28);
		contentPane.add(txtName);

		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblName.setBounds(204, 159, 47, 21);
		contentPane.add(lblName);

		JLabel lblHOD = new JLabel("Head Of Dept");
		lblHOD.setForeground(Color.WHITE);
		lblHOD.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblHOD.setBounds(177, 231, 100, 21);
		contentPane.add(lblHOD);

		comboHOD = new JComboBox();
		comboHOD.setForeground(Color.BLACK);
		comboHOD.setFont(new Font("SansSerif", Font.BOLD, 14));
		comboHOD.setBackground(new Color(245, 255, 250));
		comboHOD.setBounds(125, 252, 204, 28);
		contentPane.add(comboHOD);

		JLabel lblUpdate = new JLabel("UPDATE DEPARTMENT DETAILS");
		lblUpdate.setForeground(Color.WHITE);
		lblUpdate.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblUpdate.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(105, 105, 105), new Color(105, 105, 105),
				new Color(255, 255, 255), new Color(255, 255, 255)));
		lblUpdate.setBounds(82, 51, 291, 36);
		contentPane.add(lblUpdate);

		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateDept();
			}

		});
		btnUpdate.setBounds(174, 331, 107, 28);
		contentPane.add(btnUpdate);
		btnUpdate.setForeground(new Color(245, 255, 250));
		btnUpdate.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		btnUpdate.setBorder(
				new BevelBorder(BevelBorder.LOWERED, new Color(245, 255, 250), new Color(245, 255, 250), null, null));
		btnUpdate.setBackground(Color.BLACK);

		JLabel lblId = new JLabel("ID :");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblId.setBounds(43, 135, 26, 21);
		contentPane.add(lblId);

		lblIdAns = new JLabel("");
		lblIdAns.setForeground(Color.WHITE);
		lblIdAns.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblIdAns.setBounds(82, 135, 47, 21);
		contentPane.add(lblIdAns);
		
		JButton backBtn = new JButton("");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		backBtn.setIcon(new ImageIcon(Dept_Update.class.getResource("/Images/backSmall.png")));
		backBtn.setForeground(new Color(105, 105, 105));
		backBtn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		backBtn.setBorder(null);
		backBtn.setBackground(new Color(105, 105, 105));
		backBtn.setBounds(10, 11, 30, 30);
		contentPane.add(backBtn);
		
		JLabel lblBack = new JLabel("Back");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				back();
			}
		});
		lblBack.setForeground(Color.WHITE);
		lblBack.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblBack.setBounds(42, 17, 40, 18);
		contentPane.add(lblBack);

		setText();
		getHOD();
	}

	private void getHOD() {
		List<String> hod = new ArrayList<>();
		//  Getting type from DB and insert into JComboBox
		try {
			String query = "select employee from employee where emp_Type = 'Head Of Dept'";
			ResultSet rs = con.statement.executeQuery(query);
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

	private void updateDept() {
		String name = txtName.getText();
		String hod = (String) comboHOD.getSelectedItem();
		try {
			String query = "update department set department = '" + name + "', HOD = '" + hod + "' where dept_id = '"+deptID+"'";
			con.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Details Updated Successfully!");
		} catch (Exception e1) {
			e1.printStackTrace();

		}
		setVisible(false);
		new Dept_Screen().setVisible(true);
	}

	private void setText() {
		try {
			String query = "select dept_ID,Department, HOD from department where Dept_ID  = '" + deptID + "'";
			ResultSet rs = con.statement.executeQuery(query);
			while (rs.next()) {
				lblIdAns.setText(rs.getString("Dept_ID"));
				txtName.setText(rs.getString("Department"));

			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	private void back() {
		setVisible(false);
		Dept_Screen ds = new Dept_Screen();
		ds.setVisible(true);
	}
}
