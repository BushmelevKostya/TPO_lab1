package itmo.task2;

public class SkewHeapNode {
	private final Integer value;
	private SkewHeapNode left;
	private SkewHeapNode right;
	
	public SkewHeapNode(Integer value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
	
	public SkewHeapNode getRight() {
		return right;
	}
	
	public void setRight(SkewHeapNode right) {
		this.right = right;
	}
	
	public SkewHeapNode getLeft() {
		return left;
	}
	
	public void setLeft(SkewHeapNode left) {
		this.left = left;
	}
	
	public Integer getValue() {
		return value;
	}
}
