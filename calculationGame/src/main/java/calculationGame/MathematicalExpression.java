package calculationGame;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathematicalExpression {
	private String expression;
	private double result;
	
	
	public String getExpression() {
		return this.expression;
	}
	public double getResult() {
		return this.result;
	}
	
	public MathematicalExpression(char sign) {
		double a = Generation.generateNumberGivenEquationType(sign);
		double b = Generation.generateNumberGivenEquationType(sign);
		this.result = calculateResult(a, b, sign);
		this.expression = "" + a + " " + sign + " " + b;
	}
	
	
	public static double calculateResult(double a, double b, char sign) throws ArithmeticException{
		double result = 0;
		switch(sign) {
		case '+': result = round(a+b, 2); break;
		case '-': result = round(a-b, 2); break;
		case '*': result = round(a*b, 2); break;
		case '/':
			if(b == 0.0) 
				{throw new ArithmeticException("Division by 0 not allowed");
			} 
			else{
				result = round(a/b, 2); 
				break; 
				}
			}
		return result;
	}
	
	/*Source: https://stackoverflow.com/questions/2808535/round-a-double-to-2-decimal-places */
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = BigDecimal.valueOf(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
}
