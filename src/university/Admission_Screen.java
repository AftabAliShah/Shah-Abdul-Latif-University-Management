package university;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.UIManager;
import java.awt.Toolkit;

public class Admission_Screen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSearch;
	private JTable table;
	private JComboBox comboRollNo;
	private JButton btnView;

	DBConnection con = new DBConnection();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admission_Screen frame = new Admission_Screen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Admission_Screen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Admission_Screen.class.getResource("/Images/uniLogo.png")));
		setTitle("Admission");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 931, 584);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JButton backBtn = new JButton("");
		backBtn.setBackground(new Color(105, 105, 105));
		backBtn.setIcon(new ImageIcon(Admission_Screen.class.getResource("/Images/backSmall.png")));
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Main_Screen ms = new Main_Screen();
				ms.setVisible(true);
			}
		});
		backBtn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		backBtn.setBounds(10, 11, 28, 28);
		backBtn.setBorder(null);
		contentPane.add(backBtn);

		JLabel searchLabel = new JLabel("");
		searchLabel.setIcon(new ImageIcon(Admission_Screen.class.getResource("/Images/search.png")));
		searchLabel.setForeground(new Color(255, 255, 255));
		searchLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		searchLabel.setBounds(21, 104, 35, 35);
		contentPane.add(searchLabel);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				table.setSelectionForeground(Color.WHITE);
				table.setSelectionBackground(Color.DARK_GRAY);
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				txtSearch.setText(table.getModel().getValueAt(row, 0).toString());

			}
		});
		table.setForeground(new Color(0, 0, 0));
		table.getTableHeader().setForeground(Color.WHITE);
		table.getTableHeader().setBackground(Color.BLACK);
		table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
		table.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		table.setBackground(new Color(245, 255, 250));
		table.setFont(new Font("SansSerif", Font.BOLD, 14));
		table.setBounds(0, 161, 913, 384);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setViewportBorder(
				new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, new Color(0, 0, 0), null));
		scrollPane.setBounds(0, 162, 915, 386);
		scrollPane.setFont(new Font("SansSerif", Font.BOLD, 14));
		contentPane.add(scrollPane);

		JLabel lblHeading = new JLabel("ADMISSION");
		lblHeading.setForeground(Color.WHITE);
		lblHeading.setFont(new Font("Verdana", Font.BOLD, 19));
		lblHeading.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(105, 105, 105), new Color(105, 105, 105),
				new Color(255, 255, 255), new Color(255, 255, 255)));
		lblHeading.setBounds(388, 30, 139, 36);
		contentPane.add(lblHeading);

		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				searchText();

			}
		});
		txtSearch.setForeground(Color.BLACK);
		txtSearch.setFont(new Font("SansSerif", Font.BOLD, 14));
		txtSearch.setColumns(10);
		txtSearch.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		txtSearch.setBackground(new Color(245, 255, 250));
		txtSearch.setBounds(57, 107, 149, 28);
		contentPane.add(txtSearch);

		JButton btnDlt = new JButton("");
		btnDlt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Stu_Delete sd = new Stu_Delete();
				sd.setVisible(true);

			}
		});
		btnDlt.setIcon(new ImageIcon(Admission_Screen.class.getResource("/Images/delete.png")));
		btnDlt.setForeground(UIManager.getColor("Button.darkShadow"));
		btnDlt.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnDlt.setBorder(null);
		btnDlt.setBackground(new Color(105, 105, 105));
		btnDlt.setBounds(756, 104, 28, 28);
		contentPane.add(btnDlt);

		JLabel lblDlt = new JLabel("Delete");
		lblDlt.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				Stu_Delete sd = new Stu_Delete();
				sd.setVisible(true);
			}
		});
		lblDlt.setForeground(Color.WHITE);
		lblDlt.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblDlt.setBounds(789, 111, 52, 14);
		contentPane.add(lblDlt);

		JButton btnUpdate = new JButton("");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Stu_Update du = new Stu_Update(comboRollNo.getSelectedItem().toString());
				du.setVisible(true);
			}
		});
		btnUpdate.setIcon(new ImageIcon(Admission_Screen.class.getResource("/Images/update.png")));
		btnUpdate.setForeground(UIManager.getColor("Button.darkShadow"));
		btnUpdate.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnUpdate.setBorder(null);
		btnUpdate.setBackground(new Color(105, 105, 105));
		btnUpdate.setBounds(756, 64, 28, 28);
		contentPane.add(btnUpdate);

		comboRollNo = new JComboBox();
		comboRollNo.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		comboRollNo.setForeground(Color.BLACK);
		comboRollNo.setFont(new Font("SansSerif", Font.BOLD, 13));
		comboRollNo.setBackground(SystemColor.inactiveCaptionBorder);
		comboRollNo.setBounds(789, 66, 77, 25);
		contentPane.add(comboRollNo);

		JButton btnAdd = new JButton("");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Stu_Form af = new Stu_Form();
				af.setVisible(true);
			}
		});
		btnAdd.setIcon(new ImageIcon(Admission_Screen.class.getResource("/Images/add.png")));
		btnAdd.setForeground(UIManager.getColor("Button.darkShadow"));
		btnAdd.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnAdd.setBorder(null);
		btnAdd.setBackground(new Color(105, 105, 105));
		btnAdd.setBounds(756, 23, 28, 28);
		contentPane.add(btnAdd);

		JLabel lblAdd = new JLabel("New");
		lblAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				Stu_Form af = new Stu_Form();
				af.setVisible(true);
			}
		});
		lblAdd.setForeground(Color.WHITE);
		lblAdd.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblAdd.setBounds(789, 30, 43, 14);
		contentPane.add(lblAdd);

		JLabel lblBack = new JLabel("Back");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				Main_Screen ms = new Main_Screen();
				ms.setVisible(true);
			}
		});
		lblBack.setForeground(Color.WHITE);
		lblBack.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblBack.setBounds(41, 16, 40, 18);
		contentPane.add(lblBack);

		btnView = new JButton("VIEW");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtSearch.getText().toString().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter the correct roll no!");
				} else {
					setVisible(false);
					Student_View sv = new Student_View(txtSearch.getText());
					sv.setVisible(true);
				}
			}
		});
		btnView.setForeground(new Color(245, 255, 250));
		btnView.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnView.setBorder(
				new BevelBorder(BevelBorder.LOWERED, new Color(245, 255, 250), new Color(245, 255, 250), null, null));
		btnView.setBackground(Color.BLACK);
		btnView.setBounds(241, 111, 67, 23);
		contentPane.add(btnView);

		JButton btnPrint = new JButton("PRINT");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.print();
				} catch (Exception e1) {
				}
			}
		});
		btnPrint.setForeground(new Color(245, 255, 250));
		btnPrint.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnPrint.setBorder(
				new BevelBorder(BevelBorder.LOWERED, new Color(245, 255, 250), new Color(245, 255, 250), null, null));
		btnPrint.setBackground(Color.BLACK);
		btnPrint.setBounds(318, 111, 67, 23);
		contentPane.add(btnPrint);

		getStudentRollNo();
		printDataIntoTable();

	}

	private void printDataIntoTable() {
		try {
			String query = "select Roll_no,Student,Father_Name,HSC_Per,CNIC,Batch,Gender,Department from student";
			ResultSet rs = con.statement.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(rs));
			table.getColumnModel().getColumn(3).setPreferredWidth(85);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getStudentRollNo() {
		List<String> stuRoll = new ArrayList<>();
		// Setting department from another table of DB.
		try {
			String query1 = "select Roll_No from student";
			ResultSet rs = con.statement.executeQuery(query1);
			while (rs.next()) {
				stuRoll.add(rs.getString("Roll_No"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String arr[] = new String[stuRoll.size()];
		int i = 0;
		for (String type : stuRoll) {
			arr[i] = type;
			i++;
		}
		comboRollNo.setModel(new DefaultComboBoxModel(arr));

	}

	private void searchText() {
		DefaultTableModel obj = (DefaultTableModel) table.getModel();
		TableRowSorter<DefaultTableModel> obj11 = new TableRowSorter<>(obj);
		table.setRowSorter(obj11);
		obj11.setRowFilter(RowFilter.regexFilter("(?i)" + txtSearch.getText()));

	}
}
