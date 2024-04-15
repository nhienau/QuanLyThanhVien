/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI.Dialog;

import BLL.ThanhVienBLL;
import GUI.Component.NumericDocumentFilter;
import antlr.Tool;
import hibernatemember.DAL.ThanhVien;
import hibernatemember.DAL.ThietBi;
import hibernatemember.DAL.ThietBiDAL;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.text.PlainDocument;
import org.jdesktop.swingx.JXTextField;

/**
 *
 * @author langu
 */
public class DatChoDialog extends javax.swing.JDialog {

    private List<ThietBi> list;
    private ThietBiDAL thietbiDAL;
    private List<String> thietBiCbb;
    private ThanhVienBLL tvBLL;
    private Date currentDate = new Date();

    /**
     * Creates new form DatChoDialog
     */
    public DatChoDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setSize(440, 397);
        this.setLocationRelativeTo(null);
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        Dimension dialogSize = this.getSize();
//        int posX = (int) (screenSize.getWidth() / 2 - dialogSize.getWidth() / 2);
//        int posY = (int) (screenSize.getHeight() / 2 - dialogSize.getHeight() / 2);
//        this.setLocation(posX, posY);
        this.setResizable(false);
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void init() {
        thietbiDAL = new ThietBiDAL();
        list = thietbiDAL.loadThietBi();
        thietBiCbb = new ArrayList<>();
        for (ThietBi tb : list) {
            thietBiCbb.add(tb.getMaTB() + "");
        }
        DefaultComboBoxModel<String> modelCbb = new DefaultComboBoxModel<>();
        for (String item : thietBiCbb) {
            modelCbb.addElement(item);
        }
        thietbiCbb.setModel(modelCbb);
        String temp = thietbiCbb.getSelectedItem().toString();
        ThietBi thietBi = thietbiDAL.getThietBi(Integer.parseInt(temp));
        tentbTxtField.setText(thietBi.getTenTB());
        dateChooser.setDate(currentDate);
        System.out.println(dateChooser.getDate());
        //
        //
        SpinnerDateModel model = new SpinnerDateModel();
        model.setValue(currentDate);
        timeSpinner.setModel(model);
        timeSpinner.setValue(currentDate);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(timeSpinner, "HH:mm:ss");
        timeSpinner.setEditor(editor);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tentbTxtField = new javax.swing.JTextField();
        tentvTxtField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        thietbiCbb = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        matvTxtField = new javax.swing.JTextField();
        dateChooser = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        datchoBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        timeSpinner = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ĐẶT CHỖ ");
        setResizable(false);

        jLabel1.setText("Mã sinh viên :");

        jLabel2.setText("Tên sinh viên :");

        tentvTxtField.setEditable(false);

        jLabel3.setText("Mã thiết bị :");

        thietbiCbb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        thietbiCbb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thietbiCbbActionPerformed(evt);
            }
        });

        jLabel4.setText("Tên thiết bị :");

        matvTxtField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                matvTxtFieldFocusLost(evt);
            }
        });
        matvTxtField.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                matvTxtFieldPropertyChange(evt);
            }
        });
        matvTxtField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                matvTxtFieldKeyTyped(evt);
            }
        });

        dateChooser.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateChooserPropertyChange(evt);
            }
        });

        jLabel6.setText("Thời gian mượn :");

        datchoBtn.setText("Đặt chỗ");
        datchoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datchoBtnActionPerformed(evt);
            }
        });

        jLabel7.setText("Giờ :");

        timeSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                timeSpinnerStateChanged(evt);
            }
        });
        timeSpinner.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                timeSpinnerFocusLost(evt);
            }
        });
        timeSpinner.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                timeSpinnerPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(thietbiCbb, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tentbTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(timeSpinner, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(dateChooser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tentvTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(matvTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(datchoBtn)))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(matvTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tentvTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(thietbiCbb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tentbTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(timeSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(datchoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void thietbiCbbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thietbiCbbActionPerformed
        JComboBox<String> combo = (JComboBox<String>) evt.getSource();
        String selected = (String) combo.getSelectedItem();
        String temp = thietbiCbb.getSelectedItem().toString();
        ThietBi thietBi = thietbiDAL.getThietBi(Integer.parseInt(temp));
        tentbTxtField.setText(thietBi.getTenTB());
    }//GEN-LAST:event_thietbiCbbActionPerformed

    private void datchoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datchoBtnActionPerformed
        Date selectedDate = (Date) dateChooser.getDate();
        Date selectedTime = (Date) timeSpinner.getValue();

        // Kiểm tra nếu ngày được chọn là ngày hiện tại
        if (selectedDate.compareTo(currentDate) == 0) {
            // Kiểm tra giờ được chọn
            if (selectedTime.before(currentDate)) {
                JOptionPane.showMessageDialog(this, "Selected time is in the past.", "Error", JOptionPane.ERROR_MESSAGE);
                timeSpinner.setValue(currentDate);
                return;
            } 
        }
        //-------------------------------------------------------------------code them lịch đặt chổ-------------------------------------------

    }//GEN-LAST:event_datchoBtnActionPerformed

    private void dateChooserPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dateChooserPropertyChange
        if (dateChooser.getDate() != null) {

            Date date = dateChooser.getDate();
            Date cur = new Date();
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            LocalDate localCur = cur.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (localDate.isBefore(localCur)) {
                JOptionPane.showMessageDialog(this, "Selected date time is in the past.", "Error", JOptionPane.ERROR_MESSAGE);
                dateChooser.setDate(new Date());
            } else if (localDate.isAfter(localCur)) {
                dateChooser.setDate(date);
            } else {
                dateChooser.setDate(date); // bằng nhau date hay cur đều đc 
            }
        }
    }//GEN-LAST:event_dateChooserPropertyChange

    private void timeSpinnerPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_timeSpinnerPropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_timeSpinnerPropertyChange

    private void matvTxtFieldPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_matvTxtFieldPropertyChange

    }//GEN-LAST:event_matvTxtFieldPropertyChange
    private boolean isValidAction(KeyEvent e) {
        return e.getKeyCode() == KeyEvent.VK_BACK_SPACE
                || e.getKeyCode() == KeyEvent.VK_TAB
                || e.getKeyCode() == KeyEvent.VK_ENTER;
    }
    private void matvTxtFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_matvTxtFieldKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || isValidAction(evt))) {
            evt.consume(); // Không cho phép kí tự được nhập vào
        }
    }//GEN-LAST:event_matvTxtFieldKeyTyped

    private void matvTxtFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_matvTxtFieldFocusLost
        try {
            if (matvTxtField.getText() != null) {
                int matv = Integer.parseInt(matvTxtField.getText());
                tvBLL = new ThanhVienBLL();
                if (tvBLL.checkExist(matv) == true) {
                    ThanhVien tv = tvBLL.getThanhVien(matv);
                    tentvTxtField.setText(tv.getHoTen());
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Mã thành viên không tồn tại hoặc không hợp lệ !");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Mã thành viên không tồn tại hoặc không hợp lệ !");
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_matvTxtFieldFocusLost

    private void timeSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_timeSpinnerStateChanged
        if (timeSpinner.getValue() != null && timeSpinner.getValue() instanceof Date) {
//            System.out.println("Spinner1: " + (Date) timeSpinner.getValue());
//            Date selectedDate = (Date) timeSpinner.getValue();
//            System.out.println("Spinner2: " + (Date) timeSpinner.getValue());

//            Calendar calendarSelected = Calendar.getInstance();
//            System.out.println(dateChooser.getDate());
//            Calendar calendarCur = Calendar.getInstance();
//            calendarSelected.setTime(selectedDate);
//            System.out.println("Selected : " + calendarSelected.getTime());
//            System.out.println("CUR : " + calendarCur.getTime());
//            if (calendarSelected.before(calendarCur)) {
//                System.out.println("before");
//            }
        }
    }//GEN-LAST:event_timeSpinnerStateChanged

    private void timeSpinnerFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_timeSpinnerFocusLost
        System.out.println("abcd");
        if (timeSpinner.getValue() != null && timeSpinner.getValue() instanceof Date) {
//            System.out.println("Spinner1: " + (Date) timeSpinner.getValue());
//            Date selectedDate = (Date) timeSpinner.getValue();
//            System.out.println("Spinner2: " + (Date) timeSpinner.getValue());

//            Calendar calendarSelected = Calendar.getInstance();
//            System.out.println(dateChooser.getDate());
//            Calendar calendarCur = Calendar.getInstance();
//            calendarSelected.setTime(selectedDate);
//            System.out.println("Selected : " + calendarSelected.getTime());
//            System.out.println("CUR : " + calendarCur.getTime());
//            if (calendarSelected.before(calendarCur)) {
//                System.out.println("before");
//            }
            Date selectedDate = (Date) dateChooser.getDate();
            Date selectedTime = (Date) timeSpinner.getValue();

            // Lấy ngày và giờ hiện tại
            Date currentDate = new Date();

            // Kiểm tra nếu ngày được chọn là ngày hiện tại
            if (selectedDate.compareTo(currentDate) == 0) {
                // Kiểm tra giờ được chọn
                if (selectedTime.before(currentDate)) {
                    JOptionPane.showMessageDialog(this, "Selected time is in the past.", "Error", JOptionPane.ERROR_MESSAGE);
                    timeSpinner.setValue(currentDate);
                } else {
                    System.out.println("sia roi");
                }
            }
        } else {
            System.out.println("sai tiep");
        }
    }//GEN-LAST:event_timeSpinnerFocusLost

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DatChoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatChoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatChoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatChoDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DatChoDialog dialog = new DatChoDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton datchoBtn;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField matvTxtField;
    private javax.swing.JTextField tentbTxtField;
    private javax.swing.JTextField tentvTxtField;
    private javax.swing.JComboBox<String> thietbiCbb;
    private javax.swing.JSpinner timeSpinner;
    // End of variables declaration//GEN-END:variables
}
