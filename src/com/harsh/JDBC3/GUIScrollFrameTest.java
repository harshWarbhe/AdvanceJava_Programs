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

public class GUIScrollFrameTest extends JFrame implements ActionListener, WindowListener {
	private final String GET_STUDENT_QUERY = "SELECT SNO, SNAME, SADD, AVG FROM STUDENT1";

	private JLabel lsno, lsname, laddrs, lavg;
	private JTextField tsno, tsname, taddrs, tavg;
	private JButton bFirst, bNext, bPrevious, bLast;
	private Connection con = null;
	private PreparedStatement ps= null;
	private ResultSet rs= null;

	// constructor
	public GUIScrollFrameTest() {
		System.out.println("GUIScrollFrameTest :: 0-param constructor (start)");
		setTitle("GUI FrontEnd-scroll Frame");
		setSize(190, 300);
		setLayout(new FlowLayout()); // Use FlowLayout or another layout manager
		// add comp
		lsno = new JLabel("sno:");
		add(lsno);
		tsno = new JTextField(10);
		add(tsno);

		lsname = new JLabel("sname");
		add(lsname);
		tsname = new JTextField(10);
		add(tsname);

		laddrs = new JLabel("lsname");
		add(laddrs);
		taddrs = new JTextField(10);
		add(taddrs);

		lavg = new JLabel("lavg");
		add(lavg);
		tavg = new JTextField(10);
		add(tavg);

		bFirst = new JButton("first");
		bNext = new JButton("next");
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

		//add windowListerner 
		this.addWindowListener(this);	// 1 this = frame , 2 this = window Listener
		
		// disable editing on text box
		tsno.setEditable(false);
		tsname.setEditable(false);
		taddrs.setEditable(false);
		tavg.setEditable(false);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // the closing of frame window will terminates Application
		System.out.println("GUIScrollFrameTest :: 0-param constructor (end)");

		initializeJDBC();

	}

	private void initializeJDBC() {
		try {
			System.out.println("GUIScrollFrameTest.initilizeJDBC()");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "harsh", "tiger");
			ps = con.prepareStatement(GET_STUDENT_QUERY, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			rs = ps.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println("GUIScrollFrameTest.main() (Stat)");

		new GUIScrollFrameTest(); // anonymous object

		System.out.println("GUIScrollFrameTest.main() (end)");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("\nGUIScrollFrameTest.actionPerformed()");
		boolean flag = false;

		if (e.getSource() == bFirst) {
			try {
				rs.first();
				flag = true;
				System.out.println("First button is clicked");

			} catch (Exception e2) {
				e2.printStackTrace();
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
					System.out.println("Previous button is clicked");
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
				tsno.setText(rs.getString(1));
				tsname.setText(rs.getString(2));
				taddrs.setText(rs.getString(3));
				tavg.setText(rs.getString(4));

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
		System.out.println("GUIScrollFrameTest.windowClosing()");
		try {
			if (con!=null) {
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
