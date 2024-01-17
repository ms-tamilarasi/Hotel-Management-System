
package hotel.management.system;


import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CustomerInfo extends JFrame {
    CustomerInfo(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(Color.decode("#ffa500"));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,60,900,450);
        table.setBackground(Color.decode("#ffa500"));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try {

            Connection c = new Connection();
            String q = "select * from customer";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e ){
            e.printStackTrace();
        }

        JLabel id = new JLabel("ID");
        id.setBounds(31,11,100,18);
        id.setForeground(Color.WHITE);
        id.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(id);

        JLabel number = new JLabel("Number");
        number.setBounds(150,11,100,18);
        number.setForeground(Color.WHITE);
        number.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(number);

        JLabel name = new JLabel("Name");
        name.setBounds(270,11,100,18);
        name.setForeground(Color.WHITE);
        name.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(name);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(360,11,100,18);
        gender.setForeground(Color.WHITE);
        gender.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(gender);

        JLabel country = new JLabel("Country");
        country.setBounds(480,11,100,18);
        country.setForeground(Color.WHITE);
        country.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(country);

        JLabel room = new JLabel("Room");
        room.setBounds(600,11,100,18);
        room.setForeground(Color.WHITE);
        room.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(room);

        JLabel Time = new JLabel("CI Time");
        Time.setBounds(680,11,100,18);
        Time.setForeground(Color.WHITE);
        Time.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(Time);

        JLabel Deposit = new JLabel("Deposit");
        Deposit.setBounds(800,11,100,18);
        Deposit.setForeground(Color.WHITE);
        Deposit.setFont( new Font("Tahoma", Font.BOLD,14));
        panel.add(Deposit);

        JButton back = new JButton("Back");
        back.setBounds(400,510,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setUndecorated(true);
        setLayout(null);
        setSize(900,600);
        setLocation(430,100);
        setVisible(true);
    }
    public static void main(String[] args) {
        new CustomerInfo();
    }
}
