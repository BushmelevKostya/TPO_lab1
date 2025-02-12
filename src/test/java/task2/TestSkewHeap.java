package task2;

import itmo.task2.SkewHeap;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestSkewHeap {
	
	@Test
	public void testInsert() {
		SkewHeap heap = new SkewHeap();
		heap.insert(4);
		heap.insert(89);
		heap.insert(1);
		heap.insert(385);
		heap.insert(4);
		heap.insert(7);
		heap.insert(25);
		heap.insert(1);
		heap.insert(98);
		heap.insert(89);
		heap.insert(8);
		List<Integer> expected = List.of(1, 4, 8, 25, 89, 4, 98, 1, 89, 7, 385);
		assertEquals(expected, heap.traverseLeftToRight());
	}
	
	@Test
	public void testInsertEqual() {
		SkewHeap heap = new SkewHeap();
		heap.insert(1);
		heap.insert(1);
		heap.insert(1);
		List<Integer> expected = List.of(1, 1, 1);
		assertEquals(expected, heap.traverseLeftToRight());
	}
	
	@Test
	public void testMerge() {
		SkewHeap heap = new SkewHeap();
		heap.insert(10);
		heap.insert(5);
		heap.insert(20);
		
		assertEquals(5, heap.removeSmallest());
		assertEquals(10, heap.removeSmallest());
		assertEquals(20, heap.removeSmallest());
	}
		
		@Test
		public void testRemoveSmallest() {
			SkewHeap heap = new SkewHeap();
			heap.insert(15);
			heap.insert(5);
			heap.insert(25);
			heap.insert(3);
			
			assertEquals(3, heap.removeSmallest());
			assertEquals(5, heap.removeSmallest());
			assertEquals(15, heap.removeSmallest());
			assertEquals(25, heap.removeSmallest());
			
			assertThrows(IllegalStateException.class, heap::removeSmallest);
		}
		
		@Test
		public void testClear() {
			SkewHeap heap = new SkewHeap();
			heap.insert(30);
			heap.insert(10);
			heap.clear();
			assertThrows(IllegalStateException.class, heap::removeSmallest);
		}
	}