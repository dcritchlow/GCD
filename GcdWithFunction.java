package GcdWithFunction;

import java.util.Scanner;

public class GcdWithFunction 
{
    public static void main(String[] args)
    {
        //create input object
        Scanner input = new Scanner(System.in);
        //create String object
        String numString = new String();
        //initialize variables
        int num1 = 0;
        int num2 = 0;
        
        //output
        System.out.println("Enter a number between 1-99, or \"Y\" to quit");
        
        //input info typed into numString object
        numString = input.nextLine();
        
        //check for quit to stop program
        if(numString.equalsIgnoreCase("y"))
        {
            System.out.println("bye bye");
        }
        //go on with the program
        else
        {
            //save input to first number
            num1 = Integer.parseInt(numString);
            
            //check for correct number range
            while(num1 < 1 || num1 > 99)
            {
                //output for new number with correct range
                System.out.println("Please enter a number between 1-99");
                //input to num1 with new number
                num1 = input.nextInt();
            }
            //output for second number
            System.out.println("Please enter another number between 1-99");
            
            //save input to second number
            num2 = input.nextInt();
            
            //check for correct number range
            while(num2 < 1 || num2 > 99)
            {
                //output for new number with correct range
                System.out.println("Please enter a number between 1-99");
                //input to num2 with new number
                num2 = input.nextInt();
            }

            //print a blank line for the look of the output :)
            System.out.println();
            //output to user
            System.out.println("The GCD is: "+ getGCD(num1, num2));
        }
    }//end of main
    
    public static int getGCD(int numA, int numB)
    {
        //loop through numbers till I am ready to output
        while(numA > 1 )
        {
            //check to see if I already have the answer
            if(numA == numB)
            {
                return numA;
            }
            //else lets do the work to figure it out
            else if(numA > numB)
            {
                numA = numA - numB;
            }
            else
            {
                numB = numB - numA;
            }
        }
        //my return statement not held hostage by my "if" condition
        return numA;
    }//end getGCD method
}//end of class
