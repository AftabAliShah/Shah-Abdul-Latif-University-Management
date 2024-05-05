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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import javax.swing.JTable;
import java.awt.Toolkit;

public class Semesters extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Semesters frame = new Semesters();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Semesters() {
		setTitle("Semesters");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Semesters.class.getResource("/Images/uniLogo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 427, 468);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				table.setSelectionForeground(Color.WHITE);
				table.setSelectionBackground(Color.DARK_GRAY);
			}
		});
		table.setForeground(new Color(0, 0, 0));
		table.getTableHeader().setForeground(Color.WHITE);
		table.getTableHeader().setBackground(Color.BLACK);
		table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));
		table.setBackground(new Color(245, 255, 250));
		table.setFont(new Font("SansSerif", Font.BOLD, 14));
		table.setBounds(0, 161, 913, 384);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(null);
		scrollPane.setViewportBorder(
				new BevelBorder(BevelBorder.RAISED, new Color(0, 0, 0), null, new Color(0, 0, 0), null));
		scrollPane.setBounds(0, 101, 411, 328);
		scrollPane.setFont(new Font("SansSerif", Font.BOLD, 14));
		contentPane.add(scrollPane);

		JLabel lblHeading = new JLabel("SEMESTERS");
		lblHeading.setForeground(Color.WHITE);
		lblHeading.setFont(new Font("Verdana", Font.BOLD, 17));
		lblHeading.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(105, 105, 105), new Color(105, 105, 105),
				new Color(255, 255, 255), new Color(255, 255, 255)));
		lblHeading.setBounds(144, 34, 123, 36);
		contentPane.add(lblHeading);

		JButton backBtn = new JButton("");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Courses_Screen cs = new Courses_Screen();
				cs.setVisible(true);
			}
		});
		backBtn.setIcon(new ImageIcon(Semesters.class.getResource("/Images/backSmall.png")));
		backBtn.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 13));
		backBtn.setBorder(null);
		backBtn.setBackground(new Color(105, 105, 105));
		backBtn.setBounds(10, 11, 28, 28);
		contentPane.add(backBtn);

		JLabel lblBack = new JLabel("Back");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				Courses_Screen cs = new Courses_Screen();
				cs.setVisible(true);
			}
		});
		lblBack.setForeground(Color.WHITE);
		lblBack.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblBack.setBounds(41, 16, 40, 18);
		contentPane.add(lblBack);
		printData();

	}

	private void printData() {

		try {
			DBConnection con = new DBConnection();
			String query = "select Sems_ID as ID , Semester_No from semester";
			ResultSet rs = con.statement.executeQuery(query);
			table.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
