package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Patient_discharge extends JFrame {
    Patient_discharge(){

        JPanel panel=new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(204,102,102));
        panel.setLayout(null);
        add(panel);

        JLabel label1= new JLabel("CHECK_OUT");
        label1.setBounds(50,11,150,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(label1);

        JLabel label2 = new JLabel("Patient ID");
        label2.setBounds(30,80,150,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label2);

        Choice choice=new Choice();
        choice.setBounds(200,80,150,25);
        panel.add(choice);

        try{
            Conn c=new Conn();
            ResultSet resultSet=c.statement.executeQuery("select * from patient_info");
            while(resultSet.next()){
                choice.add(resultSet.getString("number"));
            }

        }catch(Exception e){
            e.printStackTrace();

        }
        JLabel label3 = new JLabel("Room Number");
        label3.setBounds(30,130,150,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label3);

        JLabel RNo = new JLabel();
        RNo.setBounds(200,130,150,20);
        RNo.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(RNo);

        JLabel label4 = new JLabel("In Time");
        label4.setBounds(30,180,150,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label4);

        JLabel INTime = new JLabel();
        INTime.setBounds(200,180,250,20);
        INTime.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(INTime);

        JLabel label5 = new JLabel("Out Time");
        label5.setBounds(30,230,150,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(label5);

        Date date=new Date();

        JLabel OUTime = new JLabel(""+date);
        OUTime.setBounds(200,230,250,20);
        OUTime.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(OUTime);

        JButton button=new JButton("DISCHARGE");
        button.setBounds(30,300,120,30);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Conn c=new Conn();
                try{
                   c.statement.executeUpdate("delete from patient_info where number='"+choice.getSelectedItem()+"'");
                   c.statement.executeUpdate("update room set Availablity='Available' where Room_no='"+RNo.getText()+"'" );
                   JOptionPane.showMessageDialog(null,"Done");
                   setVisible(false);
                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });


        JButton button1 =new JButton("CHECK");
        button1.setBounds(170,300,120,30);
        button1.setBackground(Color.BLACK);
        button1.setForeground(Color.WHITE);
        panel.add(button1);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Conn c=new Conn();
                try{
                    ResultSet resultSet=c.statement.executeQuery("select * from patient_info where number='"+choice.getSelectedItem()+"'");

                    while(resultSet.next()) {
                        RNo.setText(resultSet.getString("Room_number"));
                        INTime.setText(resultSet.getString("Time"));
                    }
                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });


        JButton button2 =new JButton("BACK");
        button2.setBounds(300,300,120,30);
        button2.setBackground(Color.BLACK);
        button2.setForeground(Color.WHITE);
        panel.add(button2);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });




        setUndecorated(true);
        setSize(800,400);
        setLayout(null);
        setLocation(400,250);
        setVisible(true);
    }

    public static void main(String[] args) {

        new Patient_discharge();
    }
}
