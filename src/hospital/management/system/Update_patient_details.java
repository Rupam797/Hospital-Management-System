package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import java.util.Map;

public class Update_patient_details extends JFrame {
    Update_patient_details(){

        JPanel panel=new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(204,102,102));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500, 60, 300, 300);
        panel.add(label);

        JLabel label1= new JLabel("Update Patient Details");
        label1.setBounds(124,11,260,25);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(label1);

        JLabel label2 = new JLabel("Name :");
        label2.setBounds(25,88,100,14);
        label2.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(label2);

        Choice choice=new Choice();
        choice.setBounds(248,85,140,25);
        panel.add(choice);

        try{
            Conn c=new Conn();
            ResultSet resultSet=c.statement.executeQuery("select * from patient_info");
            while(resultSet.next()){
                choice.add(resultSet.getString("Name"));
            }

        }catch(Exception e){
            e.printStackTrace();

        }

        JLabel label3 = new JLabel("Room Number");
        label3.setBounds(25,130,100,14);
        label3.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(label3);

        JTextField textField=new JTextField();
        textField.setBounds(248,129,140,20);
        panel.add(textField);

        JLabel label4 = new JLabel("In-Time");
        label4.setBounds(25,174,100,14);
        label4.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(label4);

        JTextField textFieldINTime =new JTextField();
        textFieldINTime.setBounds(248,174,140,20);
        panel.add(textFieldINTime);

        JLabel label5 = new JLabel("Amount Paid (RS) :");
        label5.setBounds(25,216,150,14);
        label5.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(label5);

        JTextField textFieldAmount =new JTextField();
        textFieldAmount.setBounds(248,216,140,20);
        panel.add(textFieldAmount);


        JLabel label6 = new JLabel("Pending :");
        label6.setBounds(25,261,100,20);
        label6.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(label6);

        JTextField textFieldPending =new JTextField();
        textFieldPending.setBounds(248,261,140,20);
        panel.add(textFieldPending);


        JButton check=new JButton("CHECK");
        check.setBounds(281,378,89,23);
        check.setBackground(Color.black);
        check.setForeground(Color.WHITE);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=choice.getSelectedItem();
                String q="select * from Patient_info where Name='"+id+"'";
                try{

                    Conn c=new Conn();
                    ResultSet resultSet=c.statement.executeQuery(q);
                    while(resultSet.next()){
                        textField.setText(resultSet.getString("Room_NUmber"));
                        textFieldINTime.setText(resultSet.getString("Time"));
                        textFieldAmount.setText(resultSet.getString("Deposite"));

                    }
                    ResultSet resultSet2=c.statement.executeQuery("select * from room where Room_no='"+textField.getText()+"'");
                    while(resultSet2.next()){
                        String price=resultSet2.getString("Price");
                        int amountPaid=Integer.parseInt(price)-Integer.parseInt(textFieldAmount.getText());
                        textFieldPending.setText(""+amountPaid);
                    }
                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });



        JButton update=new JButton("UPDATE");
        update.setBounds(56,378,89,23);
        update.setBackground(Color.black);
        update.setForeground(Color.WHITE);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Conn c = new Conn();
                    String q = choice.getSelectedItem();
                    String room=textField.getText();
                    String time=textFieldINTime.getText();
                    String amount=textFieldAmount.getText();
                    c.statement.executeUpdate("update Patient_info set Room_Number='"+room+"',Time='"+time+"',Deposite='"+amount+"' where name ='"+q+"'");
                    JOptionPane.showMessageDialog(null,"Updated Successfully");
                    setVisible(false);
                }catch(Exception p){
                    p.printStackTrace();

                }
            }
        });


        JButton button2 =new JButton("BACK");
        button2.setBounds(168,378,89,23);
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
        setSize(950,500);
        setLayout(null);
        setLocation(400,250);
        setVisible(true);

    }
    public static void main(String[] args) {
        new Update_patient_details();

    }
}
