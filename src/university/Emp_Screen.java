package university;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.proteanit.sql.DbUtils;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
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
import javax.swing.JComboBox;
import java.awt.Toolkit;
import java.awt.SystemColor;

public class Emp_Screen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSearch;
	private JTable table;
	private JComboBox comboID;
	DBConnection con = new DBConnection();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Emp_Screen frame = new Emp_Screen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Emp_Screen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Emp_Screen.class.getResource("/Images/uniLogo.png")));
		setTitle("Staff");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 929, 584);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JLabel searchLabel = new JLabel("");
		searchLabel.setIcon(new ImageIcon(Emp_Screen.class.getResource("/Images/search.png")));
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
		scrollPane.setBounds(0, 162, 919, 383);
		scrollPane.setFont(new Font("SansSerif", Font.BOLD, 14));
		contentPane.add(scrollPane);

		JLabel lblHeading = new JLabel("STAFF");
		lblHeading.setForeground(Color.WHITE);
		lblHeading.setFont(new Font("Verdana", Font.BOLD, 19));
		lblHeading.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(105, 105, 105), new Color(105, 105, 105),
				new Color(255, 255, 255), new Color(255, 255, 255)));
		lblHeading.setBounds(418, 37, 76, 36);
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
				delete();
			}
		});
		btnDlt.setIcon(new ImageIcon(Emp_Screen.class.getResource("/Images/delete.png")));
		btnDlt.setForeground(UIManager.getColor("Button.darkShadow"));
		btnDlt.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnDlt.setBorder(null);
		btnDlt.setBackground(new Color(105, 105, 105));
		btnDlt.setBounds(757, 88, 28, 28);
		contentPane.add(btnDlt);

		JLabel lblDlt = new JLabel("Delete");
		lblDlt.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				delete();
			}
		});
		lblDlt.setForeground(Color.WHITE);
		lblDlt.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblDlt.setBounds(790, 95, 52, 14);
		contentPane.add(lblDlt);

		JButton btnUpdate = new JButton("");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		btnUpdate.setIcon(new ImageIcon(Emp_Screen.class.getResource("/Images/update.png")));
		btnUpdate.setForeground(UIManager.getColor("Button.darkShadow"));
		btnUpdate.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnUpdate.setBorder(null);
		btnUpdate.setBackground(new Color(105, 105, 105));
		btnUpdate.setBounds(757, 49, 28, 28);
		contentPane.add(btnUpdate);

		comboID = new JComboBox();
		comboID.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		comboID.setForeground(Color.BLACK);
		comboID.setFont(new Font("SansSerif", Font.BOLD, 13));
		comboID.setBackground(SystemColor.inactiveCaptionBorder);
		comboID.setBounds(790, 51, 77, 25);
		contentPane.add(comboID);

		JButton btnAdd = new JButton("");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adding();
			}
		});
		btnAdd.setIcon(new ImageIcon(Emp_Screen.class.getResource("/Images/add.png")));
		btnAdd.setForeground(UIManager.getColor("Button.darkShadow"));
		btnAdd.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnAdd.setBorder(null);
		btnAdd.setBackground(new Color(105, 105, 105));
		btnAdd.setBounds(757, 11, 28, 28);
		contentPane.add(btnAdd);

		JLabel lblAdd = new JLabel("New");
		lblAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				adding();
			}
		});
		lblAdd.setForeground(Color.WHITE);
		lblAdd.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblAdd.setBounds(790, 18, 43, 14);
		contentPane.add(lblAdd);

		JButton btnTypes = new JButton("");
		btnTypes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				type();
			}
		});
		btnTypes.setIcon(new ImageIcon(Emp_Screen.class.getResource("/Images/emptypes.png")));
		btnTypes.setForeground(UIManager.getColor("Button.darkShadow"));
		btnTypes.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnTypes.setBorder(null);
		btnTypes.setBackground(new Color(105, 105, 105));
		btnTypes.setBounds(757, 123, 28, 28);
		contentPane.add(btnTypes);

		JLabel lblTypes = new JLabel("Types");
		lblTypes.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				type();
			}
		});
		lblTypes.setForeground(Color.WHITE);
		lblTypes.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblTypes.setBounds(790, 127, 52, 20);
		contentPane.add(lblTypes);

		JButton backBtn = new JButton("");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		backBtn.setIcon(new ImageIcon(Emp_Screen.class.getResource("/Images/backSmall.png")));
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
		
		JButton btnView = new JButton("VIEW");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtSearch.getText().toString().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter the correct id!");
				} else {
					setVisible(false);
					Employee_View cv = new Employee_View(txtSearch.getText());
					cv.setVisible(true);
				}
			}
		});
		btnView.setForeground(new Color(245, 255, 250));
		btnView.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnView.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(245, 255, 250), new Color(245, 255, 250), null, null));
		btnView.setBackground(Color.BLACK);
		btnView.setBounds(228, 110, 67, 23);
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
		btnPrint.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(245, 255, 250), new Color(245, 255, 250), null, null));
		btnPrint.setBackground(Color.BLACK);
		btnPrint.setBounds(305, 110, 67, 23);
		contentPane.add(btnPrint);

		printData();
		getEmpID();

	}

	private void printData() {
		try {
			String query = "select EMP_ID , Employee, Father_Name, Designation, Emp_Type as Type , Phone, CNIC, City, Gender from employee;";
			ResultSet rs = con.statement.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e1) {
			e1.printStackTrace();
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

	private void searchText() {
		DefaultTableModel obj = (DefaultTableModel) table.getModel();
		TableRowSorter<DefaultTableModel> obj11 = new TableRowSorter<>(obj);
		table.setRowSorter(obj11);
		obj11.setRowFilter(RowFilter.regexFilter("(?i)" + txtSearch.getText()));
	}

	private void back() {
		this.setVisible(false);
		Main_Screen ms = new Main_Screen();
		ms.setVisible(true);
	}

	private void adding() {
		this.setVisible(false);
		Emp_Form ef = new Emp_Form();
		ef.setVisible(true);
	}

	private void update() {
		this.setVisible(false);
		Emp_Update eu = new Emp_Update(comboID.getSelectedItem().toString());
		eu.setVisible(true);
	}

	private void delete() {
		this.setVisible(false);
		Emp_Delete ed = new Emp_Delete();
		ed.setVisible(true);
	}

	private void type() {
		this.setVisible(false);
		Emp_Type et = new Emp_Type();
		et.setVisible(true);
	}
}
