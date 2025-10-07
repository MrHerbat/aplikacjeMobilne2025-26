package com.example.buttongrid;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;

public class MainActivity extends AppCompatActivity {
    private boolean ticTacToe = true;
    private Button[][] buttonBoard = new Button[3][3];
    private char board[][] = new char[3][3];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getButtons();
        ResetBoard();
    }
    public void SetClickedButtonToX(View view){
        Button clickedButton = findViewById(view.getId());
        if(clickedButton.getText().equals(" "))
        {
            if(ticTacToe){
                clickedButton.setText("X");
                clickedButton.setEnabled(false);
                ticTacToe=false;
            }else{
                clickedButton.setText("O");
                clickedButton.setEnabled(false);
                ticTacToe=true;
            }
        }
        getButtons();
        HasWon();
    }
    public void HasWon(){
        for (int i = 0; i < 3; i++) {
            if((board[i][0]==board[i][1]&&board[i][1]==board[i][2])&&
                    (board[i][0]!=' '&&board[i][1]!=' '&&board[i][2]!=' ')){
                buttonBoard[i][0].setBackgroundColor(getResources().getColor(R.color.green));
                buttonBoard[i][1].setBackgroundColor(getResources().getColor(R.color.green));
                buttonBoard[i][2].setBackgroundColor(getResources().getColor(R.color.green));
                LockAllButtons();
            }
        }
        for (int i = 0; i < 3; i++) {
            if((board[0][i]==board[1][i]&&board[0][i]==board[2][i])&&
                    (board[0][i]!=' '&&board[1][i]!=' '&&board[2][i]!=' ')){
                buttonBoard[0][i].setBackgroundColor(getResources().getColor(R.color.green));
                buttonBoard[1][i].setBackgroundColor(getResources().getColor(R.color.green));
                buttonBoard[2][i].setBackgroundColor(getResources().getColor(R.color.green));
                LockAllButtons();
            }
        }
        if ((board[0][0] == board[1][1] && board[1][1] == board[2][2])&&
                (board[0][0]!=' '&&board[1][1]!=' '&&board[2][2]!=' ')) {
            buttonBoard[0][0].setBackgroundColor(getResources().getColor(R.color.green));
            buttonBoard[1][1].setBackgroundColor(getResources().getColor(R.color.green));
            buttonBoard[2][2].setBackgroundColor(getResources().getColor(R.color.green));
            LockAllButtons();
        }
        if ((board[2][0] == board[1][1] && board[1][1] == board[0][2])&&
                (board[2][0]!=' '&&board[1][1]!=' '&&board[0][2]!=' ')) {
            buttonBoard[2][0].setBackgroundColor(getResources().getColor(R.color.green));
            buttonBoard[1][1].setBackgroundColor(getResources().getColor(R.color.green));
            buttonBoard[0][2].setBackgroundColor(getResources().getColor(R.color.green));
            LockAllButtons();
        }
    }
    public void ResetBoard(View view){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttonBoard[i][j].setText(" ");
                buttonBoard[i][j].setEnabled(true);
                buttonBoard[i][j].setBackgroundColor(getResources().getColor(R.color.purple));
            }
        }
    }
    public void ResetBoard(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttonBoard[i][j].setText(" ");
                buttonBoard[i][j].setEnabled(true);
                buttonBoard[i][j].setBackgroundColor(getResources().getColor(R.color.purple));
            }
        }
    }
    public void LockAllButtons(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttonBoard[i][j].setEnabled(false);
            }
        }
    }
    public void getButtons(){
        int x=1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int id = getResources().getIdentifier("button"+x,"id",getPackageName());
                buttonBoard[i][j]=(Button) findViewById(id);
                board[i][j]=buttonBoard[i][j].getText().charAt(0);
                buttonBoard[i][j].setTextColor(getResources().getColor(R.color.black));
                x++;
            }
        }
    }
}