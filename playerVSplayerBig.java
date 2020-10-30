/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Swarnveer
 */
public class playerVSplayerBig extends javax.swing.JFrame {

    /**
     * Creates new form playerVSplayerBig
     */
    private String player1Image="jerry";
    private String player2Image="tom";
    private Image image;
    private String p1,p2,background;
    int[] gameState={2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2};
    int[][] winningPositions = {{0,1,2,3},{4,5,6,7},{8,9,10,11},{12,13,14,15},{0,4,8,12},{1,5,9,13},{2,6,10,14},{3,7,11,15},{0,5,10,15},{3,6,9,12}};
    int activePlayer=0,tappedcounter;
    boolean someoneWins=false;
    int p1won=0,p2won=0,turnCount=16,theme,difficulty=0;
    
    public playerVSplayerBig() {
        initComponents();
        setSize(720,764);
        setLocationRelativeTo(null);
    }

    playerVSplayerBig(String p1Name, String p2Name, int theme2, String p1Image, String p2Image, int firstTurn) {
       initComponents();
        setSize(720,764);
        setLocationRelativeTo(null);
        p1=p1Name;
        p2=p2Name;
        theme=theme2;
        player1Image=p1Image;
        player2Image=p2Image;
        if(activePlayer==0)
            playerTurnNotify.setText(p1+"'s Turn");
        else
            playerTurnNotify.setText(p2+"'s Turn");
        player1Score.setText(p1+" :"+p1won);
        player2Score.setText(p2+" :"+p2won);
         switch(theme){
            case 0: background="planets.png";
                    break;
            case 1: background="tomandjerry.jpg";
                   break;
            case 2: background="pokemon.png";
                    break;
                    
            default: background="pokemon2.png";
                    break;
        }
        try {
                image = ImageIO.read(getClass().getResource("CartoonImages/"+background));
            } catch (IOException ex) {
                Logger.getLogger(playerVSplayer.class.getName()).log(Level.SEVERE, null, ex);
            }
        pvpBackgroundBig.setIcon(new ImageIcon(image));
    }
    private void findWhoseTurn(){
        turnCount--;
        if(activePlayer==0){
            activePlayer=1;
            try {
                image = ImageIO.read(getClass().getResource("CartoonImages/"+player1Image+"2.png"));
            } catch (IOException ex) {
                Logger.getLogger(playerVSplayer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                playerTurnNotify.setText(p2+"'s Turn");
        }
        else{
            activePlayer=0;
            try {
                image = ImageIO.read(getClass().getResource("CartoonImages/"+player2Image+"2.png"));
            } catch (IOException ex) {
                Logger.getLogger(playerVSplayer.class.getName()).log(Level.SEVERE, null, ex);
            }
                playerTurnNotify.setText(p1+"'s Turn");
        }
    
    }
    
    private void winDialog(String winner){
        JOptionPane.showMessageDialog(this,winner,"Result",JOptionPane.INFORMATION_MESSAGE);
        reset();
    }
    private void reset(){
        for(int i=0;i<16;i++){
            gameState[i]=2;
        }
        jButton1.setIcon(null);
        jButton2.setIcon(null);
        jButton3.setIcon(null);
        jButton4.setIcon(null);
        jButton5.setIcon(null);
        jButton6.setIcon(null);
        jButton7.setIcon(null);
        jButton8.setIcon(null);
        jButton9.setIcon(null);
        jButton10.setIcon(null);
        jButton11.setIcon(null);
        jButton12.setIcon(null);
        jButton13.setIcon(null);
        jButton14.setIcon(null);
        jButton15.setIcon(null);
        jButton16.setIcon(null);
        turnCount=16;
        someoneWins=false;
    }
    
    
    private void determineIfWin(){
        for (int[] winningPosition : winningPositions){
                if (gameState[winningPosition[0]]==gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]]==gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]]!=2 &&
                        gameState[winningPosition[2]]==gameState[winningPosition[3]] ){
                    
                    someoneWins=true;
                    if (gameState[winningPosition[0]]==0){
                        playerTurnNotify.setText(p1+"'s Turn");
                        p1won++;
                        player1Score.setText(p1+": "+p1won);
                        activePlayer=0;
                        winDialog(p1+" Wins !!!");
                    }
                    else{
                        playerTurnNotify.setText(p2+"'s Turn");
                        p2won++;
                        player2Score.setText(p2+": "+p2won);
                        activePlayer=1;
                        winDialog(p2+" Wins !!!");
                    }
                }
                else if(turnCount==0&&!someoneWins){
                winDialog("Its A Tie");
                break;
                }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backToOptions = new javax.swing.JLabel();
        heading = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jButton14 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jButton15 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jButton16 = new javax.swing.JButton();
        matrix = new javax.swing.JLabel();
        player1Score = new javax.swing.JLabel();
        playerTurnNotify = new javax.swing.JLabel();
        newGame = new javax.swing.JButton();
        player2Score = new javax.swing.JLabel();
        pvpBackgroundBig = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        backToOptions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tictactoe/CartoonImages/back.png"))); // NOI18N
        backToOptions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backToOptionsMouseClicked(evt);
            }
        });

        heading.setFont(new java.awt.Font("Old English Text MT", 1, 75)); // NOI18N
        heading.setForeground(new java.awt.Color(255, 255, 255));
        heading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        heading.setText("3 T's");
        heading.setToolTipText("");
        heading.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        heading.setMaximumSize(new java.awt.Dimension(192, 76));
        heading.setMinimumSize(new java.awt.Dimension(192, 76));
        heading.setPreferredSize(new java.awt.Dimension(192, 76));

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tictactoe/CartoonImages/cross.png"))); // NOI18N
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });

        mainPanel.setMaximumSize(new java.awt.Dimension(600, 600));
        mainPanel.setMinimumSize(new java.awt.Dimension(600, 600));
        mainPanel.setOpaque(false);
        mainPanel.setPreferredSize(new java.awt.Dimension(600, 600));
        mainPanel.setLayout(null);

        jPanel1.setBackground(null);
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.BorderLayout());

        jButton1.setBackground(java.awt.Color.white);
        jButton1.setContentAreaFilled(false);
        jButton1.setName("0"); // NOI18N
        jButton1.setOpaque(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, java.awt.BorderLayout.CENTER);

        mainPanel.add(jPanel1);
        jPanel1.setBounds(1, 1, 147, 147);

        jPanel2.setBackground(null);
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.BorderLayout());

        jButton2.setBackground(java.awt.Color.white);
        jButton2.setContentAreaFilled(false);
        jButton2.setName("1"); // NOI18N
        jButton2.setOpaque(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, java.awt.BorderLayout.CENTER);

        mainPanel.add(jPanel2);
        jPanel2.setBounds(151, 1, 147, 147);

        jPanel3.setBackground(null);
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.BorderLayout());

        jButton3.setBackground(java.awt.Color.white);
        jButton3.setContentAreaFilled(false);
        jButton3.setName("2"); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, java.awt.BorderLayout.CENTER);

        mainPanel.add(jPanel3);
        jPanel3.setBounds(301, 1, 147, 147);

        jPanel4.setBackground(null);
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.BorderLayout());

        jButton4.setBackground(java.awt.Color.white);
        jButton4.setContentAreaFilled(false);
        jButton4.setName("3"); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4, java.awt.BorderLayout.CENTER);

        mainPanel.add(jPanel4);
        jPanel4.setBounds(451, 1, 147, 147);

        jPanel5.setBackground(null);
        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.BorderLayout());

        jButton5.setBackground(java.awt.Color.white);
        jButton5.setContentAreaFilled(false);
        jButton5.setName("4"); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton5, java.awt.BorderLayout.CENTER);

        mainPanel.add(jPanel5);
        jPanel5.setBounds(1, 151, 147, 147);

        jPanel6.setBackground(null);
        jPanel6.setOpaque(false);
        jPanel6.setLayout(new java.awt.BorderLayout());

        jButton6.setBackground(java.awt.Color.white);
        jButton6.setContentAreaFilled(false);
        jButton6.setName("5"); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton6, java.awt.BorderLayout.CENTER);

        mainPanel.add(jPanel6);
        jPanel6.setBounds(151, 151, 147, 147);

        jPanel7.setBackground(null);
        jPanel7.setOpaque(false);
        jPanel7.setLayout(new java.awt.BorderLayout());

        jButton7.setBackground(java.awt.Color.white);
        jButton7.setContentAreaFilled(false);
        jButton7.setName("6"); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton7, java.awt.BorderLayout.CENTER);

        mainPanel.add(jPanel7);
        jPanel7.setBounds(301, 151, 147, 147);

        jPanel8.setBackground(null);
        jPanel8.setOpaque(false);
        jPanel8.setLayout(new java.awt.BorderLayout());

        jButton8.setBackground(java.awt.Color.white);
        jButton8.setContentAreaFilled(false);
        jButton8.setName("7"); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton8, java.awt.BorderLayout.CENTER);

        mainPanel.add(jPanel8);
        jPanel8.setBounds(451, 151, 147, 147);

        jPanel9.setBackground(null);
        jPanel9.setOpaque(false);
        jPanel9.setLayout(new java.awt.BorderLayout());

        jButton9.setBackground(java.awt.Color.white);
        jButton9.setContentAreaFilled(false);
        jButton9.setName("8"); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton9, java.awt.BorderLayout.CENTER);

        mainPanel.add(jPanel9);
        jPanel9.setBounds(1, 301, 147, 147);

        jPanel10.setBackground(null);
        jPanel10.setOpaque(false);
        jPanel10.setLayout(new java.awt.BorderLayout());

        jButton10.setBackground(java.awt.Color.white);
        jButton10.setContentAreaFilled(false);
        jButton10.setName("9"); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton10, java.awt.BorderLayout.CENTER);

        mainPanel.add(jPanel10);
        jPanel10.setBounds(151, 301, 147, 147);

        jPanel11.setBackground(null);
        jPanel11.setOpaque(false);
        jPanel11.setLayout(new java.awt.BorderLayout());

        jButton11.setBackground(java.awt.Color.white);
        jButton11.setContentAreaFilled(false);
        jButton11.setName("10"); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton11, java.awt.BorderLayout.CENTER);

        mainPanel.add(jPanel11);
        jPanel11.setBounds(301, 301, 147, 147);

        jPanel12.setBackground(null);
        jPanel12.setOpaque(false);
        jPanel12.setLayout(new java.awt.BorderLayout());

        jButton12.setBackground(java.awt.Color.white);
        jButton12.setContentAreaFilled(false);
        jButton12.setName("11"); // NOI18N
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel12.add(jButton12, java.awt.BorderLayout.CENTER);

        mainPanel.add(jPanel12);
        jPanel12.setBounds(451, 301, 147, 147);

        jPanel13.setBackground(null);
        jPanel13.setOpaque(false);
        jPanel13.setLayout(new java.awt.BorderLayout());

        jButton13.setBackground(java.awt.Color.white);
        jButton13.setContentAreaFilled(false);
        jButton13.setName("12"); // NOI18N
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton13, java.awt.BorderLayout.CENTER);

        mainPanel.add(jPanel13);
        jPanel13.setBounds(1, 451, 147, 147);

        jPanel14.setBackground(null);
        jPanel14.setOpaque(false);
        jPanel14.setLayout(new java.awt.BorderLayout());

        jButton14.setBackground(java.awt.Color.white);
        jButton14.setContentAreaFilled(false);
        jButton14.setName("13"); // NOI18N
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton14, java.awt.BorderLayout.CENTER);

        mainPanel.add(jPanel14);
        jPanel14.setBounds(151, 451, 147, 147);

        jPanel15.setBackground(null);
        jPanel15.setOpaque(false);
        jPanel15.setLayout(new java.awt.BorderLayout());

        jButton15.setBackground(java.awt.Color.white);
        jButton15.setContentAreaFilled(false);
        jButton15.setName("14"); // NOI18N
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        jPanel15.add(jButton15, java.awt.BorderLayout.CENTER);

        mainPanel.add(jPanel15);
        jPanel15.setBounds(301, 451, 147, 147);

        jPanel16.setBackground(null);
        jPanel16.setOpaque(false);
        jPanel16.setLayout(new java.awt.BorderLayout());

        jButton16.setBackground(java.awt.Color.white);
        jButton16.setContentAreaFilled(false);
        jButton16.setName("15"); // NOI18N
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel16.add(jButton16, java.awt.BorderLayout.CENTER);

        mainPanel.add(jPanel16);
        jPanel16.setBounds(451, 451, 147, 147);

        matrix.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tictactoe/CartoonImages/matrixBig.png"))); // NOI18N
        matrix.setText("jLabel5");
        matrix.setMaximumSize(new java.awt.Dimension(600, 600));
        matrix.setMinimumSize(new java.awt.Dimension(600, 600));
        matrix.setPreferredSize(new java.awt.Dimension(600, 600));
        mainPanel.add(matrix);
        matrix.setBounds(0, 0, 600, 600);

        player1Score.setBackground(new java.awt.Color(255, 255, 102));
        player1Score.setFont(new java.awt.Font("Lithos Pro Regular", 1, 24)); // NOI18N
        player1Score.setForeground(new java.awt.Color(255, 255, 255));
        player1Score.setText("Player1: 0");

        playerTurnNotify.setBackground(new java.awt.Color(255, 255, 102));
        playerTurnNotify.setFont(new java.awt.Font("Lithos Pro Regular", 1, 24)); // NOI18N
        playerTurnNotify.setForeground(new java.awt.Color(255, 255, 255));
        playerTurnNotify.setText("Player 1's turn");

        newGame.setBackground(new java.awt.Color(255, 255, 255));
        newGame.setFont(new java.awt.Font("Lithos Pro Regular", 1, 24)); // NOI18N
        newGame.setText("New game");
        newGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameActionPerformed(evt);
            }
        });

        player2Score.setBackground(new java.awt.Color(255, 255, 102));
        player2Score.setFont(new java.awt.Font("Lithos Pro Regular", 1, 24)); // NOI18N
        player2Score.setForeground(new java.awt.Color(255, 255, 255));
        player2Score.setText("Player2: 0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(670, 670, 670)
                .addComponent(close))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(player1Score, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(newGame))
            .addGroup(layout.createSequentialGroup()
                .addGap(264, 264, 264)
                .addComponent(heading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(playerTurnNotify, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(490, 490, 490)
                .addComponent(player2Score, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(backToOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pvpBackgroundBig, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(close)
                .addGap(41, 41, 41)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(player1Score, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(newGame))))
            .addComponent(heading, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(700, 700, 700)
                .addComponent(playerTurnNotify))
            .addGroup(layout.createSequentialGroup()
                .addGap(708, 708, 708)
                .addComponent(player2Score, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(backToOptions, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pvpBackgroundBig, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backToOptionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backToOptionsMouseClicked
        // TODO add your handling code here:
        dispose();
        gameOptions obj = new gameOptions(theme);
        obj.setVisible(true);
    }//GEN-LAST:event_backToOptionsMouseClicked

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_closeMouseClicked

    private void newGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newGameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       tappedcounter = Integer.parseInt(jButton1.getName().toString());
        if(gameState[tappedcounter]==2&&!someoneWins){
            gameState[tappedcounter]=activePlayer;
            findWhoseTurn();
            jButton1.setIcon(new ImageIcon(image));
            
            determineIfWin();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        tappedcounter = Integer.parseInt(jButton2.getName().toString());
        if(gameState[tappedcounter]==2&&!someoneWins){
            gameState[tappedcounter]=activePlayer;
            findWhoseTurn();
            jButton2.setIcon(new ImageIcon(image));
            
            determineIfWin();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        tappedcounter = Integer.parseInt(jButton3.getName().toString());
        if(gameState[tappedcounter]==2&&!someoneWins){
            gameState[tappedcounter]=activePlayer;
            findWhoseTurn();
            jButton3.setIcon(new ImageIcon(image));
            
            determineIfWin();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        tappedcounter = Integer.parseInt(jButton4.getName().toString());
        if(gameState[tappedcounter]==2&&!someoneWins){
            gameState[tappedcounter]=activePlayer;
            findWhoseTurn();
            jButton4.setIcon(new ImageIcon(image));
            
            determineIfWin();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        tappedcounter = Integer.parseInt(jButton5.getName().toString());
        if(gameState[tappedcounter]==2&&!someoneWins){
            gameState[tappedcounter]=activePlayer;
            findWhoseTurn();
            jButton5.setIcon(new ImageIcon(image));
            
            determineIfWin();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        tappedcounter = Integer.parseInt(jButton6.getName().toString());
        if(gameState[tappedcounter]==2&&!someoneWins){
            gameState[tappedcounter]=activePlayer;
            findWhoseTurn();
            jButton6.setIcon(new ImageIcon(image));
            
            determineIfWin();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       tappedcounter = Integer.parseInt(jButton7.getName().toString());
        if(gameState[tappedcounter]==2&&!someoneWins){
            gameState[tappedcounter]=activePlayer;
            findWhoseTurn();
            jButton7.setIcon(new ImageIcon(image));
            
            determineIfWin();
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        tappedcounter = Integer.parseInt(jButton8.getName().toString());
        if(gameState[tappedcounter]==2&&!someoneWins){
            gameState[tappedcounter]=activePlayer;
            findWhoseTurn();
            jButton8.setIcon(new ImageIcon(image));
            
            determineIfWin();
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        tappedcounter = Integer.parseInt(jButton9.getName().toString());
        if(gameState[tappedcounter]==2&&!someoneWins){
            gameState[tappedcounter]=activePlayer;
            findWhoseTurn();
            jButton9.setIcon(new ImageIcon(image));
            
            determineIfWin();
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        tappedcounter = Integer.parseInt(jButton10.getName().toString());
        if(gameState[tappedcounter]==2&&!someoneWins){
            gameState[tappedcounter]=activePlayer;
            findWhoseTurn();
            jButton10.setIcon(new ImageIcon(image));
            
            determineIfWin();
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        tappedcounter = Integer.parseInt(jButton11.getName().toString());
        if(gameState[tappedcounter]==2&&!someoneWins){
            gameState[tappedcounter]=activePlayer;
            findWhoseTurn();
            jButton11.setIcon(new ImageIcon(image));
            
            determineIfWin();
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
       tappedcounter = Integer.parseInt(jButton12.getName().toString());
        if(gameState[tappedcounter]==2&&!someoneWins){
            gameState[tappedcounter]=activePlayer;
            findWhoseTurn();
            jButton12.setIcon(new ImageIcon(image));
            
            determineIfWin();
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
       tappedcounter = Integer.parseInt(jButton13.getName().toString());
        if(gameState[tappedcounter]==2&&!someoneWins){
            gameState[tappedcounter]=activePlayer;
            findWhoseTurn();
            jButton13.setIcon(new ImageIcon(image));
            
            determineIfWin();
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        tappedcounter = Integer.parseInt(jButton14.getName().toString());
        if(gameState[tappedcounter]==2&&!someoneWins){
            gameState[tappedcounter]=activePlayer;
            findWhoseTurn();
            jButton14.setIcon(new ImageIcon(image));
            
            determineIfWin();
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        tappedcounter = Integer.parseInt(jButton15.getName().toString());
        if(gameState[tappedcounter]==2&&!someoneWins){
            gameState[tappedcounter]=activePlayer;
            findWhoseTurn();
            jButton15.setIcon(new ImageIcon(image));
            
            determineIfWin();
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        tappedcounter = Integer.parseInt(jButton16.getName().toString());
        if(gameState[tappedcounter]==2&&!someoneWins){
            gameState[tappedcounter]=activePlayer;
            findWhoseTurn();
            jButton16.setIcon(new ImageIcon(image));
            
            determineIfWin();
        }
    }//GEN-LAST:event_jButton16ActionPerformed

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
            java.util.logging.Logger.getLogger(playerVSplayerBig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(playerVSplayerBig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(playerVSplayerBig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(playerVSplayerBig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new playerVSplayerBig().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backToOptions;
    private javax.swing.JLabel close;
    private javax.swing.JLabel heading;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel matrix;
    private javax.swing.JButton newGame;
    private javax.swing.JLabel player1Score;
    private javax.swing.JLabel player2Score;
    private javax.swing.JLabel playerTurnNotify;
    private javax.swing.JLabel pvpBackgroundBig;
    // End of variables declaration//GEN-END:variables
}
