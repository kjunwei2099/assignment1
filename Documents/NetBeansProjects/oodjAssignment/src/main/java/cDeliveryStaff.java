
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kwan Jun Wei
 */
public class cDeliveryStaff extends cUser{
    private ArrayList<String> orderList;
    private ArrayList<String> userList;
    
    public cDeliveryStaff(String username, String password){
        super(username,password);
    }
    
    public void updateDeliveryStatus(String orderID, String status){
        cFileHandling f = new cFileHandling();
        for(int i=0;i<orderList.size();i++){
            String[]order = orderList.get(i).split(";");
            if(order[0].equals(orderID))
            {
                orderList.set(i, order[0]+";"+order[1]+";"+order[2]+";"+order[3]+";"+order[4]+";"+order[5]+";"+order[6]
                +";"+order[7]+";"+order[8]+";"+order[9]+";"+status+";"+order[11]+";"+order[12]);
            }
        }
        for(String eachString: orderList){
            f.newList(eachString);
        }
        f.saveListToFile("order.txt");
    }
    
    public void loadOrderList(){
        this.orderList = cFileHandling.readFile("order.txt");
    }
    
    public ArrayList<String> getOrderList(){
        return orderList;
    }
    
    public void loadUserList(){
        this.userList = cFileHandling.readFile("userInfo.txt");
    }
    
    public ArrayList<String> getUserList(){
        return userList;
    }
    
}
