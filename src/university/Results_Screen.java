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
import java.awt.Component;

public class Results_Screen extends JFrame {

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
					Results_Screen frame = new Results_Screen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Results_Screen() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Results_Screen.class.getResource("/Images/uniLogo.png")));
		setTitle("Results");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 584);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JLabel searchLabel = new JLabel("");
		searchLabel.setIcon(new ImageIcon(Results_Screen.class.getResource("/Images/search.png")));
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
		scrollPane.setBorder(null);
		scrollPane.setViewportBorder(
				new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, new Color(0, 0, 0), null));
		scrollPane.setBounds(0, 162, 1296, 383);
		scrollPane.setFont(new Font("SansSerif", Font.BOLD, 14));
		contentPane.add(scrollPane);

		JLabel lblHeading = new JLabel("RESULTS");
		lblHeading.setForeground(Color.WHITE);
		lblHeading.setFont(new Font("Verdana", Font.BOLD, 19));
		lblHeading.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(105, 105, 105), new Color(105, 105, 105),
				new Color(255, 255, 255), new Color(255, 255, 255)));
		lblHeading.setBounds(588, 37, 107, 36);
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
				Result_Delete rd = new Result_Delete();
				rd.setVisible(true);
			}
		});
		btnDlt.setIcon(new ImageIcon(Results_Screen.class.getResource("/Images/delete.png")));
		btnDlt.setForeground(UIManager.getColor("Button.darkShadow"));
		btnDlt.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnDlt.setBorder(null);
		btnDlt.setBackground(new Color(105, 105, 105));
		btnDlt.setBounds(1064, 123, 28, 28);
		contentPane.add(btnDlt);

		JLabel lblDlt = new JLabel("Delete");
		lblDlt.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				Result_Delete rd = new Result_Delete();
				rd.setVisible(true);
			}
		});
		lblDlt.setForeground(Color.WHITE);
		lblDlt.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblDlt.setBounds(1100, 130, 52, 14);
		contentPane.add(lblDlt);

		JButton btnUpdate = new JButton("");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Result_Update ru = new Result_Update(comboID.getSelectedItem().toString());
				ru.setVisible(true);

			}
		});
		btnUpdate.setIcon(new ImageIcon(Results_Screen.class.getResource("/Images/update.png")));
		btnUpdate.setForeground(UIManager.getColor("Button.darkShadow"));
		btnUpdate.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnUpdate.setBorder(null);
		btnUpdate.setBackground(new Color(105, 105, 105));
		btnUpdate.setBounds(1064, 76, 28, 28);
		contentPane.add(btnUpdate);

		comboID = new JComboBox();
		comboID.setForeground(Color.BLACK);
		comboID.setFont(new Font("SansSerif", Font.BOLD, 13));
		comboID.setBackground(new Color(245, 255, 250));
		comboID.setBounds(1100, 80, 93, 20);
		contentPane.add(comboID);

		JButton btnCalculate = new JButton("");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Result_Calculate rc = new Result_Calculate();
				rc.setVisible(true);
			}
		});
		btnCalculate.setIcon(new ImageIcon(Results_Screen.class.getResource("/Images/calculate.png")));
		btnCalculate.setForeground(UIManager.getColor("Button.darkShadow"));
		btnCalculate.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnCalculate.setBorder(null);
		btnCalculate.setBackground(new Color(105, 105, 105));
		btnCalculate.setBounds(1064, 23, 28, 28);
		contentPane.add(btnCalculate);

		JLabel lblCalculate = new JLabel("Calculate");
		lblCalculate.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				Result_Calculate rc = new Result_Calculate();
				rc.setVisible(true);
			}
		});
		lblCalculate.setForeground(Color.WHITE);
		lblCalculate.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblCalculate.setBounds(1100, 30, 75, 14);
		contentPane.add(lblCalculate);

		JButton backBtn = new JButton("");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Main_Screen ms = new Main_Screen();
				ms.setVisible(true);
			}
		});
		backBtn.setIcon(new ImageIcon(Results_Screen.class.getResource("/Images/backSmall.png")));
		backBtn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		backBtn.setBorder(null);
		backBtn.setBackground(new Color(105, 105, 105));
		backBtn.setBounds(10, 11, 28, 28);
		contentPane.add(backBtn);

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
		
		JButton btnView = new JButton("VIEW");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtSearch.getText().toString().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter the correct id!");
				} else {
					setVisible(false);
					Result_View cv = new Result_View(txtSearch.getText());
					cv.setVisible(true);
				}
			}
		});
		btnView.setForeground(new Color(245, 255, 250));
		btnView.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnView.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(245, 255, 250), new Color(245, 255, 250), null, null));
		btnView.setBackground(Color.BLACK);
		btnView.setBounds(230, 110, 67, 23);
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
		btnPrint.setBounds(307, 110, 67, 23);
		contentPane.add(btnPrint);
		printData();
		getID();

	}

	private void printData() {
		try {
			String query = "select result_id as ID, Roll_No,Course1,Course1_Marks as M1,Course2,Course2_Marks as M2,Course3,Course3_Marks as M3,Course4,Course4_Marks as M4,Remarks,CGPA,Average,Grade from results";
			ResultSet rs = con.statement.executeQuery(query);
			table.setModel((DbUtils.resultSetToTableModel(rs)));
			table.getColumnModel().getColumn(2).setPreferredWidth(140);
			table.getColumnModel().getColumn(4).setPreferredWidth(140);
			table.getColumnModel().getColumn(6).setPreferredWidth(140);
			table.getColumnModel().getColumn(8).setPreferredWidth(140);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	private void getID() {
		List<String> id = new ArrayList<>();
		// Getting ID from DB and insert into JComboBox
		try {
			String query1 = "select Result_Id from results";
			ResultSet rs = con.statement.executeQuery(query1);
			while (rs.next()) {
				id.add(rs.getString("Result_Id"));
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

	private void searchText() {

		try {
			DefaultTableModel obj = (DefaultTableModel) table.getModel();
			TableRowSorter<DefaultTableModel> obj11 = new TableRowSorter<>(obj);
			table.setRowSorter(obj11);
			obj11.setRowFilter(RowFilter.regexFilter("(?i)" + txtSearch.getText()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
