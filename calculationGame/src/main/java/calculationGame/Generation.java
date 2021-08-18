package calculationGame;

import java.util.Random;

import javax.swing.JOptionPane;


public class Generation {
	
	private static final int NUMBER_GENERATION_SUM_SUBTRACT_RANGE = (int)Game.convertUserAnswer(JOptionPane.showInputDialog(null, "Set range for subtraction and sum equations",
																		"Calculation Game", 3));
	
	private static final int NUMBER_GENERATION_MULTIPLY_DIVIDE_RANGE = (int)Game.convertUserAnswer(JOptionPane.showInputDialog(null, "Set range for division and multiplication equations",
																		"Calculation Game", 3));
	
	//Yes is 0, No is 1, Cancel is 2
	private static final int allowNegatives = askForSettingPreferences("Do you want to include negative numbers in generation?");
	private static final int allowFractions = askForSettingPreferences("Do you want to include fractions in number generation?");
	
	private static int askForSettingPreferences(String s) {
		int temporary = JOptionPane.showConfirmDialog(null, s);
		if(temporary == 2) {
			System.exit(0);
			return 2; //this return is just so that program leaves me alone
		} else return temporary;
	}
	
	public static char generateEquationSign() {
		char[] signs = new char[] {'+','-','*','/'};
		return signs[new Random().nextInt(4)];
	}
	
		public static double generateNumberGivenEquationType(char sign) {
		if(sign == '+' || sign == '-') {
			return generateNumberGivenConditions(NUMBER_GENERATION_SUM_SUBTRACT_RANGE);
			} else return generateNumberGivenConditions(NUMBER_GENERATION_MULTIPLY_DIVIDE_RANGE);
		}

	
	private static double generateNumberGivenConditions(int range){
		if(allowNegatives == 0 && allowFractions == 0) { //allow both
			return (double)((new Random().nextInt(range*2*100)+1)-(range*100+1))/100;
		} else if(allowNegatives == 0 && allowFractions == 1) { //only allow negatives
			return (new Random().nextInt(range*2)+1)-(range+1);
		} else if(allowNegatives == 1 && allowFractions == 0) { //only allow fractions
			return (double)(new Random().nextInt(range*100)+1)/100;
		} else { //only positives
			return new Random().nextInt(range+1);
		}
	}
}
