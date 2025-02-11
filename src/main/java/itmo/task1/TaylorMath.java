	package itmo.task1;
	
	import static java.lang.Math.pow;
	import static java.lang.Math.round;
	import static java.lang.Math.abs;
	
	public class TaylorMath {
		
		private final int accuracy;
		
		public TaylorMath(int accuracy) {
			this.accuracy = accuracy;
		}
		
		public Double tg(double x) {
			if (abs(x % Math.PI) < 1e-10) {
				return 0.0;
			}
			if (abs(cos(x)) < 1e-10) {
				throw new ArithmeticException("Тангенс не определен для x = " + x);
			}
			return (double) round(sin(x) / cos(x) * pow(10, accuracy)) / pow(10, accuracy);
		}
		
		public Double cos(double x) {
			x = x % (2 * Math.PI);
			if (abs(x % (Math.PI / 2)) < 1e-10) {
				return (Math.round(x / (Math.PI / 2)) % 2 == 0) ? 1.0 : 0.0;
			}
			
			double ans = 0;
			double temp;
			int k = 0;
			do {
				temp = pow(-1, k) * pow(x, 2 * k) / factorial(2 * k);
				if (Double.isInfinite(temp)) break;
				ans += temp;
				k++;
			} while (abs(temp) >= pow(10, -this.accuracy));
			return ans;
		}
		
		public Double sin(double x) {
			x = x % (2 * Math.PI);
			if (abs(x % Math.PI) < 1e-10) {
				return 0.0;
			}
			
			double ans = 0;
			double temp;
			int k = 0;
			do {
				temp = pow(-1, k) * pow(x, 2 * k + 1) / factorial(2 * k + 1);
				if (Double.isInfinite(temp)) break;
				ans += temp;
				k++;
			} while (abs(temp) >= pow(10, -this.accuracy));
			return ans;
		}
		
		private double factorial(int n) {
			if (n < 0) throw new IllegalArgumentException("n должен быть неотрицательным");
			double result = 1.0;
			for (int i = 2; i <= n; i++) {
				result *= i;
				if (Double.isInfinite(result)) {
					throw new ArithmeticException("Переполнение факториала");
				}
			}
			return result;
		}
	}
