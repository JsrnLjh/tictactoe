/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apps;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author jasar
 */
public class TicTacToe {
    
    int borderwidth = 600;
    int borderheight = 650;
    
    
    JFrame frame = new JFrame();
    
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    
    JPanel boardpanel = new JPanel();
    JButton [][] board = new JButton[3][3];
    
    String player1 = "X";
    String player2 = "O";
    
    String currentplayer = player1;
    
    Boolean GameOver = false;
    
    int turns = 0;
    
    
    TicTacToe(){
        
        frame.setVisible(true);
        frame.setSize(borderwidth, borderheight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        textLabel.setBackground(Color.darkGray);
        textLabel.setForeground(Color.BLACK);
        textLabel.setFont(new Font("Arial", Font.BOLD, 50));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("TIC-TAC-TOE");
        textLabel.setOpaque(true);
        
        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel, BorderLayout.NORTH);
        
        boardpanel.setLayout(new GridLayout(3,3));
        boardpanel.setBackground(Color.darkGray);
        frame.add(boardpanel);
        
        
        for(int r = 0; r < 3; r++){
            for(int c = 0; c < 3; c++){
                JButton tile = new JButton();
                board[r][c] = tile;
                boardpanel.add(tile);
                tile.setBackground(Color.darkGray);
                tile.setForeground(Color.white);
                tile.setFont(new Font("Arial",Font.BOLD, 120));
                tile.setFocusable(false);
                
               
                tile.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        if(GameOver)return;
                        JButton tile = (JButton) e.getSource();
                        if(tile.getText()==""){
                            tile.setText(currentplayer);
                            turns++;
                            checkWinner();
                            if(!GameOver){
                                currentplayer = currentplayer == player1 ? player2 : player1;
                                textLabel.setText(currentplayer + "'s Turn");
                            }
                        }   
                    }
                    
                });
            }
        }
    }
void checkWinner(){
    //horizontal
    for(int r = 0; r < 3; r++){
        
        if(board[r][0].getText() == "") continue;
        
        if(board[r][0].getText() == board[r][1].getText() && 
           board[r][1].getText() == board[r][2].getText()){
           for(int i = 0; i < 3; i++){
               setWinner(board[r][i]);
           }
           GameOver = true;  
           return;
        }      
    }
    //vertical
    for(int c = 0; c < 3; c++){
        
        if(board[0][c].getText() == "") continue;
        
        if(board[0][c].getText() == board[1][c].getText() && 
           board[1][c].getText() == board[2][c].getText()){
           for(int i = 0; i < 3; i++){
               setWinner(board[i][c]);
           }
           GameOver = true;  
           return;
        }      
    }
    //diagonal
    if(board[0][0].getText() == board[1][1].getText() && 
       board[1][1].getText() == board[2][2].getText() &&
       board[0][0].getText() != ""){
       for(int i = 0; i < 3; i++){
            setWinner(board[i][i]);
       }
       GameOver = true;  
       return;
       }
    //anti-diagonal
    if(board[0][2].getText() == board[1][1].getText() && 
       board[1][1].getText() == board[2][0].getText() &&
       board[0][2].getText() != ""){
       setWinner(board[2][0]);
       setWinner(board[1][1]);
       setWinner(board[0][2]);
       GameOver = true;  
       return;
       }
    
    if(turns == 9){
        for(int r = 0; r < 3; r++){
            for(int c = 0; c < 3; c++){
                setTie(board[r][c]);
            }
        }
        GameOver = true;
    }
    
    
}


























void setWinner(JButton tile){
    tile.setForeground(Color.green);
    tile.setBackground(Color.gray);
    textLabel.setText(currentplayer + "is the WINNER!");
}

void setTie(JButton tile){

    tile.setForeground(Color.red);
    tile.setBackground(Color.gray);
    textLabel.setText("It's a TIE");
}

    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
