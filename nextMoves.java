/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;


import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class nextMoves extends playerVScpu {
    static int num = 4;
    static int nextMoveMethod(){
        if(firstTurn2==1){
              if (difficulty == 0) {
                for (int i = 0; i <= gameState.length; i++) {
                    Random r = new Random();
                    int rand = r.nextInt(9);
                    if (gameState[rand] == 2) {
                        num = rand;
                        break;
                    }
                }
            } else if (difficulty == 1) {
                priority = false;
                priority2 = true;
                for (int i = 0; i <= gameState.length; i++) {
                    Random r = new Random();
                    int rand = r.nextInt(9);
                    System.out.println("Random infinite generated "+num);
                    if (gameState[rand] == 2) {
                        num = rand;
                        System.out.println("Random Number generated is empy :"+num);
                        break;
                    }

                }
                System.out.println("Random Number generated "+num);

                if (!priority) {
                    for (int[] winningPosition : winningPositions) {
                        if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[0]] != 2) {
                            if (gameState[winningPosition[0]] == advanceOp && gameState[winningPosition[2]] != advance) {
                                num = winningPosition[2];
                                System.out.println("First " + num);
                                priority2 = false;
                            }
                        } else if (gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[1]] != 2) {
                            if (gameState[winningPosition[1]] == advanceOp && gameState[winningPosition[0]] != advance) {
                                num = winningPosition[0];
                                System.out.println("Second " + num);
                                priority2 = false;
                            }
                        } else if (gameState[winningPosition[0]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2) {
                            if (gameState[winningPosition[0]] == advanceOp && gameState[winningPosition[1]] != advance) {
                                num = winningPosition[1];
                                System.out.println("Third " + num);
                                priority2 = false;
                            }
                        }
                    }
                }
                if (priority2) {
                    for (int[] winningPosition : winningPositions) {
                        if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[0]] != 2) {
                            if (gameState[winningPosition[0]] == advance && gameState[winningPosition[2]] != advanceOp) {
                                num = winningPosition[2];
                                System.out.println("First " + num);
                                priority = true;
                            }
                        } else if (gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[1]] != 2) {
                            if (gameState[winningPosition[1]] == advance && gameState[winningPosition[0]] != advanceOp) {
                                num = winningPosition[0];
                                System.out.println("Second " + num);
                                priority = true;
                            }
                        } else if (gameState[winningPosition[0]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2) {
                            if (gameState[winningPosition[0]] == advance && gameState[winningPosition[1]] != advanceOp) {
                                num = winningPosition[1];
                                System.out.println("Third " + num);
                                priority = true;
                            }
                        }
                    }
                }
            }
            else if (difficulty==2) {
                priority = false;
                priority2 = true;
                for (int i = 0; i <= gameState.length; i++) {
                    Random r = new Random();
                    int rand = r.nextInt(9);
                    System.out.println("Random infinite generated "+num);
                    if (gameState[rand] == 2) {
                        num = rand; System.out.println("Random Number generated is empty :"+num);
                        break;

                    }
                }
                System.out.println("Random Number generated "+num);
                switch (turn) {
                    case 1:
                        if (tappedcounter==4){
                            for (int[] winningPosition : winningDiagonal) {
                                if (gameState[winningPosition[0]] == 0 && gameState[winningPosition[1]] == 1){
                                    num=winningPosition[2];System.out.println("L1");
                                }
                                else if (gameState[winningPosition[2]] == 0 && gameState[winningPosition[1]] == 1){
                                    num=winningPosition[0];System.out.println("L2");
                                }
                            }
                            ready3=true;
                        }
                        else {
                            System.out.println("ELSE BLOCK EXECUTING");
                            for(int check=0;check<allMiddle.length;check++){
                                if (tappedcounter==allMiddle[check])
                                    ready=true;System.out.println("ready is now true");
                            }
                            if (ready){
                                for (int[] winningPosition : winningPos) {
                                    if (gameState[winningPosition[0]] == 0 && (gameState[winningPosition[1]] != 1 && gameState[winningPosition[2]] == 2)){
                                        num = winningPosition[2];System.out.println("L3");
                                    }
                                    else if (gameState[winningPosition[1]] != 1 &&   (gameState[winningPosition[0]] == 2 && gameState[winningPosition[2]] == 0)) {
                                        num = winningPosition[0];System.out.println("L4");
                                    }
                                }
                            }
                            else{
                                for (int[] winningPosition : winningPos) {
                                    if (gameState[winningPosition[0]] == 0 && (gameState[winningPosition[2]] != 1 && gameState[winningPosition[1]] != 1)){
                                        num = winningPosition[2];System.out.println("L5 & num="+num);
                                        ready2=true;
                                    }
                                    else if (gameState[winningPosition[1]] != 1 &&   gameState[winningPosition[2]] == 0){
                                        num = winningPosition[0];System.out.println("L6 & num="+num);
                                        ready2=true;
                                    }
                                }
                            }
                        }
                        //priority=true;
                        break;
                    case 2:
                        if (ready){
                            num=4;System.out.println("L7");
                            ready=false;
                        }
                        else if (ready2){
                            for (int[] winningPosition : winningPos) {
                                if (gameState[winningPosition[0]] == 0 && gameState[winningPosition[2]] == 2){
                                    num = winningPosition[2];System.out.println("L8 & num="+num);
                                }
                                else if (gameState[winningPosition[2]] == 0 &&   gameState[winningPosition[0]] == 2){
                                    num = winningPosition[0];System.out.println("L9 & num="+num);
                                }
                            }
                            ready2=false;
                        }
                        else if (ready3){
                            for (int var:allCorners){
                                if (gameState[var]==2){
                                    num=var;System.out.println("L10");
                                }
                            }
                        }
                        //priority=true;
                        break;
                    default:
                        break;
                }
                if (!priority) {
                    for (int[] winningPosition : winningPositions) {
                        if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[0]] != 2) {
                            if (gameState[winningPosition[0]] == advanceOp && gameState[winningPosition[2]] != advance) {
                                num = winningPosition[2];
                                System.out.println("First " + num);
                                priority2 = false;
                            }
                        } else if (gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[1]] != 2) {
                            if (gameState[winningPosition[1]] == advanceOp && gameState[winningPosition[0]] != advance) {
                                num = winningPosition[0];
                                System.out.println("Second " + num);
                                priority2 = false;
                            }
                        } else if (gameState[winningPosition[0]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2) {
                            if (gameState[winningPosition[0]] == advanceOp && gameState[winningPosition[1]] != advance) {
                                num = winningPosition[1];
                                System.out.println("Third " + num);
                                priority2 = false;
                            }
                        }
                    }
                }
                if (priority2) {
                    for (int[] winningPosition : winningPositions) {
                        if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[0]] != 2) {
                            if (gameState[winningPosition[0]] == advance && gameState[winningPosition[2]] != advanceOp) {
                                num = winningPosition[2];
                                System.out.println("First " + num);
                                priority = true;
                            }
                        } else if (gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[1]] != 2) {
                            if (gameState[winningPosition[1]] == advance && gameState[winningPosition[0]] != advanceOp) {
                                num = winningPosition[0];
                                System.out.println("Second " + num);
                                priority = true;
                            }
                        } else if (gameState[winningPosition[0]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2) {
                            if (gameState[winningPosition[0]] == advance && gameState[winningPosition[1]] != advanceOp) {
                                num = winningPosition[1];
                                System.out.println("Third " + num);
                                priority = true;
                            }
                        }
                    }
                }
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
            System.out.println("Final random number "+num);
        }
        else if(firstTurn2==0){
        
        if (difficulty == 0) {
                for (int i = 0; i < gameState.length; i++) {
                    Random r = new Random();
                    int rand = r.nextInt(9);
                    if (gameState[rand] == 2) {
                        num = rand;
                        break;
                    }
                }
            }

            else if (difficulty == 1) {
                priority = false;
                priority2 = true;
                for (int i = 0; i < gameState.length; i++) {
                    Random r = new Random();
                    int rand = r.nextInt(9);
                    if (gameState[rand] == 2) {
                        num = rand;
                        break;
                    }
                }
                System.out.println(num);

                if (!priority) {
                    for (int[] winningPosition : winningPositions) {
                        if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[0]] != 2) {
                            if (gameState[winningPosition[0]] == advanceOp && gameState[winningPosition[2]] != advance) {
                                num = winningPosition[2];
                                System.out.println("First " + num);
                                priority2 = false;
                            }
                        }
                    }
                    for (int[] winningPosition : winningPositions) {
                        if (gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[1]] != 2) {
                            if (gameState[winningPosition[1]] == advanceOp && gameState[winningPosition[0]] != advance) {
                                num = winningPosition[0];
                                System.out.println("Second " + num);
                                priority2 = false;
                            }
                        }
                    }
                    for (int[] winningPosition : winningPositions) {
                        if (gameState[winningPosition[0]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2) {
                            if (gameState[winningPosition[0]] == advanceOp && gameState[winningPosition[1]] != advance) {
                                num = winningPosition[1];
                                System.out.println("Third " + num);
                                priority2 = false;
                            }
                        }
                    }
                }
                if (priority2) {
                    for (int[] winningPosition : winningPositions) {
                        if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[0]] != 2) {
                            if (gameState[winningPosition[0]] == advance && gameState[winningPosition[2]] != advanceOp) {
                                num = winningPosition[2];
                                System.out.println("First " + num);
                                priority = true;
                            }
                        }
                    }
                    for (int[] winningPosition : winningPositions) {
                        if (gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[1]] != 2) {
                            if (gameState[winningPosition[1]] == advance && gameState[winningPosition[0]] != advanceOp) {
                                num = winningPosition[0];
                                System.out.println("Second " + num);
                                priority = true;
                            }
                        }
                    }
                    for (int[] winningPosition : winningPositions) {
                        if (gameState[winningPosition[0]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2) {
                            if (gameState[winningPosition[0]] == advance && gameState[winningPosition[1]] != advanceOp) {
                                num = winningPosition[1];
                                System.out.println("Third " + num);
                                priority = true;
                            }
                        }
                    }
                }
                System.out.println(num);
            }
            else if (difficulty==2){
                priority=false;priority2=true;
                for (int i = 0; i < gameState.length; i++) {
                    Random r2 = new Random();

                    int rand = r2.nextInt(8);
                    if (gameState[rand] == 2) {
                        num = rand;
                        break;
                    }
                }
                System.out.println("num = "+num);
                switch (turn){
                    case 0:
                        if (tappedcounter==4){
                            Random r = new Random();
                            num = allCorners[r.nextInt(allCorners.length)];
                            ready3=true;
                            System.out.println("L1 & num = "+num);
                        }
                        else {
                            for(int check=0;check<allCorners.length;check++){
                                if (tappedcounter==allCorners[check])
                                    ready=true;System.out.println("ready is now true");
                            }
                            if (ready){
                                num=4;
                                System.out.println("L2 & num = "+num);
                            }
                        }
                        break;
                    case 1:
                        if (ready){
                            for (int i=0;i<allMiddle.length;i++) {
                                if (gameState[allMiddle[i]]  == 2)
                                    num = allMiddle[i];
                                System.out.println("L3 & num = "+num);
                            }
                            ready=false;
                        }
                        else if (ready3){
                            for (int i=0;i<allCorners.length;i++) {
                                if (gameState[allCorners[i]] == 2){
                                    num = allCorners[i];
                                    System.out.println("L4 & num = "+num+" & i="+i);
                                    break;
                                }
                            }
                            ready3=false;
                        }
                        break;
                }
                if (!priority) {
                    for (int[] winningPosition : winningPositions) {
                        if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[0]] != 2) {
                            if (gameState[winningPosition[0]] == advanceOp && gameState[winningPosition[2]] != advance) {
                                num = winningPosition[2];
                                System.out.println("First " + num);
                                priority2 = false;
                            }
                        }
                    }
                    for (int[] winningPosition : winningPositions) {
                        if (gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[1]] != 2) {
                            if (gameState[winningPosition[1]] == advanceOp && gameState[winningPosition[0]] != advance) {
                                num = winningPosition[0];
                                System.out.println("Second " + num);
                                priority2 = false;
                            }
                        }
                    }
                    for (int[] winningPosition : winningPositions) {
                        if (gameState[winningPosition[0]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2) {
                            if (gameState[winningPosition[0]] == advanceOp && gameState[winningPosition[1]] != advance) {
                                num = winningPosition[1];
                                System.out.println("Third " + num);
                                priority2 = false;
                            }
                        }
                    }
                }
                if (priority2) {
                    for (int[] winningPosition : winningPositions) {
                        if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[0]] != 2) {
                            if (gameState[winningPosition[0]] == advance && gameState[winningPosition[2]] != advanceOp) {
                                num = winningPosition[2];
                                System.out.println("First " + num);
                                priority = true;
                            }
                        }
                    }
                    for (int[] winningPosition : winningPositions) {
                        if (gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[1]] != 2) {
                            if (gameState[winningPosition[1]] == advance && gameState[winningPosition[0]] != advanceOp) {
                                num = winningPosition[0];
                                System.out.println("Second " + num);
                                priority = true;
                            }
                        }
                    }
                    for (int[] winningPosition : winningPositions) {
                        if (gameState[winningPosition[0]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2) {
                            if (gameState[winningPosition[0]] == advance && gameState[winningPosition[1]] != advanceOp) {
                                num = winningPosition[1];
                                System.out.println("Third " + num);
                                priority = true;
                            }
                        }
                    }
                }

            }
            if (gameState[num] != 2) {
                System.out.println("CONDITION ARISES " + num);
                for (int j = 0; j < gameState.length; j++) {
                    if (gameState[j] == 2) {
                        num = j;
                        System.out.println("number is now " + j);
                        break;
                    }
                }
            }
            System.out.println("FINAL   "+num);
            return num;
        
        }
            return num;
        
        
        
        
    }
    
}
