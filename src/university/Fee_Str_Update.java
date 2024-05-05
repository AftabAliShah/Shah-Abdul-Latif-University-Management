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
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class Fee_Str_Update extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtAmount;
	private JComboBox comboDept;
	private JLabel lblIDA;
	DBConnection con = new DBConnection();
	String id;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fee_Str_Update frame = new Fee_Str_Update("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Fee_Str_Update(String id) {
		this.id = id;
		setIconImage(Toolkit.getDefaultToolkit().getImage(Fee_Str_Update.class.getResource("/Images/uniLogo.png")));
		setTitle("Add Department");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 402);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);

		txtAmount = new JTextField();
		txtAmount.setForeground(Color.BLACK);
		txtAmount.setFont(new Font("SansSerif", Font.BOLD, 14));
		txtAmount.setColumns(10);
		txtAmount.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		txtAmount.setBackground(Color.WHITE);
		txtAmount.setBounds(114, 149, 204, 28);
		contentPane.add(txtAmount);

		JLabel lblAmount = new JLabel("Amount / Semester");
		lblAmount.setForeground(Color.WHITE);
		lblAmount.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblAmount.setBounds(147, 127, 137, 21);
		contentPane.add(lblAmount);

		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setForeground(Color.WHITE);
		lblDepartment.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblDepartment.setBounds(174, 202, 83, 21);
		contentPane.add(lblDepartment);

		JLabel lblHeading = new JLabel("FEE STRUCTURE FORM");
		lblHeading.setForeground(Color.WHITE);
		lblHeading.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblHeading.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(105, 105, 105), new Color(105, 105, 105),
				new Color(255, 255, 255), new Color(255, 255, 255)));
		lblHeading.setBounds(109, 47, 214, 36);
		contentPane.add(lblHeading);

		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateData();
			}

		});
		btnSubmit.setBounds(162, 294, 107, 28);
		contentPane.add(btnSubmit);
		btnSubmit.setForeground(new Color(245, 255, 250));
		btnSubmit.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		btnSubmit.setBorder(
				new BevelBorder(BevelBorder.LOWERED, new Color(245, 255, 250), new Color(245, 255, 250), null, null));
		btnSubmit.setBackground(Color.BLACK);

		comboDept = new JComboBox();
		comboDept.setForeground(Color.BLACK);
		comboDept.setFont(new Font("SansSerif", Font.BOLD, 14));
		comboDept.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		comboDept.setBackground(SystemColor.inactiveCaptionBorder);
		comboDept.setBounds(114, 223, 204, 28);
		contentPane.add(comboDept);

		JButton backBtn = new JButton("");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Fee_Str_Screen fts = new Fee_Str_Screen();
				fts.setVisible(true);
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
				Fee_Str_Screen fts = new Fee_Str_Screen();
				fts.setVisible(true);
			}
		});
		lblBack.setForeground(Color.WHITE);
		lblBack.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblBack.setBounds(46, 17, 40, 18);
		contentPane.add(lblBack);

		JLabel lblID = new JLabel("ID :");
		lblID.setForeground(Color.WHITE);
		lblID.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblID.setBounds(33, 109, 30, 21);
		contentPane.add(lblID);

		lblIDA = new JLabel("");
		lblIDA.setForeground(Color.WHITE);
		lblIDA.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblIDA.setBounds(63, 109, 60, 21);
		contentPane.add(lblIDA);

		setText();
		getDept();

	}

	private void getDept() {
		List<String> dept = new ArrayList<>();
		// Getting Department from DB and insert into JComboBox
		try {
			String query1 = "select department from department";
			ResultSet rs = con.statement.executeQuery(query1);
			while (rs.next()) {
				dept.add(rs.getString("department"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String arr[] = new String[dept.size()];
		int i = 0;
		for (String type : dept) {
			arr[i] = type;
			i++;
		}

		comboDept.setModel(new DefaultComboBoxModel(arr));

	}

	private void updateData() {
		String amount = txtAmount.getText();
		String dept = (String) comboDept.getSelectedItem();
		try {
			String query = "update fee_structure set department = '" + dept + "', amount_per_sems = '" + amount + "' where fee_str_id = '" + id + "'";
			con.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Details Successfully Updated!");
			setVisible(false);
			Fee_Str_Screen fts = new Fee_Str_Screen();
			fts.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	private void setText() {
		try {
			String query = "select fee_str_id,amount_per_sems from fee_structure where fee_str_id  = '" + id + "'";
			ResultSet rs = con.statement.executeQuery(query);
			while (rs.next()) {
				lblIDA.setText(rs.getString("fee_str_id"));
				txtAmount.setText(rs.getString("amount_per_sems"));

			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

}
