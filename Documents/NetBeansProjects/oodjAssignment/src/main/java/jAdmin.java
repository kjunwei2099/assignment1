
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Kwan Jun Wei
 * @author calvinlim
 */
public class jAdmin extends javax.swing.JFrame {
    private String role="";
    private String username;
    private String password;
    private String address;
    private String postcode;
    private String city;
    private String state;
    private cAdmin admin = new cAdmin();
    /**
     * Creates new form jDashboard
     */
    
    public jAdmin() {
        initComponents();
        configuration();  
        loadRoles();
    }
    
    public void setRole(String role){
        this.role = role;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    private void loadRoles() {
        String[] roles = admin.getDistinctRoles();
        comboAdminSearchRole.setModel(new javax.swing.DefaultComboBoxModel<>(roles));
        comboAdminSearchRole.insertItemAt("All", 0);
        
        // Clear the table
        DefaultTableModel model = (DefaultTableModel) tableAdminUser1.getModel();
        

        // Get user info from cAdmin
        cAdmin admin = new cAdmin();
        List<String[]> userInfoList = admin.getUserInfoList();
        
        // Add user info to the table based on selected role      
        comboAdminSearchRole.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
               if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedRole = (String) comboAdminSearchRole.getSelectedItem();
                    DefaultTableModel model = (DefaultTableModel) tableAdminUser1.getModel();
                    model.setRowCount(0);

                    // Get user info from cAdmin
                    cAdmin admin = new cAdmin();
                    List<String[]> userInfoList = admin.getUserInfoList();

                    // Add user info to the table based on selected role
                    if (!selectedRole.equals("All")) {
                        for (String[] userInfo : userInfoList) {
                            String role = userInfo[0];
                            String username = userInfo[1];
                            if (selectedRole.equals(role)) {
                                model.addRow(new Object[]{role, username});
                            }
                        }
                    } else {
                        for (String[] userInfo : userInfoList) {
                            String role = userInfo[0];
                            String username = userInfo[1];
                            model.addRow(new Object[]{role, username});
                        }
                    }
                }
            }
        });    
    }
 
    public void configuration(){
        
        if(role.equals("customer"))
        {
            panel.add("Cart",panelCustomer);
            panel.add("Order History",panelHistory); 
            panel.add("Profile",panelCustomerProfile);
            
            ArrayList<String> lines = cFileHandling.readFile("userInfo.txt");
            for (String eachString: lines){
                Scanner sc = new Scanner(eachString).useDelimiter(";");
                String tempRole = sc.next();
                String tempUsername = sc.next();
                String tempPassword = sc.next();
                try
                {
                    String tempAddress = sc.next();
                    String tempPostcode = sc.next();
                    String tempCity = sc.next();
                    String tempState = sc.next();
                    if(tempUsername.equals(username))
                    {
                        this.password=tempPassword;
                        this.address=tempAddress;
                        this.postcode=tempPostcode;
                        this.city=tempCity;
                        this.state=tempState;

                        lblUsername.setText(username);
                        txtAddress.setText(address);
                        txtPostcode.setText(postcode);
                        txtCity.setText(city);
                        txtState.setText(state);
                        break;
                    }
                }
                catch(Exception e){}
            }
        }
        
        btnAdminLoadTable.doClick();
        
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JTabbedPane();
        panelRole = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        comboAdminSearchRole = new javax.swing.JComboBox<>();
        txtAdminSearch = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableAdminUser1 = new javax.swing.JTable();
        btnAdminLoadTable = new javax.swing.JToggleButton();
        txtAdminPassword = new javax.swing.JPasswordField();
        jLabel25 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtAdminPassword2 = new javax.swing.JPasswordField();
        btnAdminSave = new javax.swing.JButton();
        btnAdminClear = new javax.swing.JButton();
        btnAdminDelete = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        comboAdminRole = new javax.swing.JComboBox<>();
        txtAdminUsername = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        panelProduct = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAdminShop = new javax.swing.JTable();
        comboAdminCategory = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtAdminShopSearch = new javax.swing.JTextField();
        btnAdminShopDelete = new javax.swing.JButton();
        lblShopPrice = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnShopLoadTable = new javax.swing.JButton();
        btnAdminShopAdd = new javax.swing.JButton();
        spinnerAdminShopStock = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtAdminAddPrice = new javax.swing.JTextField();
        txtAdminAddProduct1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panelHistory = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablePurchaseHistory = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        btnPurchaseHistoryRefresh = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        comboAdminHistoryOrderID2 = new javax.swing.JComboBox<>();
        comboAdminHistoryDelivery = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        panelCustomer = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCart = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        btnCartPay = new javax.swing.JButton();
        btnCartRemove = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        label123 = new javax.swing.JLabel();
        spinnerCartQuantity = new javax.swing.JSpinner();
        btnCartRefreshTable = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnCartEdit = new javax.swing.JButton();
        lblCartPrice = new javax.swing.JLabel();
        lblCartTotalItem = new javax.swing.JLabel();
        lblCartStatus = new javax.swing.JLabel();
        btnCartGetItem = new javax.swing.JButton();
        lblCartItemName = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtAdminItemName = new javax.swing.JTextField();
        txtAdminItemCatagory = new javax.swing.JTextField();
        panelCustomerProfile = new javax.swing.JPanel();
        btnProfileLogout = new javax.swing.JButton();
        btnProfileEdit = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtNewPassword = new javax.swing.JPasswordField();
        txtNewPassword2 = new javax.swing.JPasswordField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lblProfileStatus = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        txtPostcode = new javax.swing.JTextField();
        txtCity = new javax.swing.JTextField();
        txtState = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel11.setText("Filter By");

        comboAdminSearchRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAdminSearchRoleActionPerformed(evt);
            }
        });

        txtAdminSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAdminSearchKeyPressed(evt);
            }
        });

        tableAdminUser1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Role"
            }
        ));
        jScrollPane6.setViewportView(tableAdminUser1);

        btnAdminLoadTable.setText("Load Table");
        btnAdminLoadTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminLoadTableActionPerformed(evt);
            }
        });

        jLabel25.setText("Password: ");

        jLabel27.setText("Username: ");

        jLabel28.setText("Confirm Password: ");

        btnAdminSave.setText("Save");
        btnAdminSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminSaveActionPerformed(evt);
            }
        });

        btnAdminClear.setText("Clear");
        btnAdminClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminClearActionPerformed(evt);
            }
        });

        btnAdminDelete.setText("Delete");
        btnAdminDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminDeleteActionPerformed(evt);
            }
        });

        jLabel30.setText("Contact Number: ");

        comboAdminRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "delivery", "customer", " " }));
        comboAdminRole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAdminRoleActionPerformed(evt);
            }
        });

        jLabel15.setText("Search:");

        javax.swing.GroupLayout panelRoleLayout = new javax.swing.GroupLayout(panelRole);
        panelRole.setLayout(panelRoleLayout);
        panelRoleLayout.setHorizontalGroup(
            panelRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRoleLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(panelRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel30)
                    .addComponent(jLabel27)
                    .addComponent(jLabel25)
                    .addComponent(jLabel28))
                .addGap(37, 37, 37)
                .addGroup(panelRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelRoleLayout.createSequentialGroup()
                        .addComponent(btnAdminSave, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdminClear, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtAdminPassword)
                    .addComponent(txtAdminPassword2)
                    .addComponent(comboAdminRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAdminUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addGroup(panelRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRoleLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(comboAdminSearchRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRoleLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(txtAdminSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(panelRoleLayout.createSequentialGroup()
                            .addComponent(btnAdminLoadTable)
                            .addGap(90, 90, 90)
                            .addComponent(btnAdminDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(176, 176, 176))
        );
        panelRoleLayout.setVerticalGroup(
            panelRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRoleLayout.createSequentialGroup()
                .addGroup(panelRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRoleLayout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addGroup(panelRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(txtAdminUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(txtAdminPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(txtAdminPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(comboAdminRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(panelRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdminSave)
                            .addComponent(btnAdminClear)))
                    .addGroup(panelRoleLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(panelRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(comboAdminSearchRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtAdminSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelRoleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdminDelete)
                            .addComponent(btnAdminLoadTable))))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        panel.addTab("User Management", panelRole);

        tableAdminShop.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Category Name", "Item Name", "Price", "Stock Left"
            }
        ));
        jScrollPane1.setViewportView(tableAdminShop);
        if (tableAdminShop.getColumnModel().getColumnCount() > 0) {
            tableAdminShop.getColumnModel().getColumn(0).setMaxWidth(400);
            tableAdminShop.getColumnModel().getColumn(3).setMaxWidth(80);
        }

        comboAdminCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboAdminCategoryActionPerformed(evt);
            }
        });

        jLabel2.setText("Category");

        txtAdminShopSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAdminShopSearchKeyPressed(evt);
            }
        });

        btnAdminShopDelete.setText("Delete Item");
        btnAdminShopDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminShopDeleteActionPerformed(evt);
            }
        });

        jLabel8.setText("Stock:");

        btnShopLoadTable.setText("Load Table");
        btnShopLoadTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShopLoadTableActionPerformed(evt);
            }
        });

        btnAdminShopAdd.setText("Add Item");
        btnAdminShopAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminShopAddActionPerformed(evt);
            }
        });

        spinnerAdminShopStock.setModel(new javax.swing.SpinnerNumberModel(1, 1, 9, 1));

        jLabel6.setText("Item Price :");

        jLabel7.setText("Item Name :");

        jLabel3.setText("RM");

        jLabel4.setText("Search:");

        javax.swing.GroupLayout panelProductLayout = new javax.swing.GroupLayout(panelProduct);
        panelProduct.setLayout(panelProductLayout);
        panelProductLayout.setHorizontalGroup(
            panelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblShopPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelProductLayout.createSequentialGroup()
                .addGroup(panelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProductLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(panelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboAdminCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(50, 50, 50)
                        .addGroup(panelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtAdminShopSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelProductLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(75, Short.MAX_VALUE))
            .addGroup(panelProductLayout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addGroup(panelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(28, 28, 28)
                .addGroup(panelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spinnerAdminShopStock, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAdminAddProduct1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelProductLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAdminAddPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(139, 139, 139)
                .addGroup(panelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdminShopDelete)
                    .addComponent(btnAdminShopAdd)
                    .addComponent(btnShopLoadTable, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelProductLayout.setVerticalGroup(
            panelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboAdminCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAdminShopSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProductLayout.createSequentialGroup()
                        .addComponent(btnAdminShopAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdminShopDelete))
                    .addGroup(panelProductLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(panelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelProductLayout.createSequentialGroup()
                                .addComponent(txtAdminAddProduct1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(btnShopLoadTable))
                            .addGroup(panelProductLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addGroup(panelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(jLabel3)
                                        .addComponent(txtAdminAddPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(panelProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spinnerAdminShopStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelProductLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel8)))))))
                .addGap(27, 27, 27)
                .addComponent(lblShopPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );

        panel.addTab("Product", panelProduct);

        tablePurchaseHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Order ID", "Total Price", "Delivery Staff", "Order Status"
            }
        ));
        jScrollPane3.setViewportView(tablePurchaseHistory);

        jLabel14.setText("Purchased History");

        btnPurchaseHistoryRefresh.setText("Refresh");
        btnPurchaseHistoryRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPurchaseHistoryRefreshActionPerformed(evt);
            }
        });

        jLabel1.setText("Assign Order to Delivery:");

        comboAdminHistoryOrderID2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboAdminHistoryDelivery.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setText("Order ID:");

        jLabel13.setText("Delevery ID:");

        javax.swing.GroupLayout panelHistoryLayout = new javax.swing.GroupLayout(panelHistory);
        panelHistory.setLayout(panelHistoryLayout);
        panelHistoryLayout.setHorizontalGroup(
            panelHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHistoryLayout.createSequentialGroup()
                .addGroup(panelHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHistoryLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE))
                    .addGroup(panelHistoryLayout.createSequentialGroup()
                        .addGap(24, 881, Short.MAX_VALUE)
                        .addComponent(btnPurchaseHistoryRefresh))
                    .addGroup(panelHistoryLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel14)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panelHistoryLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addGap(52, 52, 52)
                .addGroup(panelHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboAdminHistoryOrderID2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(39, 39, 39)
                .addGroup(panelHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(comboAdminHistoryDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelHistoryLayout.setVerticalGroup(
            panelHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHistoryLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPurchaseHistoryRefresh)
                .addGap(17, 17, 17)
                .addGroup(panelHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboAdminHistoryOrderID2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboAdminHistoryDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(177, Short.MAX_VALUE))
        );

        panel.addTab("Purchase History", panelHistory);

        tableCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cart ID", "Item Name", "Price", "Quantity", "Total Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableCart);

        jLabel12.setText("Your Cart");

        btnCartPay.setText("Pay");
        btnCartPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCartPayActionPerformed(evt);
            }
        });

        btnCartRemove.setText("Remove From Cart");
        btnCartRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCartRemoveActionPerformed(evt);
            }
        });

        jLabel5.setText("Edit Quantity");

        label123.setText("Item Name : ");

        spinnerCartQuantity.setModel(new javax.swing.SpinnerNumberModel(1, 1, 9, 1));

        btnCartRefreshTable.setText("Refresh");
        btnCartRefreshTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCartRefreshTableActionPerformed(evt);
            }
        });

        btnCartEdit.setText("Edit");
        btnCartEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCartEditActionPerformed(evt);
            }
        });

        lblCartTotalItem.setText("Catagory: ");

        lblCartStatus.setText("Status :");

        btnCartGetItem.setText("Get Item");
        btnCartGetItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCartGetItemActionPerformed(evt);
            }
        });

        jLabel9.setText("Price : RM");

        txtAdminItemName.setText("jTextField1");

        txtAdminItemCatagory.setText("jTextField1");

        javax.swing.GroupLayout panelCustomerLayout = new javax.swing.GroupLayout(panelCustomer);
        panelCustomer.setLayout(panelCustomerLayout);
        panelCustomerLayout.setHorizontalGroup(
            panelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(panelCustomerLayout.createSequentialGroup()
                .addGroup(panelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCustomerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(panelCustomerLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel12)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCustomerLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCartRemove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCartRefreshTable))
                    .addGroup(panelCustomerLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lblCartStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCartPay, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCustomerLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(panelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelCustomerLayout.createSequentialGroup()
                                .addComponent(lblCartTotalItem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtAdminItemCatagory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelCustomerLayout.createSequentialGroup()
                                .addGroup(panelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(label123, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5)
                                    .addComponent(btnCartGetItem, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtAdminItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(1286, 1286, 1286)
                        .addGroup(panelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCartItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelCustomerLayout.createSequentialGroup()
                                .addGroup(panelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spinnerCartQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCartEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(301, 301, 301)
                                .addComponent(jLabel9)
                                .addGap(259, 259, 259)
                                .addComponent(lblCartPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelCustomerLayout.setVerticalGroup(
            panelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCustomerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCartRefreshTable)
                    .addComponent(btnCartRemove))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(panelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(label123)
                        .addComponent(txtAdminItemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblCartItemName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(panelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCartTotalItem)
                    .addComponent(txtAdminItemCatagory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCartPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(spinnerCartQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCartEdit)
                    .addComponent(btnCartGetItem))
                .addGap(38, 38, 38)
                .addGroup(panelCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCustomerLayout.createSequentialGroup()
                        .addComponent(btnCartPay)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCustomerLayout.createSequentialGroup()
                        .addComponent(lblCartStatus)
                        .addGap(34, 34, 34))))
        );

        panel.addTab("Profile", panelCustomer);

        btnProfileLogout.setText("Logout");
        btnProfileLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileLogoutActionPerformed(evt);
            }
        });

        btnProfileEdit.setText("Edit Profile");
        btnProfileEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProfileEditActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Profile");

        jLabel18.setText("Username");

        jLabel19.setText("Password");

        jLabel20.setText("New Password");

        jLabel21.setText("New Password Confirmation");

        jLabel26.setText("Address :");

        jLabel22.setText("Postcode :");

        jLabel23.setText("City :");

        jLabel24.setText("State :");

        lblProfileStatus.setText("Status :");

        javax.swing.GroupLayout panelCustomerProfileLayout = new javax.swing.GroupLayout(panelCustomerProfile);
        panelCustomerProfile.setLayout(panelCustomerProfileLayout);
        panelCustomerProfileLayout.setHorizontalGroup(
            panelCustomerProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCustomerProfileLayout.createSequentialGroup()
                .addGroup(panelCustomerProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCustomerProfileLayout.createSequentialGroup()
                        .addGroup(panelCustomerProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCustomerProfileLayout.createSequentialGroup()
                                .addGap(415, 415, 415)
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelCustomerProfileLayout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addGroup(panelCustomerProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblProfileStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelCustomerProfileLayout.createSequentialGroup()
                                        .addGroup(panelCustomerProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(panelCustomerProfileLayout.createSequentialGroup()
                                                .addGroup(panelCustomerProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel18)
                                                    .addComponent(jLabel19)
                                                    .addComponent(jLabel20))
                                                .addGap(86, 86, 86)
                                                .addGroup(panelCustomerProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(lblUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txtNewPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                                    .addComponent(txtPassword)))
                                            .addGroup(panelCustomerProfileLayout.createSequentialGroup()
                                                .addComponent(jLabel21)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtNewPassword2, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)))
                                        .addGap(64, 64, 64)
                                        .addGroup(panelCustomerProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(panelCustomerProfileLayout.createSequentialGroup()
                                                .addComponent(jLabel26)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE))
                                            .addGroup(panelCustomerProfileLayout.createSequentialGroup()
                                                .addGroup(panelCustomerProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(panelCustomerProfileLayout.createSequentialGroup()
                                                        .addGroup(panelCustomerProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel22)
                                                            .addComponent(jLabel23))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCustomerProfileLayout.createSequentialGroup()
                                                        .addComponent(jLabel24)
                                                        .addGap(35, 35, 35)))
                                                .addGroup(panelCustomerProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtCity)
                                                    .addComponent(txtState, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                                    .addComponent(txtPostcode))))))))
                        .addGap(0, 76, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCustomerProfileLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnProfileEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnProfileLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelCustomerProfileLayout.setVerticalGroup(
            panelCustomerProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCustomerProfileLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelCustomerProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProfileEdit)
                    .addComponent(btnProfileLogout))
                .addContainerGap())
            .addGroup(panelCustomerProfileLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelCustomerProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelCustomerProfileLayout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelCustomerProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18)
                            .addComponent(lblUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelCustomerProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26)
                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panelCustomerProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCustomerProfileLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(panelCustomerProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel22)
                            .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelCustomerProfileLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPostcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelCustomerProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCustomerProfileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtNewPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(lblProfileStatus)
                .addContainerGap(234, Short.MAX_VALUE))
        );

        panel.addTab("Profile", panelCustomerProfile);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 962, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 543, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProfileLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileLogoutActionPerformed
        lblProfileStatus.setText("Logged Out");
        this.role="";
        configuration();
        JOptionPane.showMessageDialog(null,"Logged Out", "Message", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_btnProfileLogoutActionPerformed

    private void btnCartRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCartRemoveActionPerformed
        DefaultTableModel objModel = (DefaultTableModel) tableCart.getModel();
        int row = tableCart.getSelectedRow();
        if (row >=0)
        {
            int response = JOptionPane.showConfirmDialog(this, "Confirm to delete the selected row?", "Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(response==JOptionPane.YES_OPTION)
            {
                ArrayList<String> lines = cFileHandling.readFile("order.txt");
                String orderID = objModel.getValueAt(row, 0).toString();
                for(int i=0; i<lines.size();i++)
                {
                    Scanner sc = new Scanner(lines.get(i)).useDelimiter(";");
                    String tempOrderID = sc.next();
                    if(tempOrderID.equals(orderID))
                    {
                        lines.remove(i);
                    }
                } 
                cFileHandling f = new cFileHandling();
                for(String eachString: lines)
                {
                    System.out.println(eachString);
                    f.newList(eachString);
                }
                f.saveListToFile("order.txt");
                objModel.removeRow(row);
            }
        }
        else
        {
            lblCartStatus.setText("No Row Selected");
        }
    }//GEN-LAST:event_btnCartRemoveActionPerformed

    private void btnProfileEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProfileEditActionPerformed
        boolean found = false;
        if(!txtPassword.getText().equals("")&&lblUsername.getText().equals(username)&&txtPassword.getText().equals(password))
        {
            if(txtNewPassword.getText().equals(txtNewPassword2.getText()))
            {
                if(!txtNewPassword.getText().equals("")&&!txtNewPassword2.getText().equals(""))
                {
                    this.password=txtNewPassword.getText();
                }
                lblProfileStatus.setText("Status: Profile Sucessfully Edited!");
                this.address=txtAddress.getText();
                this.postcode=txtPostcode.getText();
                this.city=txtCity.getText();
                this.state=txtState.getText();
                found = true;
            }
            else
            {
                lblProfileStatus.setText("Status: Make Sure New Password is same as Confirmation");
            }
        }
        else
        {
            lblProfileStatus.setText("Status: Wrong Password!");
        }
        if(found)
        {
            cFileHandling f = new cFileHandling();
            String str = role+";"+username+";"+password+";"+address+";"+postcode+";"+city+";"+state;
            //f.editSpecificList("userInfo.txt",username, str);
            f.saveListToFile("userInfo.txt");
        }
    }//GEN-LAST:event_btnProfileEditActionPerformed

    private void btnCartRefreshTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCartRefreshTableActionPerformed
        DefaultTableModel objModel = (DefaultTableModel) tableCart.getModel();
        objModel.setRowCount(0);
        ArrayList<String> lines = cFileHandling.readFile("order.txt");
        int count=0;
        for (String eachString: lines)
        {
            Scanner sc = new Scanner(eachString).useDelimiter(";");
            String orderID = sc.next();
            String date = sc.next();
            String time = sc.next();
            String tempUsername = sc.next();
            String tempItemName = sc.next();
            String tempItemPrice = sc.next();
            String tempItemQuantity = sc.next();
            String tempTotalPrice = sc.next();
            String isPaid = sc.next();
            if(tempUsername.equals(username)&&isPaid.equals("unpaid"))
            {
                objModel.addRow(new Object[]{orderID,tempItemName,tempItemPrice,tempItemQuantity,tempTotalPrice});
                count++;
            }
        }
        lblCartTotalItem.setText("Total Items: "+count);
    }//GEN-LAST:event_btnCartRefreshTableActionPerformed

    private void btnCartPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCartPayActionPerformed
        ArrayList<String> lines = cFileHandling.readFile("order.txt");
        boolean found = false;
        int response = JOptionPane.showConfirmDialog(this, "Confirm to pay?", "Confirm",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(response==JOptionPane.YES_OPTION)
        {
            for (int i=0;i<lines.size();i++)
            {
                Scanner sc = new Scanner(lines.get(i)).useDelimiter(";");
                String orderID = sc.next();
                sc.next();sc.next(); //date //time
                String tempUsername = sc.next();
                String tempItemName = sc.next();
                String tempItemPrice = sc.next();
                String tempItemQuantity = sc.next();
                String tempTotalPrice = sc.next();
                String isPaid = sc.next();
                
                LocalDateTime myObj = LocalDateTime.now(); // Create a date object
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd;HH:mm:ss");
                String formattedDate = myObj.format(myFormatObj);
                if(tempUsername.equals(username)&&isPaid.equals("unpaid"))
                {
                    String tempString = orderID+";"+formattedDate+";"+tempUsername+";"+tempItemName+";"+tempItemPrice+";"+tempItemQuantity+";"+tempTotalPrice+";paid";
                    lines.set(i, tempString);
                    found = true;
                }
            }
        }
        if(found)
        {
            cFileHandling f = new cFileHandling();
            for(String eachString: lines)
            {
                f.newList(eachString);
            }
            f.saveListToFile("order.txt");
            lblCartStatus.setText("Status : Sucessfully paid");
            found=false;
        }else{
            lblCartStatus.setText("Status : No item to paid");
        }
    }//GEN-LAST:event_btnCartPayActionPerformed

    private void btnPurchaseHistoryRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPurchaseHistoryRefreshActionPerformed
        ArrayList<String> lines = cFileHandling.readFile("order.txt");
        DefaultTableModel objModel = (DefaultTableModel) tablePurchaseHistory.getModel();
        objModel.setRowCount(0);
        for (String eachString: lines)
        {
            Scanner sc = new Scanner(eachString).useDelimiter(";");
            String orderID = sc.next();
            String date = sc.next();
            String time = sc.next();
            String tempUsername = sc.next();
            String tempItemName = sc.next();
            String tempItemPrice = sc.next();
            String tempItemQuantity = sc.next();
            String tempTotalPrice = sc.next();
            String isPaid = sc.next();
            System.out.println(eachString);
            if(tempUsername.equals(username)&&isPaid.equals("paid"))
            {
                System.out.println(eachString);
                objModel.addRow(new Object[]{date+" "+time,orderID,tempItemName,tempItemPrice,tempItemQuantity,tempTotalPrice});
            }
        }
    }//GEN-LAST:event_btnPurchaseHistoryRefreshActionPerformed

    private void btnCartGetItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCartGetItemActionPerformed
        DefaultTableModel objModel = (DefaultTableModel) tableCart.getModel();
        int row = tableCart.getSelectedRow();
        if(row>=0)
        {
            String itemName = objModel.getValueAt(row,1).toString();
            String itemPrice = objModel.getValueAt(row,2).toString();
            String itemQuantity = objModel.getValueAt(row,3).toString();
            lblCartItemName.setText(itemName);
            lblCartPrice.setText(itemPrice);
            spinnerCartQuantity.setValue(Integer.parseInt(itemQuantity));
        }
    }//GEN-LAST:event_btnCartGetItemActionPerformed

    private void btnCartEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCartEditActionPerformed
        DefaultTableModel objModel = (DefaultTableModel) tableCart.getModel();
        int row = tableCart.getSelectedRow();
        boolean canEdit=false;
        int finalQuantity;
        if(row>=0)
        {
            String category;
            String itemName;
            String itemPrice;
            String itemQuantity;
            cFileHandling f = new cFileHandling();
            ArrayList<String> itemList = cFileHandling.readFile("item.txt");
            ArrayList<String> lines = cFileHandling.readFile("order.txt");
            for(int i=0;i<itemList.size();i++)
            {
                Scanner sc = new Scanner(itemList.get(i)).useDelimiter(";");
                category = sc.next();
                itemName=sc.next();
                itemPrice=sc.next();
                itemQuantity=sc.next();
                if(lblCartItemName.getText().equals(itemName)&&!objModel.getValueAt(row,3).toString().equals(spinnerCartQuantity.getValue().toString()))
                { 
                    Integer qOri = Integer.parseInt(itemQuantity.replaceAll("[^0-9.]",""));
                    int q2 = Integer.parseInt(spinnerCartQuantity.getValue().toString());
                    int q3 = Integer.parseInt(objModel.getValueAt(row,3).toString());
                    int check = qOri-q2;
                    if(check>=0)
                    {
                        int q4;
                        canEdit=true;
                        if(q2<Integer.parseInt(objModel.getValueAt(row,3).toString()))
                        {
                            q4 = (Integer.parseInt(objModel.getValueAt(row,3).toString())-q2)+qOri;
                            System.out.println(q3);
                            itemList.set(i, (category+";"+itemName+";"+itemPrice+";"+q4));
                            finalQuantity=q4;
                        }
                        else
                        {
                            q4 = (q3+qOri)-q2;
                            itemList.set(i, (category+";"+itemName+";"+itemPrice+";"+q4));
                            finalQuantity=q4;
                        }                        
                    }
                    else
                    {
                        System.out.println("Cannot add to cart (quantity exceed stock)");
                    }
                }
            }
            if(canEdit)
            {
                System.out.println(canEdit);
                LocalDateTime myObj = LocalDateTime.now(); // Create a date object
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd;HH:mm:ss");
                String formattedDate = myObj.format(myFormatObj);
                
                objModel.setValueAt(spinnerCartQuantity.getValue(), row, 3);
                Float quantity = Float.parseFloat(spinnerCartQuantity.getValue().toString());
                Float price = Float.parseFloat(objModel.getValueAt(row,2).toString());
                String formattedTotal = String.format("%.2f", (price*quantity));
                objModel.setValueAt(formattedTotal,row,4);
                
                for(String eachString: itemList)
                {
                    f.newList(eachString); 
                }
                f.saveListToFile("item.txt");
                
                for(int i=0; i<lines.size();i++)
                {
                    Scanner sc = new Scanner(lines.get(i)).useDelimiter(";");
                    String tempOrderId=sc.next();
                    String tempDate = sc.next();
                    String tempTime = sc.next();
                    String tempUsername = sc.next();
                    String tempCartItemName = sc.next();
                    String tempCartItemPrice = sc.next(); 
                    if(objModel.getValueAt(row,0).toString().equals(tempOrderId))
                    {
                        String tempString=tempOrderId+";"+formattedDate+";"+tempUsername+";"+tempCartItemName+";"+tempCartItemPrice+";"+objModel.getValueAt(row, 3).toString()+";"+formattedTotal+";unpaid";
                        lines.set(i,tempString);
                        System.out.println(lines.get(i));
                    }
                }
                for(String eachString: lines)
                {
                    f.newList(eachString); 
                }
                f.saveListToFile("order.txt");
            }

        }
    }//GEN-LAST:event_btnCartEditActionPerformed

    private void btnAdminSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminSaveActionPerformed
        String Username = txtAdminUsername.getText();
        String Password = txtAdminPassword.getText();
        String ConPassword = txtAdminPassword2.getText();
        String Role = (String)comboAdminRole.getSelectedItem();
        
        cUser admin = new cUser(Username,Password);
        admin.checkLogin("userinfo.txt");
        
        if (!ConPassword.equals(Password)) {
            JOptionPane.showConfirmDialog(null,"Password Incorrect!", 
                    "Please re-enter password", JOptionPane.ERROR_MESSAGE);
            txtAdminPassword.setText("");
            txtAdminPassword2.setText("");
        }
        
        else {
            if ((!Username.equals(""))&&(!Password.equals(""))) {
            if(!admin.getUsernameFound()) {
                String str = Role +";"+Username+";"+Password+";;;;";
                cFileHandling f = new cFileHandling();
                f.addToList("userInfo.txt", str);
                f.saveListToFile("userInfo.txt");
            }
            else {
                JOptionPane.showConfirmDialog(null,"The username have been taken, Please contact Administator for more information",
                        "User Exsisted", JOptionPane.ERROR_MESSAGE);
            }
        }
            else {
            JOptionPane.showConfirmDialog(null,"Kindly fill in all the blank field",
                        "No empty field allowed", JOptionPane.WARNING_MESSAGE);
        }

        }
    }//GEN-LAST:event_btnAdminSaveActionPerformed

    private void btnAdminClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminClearActionPerformed
        txtAdminUsername.setText("");
        txtAdminPassword.setText("");
    }//GEN-LAST:event_btnAdminClearActionPerformed

    private void btnAdminDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminDeleteActionPerformed
        int selectedrow = tableAdminUser1.getSelectedRow();

        if (selectedrow == -1) {
            JOptionPane.showMessageDialog(null, "Please select a user to delete!");
        } else {
            if (JOptionPane.showConfirmDialog(null,"Do you sure want to delete this user profile?", "Delete?", JOptionPane.WARNING_MESSAGE) == 0) {
                DefaultTableModel model = (DefaultTableModel) tableAdminUser1.getModel();
                String role = (String) model.getValueAt(selectedrow, 0);
                String username = (String) model.getValueAt(selectedrow, 1);
                model.removeRow(selectedrow);

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
                    Logger.getLogger(jAdmin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(jAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Delete the original file and rename the temporary file
                if (inputFile.delete()) {
                    tempFile.renameTo(inputFile);
                }
            }
        }
    }//GEN-LAST:event_btnAdminDeleteActionPerformed

    private void comboAdminRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAdminRoleActionPerformed

    }//GEN-LAST:event_comboAdminRoleActionPerformed

    
    private void btnAdminLoadTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminLoadTableActionPerformed
        
    }//GEN-LAST:event_btnAdminLoadTableActionPerformed

    private void txtAdminSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdminSearchKeyPressed
        
        // if txtShopSearch is keyed in with some value, then the table will updated based on the value       
        DefaultTableModel table = (DefaultTableModel) tableAdminUser1.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        
        // show the filtered data in table 
        tableAdminUser1.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(txtAdminSearch.getText().trim()));
    }//GEN-LAST:event_txtAdminSearchKeyPressed

    private void comboAdminSearchRoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAdminSearchRoleActionPerformed

    }//GEN-LAST:event_comboAdminSearchRoleActionPerformed

    private void btnAdminShopAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminShopAddActionPerformed

    }//GEN-LAST:event_btnAdminShopAddActionPerformed

    private void btnShopLoadTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShopLoadTableActionPerformed
        File item = new File("item.txt");
        DefaultTableModel objModel = (DefaultTableModel) tableAdminShop.getModel();
        objModel.setRowCount(0);
        try {
            FileReader fr = new FileReader(item);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();

            while (line != null) {
                String[] dataRow = line.split(";");
                objModel.addRow(dataRow);
                line = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Add an "All" option to show all categories
        comboAdminCategory.addItem("All");

        // Get unique category values from item.txt
        Set<String> categories = new HashSet<>();

        //get category value from item.txt
        try {
            BufferedReader br = new BufferedReader(new FileReader("item.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                String category = data[0];
                categories.add(category);
            }
            br.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        comboAdminCategory.addActionListener(e -> {
            String selectedCategory = comboAdminCategory.getSelectedItem().toString();
            if (selectedCategory.equals("All")) {
                // Show all rows in table
                tableAdminShop.setRowSorter(null);
            } else {
                // Show only rows with selected category
                TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(objModel);
                sorter.setRowFilter(RowFilter.regexFilter(selectedCategory, 0));
                tableAdminShop.setRowSorter(sorter);
            }
        });

        for (String category : categories) {
            comboAdminCategory.addItem(category);
        }
    }//GEN-LAST:event_btnShopLoadTableActionPerformed

    private void btnAdminShopDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminShopDeleteActionPerformed

    }//GEN-LAST:event_btnAdminShopDeleteActionPerformed

    private void txtAdminShopSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdminShopSearchKeyPressed
        DefaultTableModel table = (DefaultTableModel) tableAdminShop.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        tableAdminShop.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(txtAdminShopSearch.getText().trim()));
    }//GEN-LAST:event_txtAdminShopSearchKeyPressed

    private void comboAdminCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboAdminCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboAdminCategoryActionPerformed
  
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jDashboard().setVisible(true);
            }
        }); 

        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdminClear;
    private javax.swing.JButton btnAdminDelete;
    private javax.swing.JToggleButton btnAdminLoadTable;
    private javax.swing.JButton btnAdminSave;
    private javax.swing.JButton btnAdminShopAdd;
    private javax.swing.JButton btnAdminShopDelete;
    private javax.swing.JButton btnCartEdit;
    private javax.swing.JButton btnCartGetItem;
    private javax.swing.JButton btnCartPay;
    private javax.swing.JButton btnCartRefreshTable;
    private javax.swing.JButton btnCartRemove;
    private javax.swing.JButton btnProfileEdit;
    private javax.swing.JButton btnProfileLogout;
    private javax.swing.JButton btnPurchaseHistoryRefresh;
    private javax.swing.JButton btnShopLoadTable;
    private javax.swing.JComboBox<String> comboAdminCategory;
    private javax.swing.JComboBox<String> comboAdminHistoryDelivery;
    private javax.swing.JComboBox<String> comboAdminHistoryOrderID2;
    private javax.swing.JComboBox<String> comboAdminRole;
    private javax.swing.JComboBox<String> comboAdminSearchRole;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel label123;
    private javax.swing.JLabel lblCartItemName;
    private javax.swing.JLabel lblCartPrice;
    private javax.swing.JLabel lblCartStatus;
    private javax.swing.JLabel lblCartTotalItem;
    private javax.swing.JLabel lblProfileStatus;
    private javax.swing.JLabel lblShopPrice;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTabbedPane panel;
    private javax.swing.JPanel panelCustomer;
    private javax.swing.JPanel panelCustomerProfile;
    private javax.swing.JPanel panelHistory;
    private javax.swing.JPanel panelProduct;
    private javax.swing.JPanel panelRole;
    private javax.swing.JSpinner spinnerAdminShopStock;
    private javax.swing.JSpinner spinnerCartQuantity;
    private javax.swing.JTable tableAdminShop;
    private javax.swing.JTable tableAdminUser1;
    private javax.swing.JTable tableCart;
    private javax.swing.JTable tablePurchaseHistory;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAdminAddPrice;
    private javax.swing.JTextField txtAdminAddProduct1;
    private javax.swing.JTextField txtAdminItemCatagory;
    private javax.swing.JTextField txtAdminItemName;
    private javax.swing.JPasswordField txtAdminPassword;
    private javax.swing.JPasswordField txtAdminPassword2;
    private javax.swing.JTextField txtAdminSearch;
    private javax.swing.JTextField txtAdminShopSearch;
    private javax.swing.JTextField txtAdminUsername;
    private javax.swing.JTextField txtCity;
    private javax.swing.JPasswordField txtNewPassword;
    private javax.swing.JPasswordField txtNewPassword2;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPostcode;
    private javax.swing.JTextField txtState;
    // End of variables declaration//GEN-END:variables
}
