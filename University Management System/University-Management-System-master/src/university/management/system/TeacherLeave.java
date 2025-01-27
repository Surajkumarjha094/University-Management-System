
package university.management.system;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class TeacherLeave extends JFrame implements ActionListener {
    Choice cempId , ctime;
    JDateChooser dcdate;
    JButton submit,cancel;
    TeacherLeave(){
        setSize(500,500);
        setLocation(550,100);
        setLayout(null);
        
         getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Apply Leave (Teacher)");
        heading.setBounds(40,50,300,20);
        heading.setFont(new Font("Tahoma", Font.BOLD,20));
        add(heading);
        
        
        JLabel empid = new JLabel("Search by Employee Id");
         empid .setBounds(60,100,150,20);
         heading.setFont(new Font("Tahoma", Font.PLAIN,15));
        add( empid );
        
        cempId=  new Choice();
       cempId.setBounds(60,130,200,20);
        add(cempId);
        
        try{
        Conn c =new Conn(); 
        ResultSet rs = c.s.executeQuery("select * from  teacher");
        while(rs.next()){
            cempId.add(rs.getString("empid"));
        }
        
        }
        catch (Exception e){
        e.printStackTrace();}     
        
          JLabel lbldate = new JLabel("Date");
        lbldate .setBounds(60,180,200,20);
         lbldate.setFont(new Font("Tahoma", Font.PLAIN,15));
        add( lbldate );
       
        dcdate = new JDateChooser();
        dcdate .setBounds(60,210,200,30);
        add(dcdate);
        
         JLabel lbltime = new JLabel("Time Duration");
         lbltime  .setBounds(60,260,200,25);
         heading.setFont(new Font("Tahoma", Font.PLAIN,18));
        add( lbltime  );
        
        ctime =  new Choice();
        ctime.setBounds(60,290,200,25);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);
        
        submit  = new JButton("Submit");
        submit.setBounds(60,350,100,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("serif",Font.BOLD,15));
        add(submit);
        
         cancel  = new JButton("Cancel");
        cancel.setBounds(200,350,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("serif",Font.BOLD,15));
        add(cancel);
        
       
        setVisible(true);
        
        
    
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== submit){
            String empid = cempId.getSelectedItem();
            String date  = ((JTextField)dcdate.getDateEditor().getUiComponent ()).getText();
            String duration   = ctime.getSelectedItem();
            String query = "insert into teacherLeave values('"+empid+"', '"+date+"','"+duration+"')";
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Leave Confirmed");
                setVisible(false);
            }catch (Exception  e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }
    
    public static void main(String[]args){
   new TeacherLeave();
    
    }
    
    
}
