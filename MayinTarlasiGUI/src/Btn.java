import javax.swing.JButton;

public class Btn extends JButton{
	int row,col,count;
	boolean mine,flag;
	Btn(int row,int col) {
		this.row = row;
		this.col = col;
		this.mine = false;
		this.flag = false;
		this.count = 0;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public boolean isMine() {
		return mine;
	}
	public void setMine(boolean mine) {
		this.mine = mine;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
