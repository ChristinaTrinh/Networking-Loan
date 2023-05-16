package Client;
import java.util.*;
import java.io.*;
import java.net.*;

public class Client
{
    public static void main(String[]args) throws IOException
    {
        Scanner console = new Scanner(System.in);
        System.out.println("Client");
        Socket socket = new Socket("localHost", 8000);
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        DataInputStream input = new DataInputStream(socket.getInputStream());
        while (true)
        {
            System.out.print("User, please enter an interest rate: ");
            double interestRate = console.nextDouble();
            output.writeDouble(interestRate);
            System.out.print("User, please enter a number of years: ");
            int years = console.nextInt();
            output.writeInt(years);
            System.out.print("User, please enter a loan amount: ");
            double loanAmount = console.nextDouble();
            output.writeDouble(loanAmount);
            double totalLoan = input.readDouble();  
            double monthlyPayment = input.readDouble();   
            System.out.println("Total Loan is: $" + totalLoan +"\n\n MonthlyPayments are: $" + monthlyPayment); 
            System.out.println();

            System.out.println("Would you like to do another calculation? (Yes/No)");
            String answer = console.next();
            if(answer.toLowerCase().equals("no"))
                break;
            System.out.println();
        }
    }
}
