package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import control.Attribute;

public class AttributeContent extends JPanel {

	private static final long serialVersionUID = 3803164464624865777L;
	private Attribute attr;
	private boolean draggable = true;
	protected Point anchorPoint;
	protected Cursor draggingCursor = Cursor
			.getPredefinedCursor(Cursor.HAND_CURSOR);

	// QQQ SHORTCUT
	private AttributeBorder attributeBorders[];

	public Attribute getAttr() {
		return attr;
	}

	public void setAttr(Attribute attr) {
		this.attr = attr;
	}

	public AttributeContent(Attribute attr, AttributeBorder[] attributeBorders) {
		this.attributeBorders = attributeBorders;

		setBorder(new CompoundBorder(new LineBorder(Color.black),
				new LineBorder(attr.getAttributeCategory().getColor(), 4)));

		// copy
		add(new JLabel(attr.getName()));
		setBackground(Color.green);
		setBackground(attr.getAttributeCategory().getColor());

		setPreferredSize(new Dimension(attributeBorders[0].getWidth(),
				attributeBorders[0].getHeight()));

		this.attr = attr;
		// TRY
		addDragListeners();
		setOpaque(true);
		setBackground(new Color(240, 240, 240));
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		setSize(new Dimension(attributeBorders[0].getWidth(),
				attributeBorders[0].getHeight()));
		setPreferredSize(new Dimension(attributeBorders[0].getWidth(),
				attributeBorders[0].getHeight()));
		setBackground(Color.white);

		super.paintComponent(g);
	}

	private void addDragListeners() {
		addMouseMotionListener(new MouseAdapter() {

			@Override
			public void mouseMoved(MouseEvent e) {
				anchorPoint = e.getPoint();
				setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				int anchorX = anchorPoint.x;
				int anchorY = anchorPoint.y;

				Point parentOnScreen = getParent().getLocationOnScreen();
				Point mouseOnScreen = e.getLocationOnScreen();
				Point position = new Point(mouseOnScreen.x - parentOnScreen.x
						- anchorX, mouseOnScreen.y - parentOnScreen.y - anchorY);
				setLocation(position);

				Point mouseParent = new Point(mouseOnScreen.x
						- parentOnScreen.x, mouseOnScreen.y - parentOnScreen.y);

				if ((mouseParent.x > 50) && (mouseParent.x < 150)
						&& (mouseParent.y > 50) && (mouseParent.y < 150)) {
					setLocation(new Point(50, 50));
				}

				for (AttributeBorder ab : attributeBorders) {
					if (e.getXOnScreen() < ab.getLocationOnScreen().getX()
							|| e.getXOnScreen() > ab.getLocationOnScreen()
									.getX() + ab.getWidth()
							|| e.getYOnScreen() < ab.getLocationOnScreen()
									.getY()
							|| e.getYOnScreen() > ab.getLocationOnScreen()
									.getY() + ab.getHeight()) {
						// System.out.println("out");
					} else {
						// System.out.println("(" +
						// ab.getLocationOnScreen().getX() + ", " +
						// ab.getLocationOnScreen().getY() + ") << ("
						// + e.getXOnScreen() + ", " + e.getYOnScreen() + ")");
						setLocation(
								(int) (ab.getLocationOnScreen().getX() - getParent()
										.getLocationOnScreen().getX()),
								(int) (ab.getLocationOnScreen().getY() - getParent()
										.getLocationOnScreen().getY()));
					}
				}
			}
		});
	}

	private void removeDragListeners() {
		for (MouseMotionListener listener : this.getMouseMotionListeners()) {
			removeMouseMotionListener(listener);
		}
		setCursor(Cursor.getDefaultCursor());
	}

	public boolean isDraggable() {
		return draggable;
	}

	public void setDraggable(boolean draggable) {
		this.draggable = draggable;
		if (draggable) {
			addDragListeners();
		} else {
			removeDragListeners();
		}
	}

	public Cursor getDraggingCursor() {
		return draggingCursor;
	}

	public void setDraggingCursor(Cursor draggingCursor) {
		this.draggingCursor = draggingCursor;
	}

}