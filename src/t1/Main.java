package t1;

public class Main {

	public static void main(String[] args) {
		int nt = 8;
		int inc = 1;
		Thread[] threads = new Thread[8];
		BlockingQubbie bq = new BlockingQubbie();
		
		for(int i = 0; i<nt; ++i) {
			threads[i] = new QubbieThread(i*inc, i*inc + inc, bq);
		}
		for(int i = 0; i<nt; ++i) {
			threads[i].start();
		}
	}

}
