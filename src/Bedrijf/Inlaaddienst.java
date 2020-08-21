package Bedrijf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Inlaaddienst extends Bestelling implements Comparable<Bestelling> {

    public Inlaaddienst(Bestelling ...bestelling){
        super(0,0,false,null);
        ArrayList<Bestelling> lijst1 = new ArrayList<>();
        for(Bestelling b : bestelling){
            lijst1.add(b);
        }
       Collections.sort(lijst1);
        System.out.println(lijst1);
    }

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












