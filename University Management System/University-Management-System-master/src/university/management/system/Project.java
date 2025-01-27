package university.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Project extends JFrame implements ActionListener {
    Project() {
        setSize(1540, 850);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        JMenuBar mb = new JMenuBar();

        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.BLUE);
        mb.add(newInformation);

        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);

        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.addActionListener(this);
        studentInfo.setBackground(Color.WHITE);
        newInformation.add(studentInfo);

        // View Details menu
        JMenu details = new JMenu("View Details");
        details.setForeground(Color.RED);
        mb.add(details);

        JMenuItem facultydetails = new JMenuItem("View Faculty Details");
        facultydetails.setBackground(Color.WHITE);
        facultydetails.addActionListener(this);
        details.add(facultydetails);

        JMenuItem studentdetails = new JMenuItem("View Student Details");
        studentdetails.setBackground(Color.WHITE);
        studentdetails.addActionListener(this);
        details.add(studentdetails);

        // Apply Leave menu
        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.BLUE);
        mb.add(leave);

        JMenuItem facultyleave = new JMenuItem("Faculty Leave");
        facultyleave.setBackground(Color.WHITE);
        facultyleave.addActionListener(this);
        leave.add(facultyleave);

        JMenuItem studentleave = new JMenuItem("Student Leave");
        studentleave.setBackground(Color.WHITE);
        studentleave.addActionListener(this);
        
        leave.add(studentleave);

        // Leave Details menu
        JMenu leaveDetails = new JMenu("Leave Details");
        leaveDetails.setForeground(Color.RED);
        mb.add(leaveDetails);

        JMenuItem facultyleavedetails = new JMenuItem("Faculty Leave Details");
        facultyleavedetails.setBackground(Color.WHITE);
        facultyleavedetails.addActionListener(this);
        leaveDetails.add(facultyleavedetails);

        JMenuItem studentleavedetails = new JMenuItem("Student Leave Details");
        studentleavedetails.setBackground(Color.WHITE);
         studentleavedetails.addActionListener(this);
        leaveDetails.add(studentleavedetails);

        // Examination menu
        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.BLUE);
        mb.add(exam);

        JMenuItem examinationdetails = new JMenuItem("Examination Results");
        examinationdetails.setBackground(Color.WHITE);
        exam.add(examinationdetails);

        JMenuItem entermarks = new JMenuItem("Enter Marks");
        entermarks.setBackground(Color.WHITE);
        entermarks.addActionListener(this);
        exam.add(entermarks);

        // Update Details menu
        JMenu updateInfo = new JMenu("Update Details");
        updateInfo.setForeground(Color.RED);
        mb.add(updateInfo);

        JMenuItem updatefacultyinfo = new JMenuItem("Update Faculty Details");
        updatefacultyinfo.setBackground(Color.WHITE);
        updatefacultyinfo.addActionListener(this);
        updateInfo.add(updatefacultyinfo);

        JMenuItem updatestudentinfo = new JMenuItem("Update Student Details");
        updatestudentinfo.setBackground(Color.WHITE);
        updatestudentinfo.addActionListener(this); 
        updateInfo.add(updatestudentinfo);

        // Fee Details menu
        JMenu feeInfo = new JMenu("Fee Details");
        feeInfo.setForeground(Color.BLUE);
        mb.add(feeInfo);

        JMenuItem feestructure = new JMenuItem("Fee Structure");
        feestructure.setBackground(Color.WHITE);
        feeInfo.add(feestructure);

        JMenuItem feeform = new JMenuItem("Fee Form");
        feeform.setBackground(Color.WHITE);
        feeInfo.add(feeform);

        // Utility menu
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.RED);
        mb.add(utility);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setBackground(Color.WHITE);
        calculator.addActionListener(this);
        utility.add(calculator);

        // EXIT menu
        JMenu exit = new JMenu("EXIT");
        exit.setForeground(Color.BLUE);
        mb.add(exit);

        JMenuItem ex = new JMenuItem("EXIT");
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        exit.add(ex);

        // Set the menu bar only once at the end
        setJMenuBar(mb);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        if (msg.equals("EXIT")) {
            setVisible(false);
        } else if (msg.equalsIgnoreCase("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (msg.equalsIgnoreCase("Notepad")) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(msg.equals("New Faculty Information")){
          new AddTeacher();  
        }else if(msg.equals("New Student Information")){
          new AddStudent();  
        }
        else if(msg.equals("View Faculty Details")){
          new TeacherDetails();  
        }
        else if(msg.equals("View Student Details")){
          new  StudentDetails();  
        }
         else if(msg.equals("Student Leave")){
          new  StudentLeave();  
        }
         else if(msg.equals("Faculty Leave")){
          new  TeacherLeave();  
        }
         else if(msg.equals("Student Leave Details")){
          new  StudentLeaveDetails();  
        }
         else if(msg.equals("Faculty Leave Details")){
          new  TeacherLeaveDetails();  
        }
        else if(msg.equals("Update Student Details")){
          new  UpdateStudent();  
        }
         else if(msg.equals("Update Faculty Details")){
          new  UpdateTeacher();  
        }
        
        else if(msg.equals("Enter Marks")){
          new  EnterMarks();  
        }
    }

    public static void main(String[] args) {
        new Project();
    }
}
