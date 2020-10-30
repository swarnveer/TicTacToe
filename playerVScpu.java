/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Swarnveer
 */

public class playerVScpu extends javax.swing.JFrame {

    /**
     * Creates new form playerVSplayer
     */
    private String player1Image="jerry";
    private String player2Image="tom";
    private Image image;
    private String p1,p2,background,diff,cpuButton;
    static int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2},allCorners={0,2,6,8}, allMiddle={1,7,3,5};    
    static int[][] winningPositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}},
            winningPos= {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8}},
            winningDiagonal={{0,4,8},{2,4,6}};
    static int activePlayer=0,tappedcounter;
    static boolean someoneWins=false, priority = false, priority2 = true,ready=false,ready2=false,ready3=false;;
    static int p1won=0,p2won=0,turnCount=9,theme,randomn,difficulty=0,advance = 0, advanceOp = 1;
    static int num,turn=0,firstTurn2;

    public playerVScpu() {
       initComponents();
        setSize(720,764);
        setLocationRelativeTo(null);
   
        if(activePlayer==0)
            playerTurnNotify.setText(p1+"'s Turn");
        else
            playerTurnNotify.setText(p2+"'s Turn");
       
       
    }

    public playerVScpu(String p1Name, String p2Name, int theme2, String p1Image, String p2Image, int firstTurn, String difficulty2) {
        initComponents();
        setSize(720,764);
        setLocationRelativeTo(null);
        
         
        p1=p1Name;
        p2=p2Name;
        theme=theme2;
        player1Image=p1Image;
        player2Image=p2Image;
        diff=difficulty2;
         System.out.println(difficulty2);
        if(diff.equalsIgnoreCase("easy"))
            difficulty=0;
        else if(diff.equalsIgnoreCase("medium"))
            difficulty=1;
        else if(diff.equalsIgnoreCase("hard"))
            difficulty=2;
        firstTurn2=firstTurn;
        if(firstTurn==0)
            activePlayer=0;
        else
            activePlayer=1;
        if(activePlayer==0)
            playerTurnNotify.setText(p1+"'s Turn");
        else
            playerTurnNotify.setText(p2+"'s Turn");
         player1Score.setText(p1+" :"+p1won);
         player2Score.setText(p2+" :"+p2won);
         System.out.println("Active Player="+activePlayer+" p1Won="+p1won+" p2Won="+p2won);
         switch(theme){
            case 0: background="planets.png";
                    break;
            case 1: background="tomandjerry.jpg";
                   break;
            case 2: background="pokemon.png";
                    break;
            case 3: background="superheroes1.png";
                    break;
            default: background="pokemon2.png";
                    break;
        }
        try {
                image = ImageIO.read(getClass().getResource("CartoonImages/"+background));
            } catch (IOException ex) {
                Logger.getLogger(playerVScpu.class.getName()).log(Level.SEVERE, null, ex);
            }
        pvpBackground.setIcon(new ImageIcon(image));
        if(activePlayer==1){
            Random random = new Random();
        tappedcounter = allCorners[random.nextInt(allCorners.length)];
        
        System.out.println("First Run "+tappedcounter);
        computerClick();
        }
    }
    private void computerClick(){
    
    System.out.println("Computer Click k andar"+tappedcounter);
    switch(tappedcounter){    
        case 0: jButton1.doClick();
                break;
        case 1: jButton2.doClick();
                break;
        case 2: jButton3.doClick();
                break;
        case 3: jButton4.doClick();
                break;
        case 4: jButton5.doClick();
                break;
        case 5: jButton6.doClick();
                break;
        case 6: jButton7.doClick();
                break;
        case 7: jButton8.doClick();
                break;
        case 8: jButton9.doClick();
                break;
    }
        
    }
    private void findWhoseTurn(){
        turnCount--;
        if(activePlayer==0){
            activePlayer=1;
            try {
                image = ImageIO.read(getClass().getResource("CartoonImages/"+player1Image+".png"));
            } catch (IOException ex) {
                Logger.getLogger(playerVScpu.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                playerTurnNotify.setText(p2+"'s Turn");
        }
        else{
            activePlayer=0;
            try {
                image = ImageIO.read(getClass().getResource("CartoonImages/"+player2Image+".png"));
            } catch (IOException ex) {
                Logger.getLogger(playerVScpu.class.getName()).log(Level.SEVERE, null, ex);
            }
                playerTurnNotify.setText(p1+"'s Turn");
        }
    
    }
    
    private void winDialog(String winner){
        JOptionPane.showMessageDialog(this,winner,"Result",JOptionPane.INFORMATION_MESSAGE);
        reset();
    }
    
    private void determineIfWin(){
        
        for (int[] winningPosition : winningPositions){
                if (gameState[winningPosition[0]]==gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]]==gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]]!=2){
                    System.out.println(gameState[winningPosition[0]]+" + ");
                                        System.out.println(gameState[winningPosition[1]]+" + ");
                                                            System.out.println(gameState[winningPosition[2]]+" + ");
                    someoneWins=true;
                    if (gameState[winningPosition[0]]==0){
                        playerTurnNotify.setText(p1+"'s Turn");
                        p1won++;
                        player1Score.setText(p1+": "+p1won);
                        activePlayer=0;
                        firstTurn2=0;
                        winDialog(p1+" Wins !!!");
                        System.out.println(activePlayer+"A");
                        break;
                    }
                    else{
                        playerTurnNotify.setText(p2+"'s Turn");
                        p2won++;
                        player2Score.setText(p2+": "+p2won);
                        activePlayer=1;
                        firstTurn2=1;
                        winDialog(p2+" Wins !!!");
                        System.out.println(activePlayer+"B");
                        break;
                    }
                }
                else if(turnCount==0&&!someoneWins){
                winDialog("Its A Tie");
                activePlayer=(activePlayer+1)%2;
                        System.out.println(activePlayer);
                break;
                }
                else if(!someoneWins&&activePlayer==1&&turnCount>0){
                    
                    tappedcounter = nextMoves.nextMoveMethod();
        
                        System.out.println(activePlayer+"C"+"   tapped counter="+tappedcounter);
                    computerClick();  
                    
                        System.out.println(activePlayer+"D");
                }
        }
    }
    private void reset(){
        for(int i=0;i<9;i++){
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
        someoneWins=false;
        turnCount=9;
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        playerTurnNotify = new javax.swing.JLabel();
        newGame = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        pos1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        pos2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        pos3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        pos4 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        pos5 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        pos6 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        pos7 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        pos8 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        pos9 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        matrix = new javax.swing.JLabel();
        player1Score = new javax.swing.JLabel();
        player2Score = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        backToOptions = new javax.swing.JLabel();
        pvpBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(720, 764));
        setUndecorated(true);
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Old English Text MT", 1, 75)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("3 T's");
        jLabel1.setToolTipText("");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel1.setMaximumSize(new java.awt.Dimension(192, 76));
        jLabel1.setMinimumSize(new java.awt.Dimension(192, 76));
        jLabel1.setPreferredSize(new java.awt.Dimension(192, 76));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(264, 0, 192, 76);

        playerTurnNotify.setBackground(new java.awt.Color(255, 255, 102));
        playerTurnNotify.setFont(new java.awt.Font("Lithos Pro Regular", 1, 24)); // NOI18N
        playerTurnNotify.setForeground(new java.awt.Color(255, 255, 255));
        playerTurnNotify.setText("Player 1's turn");
        getContentPane().add(playerTurnNotify);
        playerTurnNotify.setBounds(250, 700, 260, 25);

        newGame.setBackground(new java.awt.Color(255, 255, 255));
        newGame.setFont(new java.awt.Font("Lithos Pro Regular", 1, 24)); // NOI18N
        newGame.setText("New game");
        newGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameActionPerformed(evt);
            }
        });
        getContentPane().add(newGame);
        newGame.setBounds(280, 730, 167, 33);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setMaximumSize(new java.awt.Dimension(600, 600));
        jPanel1.setMinimumSize(new java.awt.Dimension(600, 600));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 600));
        jPanel1.setLayout(null);

        pos1.setBackground(new java.awt.Color(255, 255, 255));
        pos1.setOpaque(false);
        pos1.setLayout(new java.awt.BorderLayout());

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setContentAreaFilled(false);
        jButton1.setName("0"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pos1.add(jButton1, java.awt.BorderLayout.CENTER);
        jButton1.setContentAreaFilled(false);
        jButton1.setBorderPainted(false);

        jPanel1.add(pos1);
        pos1.setBounds(0, 0, 198, 198);

        pos2.setBackground(new java.awt.Color(255, 255, 255));
        pos2.setOpaque(false);
        pos2.setLayout(new java.awt.BorderLayout());

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setContentAreaFilled(false);
        jButton2.setName("1"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        pos2.add(jButton2, java.awt.BorderLayout.CENTER);
        jButton2.setContentAreaFilled(false);
        jButton2.setBorderPainted(false);

        jPanel1.add(pos2);
        pos2.setBounds(201, 0, 198, 198);

        pos3.setBackground(new java.awt.Color(255, 255, 255));
        pos3.setOpaque(false);
        pos3.setLayout(new java.awt.BorderLayout());

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setContentAreaFilled(false);
        jButton3.setName("2"); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        pos3.add(jButton3, java.awt.BorderLayout.CENTER);
        jButton3.setContentAreaFilled(false);
        jButton3.setBorderPainted(false);

        jPanel1.add(pos3);
        pos3.setBounds(402, 0, 198, 198);

        pos4.setBackground(new java.awt.Color(255, 255, 255));
        pos4.setOpaque(false);
        pos4.setLayout(new java.awt.BorderLayout());

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setContentAreaFilled(false);
        jButton4.setName("3"); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        pos4.add(jButton4, java.awt.BorderLayout.CENTER);
        jButton4.setContentAreaFilled(false);
        jButton4.setBorderPainted(false);

        jPanel1.add(pos4);
        pos4.setBounds(0, 201, 198, 198);

        pos5.setBackground(new java.awt.Color(255, 255, 255));
        pos5.setOpaque(false);
        pos5.setLayout(new java.awt.BorderLayout());

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setContentAreaFilled(false);
        jButton5.setName("4"); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        pos5.add(jButton5, java.awt.BorderLayout.CENTER);
        jButton5.setContentAreaFilled(false);
        jButton5.setBorderPainted(false);

        jPanel1.add(pos5);
        pos5.setBounds(201, 201, 198, 198);

        pos6.setBackground(new java.awt.Color(255, 255, 255));
        pos6.setOpaque(false);
        pos6.setLayout(new java.awt.BorderLayout());

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setContentAreaFilled(false);
        jButton6.setName("5"); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        pos6.add(jButton6, java.awt.BorderLayout.CENTER);
        jButton6.setContentAreaFilled(false);
        jButton6.setBorderPainted(false);

        jPanel1.add(pos6);
        pos6.setBounds(402, 201, 198, 198);

        pos7.setBackground(new java.awt.Color(255, 255, 255));
        pos7.setOpaque(false);
        pos7.setLayout(new java.awt.BorderLayout());

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setContentAreaFilled(false);
        jButton7.setName("6"); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        pos7.add(jButton7, java.awt.BorderLayout.CENTER);
        jButton7.setContentAreaFilled(false);
        jButton7.setBorderPainted(false);

        jPanel1.add(pos7);
        pos7.setBounds(0, 402, 198, 198);

        pos8.setBackground(new java.awt.Color(255, 255, 255));
        pos8.setOpaque(false);
        pos8.setLayout(new java.awt.BorderLayout());

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setContentAreaFilled(false);
        jButton8.setName("7"); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        pos8.add(jButton8, java.awt.BorderLayout.CENTER);
        jButton8.setContentAreaFilled(false);
        jButton8.setBorderPainted(false);

        jPanel1.add(pos8);
        pos8.setBounds(201, 402, 198, 198);

        pos9.setBackground(new java.awt.Color(255, 255, 255));
        pos9.setOpaque(false);
        pos9.setLayout(new java.awt.BorderLayout());

        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setContentAreaFilled(false);
        jButton9.setName("8"); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        pos9.add(jButton9, java.awt.BorderLayout.CENTER);
        jButton9.setContentAreaFilled(false);
        jButton9.setBorderPainted(false);

        jPanel1.add(pos9);
        pos9.setBounds(402, 402, 198, 198);

        matrix.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tictactoe/CartoonImages/matrix.png"))); // NOI18N
        matrix.setText("jLabel5");
        matrix.setMaximumSize(new java.awt.Dimension(600, 600));
        matrix.setMinimumSize(new java.awt.Dimension(600, 600));
        matrix.setPreferredSize(new java.awt.Dimension(600, 600));
        jPanel1.add(matrix);
        matrix.setBounds(0, 0, 600, 600);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(60, 86, 600, 600);

        player1Score.setBackground(new java.awt.Color(255, 255, 102));
        player1Score.setFont(new java.awt.Font("Lithos Pro Regular", 1, 24)); // NOI18N
        player1Score.setForeground(new java.awt.Color(255, 255, 255));
        player1Score.setText("Player1: 0");
        getContentPane().add(player1Score);
        player1Score.setBounds(0, 708, 230, 30);

        player2Score.setBackground(new java.awt.Color(255, 255, 102));
        player2Score.setFont(new java.awt.Font("Lithos Pro Regular", 1, 24)); // NOI18N
        player2Score.setForeground(new java.awt.Color(255, 255, 255));
        player2Score.setText("Player2: 0");
        getContentPane().add(player2Score);
        player2Score.setBounds(490, 708, 230, 30);

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tictactoe/CartoonImages/cross.png"))); // NOI18N
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });
        getContentPane().add(close);
        close.setBounds(670, 0, 50, 50);

        backToOptions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tictactoe/CartoonImages/back.png"))); // NOI18N
        backToOptions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backToOptionsMouseClicked(evt);
            }
        });
        getContentPane().add(backToOptions);
        backToOptions.setBounds(0, 0, 50, 50);

        pvpBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tictactoe/CartoonImages/tomandjerry2.jpg"))); // NOI18N
        getContentPane().add(pvpBackground);
        pvpBackground.setBounds(0, 0, 720, 764);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ESCAPE){
            dispose();
        }
    }//GEN-LAST:event_formKeyPressed

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

    private void newGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newGameActionPerformed

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_closeMouseClicked

    private void backToOptionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backToOptionsMouseClicked
        // TODO add your handling code here:
        dispose();
        gameOptions obj = new gameOptions(theme);
        obj.setVisible(true);
    }//GEN-LAST:event_backToOptionsMouseClicked

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
            java.util.logging.Logger.getLogger(playerVScpu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(playerVScpu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(playerVScpu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(playerVScpu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new playerVScpu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backToOptions;
    private javax.swing.JLabel close;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel matrix;
    private javax.swing.JButton newGame;
    private javax.swing.JLabel player1Score;
    private javax.swing.JLabel player2Score;
    private javax.swing.JLabel playerTurnNotify;
    private javax.swing.JPanel pos1;
    private javax.swing.JPanel pos2;
    private javax.swing.JPanel pos3;
    private javax.swing.JPanel pos4;
    private javax.swing.JPanel pos5;
    private javax.swing.JPanel pos6;
    private javax.swing.JPanel pos7;
    private javax.swing.JPanel pos8;
    private javax.swing.JPanel pos9;
    private javax.swing.JLabel pvpBackground;
    // End of variables declaration//GEN-END:variables


}

