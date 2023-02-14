/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Kwan Jun Wei
 */
import java.io.*;
import java.util.*;
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> listOfStrings = new ArrayList<String>();
        try
        {
            File f = new File("userInfo.txt");
            Scanner Sc = new Scanner(f);
            String str;
            while (Sc.hasNext())
            {
                str = Sc.next();
                listOfStrings.add(str);
            }
            String[] array = listOfStrings.toArray(new String[0]);
            for (String eachString : array){
                System.out.println(eachString);
            }
        }
        catch(Exception e)
        {  
            System.out.println(e);
        }
    }
}
