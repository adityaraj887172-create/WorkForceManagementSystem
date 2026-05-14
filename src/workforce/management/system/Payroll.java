package workforce.management.system;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Payroll extends JFrame implements ActionListener {
    JTextField tfempid, tfbasic, tfbonus, tfdeduction;
    JButton submit, back;

    Payroll(){

        setTitle("Payroll");
        setSize(500,450);
        setLocation(400,200);
        setResizable(false);
        setLayout(null);

        JLabel l1 = new JLabel("Employee ID");
        l1.setBounds(50,50,120,30);
        add(l1);

        tfempid = new JTextField();
        tfempid.setBounds(200,50,200,30);
        add(tfempid);


        JLabel l2 = new JLabel("Basic Salary");
        l2.setBounds(50,100,120,30);
        add(l2);

        tfbasic = new JTextField();
        tfbasic.setBounds(200,100,200,30);
        add(tfbasic);


        JLabel l3 = new JLabel("Bonus");
        l3.setBounds(50,150,120,30);
        add(l3);

        tfbonus = new JTextField();
        tfbonus.setBounds(200,150,200,30);
        add(tfbonus);


        JLabel l4 = new JLabel("Deduction");
        l4.setBounds(50,200,120,30);
        add(l4);

        tfdeduction = new JTextField();
        tfdeduction.setBounds(200,200,200,30);
        add(tfdeduction);


        submit = new JButton("Submit");
        submit.setBounds(80,300,120,40);
        submit.addActionListener(this);
        add(submit);


        back = new JButton("Back");
        back.setBounds(250,300,120,40);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){

            String empid = tfempid.getText();

            int basic =
                    Integer.parseInt(tfbasic.getText());

            int bonus =
                    Integer.parseInt(tfbonus.getText());

            int deduction =
                    Integer.parseInt(tfdeduction.getText());

            int total =
                    basic + bonus - deduction;

            String query =
                    "insert into payroll(empID,basicSalary,bonus,deduction,totalSalary) values('"
                            + empid + "','"
                            + basic + "','"
                            + bonus + "','"
                            + deduction + "','"
                            + total + "')";

            try{
                conn c = new conn();
                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(
                        null,
                        "Payroll Added Successfully\nTotal Salary: " + total
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
        new Payroll();
    }
}
