import java.util.Formatter;
import java.util.Locale;

public class Transaction
{

     long timeStamp;
     Account source;
     Account target;
     int amount;
     TypesOfTransaction type;


    public Transaction(Account source, Account target, int amount, TypesOfTransaction type) {
        timeStamp = System.currentTimeMillis();
        this.source = source;
        this.target = target;
        this.amount = amount;
        this.type = type;
    }

    @Override
    public String toString()
    {
        StringBuilder output = new StringBuilder();
        Formatter formatter = new Formatter(output, Locale.US);
        formatter.format("%6d", amount);
        output.append(": " + type);
        if(type == TypesOfTransaction.TRANS_TO)
        {
            output.append(" this account from " + source.owner +"("+source.id+")");
        }
        if(type == TypesOfTransaction.TRANS_FROM)
        {
            output.append(" this account to " + target.owner +"("+target.id+")");
        }
        return output.toString();
    }
}

