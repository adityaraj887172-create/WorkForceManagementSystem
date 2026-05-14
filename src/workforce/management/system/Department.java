package workforce.management.system;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Department extends JFrame implements ActionListener {
    JTextField tfempid;
    JComboBox<String> deptBox;
    JButton submit, back;

    Department(){

        setTitle("Department");
        setSize(500,400);
        setLocation(400,200);
        setResizable(false);
        setLayout(null);

        JLabel l1 = new JLabel("Employee ID");
        l1.setBounds(50,70,120,30);
        add(l1);

        tfempid = new JTextField();
        tfempid.setBounds(200,70,200,30);
        add(tfempid);


        JLabel l2 = new JLabel("Department");
        l2.setBounds(50,140,120,30);
        add(l2);

        String[] departments = {
                "HR",
                "IT",
                "Finance",
                "Sales"
        };

        deptBox = new JComboBox<>(departments);
        deptBox.setBounds(200,140,200,30);
        add(deptBox);


        submit = new JButton("Submit");
        submit.setBounds(80,250,120,40);
        submit.addActionListener(this);
        add(submit);

        back = new JButton("Back");
        back.setBounds(250,250,120,40);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){

            String empid = tfempid.getText();
            String dept =
                    (String) deptBox.getSelectedItem();

            int deptId = 0;

            if(dept.equals("HR")) deptId = 1;
            if(dept.equals("IT")) deptId = 2;
            if(dept.equals("Finance")) deptId = 3;
            if(dept.equals("Sales")) deptId = 4;

            String query =
                    "insert into employee_department(empID,deptId) values('"
                            + empid + "',"
                            + deptId + ")";

            try{
                conn c = new conn();
                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(
                        null,
                        "Department Assigned Successfully"
                );

                setVisible(false);
                new Main_class();

            }catch(Exception E){
                E.printStackTrace();
            }
        }

        else{
            setVisible(false);
            new Main_class();
        }
    }

    public static void main(String[] args) {
        new Department();
    }
}
