package com.harsh.JDBC3;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUIScrollFrame_SelectTest extends JFrame implements ActionListener, WindowListener {

	private static final String GET_EMP_QUERY = "SELECT EMPNO, ENAME, JOB, SAL FROM EMP";

	private JLabel jempno, jename, jjob, jsal;
	private JTextField tempno, tename, tjob, tsal;
	private JButton bFirst, bNext, bPrevious, bLast;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public GUIScrollFrame_SelectTest() {
		System.out.println("GUIScrollFrame_SelectTest :: 0-param constructor (start)");
		setTitle("GUIScrollFrame_SelectTest");
		setSize(270, 300);
		setLayout(new FlowLayout());

		jempno = new JLabel("jempno");
		add(jempno);
		tempno = new JTextField(20);
		add(tempno);

		jename = new JLabel("jename");
		add(jename);
		tename = new JTextField(20);
		add(tename);

		jjob = new JLabel("jjob");
		add(jjob);
		tjob = new JTextField(20);
		add(tjob);

		jsal = new JLabel("jsal");
		add(jsal);
		tsal = new JTextField(20);
		add(tsal);

		bFirst = new JButton("First");
		bNext = new JButton("Next");
		bPrevious = new JButton("previous");
		bLast = new JButton("Last");
		add(bFirst);
		add(bNext);
		add(bPrevious);
		add(bLast);

		// register and activate ActionListener for all the 4 buttons
		bFirst.addActionListener(this);
		bNext.addActionListener(this);
		bPrevious.addActionListener(this);
		bLast.addActionListener(this);

		this.addWindowListener(this);

		tempno.setEditable(false);
		tename.setEditable(false);
		tjob.setEditable(false);
		tsal.setEditable(false);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initializeJDBC();

	}

	public void initializeJDBC() {
		try {
			System.out.println("GUIScrollFrameTest.initilizeJDBC()");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "harsh", "tiger");
			ps = con.prepareStatement(GET_EMP_QUERY, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = ps.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println("GUIScrollFrame_SelectTest.main() (start)");

		new GUIScrollFrame_SelectTest();

		System.out.println("GUIScrollFrame_SelectTest.main() (end)");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("\nGUIScrollFrame_SelectTest.actionPerformed()");
		boolean flag = false;

		if (e.getSource() == bFirst) {
			try {
				rs.next();
				flag = true;
				System.out.println("First button is clicked");
			} catch (Exception e2) {

			}
		} else if (e.getSource() == bNext) {
			try {
				if (!rs.isLast()) {
					rs.next();
					flag = true;
					System.out.println("Next button is clicked");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else if (e.getSource() == bPrevious) {
			try {
				if (!rs.isFirst()) {
					rs.previous();
					flag = true;
					System.out.println("previous button is clicked");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else if (e.getSource() == bLast) {
			try {
				rs.last();
				flag = true;
				System.out.println("Last button is clicked");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		if (flag == true) {
			try {
				tempno.setText(rs.getString(1));
				tename.setText(rs.getString(2));
				tjob.setText(rs.getString(3));
				tsal.setText(rs.getString(4));

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("GUIScrollFrame_SelectTest.windowClosing()");
		try {
			if (con != null) {
				con.close();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
