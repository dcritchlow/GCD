package GcdNoFunction;

import java.util.Scanner;

public class GcdNoFunction
{

    public static void main(String[] args)
        {
            //create input object
            Scanner input = new Scanner(System.in);
            //init
            int firstNumber = 0;
            int secondNumber = 0;

            //output
            System.out.println("Enter your first number: ");
            //input
            firstNumber = input.nextInt();
            //output
            System.out.println("Enter your second number: ");
            //input
            secondNumber = input.nextInt();

            while (firstNumber < secondNumber || firstNumber > secondNumber)
            {
                if (firstNumber > secondNumber)
                {
                    firstNumber -= secondNumber;
                }
                if (secondNumber > firstNumber)
                {
                    secondNumber -= firstNumber;
                }
            }
            if (firstNumber == 1 || secondNumber == 1)
            {
                System.out.println("The Greatest Common Divisor is 1");
            }
            else
            {
                System.out.println("The Greatest Common Divisor is "+ firstNumber);
            }
        }//end of main method

}//end of class
