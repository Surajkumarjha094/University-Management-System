
package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;


public class AddTeacher extends JFrame implements ActionListener {
    JTextField tfname,  tffname,tfrname, tfaddress,tfphone, tfemail,tfx,tfxii,tfaadhar;
    JLabel labelempid ;
    JDateChooser dcdob;
    JComboBox cbcourse,cbbranch;
    JButton  submit,cancel;
    
    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong()%8000L)+1000L);
    AddTeacher(){
        setSize(900,700);
        setLocation(350,50);
        setLayout(null);
        
//        Heading
        
        JLabel heading = new JLabel("NEW Teacher Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);
        
//        usernname

        JLabel lblname = new JLabel("Username");
        lblname.setBounds(50,150,100,30);
        lblname.setFont(new Font("serif",Font.BOLD,20));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);
        
//        Fathername
        
        JLabel lblfname = new JLabel("Father's Name");
       lblfname.setBounds(400,150,200,30);
      lblfname.setFont(new Font("serif",Font.BOLD,20));
        add(lblfname);
        
        tffname = new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);
//        rollno
         JLabel lblrollno = new JLabel("Employee Id ");
        lblrollno.setBounds(50,200,200,30);
       lblrollno.setFont(new Font("serif",Font.BOLD,20));
        add(lblrollno);
        
         labelempid = new JLabel("23scse"+first4);
        labelempid.setBounds(200,200,200,30);
       labelempid.setFont(new Font("serif",Font.BOLD,20));
        add(labelempid);
        
//        dob using  calender
        
        JLabel lbldob = new JLabel("Date Of Birth");
        lbldob.setBounds(400,200,200,30);
      lbldob.setFont(new Font("serif",Font.BOLD,20));
        add(lbldob);
        
         dcdob = new JDateChooser();
        dcdob .setBounds(600,200,150,30);
        add(dcdob);
        
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
        
        tfx = new JTextField();
        tfx.setBounds(600,300,150,30);
        add(tfx);
        
        
      JLabel lblxii = new JLabel(" Class XII(%)");
        lblxii.setBounds(50,350,200,30);
       lblxii.setFont(new Font("serif",Font.BOLD,20));
        add(lblxii);
        
        tfxii = new JTextField();
        tfxii.setBounds(200,350,150,30);
        add(tfxii); 
        
         JLabel lblaadhar= new JLabel(" Adhar Number");
        lblaadhar.setBounds(400,350,200,30);
       lblaadhar.setFont(new Font("serif",Font.BOLD,20));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(600,350,150,30);
        add(tfaadhar); 
        
        JLabel lblcourse= new JLabel("Qualification");
       lblcourse.setBounds(50,400,200,30);
       lblcourse.setFont(new Font("serif",Font.BOLD,20));
        add(lblcourse);
        
        String course []  ={"b.tech","BBA","BcA","Msc","MBA","MCA","MA"};
      
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200,400,150,30);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);
        
        JLabel lblbranch= new JLabel("Department");
       lblbranch.setBounds(400,400,200,30);
       lblbranch.setFont(new Font("serif",Font.BOLD,20));
        add(lblbranch);
        
        String branch []  ={"computer science","electronics","IT","Civil","Mechanics"};
      
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(600,400,150,30);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);
        
        
        submit  = new JButton("Submit");
        submit.setBounds(250,550,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("serif",Font.BOLD,15));
        add(submit);
        
         cancel  = new JButton("Cancel");
        cancel.setBounds(450,550,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif",Font.BOLD,15));
        add(cancel);
                
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
            String name = tfname.getText();
             String fname = tffname.getText();
String empid = labelempid.getText(); 
String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
String address =  tfaddress.getText();
String phone = tfphone.getText();
String email = tfemail.getText();
String x = tfx.getText();
String  xii= tfxii.getText();
String aadhar = tfaadhar.getText();
String course = (String)cbcourse.getSelectedItem();
String branch = (String)cbbranch.getSelectedItem();

try { 
    
    String query = "insert into teacher values('"+name+"','"+fname+"','"+empid+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+x+"','"+xii+"','"+aadhar+"','"+course+"','"+branch+"')";
    Conn con = new Conn();
    con.s.executeUpdate(query);
    JOptionPane.showMessageDialog(null,"teacher  Details Inserted Succsesfully");
setVisible(false);    
}catch (Exception e){
}
    }
else{
    setVisible(false);
}}
    public static void main(String[]args){
        new AddTeacher();
    
    }
    
}
//RAM