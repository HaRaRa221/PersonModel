import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonReader {

    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        String str = "";
        ArrayList<String> crowd = new ArrayList<>();

        final int FIELD_LENGTH = 5;

        String id, f, l, t;
        int YoB = 0;


        try {

            System.out.printf(String.format("%-10s %-15s %-15s %-9s %5s", "ID#", "(f)irstName", "(l)astName", "(t)itle", "(y)OB"));
            System.out.print("\n=========================================================================");
            String[] bounds;
            for (String person : crowd)
            {
                bounds = person.split(",");
                if(bounds.length == FIELD_LENGTH) {

                    id = bounds[0].trim();
                    f = bounds[1].trim();
                    l = bounds[2].trim();
                    t = bounds[3].trim();
                    YoB = Integer.parseInt(bounds[4].trim());
                    String.format("%-10s %-15s %-15s %-9s %5d", id, f, l, t, YoB );

                }
                else
                {
                    System.out.println("Corrupt file straight ahead: ");
                    System.out.println();
                }
            }
            System.out.println();

            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));

                int line = 0;
                while (reader.ready()) {
                    rec = reader.readLine();
                    line++;
                    System.out.println(rec);
                }
                reader.close();
                System.out.println(rec);

            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found!!!");
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }

}
