package prelims.UserInterface;

import prelims.TextAreaOutputStream;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Arrays;

public class SignInWindowUI extends javax.swing.JFrame {
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel passwordLabel1;
    private javax.swing.JButton signInButton;
    private javax.swing.JButton signUpButton;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameTextField;

    public static String username;

    private final Image icon = Toolkit.getDefaultToolkit().getImage("res\\client.png");

    public static void main(String args[]) {
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

        java.awt.EventQueue.invokeLater(() -> new SignInWindowUI().setVisible(true));
    }

    /**
     * Creates new form SignUpWindowUI
     */
    public SignInWindowUI() {
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        usernameTextField = new javax.swing.JTextField();
        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        signInButton = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        signUpButton = new javax.swing.JButton();
        passwordLabel1 = new javax.swing.JLabel();

        getRootPane().setDefaultButton(signInButton);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(95, 190, 212));

        usernameTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        usernameLabel.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(22, 76, 99));
        usernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernameLabel.setText("Username");

        passwordLabel.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(22, 76, 99));
        passwordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passwordLabel.setText("Password");

        signInButton.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14)); // NOI18N
        signInButton.setForeground(new java.awt.Color(51,124,156));
        signInButton.setText("SIGN IN");
        signInButton.setAutoscrolls(true);
        signInButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        signInButton.addActionListener(this::signInButtonActionButtonPerformed);




        signUpButton.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14)); // NOI18N
        signUpButton.setForeground(new java.awt.Color(51,124,156));
        signUpButton.setText("SIGN UP");
        signUpButton.setAutoscrolls(true);
        signUpButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        signUpButton.addActionListener(this::signUpButtonActionButtonPerformed);

        passwordLabel1.setFont(new java.awt.Font("Tahoma", Font.ITALIC, 14)); // NOI18N
        passwordLabel1.setForeground(new java.awt.Color(22, 76, 99));
        passwordLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passwordLabel1.setText("Don't have an account?");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(usernameLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passwordLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(161, 161, 161))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(61, 61, 61)
                                                .addComponent(signInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(10, 10, 10)
                                                        .addComponent(signUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(passwordLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                //.addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(signInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(passwordLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(signUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setIconImage(icon);

        pack();
        setLocationRelativeTo(null);
    }

    private void signUpButtonActionButtonPerformed(java.awt.event.ActionEvent evt) {
        java.awt.EventQueue.invokeLater(() -> new SignUpWindowUI().setVisible(true));
    }

    private void signInButtonActionButtonPerformed(java.awt.event.ActionEvent evt) {
        try(
                BufferedReader bufferedReader = new BufferedReader(new FileReader("res\\Accounts.csv"))
        ){
            char[] passwordChar = passwordField.getPassword();
            String password = new String(passwordChar);

            boolean isValid = false;
            String currentLine = bufferedReader.readLine();

            while(currentLine != null){
                String[] data = currentLine.split(",");
                if(data[2].equals(usernameTextField.getText()) && data[3].equals(password)){
                    isValid = true;
                }
                currentLine = bufferedReader.readLine();
            }
            if(!isValid){
                JOptionPane.showMessageDialog(null, "Invalid Username or Password", "Invalid credentials!", JOptionPane.WARNING_MESSAGE);
            } else {
                this.dispose();

                username = usernameTextField.getText();
                java.awt.EventQueue.invokeLater(() -> {
                    MainMenu temp = new MainMenu();
                    System.setOut(new PrintStream(new TextAreaOutputStream(temp.jChatArea)));
                    temp.setVisible(true);
                    temp.jUsernameField.setText(username);
                });
            }
        } catch (Exception x){
            JOptionPane.showMessageDialog(null, "Error!", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

}
