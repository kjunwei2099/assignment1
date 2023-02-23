/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kwan Jun Wei
 */
public class cRegisteredCustomer extends cUser{
    private String name;
    private String address;

    public cRegisteredCustomer(String username, String password, String address) {
        super(username, password);
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
     // Method to view all items in a category
    public void viewItemsByCategory(cCategory category){
        
    }

    // Method to modify the customer's own profile
    public void modifyProfile(){
        
    }

    // Method to view purchase history
    public void viewPurchaseHistory(){
        
    }

    // Method to search for items and place an order
    public void placeOrder(){
        
    }

    // Method to make a payment
    public void makePayment(){
        
    }
}
