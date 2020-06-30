import java.util.ArrayList;;
import java.util.List;

public class Account {

     String id;
     Person owner;
     int balance;
    List<Transaction> listOfTrans;

    public Account(String id, Person owner, int balance) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
        listOfTrans = new ArrayList<>();
    }

    @Override
    public String toString()
    {
        StringBuilder accOutput = new StringBuilder("*** Acc " + id + " ("+owner+"). Balance: "+balance+". Transactions:\n");
        for(Transaction t : listOfTrans) accOutput.append(t+"\n");
        return accOutput.toString();
    }
}
