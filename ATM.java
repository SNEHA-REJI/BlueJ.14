import java.io.*;
class InsufficientBalance extends Exception {
    public InsufficientBalance(String message) {
        super(message);
    }
}
class BankATM {
    private String acc_num;
    private double balance;

    public BankATM(String acc_num)
    {
        this.acc_num = acc_num;
        this.balance = readAccountBalance();
    }

    public double getBalance()
    {
        return balance;
    }
    public void Deposit(double dep)
    {
	if (dep <= 0) {
            System.out.println("Invalid deposit amount");
            return;
        }
        balance += dep;
        writeAccountBalance();
        System.out.println("Deposit of " + dep + " successful.");
    }
    public void Withdraw(double with)
    {
    	try
    	{
        if (with<= 0)
        {
            System.out.println("Invalid withdrawal amount");
        }
	if (with >balance)
	{
            throw new InsufficientBalance("Insufficient balance. Withdrawal failed.");
        }

             balance -=with;
             writeAccountBalance();
             System.out.println("Withdrawal of " + with+ " successful.");
    	}
    	catch(InsufficientBalance e)
    	{
    	      System.out.println("ACCOUNT BALANCE INSUFFICIENT");
	      e.printStackTrace();
    	}
    	finally
    	{
	      System.out.println("Balance in the Account:"+balance);
    	}
    }
    public void Transfer(BankATM recipient, double trans)
    {
	try
	{
        if(this== recipient) {
            System.out.println("You cannot transfer to your own account.");
        }
        if (trans <= 0) {
            System.out.println("Invalid transfer amount.");
        }
        if (trans > balance) {
            throw new InsufficientBalance("Insufficient balance. Transfer failed.");
        }
        balance -= trans;
        recipient.balance += trans;
        writeAccountBalance();
        recipient.writeAccountBalance();
        System.out.println("Transfer of " + trans+ " successful.");
	}
	catch(InsufficientBalance e)
    	{
    	      System.out.println("ACCOUNT BALANCE INSUFFICIENT");
	      e.printStackTrace();
    	}
    	finally
    	{
	      System.out.println("Balance in the Account:"+balance);
    	}
    }
    private double readAccountBalance() {
        try
	{
	BufferedReader br= new BufferedReader(new FileReader(acc_num+ ".txt"));
        return Double.parseDouble(br.readLine());
        }
	catch (FileNotFoundException e) {
            return 0.0;
        } catch (IOException e) {
            System.out.println("An error occurred while reading the account balance.");
            return 0.0;
        }
    }

    private void writeAccountBalance() {
        try
	{
	BufferedWriter wr= new BufferedWriter(new FileWriter(acc_num+ ".txt"));
            wr.write(Double.toString(balance));
	    wr.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing the account balance.");
        }
    }
}

public class ATM
{
public static void main(String[] args)
{
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
BankATM atm= null;
BankATM recipients=null;
int choice;
try {
      System.out.println("Enter your account number: ");
      String acc_num = br.readLine();
      atm = new BankATM(acc_num);
      do{
           System.out.println("Operations");
           System.out.println("1. Deposit");
           System.out.println("2. Withdraw");
           System.out.println("3. Transfer");
           System.out.println("4.View Balance");
           System.out.println("5. Exit");
           System.out.print("Select the operation to be performed:");
           choice = Integer.parseInt(br.readLine());
           double deposit,withdraw,transfer;
           switch(choice)
           {
                case 1:
                {
                    System.out.println("Enter the deposit amount:");
                    deposit= Double.parseDouble(br.readLine());
                    atm.Deposit(deposit);
                    break;
                }
                case 2:
                {
                    System.out.println("Enter the withdrawal amount:");
                    withdraw= Double.parseDouble(br.readLine());
                    atm.Withdraw(withdraw);
                    break;
                }
                case 3:
                {
                    System.out.println("Enter recipient's account number: ");
                    String recipient_Acc= br.readLine();
                    recipients=new BankATM(recipient_Acc);
                    System.out.println("Enter the transfer amount:");
                    transfer= Double.parseDouble(br.readLine());
		    atm.Transfer(recipients,transfer);
                    break;
                }
                case 4:
                {
                    System.out.println("Current Balance:" + atm.getBalance());
                    break;
                }
                case 5:
                {
                    System.out.println("THANK YOU FOR USING THE ATM...");
                    break;
                }
                default:
                {
                    System.out.println("INVALID OPTION!");
                    break;
                }
            }
         }
         while(choice!=5);
    }
catch (NumberFormatException e)
{
    System.out.println("Invalid input. Please enter a number.");
}
catch(NullPointerException e)
{
     System.out.println("NullPointerException Caught");
}
catch (IOException e)
{
    System.out.println("An error occurred while reading input.");
}
finally
{
if(atm != null)
{
    System.out.println("Current Balance:" + atm.getBalance());
    try {
           br.close();
	   
        }
    catch (IOException e)
        {
           System.out.println("An error occurred while closing the input stream.");
        }
} }
}
}


