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
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Choice;
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

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

public class Receipts_Screen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField txtSearch;
	private JPanel contentPane;
	DBConnection con = new DBConnection();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Receipts_Screen frame = new Receipts_Screen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Receipts_Screen() {
		setTitle("Receipts");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Receipts_Screen.class.getResource("/Images/uniLogo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 532);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDepartment = new JLabel("RECEIPTS");
		lblDepartment.setBounds(311, 29, 101, 36);
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
		lblSearch.setIcon(new ImageIcon(Receipts_Screen.class.getResource("/Images/search.png")));
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
				txtSearch.setText(table.getModel().getValueAt(row, 0).toString());
				
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
		scrollPane.setBounds(0, 162, 724, 331);
		contentPane.add(scrollPane);

		JButton btnPay = new JButton("");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Fee_Pay_Form fpf = new Fee_Pay_Form();
				fpf.setVisible(true);
			}
		});
		btnPay.setIcon(new ImageIcon(Receipts_Screen.class.getResource("/Images/pay.png")));
		btnPay.setForeground(UIManager.getColor("Button.darkShadow"));
		btnPay.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnPay.setBorder(null);
		btnPay.setBackground(new Color(105, 105, 105));
		btnPay.setBounds(551, 29, 28, 28);
		contentPane.add(btnPay);

		JLabel lblPay = new JLabel("Pay");
		lblPay.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				Fee_Pay_Form fpf = new Fee_Pay_Form();
				fpf.setVisible(true);
			}
		});
		lblPay.setForeground(Color.WHITE);
		lblPay.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblPay.setBounds(584, 33, 43, 20);
		contentPane.add(lblPay);

		JButton btnAdd = new JButton("");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			Fee_Str_Screen fts = new Fee_Str_Screen();
			fts.setVisible(true);
			}
		});
		btnAdd.setIcon(new ImageIcon(Receipts_Screen.class.getResource("/Images/feeStr.png")));
		btnAdd.setForeground(UIManager.getColor("Button.darkShadow"));
		btnAdd.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnAdd.setBorder(null);
		btnAdd.setBackground(new Color(105, 105, 105));
		btnAdd.setBounds(551, 70, 28, 28);
		contentPane.add(btnAdd);

		JButton btnDlt = new JButton("");
		btnDlt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			Receipt_Delete rd = new Receipt_Delete();
			rd.setVisible(true);
			}
		});
		btnDlt.setIcon(new ImageIcon(Receipts_Screen.class.getResource("/Images/delete.png")));
		btnDlt.setForeground(UIManager.getColor("Button.darkShadow"));
		btnDlt.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnDlt.setBorder(null);
		btnDlt.setBackground(new Color(105, 105, 105));
		btnDlt.setBounds(551, 110, 28, 28);
		contentPane.add(btnDlt);

		JLabel lblDlt = new JLabel("Delete");
		lblDlt.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setVisible(false);
				Receipt_Delete rd = new Receipt_Delete();
				rd.setVisible(true);
			}
		});
		lblDlt.setForeground(Color.WHITE);
		lblDlt.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblDlt.setBounds(584, 117, 52, 14);
		contentPane.add(lblDlt);
		
		JButton backBtn = new JButton("");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Main_Screen ms = new Main_Screen();
				ms.setVisible(true);
			}
		});
		backBtn.setIcon(new ImageIcon(Receipts_Screen.class.getResource("/Images/backSmall.png")));
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
		
		JLabel lblFeeStructure = new JLabel("Fee Structure");
		lblFeeStructure.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Fee_Str_Screen fts = new Fee_Str_Screen();
				fts.setVisible(true);
			}
		});
		lblFeeStructure.setForeground(Color.WHITE);
		lblFeeStructure.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblFeeStructure.setBounds(584, 74, 111, 20);
		contentPane.add(lblFeeStructure);
		
		JButton btnView = new JButton("VIEW");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtSearch.getText().toString().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter the correct roll no!");
				} else {
					setVisible(false);
					Receipt_View rv = new Receipt_View(txtSearch.getText());
					rv.setVisible(true);
				}
			}
		});
		btnView.setForeground(new Color(245, 255, 250));
		btnView.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnView.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(245, 255, 250), new Color(245, 255, 250), null, null));
		btnView.setBackground(Color.BLACK);
		btnView.setBounds(241, 118, 67, 23);
		contentPane.add(btnView);
		
		JButton btnPrint = new JButton("PRINT");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPrint.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							table.print();
						} catch (Exception e1) {
						}
					}
				});
			}
		});
		
		btnPrint.setForeground(new Color(245, 255, 250));
		btnPrint.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		btnPrint.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(245, 255, 250), new Color(245, 255, 250), null, null));
		btnPrint.setBackground(Color.BLACK);
		btnPrint.setBounds(318, 118, 67, 23);
		contentPane.add(btnPrint);

		printData();

	}

	private void searchText() {
		DefaultTableModel obj = (DefaultTableModel) table.getModel();
		TableRowSorter<DefaultTableModel> obj11 = new TableRowSorter<>(obj);
		table.setRowSorter(obj11);
		obj11.setRowFilter(RowFilter.regexFilter("(?i)" + txtSearch.getText()));
	}


	private void printData() {
		try {
			String query = "select Fee_id as ID, fee_date as Date,Roll_No as Student_RollNo,Department,Semester,Amount  from fees";
			ResultSet rs = con.statement.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
