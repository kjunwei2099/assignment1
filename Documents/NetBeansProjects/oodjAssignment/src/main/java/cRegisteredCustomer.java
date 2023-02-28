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
    private ArrayList<String> categoryList;
    private boolean isPaid = false;
    
    public cRegisteredCustomer(){}
    
    public cRegisteredCustomer(String username, String password){
        super(username, password);
        ArrayList<String> userList = cFileHandling.readFile("userInfo.txt");
        for (String eachString : userList) {
            String[]fields = eachString.split(";");
            String tempUsername = fields[1];
            if(tempUsername.equals(super.getUsername()))
            {
                this.address = fields[3];
                this.postcode = fields[4];
                this.city = fields[5];
                this.state = fields[6];
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
    
    public void loadOrderList(){
        this.orderList = cFileHandling.readFile("order.txt");
    }
    
    public ArrayList<String> getOrderList(){
        return orderList;
    }
    
    public void loadItemList(){
        this.itemList = cFileHandling.readFile("item.txt");
    }
    
    public ArrayList<String> getItemList(){
        return itemList;
    }
    
    public void loadCategoryList(){
        this.categoryList = cFileHandling.readFile("category.txt");
    }

    public ArrayList<String> getCategoryList(){
         return categoryList;
    }
    
    public void addCart(String item){
        orderList.add(item);
        cFileHandling f = new cFileHandling();
        for(String eachString: orderList){
            f.newList(eachString);
        }
        f.saveListToFile("order.txt");
    }
    
    public void editOrderQuantity(int i, String quantity, String total, String date){
        cFileHandling f = new cFileHandling();;
        String[]order = orderList.get(i).split(";");
        orderList.set(i,order[0]+";"+date+";"+super.getUsername()+";"+order[4]+";"+order[5]+";"+quantity+";"+total+";"
        +order[8]+";"+order[9]+";"+order[10]+";"+order[11]+";"+order[12]);
        for(String eachString: orderList){
            f.newList(eachString);
        }
        f.saveListToFile("order.txt");
    }
    
    public void editItemQuantity(String categoryID, String itemName, int quantity){
        cFileHandling f = new cFileHandling();
        for(int i=0;i<itemList.size();i++){
            String[]fields = itemList.get(i).split(";");
            if(fields[0].equals(categoryID)&&fields[1].equals(itemName))
            {
                itemList.set(i, fields[0]+";"+fields[1]+";"+fields[2]+";"+quantity);
            }
        }
        for(String eachString: itemList){
            f.newList(eachString);
        }
        f.saveListToFile("item.txt");
    }
    
    public void removeCart(int orderListIndex){
        orderList.remove(orderListIndex);
        cFileHandling f = new cFileHandling();
        for(String eachString: orderList){
            f.newList(eachString);
        }
        f.saveListToFile("order.txt");
    }
    
    public void pay(){
        cFileHandling f = new cFileHandling();
        cDate d = new cDate();
        int tempID = 0;
        for (int i=0; i<orderList.size();i++){
            String[]order = orderList.get(i).split(";");
            try 
            {
                tempID = Integer.parseInt(order[0]);
            } 
            catch (Exception e) 
            {}
            if(order[3].equals(super.getUsername())&&order[0].equals("null")&&order[8].equals("unpaid"))
            {
                int finalID = tempID + 1;
                orderList.set(i,finalID+";"+d.getDate()+";"+super.getUsername()+";"+order[4]+";"+order[5]+";"+order[6]+";"
                +order[7]+";paid;null;Packing Item;no;null");
                this.isPaid = true;
            }
        }
        for(String eachString: orderList){
            f.newList(eachString);
        }
        f.saveListToFile("order.txt");
    }
    
    public boolean getIsPaid(){
        return isPaid;
    }
    
    public void setIsPaid(boolean isPaid){
        this.isPaid = isPaid;
    }
    
    public void addFeedback(String orderID, String feedback){
        cFileHandling f = new cFileHandling();
        for(int i=0; i<orderList.size(); i++){
            String[]fields = orderList.get(i).split(";");
            if(fields[0].equals(orderID))
            {
                orderList.set(i, fields[0]+";"+fields[1]+";"+fields[2]+";"+fields[3]+";"+fields[4]+";"+fields[5]+";"
                +fields[6]+";"+fields[7]+";"+fields[8]+";"+fields[9]+";"+fields[10]+";yes;"+feedback); 
            }
        }
        for(String eachString: orderList){
            f.newList(eachString);
        }
        f.saveListToFile("order.txt");
    }
}
