/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kwan Jun Wei
 */
import java.util.*;
import java.io.*;
public class openFile {
    List<String> listOfStrings = new ArrayList<String>();
    
    public void openReadFile(String filename){
        try
        {
            File f = new File(filename);
            Scanner Sc = new Scanner(f);
            String str;
            
            while (Sc.hasNext())
            {
                str = Sc.next();
                listOfStrings.add(str);
            }
            String[] array = listOfStrings.toArray(new String[0]);
            /*
            for (String eachString : array){
                System.out.println(eachString);
            }
            */
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void writeToFile(String filename){
        
    }
}
