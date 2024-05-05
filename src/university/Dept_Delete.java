package university;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Choice;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class Dept_Delete extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNameAns;
	private JComboBox comboID;
	DBConnection con = new DBConnection();
	
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dept_Delete frame = new Dept_Delete();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Dept_Delete() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Dept_Delete.class.getResource("/Images/uniLogo.png")));
		setTitle("Delete Department");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 417);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setForeground(new Color(105, 105, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);

		JLabel lblUpdate = new JLabel("DELETE DEPARTMENT");
		lblUpdate.setForeground(Color.WHITE);
		lblUpdate.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblUpdate.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(105, 105, 105), new Color(105, 105, 105),
				new Color(255, 255, 255), new Color(255, 255, 255)));
		lblUpdate.setBounds(124, 57, 207, 36);
		contentPane.add(lblUpdate);

		JLabel lblName = new JLabel("Name :");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblName.setBounds(79, 216, 54, 29);
		contentPane.add(lblName);

		JLabel lblId = new JLabel("ID :");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblId.setBounds(56, 143, 26, 21);
		contentPane.add(lblId);

		JButton btnDlt = new JButton("DELETE");
		btnDlt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteDept();
			}
		});
		lblNameAns = new JLabel("");
		lblNameAns.setForeground(Color.WHITE);
		lblNameAns.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblNameAns.setBounds(136, 216, 225, 29);
		contentPane.add(lblNameAns);

		btnDlt.setForeground(new Color(245, 255, 250));
		btnDlt.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		btnDlt.setBorder(
				new BevelBorder(BevelBorder.LOWERED, new Color(245, 255, 250), new Color(245, 255, 250), null, null));
		btnDlt.setBackground(Color.BLACK);
		btnDlt.setBounds(174, 309, 107, 28);
		contentPane.add(btnDlt);

		comboID = new JComboBox();
		comboID.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				updateItem();
			}
		});
		comboID.setForeground(Color.BLACK);
		comboID.setFont(new Font("SansSerif", Font.BOLD, 14));
		comboID.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		comboID.setBackground(SystemColor.inactiveCaptionBorder);
		comboID.setBounds(92, 141, 96, 25);
		contentPane.add(comboID);
		
		JButton backBtn = new JButton("");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backBtn();
			}
		});
		backBtn.setIcon(new ImageIcon(Dept_Delete.class.getResource("/Images/backSmall.png")));
		backBtn.setForeground(UIManager.getColor("Button.darkShadow"));
		backBtn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		backBtn.setBorder(null);
		backBtn.setBackground(new Color(105, 105, 105));
		backBtn.setBounds(10, 11, 30, 30);
		contentPane.add(backBtn);
		
		JLabel lblBack = new JLabel("Back");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				backBtn();
			}
		});
		lblBack.setForeground(Color.WHITE);
		lblBack.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblBack.setBounds(42, 17, 40, 18);
		contentPane.add(lblBack);
		
		

		getDeptID();
		updateItem();

	}

	private void updateItem() {
		try {
			String query = "select department from department where dept_ID = '" + comboID.getSelectedItem() + "'";
			ResultSet rs = con.statement.executeQuery(query);
			while (rs.next()) {
				lblNameAns.setText(rs.getString("department"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getDeptID() {
		List<String> deptID = new ArrayList<>();
		//  Getting dept from DB and insert into JComboBox
		try {
			String query = "select dept_id from department";
			ResultSet rs = con.statement.executeQuery(query);
			while (rs.next()) {
				deptID.add(rs.getString("Dept_ID"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String arr[] = new String[deptID.size()];
		int i = 0;
		for (String type : deptID) {
			arr[i] = type;
			i++;
		}

		comboID.setModel(new DefaultComboBoxModel(arr));
	}
	private void deleteDept() {
		try {
			String query = "delete from department where Dept_ID = '" + comboID.getSelectedItem() + "'";
			con.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Department Deleted Successfully!");
			setVisible(false);
			Dept_Screen ds = new Dept_Screen();
			ds.setVisible(true);

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	private void backBtn() {
		setVisible(false);
		Dept_Screen ds = new Dept_Screen();
		ds.setVisible(true);
	}
}
