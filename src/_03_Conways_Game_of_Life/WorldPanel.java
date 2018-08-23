package _03_Conways_Game_of_Life;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class WorldPanel extends JPanel implements MouseListener, ActionListener {
	private static final long serialVersionUID = 1L;
	private int cellsPerRow;
	private int cellSize;

	private Timer timer;

	// 1. Create a 2D array of Cells. Do not initialize it.

	Cell[][] cells;

	public WorldPanel(int w, int h, int cpr) {
		setPreferredSize(new Dimension(w, h));
		addMouseListener(this);
		timer = new Timer(500, this);
		this.cellsPerRow = cpr;

		// 2. Calculate the cell size.
		int size = w * h;
		// 3. Initialize the cell array to the appropriate size.
		cells = new Cell[h][cpr];
		// 3. Iterate through the array and initialize each cell.
		// Don't forget to consider the cell's dimensions when
		// passing in the location.
		for (int i = 0; i < cells[i].length; i++) {
			for (int j = 0; j < cells.length; j++) {
				cells[i][j] = new Cell(w, h, size);
			}
		}
	}

	public void randomizeCells() {
		// 4. Iterate through each cell and randomly set each
		// cell's isAlive memeber to true or false
		for (int i = 0; i < cells[i].length; i++) {
			for (int j = 0; j < cells.length; j++) {
				int r = new Random().nextInt();
				if (r % 2 == 0) {
					cells[i][j].isAlive = false;
				} else {
					cells[i][j].isAlive = true;
				}
			}
		}
		repaint();
	}

	public void clearCells() {
		// 5. Iterated through the cells and set them all to dead.
		for (int i = 0; i < cells[i].length; i++) {
			for (int j = 0; j < cells.length; j++) {
				cells[i][j].isAlive = false;
			}
		}
		repaint();
	}

	public void startAnimation() {
		timer.start();
	}

	public void stopAnimation() {
		timer.stop();
	}

	public void setAnimationDelay(int sp) {
		timer.setDelay(sp);
	}

	@Override
	public void paintComponent(Graphics g) {
		// 6. Iterate through the cells and draw them all

		for (int i = 0; i < cells[i].length; i++) {
			for (int j = 0; j < cells.length; j++) {
				cells[i][j].draw(g);
			}
		}

		// draws grid
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
	}

	// advances world one step
	public void step() {
		// 7. iterate through cells and get their neighbors
		//

		int[][] neighbors = new int[cellsPerRow][cellsPerRow];
		for (int i = 0; i < neighbors[cellsPerRow].length; i++) {
			for (int j = 0; j < neighbors.length; j++) {
				neighbors[i][j] = getLivingNeighbors(i, j);
			}
		}

		// 8. check if each cell should live or die
		for (int i = 0; i < cells[i].length; i++) {
			for (int j = 0; j < cells.length; j++) {
				cells[i][j].liveOrDie(neighbors[i][j]);
			}
		}
	}
	//

	// repaint();

	// 9. Complete the method.
	// It returns an array list of the 8 or less neighbors of the
	// cell identified by x and y
	
	///////*(above) no it doesn't, return an int.

	public int getLivingNeighbors(int x, int y) {
		int neighbors = 0;
		
//	  	0OO
//	  	0OO
//	    0OO
		if (x == 0) {
//		  	0OO
//		  	OOO
//		    OOO
			if (y == 0) {
				if (cells[x][y + 1].isAlive = true) {
					neighbors++;
				}
				if (cells[x + 1][y].isAlive = true) {
					neighbors++;
				}
				if (cells[x + 1][y + 1].isAlive = true) {
					neighbors++;
				}
			}
//		  	OOO
//		  	0OO
//		    OOO
			if (y != cells.length - 1 && y != 0) {
				if (cells[x][y + 1].isAlive = true) {
					neighbors++;

				}
				if (cells[x][y - 1].isAlive = true) {
					neighbors++;
				}
				if (cells[x + 1][y + 1].isAlive = true) {
					neighbors++;
				}
				if (cells[x + 1][y - 1].isAlive = true) {
					neighbors++;
				}
				if (cells[x + 1][y].isAlive = true) {
					neighbors++;
				}
			}
//		  	OOO
//		  	OOO
//		    0OO
			if (y == cells.length - 1) {
				if (cells[x][y + 1].isAlive = true) {
					neighbors++;
				}
				if (cells[x + 1][y].isAlive = true) {
					neighbors++;
				}
				if (cells[x + 1][y - 1].isAlive = true) {
					neighbors++;
				}

			}
		}
//	  	O0O
//	  	O0O
//	    O0O
		if (x != 0 && x != cells.length - 1) {
//		  	O0O
//		  	OOO
//		    OOO
			if (y == 0) {
				if (cells[x][y + 1].isAlive = true) {
					neighbors++;
				}
				if (cells[x - 1][y].isAlive = true) {
					neighbors++;
				}
				if (cells[x - 1][y + 1].isAlive = true) {
					neighbors++;
				}
				if (cells[x + 1][y].isAlive = true) {
					neighbors++;
				}
				if (cells[x + 1][y + 1].isAlive = true) {
					neighbors++;
				}
			}
//		  	OOO
//		  	O0O
//		    OOO
			if (y != 0 && y != cells.length - 1) {
				if (cells[x - 1][y - 1].isAlive = true) {
					neighbors++;
				}
				if (cells[x - 1][y].isAlive = true) {
					neighbors++;
				}
				if (cells[x - 1][y + 1].isAlive = true) {
					neighbors++;
				}

				if (cells[x + 1][y].isAlive = true) {
					neighbors++;
				}
				if (cells[x + 1][y + 1].isAlive = true) {
					neighbors++;
				}
				if (cells[x + 1][y - 1].isAlive = true) {
					neighbors++;
				}
				if (cells[x][y - 1].isAlive = true) {
					neighbors++;
				}
				if (cells[x][y + 1].isAlive = true) {
					neighbors++;
				}
			}
//		  	OOO
//		  	OOO
//		    O0O
			if (y != 0 && y != cells.length - 1) {
				if (cells[x - 1][y - 1].isAlive = true) {
					neighbors++;
				}
				if (cells[x - 1][y].isAlive = true) {
					neighbors++;
				}
				if (cells[x][y - 1].isAlive = true) {
					neighbors++;
				}
				if (cells[x + 1][y - 1].isAlive = true) {
					neighbors++;
				}
				if (cells[x + 1][y].isAlive = true) {
					neighbors++;
				}
			}
		}
//	  	OO0
//	  	OO0
//	    OO0
		if (x == cells.length - 1) {
//		  	OOO
//		  	OOO
//		    OO0
			if (y == cells.length - 1) {
				if (cells[x - 1][y].isAlive = true) {
					neighbors++;
				}
				if (cells[x][y - 1].isAlive = true) {
					neighbors++;
				}
				if (cells[x - 1][y - 1].isAlive = true) {
					neighbors++;
				}
			}

//		  	OOO
//		  	OO0
//		    OOO
			if (y != 0 && y != cells.length - 1) {
				if (cells[x - 1][y].isAlive = true) {
					neighbors++;
				}
				if (cells[x - 1][y - 1].isAlive = true) {
					neighbors++;
				}
				if (cells[x - 1][y + 1].isAlive = true) {
					neighbors++;
				}
				if (cells[x][y - 1].isAlive = true) {
					neighbors++;
				}
				if (cells[x][y + 1].isAlive = true) {
					neighbors++;
				}
			}
//		  	OO0
//		  	OOO
//		    OOO

			if (y == 0) {
				if (cells[x - 1][y].isAlive = true) {
					neighbors++;
				}
				if (cells[x][y + 1].isAlive = true) {
					neighbors++;
				}
				if (cells[x - 1][y + 1].isAlive = true) {
					neighbors++;
				}
			}

		}

		return neighbors;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// 10. Use e.getX() and e.getY() to determine
		// which cell is clicked. Then toggle
		// the isAlive variable for that cell.
		
		if(cells[e.getX()][e.getY()].isAlive = true) {
			cells[e.getX()][e.getY()].isAlive = false;
		}
		if(cells[e.getX()][e.getY()].isAlive = false) {
			cells[e.getX()][e.getY()].isAlive = true;
		}
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		step();
	}
}
