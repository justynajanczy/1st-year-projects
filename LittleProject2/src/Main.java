import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;


public class Main
{
    public static void main(String[] args) {
        String fIn = "Bank.dat";
        String fErr = "Bank.err";
        Map<String, Account> accs = readData(fIn, fErr);

        for (Map.Entry<String, Account> e : accs.entrySet())
            System.out.print(e.getValue());

        try {
            String errLog = new String(
                    Files.readAllBytes(Paths.get(fErr)), UTF_8);
            System.out.println("\nContent of " +
                    "\"Bank.err\" follows:\n");
            System.out.println(errLog);
        } catch (IOException e) {
            System.out.println("Problems with error log");
            return;
        }
    }

    public static Map<String, Account> readData(String fIn, String fErr) {

        Map<String, Account> output = new HashMap<>();
        try (Stream<String> lines = Files.lines(Paths.get(fIn))) {

            FileWriter myWriter = new FileWriter(fErr);
            String[] arr = lines.toArray(String[]::new);

            for (int i = 0; i < arr.length; i++) {
                String[] line = arr[i].split(" ");


                switch (line.length) {
                    //creation of a new account
                    case 4:
                        try {
                            if (Integer.parseInt(line[3]) < 0) {
                                myWriter.write("Line " + (i + 1) + ": " + arr[i] + "\n" +
                                        "    Error: Non-positive initial deposit\n");

                            } else if (output.containsKey(line[0])) {
                                myWriter.write("Line " + (i + 1) + ": " + arr[i] + "\n" +
                                        "    Error: Account already exists\n");
                            } else {
                                output.put(line[0], new Account(
                                                         line[0],
                                                         new Person(line[1], line[2]),
                                                         Integer.parseInt(line[3])));

                                output.get(line[0]).listOfTrans
                                        .add(
                                                new Transaction(
                                                        null,
                                                        output.get(line[0]),
                                                        Integer.parseInt(line[3]),
                                                        TypesOfTransaction.INIT_DEPOS));
                            }
                        } catch (NumberFormatException e) {
                            myWriter.write("Line " + (i + 1) + ": " + arr[i] + "\n" +
                                    "    Error: Amount expected\n");
                        }
                        break;

                    //transfer between accounts
                    case 3:
                        try {
                            if (Integer.parseInt(line[2]) > output.get(line[0]).balance) {
                                myWriter.write("Line " + (i + 1) + ": " + arr[i] + "\n" +
                                        "    Error: Insufficient funds\n");
                            } else if (!output.containsKey(line[0]) || !output.containsKey(line[1])) {
                                myWriter.write("Line " + (i + 1) + ": " + arr[i] + "\n" +
                                        "    Error : At least one of the accounts doesn't exist\n");
                            } else {
                                //sender account
                                output.get(line[0]).balance -= Integer.parseInt(line[2]);
                                output.get(line[0]).listOfTrans
                                        .add(
                                                new Transaction(
                                                        output.get(line[0]),
                                                        output.get(line[1]),
                                                        -Integer.parseInt(line[2]),
                                                        TypesOfTransaction.TRANS_FROM));

                                //recipient account
                                output.get(line[1]).balance += Integer.parseInt(line[2]);
                                output.get(line[1]).listOfTrans
                                        .add(
                                                new Transaction(
                                                        output.get(line[0]),
                                                        output.get(line[1]),
                                                        Integer.parseInt(line[2]),
                                                        TypesOfTransaction.TRANS_TO));
                            }
                        }
                        catch(NumberFormatException e)
                        {
                            myWriter.write("Line " + (i + 1) + ": " + arr[i] + "\n" +
                                    "    Error: Amount expected\n");
                        }
                        break;

                    //deposit/withdrawal
                    case 2:
                        try {
                            if (!output.containsKey(line[0])) {
                                myWriter.write("Line " + (i + 1) + ": " + arr[i] + "\n" +
                                        "    Error : Account doesn't exist\n");
                            } else {
                                //withdrawal
                                if(output.get(line[0]).balance + Integer.parseInt(line[1]) <0)
                                {
                                    myWriter.write("Line " + (i + 1) + ": " + arr[i] + "\n" +
                                            "    Error : Amount of withdrawal exceeds the balance\n");
                                }
                                else if (Integer.parseInt(line[1]) < 0) {
                                    output.get(line[0]).balance += Integer.parseInt(line[1]);
                                    output.get(line[0]).listOfTrans
                                            .add(
                                                    new Transaction(
                                                            output.get(line[0]),
                                                            null,
                                                            Integer.parseInt(line[1]),
                                                            TypesOfTransaction.WITHDRAWAL));
                                }
                                else
                                    {
                                    //deposit
                                    output.get(line[0]).balance += Integer.parseInt(line[1]);
                                    output.get(line[0]).listOfTrans
                                            .add(
                                                    new Transaction(
                                                            null,
                                                            output.get(line[0]),
                                                            Integer.parseInt(line[1]),
                                                            TypesOfTransaction.DEPOSIT));
                                }
                            }
                        }
                        catch(NumberFormatException e)
                        {
                            myWriter.write("Line " + (i + 1) + ": " + arr[i] + "\n" +
                                    "    Error: Amount expected\n");
                        }
                        break;

                    default:
                        if(line.length > 4)
                        {
                            myWriter.write("Line " + (i + 1) + ": " + arr[i] + "\n" +
                                    "    Error: Too many arguments\n");
                        }
                        else if(line.length < 2)
                        {
                            myWriter.write("Line " + (i + 1) + ": " + arr[i] + "\n" +
                                    "    Error: Too few arguments\n");
                        } else{
                            myWriter.write("Line " + (i + 1) + ": " + arr[i] + "\n" +
                                    "    Error: Inappropriate format\n");
                        }
                }
            }
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }
}
