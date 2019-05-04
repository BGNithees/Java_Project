package s_FORM;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
 
public class SurveyForm implements ActionListener {
    JFrame frame;
    String bool;
    String[] brands={"Samsung", "Apple", "Redmi", "Oneplus", "Google pixel", "Lenovo", "Oppo", "Vivo"};
    String specs;
    JLabel lblName = new JLabel("Name");
    JTextField textField = new JTextField();
    JLabel lblEmailId = new JLabel("E-mail ID");
    JTextField textField_1 = new JTextField();
    JLabel lblNewLabel = new JLabel("Select Your SmartPhone Brand");
    JComboBox comboBox = new JComboBox(brands);
    JLabel lblWhichIsBetter = new JLabel("Which is better in you Smartphone ");
    JCheckBox chckbxPerfomance = new JCheckBox("Perfomance");
    JCheckBox chckbxNewCheckBox = new JCheckBox("Design");
    JCheckBox chckbxBattery = new JCheckBox("Battery");
    JCheckBox chckbxCamera = new JCheckBox("Camera");
    JLabel lblDoYouRecommend = new JLabel("Do You Recommend Your smartphone to others?");
    JRadioButton rdbtnYes = new JRadioButton("Yes");
    JRadioButton rdbtnNo = new JRadioButton("No");
    JLabel lblSmartphoneSurveyForm = new JLabel("Smartphone Survey Form");
    JButton btnSubmit = new JButton("Submit");
 
 
    SurveyForm(){
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }
    
    public void createWindow()
    {
    	frame = new JFrame();
        frame.setTitle("Survey Form");
        frame.setBounds(800, 800, 750, 400);
        frame.getContentPane().setBackground(Color.blue);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
    public void setLocationAndSize()
    {
        lblName.setBounds(78, 56, 68, 30);
        textField.setBounds(197, 60, 116, 22);
        textField.setColumns(10);
        lblEmailId.setBounds(78, 102, 56, 16);
        textField_1.setBounds(197, 99, 116, 22);
        textField_1.setColumns(10);
        lblNewLabel.setBounds(78, 146, 184, 16);
        comboBox.setBounds(282, 143, 86, 22);
        lblWhichIsBetter.setBounds(78, 186, 202, 16);
        chckbxPerfomance.setBounds(292, 182, 113, 25);
        chckbxNewCheckBox.setBounds(401, 182, 68, 25);
        chckbxBattery.setBounds(476, 182, 68, 25);
        chckbxCamera.setBounds(557, 182, 79, 25);
        lblDoYouRecommend.setBounds(78, 224, 278, 16);
        rdbtnYes.setBounds(374, 220, 56, 25);
        rdbtnNo.setBounds(434, 220, 49, 25);
        lblSmartphoneSurveyForm.setBounds(197, 13, 345, 28);
        lblSmartphoneSurveyForm.setFont(new Font("Yu Gothic Light", Font.PLAIN, 32));
        btnSubmit.setBounds(318, 287, 97, 25);
    }
    public void addComponentsToFrame()
    {
    	frame.add(lblName);
    	frame.add(textField);
    	frame.add(lblEmailId);
    	frame.add(textField_1);
    	frame.add(lblNewLabel);
    	frame.add(comboBox);
    	frame.add(lblWhichIsBetter);
    	frame.add(chckbxPerfomance);
    	frame.add(chckbxNewCheckBox);
    	frame.add(chckbxBattery);
    	frame.add(chckbxCamera);
    	frame.add(lblDoYouRecommend);
    	frame.add(rdbtnYes);
    	frame.add(rdbtnNo);
    	frame.add(lblSmartphoneSurveyForm);
    	frame.add(btnSubmit);
    }
    public void actionEvent()
    {
        btnSubmit.addActionListener(this);
    }
 
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnSubmit)
        {
    		if(chckbxPerfomance.isSelected()==true){
    			specs = "Perfomance";
    		}
    		else if(chckbxNewCheckBox.isSelected()==true){
    			specs = "Design";
    		}
    		else if(chckbxBattery.isSelected()==true){
    			specs = "Battery";
    		}
    		else if(chckbxCamera.isSelected()==true){
    			specs = "Camera";
    		}
    		else if(chckbxPerfomance.isSelected()==true&&chckbxNewCheckBox.isSelected()==true&&chckbxBattery.isSelected()==true&&chckbxCamera.isSelected()==true){
    			specs = "Perfomance"+","+"Design"+","+"Battery"+","+"Camera"; 
    		}
    		if(rdbtnYes.isSelected()==true){
    			bool="Yes";
    		}
    		else{
    			bool="No";
    		}
    		
            
        	
            try {
            	Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/form","root","");
                PreparedStatement Pstatement=connection.prepareStatement("insert into Survey_form values(?,?,?,?,?)");
                Pstatement.setString(1,textField.getText().toString());
                Pstatement.setString(2,textField_1.getText().toString());
                Pstatement.setString(3,comboBox.getSelectedItem().toString());
                Pstatement.setString(4,specs);
                Pstatement.setString(5,bool);
                Pstatement.executeUpdate();
                JOptionPane.showMessageDialog(null,"Survey stored Successfully");
                connection.close();
            } 
            catch (SQLException e1) {
            	JOptionPane.showMessageDialog(null,"Survey not stored Successfully Check the errors given below\n");
            	e1.printStackTrace();
            }


        }
    }

}