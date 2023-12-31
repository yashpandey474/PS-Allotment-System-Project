/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package project;

import javax.swing.*;
import java.util.ArrayList;

/**
 *
 * @author PRIYANK
 */
@SuppressWarnings("serial")
public class EditStations extends JFrame {
    static String id;
    Station sta;
    /**
     * Creates new form EditStations
     */
    public EditStations(String val) {
        id = val;
        sta = (Station) allotmentData.getStation(id);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        doneButton = new JButton();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        stationIdLabel = new JLabel();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        stationCompany = new JTextField();
        stationLocation = new JTextField();
        stationStipend = new JTextField();
        stationBranches = new JTextField();
        stationCourses = new JTextField();
        stationMaxStudents = new JTextField();
        idLabel = new JLabel();
        String coursesStr = "";
        for(String s: sta.getSubjects()){
            coursesStr += s + " ";
        }
        String branchesStr = "";
        for(String s: sta.getBranches()){
            branchesStr += s + " ";
        }
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        stationIdLabel.setVisible(false);
        stationCompany.setText(sta.getCompany());
        stationLocation.setText(sta.getLocation());
        stationStipend.setText(""+ sta.getStipend());
        stationCourses.setText(coursesStr);
        stationBranches.setText(branchesStr);
        stationMaxStudents.setText(""+sta.getMaxStudents());
        jLabel3.setText("Company:");

        jLabel4.setText("Location:");

        jLabel5.setText("ID:");

        jLabel6.setText("Stipend:");

        jLabel7.setText("Branches:");

        jLabel8.setText("Courses: ");
        
        
        if(allotmentData.getRoundNo()>1) {
        	jLabel8.setVisible(false);
        	stationCourses.setVisible(false);
        	jLabel7.setVisible(false);
        	stationBranches.setVisible(false);
        	jLabel9.setVisible(false);
        	stationMaxStudents.setVisible(false);
        }
        doneButton.setText("Done");
        doneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneButtonActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 204));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Practice School Allotment Portal");

        jLabel2.setText("Kindly change the details as required:");

        jLabel9.setText("No. of Students:");

        stationStipend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stationStipendActionPerformed(evt);
            }
        });

        stationBranches.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stationBranchesActionPerformed(evt);
            }
        });

        stationMaxStudents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stationMaxStudentsActionPerformed(evt);
            }
        });

        idLabel.setText(id);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(294, 294, 294)
                                                .addComponent(stationIdLabel, GroupLayout.PREFERRED_SIZE, 438, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(81, 81, 81)
                                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel5, GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel3, GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel4, GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel6, GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel7, GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel8, GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel9, GroupLayout.Alignment.TRAILING))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(doneButton)
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(stationLocation, GroupLayout.Alignment.TRAILING)
                                                                .addComponent(stationStipend, GroupLayout.Alignment.TRAILING)
                                                                .addComponent(stationBranches, GroupLayout.Alignment.TRAILING)
                                                                .addComponent(stationCourses, GroupLayout.Alignment.TRAILING)
                                                                .addComponent(stationMaxStudents, GroupLayout.Alignment.TRAILING)
                                                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                                .addComponent(idLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(stationCompany, GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE))
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(jLabel10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                                .addGap(96, 96, 96))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 565, GroupLayout.PREFERRED_SIZE)
                                                .addGap(84, 84, 84))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stationIdLabel)
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel10)
                                        .addComponent(idLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(stationCompany, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(stationLocation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(stationStipend, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(stationBranches, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(stationCourses, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(stationMaxStudents, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(doneButton)
                                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        String location = null;
        String company = null;
        int stipend = 0;
        int maxStudents = 0;
        String courses = null;
        String branches = null;
        ArrayList<String> branchesAL = new ArrayList<>();
        ArrayList<String> subjects = new ArrayList<>();
        try {

            company = stationCompany.getText().trim();
            
            stipend = Integer.parseInt(stationStipend.getText().trim());
            
            location = stationLocation.getText().trim();
            
            if(allotmentData.getRoundNo()==1) {
            	courses = stationCourses.getText().trim();
                branches = stationBranches.getText().trim();
                maxStudents = Integer.parseInt(stationMaxStudents.getText().trim());
                
                String[] subArr = courses.split(" ");
                for (int i = 0; i < subArr.length; i++) {
                    subjects.add(subArr[i]);
                }
                
                String[] prefArr = branches.split(" ");
                for (int i = 0; i < prefArr.length; i++) {
                    branchesAL.add(prefArr[i]);
                }
            }
            if(allotmentData.getRoundNo()>1) {
            	branchesAL = sta.getBranches();
            	subjects = sta.getSubjects();
            	maxStudents = sta.getMaxStudents();
            }
            if(location == null || company == null || stipend == 0 || maxStudents ==0   || location.isEmpty() ) {
                throw new Exception();
            }
           
            
            for(Station sta1: allotmentData.allStations){

                if(sta1.getId().equals(id)){
                    sta1.setLocation(location);
                    sta1.setBranches(subjects);
                    sta1.setCompany(company);
                    sta1.setMaxStudents(maxStudents);
                    sta1.setStipend(stipend);
                    sta1.setBranches(branchesAL);
                    sta1.setSubjects(subjects);
                }
            }

            //allotmentData.allStations.remove(sta);

            JOptionPane.showMessageDialog(null, "Station details changed successfully.");

            stationCompany.setText("");
            stationMaxStudents.setText("");
            stationStipend.setText("");
            stationCourses.setText("");
            stationBranches.setText("");
            stationLocation.setText("");
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please enter all fields and with correct data types!");
        }
    }

    private void stationStipendActionPerformed(java.awt.event.ActionEvent evt) {

        // TODO add your handling code here:
    }

    private void stationBranchesActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void stationMaxStudentsActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditStations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditStations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditStations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditStations.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditStations(id).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private JButton doneButton;
    private JLabel idLabel;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JTextField stationBranches;
    private JTextField stationCompany;
    private JTextField stationCourses;
    private JTextField stationLocation;
    private JTextField stationMaxStudents;
    private JTextField stationStipend;
    private JLabel stationIdLabel;
    // End of variables declaration                   
}
