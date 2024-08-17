package com.vedikatechlabs.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    String b1, b2, b3, b4, b5, b6, b7, b8, b9;
    int flag;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        init();

        //res
        // tart button logic to perform start new game
        ImageView imageView = findViewById(R.id.again);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View response) {
                newGame();
                enableButtons();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void init()
    {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
    }

    public void check(View view)
    {
        Button currentBtn = (Button) view;

        //To identify button is already filled or not
        if (currentBtn.getText().toString().isEmpty())
        {
            //each time button click counter increases
            counter++;
            //Toggle between X & O
            if (flag == 0){
                currentBtn.setText("X");
                flag = 1;
            } else {
                currentBtn.setText("O");
                flag = 0;
            }

            //Start checking winner after 4 chances bcz before 4 their is not chance to win game
            if (counter > 4){
                b1 = btn1.getText().toString();
                b2 = btn2.getText().toString();
                b3 = btn3.getText().toString();
                b4 = btn4.getText().toString();
                b5 = btn5.getText().toString();
                b6 = btn6.getText().toString();
                b7 = btn7.getText().toString();
                b8 = btn8.getText().toString();
                b9 = btn9.getText().toString();

                //conditions to check winner!!!
                if (b1.equals(b2) && b2.equals(b3) && !b1.isEmpty()){
                    //1
                    Toast.makeText(this,"Winner <<< "+b1, Toast.LENGTH_LONG).show();
                    disableButtons();
                } else if (b4.equals(b5) && b5.equals(b6) && !b4.isEmpty()) {
                    //2
                    Toast.makeText(this, "Winner <<< "+b4, Toast.LENGTH_LONG).show();
                    disableButtons();
                } else if (b7.equals(b8) && b8.equals(b9) && !b7.isEmpty()) {
                    //3
                    Toast.makeText(this, "Winner <<< "+b7, Toast.LENGTH_LONG).show();
                    disableButtons();
                } else if (b1.equals(b4) && b4.equals(b7) && !b1.isEmpty()) {
                    //4
                    Toast.makeText(this, "Winner <<< "+b1, Toast.LENGTH_LONG).show();
                    disableButtons();
                } else if (b2.equals(b5) && b5.equals(b8) && !b2.isEmpty()) {
                    //5
                    Toast.makeText(this, "Winner <<< "+b2, Toast.LENGTH_LONG).show();
                    disableButtons();
                } else if (b3.equals(b6) && b6.equals(b9) && !b3.isEmpty()) {
                    //6
                    Toast.makeText(this, "Winner <<< "+b3, Toast.LENGTH_LONG).show();
                    disableButtons();
                } else if (b1.equals(b5) && b5.equals(b9) && !b1.isEmpty()) {
                    //7
                    Toast.makeText(this, "Winner <<< "+b5, Toast.LENGTH_LONG).show();
                    disableButtons();
                } else if (b3.equals(b5) && b5.equals(b7) && !b3.isEmpty()) {
                    //8
                    Toast.makeText(this, "Winner <<< "+b3, Toast.LENGTH_LONG).show();
                    disableButtons();
                } else if (counter==9) {
                    Toast.makeText(this, "<<< Game Drawn! >>>", Toast.LENGTH_SHORT).show();
                }
            }
        }

    }
    public void newGame() {
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        flag = 0;
        counter = 0;
    }
    //Enable buttons to start the game
    private void enableButtons() {
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        btn7.setEnabled(true);
        btn8.setEnabled(true);
        btn9.setEnabled(true);
    }

    //Method to disable all the buttons
    private void disableButtons() {
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);
    }

}