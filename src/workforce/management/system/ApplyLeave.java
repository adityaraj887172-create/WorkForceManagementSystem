package workforce.management.system;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplyLeave extends JFrame implements ActionListener {
    JTextField tfempid, tffrom, tfto, tfreason;
    JComboBox<String> leaveBox;
    JButton submit, back;

    ApplyLeave(){

        setTitle("Apply Leave");
        setSize(500,500);
        setLocation(400,200);
        setResizable(false);
        setLayout(null);

        JLabel l1 = new JLabel("Employee ID");
        l1.setBounds(50,50,120,30);
        add(l1);

        tfempid = new JTextField();
        tfempid.setBounds(200,50,200,30);
        add(tfempid);


        JLabel l2 = new JLabel("Leave Type");
        l2.setBounds(50,100,120,30);
        add(l2);

        String[] types = {
                "Sick Leave",
                "Casual Leave",
                "Paid Leave"
        };

        leaveBox = new JComboBox<>(types);
        leaveBox.setBounds(200,100,200,30);
        add(leaveBox);


        JLabel l3 = new JLabel("From Date");
        l3.setBounds(50,150,120,30);
        add(l3);

        tffrom = new JTextField();
        tffrom.setBounds(200,150,200,30);
        add(tffrom);


        JLabel l4 = new JLabel("To Date");
        l4.setBounds(50,200,120,30);
        add(l4);

        tfto = new JTextField();
        tfto.setBounds(200,200,200,30);
        add(tfto);


        JLabel l5 = new JLabel("Reason");
        l5.setBounds(50,250,120,30);
        add(l5);

        tfreason = new JTextField();
        tfreason.setBounds(200,250,200,30);
        add(tfreason);


        submit = new JButton("Submit");
        submit.setBounds(80,350,120,40);
        submit.addActionListener(this);
        add(submit);


        back = new JButton("Back");
        back.setBounds(250,350,120,40);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){

            String empid = tfempid.getText();
            String leaveType =
                    (String) leaveBox.getSelectedItem();
            String from = tffrom.getText();
            String to = tfto.getText();
            String reason = tfreason.getText();

            String query =
                    "insert into leaves(empID,leaveType,fromDate,toDate,reason,status) values('"
                            + empid + "','"
                            + leaveType + "','"
                            + from + "','"
                            + to + "','"
                            + reason + "','Pending')";

            try{
                conn c = new conn();
                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(
                        null,
                        "Leave Applied Successfully"
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
        new ApplyLeave();
    }
}
