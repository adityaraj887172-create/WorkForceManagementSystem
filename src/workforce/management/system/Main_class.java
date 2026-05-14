package workforce.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_class extends JFrame {

    Main_class(){

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/images3.png"));
        Image i2 = i1.getImage().getScaledInstance(1100,560, Image.SCALE_DEFAULT);

        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i1);
        img.setBounds(0,0,1100,560);
        add(img);

        JLabel heading = new JLabel("WorkForce Management System");
        heading.setBounds(150,460,800,60);
        heading.setFont(new Font("Raleway",Font.BOLD,50));
        img.add(heading);

        JButton add = new JButton("Add Employee");
        add.setBounds(480,190,150,35);
        add.setForeground(Color.white);
        add.setBackground(Color.black);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new AddEmployee();
                setVisible(false);

            }
        });
        img.add(add);

        JButton view = new JButton("View Employee");
        view.setBounds(480,260,150,40);
        view.setForeground(Color.white);
        view.setBackground(Color.black);
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new View_Employee();
                setVisible(false);

            }
        });
        img.add(view);

        JButton rem = new JButton("Remove Employee");
        rem.setBounds(480,340,150,40);
        rem.setForeground(Color.white);
        rem.setBackground(Color.black);
        rem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RemoveEmployee();
            }
        });
        img.add(rem);

        JButton attendance =
                new JButton("Attendance");
        attendance.setBounds(150,180,130,40);
        attendance.addActionListener(e -> {
            new MarkAttendance();
            setVisible(false);
        });
        img.add(attendance);


        JButton leave =
                new JButton("Leave");
        leave.setBounds(150,250,130,35);
        leave.addActionListener(e -> {
            new ApplyLeave();
            setVisible(false);
        });
        img.add(leave);

        JButton payroll =
                new JButton("Payroll");
        payroll.setBounds(150,320,130,35);
        payroll.addActionListener(e -> {
            new Payroll();
            setVisible(false);
        });
        img.add(payroll);

        JButton department =
                new JButton("Department");
        department.setBounds(150,390,130,35);
        department.addActionListener(e -> {
            new Department();
            setVisible(false);
        });
        img.add(department);

        JButton viewAttendance =
                new JButton("View Attendance");

        viewAttendance.setBounds(900,180,130,40);

        viewAttendance.addActionListener(e -> {
            new ViewAttendance();
            setVisible(false);
        });

        img.add(viewAttendance);

        JButton viewLeave =
                new JButton("View Leave");

        viewLeave.setBounds(900,250,130,40);

        viewLeave.addActionListener(e -> {
            new ViewLeave();
            setVisible(false);
        });

        img.add(viewLeave);

        JButton viewPayroll =
                new JButton("View Payroll");

        viewPayroll.setBounds(900,320,130,45);

        viewPayroll.addActionListener(e -> {
            new ViewPayroll();
            setVisible(false);
        });

        img.add(viewPayroll);

        JButton viewDepartment =
                new JButton("View Department");
        viewDepartment.setBounds(900,390,130,40);
        viewDepartment.addActionListener(e -> {
            new ViewDepartment();
            setVisible(false);
        });
        img.add(viewDepartment);



        setSize(1120,630);
        setLocation(250,100);
        setResizable(false);
        setLayout(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Main_class();

    }

}
