/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI.Panel;

//import BLL.ThietBiBLL;
import BLL.ThietBiBLL;
import GUI.Component.IntegratedSearch;
import GUI.Component.MainFunction;
import GUI.Component.PanelBorderRadius;
import GUI.Main;
import hibernatemember.DAL.ThietBi;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class ThietBiPanel extends JPanel implements ActionListener{
    public JFrame owner = (JFrame) SwingUtilities.getWindowAncestor(this);
    private ThietBiBLL thietBiBLL = new ThietBiBLL();
    PanelBorderRadius main, functionBar;
    JPanel pnlBorder1, pnlBorder2, pnlBorder3, pnlBorder4, contentCenter;
    JTable tableThietBi;
    JScrollPane scrollTableThietBi;
    MainFunction mainFunction;
    public IntegratedSearch search;
    Main m;
//    ArrayList<DTO.NhanVienDTO> listnv = nvBus.getAll();

    Color BackgroundColor = new Color(240, 247, 250);
    private DefaultTableModel tblModel;

    private void initComponent() {
        this.setBackground(BackgroundColor);
        this.setLayout(new BorderLayout(0, 0));
        this.setOpaque(true);

        // pnlBorder1, pnlBorder2, pnlBorder3, pnlBorder4 chỉ để thêm contentCenter ở giữa mà contentCenter không bị dính sát vào các thành phần khác
        pnlBorder1 = new JPanel();
        pnlBorder1.setPreferredSize(new Dimension(0, 10));
        pnlBorder1.setBackground(BackgroundColor);
        this.add(pnlBorder1, BorderLayout.NORTH);

        pnlBorder2 = new JPanel();
        pnlBorder2.setPreferredSize(new Dimension(0, 10));
        pnlBorder2.setBackground(BackgroundColor);
        this.add(pnlBorder2, BorderLayout.SOUTH);

        pnlBorder3 = new JPanel();
        pnlBorder3.setPreferredSize(new Dimension(10, 0));
        pnlBorder3.setBackground(BackgroundColor);
        this.add(pnlBorder3, BorderLayout.EAST);

        pnlBorder4 = new JPanel();
        pnlBorder4.setPreferredSize(new Dimension(10, 0));
        pnlBorder4.setBackground(BackgroundColor);
        this.add(pnlBorder4, BorderLayout.WEST);

        contentCenter = new JPanel();
        contentCenter.setPreferredSize(new Dimension(1100, 600));
        contentCenter.setBackground(BackgroundColor);
        contentCenter.setLayout(new BorderLayout(10, 10));
        this.add(contentCenter, BorderLayout.CENTER);

        // functionBar là thanh bên trên chứa các nút chức năng như thêm xóa sửa, và tìm kiếm
        functionBar = new PanelBorderRadius();
        functionBar.setPreferredSize(new Dimension(0, 100));
        functionBar.setLayout(new GridLayout(1, 2, 50, 0));
        functionBar.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentCenter.add(functionBar, BorderLayout.NORTH);

        String[] action = {"create", "update", "delete", "detail", "import"};
        mainFunction = new MainFunction(action);
        for (String ac : action) {
            mainFunction.btn.get(ac).addActionListener(this);
        }
        functionBar.add(mainFunction);
        search = new IntegratedSearch(new String[]{"Tất cả", "Họ tên", "Email"});
        functionBar.add(search);
//        search.btnReset.addActionListener(nvBus);
//        search.cbxChoose.addActionListener(nvBus);
//        search.txtSearchForm.getDocument().addDocumentListener(new NhanVienBUS(search.txtSearchForm, this));

        // main là phần ở dưới để thống kê bảng biểu
        main = new PanelBorderRadius();
        BoxLayout boxly = new BoxLayout(main, BoxLayout.Y_AXIS);
        main.setLayout(boxly);
//        main.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentCenter.add(main, BorderLayout.CENTER);

        tableThietBi = new JTable();
        scrollTableThietBi = new JScrollPane();
        tableThietBi = new JTable();
        tblModel = new DefaultTableModel();
        String[] header = new String[]{"Mã TB", "Tên TB", "Mô tả TB"};

        tblModel.setColumnIdentifiers(header);
        tableThietBi.setModel(tblModel);
        tableThietBi.setFocusable(false);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        tableThietBi.setDefaultRenderer(Object.class, centerRenderer);
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tableThietBi.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tableThietBi.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tableThietBi.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        scrollTableThietBi.setViewportView(tableThietBi);
        main.add(scrollTableThietBi);
    }

    public ThietBiPanel(Main m) {
        this.m = m;
        initComponent();
        tableThietBi.setDefaultEditor(Object.class, null);
        loadDataTable();
    }

    public int getRow() {
        return tableThietBi.getSelectedRow();
    }

//    public DTO.NhanVienDTO getNhanVien() {
//        return listnv.get(tableNhanVien.getSelectedRow());
//    }
    public void loadDataTable() {
        ArrayList<ThietBi> list = new ArrayList<>(thietBiBLL.loadThietBi());
        tblModel.setRowCount(0);
        for (ThietBi thietbi : list) {
            tblModel.addRow(new Object[]{
                thietbi.getMaTB(), thietbi.getTenTB(), thietbi.getMoTaTB()
            });
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
