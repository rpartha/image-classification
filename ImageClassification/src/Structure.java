import java.util.ArrayList;

public class Structure {
	char[][] arrList;
	boolean face;
	int val;
	public Structure(char[][] arrList, boolean face){
		this.arrList = arrList;
		this.face = face;
	}
	public Structure(char[][] arrList, int val){
		this.arrList = arrList;
		this.val = val;
	}
}
