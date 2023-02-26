
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
public class cUser {
    private String role;
    private String username;
    private String password;
    private boolean found = false;
    private boolean usernameFound = false;
    
    public cUser(){}
    
    //contructor
    public cUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    //creation of class obj method
    public void checkLogin(String filename){
        cFileHandling f = new cFileHandling();
        ArrayList<String> lines = cFileHandling.readFile(filename);
        for (String eachString: lines){
            Scanner sc = new Scanner(eachString).useDelimiter(";");
            String tempRole = sc.next();
            String tempUsername = sc.next();
            String tempPassword = sc.next();
            if(tempUsername.equals(username))
            {
                usernameFound=true;
                if(tempUsername.equals(username)&&tempPassword.equals(password))
                {
                    this.setRole(tempRole);
                    found = true;
                    break;
                }
            }
        }
    }
    
    //encapsulation
    //getter
    public boolean getFound(){
        return found;
    }
    //setter
    public void setFoundFalse(){
        this.found = false;
    }
        
    public boolean getUsernameFound(){
        return usernameFound;
    }
    
    public void setUsernameFound(){
        this.usernameFound = false;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setRole(String role){
        this.role = role;
    }
    
    public String getRole(){
        return role;
    }
}
