package t2;

public class Tree {
	double val;
	Tree left;
	Tree right;

	public Tree(double v) {
		this.val = v;
		this.left = null;
		this.right = null;
	}

	public int size() {
		int Lsize;
		int Rsize;

		if (left == null) {
			Lsize = 0;
		} else {
			Lsize = left.size();
		}

		if (right == null) {
			Rsize = 0;
		} else {
			Rsize = right.size();
		}

		return Lsize + Rsize + 1;
	}

	public void insert(double v) {
		boolean goLeft = v < this.val;
		boolean inserted = false;

		if (goLeft) {
			synchronized (this) {
				if (this.left == null) {
					inserted = true;
					this.left = new Tree(v);
				}
			}
		} else {
			synchronized (this) {
				if (this.right == null) {
					inserted = true;
					this.right = new Tree(v);
				}
			}
		}

		if (!inserted) {
			if (goLeft) {
				this.left.insert(v);
			} else {
				this.right.insert(v);
			}
		}
	}
}
