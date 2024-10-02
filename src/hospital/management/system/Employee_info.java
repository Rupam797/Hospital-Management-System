package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee_info extends JFrame {
     Employee_info(){

         JPanel panel=new JPanel();
         panel.setBounds(5,5,900,590);
         panel.setBackground(new Color(204,102,102));
         panel.setLayout(null);
         add(panel);

         JTable table=new JTable();
         table.setBounds(10,34,900,450);
         table.setBackground(new Color(204,102,102));
         table.setFont(new Font("Tahoma", Font.BOLD,12));
         panel.add(table);

         try{
             Conn c=new Conn();
             String q="select * from EMP_info";
             ResultSet resultset=c.statement.executeQuery(q);
             table.setModel((DbUtils.resultSetToTableModel(resultset)));

         }catch(Exception e){
             e.printStackTrace();

         }

         JLabel label1= new JLabel("Name");
         label1.setBounds(50,11,150,20);
         label1.setFont(new Font("Tahoma",Font.BOLD,17));
         panel.add(label1);

         JLabel label2= new JLabel("Age");
         label2.setBounds(220,11,150,20);
         label2.setFont(new Font("Tahoma",Font.BOLD,16));
         panel.add(label2);

         JLabel label3 = new JLabel("Phone Number");
         label3.setBounds(325,9,150,20);
         label3.setFont(new Font("Tahoma",Font.BOLD,16));
         panel.add(label3);

         JLabel label4 = new JLabel("Salary");
         label4.setBounds(520,11,150,20);
         label4.setFont(new Font("Tahoma",Font.BOLD,16));
         panel.add(label4);

         JLabel label5 = new JLabel("Email");
         label5.setBounds(650,11,150,20);
         label5.setFont(new Font("Tahoma",Font.BOLD,16));
         panel.add(label5);

         JLabel label7 = new JLabel("Aadhar Number ");
         label7.setBounds(750,11,150,20);
         label7.setFont(new Font("Tahoma",Font.BOLD,16));
         panel.add(label7);

         JButton button=new JButton("back");
         button.setBounds(350,500,120,30);
         button.setBackground(Color.BLACK);
         button.setForeground(Color.WHITE);
         panel.add(button);
         button.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 setVisible(false);
             }
         });




         setUndecorated(true);
         setSize(910,600);
         setLocation(350,230);
         setLayout(null);
         setVisible(true);

     }
    public static void main(String[] args) {
       new Employee_info();
    }
}
