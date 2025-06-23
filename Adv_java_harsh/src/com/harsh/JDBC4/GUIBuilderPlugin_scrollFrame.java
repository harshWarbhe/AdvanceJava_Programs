package com.harsh.JDBC4;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUIBuilderPlugin_scrollFrame {

	private final String GET_STUDENT_QUERY = "SELECT SNO, SNAME, SADD, AVG FROM STUDENT1 ORDER BY SNO";

	private JFrame frmGuibuilderscrollframe;
	private final JLabel lblNewLabel = new JLabel("SNO");
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIBuilderPlugin_scrollFrame window = new GUIBuilderPlugin_scrollFrame();
					window.frmGuibuilderscrollframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIBuilderPlugin_scrollFrame() {
		initialize();
		initializeJDBC();
	}

	private void initializeJDBC() {
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "harsh", "tiger");
			ps = con.prepareStatement(GET_STUDENT_QUERY, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = ps.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGuibuilderscrollframe = new JFrame();
		frmGuibuilderscrollframe.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					if (rs != null) {
						rs.close();
					}

				} catch (Exception e2) {
					e2.printStackTrace();
				}

				try {
					if (ps != null) {
						ps.close();
					}

				} catch (Exception e2) {
					e2.printStackTrace();
				}

				try {
					if (con != null) {
						con.close();
					}

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		frmGuibuilderscrollframe.setForeground(new Color(128, 128, 128));
		frmGuibuilderscrollframe.setBackground(SystemColor.desktop);
		frmGuibuilderscrollframe.setFont(new Font("Dialog", Font.BOLD, 14));
		frmGuibuilderscrollframe.setTitle("GUIBuilder_scrollFrame ");
		frmGuibuilderscrollframe.setBounds(100, 100, 450, 300);
		frmGuibuilderscrollframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGuibuilderscrollframe.getContentPane().setLayout(null);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(45, 26, 126, 36);
		frmGuibuilderscrollframe.getContentPane().add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(223, 35, 96, 19);
		frmGuibuilderscrollframe.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblSname = new JLabel("SNAME");
		lblSname.setHorizontalAlignment(SwingConstants.CENTER);
		lblSname.setBounds(45, 56, 126, 36);
		frmGuibuilderscrollframe.getContentPane().add(lblSname);

		JLabel lblSaddrs = new JLabel("SADD");
		lblSaddrs.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaddrs.setBounds(45, 93, 126, 36);
		frmGuibuilderscrollframe.getContentPane().add(lblSaddrs);

		JLabel lblAvg = new JLabel("AVG");
		lblAvg.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvg.setBounds(45, 130, 126, 36);
		frmGuibuilderscrollframe.getContentPane().add(lblAvg);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(223, 65, 96, 19);
		frmGuibuilderscrollframe.getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(223, 102, 96, 19);
		frmGuibuilderscrollframe.getContentPane().add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(223, 139, 96, 19);
		frmGuibuilderscrollframe.getContentPane().add(textField_3);

		JButton btnNewButton = new JButton("FIRST");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rs.first();
					textField.setText(rs.getString(1));
					textField_1.setText(rs.getString(2));
					textField_2.setText(rs.getString(3));
					textField_3.setText(rs.getString(4));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setBounds(21, 193, 85, 21);
		frmGuibuilderscrollframe.getContentPane().add(btnNewButton);

		JButton btnNext = new JButton("NEXT");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!rs.isLast()) {
						rs.next();
						textField.setText(rs.getString(1));
						textField_1.setText(rs.getString(2));
						textField_2.setText(rs.getString(3));
						textField_3.setText(rs.getString(4));
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNext.setBounds(118, 193, 85, 21);
		frmGuibuilderscrollframe.getContentPane().add(btnNext);

		JButton btnPrevious = new JButton("PREVOIUS");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!rs.isFirst()) {
						rs.previous();
						textField.setText(rs.getString(1));
						textField_1.setText(rs.getString(2));
						textField_2.setText(rs.getString(3));
						textField_3.setText(rs.getString(4));
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnPrevious.setBounds(223, 193, 85, 21);
		frmGuibuilderscrollframe.getContentPane().add(btnPrevious);

		JButton btnLast = new JButton("LAST");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rs.last();
					textField.setText(rs.getString(1));
					textField_1.setText(rs.getString(2));
					textField_2.setText(rs.getString(3));
					textField_3.setText(rs.getString(4));

				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnLast.setBounds(324, 193, 85, 21);
		frmGuibuilderscrollframe.getContentPane().add(btnLast);
	}
}
