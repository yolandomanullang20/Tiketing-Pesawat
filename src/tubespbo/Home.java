/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author yolan
 */
public class Home extends javax.swing.JFrame {
    
   
    //user awal
    
    //insert
//    public boolean insertUser(Kostumer kostumer) throws SQLException{
//        String k  ueri = "INSERT INTO kostumer(id_kostumer,nama_kostumer,nik_kostumer,umur_kostumer,no_kostumer,alamat_kostumer)";
//        PreparedStatment ps = 
//    }
    

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        // kode untuk lock maaximized
        setExtendedState(JFrame.MAXIMIZED_HORIZ);
        setVisible(true);
        setResizable(false);
        // akhor kode untuk maximized
        //kode untuk set muncul di tengah
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2-getWidth()/2, size.height/2 - getHeight()/2);
        //akhir kode untuk set muncul di tengah
            //tabel user
           load_table();
           // tabel rute
           load_table_rute();
           
           // tabel admin
           load_table_admin();
           
           //tabel_transaksi
           load_table_transaksi();
           
           
           //panggil sql di kombo box from kostumer to booking
           Fillcombo();
           
           //
           FillcomboMaskapai();
           
           //
           
           

           
                
    }
    private void Fillcombo(){
        try {
            ResultSet rs =null;
            String sql = "SELECT * from kostumer";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                String nama = rs.getString("nama_kostumer");
                bookingUsername.addItem(nama);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void FillcomboMaskapai(){
        try {
            ResultSet rs =null;
            String sql = "SELECT * from rute";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                String nama = rs.getString("maskapai");
                maskapaiBooking.addItem(nama);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
private void load_table(){
        // membuat tampilan model tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nama");
        model.addColumn("NIM");
        model.addColumn("Umur");
        model.addColumn("noHO");
        model.addColumn("Alamat");        
        model.addColumn("Jenis Kelamin");

        
        //menampilkan data database kedalam tabel
        try {
            int no=1;
            String sql = "select * from kostumer";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7)});
            }
            tabelKostumer.setModel(model);
        } catch (Exception e) {
        }
}
private void load_table_rute(){
        // membuat tampilan model tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID RUTE");
        model.addColumn("Maskapai");
        model.addColumn("Asal");
        model.addColumn("Tujuan");
        model.addColumn("Kursi");
        model.addColumn("Harga");
        
        //menampilkan data database kedalam tabel
        try {
            int no=1;
            String sql = "select * from rute";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6)});
            }
            TabelRute.setModel(model);
        } catch (Exception e) {
        }
}private void load_table_admin(){
        // membuat tampilan model tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nama");
        model.addColumn("Username");
        model.addColumn("Password");
        
        //menampilkan data database kedalam tabel
        try {
            int no=1;
            String sql = "select * from login";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{res.getString(2),res.getString(3),res.getString(4)});
            }
            adminTabel.setModel(model);
        } catch (Exception e) {
        }
}


private void load_table_transaksi(){
        // membuat tampilan model tabel
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("NAMA");
        model.addColumn("NIK");
        model.addColumn("UMUR");
        model.addColumn("HP");
        model.addColumn("ALAMAT");
        model.addColumn("MASKAPAI");
        model.addColumn("ASAL");
        model.addColumn("TUJUAN");
        model.addColumn("HARGA");
        model.addColumn("TGL");
        
        //menampilkan data database kedalam tabel
        try {
            int no=1;
            String sql = "select * from transaksi";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                model.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8),res.getString(9),res.getString(10),res.getString(11)});
            }
            tabelTransaksi.setModel(model);
        } catch (Exception e) {
        }
}
private void kosongKostumer(){
        field_idUser.setText(null);
        field_namaUser.setText(null);
        field_nikUser.setText(null);
        field_noUser.setText(null);        
        field_alamatUser.setText(null);
        field_umurUser.setText(null);
        fiel_gender.setSelectedItem(this);
    }
