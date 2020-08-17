package Bedrijf;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class chauffeur{

        public static void main(String args[])
        {
            try
            {
                File file=new File("./file.txt");
    FileReader fr=new FileReader(file);
    BufferedReader br=new BufferedReader(fr);
    StringBuffer sb=new StringBuffer();
    String line;
while((line=br.readLine())!=null)
    {
        sb.append(line);
        sb.append("\n");
    }
fr.close();
System.out.println("Contents of File: ");
System.out.println(sb.toString());
}
catch(IOException e)
        {
        e.printStackTrace();
        }
        }
        }



