package calculationGame;

import javax.swing.JOptionPane;

public class Game {

	public static void runGame() {
		JOptionPane.showMessageDialog(null, "This is mathematical game where you are presented with a mathematical expression, and have to provide an answer. \n"
				+ " You will be presented with two numbers. When dealing with decimals, round the result to two decimal places, and use dot to separate "
				+ "decimals from the rest of the numbers. \n Example: 1.23 instead of 1,23 or 1.12345. \n\n When you're done, just close the window. ");

		int attempts = 0;
		int correctGuesses = 0;
		MathematicalExpression expression;
		
		while(true) {
			//generating expression
			try {
				expression = new MathematicalExpression(Generation.generateEquationSign());
			} catch(Exception e) {
				System.out.print("division by 0 attempted. Rolling new equation");
				continue;
			}
			
			attempts +=1;
			
			//System.out.println("Debug - correct result: " + expression.getResult()); //made to check correct answers for testing purposes
			
			String response = JOptionPane.showInputDialog(null, expression.getExpression() + "=", "Calculation Game", 3);
			
			correctGuesses += compareResults(expression.getResult(), convertUserAnswer(response));
			
			JOptionPane.showMessageDialog(null, "Current attemps: " + attempts + ", of which corrects: " + correctGuesses);
		}
	}
	
	private static int compareResults(double correct, double playerGuess) {
		if(Double.compare(correct, playerGuess) == 0)
			return 1;
		else return 0;
	}
	
	public static double convertUserAnswer(String response) {
		if(response.length() == 0) {
			return 1;
		} else {
			try {
			return  Double.parseDouble(response);
			} catch(Exception e){
				System.exit(0);
				return 0;
			}
	}
}
}
