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
    	String input = userInput.nextLine();
    	
    	System.out.println(produceAnswer(input));
    	
    }
    	/*String input = "input";
    	
    	
    while (!(input.equalsIgnoreCase("quit"))) {
    		input = userInput.nextLine();
    		System.out.println(produceAnswer(input));
    		input = userInput.nextLine();/*
    	 		
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
     */
     
    public static String produceAnswer(String input)
    {//does all of the work
        // TODO: Implement this function to produce the solution to the input
    	
    	/*operand
    	operator
    	
    	second operand*/
    
    	//operand
    	
    	
    	Scanner s = new Scanner(input);
    	String operand1 = s.next();
    	String operator = s.next();
    	String operand2 = s.next();
    	
    	
    	return operand2;
    	/*
    	String frac = input;
    	String operand1 = frac.substring(0, frac.indexOf(' '));
    	frac = frac.substring(frac.indexOf(' ') + 1);
    	String operator = frac.substring(0, frac.indexOf(' '));
    	frac = frac.substring(frac.indexOf(' ') + 1);
    	String operand2 = frac;
    	
    	
     
    	String op2Whole = findWhole(operand2);
    	String op2Num = findNum(operand2);
    	String op2Denom = findDenom(operand2);
    	String chk2Answer = "whole:" + op2Whole + " numerator:" 
    	+ op2Num + " denominator:" + op2Denom;
    	
        return chk2Answer; 
    }
    
    public static String findWhole(String str) {
    	
    	//mixed fraction 3_4/5
    	if(str.contains("_")) {
    		return str.substring(0, str.indexOf('_'));
    	}else if (str.contains("/")) {
    		return "0";
    	}else return str;
    		
   	}
    
    public static String findNum(String str) {
    	if(str.contains("_")) {
    		return str.substring(str.indexOf('_') + 1, str.indexOf('/'));
    	}else if(str.contains("/")) {
    		return str.substring(0,str.indexOf('/'));
    	}else {
    		return "0";
    	}
    		
    }
    
    public static String findDenom(String str) {
    	if(str.contains("/")) {
    		return str.substring(str.indexOf("/")+1);
    	}else{
    		return "1";
    	}
   
    }
    
    public static String evaluate(String operator, String operand1, String operand2) {
    	//addition*/
    	
   }
    	
    	
    	
    	
    	//fraction
    	//whole number
    	
    }

    // TODO: Fill in the space below with any helper methods that you think you will need


