
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
    ArrayList<String> usersList = new ArrayList<String>();
    
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
    
    public void addToList(String filename, String str){
        for(int i=0; i<readFile(filename).size();i++)
        {
            usersList.add(readFile(filename).get(i));
        }
        usersList.add(str);
    }
    
    public void newList(String str){
        usersList.add(str);
    }
    
    public void editSpecificList(String filename, String username, String str){
        for(int i=0; i<readFile(filename).size();i++)
        {
            usersList.add(readFile(filename).get(i));
        }
        
        for (int i=0; i<usersList.size(); i++)
        {
            String[]fields = usersList.get(i).split(";");
            if(fields[1].equals(username))
            {
                System.out.println(str);
                usersList.set(i,str);
                break;
            }
        }
    }
    
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
