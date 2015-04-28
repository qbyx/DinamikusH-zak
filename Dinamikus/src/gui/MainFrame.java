package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import controll.AttributeCategory;

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
		
		AttributeCategory attrCat[] = new AttributeCategory[3];
		{
			attrCat[0] = new AttributeCategory("auto", Color.blue);
			attrCat[1] = new AttributeCategory("auto", Color.gray);
			attrCat[2] = new AttributeCategory("kedvenc cuni", Color.red);

			AttributeContent tryfirst = new AttributeContent(attrCat[0], "asdf");
			AttributeContent tryfirst2 = new AttributeContent(attrCat[0], "a234");
			AttributeContent tryfirst3 = new AttributeContent(attrCat[0], ", asdfaaa");
			AttributeContent tryfirst4 = new AttributeContent(attrCat[1], "asdfsdfa");
//			tryfirst.addMouseListener(new MouseAdapter() {
//					public void mousePressed(MouseEvent me) { 
//						System.out.println(me); 
//					}
//			}); 
			Panel1.add(tryfirst);
			Panel1.add(tryfirst2);
			Panel1.add(tryfirst3);
			Panel1.add(tryfirst4);
		}

		Panel2 = new JPanel();
		Panel2.setBackground(Color.RED);
		Panel2.setPreferredSize(new Dimension(100,100));

		Panel3 = new JPanel(new GridLayout(1, 4, 10, 10));
		Panel3.setBackground(Color.WHITE);
		Panel3.setBorder(BorderFactory.createEmptyBorder());

		{
			Panel3.add(new House(attrCat));
			Panel3.add(new House(attrCat));
			Panel3.add(new House(attrCat));
			Panel3.add(new House(attrCat));
		}

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
