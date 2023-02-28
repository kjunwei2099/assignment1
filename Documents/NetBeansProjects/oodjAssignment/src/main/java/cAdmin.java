
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
    // Reading the userinfo.txt file and storing the data in the userInfoList.
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

    /**
     * Read the file line by line, split each line into an array of strings, and add
     * the first element
     * of each array to a set
     * 
     * @return An array of strings.
     */
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

    public boolean saveUserInfo(String role, String username, String password) {
        // Check if the username already exists in the file
        for (String[] userInfo : userInfoList) {
            if (userInfo[1].equals(username)) {
                // Username already exists, return false to indicate failure to save
                return false;
            }
        }

        // Open the userinfo.txt file for writing
        try (FileWriter writer = new FileWriter("userinfo.txt", true)) {
            // Write the user information to the file
            writer.write(role + ";" + username + ";" + password + "\n");
            // Add the new user info to userInfoList
            userInfoList.add(new String[] { role, username, password });
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
        public boolean deleteUserInfo(String role, String username) {
        File inputFile = new File("userinfo.txt");
        File tempFile = new File("userinfo_temp.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] info = line.split(";");
                String dltRole = info[0].trim();
                String dltUsername = info[1].trim();

                if (!(dltUsername.equals(username) && dltRole.equals(role))) {
                    writer.write(line + System.getProperty("line.separator"));
                }
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return false;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }

        // Delete the original file and rename the temporary file
        if (inputFile.delete()) {
            tempFile.renameTo(inputFile);
            return true;
        } else {
            return false;
        }
    }

}
