package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class CustomGame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JButton next, back, ok, add, remove;
	private JLabel labelHouse, labelCat;
	private JComboBox<String> comboHouse, comboCat;
	private int houseNumber;
	private int catNumber;
	private String cat[][], allCat[][];
	private JList<String> list1, list2;
	private DefaultListModel<String> model1, model2;
	private int addElement, addHouse;
	private JLabel labelList;
	private JLabel labelCatList;
	private MainFrame mainFrame;

	public CustomGame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		setBounds(100, 100, 500, 370);
		setTitle("CustomGame");
		setVisible(true);
		FileRead("games/Custom.haz");
		addWindowListener(listener);
		setResizable(false);

		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		add(panel);
		panel.setLayout(null);

		labelHouse = new JLabel("Házak száma:");
		labelHouse.setBounds(10, 20, 100, 25);
		labelHouse.setForeground(Color.white);
		panel.add(labelHouse);

		labelCat = new JLabel("Komponensek száma:");
		labelCat.setBounds(180, 20, 150, 25);
		labelCat.setForeground(Color.white);
		panel.add(labelCat);

		String[] comboItems = { "3", "4", "5", "6", "7" };
		comboHouse = new JComboBox<String>(comboItems);
		comboHouse.setBounds(100, 20, 50, 25);
		panel.add(comboHouse);

		comboCat = new JComboBox<String>(comboItems);
		comboCat.setBounds(315, 20, 50, 25);
		panel.add(comboCat);

		ok = new JButton("Ok");
		ok.setBounds(395, 20, 75, 25);
		panel.add(ok);

		model1 = new DefaultListModel<>();
		model1 = addListModel(0);

		list1 = new JList<String>(model1);
		list1.setBounds(20, 90, 200, 200);
		list1.setBorder(BorderFactory.createRaisedBevelBorder());
		list1.setBackground(Color.DARK_GRAY);
		list1.setForeground(Color.white);
		panel.add(list1);

		model2 = new DefaultListModel<>();
		list2 = new JList<String>(model2);
		list2.setBounds(280, 90, 200, 200);
		list2.setBorder(BorderFactory.createRaisedBevelBorder());
		list2.setBackground(Color.DARK_GRAY);
		list2.setForeground(Color.white);
		panel.add(list2);

		labelList = new JLabel();
		labelList.setBounds(280, 70, 30, 20);
		labelList.setForeground(Color.white);
		panel.add(labelList);

		labelCatList = new JLabel();
		labelCatList.setBounds(280, 70, 30, 20);
		labelCatList.setForeground(Color.white);
		panel.add(labelCatList);

		add = new JButton(">");
		add.setBounds(230, 155, 42, 25);
		panel.add(add);

		remove = new JButton("<");
		remove.setBounds(230, 200, 42, 25);
		panel.add(remove);

		next = new JButton("Következö");
		next.setBounds(385, 300, 93, 25);
		panel.add(next);

		back = new JButton("Elözö");
		back.setBounds(283, 300, 93, 25);
		panel.add(back);

		ok.addActionListener(this);

		add.addActionListener(addl);
		remove.addActionListener(removel);
		next.addActionListener(nextl);
		DisableList();
	}

	private ActionListener nextl = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

		}
	};

	public void actionPerformed(ActionEvent e) {
		if (ok.getText().equals("Ok")) {
			DisableHouseNumber();
			houseNumber = Integer.parseInt(comboHouse.getSelectedItem()
					.toString());
			addElement = houseNumber;
			catNumber = Integer.parseInt(comboHouse.getSelectedItem()
					.toString());
			addHouse = catNumber;
			cat = new String[houseNumber][catNumber];
			labelList.setText(Integer.toString(addElement));
			EnableList();
		} else {
			EnableHouseNumber();
			DisableList();
		}
	}

	private ActionListener addl = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				Object o = list1.getSelectedValue();
				model1.removeElement(o);
				model2.addElement(o.toString());
				addElement--;
				labelList.setText(Integer.toString(addElement));
				if (addElement == 0) {
					add.setEnabled(false);
				}
			} catch (Exception err) {
			}
		}
	};

	private ActionListener removel = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				Object o = list2.getSelectedValue();
				model2.removeElement(o);
				model1.addElement(o.toString());
				addElement++;
				labelList.setText(Integer.toString(addElement));
				if (addElement == 1) {
					add.setEnabled(true);
				}
			} catch (Exception err) {
			}
		}
	};

	WindowListener listener = new WindowAdapter() {
		public void windowClosing(WindowEvent we) {
			mainFrame.setEnabled(true);
		}
	};

	private void DisableHouseNumber() {
		labelHouse.setEnabled(false);
		comboHouse.setEnabled(false);
		labelCat.setEnabled(false);
		comboCat.setEnabled(false);
		ok.setText("Mégse");
	}

	private void EnableHouseNumber() {
		labelHouse.setEnabled(true);
		comboHouse.setEnabled(true);
		labelCat.setEnabled(true);
		comboCat.setEnabled(true);
		ok.setText("Ok");
	}

	private void DisableList() {
		list1.setEnabled(false);
		list2.setEnabled(false);
		add.setEnabled(false);
		remove.setEnabled(false);
		next.setEnabled(false);
		back.setEnabled(false);
		labelList.setEnabled(false);
		labelCatList.setEnabled(false);
	}

	private void EnableList() {
		list1.setEnabled(true);
		list2.setEnabled(true);
		add.setEnabled(true);
		remove.setEnabled(true);
		next.setEnabled(true);
		back.setEnabled(true);
		labelList.setEnabled(true);
		labelCatList.setEnabled(true);
	}

	private DefaultListModel<String> addListModel(int i) {
		DefaultListModel<String> m = new DefaultListModel<>();
		for (int j = 0; j < allCat[i].length; j++) {
			m.addElement(allCat[i][j]);
		}
		return m;
	}

	public void FileRead(String fileName) {
		BufferedReader br = null;
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(fileName));
			houseNumber = Integer.parseInt(br.readLine());
			catNumber = Integer.parseInt(br.readLine());
			allCat = new String[houseNumber][catNumber];
			int i = 0;
			while ((sCurrentLine = br.readLine()) != null) {
				allCat[i] = sCurrentLine.split(" ");
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	// public static void main(String[] args) {
	// CustomGame f = new CustomGame();
	// f.setBounds(100, 100, 500, 370);
	// f.setTitle("CustomGame");
	// f.setVisible(true);
	// }

}
