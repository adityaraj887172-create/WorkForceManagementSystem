package workforce.management.system;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MarkAttendance extends JFrame implements ActionListener {
    JTextField tfempid, tfname;
    JComboBox<String> statusBox;
    JButton submit, back;

    MarkAttendance(){

        setTitle("Mark Attendance");
        setSize(500,400);
        setLocation(400,200);
        setResizable(false);
        setLayout(null);

        JLabel l1 = new JLabel("Employee ID");
        l1.setBounds(50,50,100,30);
        add(l1);

        tfempid = new JTextField();
        tfempid.setBounds(180,50,200,30);
        add(tfempid);


        JLabel l2 = new JLabel("Name");
        l2.setBounds(50,100,100,30);
        add(l2);

        tfname = new JTextField();
        tfname.setBounds(180,100,200,30);
        add(tfname);


        JLabel l3 = new JLabel("Status");
        l3.setBounds(50,150,100,30);
        add(l3);

        String[] status = {"Present","Absent"};
        statusBox = new JComboBox<>(status);
        statusBox.setBounds(180,150,200,30);
        add(statusBox);


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
            String name = tfname.getText();
            String status =
                    (String) statusBox.getSelectedItem();

            String query =
                    "insert into attendance(empID,name,date,status) values('"
                            + empid + "','"
                            + name + "', now(), '"
                            + status + "')";

            try{
                conn c = new conn();
                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(
                        null,
                        "Attendance Marked Successfully"
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
        new MarkAttendance();
    }
}
