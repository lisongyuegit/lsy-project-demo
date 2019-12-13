package bigdecimal;

import java.math.BigDecimal;


public class BigDecimalTest {
public static void main(String[] args) {
	BigDecimal aa = BigDecimal.ZERO;
	BigDecimal bb = new BigDecimal("0");
	System.out.println("aa: "+aa);
	System.out.println("bb: "+bb);
	System.out.println(aa == bb);
	System.out.println(aa.compareTo(bb));	
}
}

