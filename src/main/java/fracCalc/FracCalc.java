
/**
 * @author Mr. Rasmussen
 */

package fracCalc;
import java.util.Scanner;
public class FracCalc {

    public static void main(String[] args)
    {
    	Scanner userInput = new Scanner(System.in);
    	System.out.print("Enter a fraction problem: ");
    	String input = "input";
    	input = userInput.nextLine();
    	
    while (!(input.equalsIgnoreCase("quit"))) {
    		System.out.println(produceAnswer(input));
    		System.out.println("Enter another fraction problem: ");
    		input = userInput.nextLine();
    	 		
    }
    	userInput.close();
    	
    	
 }   	
    	    	  
     
    public static String produceAnswer(String input)
    {//does all of the work
        // TODO: Implement this function to produce the solution to the input
    	

    
		/*// simple operation starts //////
		 * input = input.trim();
		 * 
		 * String frac = input; String operand1 = frac.substring(0, frac.indexOf(' '));
		 * frac = frac.substring(frac.indexOf(' ') + 1); String operator =
		 * frac.substring(0, frac.indexOf(' ')); frac = frac.substring(frac.indexOf(' ')
		 * + 1); String operand2 = frac;
		 * 
		 * String chk3Answer = "";
		 * 
		 * chk3Answer = evaluate(operator, operand1, operand2);
		 */////simple operation end //////
    	
    	//////////////////////////////// Multiple Operations Start/////////////////// 
        // it's fine for operations contain one or more spaces, example "   5_3/4   -   -6_8/8   -  5_3/4 "
        // store input in a string array
    	//extra credit
    	String[] fracStringArray = input.split("\\s+"); // The input string split into substrings by one or more spaces

    	if(fracStringArray.length<3) { // the arithmetic operation should have at least 3 elements, like 1 + 2, or 1 + 2 + 3
    		return "ERROR: Input is in an invalid format.";
    	}
    	
    	// invalid: 1 + 
    	// invalid: 1 + 2 +
    	// even number of operand and operator is invalid
    	if((fracStringArray.length % 2)==0) 
    		return "ERROR: Input is in an invalid format.";   

    	// simple operation 1 + 2 => string array ["1","+","2"], operand1 is "1", operator is "+", operand2 is "2"
    	// chk3Answer = evaluate("+", "1", "2"); so chk3Answer = 3
    	
    	String chk3Answer = "";
    	if(fracStringArray.length >= 3) {
    		String operand1 = fracStringArray[0]; // index 0 is the the 1st element in the array which is "1"
    		String operator = fracStringArray[1]; // index 1 is the the 2nd element in the array which is "+"
    		String operand2 = fracStringArray[2]; // index 2 is the the 3th element in the array which is "2"
    		chk3Answer = evaluate(operator, operand1, operand2);
    	}
    	
    	// multiple operations example 1 + 2 + 3 + 4
    	// from "1 + 2 " the above code section we got chk3Answer = 3
    	
    	// Next, first loop for " + 3 " do chk3Answer = evaluate("+", "chk3Answer", "3"), chk3Answer will be 3 + 3 = 6
    	// then second loop for " + 4 " do chk3Answer = evaluate("+", "chk3Answer", "4") chk3Answer will be 6 + 4 = 10
        for (int i=3; i < fracStringArray.length; i+=2) {
    		String operator = fracStringArray[i]; // index i is the the first element in the array which is "+"
    		String operand = fracStringArray[i+1]; // index i+1 is the the first element in the array which is "3"
    		chk3Answer = evaluate(operator, chk3Answer, operand);
    	}
        ////////////////////////////////Multiple Operations End/////////////////// 
        return chk3Answer; 
    }
    
    public static String findWhole(String str) {
    	  	
    	if(str.indexOf('_') != -1) {
    		return str.substring(0, str.indexOf('_'));
    	}else if (str.indexOf('/') != -1) {
    		return "0";
    	}else return str;
    		
   	}
    
    public static String findNum(String str) {
    	if(str.indexOf('_') != -1) {
    		return str.substring(str.indexOf('_') + 1, str.indexOf('/'));
    	}else if(str.indexOf('/') != -1 ) {
    		return str.substring(0,str.indexOf('/'));
    	}else {
    		return "0";
    	}
    		
    }
    
    public static String findDenom(String str) {
    	if(str.indexOf('/') != -1) {
    		return str.substring(str.indexOf("/")+1);
    	}else{
    		return "1";
    	}
    }
    
