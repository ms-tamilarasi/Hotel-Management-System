
package hotel.management.system;


import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PickUp extends JFrame {
    
    PickUp(){

        JPanel panel = new JPanel();
        panel.setBackground(Color.decode("#ffa500"));
        panel.setBounds(5,5,790,590);
        panel.setLayout(null);
        add(panel);

        JLabel pus = new JLabel("Pick Up Service");
        pus.setBounds(350,11,160,25);
        pus.setForeground(Color.WHITE);
        pus.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(pus);

        JLabel TOC = new JLabel("Type of Car");
        TOC.setBounds(32,97,89,19);
        TOC.setForeground(Color.WHITE);
        TOC.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(TOC);

        Choice c = new Choice();
        c.setBounds(123,94,150,25);
        panel.add(c);

        try{
            Connection C = new Connection();
            ResultSet resultSet = C.statement.executeQuery("select * from driver");
            while (resultSet.next()){
                c.add(resultSet.getString("carName"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        JTable table = new JTable();
        table.setBounds(10,243,800,250);
        table.setBackground(Color.decode("#ffa500"));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try{
            Connection C = new Connection();
            String q = "select * from driver";
            ResultSet resultSet = C.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel name = new JLabel("Name");
        name.setBounds(24,208,46,19);
        name.setForeground(Color.WHITE);
        panel.add(name);

        JLabel age = new JLabel("Age");
        age.setBounds(165,208,46,19);
        age.setForeground(Color.WHITE);
        panel.add(age);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(264,208,46,19);
        gender.setForeground(Color.WHITE);
        panel.add(gender);

        JLabel company = new JLabel("Company");
        company.setBounds(366,208,100,19);
        company.setForeground(Color.WHITE);
        panel.add(company);

        JLabel Carname = new JLabel("Car Name");
        Carname.setBounds(486,208,100,19);
        Carname.setForeground(Color.WHITE);
        panel.add(Carname);

        JLabel available = new JLabel("Available");
        available.setBounds(600,208,100,19);
        available.setForeground(Color.WHITE);
        panel.add(available);

        JLabel location = new JLabel("Location");
        location.setBounds(700,208,100,19);
        location.setForeground(Color.WHITE);
        panel.add(location);

        JButton display = new JButton("Display");
        display.setBounds(200,500,120,30);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.WHITE);
        panel.add(display);
        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "select * from driver where carName = '"+c.getSelectedItem()+"'";
                try{
                    Connection c = new Connection();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });



        JButton Back = new JButton("Back");
        Back.setBounds(420,500,120,30);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        panel.add(Back);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setLayout(null);
        setSize(800,600);
        setLocation(450,100);
        setVisible(true);
    }
    public static void main(String[] args) {
        new PickUp();
    }
}
