package Server;
import java.util.*;
import java.io.*;
import java.net.*;
public class Server{
    public static void main(String[]args) throws IOException{
        System.out.println("Server");
        ServerSocket serversocket = new ServerSocket(8000);
        Socket socket = serversocket.accept();
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        DataInputStream input = new DataInputStream(socket.getInputStream());
        double interestRate=0;
        int years=0;
        double loanAmount=0;
        while (true){
            interestRate = input.readDouble();
            System.out.println("InterestRate: "+interestRate);
            years = input.readInt();
            System.out.println("Years: "+years);
            loanAmount = input.readDouble();
            System.out.println("LoanAmount: "+loanAmount);
            
            double totalPayment = loanAmount + loanAmount * (interestRate / 100.0) * years;
            output.writeDouble(totalPayment);
            
            double monthlyPayment = (totalPayment)/(years*12);
            int month = (int)(monthlyPayment*100);
            monthlyPayment = month/100.0;
            output.writeDouble(monthlyPayment);
        }
    }
}

