/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author calvinlim
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class cItem {
    private static final String FILENAME = "item.txt";
    private List<String[]> itemList;

    public cItem() {
        itemList = new ArrayList<>();
        loadItemList();
    }

    public List<String[]> getItemList() {
        return itemList;
    }

    private void loadItemList() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] itemInfo = line.split(";");
                itemList.add(itemInfo);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}



















