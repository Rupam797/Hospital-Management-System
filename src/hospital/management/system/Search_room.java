package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Search_room extends JFrame {

    Choice choice;
    JTable table;
    Search_room(){
        JPanel panel=new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(204,102,102));
        panel.setLayout(null);
        add(panel);

        JLabel label1= new JLabel("Search For Rooms");
        label1.setBounds(250,11,186,25);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(label1);

        JLabel label2 = new JLabel("Status :");
        label2.setBounds(70,70,80,25);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        choice=new Choice();
        choice.setBounds(170,70,120,20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        table=new JTable();
        table.setBounds(0,187,700,210);
        table.setBackground(new Color(204,102,102));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try{
            Conn c=new Conn();
            String q="select * from room";
            ResultSet resultSet=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number");
        label3.setBounds(33,162,150,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);

        JLabel label4 = new JLabel("Availability");
        label4.setBounds(210,162,150,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);

        JLabel label5 = new JLabel("Price");
        label5.setBounds(415,162,150,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label5);

        JLabel label6 = new JLabel("Bed Type");
        label6.setBounds(565,162,150,20);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label6);

        JButton search=new JButton("Search");
        search.setBounds(200,420,120,20);
        search.setBackground(Color.black);
        search.setForeground(Color.WHITE);
        panel.add(search);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q="select * from Room where Availablity='"+choice.getSelectedItem()+"'";
                try{
                    Conn c=new Conn();
                    ResultSet resultSet=c.statement.executeQuery(q);
                    table.setModel((DbUtils.resultSetToTableModel(resultSet)));
                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });


        JButton back =new JButton("Back");
        back.setBounds(380,420,120,20);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });



        setUndecorated(true);
        setSize(700,500);
        setLayout(null);
        setLocation(400,250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new  Search_room();
    }
}
