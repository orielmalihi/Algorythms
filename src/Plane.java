import java.util.Arrays;

public class Plane {
	Node[][] mat;
	int size;
	
	
	public Plane(int n) {
		size = n;
		mat = new Node[n][n];
		for(int i = 0; i<mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				int rx = (int)(Math.random()*20);
				int ry = (int)(Math.random()*20);
				mat[i][j] = new Node(rx,ry);
			}
		}
	}
	
	public int getBestVal() {
		mat[0][0].bestlengt = 0;
		for(int i = 1; i<mat.length; i++) {
			mat[i][0].bestlengt = mat[i-1][0].bestlengt + mat[i-1][0].y;
			mat[0][i].bestlengt = mat[0][i-1].bestlengt + mat[0][i-1].x;
		}
		for(int i = 1; i<mat.length; i++) {
			for(int j = 1; j<mat.length; j++) {
				mat[i][j].bestlengt =Math.min(mat[i-1][j].bestlengt + mat[i-1][j].y,mat[i][j-1].bestlengt + mat[i][j-1].x);
			}
		}
		return mat[size-1][size-1].bestlengt;
		
	}
	
	public String toString() {
		String ans = "";
		for(int i =0; i<mat.length; i++) {
			ans += Arrays.toString(mat[i])+"\n";
		}
		return ans;
	}
	
	
	 class Node {
		int x;
		int y;
		int bestlengt = 0;
		
		public Node(int xx, int yy) {
			x = xx;
			y = yy;
		}
		
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
		public int getBestLength() {
			return bestlengt;
		}
		
		public String toString() {
			return "y:"+y+",x:"+x+",bl:"+bestlengt;
		}
	}
	 
	 public static void main(String[] args) {
		 Plane p = new Plane(10);
		 int bestlength = p.getBestVal();
		 System.out.println(p);
		 System.out.println("**********");
		 System.out.println("best length is "+bestlength);
		 
		
	}

}
