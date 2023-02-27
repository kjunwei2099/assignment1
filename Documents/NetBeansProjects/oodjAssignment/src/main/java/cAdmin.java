/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 *
 * @author calvinlim
 */


public class cAdmin {
    private List<String[]> userInfoList;

    public cAdmin() {
        // Initialize userInfoList with data from userinfo.txt
        userInfoList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("userinfo.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userInfo = line.split(";");
                userInfoList.add(userInfo);
            }
        } catch (IOException ex) {
            System.out.println("Error loading user info from file: " + ex.getMessage());
        }
    }

    public List<String[]> getUserInfoList() {
        return userInfoList;
    }
    
        public String[] getDistinctRoles() {
        Set<String> roles = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader("userinfo.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userInfo = line.split(";");
                roles.add(userInfo[0]);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return roles.toArray(new String[0]);
    }
}

