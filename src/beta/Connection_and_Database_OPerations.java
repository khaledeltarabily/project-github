/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beta;

import java.awt.Cursor;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ALDAWLY
 */
public class Connection_and_Database_OPerations {
    Connection con;
    Connection connect(){
        try{
           
            Class.forName("org.sqlite.JDBC");
            con =DriverManager.getConnection("jdbc:sqlite:C:\\Users\\ALDAWLY\\Downloads\\adwat.db"); 
            JOptionPane.showMessageDialog(null,"connected");
            return con;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }  
    }
    ResultSet select_table(String table_name){
        Connection conn = null;
        ResultSet rs = null;
        try{
             conn=connect();
             Statement st=conn.createStatement();
             rs=st.executeQuery("SELECT * FROM "+table_name+"");
             JOptionPane.showMessageDialog(null,"success");
             return rs;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }finally{
             try {
                 conn.close();
                 rs.close();
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
        }
       
    }
    


//ادخال بيانات مورد1
    void insert_suppliers(String name,long tele,String address,String category){
         Connection conn = null;
        try{ 
            String sql = "INSERT INTO suppliers( sup_name , sup_tele , sup_address , sup_category ) " +
        "VALUES (?, ?, ?,?)";
         conn=connect();
         PreparedStatement preparedStatement = conn.prepareStatement(sql);
         preparedStatement.setString(1, name);
         preparedStatement.setLong(2, tele);
         preparedStatement.setString(3, address);
         preparedStatement.setString(4, category);
         preparedStatement.executeUpdate(); 
         preparedStatement.close();
         
         JOptionPane.showMessageDialog(null,"success");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
             try {
                 conn.close();
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
        }
    }
    //******************


//ادخال فاتوره بيع2
    void insert_bells(String date,double total,String reciver_name, int emp_id,String notes){
         Connection conn = null;
        try{ 
            String sql = "INSERT INTO bells( bell_date , bell_total , bell_reciver , emp_id , notes ) " +
        "VALUES (?, ?, ?)";
         conn=connect();
         PreparedStatement preparedStatement = conn.prepareStatement(sql);
         preparedStatement.setString(1,date);
         preparedStatement.setDouble(2, total);
         preparedStatement.setString(3, reciver_name);
         preparedStatement.setInt(4, emp_id);
         preparedStatement.setString(5, notes);
         preparedStatement.executeUpdate(); 
         preparedStatement.close();
         
         JOptionPane.showMessageDialog(null,"success");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
             try {
                 conn.close();
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
        }
    }
    //*******************

    
    
    
//ادخال فواتير الشراء 3
    void insert_buyies(String date,double total,int sup_id, int admin_id,int item_quantity,double item_price,String item_name
    ,int warehouse_id, String notes){
         Connection conn = null;
        try{ 
            String sql = "INSERT INTO buyies( date , total , sup_id , admin_id , item_quantity , item_price , item_name , warehouse_id , notes) " +
        "VALUES (?, ?, ? ,? , ? , ? , ? , ? , ?)";
         conn=connect();
         PreparedStatement preparedStatement = conn.prepareStatement(sql);
         preparedStatement.setString(1,date);
         preparedStatement.setDouble(2, total);
         preparedStatement.setInt(3, sup_id);
         preparedStatement.setInt(4, admin_id);
         preparedStatement.setInt(5, item_quantity);
         preparedStatement.setInt(6, item_quantity);
         preparedStatement.setDouble(7, item_price);
         preparedStatement.setInt(8, warehouse_id);
         preparedStatement.setString(9, notes);
         preparedStatement.executeUpdate(); 
         preparedStatement.close();
         JOptionPane.showMessageDialog(null,"success");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
             try {
                 conn.close();
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
        }
    }
    //************
    
    
    
    //ادخال حسابات مورد4
    void insert_supp_reckoning(int sup_id,String date, String notes){
         Connection conn = null;
        try{ 
            String sql = "INSERT INTO supp_reckoning( sup_id , da2n , madyon , last_date , notes ) " +
        "VALUES (?, ?, ? , ? , ? )";
         conn=connect();
         PreparedStatement preparedStatement = conn.prepareStatement(sql);
         preparedStatement.setString(1,date);
         preparedStatement.setDouble(2, 0);
         preparedStatement.setDouble(3, 0);
         preparedStatement.setString(4, date);
         preparedStatement.setString(5, notes);
         preparedStatement.executeUpdate(); 
         preparedStatement.close();
         
         JOptionPane.showMessageDialog(null,"success");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
             try {
                 conn.close();
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
        }
    }
    //********************
   
    
    
//ادخال في  مخزن جديد5
void insert_in_warehouse(String warehouse_name){
        Connection conn = null;
        try{ 
            String sql = "INSERT INTO warehouses( warehouse_name ) " +
        "VALUES (?)";
         conn=connect();
         PreparedStatement preparedStatement = conn.prepareStatement(sql);
         preparedStatement.setString(1,warehouse_name);
         preparedStatement.executeUpdate(); 
         preparedStatement.close();
         
         JOptionPane.showMessageDialog(null,"success");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
             try {
                 conn.close();
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
        }
    }
//************
    
   
    
//ادخال عملاء6
void insert_clients(String name,String adress, long tele){
         Connection conn = null;
        try{ 
            String sql = "INSERT INTO clients( client_name , client_tele , client_adress) " +
        "VALUES (?, ?, ?)";
         conn=connect();
         PreparedStatement preparedStatement = conn.prepareStatement(sql);
         preparedStatement.setString(1,name);
         preparedStatement.setLong(2, tele);
         preparedStatement.setString(3, adress);
         preparedStatement.executeUpdate(); 
         preparedStatement.close();
         //ادخال حسابات العميل
         //insert_client_reckoning();
         JOptionPane.showMessageDialog(null,"success");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
             try {
                 conn.close();
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
        }
    }
//*********
    

//ادخال مديرين7

void insert_admins(String name,String password){
         Connection conn = null;
        try{ 
            String sql = "INSERT INTO admins( admin_username , admin_password) " +
        "VALUES (?, ?)";
         conn=connect();
         PreparedStatement preparedStatement = conn.prepareStatement(sql);
         preparedStatement.setString(1,name);
         preparedStatement.setString(2, password);
         preparedStatement.executeUpdate(); 
         preparedStatement.close();
         //ادخال حسابات مديرين
         //insert_supp_reckoning();
         JOptionPane.showMessageDialog(null,"success");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
             try {
                 conn.close();
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
        }
    }
//********************



//ادخال موظفين8
void insert_employees(String emp_name,String emp_password,String emp_adress,String emp_shift,double emp_salary,String notes){
         Connection conn = null;
        try{ 
            String sql = "INSERT INTO employees( emp_name , emp_password , adress , emp_shift , emp_salary , notes) " +
        "VALUES (?, ? ,? , ? , ? , ?)";
         conn=connect();
         PreparedStatement preparedStatement = conn.prepareStatement(sql);
         preparedStatement.setString(1,emp_name);
         preparedStatement.setString(2, emp_password);
         preparedStatement.setString(3, emp_adress);
         preparedStatement.setString(4, emp_shift);
         preparedStatement.setDouble(5, emp_salary);
         preparedStatement.setString(6, notes);
         preparedStatement.executeUpdate(); 
         preparedStatement.close();
         JOptionPane.showMessageDialog(null,"success");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
             try {
                 conn.close();
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
        }
    }
//********************
 

//ادخال اصناف9
void insert_items(String item_name,double item_price,int warehouse_id,double item_real_price ,String notes,int sup_id){
         Connection conn = null;
        try{ 
            String sql = "INSERT INTO employees( item_name , item_price , warehouse_id , item_real_price , notes , sup_id) " +
        "VALUES (?, ? ,? , ? , ? , ?)";
         conn=connect();
         PreparedStatement preparedStatement = conn.prepareStatement(sql);
         preparedStatement.setString(1,item_name);
         preparedStatement.setDouble(2, item_price);
         preparedStatement.setInt(3, warehouse_id);
         preparedStatement.setDouble(4, item_real_price);
         preparedStatement.setString(5, notes);
         preparedStatement.setInt(6, sup_id);
         preparedStatement.executeUpdate(); 
         preparedStatement.close();
         JOptionPane.showMessageDialog(null,"success");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
             try {
                 conn.close();
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
        }
    }
//****************



//ادخال مبيعات10
void insert_sales(int bell_id,int item_id,int quantity,double item_price ){
         Connection conn = null;
        try{ 
            String sql = "INSERT INTO sales( bell_id , item_id , quantity , item_price) " +
        "VALUES (?, ? ,? , ? , ? , ?)";
         conn=connect();
         PreparedStatement preparedStatement = conn.prepareStatement(sql);
         preparedStatement.setInt(1,bell_id);
         preparedStatement.setDouble(2, item_id);
         preparedStatement.setInt(3, quantity);
         preparedStatement.setDouble(4, item_price);
         preparedStatement.executeUpdate(); 
         preparedStatement.close();
         JOptionPane.showMessageDialog(null,"success");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
             try {
                 conn.close();
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
        }
    }
//****************


//ادخال مصروفات11
void insert_expenses(String notes,String emp_name,String expenses_date,double cost ){
         Connection conn = null;
        try{ 
            String sql = "INSERT INTO expenses( notes , emp_name , expenses_date , cost) " +
        "VALUES (?, ? ,? , ?)";
         conn=connect();
         PreparedStatement preparedStatement = conn.prepareStatement(sql);
         preparedStatement.setString(1,notes);
         preparedStatement.setString(2, emp_name);
         preparedStatement.setString(3, expenses_date);
         preparedStatement.setDouble(4, cost);
         preparedStatement.executeUpdate(); 
         preparedStatement.close();
         JOptionPane.showMessageDialog(null,"success");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
             try {
                 conn.close();
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
        }
    }
//****************

    
//ادخال مسترجعات12
void insert_retrived(int item_id,int bell_id,String retrive_date,double cost,int emp_id ){
         Connection conn = null;
        try{ 
            String sql = "INSERT INTO Retrieved( item_id , bell_id , retrive_date , cost , emp_id) " +
        "VALUES (?, ? , ?, ?, ?)";
         conn=connect();
         PreparedStatement preparedStatement = conn.prepareStatement(sql);
         preparedStatement.setInt(1,item_id);
         preparedStatement.setInt(2, bell_id);
         preparedStatement.setString(3, retrive_date);
         preparedStatement.setDouble(4, cost);
         preparedStatement.setDouble(5, emp_id);
         preparedStatement.executeUpdate(); 
         preparedStatement.close();
         JOptionPane.showMessageDialog(null,"success");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
             try {
                 conn.close();
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
        }
    }
//****************


 //ادخال حسابات عميل 13
void insert_client_reckoning(int sup_id,String date, String notes){
         Connection conn = null;
        try{ 
            String sql = "INSERT INTO client_reckoning( client_id , da2n , madyon , last_date , notes ) " +
        "VALUES (?, ?, ? , ? , ? )";
         conn=connect();
         PreparedStatement preparedStatement = conn.prepareStatement(sql);
         preparedStatement.setString(1,date);
         preparedStatement.setDouble(2, 0);
         preparedStatement.setDouble(3, 0);
         preparedStatement.setString(4, date);
         preparedStatement.setString(5, notes);
         preparedStatement.executeUpdate(); 
         preparedStatement.close();
         
         JOptionPane.showMessageDialog(null,"success");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
             try {
                 conn.close();
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
        }
    }
//********************
   



    //////////////////////////////////////////////تحديث//////////////////////////////////////////



//تحديث بيانات مورد1-1
    void update_suppliers(String name,int id,String old_name){
           Connection conn = null;
        try{ 
              String sql = "UPDATE suppliers SET sup_name = ?  "
                + "WHERE sup_id = ? or sup_name = ?";
         conn=connect();
         PreparedStatement preparedStatement = conn.prepareStatement(sql);
         preparedStatement.setString(1,name);
         preparedStatement.setDouble(2, id);
         preparedStatement.setString(3,old_name);
         preparedStatement.executeUpdate(); 
         preparedStatement.close();
         
         JOptionPane.showMessageDialog(null,"success");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
             try {
                 conn.close();
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
        }
        
    }
   //*****************

    
//تحديث بيانات عميل1-2
    void update_clients(String name,int id,String old_name){
           Connection conn = null;
        try{ 
              String sql = "UPDATE clients SET client_name = ?  "
                + "WHERE client_id = ? or client_name = ?" ;
         conn=connect();
         PreparedStatement preparedStatement = conn.prepareStatement(sql);
         preparedStatement.setString(1,name);
         preparedStatement.setDouble(2, id);
         preparedStatement.setString(3, old_name);
         preparedStatement.executeUpdate(); 
         preparedStatement.close();
         
         JOptionPane.showMessageDialog(null,"success");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
             try {
                 conn.close();
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
        }
        
    }
//*****************

   //تحديث بيانات حسابات عميل1-3
    void update_clients_reckoning(int id,double da2n,double madyon,String last_date){
           Connection conn = null;
        try{ 
              String sql = "UPDATE clients_reckoning SET da2n = da2n + ? , madyon = madyon + ? , last_date = ?   "
                + "WHERE client_id = " ;
         conn=connect();
         PreparedStatement preparedStatement = conn.prepareStatement(sql);
         preparedStatement.setDouble(1,da2n);
         preparedStatement.setDouble(2, madyon);
         preparedStatement.setString(3, last_date);
         preparedStatement.setInt(4, id);
         preparedStatement.executeUpdate(); 
         preparedStatement.close();
         
         JOptionPane.showMessageDialog(null,"success");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
             try {
                 conn.close();
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
        }
        
    }
//*****************

   //1-4تحديث حسابات مورد
    void update_supplier_reckoning(int id,double da2n,double madyon,String last_date){
           Connection conn = null;
        try{ 
              String sql = "UPDATE clients_reckoning SET da2n = da2n + ? , madyon = madyon + ? , last_date = ?   "
                + "WHERE sup_id = ? " ;
         conn=connect();
         PreparedStatement preparedStatement = conn.prepareStatement(sql);
         preparedStatement.setDouble(1,da2n);
         preparedStatement.setDouble(2, madyon);
         preparedStatement.setString(3, last_date);
         preparedStatement.setInt(4, id);
         preparedStatement.executeUpdate(); 
         preparedStatement.close();
         
         JOptionPane.showMessageDialog(null,"success");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
             try {
                 conn.close();
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
        }
        
    }
//*****************

 //تحديث فواتير1-5
    void update_bells(double total,String reciver_name, int emp_id,String notes, int bell_code ,String date){
         Connection conn = null;
        try{ 
           String sql = "UPDATE bells SET total = ? , reciver_name = ? , notes = ? , bell_date = ?     "
                + "WHERE bell_code = ? " ;
         conn=connect();
         PreparedStatement preparedStatement = conn.prepareStatement(sql);
         preparedStatement.setDouble(1,total);
         preparedStatement.setString(2, reciver_name);
         preparedStatement.setString(3, notes);
         preparedStatement.setString(4, date);
         preparedStatement.setInt(5, bell_code);
         preparedStatement.executeUpdate(); 
         preparedStatement.close();
         
         JOptionPane.showMessageDialog(null,"success");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
             try {
                 conn.close();
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
        }
    }
    //*******************
  
//تحديث فواتي شراء1-6
    void update_buyies(String date,double total,int sup_id, int admin_id,int item_quantity,double item_price,String item_name
    ,int warehouse_id, String notes,int bell_code){
         Connection conn = null;
        try{ 
          String sql = "UPDATE bells SET total = ? , sup_id = ? , admin_id = ? , item_quantity = ? , item_price = ? , item_name = ? , warehouse_id = ? , notes = ?     "
                + "WHERE buy_bell_code = ? " ;
         conn=connect();
         PreparedStatement preparedStatement = conn.prepareStatement(sql);
         preparedStatement.setDouble(1,total);
         preparedStatement.setInt(2, sup_id);
         preparedStatement.setInt(3, admin_id);
         preparedStatement.setInt(4, item_quantity);
         preparedStatement.setDouble(5, item_price);
         preparedStatement.setString(6, item_name);
         preparedStatement.setInt(7, warehouse_id);
         preparedStatement.setString(8, notes);
         preparedStatement.setInt(9, bell_code);
         preparedStatement.executeUpdate(); 
         preparedStatement.close();
         JOptionPane.showMessageDialog(null,"success");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
             try {
                 conn.close();
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
        }
    }
    //************
        

//تحديثاصناف1-7
void update_items(String item_name,double item_price,int warehouse_id,double item_real_price ,String notes,int sup_id,int item_id){
         Connection conn = null;
        try{ 
          String sql = "UPDATE bells SET item_name = ? , item_price = ? , warehouse_id = ? , item_real_price = ? , notes = ? , sup_id = ? "
                + "WHERE item_id = ? " ;
         conn=connect();
         PreparedStatement preparedStatement = conn.prepareStatement(sql);
         preparedStatement.setString(1,item_name);
         preparedStatement.setDouble(2, item_price);
         preparedStatement.setInt(3, warehouse_id);
         preparedStatement.setDouble(4, item_real_price);
         preparedStatement.setString(5, notes);
         preparedStatement.setInt(6, sup_id);
         preparedStatement.setInt(7, item_id);
         preparedStatement.executeUpdate(); 
         preparedStatement.close();
         JOptionPane.showMessageDialog(null,"success");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
             try {
                 conn.close();
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
        }
    }
//****************

//تعديل فالمسترجعات1-8
void update_retrived(int item_id,int bell_id){
         Connection conn = null;
        try{ 
          String sql = "UPDATE bells SET item_id = ? "
                + "WHERE bell_id = ? " ;
         conn=connect();
         PreparedStatement preparedStatement = conn.prepareStatement(sql);
         preparedStatement.setInt(1,item_id);
         preparedStatement.setInt(2, bell_id);
         preparedStatement.executeUpdate(); 
         preparedStatement.close();
         JOptionPane.showMessageDialog(null,"success");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
             try {
                 conn.close();
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
        }
    }
//****************

 //تحديث مصورفات1-9
void update_expenses(String notes,String emp_name,String expense_date,double cost ,String oldname ){
         Connection conn = null;
        try{ 
           String sql = "UPDATE bells SET notes = ? , emp_name= ? , cost = ? "
                + "WHERE emp_name = ? and expense_date = ? " ;
         conn=connect();
         PreparedStatement preparedStatement = conn.prepareStatement(sql);
         preparedStatement.setString(1,notes);
         preparedStatement.setString(2, emp_name);
         preparedStatement.setDouble(3, cost);
         preparedStatement.setString(4, oldname);
         preparedStatement.setString(5, expense_date);
         preparedStatement.executeUpdate(); 
         preparedStatement.close();
         JOptionPane.showMessageDialog(null,"success");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
             try {
                 conn.close();
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
        }
    }
//****************

 
//تحديث موظفين1-10
void update_employees(String emp_name,String emp_password,String emp_adress,String emp_shift,double emp_salary,String notes ,String old_name,int emp_id){
         Connection conn = null;
        try{ 
         String sql = "UPDATE bells SET emp_name = ? , emp_password= ? , emp_adress = ? , emp_shift = ? , emp_salary = ? , notes= ?"
                + "WHERE emp_id = ? or emp_name = ? " ;
         conn=connect();
         PreparedStatement preparedStatement = conn.prepareStatement(sql);
         preparedStatement.setString(1,emp_name);
         preparedStatement.setString(2, emp_password);
         preparedStatement.setString(3, emp_adress);
         preparedStatement.setString(4, emp_shift);
         preparedStatement.setDouble(5, emp_salary);
         preparedStatement.setString(6, notes);
         preparedStatement.setInt(7, emp_id);
         preparedStatement.setString(8, emp_name);
         preparedStatement.executeUpdate(); 
         preparedStatement.close();
         JOptionPane.showMessageDialog(null,"success");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
             try {
                 conn.close();
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
        }
    }
//********************
    
   
//تحديث مديرين1-11
void update_admins(String name,String password,String oldname ,int admin_id ){
         Connection conn = null;
        try{ 
            String sql = "update admins set admin_username = ? , admin_password = ?  " +
        "where admin_username = ? or admin_id = ?";
         conn=connect();
         PreparedStatement preparedStatement = conn.prepareStatement(sql);
         preparedStatement.setString(1,name);
         preparedStatement.setString(2, password);
         preparedStatement.setString(2, oldname);
         preparedStatement.setInt(2, admin_id);
         preparedStatement.executeUpdate(); 
         preparedStatement.close();
         JOptionPane.showMessageDialog(null,"success");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
             try {
                 conn.close();
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
        }
    }
//********************

//تحديث مبيعات1-11
void update_sales(int bell_id,int item_id,int quantity){
         Connection conn = null;
        try{ 
            String sql = "update  sales set  quantity = ? " +
        "where  bell_id = ? ,item_id = ? ";
         conn=connect();
         PreparedStatement preparedStatement = conn.prepareStatement(sql);
         preparedStatement.setInt(1,quantity);
         preparedStatement.setInt(2, bell_id);
         preparedStatement.setInt(3, item_id);
         preparedStatement.executeUpdate(); 
         preparedStatement.close();
         JOptionPane.showMessageDialog(null,"success");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
             try {
                 conn.close();
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
        }
    }
//****************

 
   /////////////////////////////////////////////////////////مسح \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\




//مسح مورد
    void delete_suppliers(int id,String name){
        String sql = "DELETE FROM suppliers WHERE sup_id = ? and sup_name = ?";
         try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {           
                pstmt.setInt(1,id);
                pstmt.setString(2,name);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null,"success");

 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
   //************
    
//مسح عميل
    void delete_clients(int id,String name){
        String sql = "DELETE FROM clients WHERE client_id = ? and client_name = ?";
         try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {           
                pstmt.setInt(1,id);
                pstmt.setString(2,name);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null,"success");

 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
   //************
    
    
//مسح موظف
    void delete_employees(int id,String name){
        String sql = "DELETE FROM employees WHERE emp_id = ? and emp_name = ?";
         try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {           
                pstmt.setInt(1,id);
                pstmt.setString(2,name);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null,"success");

 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
   //************
    
       
//مسح مدير
    void delete_admin(int id,String name){
        String sql = "DELETE FROM admins WHERE admin_id = ? and admin_name = ?";
         try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {           
                pstmt.setInt(1,id);
                pstmt.setString(2,name);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null,"success");

 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
   //************
       
    
//مسح فواتير البيع
    void delete_bells(int bell_id){
        String sql = "DELETE FROM bells WHERE bell_code = ? ";
         try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {           
                pstmt.setInt(1,bell_id);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null,"success");

 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //**************

//مسح فواتير الشراء
    void delete_buy_bells(int bell_id){
        String sql = "DELETE FROM buyies WHERE buy_bell_code = ? ";
         try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {           
                pstmt.setInt(1,bell_id);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null,"success");

 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //**************

   //مسح اصناف
    void delete_items(int item_id){
        String sql = "DELETE FROM items WHERE item_id = ? ";
         try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {           
                pstmt.setInt(1,item_id);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null,"success");

 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //**************
 
    
  //مسح مخزن
    void delete_warehouses(int warehouse_id, String warehouse_name){
        String sql = "DELETE FROM warehouses WHERE warehouse_id = ? and warehouse_name = ?";
         try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {           
                pstmt.setInt(1,warehouse_id);
                pstmt.setString(2,warehouse_name);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null,"success");

 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //**************
 
   //مسح مشتريات
    void delete_sales(int bell_id, int item_id) {
        String sql = "DELETE FROM salse WHERE bell_id = ? and item_id = ?";
         try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {           
                pstmt.setInt(1,bell_id);
                pstmt.setInt(2,item_id);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null,"success");

 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //**************
 
//مسح مرتجع
    void delete_retrived(int bell_id, int item_id) {
        String sql = "DELETE FROM Retrieved WHERE bell_id = ? and item_id = ?";
         try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {           
                pstmt.setInt(1,bell_id);
                pstmt.setInt(2,item_id);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null,"success");

 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //**************
 

//مسح حسابات مورد
    void delete_suppliers_reckoning(int id){
        String sql = "DELETE FROM suppliers_reckoning WHERE sup_id = ? ";
         try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {           
                pstmt.setInt(1,id);
                pstmt.setString(2,name);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null,"success");

 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
   //************
    

     
    
    
//مسح حسابات مورد
    void delete_clients_reckoning(int id){
        String sql = "DELETE FROM clients_reckoning WHERE clients_id = ? ";
         try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {           
                pstmt.setInt(1,id);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null,"success");

 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
   //************
    

     
    
}

