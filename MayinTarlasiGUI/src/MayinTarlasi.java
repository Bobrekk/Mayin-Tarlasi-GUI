import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MayinTarlasi implements MouseListener{
	JFrame frame;
	Btn [] [] button = new Btn [10] [10];
	int openButton;
	MayinTarlasi() {
		openButton = 0;
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new GridLayout (10,10));
		frame.setSize(800,800);
		for (int row = 0; row < button.length; row++) {
			for (int col = 0; col < button [0].length; col++) {
				Btn b = new Btn (row,col);
				frame.add(b);
				button [row] [col] = b;
				b.addMouseListener(this);
			}
		}
		generateMine();
		updateCount();
		frame.setVisible(true);
	}
	public void generateMine() {
		int i = 0;
		while (i < 10) {
			int randRow = (int) (Math.random() * button.length);
			int randCol = (int) (Math.random() * button [0].length);
			while (button [randRow] [randCol].isMine()) {
				randRow = (int) (Math.random() * button.length);
				randCol = (int) (Math.random() * button [0].length);
			}
			button [randRow] [randCol].setMine(true);
			i++;
		}
	}
	public void print() {
		for (int row = 0; row < button.length; row++) {
			for (int col = 0; col < button [0].length; col++) {
				if (button [row] [col].isMine()) {
					button [row] [col].setIcon(new ImageIcon("Mine.png"));
				}
				else {
					button [row] [col].setText(button [row] [col].getCount() + "");
				}
				}
			}
	}
	public void printMine() {
		for (int row = 0; row < button.length; row++) {
			for (int col = 0; col < button [0].length; col++) {
				if (button [row] [col].isMine()) {
					button [row] [col].setIcon(new ImageIcon("Mine.png"));
				}
	}
		}
	}
	public void open (int r, int c) {
		if (r < 0 || r >= button.length || c < 0 || c >= button [0].length || button [r] [c].isEnabled() == false ) {
		return;
		}
		else if (button [r] [c].getCount() != 0) {
			button [r] [c].setText(button [r] [c].getCount() + "");
			button [r] [c].setEnabled(false);
			openButton++;
		}
		else {
			openButton++;
			button [r] [c].setEnabled(false);
			open (r-1,c);
			open (r+1,c);
			open (r,c-1);
			open (r,c+1);
		}
	}
	public void updateCount() {
		for (int row = 0; row < button.length; row++) {
			for (int col = 0; col < button [0].length; col++) {
				if (button [row] [col].isMine()) {
					counting(row,col);
				}
				}
			}
	}
	public void counting(int row, int col) {
		for (int r = row - 1; r <= row + 1; r++) {
			for (int c = col - 1; c <= col + 1; c++) {
				try {int value = button [r] [c].getCount();
				button [r] [c].setCount(++value);
				}
				catch(Exception e) {}
				}
			}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		Btn b = (Btn) e.getComponent();
		if (e.getButton() == 1) {
			System.out.println("Sol týk");
			if (b.isMine()) {
				JOptionPane.showMessageDialog(frame, "Mayýna bastýnýz!");
			}
			else {
				open (b.getRow(),b.getCol());
				if (openButton == (button.length*button[0].length) - 10) {
					JOptionPane.showMessageDialog(frame, "Tebrikler oyunu kazandýnýz!");
					print();
				}
			}
		}
		else if (e.getButton() == 3) {
			System.out.println("Sað týk");
			if (!b.isFlag()) {
				b.setIcon(new ImageIcon("Flag.png"));
				b.setFlag(true);
			}
			else {
				b.setIcon(null);
				b.setFlag(false);
			}
		} 
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
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
}
