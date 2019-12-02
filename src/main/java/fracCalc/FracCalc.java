
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
    	    	
        // TODO: Read the input from the user and call produceAnswer with an equation
//still needs to run-user sentinel loop is going to run here//take input and parse it
    	//call produceAnswer
    	//system.out.println statement
    

    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
     
     
    public static String produceAnswer(String input)
    {//does all of the work
        // TODO: Implement this function to produce the solution to the input
    	
    	/*operand
    	operator
    	
    	second operand*/
    
    	//operand
    	
    	
    	/*Scanner s = new Scanner(input);
    	String operand1 = s.next();
    	String operator = s.next();
    	String operand2 = s.next();
    	
    	
    	return operand2;*/
    	input = input.trim();
    	
    	String frac = input;
    	String operand1 = frac.substring(0, frac.indexOf(' '));
    	frac = frac.substring(frac.indexOf(' ') + 1);
    	String operator = frac.substring(0, frac.indexOf(' '));
    	frac = frac.substring(frac.indexOf(' ') + 1);
    	String operand2 = frac;
    	
    	
     
    	/*String op2Whole = findWhole(operand2);
    	String op2Num = findNum(operand2);
    	String op2Denom = findDenom(operand2);
    	String chk2Answer = "whole:" + op2Whole + " numerator:" 
    	+ op2Num + " denominator:" + op2Denom;*/
    	String chk3Answer = "";
    	
    	chk3Answer = evaluate(operator, operand1, operand2);
    	
        return chk3Answer; 
    }
    
    public static String findWhole(String str) {
    	
    	//mixed fraction 3_4/5
    	
    	
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
    		/*if(operator.equals("+")) {
    			chk3Answer = add(operand1, operand2);
    		}else if(operator.equals("-")) {
    			chk3Answer = subtract(operand1, operand2);
    		}else if(operator.equals("*")) {
    			chk3Answer = multiply(operand1, operand2);
    		}else if(operator.equals("/")) {
    			chk3Answer = divide(operand1, operand2);
    		}else {
    			return "ERROR: Input is in an invalid format.";//extra credit?
    		}*/
    	chk3Answer = operation (operator, operand1, operand2);
    	return chk3Answer;
    	}
    	
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
         }
        int denominator = 1;// default set to 1, like 0/1
        int numerator = 0;     //default set to 0;
        int whole = 0;        //default set to 0;

        // operation calculation        
        if(operator.equals("+")) {
            // example 1_2/3 + -4_5/6, denominator = 3 * 6 = 18
            denominator = denon1 * denon2; // 18            
            // numerator = (1 * denominator) + (2 * 6) * (1) + (-4)*denominator + (5*3) * (-1)
//            numerator = (whole1 * denominator) + (num1 * denon2) * signed1 + 
//                (whole2 * denominator) + (num2 * denon1) * signed2;
            numerator = (whole1 * denon1 + num1 ) * denon2 * signed1 +
                (whole2 * denon2 + num2) * denon1 * signed2;
            
        }else if(operator.equals("-")){
            // comments are similar to the add function
            denominator = denon1 * denon2;            
            numerator = (whole1 * denon1 + num1 ) * denon2 * signed1 -
                (whole2 * denon2 + num2) * denon1 * signed2;
            
        }else if(operator.equals("*")){
            // example 2_3/4 * 5_6/7 = (2*4 + 3)/4 * (5*7 + 6)/7 
            // whole1 = 2, num1 = 3, denon1 = 4; whole2 = 5, num2 = 6, denon2 = 7; 
            // numerator = (2*4 + 3)*(5*7 + 6), denominator = 4*7
            // numerator = (whole1*denon1 + num1)*(whole2*denon2 + num2)  
            // denominator = denon1*denon2
            denominator = denon1 * denon2;            
            numerator = (whole1 * denon1 + num1 ) * signed1 *
                (whole2 * denon2 + num2) * signed2;
    
        }
        else if(operator.equals("/")){
            // example 2_3/4 / 5_6/7 = (2*4 + 3)/4 / (5*7 + 6)/7 
            // whole1 = 2, num1 = 3, denon1 = 4; whole2 = 5, num2 = 6, denon2 = 7; 
            // numerator = (2*4 + 3)*7, denominator = 4*(5*7 + 6)
            denominator = denon1 * ((whole2*denon2 + num2) * signed2);            
            numerator = denon2 * ((whole1*denon1 + num1) * signed1 );
        }else {
            return "ERROR: Input is in an invalid format.";
        }      
        
/*        // example 2_3/4 * 5_6/7 = (2*4 + 3)/4 * (5*7 + 6)/7 
        // whole1 = 2, num1 = 3, denon1 = 4; whole2 = 5, num2 = 6, denon2 = 7; 
        // numerator = (2*4 + 3)*(5*7 + 6), denominator = 4*7
        // numerator = (whole1*denon1 + num1)*(whole2*denon2 + num2)  
        // denominator = denon1*denon2
        int denominator = denon1 * denon2;
        
        int numerator = ((whole1 * denon1) + num1 * signed1) *
            ((whole2 * denon2) + num2 * signed2);
    
    */
        whole = numerator/denominator;
        numerator = numerator%denominator;
        
           // if whole is not 0, it will carry the sign of the fraction, so make numerator always positive
        // else if whole is 0, numerator will carry the sign
        // 1_1/2 * -3/4 = -1_1/8
        if (whole != 0 && numerator < 0) {     // if whole is not 0, and numerator < 0 which is negative 
           numerator = numerator * (-1);       // then multiple -1 to make numerator positive
        }
        
        if (whole != 0 && denominator < 0) {     // if whole is not 0, and denom < 0 which is negative 
            denominator = denominator * (-1);       // then multiple -1 to make denom positive
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
    
    //greatest common factor
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
       int common = 0;
       // get absolute values for numerator and denominator
       int num = Math.abs(numerator);
       int den = Math.abs(denominator);
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
    
    // check a string is a number
   
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



    	//fraction	
    	//whole number
    	

    // TODO: Fill in the space below with any helper methods that you think you will need



