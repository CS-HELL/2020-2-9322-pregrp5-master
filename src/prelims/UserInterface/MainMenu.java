package prelims.UserInterface;

import prelims.TextAreaOutputStream;
import prelims.UserInterface.AccountManagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.Socket;
import java.util.*;

public class MainMenu extends javax.swing.JFrame {

    // Socket

    private static Socket clientSocket;
    private static int PORT = 8888;
    private PrintWriter outWriter;
    private String clientName;
    private final Image icon = Toolkit.getDefaultToolkit().getImage("res\\client.png");

    private javax.swing.JLabel jLoggedInLabel;

    public static String userInputIpAddress;

    // Variables declaration
    private javax.swing.JButton jSendMessageButton;
    private javax.swing.JButton jListButton;
    private javax.swing.JButton jExitButton;
    private javax.swing.JButton jRoomButton;
    private javax.swing.JButton jManageButton;

    private javax.swing.JTabbedPane jMainMenuTabbedPane;

    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;

    private javax.swing.JMenuBar jMenuBar1;

    private javax.swing.JMenuItem jManageAccountMenuItem;
    private javax.swing.JMenuItem jExitMenuItem;

    private javax.swing.JTextField jMessageField;
    public javax.swing.JTextField jUsernameField;

    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;

    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;

    public javax.swing.JTextArea jChatArea;

    private javax.swing.JPanel jUserListPane;

    public JList<Object> jofflineList;
    public static JList<String> jonlineList;

    public static ArrayList<String> jonlineArrayList;
    // End of variables declaration

    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        initComponents();

