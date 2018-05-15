package t2;

public class TreeMain {

	public static void main(String[] args) throws InterruptedException {
		Tree t = new Tree(0.5);
		Thread[] threads = new Thread[40];
		
		for(int i = 0; i< threads.length; ++i) {
			threads[i] = new TreeThread(t);
		}
		
		for(int i = 0; i< threads.length; ++i) {
			threads[i].start();
		}
		long n = System.nanoTime();
		for(int i = 0; i< threads.length; ++i) {
			threads[i].join();
		}
		System.out.println(System.nanoTime() - n);

		t = new Tree(0.5);
		n = System.nanoTime();
		for (int i = 0; i < threads.length * 2000; ++i) {
			t.insert(Math.random());
		}
		System.out.println(System.nanoTime() - n);
		
	}

}
