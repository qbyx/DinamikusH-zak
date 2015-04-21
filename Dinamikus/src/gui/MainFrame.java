package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	private JPanel Panel1, Panel2, Panel3;

	public MainFrame() {
		setLayout(new BorderLayout());
		setBounds(0,0,500,500);
		setTitle("Paint");
		setVisible(true);

		Panel1 = new JPanel();
		Panel1.setBackground(Color.GREEN);
		Panel1.setPreferredSize(new Dimension(200,200));

		Panel2 = new JPanel();
		Panel2.setBackground(Color.RED);
		Panel2.setPreferredSize(new Dimension(100,100));

		Panel3 = new JPanel();
		Panel3.setBackground(Color.WHITE);
		

		add(Panel1, BorderLayout.SOUTH);
		add(Panel2, BorderLayout.EAST);
		add(Panel3, BorderLayout.CENTER);
		addWindowListener(listener);
	}

	WindowListener listener = new WindowAdapter() {
		public void windowClosing(WindowEvent we) {
			System.exit(0);
		}
	};
}