private void kosongRute(){
        ruteField_id.setText(null);
        ruteCombo_maskapai.setSelectedItem(this);
        ruteField_Asal.setText(null);
        ruteField_Tujuan.setText(null);        
        ruteField_kursi.setText(null);
        ruteField_harga.setText(null);
}
private void kosongkanAdmin(){
        adminNama.setText(null);
        adminUsername.setText(null);
        adminPassword.setText(null);        
}
  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel4 = new javax.swing.JLabel();
        bodyPanel = new javax.swing.JPanel();
        panelKiri = new javax.swing.JPanel();
        adminMenu = new javax.swing.JButton();
        homeMenu = new javax.swing.JButton();
        bookingMenu = new javax.swing.JButton();
        kostumerMenu = new javax.swing.JButton();
        transaksiMenu = new javax.swing.JButton();
        about = new javax.swing.JButton();
        iconPlane = new javax.swing.JLabel();
        judulText = new javax.swing.JLabel();
        logout = new javax.swing.JButton();
        ruteMenu = new javax.swing.JButton();
        panelKanan = new javax.swing.JPanel();
        homePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        bookingPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        bookingUsername = new javax.swing.JComboBox<>();
        idBooking = new javax.swing.JTextField();
        bookingNIK = new javax.swing.JTextField();
        bookingUmur = new javax.swing.JTextField();
        bookingHP = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        bookingAlamat = new javax.swing.JTextArea();
        hargaBooking = new javax.swing.JTextField();
        tanggalBooking = new com.toedter.calendar.JDateChooser();
        maskapaiBooking = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        asalBooking = new javax.swing.JComboBox<>();
        tujuanBooking = new javax.swing.JComboBox<>();
        tanggalTes = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        text_errorNIKUser = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        text_idUser = new javax.swing.JLabel();
        text_alamatUser = new javax.swing.JLabel();
        text_nikUser = new javax.swing.JLabel();
        text_umurUser = new javax.swing.JLabel();
        text_noUser = new javax.swing.JLabel();
        field_noUser = new javax.swing.JTextField();
        text_namaUser = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelKostumer = new javax.swing.JTable();
        teks_genderUser = new javax.swing.JLabel();
        field_namaUser = new javax.swing.JTextField();
        field_nikUser = new javax.swing.JTextField();
        field_alamatUser = new javax.swing.JTextField();
        field_umurUser = new javax.swing.JTextField();
        field_idUser = new javax.swing.JTextField();
        error_noUser = new javax.swing.JLabel();
        error_nikUser = new javax.swing.JLabel();
        error_umurUser = new javax.swing.JLabel();
        button_simpanUser = new javax.swing.JButton();
        button_ubahUser = new javax.swing.JButton();
        button_hapusUser = new javax.swing.JButton();
        button_batalUser = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        fiel_gender = new javax.swing.JComboBox<>();
        transaksiPanel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabelTransaksi = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        adminPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        adminNama = new javax.swing.JTextField();
        adminUsername = new javax.swing.JTextField();
        adminPassword = new javax.swing.JPasswordField();
        adminSImpan = new javax.swing.JButton();
        adminUbah = new javax.swing.JButton();
        adminBatal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        adminTabel = new javax.swing.JTable();
        adminHapus1 = new javax.swing.JButton();
        panelRute = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        ruteField_harga = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        ruteField_id = new javax.swing.JTextField();
        ruteField_Asal = new javax.swing.JTextField();
        ruteField_Tujuan = new javax.swing.JTextField();
        ruteField_kursi = new javax.swing.JTextField();
        ruteCombo_maskapai = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TabelRute = new javax.swing.JTable();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bodyPanel.setBackground(new java.awt.Color(6, 214, 160));

        panelKiri.setBackground(new java.awt.Color(17, 138, 178));
        panelKiri.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));

        adminMenu.setBackground(new java.awt.Color(255, 209, 102));
        adminMenu.setFont(new java.awt.Font("Montserrat SemiBold", 1, 18)); // NOI18N
        adminMenu.setForeground(new java.awt.Color(0, 0, 0));
        adminMenu.setIcon(new javax.swing.ImageIcon("D:\\_2020_03\\pbo\\TUBES PBO\\TubesPBO\\Assest\\Icon\\user-avatar-with-check-mark.png")); // NOI18N
        adminMenu.setText("ADMIN");
        adminMenu.setToolTipText("");
        adminMenu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        adminMenu.setIconTextGap(25);
        adminMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminMenuActionPerformed(evt);
            }
        });

        homeMenu.setBackground(new java.awt.Color(255, 209, 102));
        homeMenu.setFont(new java.awt.Font("Montserrat SemiBold", 1, 18)); // NOI18N
        homeMenu.setForeground(new java.awt.Color(0, 0, 0));
        homeMenu.setIcon(new javax.swing.ImageIcon("D:\\_2020_03\\pbo\\TUBES PBO\\TubesPBO\\Assest\\Icon\\house.png")); // NOI18N
        homeMenu.setText("HOME");
        homeMenu.setToolTipText("");
        homeMenu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        homeMenu.setIconTextGap(25);
        homeMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeMenuActionPerformed(evt);
            }
        });

        bookingMenu.setBackground(new java.awt.Color(255, 209, 102));
        bookingMenu.setFont(new java.awt.Font("Montserrat SemiBold", 1, 18)); // NOI18N
        bookingMenu.setForeground(new java.awt.Color(0, 0, 0));
        bookingMenu.setIcon(new javax.swing.ImageIcon("D:\\_2020_03\\pbo\\TUBES PBO\\TubesPBO\\Assest\\Icon\\calendar.png")); // NOI18N
        bookingMenu.setText("BOOKING");
        bookingMenu.setToolTipText("");
        bookingMenu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bookingMenu.setIconTextGap(25);
        bookingMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingMenuActionPerformed(evt);
            }
        });

        kostumerMenu.setBackground(new java.awt.Color(255, 209, 102));
        kostumerMenu.setFont(new java.awt.Font("Montserrat SemiBold", 1, 18)); // NOI18N
        kostumerMenu.setForeground(new java.awt.Color(0, 0, 0));
        kostumerMenu.setIcon(new javax.swing.ImageIcon("D:\\_2020_03\\pbo\\TUBES PBO\\TubesPBO\\Assest\\Icon\\customer.png")); // NOI18N
        kostumerMenu.setText("COSTUMER");
        kostumerMenu.setToolTipText("");
        kostumerMenu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        kostumerMenu.setIconTextGap(25);
        kostumerMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kostumerMenuActionPerformed(evt);
            }
        });

        transaksiMenu.setBackground(new java.awt.Color(255, 209, 102));
        transaksiMenu.setFont(new java.awt.Font("Montserrat SemiBold", 1, 18)); // NOI18N
        transaksiMenu.setForeground(new java.awt.Color(0, 0, 0));
        transaksiMenu.setIcon(new javax.swing.ImageIcon("D:\\_2020_03\\pbo\\TUBES PBO\\TubesPBO\\Assest\\Icon\\history.png")); // NOI18N
        transaksiMenu.setText("TRANSAKSI");
        transaksiMenu.setToolTipText("");
        transaksiMenu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        transaksiMenu.setIconTextGap(25);
        transaksiMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transaksiMenuActionPerformed(evt);
            }
        });

        about.setBackground(new java.awt.Color(255, 209, 102));
        about.setFont(new java.awt.Font("Montserrat SemiBold", 1, 18)); // NOI18N
        about.setForeground(new java.awt.Color(0, 0, 0));
        about.setIcon(new javax.swing.ImageIcon("D:\\_2020_03\\pbo\\TUBES PBO\\TubesPBO\\Assest\\Icon\\info.png")); // NOI18N
        about.setToolTipText("");
        about.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        about.setIconTextGap(25);
        about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutActionPerformed(evt);
            }
        });

        iconPlane.setIcon(new javax.swing.ImageIcon("D:\\_2020_03\\pbo\\TUBES PBO\\TubesPBO\\Assest\\Icon\\travelling.png")); // NOI18N

        judulText.setFont(new java.awt.Font("Montserrat SemiBold", 1, 24)); // NOI18N
        judulText.setForeground(new java.awt.Color(255, 255, 255));
        judulText.setText("TRAVELIN AJA");

        logout.setBackground(new java.awt.Color(17, 138, 178));
        logout.setForeground(new java.awt.Color(17, 138, 178));
        logout.setIcon(new javax.swing.ImageIcon("D:\\_2020_03\\pbo\\TUBES PBO\\TubesPBO\\Assest\\Icon\\logout.png")); // NOI18N
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        ruteMenu.setBackground(new java.awt.Color(255, 209, 102));
        ruteMenu.setFont(new java.awt.Font("Montserrat SemiBold", 1, 18)); // NOI18N
        ruteMenu.setForeground(new java.awt.Color(0, 0, 0));
        ruteMenu.setIcon(new javax.swing.ImageIcon("D:\\_2020_03\\pbo\\TUBES PBO\\TubesPBO\\Assest\\Icon\\history.png")); // NOI18N
        ruteMenu.setText("RUTE");
        ruteMenu.setToolTipText("");
        ruteMenu.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ruteMenu.setIconTextGap(25);
        ruteMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ruteMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelKiriLayout = new javax.swing.GroupLayout(panelKiri);
        panelKiri.setLayout(panelKiriLayout);
        panelKiriLayout.setHorizontalGroup(
            panelKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelKiriLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(iconPlane, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
            .addGroup(panelKiriLayout.createSequentialGroup()
                .addGroup(panelKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(about)
                    .addGroup(panelKiriLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(judulText))
                    .addComponent(logout))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelKiriLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adminMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(transaksiMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kostumerMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bookingMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(homeMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ruteMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelKiriLayout.setVerticalGroup(
            panelKiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelKiriLayout.createSequentialGroup()
                .addComponent(logout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iconPlane, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(judulText)
                .addGap(18, 18, 18)
                .addComponent(homeMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bookingMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(kostumerMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(transaksiMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ruteMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(adminMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(about, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelKanan.setBackground(new java.awt.Color(6, 214, 160));
        panelKanan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        panelKanan.setLayout(new java.awt.CardLayout());

        homePanel.setBackground(new java.awt.Color(17, 138, 178));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\_2020_03\\pbo\\TUBES PBO\\TubesPBO\\Assest\\Icon\\bg home.png")); // NOI18N

        javax.swing.GroupLayout homePanelLayout = new javax.swing.GroupLayout(homePanel);
        homePanel.setLayout(homePanelLayout);
        homePanelLayout.setHorizontalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        homePanelLayout.setVerticalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        panelKanan.add(homePanel, "card2");

        bookingPanel.setBackground(new java.awt.Color(255, 202, 58));
        bookingPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 36)); // NOI18N
        jLabel30.setText("BOOKING PESAWAT");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(313, Short.MAX_VALUE)
                .addComponent(jLabel30)
                .addGap(292, 292, 292))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel30)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        bookingPanel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, -1));

        bookingPanel.add(bookingUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 170, -1));

        idBooking.setText("ID0000");
        bookingPanel.add(idBooking, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 170, -1));

        bookingNIK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookingNIKMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bookingNIKMouseEntered(evt);
            }
        });
        bookingNIK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingNIKActionPerformed(evt);
            }
        });
        bookingPanel.add(bookingNIK, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 170, -1));

        bookingUmur.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                bookingUmurMouseDragged(evt);
            }
        });
        bookingUmur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bookingUmurMouseEntered(evt);
            }
        });
        bookingUmur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookingUmurActionPerformed(evt);
            }
        });
        bookingUmur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bookingUmurKeyPressed(evt);
            }
        });
        bookingPanel.add(bookingUmur, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 180, -1));

        bookingHP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bookingHPMouseEntered(evt);
            }
        });
        bookingPanel.add(bookingHP, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 180, -1));

        bookingAlamat.setColumns(20);
        bookingAlamat.setRows(5);
        bookingAlamat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bookingAlamatMouseEntered(evt);
            }
        });
        jScrollPane4.setViewportView(bookingAlamat);

        bookingPanel.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, -1, -1));

        hargaBooking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hargaBookingMouseEntered(evt);
            }
        });
        bookingPanel.add(hargaBooking, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 310, 160, -1));
        bookingPanel.add(tanggalBooking, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 370, 170, -1));

        bookingPanel.add(maskapaiBooking, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 150, 160, -1));

        jLabel2.setText("TAMPIL TANGGAL");
        bookingPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 430, -1, -1));

        asalBooking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                asalBookingMouseEntered(evt);
            }
        });
        asalBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                asalBookingActionPerformed(evt);
            }
        });
        bookingPanel.add(asalBooking, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 210, 160, -1));

        tujuanBooking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tujuanBookingMouseEntered(evt);
            }
        });
        bookingPanel.add(tujuanBooking, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 260, 160, -1));

        tanggalTes.setText("jTextField1");
        tanggalTes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tanggalTesMouseEntered(evt);
            }
        });
        bookingPanel.add(tanggalTes, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 430, 180, -1));

        jButton8.setText("SIMPAN");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        bookingPanel.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 530, -1, -1));

        jLabel19.setText("ID BOOKING");
        bookingPanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel20.setText("NAMA");
        bookingPanel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jLabel21.setText("NIK");
        bookingPanel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        jLabel22.setText("UMUR");
        bookingPanel.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        jLabel23.setText("NO HP");
        bookingPanel.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, -1, -1));

        jLabel24.setText("ALAMAT");
        bookingPanel.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));

        jLabel25.setText("MASKAPAI");
        bookingPanel.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, -1, -1));

        jLabel26.setText("ASAL");
        bookingPanel.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 210, -1, -1));

        jLabel27.setText("TUJUAN");
        bookingPanel.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, -1, -1));

        jLabel28.setText("HARGA");
        bookingPanel.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 320, -1, -1));

        jLabel29.setText("TANGGAL");
        bookingPanel.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 370, -1, -1));

        panelKanan.add(bookingPanel, "card3");

        text_errorNIKUser.setBackground(new java.awt.Color(142, 202, 230));
        text_errorNIKUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 24)); // NOI18N
        jLabel3.setText("KOSTUMER MENEJEMEN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(335, 335, 335)
                .addComponent(jLabel3)
                .addContainerGap(344, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel3)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        text_errorNIKUser.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 100));

        text_idUser.setBackground(new java.awt.Color(0, 0, 0));
        text_idUser.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        text_idUser.setText("ID");
        text_errorNIKUser.add(text_idUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        text_alamatUser.setBackground(new java.awt.Color(0, 0, 0));
        text_alamatUser.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        text_alamatUser.setText("ALAMAT");
        text_errorNIKUser.add(text_alamatUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, -1, -1));

        text_nikUser.setBackground(new java.awt.Color(0, 0, 0));
        text_nikUser.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        text_nikUser.setText("NIK");
        text_errorNIKUser.add(text_nikUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, -1, -1));

        text_umurUser.setBackground(new java.awt.Color(0, 0, 0));
        text_umurUser.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        text_umurUser.setText("UMUR");
        text_errorNIKUser.add(text_umurUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, -1, -1));

        text_noUser.setBackground(new java.awt.Color(0, 0, 0));
        text_noUser.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        text_noUser.setText("NO HP");
        text_errorNIKUser.add(text_noUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        field_noUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_noUserActionPerformed(evt);
            }
        });
        field_noUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                field_noUserKeyPressed(evt);
            }
        });
        text_errorNIKUser.add(field_noUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 280, 40));

        text_namaUser.setBackground(new java.awt.Color(0, 0, 0));
        text_namaUser.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        text_namaUser.setText("NAMA");
        text_errorNIKUser.add(text_namaUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        tabelKostumer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NAMA", "GENDER", "NIK", "NO HP", "UMUR", "ALAMAT"
            }
        ));
        tabelKostumer.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tabelKostumerAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tabelKostumer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelKostumerMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelKostumer);

        text_errorNIKUser.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 470, 780, 180));

        teks_genderUser.setBackground(new java.awt.Color(0, 0, 0));
        teks_genderUser.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        teks_genderUser.setText("GENDER");
        text_errorNIKUser.add(teks_genderUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        field_namaUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_namaUserActionPerformed(evt);
            }
        });
        text_errorNIKUser.add(field_namaUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 280, 40));

        field_nikUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_nikUserActionPerformed(evt);
            }
        });
        field_nikUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                field_nikUserKeyPressed(evt);
            }
        });
        text_errorNIKUser.add(field_nikUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 280, 40));

        field_alamatUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_alamatUserActionPerformed(evt);
            }
        });
        text_errorNIKUser.add(field_alamatUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 260, 280, 40));

        field_umurUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_umurUserActionPerformed(evt);
            }
        });
        field_umurUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                field_umurUserKeyPressed(evt);
            }
        });
        text_errorNIKUser.add(field_umurUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 190, 280, 40));

        field_idUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_idUserActionPerformed(evt);
            }
        });
        text_errorNIKUser.add(field_idUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 280, 40));

        error_noUser.setText("jLabel9");
        text_errorNIKUser.add(error_noUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, -1, -1));

        error_nikUser.setText("jLabel9");
        text_errorNIKUser.add(error_nikUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 170, -1, -1));

        error_umurUser.setText("jLabel10");
        text_errorNIKUser.add(error_umurUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 240, -1, -1));

        button_simpanUser.setText("SIMPAN");
        button_simpanUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_simpanUserActionPerformed(evt);
            }
        });
        text_errorNIKUser.add(button_simpanUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, -1, -1));

        button_ubahUser.setText("UBAH");
        button_ubahUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_ubahUserActionPerformed(evt);
            }
        });
        text_errorNIKUser.add(button_ubahUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, -1, -1));

        button_hapusUser.setText("HAPUS");
        button_hapusUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_hapusUserActionPerformed(evt);
            }
        });
        text_errorNIKUser.add(button_hapusUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 380, -1, -1));

        button_batalUser.setText("CLEAR");
        button_batalUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_batalUserActionPerformed(evt);
            }
        });
        text_errorNIKUser.add(button_batalUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 380, -1, -1));

        jLabel9.setText("CARI");
        text_errorNIKUser.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, -1, -1));

        fiel_gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki Laki", "Perempuan" }));
        fiel_gender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiel_genderActionPerformed(evt);
            }
        });
        text_errorNIKUser.add(fiel_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 180, -1));

        panelKanan.add(text_errorNIKUser, "card4");

        transaksiPanel.setBackground(new java.awt.Color(51, 255, 153));

        tabelTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "nama", "nik", "umur", "hp", "alamat", "maskapai", "asal", "tujuan", "harga", "tanggal"
            }
        ));
        tabelTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelTransaksiMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tabelTransaksi);

        jLabel15.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 36)); // NOI18N
        jLabel15.setText("TRANSAKSI HISTORI");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(296, 296, 296))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel15)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout transaksiPanelLayout = new javax.swing.GroupLayout(transaksiPanel);
        transaksiPanel.setLayout(transaksiPanelLayout);
        transaksiPanelLayout.setHorizontalGroup(
            transaksiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transaksiPanelLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(transaksiPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 982, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        transaksiPanelLayout.setVerticalGroup(
            transaksiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transaksiPanelLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(340, Short.MAX_VALUE))
        );

        panelKanan.add(transaksiPanel, "card5");

        adminPanel.setBackground(new java.awt.Color(51, 255, 153));
        adminPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(33, 158, 188));

        jLabel6.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 48)); // NOI18N
        jLabel6.setText("ADMIN DASHBOARD");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(230, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(207, 207, 207))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel6)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        adminPanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, -1));

        jLabel5.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jLabel5.setText("PASSWORD");
        adminPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, -1, -1));

        jLabel7.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jLabel7.setText("NAMA");
        adminPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        jLabel8.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jLabel8.setText("USERNAME");
        adminPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, -1));

        adminNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminNamaActionPerformed(evt);
            }
        });
        adminPanel.add(adminNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 200, 30));

        adminUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminUsernameActionPerformed(evt);
            }
        });
        adminPanel.add(adminUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 200, 30));

        adminPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminPasswordActionPerformed(evt);
            }
        });
        adminPanel.add(adminPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, 200, 30));

        adminSImpan.setText("TAMBAH");
        adminSImpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminSImpanActionPerformed(evt);
            }
        });
        adminPanel.add(adminSImpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, -1, -1));

        adminUbah.setText("EDIT");
        adminUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminUbahActionPerformed(evt);
            }
        });
        adminPanel.add(adminUbah, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 260, -1, -1));

        adminBatal.setText("RESET");
        adminBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminBatalActionPerformed(evt);
            }
        });
        adminPanel.add(adminBatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 260, 80, -1));

        adminTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nama", "Username", "Password"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        adminTabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminTabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(adminTabel);

        adminPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, -1, 90));

        adminHapus1.setText("HAPUS");
        adminHapus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminHapus1ActionPerformed(evt);
            }
        });
        adminPanel.add(adminHapus1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 260, 80, -1));

        panelKanan.add(adminPanel, "card6");

        panelRute.setBackground(new java.awt.Color(67, 170, 139));
        panelRute.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jLabel10.setText("ID RUTE");
        panelRute.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));

        jLabel11.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jLabel11.setText("TUJUAN");
        panelRute.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, -1));

        jLabel12.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jLabel12.setText("MASKAPAI");
        panelRute.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        jLabel13.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        panelRute.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel14.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jLabel14.setText("ASAL");
        panelRute.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, -1));

        jLabel16.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jLabel16.setText("HARGA");
        panelRute.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, -1, -1));

        jLabel17.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jLabel17.setText("JUMLAH KURSI");
        panelRute.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 150, -1, -1));
        panelRute.add(ruteField_harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 210, 230, 30));

        jLabel18.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 36)); // NOI18N
        jLabel18.setText("PANEL RUTE");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(392, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addGap(366, 366, 366))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel18)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        panelRute.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 120));

        ruteField_id.setText("ID000");
        ruteField_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ruteField_idActionPerformed(evt);
            }
        });
        panelRute.add(ruteField_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 230, 30));

        ruteField_Asal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ruteField_AsalActionPerformed(evt);
            }
        });
        panelRute.add(ruteField_Asal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 230, 30));
        panelRute.add(ruteField_Tujuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 230, 30));
        panelRute.add(ruteField_kursi, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 150, 230, 30));

        ruteCombo_maskapai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Garuda Indonesia", "Batik Air", "Lion Air", "Sriwijaya Air", "Citilink " }));
        panelRute.add(ruteCombo_maskapai, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 180, -1));

        jButton1.setText("INSERT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelRute.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, -1, -1));

        jButton2.setText("EDIT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panelRute.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 410, -1, -1));

        jButton3.setText("HAPUS");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        panelRute.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 410, -1, -1));

        jButton4.setText("RESET");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        panelRute.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 410, -1, -1));

        TabelRute.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID RUTE", "MASKAPAI", "ASAL", "TUJUAN", "KURSI", "HARGA"
            }
        ));
        TabelRute.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelRuteMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TabelRute);

        panelRute.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 960, 120));

        panelKanan.add(panelRute, "card7");

        javax.swing.GroupLayout bodyPanelLayout = new javax.swing.GroupLayout(bodyPanel);
        bodyPanel.setLayout(bodyPanelLayout);
        bodyPanelLayout.setHorizontalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addComponent(panelKiri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelKanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelKiri, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelKanan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutActionPerformed
        aboutPage n = new aboutPage();
        n.setVisible(true);
        
    }//GEN-LAST:event_aboutActionPerformed

    private void transaksiMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transaksiMenuActionPerformed
       // TODO add your handling code here:
        //dynamic panel
        // remove panel sebelumnya
        panelKanan.removeAll();
        panelKanan.repaint();
        panelKanan.revalidate();
        //repaint panel sebelumnya
        panelKanan.add(transaksiPanel);
        panelKanan.repaint();
        panelKanan.revalidate();
        
    }//GEN-LAST:event_transaksiMenuActionPerformed

    private void kostumerMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kostumerMenuActionPerformed
        // TODO add your handling code here:
        //dynamic panel
        // remove panel sebelumnya
        panelKanan.removeAll();
        panelKanan.repaint();
        panelKanan.revalidate();
        //repaint panel sebelumnya
        panelKanan.add(text_errorNIKUser);
        panelKanan.repaint();
        panelKanan.revalidate();
    }//GEN-LAST:event_kostumerMenuActionPerformed

    private void bookingMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingMenuActionPerformed
        // TODO add your handling code here:
        //dynamic panel
        // remove panel sebelumnya
        panelKanan.removeAll();
        panelKanan.repaint();
        panelKanan.revalidate();
        //repaint panel sebelumnya
        panelKanan.add(bookingPanel);
        panelKanan.repaint();
        panelKanan.revalidate();
    }//GEN-LAST:event_bookingMenuActionPerformed

    private void homeMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeMenuActionPerformed
        // TODO add your handling code here:
        //dynamic panel
        // remove panel sebelumnya
        panelKanan.removeAll();
        panelKanan.repaint();
        panelKanan.revalidate();
        //repaint panel sebelumnya
        panelKanan.add(homePanel);
        panelKanan.repaint();
        panelKanan.revalidate();
    }//GEN-LAST:event_homeMenuActionPerformed

    private void adminMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminMenuActionPerformed
        // TODO add your handling code here:
        //dynamic panel
        // remove panel sebelumnya
        panelKanan.removeAll();
        panelKanan.repaint();
        panelKanan.revalidate();
        //repaint panel sebelumnya
        panelKanan.add(adminPanel);
        panelKanan.repaint();
        panelKanan.revalidate();
    }//GEN-LAST:event_adminMenuActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed

        int pesan = JOptionPane.showConfirmDialog(null, "Yakin Ingin Logout ? ","Konfirmasi",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(pesan == JOptionPane.YES_OPTION){
            setVisible(false);
            LoginForm login = new LoginForm();
            login.setVisible(true);
            setVisible(false);
        }
        

    }//GEN-LAST:event_logoutActionPerformed

    private void adminNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adminNamaActionPerformed

    private void adminUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adminUsernameActionPerformed

    private void adminSImpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminSImpanActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "INSERT INTO login(nama,username,password) VALUES ('"+adminNama.getText()+"','"+adminUsername.getText()+"','"+adminPassword.getText()+"')";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
            load_table_admin();
            kosongkanAdmin();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
    }//GEN-LAST:event_adminSImpanActionPerformed

    private void field_noUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_noUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_noUserActionPerformed

    private void field_namaUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_namaUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_namaUserActionPerformed

    private void field_nikUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_nikUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_nikUserActionPerformed

    private void field_alamatUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_alamatUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_alamatUserActionPerformed

    private void field_umurUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_umurUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_umurUserActionPerformed

    private void field_idUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_idUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_idUserActionPerformed

    private void field_noUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_noUserKeyPressed
        // TODO add your handling code here:
        if(field_noUser.getText().length()>=12){
            field_noUser.setText(field_noUser.getText().substring(0, 11));
  
        }
        char c = evt.getKeyChar();
        if(Character.isLetter(c)){
            field_noUser.setEditable(false);
            error_noUser.setText("Silhkan isi hanya dengan angka");
        }
        else{
            field_noUser.setEditable(true);
            error_noUser.setText("");
        }
    }//GEN-LAST:event_field_noUserKeyPressed

    private void field_nikUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_nikUserKeyPressed
        // TODO add your handling code here:
        if(field_nikUser.getText().length()>=16){
            field_nikUser.setText(field_nikUser.getText().substring(0, 15));
  
        }
        char c = evt.getKeyChar();
        if(Character.isLetter(c)){
            field_nikUser.setEditable(false);
            error_nikUser.setText("Silhkan isi hanya dengan angka");
        }
        else{
            field_nikUser.setEditable(true);
            error_nikUser.setText("");
        }
    }//GEN-LAST:event_field_nikUserKeyPressed

    private void field_umurUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_umurUserKeyPressed
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(Character.isLetter(c)){
            field_umurUser.setEditable(false);
            error_umurUser.setText("Silhkan isi hanya dengan angka");
        }
        else{
            field_umurUser.setEditable(true);
            error_noUser.setText("");
        }
    }//GEN-LAST:event_field_umurUserKeyPressed

    private void button_simpanUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_simpanUserActionPerformed
        // TODO add your handling code here:
        try {
//            String idUser = field_idUser.
            String sql = "INSERT INTO kostumer VALUES('"+field_idUser.getText()+"','"+field_namaUser.getText()+"','"+field_nikUser.getText()+"','"+field_umurUser.getText()+"','"+field_noUser.getText()+"','"+field_alamatUser.getText()+"','"+fiel_gender.getSelectedItem()+"')";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
            load_table();
            kosongKostumer();
        }  catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
    }//GEN-LAST:event_button_simpanUserActionPerformed

    private void fiel_genderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiel_genderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fiel_genderActionPerformed

    private void tabelKostumerAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tabelKostumerAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelKostumerAncestorAdded

    private void tabelKostumerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelKostumerMouseClicked
        // TODO add your handling code here:
        int baris = tabelKostumer.rowAtPoint(evt.getPoint());
        String idUser =tabelKostumer.getValueAt(baris, 0).toString();
        field_idUser.setText(idUser);
        
        String namaUser =tabelKostumer.getValueAt(baris, 1).toString();
        field_namaUser.setText(namaUser);
        
        String gender =tabelKostumer.getValueAt(baris, 6).toString();
        fiel_gender.setSelectedItem(gender);
        
        String nikUser =tabelKostumer.getValueAt(baris, 2).toString();
        field_nikUser.setText(nikUser);
        
        String noHPUser =tabelKostumer.getValueAt(baris, 4).toString();
        field_noUser.setText(noHPUser);
        
        String umurUser =tabelKostumer.getValueAt(baris, 3).toString();
        field_umurUser.setText(umurUser);
        
        String alamatUser =tabelKostumer.getValueAt(baris, 5).toString();
        field_alamatUser.setText(alamatUser);
    }//GEN-LAST:event_tabelKostumerMouseClicked

    private void button_ubahUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ubahUserActionPerformed
        // TODO add your handling code here:
        try {
            String sql ="UPDATE kostumer SET id_kostumer = '"+field_idUser.getText()+"', nama_kostumer = '"+field_namaUser.getText()+"',nik_kostumer= '"+field_nikUser.getText()+"',umur_kostumer = '"+field_umurUser.getText()+"',no_kostumer= '"+field_noUser.getText()+"',alamat_kostumer= '"+field_alamatUser.getText()+"', jk_user = '"+fiel_gender.getSelectedItem()+"' WHERE id_kostumer = '"+field_idUser.getText()+"'";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "data berhasil di edit");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Perubahan Data Gagal"+e.getMessage());
        }
        load_table();
        kosongKostumer();
    }//GEN-LAST:event_button_ubahUserActionPerformed

    private void button_hapusUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_hapusUserActionPerformed
        // TODO add your handling code here:
        try {
            String sql ="delete from kostumer where id_kostumer='"+field_idUser.getText()+"'";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "berhasil di hapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        load_table();
        kosongKostumer();
    }//GEN-LAST:event_button_hapusUserActionPerformed

    private void ruteMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ruteMenuActionPerformed
        // TODO add your handling code here:
        panelKanan.removeAll();
        panelKanan.repaint();
        panelKanan.revalidate();
        //repaint panel sebelumnya
        panelKanan.add(panelRute);
        panelKanan.repaint();
        panelKanan.revalidate();
    }//GEN-LAST:event_ruteMenuActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "INSERT INTO rute VALUES ('"+ruteField_id.getText()+"','"+ruteCombo_maskapai.getSelectedItem()+"','"+ruteField_Asal.getText()+"','"+ruteField_Tujuan.getText()+"','"+ruteField_kursi.getText()+"','"+ruteField_harga.getText()+"')";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Penyimpanan Data Berhasil");
            load_table_rute();
            kosongRute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            String sql ="UPDATE rute SET id_rute = '"+ruteField_id.getText()+"', maskapai = '"+ruteCombo_maskapai.getSelectedItem()+"', asal = '"+ruteField_Asal.getText()+"', tujuan= '"+ruteField_Tujuan.getText()+"',jlhKursi= '"+ruteField_kursi.getText()+"',harga= '"+ruteField_harga.getText()+"' WHERE id_rute = '"+ruteField_id.getText()+"'";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "data berhasil di edit");
            load_table_rute();
            kosongRute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Perubahan Data Gagal"+e.getMessage());
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void TabelRuteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelRuteMouseClicked
        // TODO add your handling code here:
        int baris = TabelRute.rowAtPoint(evt.getPoint());
        
        String idRute =TabelRute.getValueAt(baris, 0).toString();
        ruteField_id.setText(idRute);
        
        String namaMaskapai =TabelRute.getValueAt(baris, 1).toString();
        ruteCombo_maskapai.setSelectedItem(namaMaskapai);
        
        String asalRute =TabelRute.getValueAt(baris, 2).toString();
        ruteField_Asal.setText(asalRute);
        
        String tujuanRute = TabelRute.getValueAt(baris, 3).toString();
        ruteField_Tujuan.setText(tujuanRute);
        
        String kursiRute = TabelRute.getValueAt(baris, 4).toString();
        ruteField_kursi.setText(kursiRute);
        
        String hargaRute = TabelRute.getValueAt(baris, 5).toString();
        ruteField_harga.setText(hargaRute);
 
        
    }//GEN-LAST:event_TabelRuteMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            String sql ="delete from rute where id_rute='"+ruteField_id.getText()+"'";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "berhasil di hapus");
            load_table_rute();
            kosongRute();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void button_batalUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_batalUserActionPerformed
        // TODO add your handling code here:
        kosongKostumer();
    }//GEN-LAST:event_button_batalUserActionPerformed

    private void adminBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminBatalActionPerformed
        // TODO add your handling code here:
        kosongkanAdmin();
    }//GEN-LAST:event_adminBatalActionPerformed

    private void adminPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminPasswordActionPerformed
           // TODO add your handling code here:
            
    }//GEN-LAST:event_adminPasswordActionPerformed

    private void adminUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminUbahActionPerformed
        // TODO add your handling code here:
        try {
            String sql ="UPDATE login SET nama = '"+adminNama.getText()+"', username = '"+adminUsername.getText()+"',password= '"+adminPassword.getText()+"' WHERE username = '"+adminUsername.getText()+"'";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "data berhasil di edit");
            load_table_admin();
            kosongkanAdmin();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Perubahan Data Gagal"+e.getMessage());
        }
        
    }//GEN-LAST:event_adminUbahActionPerformed

    private void adminTabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminTabelMouseClicked
        // TODO add your handling code here:
        int baris =adminTabel.rowAtPoint(evt.getPoint());
        
        String nama =adminTabel.getValueAt(baris, 1).toString();
        adminNama.setText(nama);
        
        String username =adminTabel.getValueAt(baris, 1).toString();
        adminUsername.setText(username);
        
        String password =adminTabel.getValueAt(baris, 1).toString();
        adminPassword.setText(password);
        
        
       
    }//GEN-LAST:event_adminTabelMouseClicked

    private void adminHapus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminHapus1ActionPerformed
        // TODO add your handling code here:
        try {
            String sql ="delete from login where username='"+adminUsername.getText()+"'";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(this, "berhasil di hapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        load_table_admin();
        kosongkanAdmin();
    }//GEN-LAST:event_adminHapus1ActionPerformed

    private void bookingNIKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingNIKActionPerformed
                // TODO add your handling code here:
            
            
           
//        try {
//            String sql ="SELECT nik_kostumer from kostumer where nama_kostumer ='"+bookingUsername.getSelectedItem()+"'".toString();
//            java.sql.Connection conn=(Connection)Config.configDB();
//            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
//            pst.execute();
//            
//            
//            
//            
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, e.getMessage());
//        }
    }//GEN-LAST:event_bookingNIKActionPerformed

    private void bookingNIKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookingNIKMouseClicked
         //TODO add your handling code here:
        
    }//GEN-LAST:event_bookingNIKMouseClicked

    private void bookingUmurKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bookingUmurKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookingUmurKeyPressed

    private void bookingUmurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookingUmurActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookingUmurActionPerformed

    private void bookingUmurMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookingUmurMouseDragged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_bookingUmurMouseDragged

    private void bookingUmurMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookingUmurMouseEntered
        // TODO add your handling code here:
        try {
            ResultSet rs =null;
            String sql = "SELECT umur_kostumer from kostumer where nama_kostumer ='"+bookingUsername.getSelectedItem()+"'";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String nama = rs.getString("umur_kostumer");
                bookingUmur.setText(nama);
                
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_bookingUmurMouseEntered

    private void bookingNIKMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookingNIKMouseEntered
        // TODO add your handling code here:
        try {
            ResultSet rs =null;
            String sql = "SELECT nik_kostumer from kostumer where nama_kostumer ='"+bookingUsername.getSelectedItem()+"'";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String nama = rs.getString("nik_kostumer");
                bookingNIK.setText(nama);
                
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_bookingNIKMouseEntered

    private void bookingHPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookingHPMouseEntered
        // TODO add your handling code here:
        try {
            ResultSet rs =null;
            String sql = "SELECT no_kostumer from kostumer where nama_kostumer ='"+bookingUsername.getSelectedItem()+"'";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String nama = rs.getString("no_kostumer");
                bookingHP.setText("0"+nama);
                
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_bookingHPMouseEntered

    private void bookingAlamatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookingAlamatMouseEntered
        // TODO add your handling code here:
        try {
            ResultSet rs =null;
            String sql = "SELECT alamat_kostumer from kostumer where nama_kostumer ='"+bookingUsername.getSelectedItem()+"'";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String nama = rs.getString("alamat_kostumer");
                bookingAlamat.setText(nama);
                
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_bookingAlamatMouseEntered

    private void asalBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_asalBookingActionPerformed
        // TODO add your handling code here:
//        int itemCount = asalBooking.getItemCount();
//
//    for(int i=0;i<itemCount;i++){
//        asalBooking.removeItemAt(0);
//     }
//        try {
//            ResultSet rs =null;
//            String sql = "SELECT * from rute where maskapai = '"+maskapaiBooking.getSelectedItem()+"'";
//            java.sql.Connection conn=(Connection)Config.configDB();
//            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
//            rs = pst.executeQuery();
//            
//            while(rs.next()){
//                String nama = rs.getString("asal");
//                
//                asalBooking.addItem(nama);
//            }
//            
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//        }
    }//GEN-LAST:event_asalBookingActionPerformed

    private void asalBookingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_asalBookingMouseEntered
        // TODO add your handling code here:
        asalBooking.removeAllItems();
         try {
            ResultSet rs =null;
            String sql = "SELECT * from rute where maskapai = '"+maskapaiBooking.getSelectedItem()+"'";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                String nama = rs.getString("asal");
                asalBooking.addItem(nama);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_asalBookingMouseEntered

    private void ruteField_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ruteField_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ruteField_idActionPerformed

    private void ruteField_AsalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ruteField_AsalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ruteField_AsalActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        kosongRute();
       
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tujuanBookingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tujuanBookingMouseEntered
        // TODO add your handling code here:
        tujuanBooking.removeAllItems();
         try {
            ResultSet rs =null;
            String sql = "SELECT * from rute where maskapai = '"+maskapaiBooking.getSelectedItem()+"' and asal='"+asalBooking.getSelectedItem()+"'";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                String nama = rs.getString("tujuan");
              tujuanBooking.addItem(nama);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_tujuanBookingMouseEntered

    private void hargaBookingMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hargaBookingMouseEntered
        // TODO add your handling code here:
        try {
            ResultSet rs =null;
            String sql = "SELECT harga from rute where maskapai ='"+maskapaiBooking.getSelectedItem()+"' and asal = '"+asalBooking.getSelectedItem()+"' and tujuan = '"+tujuanBooking.getSelectedItem()+"'";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String nama = rs.getString("harga");
                hargaBooking.setText(nama);
                
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_hargaBookingMouseEntered

    private void tanggalTesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tanggalTesMouseEntered
        // TODO add your handling code here:
        String tampilan = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(tanggalBooking.getDate()));
       tanggalTes.setText(tanggal);
    }//GEN-LAST:event_tanggalTesMouseEntered

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "INSERT INTO transaksi VALUES ('"+idBooking.getText()+"','"+bookingUsername.getSelectedItem()+"','"+bookingNIK.getText()+"','"+bookingUmur.getText()+"','"+bookingHP.getText()+"','"+bookingAlamat.getText()+"','"+maskapaiBooking.getSelectedItem()+"','"+asalBooking.getSelectedItem()+"','"+tujuanBooking.getSelectedItem()+"','"+hargaBooking.getText()+"','"+tanggalTes.getText()+"')";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "PEMESANAN BERHASIL");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void tabelTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelTransaksiMouseClicked
        // TODO add your handling code here:
     int baris = tabelTransaksi.rowAtPoint(evt.getPoint());
        String nama =tabelTransaksi.getValueAt(baris, 1).toString();
        
        String nim = tabelTransaksi.getValueAt(baris,2).toString();
 
//        String jr = jTable1.getValueAt(baris, 3).toString();
//        jComboBox1.setSelectedItem(jr);
        
        JOptionPane.showMessageDialog(rootPane, "cetak transaksi coming soon");
    }//GEN-LAST:event_tabelTransaksiMouseClicked
    
     
    
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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelRute;
    private javax.swing.JButton about;
    private javax.swing.JButton adminBatal;
    private javax.swing.JButton adminHapus1;
    private javax.swing.JButton adminMenu;
    private javax.swing.JTextField adminNama;
    private javax.swing.JPanel adminPanel;
    private javax.swing.JPasswordField adminPassword;
    private javax.swing.JButton adminSImpan;
    private javax.swing.JTable adminTabel;
    private javax.swing.JButton adminUbah;
    private javax.swing.JTextField adminUsername;
    private javax.swing.JComboBox<String> asalBooking;
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JTextArea bookingAlamat;
    private javax.swing.JTextField bookingHP;
    private javax.swing.JButton bookingMenu;
    private javax.swing.JTextField bookingNIK;
    private javax.swing.JPanel bookingPanel;
    private javax.swing.JTextField bookingUmur;
    private javax.swing.JComboBox<String> bookingUsername;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton button_batalUser;
    private javax.swing.JButton button_hapusUser;
    private javax.swing.JButton button_simpanUser;
    private javax.swing.JButton button_ubahUser;
    private javax.swing.JLabel error_nikUser;
    private javax.swing.JLabel error_noUser;
    private javax.swing.JLabel error_umurUser;
    private javax.swing.JComboBox<String> fiel_gender;
    private javax.swing.JTextField field_alamatUser;
    private javax.swing.JTextField field_idUser;
    private javax.swing.JTextField field_namaUser;
    private javax.swing.JTextField field_nikUser;
    private javax.swing.JTextField field_noUser;
    private javax.swing.JTextField field_umurUser;
    private javax.swing.JTextField hargaBooking;
    private javax.swing.JButton homeMenu;
    private javax.swing.JPanel homePanel;
    private javax.swing.JLabel iconPlane;
    private javax.swing.JTextField idBooking;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel judulText;
    private javax.swing.JButton kostumerMenu;
    private javax.swing.JButton logout;
    private javax.swing.JComboBox<String> maskapaiBooking;
    private javax.swing.JPanel panelKanan;
    private javax.swing.JPanel panelKiri;
    private javax.swing.JPanel panelRute;
    private javax.swing.JComboBox<String> ruteCombo_maskapai;
    private javax.swing.JTextField ruteField_Asal;
    private javax.swing.JTextField ruteField_Tujuan;
    private javax.swing.JTextField ruteField_harga;
    private javax.swing.JTextField ruteField_id;
    private javax.swing.JTextField ruteField_kursi;
    private javax.swing.JButton ruteMenu;
    private javax.swing.JTable tabelKostumer;
    public static javax.swing.JTable tabelTransaksi;
    private com.toedter.calendar.JDateChooser tanggalBooking;
    private javax.swing.JTextField tanggalTes;
    private javax.swing.JLabel teks_genderUser;
    private javax.swing.JLabel text_alamatUser;
    private javax.swing.JPanel text_errorNIKUser;
    private javax.swing.JLabel text_idUser;
    private javax.swing.JLabel text_namaUser;
    private javax.swing.JLabel text_nikUser;
    private javax.swing.JLabel text_noUser;
    private javax.swing.JLabel text_umurUser;
    private javax.swing.JButton transaksiMenu;
    private javax.swing.JPanel transaksiPanel;
    private javax.swing.JComboBox<String> tujuanBooking;
    // End of variables declaration//GEN-END:variables
}
  



