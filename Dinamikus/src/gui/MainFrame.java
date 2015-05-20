package gui;

import io.GameLoader;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Attribute;
import control.AttributeCategory;
import control.Game;
import control.GameState;

public class MainFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 6270545319112969177L;

	private HouseContent houses[];
	// main panels
	private JPanel housePanel;
	private JPanel actionPanel;
	private JPanel attributePanel;

	// game state
	private GameState gs;

	private JMenu fileMenu;
	private JMenu gamesMenu;
	private JMenuItem game3Menu;
	private JMenuItem game5Menu;
	private JMenuItem game7Menu;
	private JMenuItem gameCustomMenu;
	private JMenuItem closeMenu;
	private JMenuBar menuBar;
	private GameLoader gameLoader;
	private CustomGame customGame;
	// temp
	private MainFrame mainFrame;

	private AttributeContent attributesConents[];
	private int houseCount = 5;
	private int attributeCount;
	private Game game;
	// QQQ
	private AttributeBorder attributeBorders[];

	public MainFrame() {
		mainFrame = this;
		gameLoader = new GameLoader();
		gameLoader.setGame(houseCount);
		// attributeCount = gameLoader.getCatNumber();
		attributeCount = gameLoader.getAttributeCount();
		attributesConents = new AttributeContent[attributeCount * houseCount];
		attributeBorders = new AttributeBorder[attributeCount * houseCount];
		game = new Game(this);

		gs = new GameState(this);

		setLayout(new BorderLayout());
		setSize(1300, 700);
		setResizable(false);

		buildHousePanel(houseCount, game.getAttributeCategories());

		buildActionPanel();

		buildAttributePanel();

		CreateMenuBar();
		AddMenuListener();
		addWindowListener(listener);

		repaint();
		setVisible(true);

		dropAttributes(game.getAttributes());
	}

	public int getHouseCount() {
		return houseCount;
	}

	public void setHouseCount(int houseCount) {
		this.houseCount = houseCount;
	}

	public int getAttributeCount() {
		return attributeCount;
	}

	public void setAttributeCount(int attributeCount) {
		this.attributeCount = attributeCount;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public GameLoader getGameLoader() {
		return gameLoader;
	}

	public void setGameLoader(GameLoader gameLoader) {
		this.gameLoader = gameLoader;
	}

	public void buildHousePanel(int houseCount,
			AttributeCategory[] attributeCategories) {
		housePanel = new JPanel(new GridLayout(1, houseCount, 10, 10));

		housePanel.setBackground(Color.darkGray);
		housePanel.setBorder(BorderFactory.createEmptyBorder());

		houses = new HouseContent[houseCount];
		for (int i = 0; i < houseCount; ++i) {
			houses[i] = new HouseContent(attributeCategories, i);
			housePanel.add(houses[i]);
			// QQQ
			for (int j = 0; j < attributeCount; ++j) {
				attributeBorders[i * attributeCount + j] = houses[i]
						.getBorders()[j];
			}
		}

		getContentPane().add(housePanel, BorderLayout.CENTER);
	}

	public void buildActionPanel() {
		actionPanel = new JPanel(new FlowLayout());

		actionPanel.setBackground(Color.RED);
		actionPanel.setPreferredSize(new Dimension(200, 1));

		// temp
		JButton b = new JButton("ev");
		b.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				System.out.println("Evaluate: ...");
				gs.Evaluate();
			}
		});
		actionPanel.add(b);

		getContentPane().add(actionPanel, BorderLayout.EAST);
	}

	public void buildAttributePanel() {
		attributePanel = new JPanel(new FlowLayout());

		attributePanel.setBackground(Color.DARK_GRAY);
		attributePanel.setPreferredSize(new Dimension(1, 300));

		getContentPane().add(attributePanel, BorderLayout.SOUTH);
	}

	public void dropAttributes(Attribute[] attr) {
		JPanel glassPanel = (JPanel) getGlassPane();
		glassPanel.setBorder(new EmptyBorder(400, 0, 0, 0));

		for (int i = 0; i < attr.length; ++i) {
			attributesConents[i] = new AttributeContent(attr[i],
					attributeBorders);

			attributesConents[i].setGs(gs);

			glassPanel.add(attributesConents[i]);
		}

		glassPanel.setVisible(true);
	}

	private void CreateMenuBar() {
		fileMenu = new JMenu("File");
		gamesMenu = new JMenu("Games");
		game3Menu = new JMenuItem("Beginner");
		game5Menu = new JMenuItem("Intermediate");
		game7Menu = new JMenuItem("Advanced");
		gameCustomMenu = new JMenuItem("Custom");
		closeMenu = new JMenuItem("Close");
		menuBar = new JMenuBar();
		gamesMenu.add(game3Menu);
		gamesMenu.add(game5Menu);
		gamesMenu.add(game7Menu);
		gamesMenu.add(gameCustomMenu);
		fileMenu.add(gamesMenu);
		fileMenu.add(closeMenu);
		menuBar.add(fileMenu);
		setJMenuBar(menuBar);
	}

	private void AddMenuListener() {
		closeMenu.addActionListener(close);
		game3Menu.addActionListener(game3);
		game5Menu.addActionListener(game5);
		game7Menu.addActionListener(game7);
		gameCustomMenu.addActionListener(gameCustom);
	}

	private ActionListener game3 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			gameLoader.setGame(3);
		}
	};

	private ActionListener game5 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			gameLoader.setGame(5);
		}
	};
	private ActionListener game7 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			gameLoader.setGame(7);
		}
	};
	private ActionListener gameCustom = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setEnabled(false);
			customGame = new CustomGame(mainFrame);
		}
	};

	private ActionListener close = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	};

	WindowListener listener = new WindowAdapter() {
		public void windowClosing(WindowEvent we) {
			System.exit(0);
		}
	};

	public void actionPerformed(ActionEvent e) {
	}

}
