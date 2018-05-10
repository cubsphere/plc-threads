package t1;

public class QubbieThread extends Thread {
	int s;
	int e;
	BlockingQubbie bq;
	
	public QubbieThread (int s, int e, BlockingQubbie bq) {
		this.s = s;
		this.e = e;
		this.bq = bq;
	}
	
	public void run() {
		for(int i = s; i<e; ++i) {
			bq.insert(i);
		}
		
		for(int i = s; i<e; ++i) {
			bq.remove();
		}
	}
}
