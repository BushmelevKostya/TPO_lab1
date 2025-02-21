package task1;

import itmo.task1.TaylorMath;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TestFunction {
	
	private final int accuracy = 4;
	private final double EPSILON = Math.pow(0.1, accuracy);
	TaylorMath math = new TaylorMath(accuracy);
	
	private static Stream<Double> generateValues() {
		double arg = Math.PI / 8;
		return Stream.iterate(arg, n -> n + Math.PI).limit(3);
	}
	
	@ParameterizedTest
	@CsvSource({
			"0.0, 0",
			"1.0, 0.7854", //Math.PI / 4
			"0.0, 3.1415", //Math.PI
			"-1.0, 2.3562", //Math.PI * 3 / 4
			"-0.6359, 12",
			"-0.031, -254.5"
	})
	void testTg(double expected, double param) {
		assertEquals(expected, math.tg(param), EPSILON);
	}
	
	@ParameterizedTest
	@MethodSource("generateValues")
	void propertyTest(double param) {
		double value = 0.4142F;
		assertEquals(value, math.tg(param), EPSILON);
		assertEquals(-value, math.tg(-param), EPSILON);
	}
	
	@ParameterizedTest
	@ValueSource(doubles = { Math.PI / 2, 3 * Math.PI / 2})
	void testTgUndefined(double param) {
		assertThrows(ArithmeticException.class, () -> math.tg(param));
	}
	
	@Test
	void testTgIncrease() {
		assertTrue(math.derivative(math::tg, Math.PI / 6) > 0);
	}
}
