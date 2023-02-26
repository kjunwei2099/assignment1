
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kwan Jun Wei
 */
public class cFileHandling {
    // arrayList in cFileHandling for write file
    ArrayList<String> usersList = new ArrayList<String>();
    
    // return an arrayList from the parameter (filename) 
    public static ArrayList<String>readFile(String filename){
        ArrayList<String> listOfStrings = new ArrayList<String>();
        try
        {
            File f = new File(filename);
            Scanner Sc = new Scanner(f).useDelimiter("\n");
            String str;
            while (Sc.hasNext())
            {
                str = Sc.next();
                if(str != null)
                {
                    listOfStrings.add(str);
                }
            }
            Sc.close();
        }
        catch(Exception e)
        {  
            System.out.println(e);
        }
        return listOfStrings;
    }
    
    // read file and add to arrayList above then add a new string into arrayList
    public void addToList(String filename, String str){
        for(int i=0; i<readFile(filename).size();i++)
        {
            usersList.add(readFile(filename).get(i));
        }
        usersList.add(str);
    }
    
    // add a new string into arrayList
    public void newList(String str){
        usersList.add(str);
    }
    
    // save arrayList above into text file and clear the arrayList above for further uses
    public void saveListToFile(String filename){
        try
        {
            FileWriter writer = new FileWriter(filename);
            for(String user: usersList){
                writer.write(user+"\n");
            }
            writer.close();
            usersList.clear();
        }
        catch(Exception e)
        {
            System.out.println("Error writing file: "+e.getMessage());
        }
    }
}
