/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.Random;

/**
 *
 * @author Swarnveer
 */
public class nextMovesBig extends playerVScpuBig {
    static int num;
    static int nextMoveMethod(){
    
        if (difficulty == 0) {
            for (int i = 0; i <= gameState.length; i++) {
                Random r = new Random();
                int rand = r.nextInt(16);
                if (gameState[rand] == 2) {
                    num = rand;
                    break;
                }
            }
        } else if (difficulty == 1 || difficulty ==2) {
            priority = false;
            priority2 = true;
            for (int i = 0; i <= gameState.length; i++) {
                Random r = new Random();
                int rand = r.nextInt(16);
                System.out.println("Random infinite generated "+num);
                if (gameState[rand] == 2) {
                    num = rand;
                    System.out.println("Random Number generated is empy :"+num);
                    break;
                }

            }
            System.out.println("Random Number generated "+num);

            if (!priority){
                for (int[] winningPosition : winningPositions){
                    if (gameState[winningPosition[0]]==gameState[winningPosition[1]] &&
                            gameState[winningPosition[1]]==gameState[winningPosition[2]] &&
                            gameState[winningPosition[1]]!=2){
                        if (gameState[winningPosition[0]]==advanceOp && gameState[winningPosition[3]]!=advance){
                            num=winningPosition[3];System.out.println("First "+num);priority2=false;
                        }
                    }
                }
                for (int[] winningPosition : winningPositions){
                    if (gameState[winningPosition[1]]==gameState[winningPosition[2]] &&
                            gameState[winningPosition[2]]==gameState[winningPosition[3]] &&
                            gameState[winningPosition[2]]!=2){
                        if (gameState[winningPosition[1]]==advanceOp && gameState[winningPosition[0]]!=advance){
                            num=winningPosition[0];System.out.println("First "+num);priority2=false;
                        }
                    }
                }
                for (int[] winningPosition : winningPositions){
                    if (gameState[winningPosition[0]]==gameState[winningPosition[2]] &&
                            gameState[winningPosition[2]]==gameState[winningPosition[3]] &&
                            gameState[winningPosition[2]]!=2){
                        if (gameState[winningPosition[0]]==advanceOp && gameState[winningPosition[1]]!=advance){
                            num=winningPosition[1];System.out.println("First "+num);priority2=false;
                        }
                    }
                }
                for (int[] winningPosition : winningPositions){
                    if (gameState[winningPosition[0]]==gameState[winningPosition[1]] &&
                            gameState[winningPosition[1]]==gameState[winningPosition[3]] &&
                            gameState[winningPosition[1]]!=2){
                        if (gameState[winningPosition[0]]==advanceOp && gameState[winningPosition[2]]!=advance){
                            num=winningPosition[2];System.out.println("First "+num);priority2=false;
                        }
                    }
                }
            }
            if (priority2){
                for (int[] winningPosition : winningPositions){
                    if (gameState[winningPosition[0]]==gameState[winningPosition[1]] &&
                            gameState[winningPosition[1]]==gameState[winningPosition[2]] &&
                            gameState[winningPosition[1]]!=2){
                        if (gameState[winningPosition[0]]==advance && gameState[winningPosition[3]]!=advanceOp){
                            num=winningPosition[3];System.out.println("First "+num);priority2=false;
                        }
                    }
                }
                for (int[] winningPosition : winningPositions){
                    if (gameState[winningPosition[1]]==gameState[winningPosition[2]] &&
                            gameState[winningPosition[2]]==gameState[winningPosition[3]] &&
                            gameState[winningPosition[2]]!=2){
                        if (gameState[winningPosition[1]]==advance && gameState[winningPosition[0]]!=advanceOp){
                            num=winningPosition[0];System.out.println("First "+num);priority2=false;
                        }
                    }
                }
                for (int[] winningPosition : winningPositions){
                    if (gameState[winningPosition[0]]==gameState[winningPosition[2]] &&
                            gameState[winningPosition[2]]==gameState[winningPosition[3]] &&
                            gameState[winningPosition[2]]!=2){
                        if (gameState[winningPosition[0]]==advance && gameState[winningPosition[1]]!=advanceOp){
                            num=winningPosition[1];System.out.println("First "+num);priority2=false;
                        }
                    }
                }
                for (int[] winningPosition : winningPositions){
                    if (gameState[winningPosition[0]]==gameState[winningPosition[1]] &&
                            gameState[winningPosition[1]]==gameState[winningPosition[3]] &&
                            gameState[winningPosition[1]]!=2){
                        if (gameState[winningPosition[0]]==advance && gameState[winningPosition[2]]!=advanceOp){
                            num=winningPosition[2];System.out.println("First "+num);priority2=false;
                        }
                    }
                }
            }
            System.out.println("Final random number "+num);
        }
        if (gameState[num]!=2){
            System.out.println("CONDITION ARISES "+num);
            for (int j=0;j<gameState.length;j++){
                if (gameState[j]==2){
                    num=j;
                    System.out.println("number is now "+j);
                    break;
                }
            }
        }
        return num;
    
    
    
    }
    
}
