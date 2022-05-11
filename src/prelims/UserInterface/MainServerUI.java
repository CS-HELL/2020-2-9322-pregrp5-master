package prelims.UserInterface;

import prelims.Client;
import prelims.TextAreaOutputStream;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainServerUI extends javax.swing.JFrame {

    public static SimpleDateFormat dateFormatter = new SimpleDateFormat("[hh:mm a]");
    public static final HashMap<String, PrintWriter> onlineClients = new HashMap<String, PrintWriter>();

    //Telnet Socket
    private static ServerSocket serverSocket;
    private static int PORT = 8888;
    private static volatile boolean exit = false;
    private static final int MAX_CLIENT = 50;
    private final Image icon = Toolkit.getDefaultToolkit().getImage("res\\server.png");

    //JFrame
    private javax.swing.JButton jClearButton;
    public JTextArea jConsoleArea;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jShutDownServerButton;
    private javax.swing.JButton jStartServerButton;
    private javax.swing.JPanel mainPanel;

    /**
     * Main method to run the Java File.
     * @param args
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
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

            try {
                MainServerUI ServerUI = new MainServerUI();

                System.setOut(new PrintStream(new TextAreaOutputStream(ServerUI.jConsoleArea)));
                ServerUI.setVisible(true);
            }catch(Exception e){
                e.printStackTrace();
            }
        });
    }

    //Interface design Area

    /**
     * Creates new form TelnetServer
     */
    public MainServerUI() {
        initComponents();
    }

    /**
     * MainServerUI's frame and its components.
     */
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jConsoleArea = new javax.swing.JTextArea();
        jStartServerButton = new javax.swing.JButton();
        jClearButton = new javax.swing.JButton();
        jShutDownServerButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        setResizable(false);

        setIconImage(icon);
        setLayout(null);
        setSize(400,400);
        setVisible(true);

        jConsoleArea.setColumns(20);
        jConsoleArea.setRows(5);
        jConsoleArea.setEditable(false);
        jScrollPane1.setViewportView(jConsoleArea);

        jStartServerButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jStartServerButton.setText("START SERVER");
        jStartServerButton.addActionListener(this::jStartServerButtonActionPerformed);

        jClearButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jClearButton.setText("CLEAR");
        jClearButton.addActionListener(this::jClearButtonActionPerformed);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1)
                                        .addGroup(mainPanelLayout.createSequentialGroup()
                                                .addComponent(jStartServerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                                                .addComponent(jClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                                .addGap(11, 11, 11)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jStartServerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jClearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );

        jShutDownServerButton.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jShutDownServerButton.setText("SHUT DOWN SERVER");
        jShutDownServerButton.addActionListener(this::jShutDownServerButtonActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jShutDownServerButton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jShutDownServerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack();
    }

    /**
     * Action Performed Button to start the server.
     * @param evt
     */
    private void jStartServerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        try{
            Thread.sleep(500);
        }catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }

        new Thread(new ServerHandler()).start();

        jConsoleArea.append("[SERVER] STATUS: ONLINE.\n\n");
    }

    /**
     * Action Performed Button to shut down the server.
     * @param evt
     */
    private void jShutDownServerButtonActionPerformed(java.awt.event.ActionEvent evt){
        if(!serverSocket.isClosed()) {
            try {
                serverSocket.close();
            } catch (IOException ignored) {

            }
        }
        jConsoleArea.append("[SERVER] STATUS: OFFLINE.\n");
    }

    /**
     * Clear button.
     * @param evt
     */
    private void jClearButtonActionPerformed(java.awt.event.ActionEvent evt) {
        jConsoleArea.setText("");
    }

    /**
     * Method to send certain logs to the server.
     * @param logMessage will be the message
     */
    private static void printToLogs(String logMessage){
        System.out.printf("%s %s\n", dateFormatter.format(new Date()), logMessage);
    }

    private static void privateMessage(String username, String message){
        for(PrintWriter printWriter : onlineClients.values()){
            if(onlineClients.containsKey(username)){
                printWriter.println(message);
            }
            else{
                JOptionPane.showMessageDialog(null, "No Such User!", "Unable to send Message", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    /**
     * A ServerHandler Runnable class to enable multiple clients to join in 1 server.
     */

    private class ServerHandler implements Runnable{

        @Override
        public void run(){

            try{
                InetAddress ipAddress = InetAddress.getLocalHost();

                serverSocket = new ServerSocket(PORT);
                printToLogs("[SERVER] Port: " + PORT);
                printToLogs("[SERVER] IP Address: " + ipAddress);
                printToLogs("[SERVER] is now waiting for connections...");


                while(!exit){
                    if(onlineClients.size() <= MAX_CLIENT){
                        new Thread(new ClientHandler(serverSocket.accept())).start();
                    }
                }

            } catch (IOException e) {
                printToLogs("\n[SERVER] Error: \n");
                printToLogs(Arrays.toString(e.getStackTrace()));
                printToLogs("\n[SERVER] Aborting...");
            }
        }
    }

    /**
     * A ClienHandler Runnable class
     */
    private class ClientHandler implements Runnable{

        String name;
        Socket clientSocket;

        private ClientHandler(Socket socket){
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            Client.setClientSocket(clientSocket);

            try{

                BufferedReader inReader = new BufferedReader(new InputStreamReader(Client.getClientSocket().getInputStream()));
                PrintWriter outWriter = new PrintWriter(Client.getClientSocket().getOutputStream(), true);

                for(;;){
                    Client.setUserName(inReader.readLine());
                    name = Client.getuserName();

                    if(name == null){
                        return;
                    }
                    synchronized (onlineClients){
                        if(!name.isEmpty() && !onlineClients.containsKey(name)) break;
                        else outWriter.println("Invalid name");
                    }
                }

                outWriter.println("Welcome to the localhost chatroom " + name);
                printToLogs("[SERVER] " + name + " " + Client.getClientSocket().getLocalAddress() + " has joined.");

                Client.setUserName(name);
                onlineClients.put(name, outWriter);

                String message;

                while((message = inReader.readLine()) != null){
                    if(!message.isEmpty()){
                        broadcast(String.format("[%s] %s", name, message));
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally{
                if(name != null){
                    printToLogs("[SERVER] " + name + " " + Client.getClientSocket().getLocalAddress() + " has left.");
                    onlineClients.remove(name);
                }
            }
        }

        /**
         * Broadcast the messages from the server to the clients.
         * @param serverWideMessage
         */
        private void broadcast(String serverWideMessage){
            for(PrintWriter printWriter : onlineClients.values()){
                printWriter.println(serverWideMessage);
            }
        }

        public String getName() {
            return name;
        }
    }
}




