package itmo;

import itmo.task2.SkewHeap;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		SkewHeap skewHeap = new SkewHeap();
		skewHeap.insert(89);
		skewHeap.insert(4);
		skewHeap.insert(1);
		skewHeap.insert(385);
		skewHeap.insert(4);
		skewHeap.insert(7);
		skewHeap.insert(25);
		skewHeap.insert(1);
		skewHeap.insert(98);
		skewHeap.insert(89);
		skewHeap.insert(8);
		skewHeap.printHeap();
	}
}