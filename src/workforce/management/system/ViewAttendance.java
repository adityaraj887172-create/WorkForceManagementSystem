package workforce.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.sql.ResultSet;

public class ViewAttendance extends JFrame {
    JTable table;
    JButton back;
    ViewAttendance(){

        setTitle("View Attendance");
        setSize(800,500);
        setLocation(300,150);
        setResizable(false);
        setLayout(null);

        table = new JTable();

        try{
            conn c = new conn();

            ResultSet rs =
                    c.statement.executeQuery("select * from attendance");

            table.setModel(
                    DbUtils.resultSetToTableModel(rs)
            );
        }catch (Exception e){
            e.printStackTrace();
        }
        JScrollPane jsp =
                new JScrollPane(table);
        jsp.setBounds(0,0,780,400);
        add(jsp);

        back = new JButton("Back");
        back.setBounds(330,420,120,30);
        back.addActionListener(e -> {
            setVisible(false);
            new Main_class();
        });
        add(back);

        setVisible(true);

    }

    public static void main(String[] args) {
        new ViewAttendance();
    }
}
