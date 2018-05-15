package t2;

public class TreeThread extends Thread {
	Tree t;

	public TreeThread(Tree t) {
		this.t = t;
	}

	public void run() {
		for (int i = 0; i < 2000; ++i) {
			t.insert(Math.random());
		}
	}
}
