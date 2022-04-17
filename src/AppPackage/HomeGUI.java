package AppPackage;

import com.jtattoo.plaf.DecorationHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.JRootPane;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class HomeGUI extends javax.swing.JFrame 
{
    TableModel model ;
    int xMouse,yMouse;
    ArrayList<String> arr ;
    int index;
    public static int count;
    MP3Class MUSIC = new MP3Class();
    String musicPlaying="";
    DefaultTableModel dmodel;
    String musicPath = "";
    String musicLocation = "";
    String loc1 = "";
    String getMusicLoc = "";
    
    
    public HomeGUI() 
    {
        initComponents();
      
        WallpaperPanel.setVisible(false);
        MailPanel.setVisible(false);
        MusicPanel.setVisible(false);
        arr = new ArrayList<String>();
        DecorationHelper.decorateWindows(false);
        HomeGUI.this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        JTableHeader header = jTable1.getTableHeader();
        header.setTable(null);
        dmodel = (DefaultTableModel) jTable1.getModel();
        ConfigPanel.setVisible(false);
       
        createConfig();
        loadConfig();
        musicLocation = musicPath + "\\";
        fileList(musicLocation);
        jTable1.changeSelection(index, 0, false, true);
    }
    
    private void refreshMusic()
    {
        DefaultTableModel empty = (DefaultTableModel) jTable1.getModel();
        while(empty.getRowCount()>0)
        {
            
            empty.removeRow(0);
           
        }
        arr.removeAll(arr);
        fileList(jTextField2.getText()+"");
        musicPath = jTextField2.getText()+"";
        musicLocation = musicPath + "\\";
        jLabel40.setText("");
        MUSIC.stop();
        musicPlaying="";
        jLabel37.setToolTipText("Turn On Loop");
        count = 0;
        jLabel38.setToolTipText("Play Music");
        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Play.png")));
        jTable1.changeSelection(0, 0, false, true);
    }
    
    private void createConfig() 
    { 
        File checkConfig = new File("Configuration.config");
        if(checkConfig.exists()==true)
        {
            System.out.println("Configuration File exist.");
        }
        else
        {
        
        try 
        {
            Properties prop = new Properties();
            
            prop.put("MusicLocation", System.getProperty("user.home") + "\\Music");
            prop.put("Facebook","www.facebook.com");
            prop.put("Twitter", "www.twitter.com");
            prop.put("Youtube", "www.youtube.com");
            prop.put("Whatsapp", "www.web.whatsapp.com");
            prop.put("GmailID" , "");
            prop.put("Password", "");
       
            prop.store(new FileOutputStream("Configuration.config"), null);
            
        } 
        catch (FileNotFoundException ex) 
        {
        } 
        catch (IOException ex) 
        {
        }
        }
    }
    private void loadConfig()
    {
        Properties prop = new Properties();
        try 
        {
            loc1 = System.getProperty("user.home") + "\\Music";
            prop.load(new FileInputStream("Configuration.config"));
            musicPath = prop.getProperty("MusicLocation");
            if(loc1.equals(musicPath))
            {
                jTextField2.setText(prop.getProperty("MusicLocation",musicPath));
            }else
            {
                 jTextField2.setText(prop.getProperty("MusicLocation"));
            }
            jTextField8.setText(prop.getProperty("Facebook")+"");
            jTextField5.setText(prop.getProperty("Twitter")+"");
            jTextField7.setText(prop.getProperty("Youtube")+"");
            jTextField6.setText(prop.getProperty("Whatsapp")+"");
            jTextField4.setText(prop.getProperty("GmailID")+"");
            jTextField3.setText(prop.getProperty("Password")+"");
        } 
        catch (FileNotFoundException ex) 
        {
            System.out.println("Config File Not found.");
        } 
        catch (IOException ex) 
        {
        }
    }
    
   
    
    
    private void mp3()
    {
        new Thread()
        {
            public void run()
            {
                while(true)
                {
                    if(MUSIC.player.isComplete()==true)
                    {   
                        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Play.png")));
                        jLabel40.setText("");
                    }
                }
            }
      
      
        }.start();
    }
    
    private void searchMusic(String query)
    {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dmodel);
        jTable1.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
    
    
    
    
    
    private void fileList(String path)
    {
        File file = new  File(path);
        FilenameFilter ff = new FilenameFilter() 
        {
            @Override
            public boolean accept(File file, String name)
            {
             
                if(file.isDirectory() && name.endsWith(".mp3"))
                {
                    return true;
                }
                    return false;
            }
        };    
        String[] files = file.list(ff);
        for(String e:files)
        {
           arr.add(e);
        }
            DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();
            Object [] row = new Object[1];
            for (String file1 : files) 
            {
                row[0] = file1;
                model1.addRow(row);
            }
     
 
        }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ConfigPanel = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        MenuPanel = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        MailPanel = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        WallpaperPanel = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        MusicPanel = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new SubJTable();
        jLabel23 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1040, 540));
        setMinimumSize(new java.awt.Dimension(1040, 540));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ConfigPanel.setMaximumSize(new java.awt.Dimension(1040, 540));
        ConfigPanel.setMinimumSize(new java.awt.Dimension(1040, 540));
        ConfigPanel.setPreferredSize(new java.awt.Dimension(1040, 540));
        ConfigPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel43.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 153, 255));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ConfigPanel.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 19, 550, 20));

        jTextField8.setBackground(new java.awt.Color(1, 9, 18));
        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(255, 255, 255));
        jTextField8.setBorder(null);
        jTextField8.setOpaque(false);
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        ConfigPanel.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 166, 390, 22));

        jTextField3.setBackground(new java.awt.Color(1, 9, 18));
        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));
        jTextField3.setBorder(null);
        jTextField3.setOpaque(false);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        ConfigPanel.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 376, 390, 22));

        jTextField4.setBackground(new java.awt.Color(1, 9, 18));
        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));
        jTextField4.setBorder(null);
        jTextField4.setOpaque(false);
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        ConfigPanel.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 334, 380, 22));

        jTextField6.setBackground(new java.awt.Color(1, 9, 18));
        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(255, 255, 255));
        jTextField6.setBorder(null);
        jTextField6.setOpaque(false);
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        ConfigPanel.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 250, 380, 22));

        jTextField7.setBackground(new java.awt.Color(1, 9, 18));
        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(255, 255, 255));
        jTextField7.setBorder(null);
        jTextField7.setOpaque(false);
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        ConfigPanel.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 292, 390, 22));

        jTextField5.setBackground(new java.awt.Color(1, 9, 18));
        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(255, 255, 255));
        jTextField5.setBorder(null);
        jTextField5.setOpaque(false);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        ConfigPanel.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 208, 380, 22));

        jTextField2.setBackground(new java.awt.Color(1, 9, 18));
        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setBorder(null);
        jTextField2.setOpaque(false);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        ConfigPanel.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(404, 124, 390, 22));

        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Save.png"))); // NOI18N
        jLabel41.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel41MouseReleased(evt);
            }
        });
        ConfigPanel.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 470, 110, 40));

        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/NewConfig2.png"))); // NOI18N
        ConfigPanel.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 790, 410));

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("x");
        jLabel46.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel46MouseReleased(evt);
            }
        });
        ConfigPanel.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, -2, 40, 40));

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(0, 153, 255));
        jLabel48.setText("Project Jarvis");
        ConfigPanel.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 90, 40));

        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/TitleBar.png"))); // NOI18N
        ConfigPanel.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -6, 1040, 50));

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Wallpaper/WallpaperFive.png"))); // NOI18N
        jLabel50.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel50MouseDragged(evt);
            }
        });
        jLabel50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel50MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel50MouseReleased(evt);
            }
        });
        ConfigPanel.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 540));

        getContentPane().add(ConfigPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 540));

        MenuPanel.setMaximumSize(new java.awt.Dimension(1040, 540));
        MenuPanel.setMinimumSize(new java.awt.Dimension(1040, 540));
        MenuPanel.setPreferredSize(new java.awt.Dimension(1040, 540));
        MenuPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel42.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel42MouseReleased(evt);
            }
        });
        MenuPanel.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 294, 110, 20));

        jLabel39.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel39MouseReleased(evt);
            }
        });
        MenuPanel.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 180, 160));

        jLabel21.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel21MouseReleased(evt);
            }
        });
        MenuPanel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 180, 160));

        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel12MouseReleased(evt);
            }
        });
        MenuPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 180, 160));

        jTextField1.setBackground(new java.awt.Color(0, 0, 0));
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(0, 153, 255));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Search");
        jTextField1.setBorder(null);
        MenuPanel.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 70, 220, -1));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Search.png"))); // NOI18N
        MenuPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 60, 270, 40));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Menu.png"))); // NOI18N
        MenuPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 820, 410));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("x");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel4MouseReleased(evt);
            }
        });
        MenuPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, -2, 40, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 34)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("_");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel5MouseReleased(evt);
            }
        });
        MenuPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(964, -20, 40, 60));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setText("Project Jarvis");
        MenuPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 90, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/TitleBar.png"))); // NOI18N
        MenuPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -6, 1040, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Wallpaper/WallpaperFour.png"))); // NOI18N
        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel1MouseDragged(evt);
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel1MouseReleased(evt);
            }
        });
        MenuPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 540));

        getContentPane().add(MenuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 540));

        MailPanel.setMaximumSize(new java.awt.Dimension(1040, 540));
        MailPanel.setMinimumSize(new java.awt.Dimension(1040, 540));
        MailPanel.setPreferredSize(new java.awt.Dimension(1040, 540));
        MailPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel44.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 153, 255));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MailPanel.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 19, 550, 20));

        jTextField9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField9.setBorder(null);
        jTextField9.setOpaque(false);
        MailPanel.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 106, 610, 24));

        jTextField10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField10.setBorder(null);
        jTextField10.setOpaque(false);
        MailPanel.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 188, 610, 24));

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Send.png"))); // NOI18N
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel20MouseReleased(evt);
            }
        });
        MailPanel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 480, 120, 40));

        jScrollPane2.setBorder(null);

        jTextArea1.setBackground(new java.awt.Color(26, 26, 26));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI Light", 0, 16)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        MailPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 270, 630, 160));

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Mail.png"))); // NOI18N
        jLabel19.setText("jLabel19");
        MailPanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 680, 410));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("x");
        jLabel22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel22MouseReleased(evt);
            }
        });
        MailPanel.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, -2, 40, 40));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 153, 255));
        jLabel24.setText("Project Jarvis");
        MailPanel.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 90, 40));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/TitleBar.png"))); // NOI18N
        MailPanel.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -6, 1040, 50));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Wallpaper/WallpaperFour.png"))); // NOI18N
        jLabel26.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel26MouseDragged(evt);
            }
        });
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel26MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel26MouseReleased(evt);
            }
        });
        MailPanel.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 540));

        getContentPane().add(MailPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 540));

        WallpaperPanel.setMaximumSize(new java.awt.Dimension(1040, 540));
        WallpaperPanel.setMinimumSize(new java.awt.Dimension(1040, 540));
        WallpaperPanel.setPreferredSize(new java.awt.Dimension(1040, 540));
        WallpaperPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 153, 255));
        jLabel27.setText("Project Jarvis");
        WallpaperPanel.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 90, 40));
        WallpaperPanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 260, 160));
        WallpaperPanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 120, 260, 150));
        WallpaperPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 290, 260, 160));
        WallpaperPanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, 260, 160));
        WallpaperPanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 260, 160));
        WallpaperPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 260, 150));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Wallpaper/Wallpaper.png"))); // NOI18N
        WallpaperPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 870, 410));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("x");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel10MouseReleased(evt);
            }
        });
        WallpaperPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, -2, 40, 40));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/TitleBar.png"))); // NOI18N
        WallpaperPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -6, 1040, 50));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Wallpaper/WallpaperThree.png"))); // NOI18N
        jLabel9.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel9MouseDragged(evt);
            }
        });
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel9MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel9MouseReleased(evt);
            }
        });
        WallpaperPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 540));

        getContentPane().add(WallpaperPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 540));

        MusicPanel.setMaximumSize(new java.awt.Dimension(1040, 540));
        MusicPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 153, 255));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MusicPanel.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 19, 550, 20));

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setToolTipText("");
        jScrollPane1.setAlignmentX(20.0F);
        jScrollPane1.setAlignmentY(20.0F);
        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setFocusable(false);
        jScrollPane1.setOpaque(false);
        jScrollPane1.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jScrollPane1MouseWheelMoved(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 153, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAlignmentX(20.0F);
        jTable1.setAlignmentY(20.0F);
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.setFocusable(false);
        jTable1.setOpaque(false);
        jTable1.setRowHeight(30);
        jTable1.setRowMargin(0);
        jTable1.setSelectionBackground(new java.awt.Color(0, 0, 0));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.setShowHorizontalLines(false);
        jTable1.setShowVerticalLines(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable1MouseEntered(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        MusicPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 643, 270));

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Next.png"))); // NOI18N
        jLabel23.setToolTipText("Next Song");
        jLabel23.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel23MouseReleased(evt);
            }
        });
        MusicPanel.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 440, 60, 50));

        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Loop.png"))); // NOI18N
        jLabel37.setToolTipText("Turn On Loop");
        jLabel37.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel37MouseReleased(evt);
            }
        });
        MusicPanel.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 440, 60, 50));

        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Play.png"))); // NOI18N
        jLabel38.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel38MouseReleased(evt);
            }
        });
        MusicPanel.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 440, 60, 50));

        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Stop.png"))); // NOI18N
        jLabel35.setToolTipText("Stop Music");
        jLabel35.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel35MouseReleased(evt);
            }
        });
        MusicPanel.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 440, 60, 50));

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Back.png"))); // NOI18N
        jLabel28.setToolTipText("Previous Song");
        jLabel28.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel28MouseReleased(evt);
            }
        });
        MusicPanel.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 440, 60, 50));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("x");
        jLabel36.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel36MouseReleased(evt);
            }
        });
        MusicPanel.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, -2, 40, 40));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("x");
        jLabel29.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel29MouseReleased(evt);
            }
        });
        MusicPanel.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, -2, 40, 40));

        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MusicBG.png"))); // NOI18N
        MusicPanel.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 720, 370));

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 153, 255));
        jLabel30.setText("Project Jarvis");
        MusicPanel.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 90, 40));

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/TitleBar.png"))); // NOI18N
        MusicPanel.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -6, 1040, 50));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Wallpaper/WallpaperThree.png"))); // NOI18N
        jLabel32.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel32MouseDragged(evt);
            }
        });
        jLabel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel32MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel32MouseReleased(evt);
            }
        });
        MusicPanel.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 540));

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Wallpaper/WallpaperFour.png"))); // NOI18N
        jLabel34.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel34MouseDragged(evt);
            }
        });
        jLabel34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel34MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel34MouseReleased(evt);
            }
        });
        MusicPanel.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 540));

        getContentPane().add(MusicPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 540));

        setSize(new java.awt.Dimension(1040, 540));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseReleased
        System.exit(0);
    }//GEN-LAST:event_jLabel4MouseReleased

    private void jLabel5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseReleased
        this.setState(ICONIFIED);
    }//GEN-LAST:event_jLabel5MouseReleased

    private void jLabel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseReleased
       
        
    }//GEN-LAST:event_jLabel1MouseReleased

    private void jLabel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseDragged
       int x = evt.getXOnScreen();
       int y = evt.getYOnScreen();
       this.setLocation(x-xMouse,y-yMouse);
    }//GEN-LAST:event_jLabel1MouseDragged

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel9MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseDragged

    private void jLabel9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MousePressed

    private void jLabel9MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseReleased

    private void jLabel10MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseReleased
     WallpaperPanel.setVisible(false);
     MenuPanel.setVisible(true);
    }//GEN-LAST:event_jLabel10MouseReleased

    private void jLabel12MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseReleased
        WallpaperPanel.setVisible(true);
        MenuPanel.setVisible(false);
    }//GEN-LAST:event_jLabel12MouseReleased

    private void jLabel22MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseReleased
       MenuPanel.setVisible(true);
       WallpaperPanel.setVisible(false);
       MailPanel.setVisible(false);
    }//GEN-LAST:event_jLabel22MouseReleased

    private void jLabel26MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseDragged
       int x = evt.getXOnScreen();
       int y = evt.getYOnScreen();
       this.setLocation(x-xMouse,y-yMouse);
    }//GEN-LAST:event_jLabel26MouseDragged

    private void jLabel26MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MousePressed
        xMouse = evt.getX();
        yMouse =evt.getY();
    }//GEN-LAST:event_jLabel26MousePressed

    private void jLabel26MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel26MouseReleased

    private void jLabel21MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseReleased
       MenuPanel.setVisible(false);
       WallpaperPanel.setVisible(false);
       MailPanel.setVisible(true);
       ConfigPanel.setVisible(false);
    }//GEN-LAST:event_jLabel21MouseReleased

    private void jLabel29MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel29MouseReleased

    private void jLabel32MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xMouse,y-yMouse);
    }//GEN-LAST:event_jLabel32MouseDragged

    private void jLabel32MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MousePressed
        xMouse = evt.getX();
        yMouse =evt.getY();
    }//GEN-LAST:event_jLabel32MousePressed

    private void jLabel32MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel32MouseReleased

    private void jLabel34MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel34MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xMouse,y-yMouse);
    }//GEN-LAST:event_jLabel34MouseDragged

    private void jLabel34MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel34MousePressed
        xMouse = evt.getX();
        yMouse =evt.getY();
    }//GEN-LAST:event_jLabel34MousePressed

    private void jLabel34MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel34MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel34MouseReleased

    private void jLabel36MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel36MouseReleased
       MenuPanel.setVisible(true);
       WallpaperPanel.setVisible(false);
       MailPanel.setVisible(false);
       MusicPanel.setVisible(false);
       ConfigPanel.setVisible(false);
    }//GEN-LAST:event_jLabel36MouseReleased

    private void jLabel39MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseReleased
        MenuPanel.setVisible(false);
        WallpaperPanel.setVisible(false);
        MailPanel.setVisible(false);
        MusicPanel.setVisible(true);
        ConfigPanel.setVisible(false);
    }//GEN-LAST:event_jLabel39MouseReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if(evt.getClickCount()==2)
       {
            index = jTable1.getSelectedRow();
            model = jTable1.getModel();
            String name = model.getValueAt(index, 0).toString();
            String fname = musicLocation+name;
            System.out.println(fname);
            MUSIC.play(fname);
            String songName = name;
           
            if(songName.length()>70)
            {
                songName = songName.substring(0,70);
                songName = songName + "...";
            }
            
            jLabel40.setText("");
            jLabel40.setText("<html><body><b><font color=\"22B14C\" >Song Playing : </font></b> " + songName+ "</body</html>");
            musicPlaying = "true";
            jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Pause.png")));
            jLabel38.setToolTipText("Pause Music");
            mp3();
       }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased

    }//GEN-LAST:event_jTable1MouseReleased

    private void jScrollPane1MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jScrollPane1MouseWheelMoved

    }//GEN-LAST:event_jScrollPane1MouseWheelMoved

    private void jTable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseEntered

    private void jLabel38MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel38MouseReleased
         if(musicPlaying.equals("true"))
        {
             jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Play.png")));
             MUSIC.pause();
             jLabel38.setToolTipText("Play Music");
             musicPlaying= "false";
            String songName = arr.get(index);
            if(songName.length()>70)
            {
                songName = songName.substring(0,70);
                songName = songName + "...";
            }
             jLabel40.setText("<html><body><b><font color=\"22B14C\" >Song Paused : </font></b> " + songName+ "</body</html>");
        }else if(musicPlaying.equals("false"))
        {
        index = jTable1.getSelectedRow();
        model = jTable1.getModel();
        String name = model.getValueAt(index, 0).toString();
        String fname = musicLocation+name;
        MUSIC.resume();
        musicPlaying = "true";
        jLabel38.setToolTipText("Pause Music");
        String songName = arr.get(index);
            if(songName.length()>70)
            {
                songName = songName.substring(0,70);
                songName = songName + "...";
            }
        jLabel40.setText("<html><body><b><font color=\"22B14C\" >Song Playing : </font></b> " + songName+ "</body</html>");
        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Pause.png")));
        }else
        {
           
            jLabel38.setToolTipText("Pause Music");
            index = jTable1.getSelectedRow();
            model = jTable1.getModel();
            String name = model.getValueAt(index, 0).toString();
            String fname = musicLocation+name;
            MUSIC.play(fname);
            String songName = arr.get(index);
            if(songName.length()>70)
            {
                songName = songName.substring(0,70);
                songName = songName + "...";
            }
            jLabel40.setText("<html><body><b><font color=\"22B14C\" >Song Playing : </font></b> " + songName+ "</body</html>");
            musicPlaying = "true";
            jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Pause.png")));
            mp3();
        }
    }//GEN-LAST:event_jLabel38MouseReleased

    private void jLabel28MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseReleased
       if(index>0)
              jLabel40.setText("");
            MUSIC.play(musicLocation+arr.get(--index));
            String songName = arr.get(index);
            if(songName.length()>70)
            {
                songName = songName.substring(0,70);
                songName = songName + "...";
            }
            jLabel40.setText("<html><body><b><font color=\"22B14C\">Song Playing : </font></b> " + songName+ "</body</html>");
            jTable1.changeSelection(index, 0, false, true);
            jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Pause.png")));
            mp3();
    }//GEN-LAST:event_jLabel28MouseReleased

    private void jLabel23MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseReleased
         if(index>=0 && index<=arr.size())
        {
            
           jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Pause.png")));
           MUSIC.play(musicLocation+arr.get(++index));
           jLabel40.setText("");
           String songName = arr.get(index);
            if(songName.length()>70)
            {
                songName = songName.substring(0,70);
                songName = songName + "...";
            }
           jLabel40.setText("<html><body><b><font color=\"22B14C\" >Song Playing : </font></b> " + songName+ "</body</html>");
           jTable1.changeSelection(index, 0, false, true);
           mp3();
        }
    }//GEN-LAST:event_jLabel23MouseReleased

    private void jLabel35MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseReleased
        MUSIC.stop();
        jLabel40.setText("");
       
        musicPlaying = "";
        jLabel37.setToolTipText("Turn On Loop");
        count = 0;
        jLabel38.setToolTipText("Play Music");
        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Play.png")));
    }//GEN-LAST:event_jLabel35MouseReleased

    private void jLabel37MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseReleased
        switch(count)
        {
        
            case  0 : 
                count = 1;
                jLabel37.setToolTipText("Turn Off Loop");
               break;
            case 1 :
                count = 0;
                jLabel37.setToolTipText("Turn On Loop");
                break;
        }
    }//GEN-LAST:event_jLabel37MouseReleased

    private void jLabel46MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel46MouseReleased
        String music = jTextField2.getText();
        if(getMusicLoc.equals(music))
        {
            System.out.println("Music Location Not Changed");
        
        }
        else
        {
            refreshMusic();
        }

        MenuPanel.setVisible(true);
        WallpaperPanel.setVisible(false);
        MailPanel.setVisible(false);
        MusicPanel.setVisible(false);
        ConfigPanel.setVisible(false);
        jLabel43.setText("");
        
        
        
    }//GEN-LAST:event_jLabel46MouseReleased

    private void jLabel50MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel50MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel50MouseReleased

    private void jLabel50MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel50MousePressed
        xMouse = evt.getX();
        yMouse =evt.getY();
    }//GEN-LAST:event_jLabel50MousePressed

    private void jLabel50MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel50MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x-xMouse,y-yMouse);

    }//GEN-LAST:event_jLabel50MouseDragged

    private void jLabel42MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel42MouseReleased
        MenuPanel.setVisible(false);
        WallpaperPanel.setVisible(false);
        MailPanel.setVisible(false);
        MusicPanel.setVisible(false);
        ConfigPanel.setVisible(true);
        getMusicLoc = jTextField2.getText();
        
        
    }//GEN-LAST:event_jLabel42MouseReleased

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jLabel41MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel41MouseReleased
        Properties prop = new Properties();
        try 
        {
            if(jTextField2.getText().equals(""))
            {
                prop.put("MusicLocation", System.getProperty("user.home")+"\\Music");
            }else
            {
                prop.put("MusicLocation",jTextField2.getText()+"");
            }
            
            
            if(jTextField8.getText().equals(""))
            {
                prop.put("Facebook", "www.facebook.com");
            }else
            {
                 prop.put("Facebook",jTextField8.getText()+"");
            }
            
           if(jTextField5.getText().equals(""))
            {
                prop.put("Twitter", "www.twitter.com");
            }else
            {
                 prop.put("Twitter", jTextField5.getText()+"");
            }
           
             if(jTextField6.getText().equals(""))
            {
                 prop.put("Whatsapp", "www.web.whatsapp..com");
            }else
            {
                 prop.put("Whatsapp", jTextField6.getText()+"");
            }
             
           if(jTextField7.getText().equals(""))
            {
                prop.put("Youtube", "www.youtube.com");
            }else
            {
               prop.put("Youtube", jTextField7.getText()+"");
            }
           
           
            prop.put("GmailID", jTextField4.getText()+"");
            prop.put("Password", jTextField3.getText()+"");
            
            prop.store(new FileOutputStream("Configuration.config"), null);
        } 
        catch (IOException e) 
        {
        }
          jLabel43.setText("<html><body><b><font color=\"22B14C\" >Message : </font></b>Configuration saved successfully.</body</html>");
    }//GEN-LAST:event_jLabel41MouseReleased

    private void jLabel20MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseReleased
        SendEmail mail = new SendEmail(jTextField9.getText(), jTextField10.getText(), jTextArea1.getText());
    }//GEN-LAST:event_jLabel20MouseReleased
 
   
    public static void main(String args[]) 
    {
       try 
        {
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
        } 
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) 
        {
        }
       
       java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run() 
            {
                new HomeGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ConfigPanel;
    private javax.swing.JPanel MailPanel;
    private javax.swing.JPanel MenuPanel;
    private javax.swing.JPanel MusicPanel;
    private javax.swing.JPanel WallpaperPanel;
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
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    public static javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    public static javax.swing.JTextField jTextField3;
    public static javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
