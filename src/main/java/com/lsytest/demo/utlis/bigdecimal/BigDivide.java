package bigdecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDivide {
	public static void main(String[] args) {
		BigDecimal bi1 = new BigDecimal("2");
		BigDecimal bi2 = new BigDecimal("3");
		BigDecimal divide = bi1.divide(bi2, 2, RoundingMode.HALF_UP);

		System.out.println(divide.doubleValue());

	}

}
