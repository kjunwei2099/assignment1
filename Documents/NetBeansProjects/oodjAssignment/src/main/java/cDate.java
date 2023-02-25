
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Kwan Jun Wei
 */
public class cDate {
    private String total;
    public String getDate(){
        LocalDateTime myObj = LocalDateTime.now(); // Create a date object
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd;HH:mm:ss");
        String formattedDate = myObj.format(myFormatObj);
        return formattedDate;
    }
    
    public void calTotalPrice(String price, String quantity){
        Float Price = Float.parseFloat(price);
        Float Quantity = Float.parseFloat(quantity);
        this.total = String.format("%.2f", (Price*Quantity));
    }
    
    public String getTotal(){
        return total;
    }
}
