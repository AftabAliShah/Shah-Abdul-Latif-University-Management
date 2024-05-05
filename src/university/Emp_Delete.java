package university;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.DesignMode;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Choice;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Emp_Delete extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblCnicAns;
	private JLabel lblFNameAns;
	private JLabel lblDesigAns;
	private JLabel lblNameAns;
	private JComboBox comboID;
	DBConnection con = new DBConnection();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Emp_Delete frame = new Emp_Delete();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Emp_Delete() {
		setTitle("Delete Employe");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Emp_Delete.class.getResource("/Images/uniLogo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, -13, 469, 531);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblHeading = new JLabel("DELETE EMPLOYE");
		lblHeading.setForeground(new Color(255, 255, 255));
		lblHeading.setFont(new Font("Verdana", Font.BOLD, 19));
		lblHeading.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(105, 105, 105), new Color(105, 105, 105),
				new Color(255, 255, 255), new Color(255, 255, 255)));
		lblHeading.setBounds(128, 44, 196, 36);
		contentPane.add(lblHeading);

		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblName.setBounds(207, 147, 39, 21);
		contentPane.add(lblName);

		JLabel lblDesignation = new JLabel("Deisgnation");
		lblDesignation.setForeground(Color.WHITE);
		lblDesignation.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDesignation.setBounds(184, 276, 84, 21);
		contentPane.add(lblDesignation);

		JLabel lblFName = new JLabel("Father's Name");
		lblFName.setForeground(Color.WHITE);
		lblFName.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblFName.setBounds(176, 218, 100, 21);
		contentPane.add(lblFName);

		JLabel lblCnicNo = new JLabel("CNIC No.");
		lblCnicNo.setForeground(Color.WHITE);
		lblCnicNo.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCnicNo.setBounds(196, 335, 61, 21);
		contentPane.add(lblCnicNo);

		JButton btnDlt = new JButton("DELETE");
		btnDlt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteData();
			}
		});
		btnDlt.setForeground(new Color(245, 255, 250));
		btnDlt.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		btnDlt.setBorder(
				new BevelBorder(BevelBorder.LOWERED, new Color(245, 255, 250), new Color(245, 255, 250), null, null));
		btnDlt.setBackground(Color.BLACK);
		btnDlt.setBounds(173, 421, 107, 28);
		contentPane.add(btnDlt);

		JLabel lblId = new JLabel("ID :");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblId.setBounds(42, 114, 30, 21);
		contentPane.add(lblId);

		lblNameAns = new JLabel("");
		lblNameAns.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameAns.setForeground(Color.WHITE);
		lblNameAns.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblNameAns.setBounds(90, 168, 273, 28);
		contentPane.add(lblNameAns);

		lblDesigAns = new JLabel("");
		lblDesigAns.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesigAns.setForeground(Color.WHITE);
		lblDesigAns.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblDesigAns.setBounds(90, 296, 273, 28);
		contentPane.add(lblDesigAns);

		lblFNameAns = new JLabel("");
		lblFNameAns.setHorizontalAlignment(SwingConstants.CENTER);
		lblFNameAns.setForeground(Color.WHITE);
		lblFNameAns.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblFNameAns.setBounds(90, 237, 273, 28);
		contentPane.add(lblFNameAns);

		lblCnicAns = new JLabel("");
		lblCnicAns.setHorizontalAlignment(SwingConstants.CENTER);
		lblCnicAns.setForeground(Color.WHITE);
		lblCnicAns.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblCnicAns.setBounds(90, 354, 273, 28);
		contentPane.add(lblCnicAns);

		comboID = new JComboBox();
		comboID.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				setDataIntoLabel();
			}
		});
		comboID.setForeground(Color.BLACK);
		comboID.setFont(new Font("SansSerif", Font.BOLD, 14));
		comboID.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		comboID.setBackground(SystemColor.inactiveCaptionBorder);
		comboID.setBounds(72, 112, 84, 25);
		contentPane.add(comboID);

		JButton backBtn = new JButton("");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		backBtn.setIcon(new ImageIcon(Emp_Delete.class.getResource("/Images/backSmall.png")));
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
				back();
			}
		});
		lblBack.setForeground(Color.WHITE);
		lblBack.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblBack.setBounds(42, 17, 40, 18);
		contentPane.add(lblBack);

		getEmpID();
		// For Set Text into label
		setDataIntoLabel();

	}

	private void deleteData() {
		try {
			String query = "delete from Employee where Emp_ID = '" + comboID.getSelectedItem() + "'";
			con.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Employee Details Deleted Successfully!");
			setVisible(false);
			Emp_Screen es = new Emp_Screen();
			es.setVisible(true);

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	private void setDataIntoLabel() {
		try {
			String query = "select employee,Designation,Father_Name,Cnic from employee where emp_id = '"
					+ comboID.getSelectedItem() + "'";
			ResultSet rs = con.statement.executeQuery(query);
			while (rs.next()) {
				lblNameAns.setText(rs.getString("Employee"));
				lblDesigAns.setText(rs.getString("Designation"));
				lblFNameAns.setText(rs.getString("Father_Name"));
				lblCnicAns.setText(rs.getString("Cnic"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void getEmpID() {
		List<String> empID = new ArrayList<>();
		// Getting ID from DB and insert into JComboBox
		try {
			String query1 = "select emp_id from employee";
			ResultSet rs = con.statement.executeQuery(query1);
			while (rs.next()) {
				empID.add(rs.getString("emp_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String arr[] = new String[empID.size()];
		int i = 0;
		for (String type : empID) {
			arr[i] = type;
			i++;
		}

		comboID.setModel(new DefaultComboBoxModel(arr));

	}

	private void back() {
		setVisible(false);
		Emp_Screen es = new Emp_Screen();
		es.setVisible(true);
	}
}
