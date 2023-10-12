/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Math;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.ValueAxis;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;

/**
 *
 * @author hp
 */
public class mainFrame extends javax.swing.JFrame {

    static Connection conn;
    static Statement st;
    String attachment_path;
    public static String tableName = "readings";
    
    /**
     * Creates new form mainFrame
     */
    public mainFrame() {
        initComponents();
        mann.setSelected(true);
        voltRelay.setSelected(true);
        sampleFreq.setEnabled(false);
        ta2.append(mann.getText() + "\n\n");
        ta2.append("In this example, we create a Font object with the desired style (in this case, Font.BOLD) and apply it to the JLabel using the setFont method. "
                + "This will make the text in the JLabel appear in bold. You can adjust the font size, style, and other "
                + "properties as needed to customize the appearance of your text.");    
    }
    
    private static JFreeChart createChart(String title, String xAxisLabel, String yAxisLabel, JDBCCategoryDataset dataset) {
            JFreeChart chart = ChartFactory.createLineChart(title, xAxisLabel, yAxisLabel, dataset, PlotOrientation.VERTICAL, true, true, false);
            CategoryPlot plot = chart.getCategoryPlot();
            plot.setBackgroundPaint(Color.BLACK);
            org.jfree.chart.axis.CategoryAxis domainAxis = plot.getDomainAxis();
            org.jfree.chart.axis.ValueAxis rangeAxis = plot.getRangeAxis();

            // Set the domain (X) axis label color to white
            domainAxis.setLabelPaint(Color.BLACK);
            domainAxis.setTickLabelPaint(Color.BLACK);

            // Set the range (Y) axis label color to white
            rangeAxis.setLabelPaint(Color.BLACK);
            rangeAxis.setTickLabelPaint(Color.BLACK);
        return chart;
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        parentPanel = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();
        control = new javax.swing.JPanel();
        start = new javax.swing.JButton();
        sampleFreq = new javax.swing.JTextField();
        plotGraph = new javax.swing.JButton();
        lbl1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        upload = new javax.swing.JButton();
        threesample = new javax.swing.JRadioButton();
        mann = new javax.swing.JRadioButton();
        voltRelay = new javax.swing.JRadioButton();
        currRelay = new javax.swing.JRadioButton();
        tn = new javax.swing.JLabel();
        tn1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ta = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta2 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CyberGrid Gaurdian");
        setBackground(new java.awt.Color(0, 0, 0));

        parentPanel.setBackground(new java.awt.Color(21, 36, 60));
        parentPanel.setForeground(new java.awt.Color(255, 255, 255));
        parentPanel.setPreferredSize(new java.awt.Dimension(1790, 660));
        parentPanel.setLayout(new java.awt.BorderLayout());

        mainPanel.setBackground(new java.awt.Color(21, 36, 60));

        control.setBackground(new java.awt.Color(21, 36, 60));
        control.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), "Control Panel", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 16), new java.awt.Color(255, 255, 255))); // NOI18N
        control.setForeground(new java.awt.Color(204, 204, 204));
        control.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        start.setBackground(new java.awt.Color(255, 255, 255));
        start.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        start.setText("Start");
        start.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        start.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                startMouseEntered(evt);
            }
        });
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });
        control.add(start, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 920, 60));

        sampleFreq.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        sampleFreq.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        sampleFreq.setText("50000");
        sampleFreq.setBorder(null);
        control.add(sampleFreq, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 210, 30));

        plotGraph.setBackground(new java.awt.Color(255, 255, 255));
        plotGraph.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        plotGraph.setText("Plot Graph");
        plotGraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plotGraphActionPerformed(evt);
            }
        });
        control.add(plotGraph, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, 433, 63));

        lbl1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        lbl1.setForeground(new java.awt.Color(255, 255, 0));
        lbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl1.setText("Click \"Start\" to process");
        control.add(lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 433, 53));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sampling Frequency:");
        control.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 190, 30));

        upload.setBackground(new java.awt.Color(255, 255, 255));
        upload.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        upload.setText("Attach CSV File");
        upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadActionPerformed(evt);
            }
        });
        control.add(upload, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, 433, 63));

        threesample.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(threesample);
        threesample.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        threesample.setForeground(new java.awt.Color(255, 255, 255));
        threesample.setText("Three Sample Technique");
        threesample.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        threesample.setOpaque(false);
        control.add(threesample, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, 430, 60));

        mann.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(mann);
        mann.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        mann.setForeground(new java.awt.Color(255, 255, 255));
        mann.setText("Mann Morrison Technique");
        mann.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        mann.setOpaque(false);
        control.add(mann, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 430, 60));

        voltRelay.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(voltRelay);
        voltRelay.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        voltRelay.setForeground(new java.awt.Color(255, 255, 255));
        voltRelay.setText("Over Voltage Relay");
        voltRelay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        voltRelay.setOpaque(false);
        control.add(voltRelay, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 440, 30));

        currRelay.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup2.add(currRelay);
        currRelay.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        currRelay.setForeground(new java.awt.Color(255, 255, 255));
        currRelay.setText("Over Current Relay");
        currRelay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        currRelay.setOpaque(false);
        control.add(currRelay, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, 430, 30));

        tn.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        tn.setForeground(new java.awt.Color(255, 255, 255));
        tn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tn.setText("readings");
        control.add(tn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 270, 60));

        tn1.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        tn1.setForeground(new java.awt.Color(255, 255, 255));
        tn1.setText("Default Table :");
        control.add(tn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 150, 60));

        ta.setEditable(false);
        ta.setColumns(20);
        ta.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        ta.setLineWrap(true);
        ta.setRows(5);
        ta.setText("Result:\n");
        ta.setWrapStyleWord(true);
        jScrollPane2.setViewportView(ta);

        ta2.setEditable(false);
        ta2.setBackground(new java.awt.Color(216, 213, 213));
        ta2.setColumns(20);
        ta2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ta2.setLineWrap(true);
        ta2.setRows(5);
        ta2.setWrapStyleWord(true);
        ta2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(ta2);

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CyberGrid: Gaurdian");

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Made by: Atharva Sandip Joshi (31)");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(control, javax.swing.GroupLayout.PREFERRED_SIZE, 981, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(control, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
        );

        parentPanel.add(mainPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(parentPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void uploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadActionPerformed
        // TODO add your handling code here:
        JFileChooser file = new JFileChooser();
        file.showOpenDialog(null);
        File f = file.getSelectedFile();
        String filename = f.getAbsolutePath();
        if (f != null) { // Check if a file was selected
            String fileNameWithExtension = f.getName();
            int dotIndex = fileNameWithExtension.lastIndexOf('.');
            String files = (dotIndex == -1) ? fileNameWithExtension : fileNameWithExtension.substring(0, dotIndex);
            //System.out.println("File Name without Extension: " + files);
            tn1.setText("Selected Table :");
            tn.setText(files.toLowerCase());
            tableName = files.toLowerCase();
                try {
                    Class.forName("java.sql.Driver");
                    conn = DriverManager.getConnection("jdbc:mysql://localhost/cyberGrid","root","root");
                    st = conn.createStatement();
                    String createTable = "CREATE TABLE IF NOT EXISTS "+ tableName +" ( row_id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                                            "    sampTime DOUBLE,\n" +
                                            "    Vt DOUBLE,\n" +
                                            "    It DOUBLE,\n" +
                                            "    time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,\n" +
                                            "    Vm DOUBLE,\n" +
                                            "    Im DOUBLE,\n" +
                                            "    voltageRelay TINYINT(1) DEFAULT 0,\n" +
                                            "    currentRelay TINYINT(1) DEFAULT 0\n" +
                                        ");";
                    st.execute(createTable);
                } catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
            }
        }
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while((line = br.readLine())!= null){
                String[] value = line.split(",");
                System.out.println("Value 1 :"+value[0]+"Value 2 :"+value[1]+"Value 3 :"+value[2]);
                String sql = "INSERT INTO "+ tableName +" (sampTime, Vt, It) VALUES('"+value[1]+"','"+value[2]+"','"+value[3]+"');";
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.executeUpdate();
            }
            br.close();
        } catch (Exception e ) {
            JOptionPane.showMessageDialog(null, e);
        }

        lbl1.setText("Suucessful Action..");
        new table().setVisible(true);
    }//GEN-LAST:event_uploadActionPerformed

    private void plotGraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plotGraphActionPerformed
        // TODO add your handling code here:
        if(voltRelay.isSelected()){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost/cyberGrid", "root", "root");
                st = conn.createStatement();
                String stmt = "SELECT sampTime, Vt, It, Vm\n" +
                                    "FROM "+ tableName +"\n" +
                                    "WHERE sampTime <= (\n" +
                                    "    SELECT MAX(sampTime)\n" +
                                    "    FROM readings\n" +
                                    "    WHERE voltageRelay = true\n" +
                                ");";
                ResultSet rs = st.executeQuery(stmt);
                if (!rs.next()) {
                    // The result set is empty, so change the query
                    stmt = "SELECT sampTime, Vt, It from " + tableName;
                    rs = st.executeQuery(stmt);
                }
                JDBCCategoryDataset dataset = new JDBCCategoryDataset(conn, stmt);
                JFreeChart chart = createChart("Over Voltage Relay", "Sampling Time", "Current/Voltage", dataset);
                ChartPanel chartPanel = new ChartPanel(chart);
                
                // Create and display the main frame
                JFrame frame = new JFrame("Chart Example");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setBackground(Color.BLACK);
                frame.setForeground(Color.WHITE);
    
                // Add the chart panel to the frame
                frame.getContentPane().add(chartPanel);
                frame.setVisible(true);
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }else if(currRelay.isSelected()){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost/cyberGrid", "root", "root");
                st = conn.createStatement();
                String stmt = "SELECT sampTime, Vt, It, Im\n" +
                                    "FROM readings\n" +
                                    "WHERE sampTime <= (\n" +
                                    "    SELECT MAX(sampTime)\n" +
                                    "    FROM readings\n" +
                                    "    WHERE currentRelay = true\n" +
                                ");";
                ResultSet rs = st.executeQuery(stmt);
                if (!rs.next()) {
                    // The result set is empty, so change the query
                    stmt = "SELECT sampTime, Vt, It from " + tableName;
                    rs = st.executeQuery(stmt);
                }
                JDBCCategoryDataset dataset = new JDBCCategoryDataset(conn, stmt);
                JFreeChart chart = createChart("Over Current Relay", "Sampling Time", "Current/Voltage", dataset);
                ChartPanel chartPanel = new ChartPanel(chart);
                
                // Create and display the main frame
                JFrame frame = new JFrame("Chart Example");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setSize(800, 600);
                frame.setBackground(Color.BLACK);
                frame.setForeground(Color.WHITE);
    
                // Add the chart panel to the frame
                frame.getContentPane().add(chartPanel);
                frame.setVisible(true);
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_plotGraphActionPerformed

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
        // TODO add your handling code here:
        // MANN MORRISON TECHNIQUE + VOLTAGE RELAY SELECTED
        if(mann.isSelected() && voltRelay.isSelected()){
            ta.append("MANN MORRISON TECHNIQUE + VOLTAGE RELAY SELECTED \n CONNECTED DATABASE: "+ tableName +"\n Processing Started\n");
            boolean isfault = false;
            double f = Integer.parseInt(sampleFreq.getText());
            //double deltaT = 1/f;
            final double omega = 314.159265;
            try{
                Class.forName("java.sql.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/cyberGrid","root","root");
                st = conn.createStatement();
                String stmt="SELECT Vt FROM " + tableName + " ;";
                st.executeQuery(stmt);
                String sql=stmt;
                ResultSet rs = st.executeQuery(sql);
                ta.append("Connection Established\n");
                rs.next();
                double prev, curr, nxt;
                prev = rs.getDouble("Vt");
                rs.next();
                curr = rs.getDouble("Vt");
                rs.next();
                nxt = rs.getDouble("Vt");
                rs.next();

                System.out.println("prev "+prev);
                System.out.println("curr "+curr);
                System.out.println("next "+nxt);

                while(isfault != true){
                    double diff = (nxt - prev);
                    //System.out.println("difference "+diff);
                    //ta.append("difference "+diff + "\n");
                    double vDash1 = diff/(0.00004);
                    //System.out.println("vdash1 "+vDash1);
                    //ta.append("vdash1 "+vDash1 + "\n");
                    double vDash = vDash1/omega;
                    //System.out.println("vDash "+vDash);
                    //ta.append("vDash "+vDash + "\n");
                    double vmsq = Math.pow(vDash, 2);
                    //System.out.println("vmsq "+vmsq);
                    //ta.append("vmsq "+vmsq + "\n");
                    double vtsq = Math.pow(curr, 2);
                    //System.out.println("vtsq "+vtsq);
                    //ta.append("vtsq "+vtsq + "\n");
                    double addition = vmsq+vtsq;
                    //System.out.println("add "+addition);
                    //ta.append("add "+addition + "\n");
                    double vm = Math.sqrt(addition);
                    //System.out.println("Vm "+vm);
                    //ta.append("Vm "+vm + "\n");
                    //double tValue = Math.floor(vm);
                    System.out.println("Final Answer "+vm);
                    ta.append("Vm : "+vm+ " at Vt :" + curr + "\n");

                    if(vm >= 230.00){
                        isfault = true;
                        ta.append("FAULT OCCURED at " + curr + " Vm is " + vm);
                        ta.setForeground(Color.red);
                        lbl1.setText("Fault Detected !!!");
                        lbl1.setForeground(Color.RED);
                        lbl1.setVisible(true);
                        // Update the isFault column to true
                        String updateFaultSql = "UPDATE " + tableName + " SET voltageRelay = true, sampTime = CURRENT_TIMESTAMP, Vm =" + vm + "WHERE Vt =" + nxt;
                        st.executeUpdate(updateFaultSql);
                        new table().setVisible(true);
                        break;
                    }
                    prev = curr;
                    curr = nxt;
                    nxt = rs.getDouble("Vt");
                    rs.next();
                    ta.setForeground(Color.green);

                    System.out.println("prev2 "+prev);
                    System.out.println("curr2 "+curr);
                    System.out.println("next2 "+nxt);
                    
                    lbl1.setText("No Fault Detected");
                    lbl1.setForeground(Color.GREEN);
                    lbl1.setVisible(true);
                }
            }catch(Exception e){
                System.out.print(e);
            }
        }
        // MANN MORRISON TECHNIQUE + CURRENT RELAY SELECTED
        else if(mann.isSelected() && currRelay.isSelected()){
            ta.append("MANN MORRISON TECHNIQUE + CURRENT RELAY SELECTED \n CONNECTED DATABASE: "+ tableName +"\n Processing Started\n");
            boolean isfault = false;
            double f = Integer.parseInt(sampleFreq.getText());
            double deltaT = 1/f;
            final double omega = 314.159265;
            try{
                Class.forName("java.sql.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/cyberGrid","root","root");
                st = conn.createStatement();
                String stmt="SELECT It FROM " + tableName;
                st.executeQuery(stmt);
                String sql=stmt;
                ResultSet rs = st.executeQuery(sql);
                ta.append("Connection Established\n");
                rs.next();
                double prev, curr, nxt;
                prev = rs.getDouble("It");
                rs.next();
                curr = rs.getDouble("It");
                rs.next();
                nxt = rs.getDouble("It");
                rs.next();

                System.out.println("prev "+prev);
                System.out.println("curr "+curr);
                System.out.println("next "+nxt);

                while(isfault != true){
                    double diff = (nxt - prev);
                    //System.out.println("difference "+diff);
                    double iDash1 = diff/(0.00004);
                    //System.out.println("Idash1 "+iDash1);
                    double iDash = iDash1/omega;
                    //System.out.println("IDash "+iDash);
                    double imsq = Math.pow(iDash, 2);
                    //System.out.println("Imsq "+imsq);
                    double itsq = Math.pow(curr, 2);
                    //System.out.println("Itsq "+itsq);
                    double addition = imsq+itsq;
                    //System.out.println("add "+addition);
                    double im = Math.sqrt(addition);
                    //System.out.println("Im "+im);
                    System.out.println("Final Answer "+im);
                    ta.append("Im : "+im+ " at It :" + curr + "\n");

                    if(im >= 40.00){
                        isfault = true;
                        ta.append("FAULT OCCURED at " + curr + " Im is " + im);
                        ta.setForeground(Color.red);
                        lbl1.setText("Fault Detected !!!");
                        lbl1.setForeground(Color.RED);
                        lbl1.setVisible(true);
                        // Update the isFault column to true
                        String updateFaultSql = "UPDATE " + tableName + " SET currentRelay = true, , sampTime = CURRENT_TIMESTAMP, Im =" + im + "WHERE It =" + nxt;
                        st.executeUpdate(updateFaultSql);
                        new table().setVisible(true);
                        break;
                    }
                    prev = curr;
                    curr = nxt;
                    nxt = rs.getDouble("It");
                    rs.next();
                    ta.setForeground(Color.green);

                    System.out.println("prev2 "+prev);
                    System.out.println("curr2 "+curr);
                    System.out.println("next2 "+nxt);
                    
                    lbl1.setText("No Fault Detected");
                    lbl1.setForeground(Color.GREEN);
                    lbl1.setVisible(true);
                }
            }catch(Exception e){
                System.out.print(e);
            }
        }

        // THREE SAMPLE TECHNIQUE + VOLTAGE RELAY SELECTED
        else if(threesample.isSelected() && voltRelay.isSelected()){
            ta.append("THREE SAMPLE TECHNIQUE + VOLTAGE RELAY SELECTED \n Processing Started\n");
            boolean isfault = false;
            double f = Integer.parseInt(sampleFreq.getText());
            double deltaT = 1/f;
            final double omega = 314.159265;
            try{
                Class.forName("java.sql.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/cyberGrid","root","root");
                st = conn.createStatement();
                String stmt="SELECT Vt FROM readings";
                st.executeQuery(stmt);
                String sql=stmt;
                ResultSet rs = st.executeQuery(sql);
                ta.append("Connection Established\n");
                rs.next();
                double prev, curr, nxt;
                prev = rs.getDouble("Vt");
                rs.next();
                curr = rs.getDouble("Vt");
                rs.next();
                nxt = rs.getDouble("Vt");
                rs.next();

                System.out.println("prev "+prev);
                System.out.println("curr "+curr);
                System.out.println("next "+nxt);

                while(isfault != true){
                    double diff = (nxt - prev);
                    System.out.println("difference "+diff);
                    double vDash1 = diff/(0.00004);
                    System.out.println("vdash1 "+vDash1);
                    double vDash = vDash1/omega;
                    System.out.println("vDash "+vDash);
                    double vmsq = Math.pow(vDash, 2);
                    System.out.println("vmsq "+vmsq);
                    double vtsq = Math.pow(curr, 2);
                    System.out.println("vtsq "+vtsq);
                    double addition = vmsq+vtsq;
                    System.out.println("add "+addition);
                    double vm = Math.sqrt(addition);
                    System.out.println("Vm "+vm);
                    double tValue = Math.floor(vm);
                    System.out.println("Final Answer "+tValue);
                    ta.append("Vm : "+tValue+ " at Vt :" + curr + "\n");

                    if(tValue > 500.00){
                        isfault = true;
                        ta.append("FAULT OCCURED at " + curr + " Vm is " + tValue);
                        ta.setForeground(Color.red);
                        lbl1.setVisible(true);
                        break;
                    }
                    prev = curr;
                    curr = nxt;
                    rs.next();
                    nxt = rs.getDouble("Vt");
                    ta.setForeground(Color.green);

                    System.out.println("prev2 "+prev);
                    System.out.println("curr2 "+curr);
                    System.out.println("next2 "+nxt);
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }

        // THREE SAMPLE TECHNIQUE + CURRENT RELAY SELECTED
        else if(threesample.isSelected() && currRelay.isSelected()){
            ta.append("THREE SAMPLE TECHNIQUE + CURRENT RELAY SELECTED \n Processing Started\n");
            boolean isfault = false;
            double f = Integer.parseInt(sampleFreq.getText());
            double deltaT = 1/f;
            final double omega = 314.159265;
            try{
                Class.forName("java.sql.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/cyberGrid","root","root");
                st = conn.createStatement();
                String stmt="SELECT Vt FROM readings";
                st.executeQuery(stmt);
                String sql=stmt;
                ResultSet rs = st.executeQuery(sql);
                ta.append("Connection Established\n");
                rs.next();
                double prev, curr, nxt;
                prev = rs.getDouble("Vt");
                rs.next();
                curr = rs.getDouble("Vt");
                rs.next();
                nxt = rs.getDouble("Vt");
                rs.next();

                System.out.println("prev "+prev);
                System.out.println("curr "+curr);
                System.out.println("next "+nxt);

                while(isfault != true){
                    double diff = (nxt - prev);
                    System.out.println("difference "+diff);
                    double vDash1 = diff/(0.00004);
                    System.out.println("vdash1 "+vDash1);
                    double vDash = vDash1/omega;
                    System.out.println("vDash "+vDash);
                    double vmsq = Math.pow(vDash, 2);
                    System.out.println("vmsq "+vmsq);
                    double vtsq = Math.pow(curr, 2);
                    System.out.println("vtsq "+vtsq);
                    double addition = vmsq+vtsq;
                    System.out.println("add "+addition);
                    double vm = Math.sqrt(addition);
                    System.out.println("Vm "+vm);
                    double tValue = Math.floor(vm);
                    System.out.println("Final Answer "+tValue);
                    ta.append("Vm : "+tValue+ " at Vt :" + curr + "\n");

                    if(tValue > 500.00){
                        isfault = true;
                        ta.append("FAULT OCCURED at " + curr + " Vm is " + tValue);
                        ta.setForeground(Color.red);
                        lbl1.setVisible(true);
                        break;
                    }
                    prev = curr;
                    curr = nxt;
                    rs.next();
                    nxt = rs.getDouble("Vt");
                    ta.setForeground(Color.green);

                    System.out.println("prev2 "+prev);
                    System.out.println("curr2 "+curr);
                    System.out.println("next2 "+nxt);
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_startActionPerformed

    private void startMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_startMouseEntered
        // TODO add your handling code here:
        start.setBackground(Color.yellow);
    }//GEN-LAST:event_startMouseEntered

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
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JPanel control;
    private javax.swing.JRadioButton currRelay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JRadioButton mann;
    private javax.swing.JPanel parentPanel;
    private javax.swing.JButton plotGraph;
    private javax.swing.JTextField sampleFreq;
    private javax.swing.JButton start;
    private javax.swing.JTextArea ta;
    private javax.swing.JTextArea ta2;
    private javax.swing.JRadioButton threesample;
    private javax.swing.JLabel tn;
    private javax.swing.JLabel tn1;
    private javax.swing.JButton upload;
    private javax.swing.JRadioButton voltRelay;
    // End of variables declaration//GEN-END:variables
}
