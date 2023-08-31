import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.util.Arraylist;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator {
    public static void main(String[] args)
    {
        ArrayList<String> Dpeople = new ArrayList<>();
        String ID = "";
        String fName = "";
        String lName = "";
        String DPeopleData = "";
        String title = "";
        int YOB = 0;

        Scanner in = new Scanner (System.in);

        ArrayList<String> Dpeople = new ArrayList<>();

        boolean done = false;
        do {
            ID = SafeInput.getNonZeroLenString(in, "Enter the 6 digit ID: ");
            fName = SafeInput.getNonZeroLenString(in, "What is the first name of person");
            lName = SafeInput.getNonZeroLenString(in, "What is the last name of person");
            title = SafeInput.getNonZeroLenString(in, "What title does the person go by (Mr., Mrs., Ms., Dr., etc.");
            YOB = SafeInput.getRangedInt(in, "Enter your birth year in 4 digits", 1000, 9999);

            DpeopleData = ID + ", " + fName + ", " + lName + ", " + title + ", " + YOB;
            DPeople.add(DPeopleData);

            done = SafeInput.getYNConfirm(in, "Are you finished with the people data?")

        } while (!done);

        for (String d: DPeopleData) {
            System.out.println(d);
        }

        try
        {

            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));


            for(String Dp : DPeopleData)
            {
                writer.write(rec, 0, rec.length());
                writer.newLine();

            }
            writer.close();
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

}
