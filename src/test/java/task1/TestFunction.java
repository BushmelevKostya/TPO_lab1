package task1;

import itmo.task1.TaylorMath;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestFunction {
	
	private final int accuracy = 4;
	private final double EPSILON = Math.pow(0.1, accuracy);
	
	@Test
	void testTg() {
		TaylorMath math = new TaylorMath(accuracy);
		assertEquals(0.0, math.tg(0), EPSILON);
		assertEquals(1.0, math.tg(Math.PI / 4), EPSILON);
		assertEquals(0.0, math.tg(Math.PI), EPSILON);
		assertEquals(-1.0, math.tg(3 * Math.PI / 4), EPSILON);
		assertEquals(-0.6359, math.tg(12), EPSILON);
		assertEquals(-0.031, math.tg(-254.5), EPSILON);
	}
	
	@Test
	void propertyTest() {
		TaylorMath math = new TaylorMath(accuracy);
		double value = 0.4142F;
		double arg = Math.PI / 8;
		for (int i = 0; i < 100; i++) {
			assertEquals(value, math.tg(arg), EPSILON);
			assertEquals(-value, math.tg(-arg), EPSILON);
			arg += Math.PI;
		}
	}
	
	@Test
	void testTgUndefined() {
		TaylorMath math = new TaylorMath(accuracy);
		assertThrows(ArithmeticException.class, () -> math.tg(Math.PI / 2));
		assertThrows(ArithmeticException.class, () -> math.tg(3 * Math.PI / 2));
	}
}
