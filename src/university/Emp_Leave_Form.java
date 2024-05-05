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
import java.beans.DesignMode;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.Choice;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Emp_Leave_Form extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox comboID;
	private JComboBox comboDuration;
	private JDateChooser dateChooser;
	private JLabel lblNameA;
	private JLabel lblFNameA;
	private JLabel lblCnicA;
	DBConnection con = new DBConnection();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Emp_Leave_Form frame = new Emp_Leave_Form();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Emp_Leave_Form() {
		setTitle("Apply Leave");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Emp_Leave_Form.class.getResource("/Images/uniLogo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, -13, 457, 494);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblHeading = new JLabel("APPLY LEAVE");
		lblHeading.setForeground(new Color(255, 255, 255));
		lblHeading.setFont(new Font("Verdana", Font.BOLD, 19));
		lblHeading.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(105, 105, 105), new Color(105, 105, 105),
				new Color(255, 255, 255), new Color(255, 255, 255)));
		lblHeading.setBounds(142, 40, 156, 36);
		contentPane.add(lblHeading);

		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setForeground(Color.WHITE);
		lblDuration.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDuration.setBounds(88, 280, 69, 21);
		contentPane.add(lblDuration);

		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertData();

			}
		});
		btnSubmit.setForeground(new Color(245, 255, 250));
		btnSubmit.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 14));
		btnSubmit.setBorder(
				new BevelBorder(BevelBorder.LOWERED, new Color(245, 255, 250), new Color(245, 255, 250), null, null));
		btnSubmit.setBackground(Color.BLACK);
		btnSubmit.setBounds(167, 382, 107, 28);
		contentPane.add(btnSubmit);

		JButton backBtn = new JButton("");
		backBtn.setIcon(new ImageIcon(Emp_Leave_Form.class.getResource("/Images/backSmall.png")));
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		backBtn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		backBtn.setBorder(null);
		backBtn.setBackground(new Color(105, 105, 105));
		backBtn.setBounds(10, 11, 28, 28);
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
		lblBack.setBounds(41, 16, 40, 18);
		contentPane.add(lblBack);

		comboID = new JComboBox();
		comboID.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				setEmpText();
			}
		});
		comboID.setForeground(Color.BLACK);
		comboID.setFont(new Font("SansSerif", Font.BOLD, 14));
		comboID.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		comboID.setBackground(new Color(245, 255, 250));
		comboID.setBounds(59, 111, 113, 28);
		contentPane.add(comboID);

		JLabel lblID = new JLabel("ID :");
		lblID.setForeground(Color.WHITE);
		lblID.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblID.setBounds(31, 115, 28, 21);
		contentPane.add(lblID);

		comboDuration = new JComboBox();
		comboDuration.setModel(new DefaultComboBoxModel(
				new String[] { "1 Day", "2 Days", "3 Days", "4 Days", "For A Week", "For A Month" }));
		comboDuration.setForeground(Color.BLACK);
		comboDuration.setFont(new Font("SansSerif", Font.BOLD, 14));
		comboDuration
				.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		comboDuration.setBackground(SystemColor.inactiveCaptionBorder);
		comboDuration.setBounds(88, 301, 264, 28);
		contentPane.add(comboDuration);

		dateChooser = new JDateChooser();
		dateChooser.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		dateChooser.setBounds(273, 111, 128, 28);
		contentPane.add(dateChooser);

		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblDate.setBounds(235, 115, 33, 21);
		contentPane.add(lblDate);

		JLabel lblName = new JLabel("Name :");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblName.setBounds(88, 167, 50, 21);
		contentPane.add(lblName);

		lblNameA = new JLabel("");
		lblNameA.setForeground(Color.WHITE);
		lblNameA.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNameA.setBounds(142, 163, 194, 28);
		contentPane.add(lblNameA);
		
		JLabel lblFName = new JLabel("Father's Name :");
		lblFName.setForeground(Color.WHITE);
		lblFName.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblFName.setBounds(88, 206, 113, 21);
		contentPane.add(lblFName);
		
		lblFNameA = new JLabel("");
		lblFNameA.setForeground(Color.WHITE);
		lblFNameA.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblFNameA.setBounds(202, 202, 194, 28);
		contentPane.add(lblFNameA);
		
		JLabel lblCnic = new JLabel("CNIC :");
		lblCnic.setForeground(Color.WHITE);
		lblCnic.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCnic.setBounds(88, 243, 50, 21);
		contentPane.add(lblCnic);
		
		lblCnicA = new JLabel("");
		lblCnicA.setForeground(Color.WHITE);
		lblCnicA.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblCnicA.setBounds(142, 239, 194, 28);
		contentPane.add(lblCnicA);

		setEmpText();
		getID();

	}

	public void getID() {

		List<String> id = new ArrayList<>();
		// Getting roll no from DB and insert into JComboBox
		try {
			String query1 = "select emp_id from employee";
			ResultSet rs = con.statement.executeQuery(query1);
			while (rs.next()) {
				id.add(rs.getString("emp_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String arr[] = new String[id.size()];
		int i = 0;
		for (String type : id) {
			arr[i] = type;
			i++;
		}

		comboID.setModel(new DefaultComboBoxModel(arr));

	}

	private void insertData() {
		
		try {
			String duration = (String) comboDuration.getSelectedItem();
			String id = (String) comboID.getSelectedItem();
			String date = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();

			String query = "insert into employe_leave(date,duration,emp_id) values ('" + date + "','" + duration
					+ "','" + id + "')";
			con.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Leave Successfully Applied!");

			setVisible(false);
			new Emp_Leave_Screen().setVisible(true);
		}

		catch (Exception e1) {
			e1.printStackTrace();

		}

	}

	private void setEmpText() {
		try {

			String query = "select employee,father_name,cnic from employee where emp_id  = '" + comboID.getSelectedItem() + "'";
			ResultSet rs = con.statement.executeQuery(query);
			while (rs.next()) {
				lblNameA.setText(rs.getString("employee"));
				lblFNameA.setText(rs.getString("father_name"));
				lblCnicA.setText(rs.getString("cnic"));
				
				 
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void back() {
		setVisible(false);
		Emp_Leave_Screen els = new Emp_Leave_Screen();
		els.setVisible(true);
	}
}
