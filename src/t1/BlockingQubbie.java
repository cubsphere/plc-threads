package t1;

public class BlockingQubbie{
	private int[] elem;
	private int getIndex;
	private int putIndex;
	
	public BlockingQubbie() {
		elem = new int[1];
		getIndex = 0;
		putIndex = 0;
	}
	
	synchronized void insert (int i) {
		System.out.println(Thread.currentThread() + " inserting " + i);
		elem[putIndex] = i;
		++putIndex;
		if(putIndex >= elem.length) {
			int[] temp = new int[2*(putIndex - getIndex) + 1];
			for (int k = getIndex, l=0; k<putIndex; ++k,++l) {
				temp[l] = elem[k];
			}
			elem = temp;
			putIndex = putIndex - getIndex;
			getIndex = 0;
		}
	}
	
	synchronized int remove () {
		if(getIndex >= putIndex) throw new Error("beep");
		int temp = elem[getIndex];
		++getIndex;
		System.out.println(Thread.currentThread() + "              getting " + temp);
		return temp;
	}
}