        try{
            userInputIpAddress = JOptionPane.showInputDialog("Enter Server's IP Address.");
            clientName = SignInWindowUI.username.trim();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cannot connect to the server!", "Error!", JOptionPane.WARNING_MESSAGE);
            System.exit(1);
            e.printStackTrace();
        }
    }

    /**
     * MainMenu's main Frame and components.
     */
    private void initComponents() {
        jMenu2 = new javax.swing.JMenu();
        jUserListPane = new javax.swing.JPanel();
        jMainMenuTabbedPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jonlineList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jofflineList = new javax.swing.JList<>();
        jLoggedInLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jChatArea = new javax.swing.JTextArea();
        jMessageField = new javax.swing.JTextField();
        jUsernameField = new javax.swing.JTextField();
        jSendMessageButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jManageAccountMenuItem = new javax.swing.JMenuItem();
        jExitMenuItem = new javax.swing.JMenuItem();
        jRoomButton = new javax.swing.JButton();
        jManageButton = new javax.swing.JButton();
        jExitButton = new javax.swing.JButton();
        jListButton = new javax.swing.JButton();

        setResizable(false);
        jChatArea.setEditable(false);
        jChatArea.setLineWrap(true);
        jChatArea.setWrapStyleWord(true);

        setIconImage(icon);

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMainMenuTabbedPane.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMainMenuTabbedPane.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N

        jRoomButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jRoomButton.setText("Join a Room");
        /*jRoomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRoomButtonActionPerformed(evt);
            }
        });*/
        jRoomButton.setVisible(false);

        jManageButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jManageButton.setText("Manage Account");
        jManageButton.addActionListener(this::jManageButtonActionPerformed);

        jExitButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jExitButton.setText("Logout");
        jExitButton.addActionListener(this::jExitButtonActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setBackground(new java.awt.Color(134,209,208));
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(136, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jManageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jRoomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(134, 134, 134))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addComponent(jRoomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jManageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(136, Short.MAX_VALUE))
        );

        jMainMenuTabbedPane.addTab("Main Menu", jPanel1);

        jChatArea.setColumns(20);
        jChatArea.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N
        jChatArea.setRows(5);
        jScrollPane1.setViewportView(jChatArea);

        jMessageField.setFont(new Font("Calibri", 0, 14));
        jMessageField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if(key==KeyEvent.VK_ENTER){
                    SendMessage();
                }
            }
        });
        jMessageField.setEditable(false);

        jUsernameField.setFont(new Font("Calibri", 0, 14));
        jUsernameField.setEditable(false);

        jSendMessageButton.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        jSendMessageButton.setText("SEND");
        jSendMessageButton.addActionListener(this::SendMessageActionPerformed);
        jSendMessageButton.setEnabled(false);

        jListButton.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        jListButton.setText("Enter");
        jListButton.addActionListener(this::setjListButtonActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2.setBackground(new java.awt.Color(134,209,208));
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jScrollPane1)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jMessageField, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSendMessageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jMessageField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jSendMessageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jListButton, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                                .addContainerGap())
        );

        jMainMenuTabbedPane.addTab("Broadcast Channel", jPanel2);

        javax.swing.GroupLayout jUserListPaneLayout = new javax.swing.GroupLayout(jUserListPane);
        jUserListPane.setLayout(jUserListPaneLayout);
        jUserListPaneLayout.setHorizontalGroup(
                jUserListPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jMainMenuTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jMainMenuTabbedPane.addTab("Active Users", jPanel3);
        jUserListPane.setLayout(jUserListPaneLayout);
        jUserListPaneLayout.setHorizontalGroup(
                jUserListPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jMainMenuTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jUserListPaneLayout.setVerticalGroup(
                jUserListPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jUserListPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jMainMenuTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLoggedInLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLoggedInLabel.setText("Logged in as: ");

        jMenu1.setText("File");

        jManageAccountMenuItem.setText("Manage account");
        jManageAccountMenuItem.addActionListener(this::jManageButtonActionPerformed);
        jMenu1.add(jManageAccountMenuItem);

        jExitMenuItem.setText("Exit");
        jExitMenuItem.addActionListener(this::jExitMenuItemActionPerformed);
        jMenu1.add(jExitMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jUserListPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLoggedInLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jLoggedInLabel)
                                                .addGap(9, 9, 9))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jUsernameField, GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addComponent(jUserListPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    /**
     * Action Performed of SendMessage()
     * @param evt
     */
    private void SendMessageActionPerformed(java.awt.event.ActionEvent evt) {
        SendMessage();
    }

    private void setjListButtonActionPerformed(ActionEvent evt){
        jMessageField.setEditable(true);
        jSendMessageButton.setEnabled(true);

        try{
            clientSocket = new Socket(userInputIpAddress, PORT);
            outWriter = new PrintWriter(clientSocket.getOutputStream(), true);
            new Thread(new Listener()).start();

            outWriter.println(clientName);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cannot connect to the server!", "Error!", JOptionPane.WARNING_MESSAGE);
            System.exit(1);
            e.printStackTrace();
        }
    }

    /**
     * TBD
     * @param evt
     */
    private void setjManageAccountMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
    }

    /**
     * Method to close the window via Menu Bar.
     * @param evt
     */
    private void jExitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        ExitCommand();
    }

    /*private void jRoomButtonActionPerformed(java.awt.event.ActionEvent evt) {
        java.awt.EventQueue.invokeLater(() -> {
            RoomChatBox temp = new RoomChatBox();
            System.setOut(new PrintStream(new TextAreaOutputStream(temp.TextArea)));
            temp.setVisible(true);
        });
    }*/

    private void jManageButtonActionPerformed(java.awt.event.ActionEvent evt) {
        java.awt.EventQueue.invokeLater(() -> {
            AccountManagement am = new AccountManagement();
            am.setVisible(true);
        });

    }

    private void jExitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        ExitCommand();
    }

    /**
     * Sends the message to the group chat
     */
    private void SendMessage(){
        String message = jMessageField.getText().trim();
        if(!message.isEmpty()){
            outWriter.println(message);
            jMessageField.setText("");
        }
    }

    private void ExitCommand(){
        int input = JOptionPane.showConfirmDialog(null, "Are you sure?", "Exit?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(input == 0){
            System.exit(0);
        }
    }

    /**
     * Print msg.
     * @param message will be the message
     */
    public static void addToLogs(String message) {
        System.out.printf("%s %s\n", MainServerUI.dateFormatter.format(new Date()), message);
    }

    /**
     * Listener class to read inputs.
     */
    private static class Listener implements Runnable{
        private BufferedReader inReader;
        @Override
        public void run(){
            try{
                inReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String read;
                for(;;){
                    read = inReader.readLine();
                    if(!(read == null) && !(read.isEmpty())) addToLogs(read);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}



