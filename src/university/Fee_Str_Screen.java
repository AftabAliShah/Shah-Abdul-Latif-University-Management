package university;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import javax.swing.JComboBox;

public class Fee_Str_Screen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField txtSearch;
	private JPanel contentPane;
	private JComboBox comboID;
	DBConnection con = new DBConnection();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fee_Str_Screen frame = new Fee_Str_Screen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Fee_Str_Screen() {
		setTitle("Fee Structure");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Fee_Str_Screen.class.getResource("/Images/uniLogo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 532);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDepartment = new JLabel("FEE STRUCTURE");
		lblDepartment.setBounds(248, 29, 156, 36);
		contentPane.add(lblDepartment);
		lblDepartment.setForeground(new Color(245, 255, 250));
		lblDepartment.setFont(new Font("Verdana", Font.BOLD, 16));
		lblDepartment.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(105, 105, 105), new Color(105, 105, 105),
				new Color(255, 255, 255), new Color(255, 255, 255)));

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
		txtSearch.setBounds(69, 115, 149, 28);
		contentPane.add(txtSearch);

		JLabel lblSearch = new JLabel("");
		lblSearch.setIcon(new ImageIcon(Fee_Str_Screen.class.getResource("/Images/search.png")));
		lblSearch.setForeground(Color.WHITE);
		lblSearch.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblSearch.setBounds(26, 112, 35, 35);
		contentPane.add(lblSearch);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setSelectionBackground(new Color(105, 105, 105));
		table.setGridColor(new Color(128, 128, 128));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				table.setSelectionForeground(Color.WHITE);
				table.setSelectionBackground(Color.DARK_GRAY);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				txtSearch.setText(table.getModel().getValueAt(row, 1).toString());
				
			}
		});

		table.setForeground(new Color(0, 0, 0));
		table.getTableHeader().setForeground(Color.WHITE);
		table.getTableHeader().setBackground(Color.BLACK);
		table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
		table.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), new Color(0, 0, 0), null, null));
		table.setBackground(new Color(245, 255, 250));
		table.setFont(new Font("Times New Roman", Font.BOLD, 15));
		table.setBounds(0, 161, 913, 384);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setAlignmentY(Component.TOP_ALIGNMENT);
		scrollPane.setViewportBorder(
				new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, new Color(0, 0, 0), null));
		scrollPane.setFont(new Font("SansSerif", Font.BOLD, 14));
		scrollPane.setBounds(0, 162, 652, 331);
		contentPane.add(scrollPane);

		JButton btnAdd = new JButton("");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Fee_Str_Form fts = new Fee_Str_Form();
				fts.setVisible(true);
				
			}
		});
		btnAdd.setIcon(new ImageIcon(Fee_Str_Screen.class.getResource("/Images/add.png")));
		btnAdd.setForeground(UIManager.getColor("Button.darkShadow"));
		btnAdd.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnAdd.setBorder(null);
		btnAdd.setBackground(new Color(105, 105, 105));
		btnAdd.setBounds(479, 43, 28, 28);
		contentPane.add(btnAdd);

		JLabel lblAdd = new JLabel("Add Structure");
		lblAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				Fee_Str_Form fts = new Fee_Str_Form();
				fts.setVisible(true);
			}
		});
		lblAdd.setForeground(Color.WHITE);
		lblAdd.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblAdd.setBounds(512, 47, 113, 20);
		contentPane.add(lblAdd);
		
		JButton backBtn = new JButton("");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Main_Screen ms = new Main_Screen();
				ms.setVisible(true);
			}
		});
		backBtn.setIcon(new ImageIcon(Fee_Str_Screen.class.getResource("/Images/backSmall.png")));
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
				setVisible(false);
				Main_Screen ms = new Main_Screen();
				ms.setVisible(true);
			}
		});
		lblBack.setForeground(Color.WHITE);
		lblBack.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblBack.setBounds(42, 17, 40, 18);
		contentPane.add(lblBack);
		
		JButton btnUpdate = new JButton("");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fee_Str_Update ftu = new Fee_Str_Update(comboID.getSelectedItem().toString());
				ftu.setVisible(true);
			}
		});
		btnUpdate.setIcon(new ImageIcon(Fee_Str_Screen.class.getResource("/Images/update.png")));
		btnUpdate.setForeground(UIManager.getColor("Button.darkShadow"));
		btnUpdate.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnUpdate.setBorder(null);
		btnUpdate.setBackground(new Color(105, 105, 105));
		btnUpdate.setBounds(479, 94, 28, 28);
		contentPane.add(btnUpdate);
		
		comboID = new JComboBox();
		comboID.setForeground(Color.BLACK);
		comboID.setFont(new Font("SansSerif", Font.BOLD, 13));
		comboID.setBackground(new Color(245, 255, 250));
		comboID.setBounds(512, 98, 77, 20);
		contentPane.add(comboID);

		getID();
		printData();

	}

	private void searchText() {
		DefaultTableModel obj = (DefaultTableModel) table.getModel();
		TableRowSorter<DefaultTableModel> obj11 = new TableRowSorter<>(obj);
		table.setRowSorter(obj11);
		obj11.setRowFilter(RowFilter.regexFilter("(?i)" + txtSearch.getText()));
	}

	private void getID() {
		List<String> id = new ArrayList<>();
		//  Getting ID from DB and insert into JComboBox
		try {
			String query = "select Fee_Str_id from fee_Structure";
			ResultSet rs = con.statement.executeQuery(query);
			while (rs.next()) {
				id.add(rs.getString("Fee_Str_id"));
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

	private void printData() {
		try {
			String query = "select Fee_Str_id as ID, Department,Amount_Per_Sems as Amount_Per_Semester from fee_Structure";
			ResultSet rs = con.statement.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