    public static String evaluate(String operator, String operand1, String operand2) {
    	String chk3Answer = "";
    	
    	chk3Answer = operation (operator, operand1, operand2);
    	return chk3Answer;
    	}
  //math operations  	
  public static String operation(String operator, String operand1, String operand2) {
        
        // find whole,num and denom from operand1 and operand2
        String op1Whole = findWhole(operand1);
        String op1Num = findNum(operand1);
        String op1Denom = findDenom(operand1);
            
        String op2Whole = findWhole(operand2);
        String op2Num = findNum(operand2);
        String op2Denom = findDenom(operand2);
        
        // check input numeric example 1_R/2 + 2_9/P
        if (!isNumeric(op1Whole) ||
            !isNumeric(op1Num)   ||
            !isNumeric(op1Denom) ||
            !isNumeric(op2Whole) ||
            !isNumeric(op2Num)   ||
            !isNumeric(op2Denom) ) {
                return "ERROR: operand is not numeric.";
            }
        
        // convert string to integer
        //parse fraction
        int  whole1 = Integer.parseInt(op1Whole);
        int  num1 = Integer.parseInt(op1Num);
        int  denon1 = Integer.parseInt(op1Denom);
        int  signed1 = 1;
        if (whole1 < 0) {
            signed1 = -1; // save the sign of the whole1
            whole1 = signed1 * whole1; // make whole1 always positive
        }
        
        int  whole2 = Integer.parseInt(op2Whole);
        int  num2 = Integer.parseInt(op2Num);
        int  denon2 = Integer.parseInt(op2Denom);

        int  signed2 = 1;
        if (whole2 < 0) {
            signed2 = -1; //save the sign of the whole2
            whole2 = signed2 * whole2; // make whole2 always positive
        }
         // check preconditions
         if ((denon1 == 0) || (denon2 == 0)) {
             return"ERROR: Cannot divide by zero."; 
             //cannot divide or multiply by 0
         }
        int denominator = 1;    // default set to 1, like 0/1
        int numerator = 0;     //default set to 0;
        int whole = 0;        //default set to 0;

        // operation calculation  
        //addition
        if(operator.equals("+")) {
            // example 1_2/3 + -4_5/6, denominator = 3 * 6 = 18
            denominator = denon1 * denon2; // 18            
            // numerator = (1 * denominator) + (2 * 6) * (1) + (-4)*denominator + (5*3) * (-1)
            numerator = (whole1 * denon1 + num1 ) * denon2 * signed1 +
                (whole2 * denon2 + num2) * denon1 * signed2;
        
        //subtract
        }else if(operator.equals("-")){
            // similar to the add function
            denominator = denon1 * denon2;            
            numerator = (whole1 * denon1 + num1 ) * denon2 * signed1 -
                (whole2 * denon2 + num2) * denon1 * signed2;
        
        //multiply
        }else if(operator.equals("*")){
            // example 2_3/4 * 5_6/7 = (2*4 + 3)/4 * (5*7 + 6)/7 
            // whole1 = 2, num1 = 3, denon1 = 4; whole2 = 5, num2 = 6, denon2 = 7; 
            // numerator = (2*4 + 3)*(5*7 + 6), denominator = 4*7
            denominator = denon1 * denon2;            
            numerator = (whole1 * denon1 + num1 ) * signed1 *
                (whole2 * denon2 + num2) * signed2;
    
        }
        //divide
        else if(operator.equals("/")){
            // example 2_3/4 / 5_6/7 = (2*4 + 3)/4 / (5*7 + 6)/7 
            // whole1 = 2, num1 = 3, denon1 = 4; whole2 = 5, num2 = 6, denon2 = 7; 
            // numerator = (2*4 + 3)*7, denominator = 4*(5*7 + 6)
            denominator = denon1 * ((whole2*denon2 + num2) * signed2);            
            numerator = denon2 * ((whole1*denon1 + num1) * signed1 );
                  
        }else {
            return "ERROR: Input is in an invalid format.";
        }      
        
        // example 2_3/4 * 5_6/7 = (2*4 + 3)/4 * (5*7 + 6)/7 
        // whole1 = 2, num1 = 3, denon1 = 4; whole2 = 5, num2 = 6, denon2 = 7;    
    
        whole = numerator/denominator;
        numerator = numerator%denominator;
        
           // if whole is not 0, it will carry the sign of the fraction, so make numerator always positive
        // else if whole is 0, numerator will carry the sign
        // 1_1/2 * -3/4 = -1_1/8
        if (whole != 0 && numerator < 0) {     // if whole is not 0, and numerator < 0 which is negative 
           numerator = numerator * (-1);       // then multiple -1 to make numerator positive
        }
        
        if (whole != 0 && denominator < 0) {     // if whole is not 0, and denominator < 0 which is negative 
            denominator = denominator * (-1);       // then multiple -1 to make denominator positive
         }
        
        if (whole == 0 && denominator < 0) {     // if whole is 0, and denominator < 0 ( negative ), put the negative sign in numerator
            denominator = denominator * (-1);    // by multiple -1 to make denominator positive
            numerator = numerator * (-1);        // and multiple -1 to make numerator negative
         }
        
        String wholeStr = "";
        
        if(whole != 0) {
            wholeStr = Integer.toString(whole);
        }
        String fractionStr = reduce(numerator, denominator);
        
        if(fractionStr.isEmpty() && wholeStr.isEmpty()) {
            return "0";  
        }
    
        if(fractionStr.isEmpty() || wholeStr.isEmpty()) {
            return wholeStr + fractionStr;  
        }

        return wholeStr + "_" + fractionStr;
    }
    
  
    //greatest common factor of 2 inputs
    public static int gcd(int denom1, int denom2)
    {
       int factor = denom2;
       while (denom2 != 0) {
          factor = denom2;
          denom2 = denom1 % denom2;
          denom1 = factor;
       }
       return denom1;
    }
    	
    public static String reduce(int numerator, int denominator)
    {
    	//improper fraction-->mixed fraction
    	
       int common = 0;
       // get absolute values for numerator and denominator
       int num = Math.abs(numerator);
       int den = Math.abs(denominator);//cannot be 0
       // figure out which is less, numerator or denominator
       if (num > den)
          common = gcd(num, den);
       else if (num < den)
          common = gcd(den, num);
       else  // if both are the same, don't need to call gcd
          common = num;

       numerator = numerator / common;
       denominator = denominator / common;
       
       if(numerator == 0) { 
     	  return "";
       }
       return Integer.toString(numerator) + "/" + Integer.toString(denominator);
    }
    
    // check if string is a number
   
    public static boolean isNumeric(String str)
    {
 	   if(str.charAt(0) == '-'|| str.charAt(0) == '+') {
 		   str = str.substring(1);
 	   }
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }
 }


