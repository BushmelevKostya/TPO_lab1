package itmo.task2;

public class SkewHeap {
	private SkewHeapNode root;
	
	public SkewHeap() {
		this.root = null;
	}
	
	public void insert(int value) {
		SkewHeapNode newNode = new SkewHeapNode(value);
		root = merge(root, newNode);
	}
	
	private SkewHeapNode merge(SkewHeapNode left, SkewHeapNode right) {
		if (left == null) return right;
		if (right == null) return left;
		if (left.getValue() > right.getValue()) {
			SkewHeapNode temp = left;
			left = right;
			right = temp;
		}
		SkewHeapNode temp = left.getLeft();
		left.setLeft(merge(left.getRight(), right));
		left.setRight(temp);
		
		return left;
	}
	
	public Integer removeSmallest() throws IllegalArgumentException {
	    if (root == null) throw new IllegalStateException("Empty Heap");
	    Integer minValue = root.getValue();
	    root = merge(root.getLeft(), root.getRight());
	    return minValue;
	}
	
	public void clear() {
		root = null;
	}
	
	public void printHeap() {
		printHeap(root, "", true);
	}
	
	private void printHeap(SkewHeapNode node, String prefix, boolean isLeft) {
		if (node != null) {
			System.out.println(prefix + (isLeft ? "├── " : "└── ") + node.getValue());
			printHeap(node.getLeft(), prefix + (isLeft ? "│   " : "    "), true);
			printHeap(node.getRight(), prefix + (isLeft ? "│   " : "    "), false);
		}
	}
}
