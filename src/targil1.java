
public class targil1 { // the parking cars problem

	private int[]a;

	public targil1(int size) {
		a = new int[size];
	}
	public void setVal(int val, int i) {
		a[i] = val;
	}
	public int numOfCars() {
		int i =0, count=0;
		boolean flag = true;
		while(flag) {
			while(a[i]!=1000) {
				a[i]=1000;
				count++;
				i = (i+1)%a.length;
			}
			if(i==0) {
				a[i]=2000;
				i = a.length-1;

			}
			while(i>0) {
				a[i] = 2000;
				i--;
			}
			if(a[i]==2000)
				flag = false;
			else {
				a[i] = 0; // randomal number which is not 1000
				count = 0;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println();
		targil1 test = new targil1(10);
		System.out.println(test.numOfCars());
		test.setVal(1000, 3);
		test.setVal(1000, 5);
		test.setVal(1000, 8);
	}


}
