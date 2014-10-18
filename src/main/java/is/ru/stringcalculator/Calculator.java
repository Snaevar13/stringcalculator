package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.contains(",") || text.contains("\n")
			|| text.contains("//") || text.contains("-")){
			return sum(splitNumbers(text));
		}
		else
			return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
		if(numbers.startsWith("//")){
			Character delimiter = numbers.charAt(2);
			numbers = numbers.substring(4);
			return numbers.split(",|\n|" + delimiter);
		}
		if(numbers.contains("-")){
		String negativeNumbers = "";
			for(int i = 0; i < numbers.length() - 1; i++){
				if(numbers.charAt(i) == '-'){
					negativeNumbers += "-" + numbers.charAt(i + 1);
				}
			}
			negativeNumbers = "Negatives not allowed:" + negativeNumbers;
			throw new IllegalArgumentException(negativeNumbers);
		}
	    return numbers.split(",|\n");
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
        	if(toInt(number) < 1001)
		    	total += toInt(number);
		}
		return total;
    }
}