
package university.management.system;
import javax.swing.*;
import java.awt.*;

import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.sql.ResultSet;
import java.sql.*;


public class UpdateTeacher extends JFrame implements ActionListener {
    JTextField tfeducation, tfdepartment,  tfaddress,tfphone, tfemail,tfbranch;
    JLabel labelempid ;
    JButton  submit,cancel;
    Choice cEmpId;
    
   UpdateTeacher(){
        setSize(900,700);
        setLocation(350,50);
        setLayout(null);
        
//        Heading
        
        JLabel heading = new JLabel("Update Techer Details");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);
        
        JLabel lblrollno= new JLabel("Select EmpId");
        lblrollno.setBounds(50,100,200,20);
        lblrollno.setFont(new Font("serif",Font.BOLD,20));
        
        add(lblrollno);
        
       cEmpId =  new Choice();
        cEmpId.setBounds(250,100,200,20);
        add(cEmpId);
        
        try{
        Conn c =new Conn(); 
        ResultSet rs = c.s.executeQuery("select * from  teacher");
        while(rs.next()){
            cEmpId.add(rs.getString("empid"));
        }
        
        }
        catch (Exception e){
        e.printStackTrace();}     
        
        
//        usernname 

        JLabel lblname = new JLabel("Username");
        lblname.setBounds(50,150,100,30);
        lblname.setFont(new Font("serif",Font.BOLD,20));
        add(lblname);
        
        JLabel labelname = new JLabel();
        labelname.setBounds(200,150,150,30);
        labelname.setFont(new Font("Tahoma",Font.BOLD,20));
        add(labelname);
        
//        Fathername
        
        JLabel lblfname = new JLabel("Father's Name");
       lblfname.setBounds(400,150,200,30);
      lblfname.setFont(new Font("serif",Font.BOLD,20));
        add(lblfname);
        
      JLabel   labelfname = new JLabel();
        labelfname.setBounds(600,150,150,30);
        labelfname.setFont(new Font("Tahoma",Font.BOLD,20));
        add(labelfname);
//        rollno
         JLabel lblrollnumber = new JLabel("Employee Id");
       lblrollnumber.setBounds(50,200,200,30);
       lblrollnumber.setFont(new Font("serif",Font.BOLD,20));
        add(lblrollnumber);
        
         labelempid = new JLabel();
        labelempid.setBounds(200,200,200,30);
       labelempid.setFont(new Font("Tahoma",Font.BOLD,20));
        add(labelempid);
        
//        dob using  calender
        
        JLabel lbldob = new JLabel("Date Of Birth");
        lbldob.setBounds(400,200,200,30);
      lbldob.setFont(new Font("serif",Font.BOLD,20));
        add(lbldob);
        
       JLabel  labeldob = new JLabel();
        labeldob .setBounds(600,200,150,30);
        labeldob.setFont(new Font("Tahoma",Font.BOLD,20));
        add(labeldob);
        
         JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50,250,200,30);
      lbladdress.setFont(new Font("serif",Font.BOLD,20));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);
        
         JLabel lblphone = new JLabel("Phone Number");
        lblphone.setBounds(400,250,200,30);
       lblphone.setFont(new Font("serif",Font.BOLD,20));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);
       
        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50,300,200,30);
      lblemail.setFont(new Font("serif",Font.BOLD,20));
        add(lblemail);
        
        tfemail = new JTextField();
         tfemail.setBounds(200,300,150,30);
        add( tfemail);
        
         JLabel lbx = new JLabel("Class X (%)");
        lbx.setBounds(400,300,200,30);
      lbx.setFont(new Font("serif",Font.BOLD,20));
        add(lbx);
        
       JLabel labelx = new JLabel();
        labelx.setBounds(600,300,150,30);
        labelx.setFont(new Font("Tahoma",Font.BOLD,20));
        add(labelx);
        
        
      JLabel lblxii = new JLabel(" Class XII(%)");
        lblxii.setBounds(50,350,200,30);
       lblxii.setFont(new Font("serif",Font.BOLD,20));
        add(lblxii);
        
        JLabel labelxii = new JLabel();
        labelxii.setBounds(200,350,150,30);
        labelxii.setFont(new Font("Tahoma",Font.BOLD,20));
        add(labelxii); 
        
         JLabel lblaadhar= new JLabel(" Adhar Number");
        lblaadhar.setBounds(400,350,200,30);
       lblaadhar.setFont(new Font("serif",Font.BOLD,20));
        add(lblaadhar);
        
        JLabel labelaadhar = new JLabel();
        labelaadhar.setBounds(600,350,150,30);
        labelaadhar.setFont(new Font("Tahoma",Font.BOLD,16));
        add(labelaadhar); 
        
        JLabel lblcourse= new JLabel("Education");
       lblcourse.setBounds(50,400,200,30);
       lblcourse.setFont(new Font("serif",Font.BOLD,20));
        add(lblcourse);
        
        String education []  ={"b.tech","BBA","BcA","Msc","MBA","MCA","MA"};
      
        tfeducation = new JTextField();
        tfeducation .setBounds(200,400,150,30);
        
        add(tfeducation );
        
        JLabel lbldepartment= new JLabel("Department");
       lbldepartment.setBounds(400,400,200,30);
       lbldepartment.setFont(new Font("serif",Font.BOLD,20));
        add(lbldepartment);
        
        String department []  ={"computer science","electronics","IT","Civil","Mechanics"};
      
        tfdepartment = new JTextField();
        tfdepartment.setBounds(600,400,150,30);
        tfdepartment.setBackground(Color.WHITE);
        add(tfdepartment);
        
       cEmpId.addItemListener(new ItemListener() {
    public void itemStateChanged(ItemEvent ie) {
        try {
            Conn c = new Conn();
            String query = "select * from teacher where empid = '" + cEmpId.getSelectedItem() + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                labeldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
               labelx.setText(rs.getString("class_x"));
                labelxii.setText(rs.getString("class_xii"));
                labelaadhar.setText(rs.getString("aadhar"));
                labelempid.setText(rs.getString("empid"));
                tfeducation.setText(rs.getString("education"));
                tfdepartment.setText(rs.getString("department"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
});

        submit  = new JButton("Update");
        submit.setBounds(250,500,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("serif",Font.BOLD,15));
        add(submit);
        
         cancel  = new JButton("Cancel");
        cancel.setBounds(450,500,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif",Font.BOLD,15));
        add(cancel);
                
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            
String empid = labelempid.getText(); 
String address =  tfaddress.getText();
String phone = tfphone.getText();
String email = tfemail.getText();


String education = tfeducation.getText();
String department = tfdepartment.getText();

try { 
    
    String query = "update teacher set address ='"+address+"',phone ='"+phone+"',email = '"+email+"',education = '"+education+"', department = '"+department+"' where empid = '"+empid+"'";
    Conn con = new Conn();
    con.s.executeUpdate(query);
    JOptionPane.showMessageDialog(null,"teacher Details Updated Succsesfully");
setVisible(false);    
}catch (Exception e){
}
    }
else{
    setVisible(false);
}}
    public static void main(String[]args){
        new UpdateTeacher();
    
    }
    
}
//RAM