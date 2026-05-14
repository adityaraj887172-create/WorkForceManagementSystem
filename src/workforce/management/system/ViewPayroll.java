package workforce.management.system;

import net.proteanit.sql.DbUtils;


import javax.swing.*;
import java.sql.ResultSet;

public class ViewPayroll extends JFrame {
    JTable table;
    JButton back;

    ViewPayroll(){

        setTitle("View Payroll");
        setSize(900,500);
        setLocation(300,150);
        setResizable(false);
        setLayout(null);

        table = new JTable();

        try{
            conn c = new conn();

            ResultSet rs =
                    c.statement.executeQuery("select * from payroll");

            table.setModel(
                    DbUtils.resultSetToTableModel(rs)
            );

        }catch(Exception e){
            e.printStackTrace();
        }

        JScrollPane jsp =
                new JScrollPane(table);
        jsp.setBounds(0,0,880,400);
        add(jsp);

        back = new JButton("Back");
        back.setBounds(380,420,120,30);
        back.addActionListener(e -> {
            setVisible(false);
            new Main_class();
        });
        add(back);

        setVisible(true);
    }

    public static void main(String[] args) {
        new ViewPayroll();
    }
}
