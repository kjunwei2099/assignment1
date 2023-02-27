import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kwan Jun Wei
 */
public class cRegisteredCustomer extends cUser{
    private String address;
    private String postcode;
    private String city;
    private String state;
    
    private ArrayList<String> orderList;
    private ArrayList<String> itemList;
    
    public cRegisteredCustomer(){
        orderList = cFileHandling.readFile("order.txt");
        itemList = cFileHandling.readFile("item.txt");
    }
    
    public cRegisteredCustomer(String username, String password){
        super(username, password);
        ArrayList<String> userList = cFileHandling.readFile("userInfo.txt");
        for (String eachString : userList) {
            Scanner sc = new Scanner(eachString).useDelimiter(";");
            String tempRole = sc.next();
            String tempUsername = sc.next();
            String tempPassword = sc.next();
            if(tempUsername.equals(super.getUsername()))
            {
                this.address = sc.next();
                this.postcode = sc.next();
                this.city = sc.next();
                this.state = sc.next();
            }
        }
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    // Method to modify the customer's own profile
    public void modifyProfile(String role, String username, String password, String address, String postcode, String city, String state){
        this.setAddress(address);
        this.setPostcode(postcode);
        this.setCity(city);
        this.setState(state);
        
        String userInfo = role+";"+username+";"+password+";"+this.getAddress()+";"+ this.getPostcode()+";"+this.getCity()+";"+this.getState();
        
        cFileHandling f = new cFileHandling();
        ArrayList<String> userList = cFileHandling.readFile("userInfo.txt");
        for (int i=0; i<userList.size(); i++)
        {
            String[]fields = userList.get(i).split(";");
            if(fields[1].equals(username))
            {
                userList.set(i,userInfo);
                break;
            }
        }
        
        for(String eachString: userList){
            f.newList(eachString);
        }
        f.saveListToFile("userInfo.txt");
    }
    
    public ArrayList<String> getOrderList(){
        return orderList;
    }
    
    public ArrayList<String> getItemList(){
        return itemList;
    }
//    
//    public static ArrayList<String>loadShop(){
//        ArrayList<String> itemList = cFileHandling.readFile("item.txt");
//        return itemList;
//    }
//    
//    public void ArrayList<String>loadCart(){
//        ArrayList<String> orderList = cFileHandling.readFile("order.txt");
//        for(String eachString: orderList){
//            
//        }
//        return orderList;
//    }
//    
//    public static ArrayList<String>loadHistory(){
//        ArrayList<String> orderHistory = cFileHandling.readFile("order.txt");
//        return orderHistory;
//    }
}
