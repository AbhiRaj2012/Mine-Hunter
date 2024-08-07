package com.example.minehunter;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.gridlayout.widget.GridLayout;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;


import java.util.Random;
import java.util.HashSet;
import java.util.Set;


public class MainActivity extends AppCompatActivity {

    private MediaPlayerUtil mediaPlayerUtil;
    String[] Mines = {"1","2","3","4","5","6"};

    float betAmount = 0;
    float walletAmount = 100;
    float temp,winningAmount;
    int diamond=0;
    boolean result;
    int[] bombs;

    CardView setUpCard, runningCard;
    GridLayout mineField;
    Button mine1, mine2, mine3, mine4, mine5, mine6, mine7, mine8, mine9, mine10, mine11, mine12, mine13, mine14, mine15, mine16;
    EditText wallet, betAmountField,winningAmountField;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayerUtil = new MediaPlayerUtil();

        setUpCard = findViewById(R.id.setupCard);
        runningCard = findViewById(R.id.runningCard);
        mineField = findViewById(R.id.mineField);

        mine1 = findViewById(R.id.b1);
        mine2 = findViewById(R.id.b2);
        mine3 = findViewById(R.id.b3);
        mine4 = findViewById(R.id.b4);
        mine5 = findViewById(R.id.b5);
        mine6 = findViewById(R.id.b6);
        mine7 = findViewById(R.id.b7);
        mine8 = findViewById(R.id.b8);
        mine9 = findViewById(R.id.b9);
        mine10 = findViewById(R.id.b10);
        mine11 = findViewById(R.id.b11);
        mine12 = findViewById(R.id.b12);
        mine13 = findViewById(R.id.b13);
        mine14 = findViewById(R.id.b14);
        mine15 = findViewById(R.id.b15);
        mine16 = findViewById(R.id.b16);

        wallet = findViewById(R.id.wallet);
        betAmountField = findViewById(R.id.betAmount);
        Button startBet = findViewById(R.id.start_button);

        winningAmountField = findViewById(R.id.current_win);
        Button stopBet = findViewById(R.id.stop_withdraw);

        Drawable diamond_back = ContextCompat.getDrawable(MainActivity.this,R.drawable.diamond);
        Drawable bomb_back = ContextCompat.getDrawable(MainActivity.this,R.drawable.time_bomb);



        Spinner numMines = findViewById(R.id.mines);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,R.layout.spinner,Mines);
        adapter.setDropDownViewResource(R.layout.spinner);
        numMines.setAdapter(adapter);



//--------------------------------------------------------------------------------------------------------------

        mineField.setFocusable(false);


        wallet.setText(String.valueOf(walletAmount));
        betAmountField.setText(String.valueOf(betAmount));

        startBet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                betAmount = Float.parseFloat(betAmountField.getText().toString());
                walletAmount = Float.parseFloat(wallet.getText().toString());

                if (betAmount <= walletAmount && betAmount > 0){
                    View v = getCurrentFocus();
                    if (v != null) {
                        // Get the InputMethodManager service
                        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        // Hide the soft keyboard
                        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    }


                    mediaPlayerUtil.playSound(MainActivity.this, R.raw.start);

                    temp = walletAmount - betAmount;
                    wallet.setText(String.valueOf(temp));
                    winningAmountField.setText(String.valueOf(betAmount));

                    temp = Float.parseFloat(numMines.getSelectedItem().toString());
                    bombs = generateUniqueRandomNumbers((int)temp);

                    setUpCard.setVisibility(View.GONE);
                    runningCard.setVisibility(View.VISIBLE);
                    mineField.setFocusable(true);
                    for (int i = 0; i < mineField.getChildCount(); i++) {
                        View child = mineField.getChildAt(i);
                        child.setClickable(true);
                        child.setFocusable(true);
                        child.setEnabled(true);
                    }



                    mine1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            result = containsBomb(bombs,1);
                            if (!result){
                                mine1.setBackground(diamond_back);
                                mine1.setEnabled(false);
                                winningAmountField.setText(String.valueOf(winningAmount));
                            }else{
                                mine1.setBackground(bomb_back);
                            }
                        }
                    });

                    mine2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            result = containsBomb(bombs,2);
                            if (!result){
                                mine2.setBackground(diamond_back);
                                mine2.setEnabled(false);
                                winningAmountField.setText(String.valueOf(winningAmount));
                            }else{
                                mine2.setBackground(bomb_back);

                            }
                        }
                    });

                    mine3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            result = containsBomb(bombs,3);
                            if (!result){
                                mine3.setBackground(diamond_back);
                                mine3.setEnabled(false);
                                winningAmountField.setText(String.valueOf(winningAmount));
                            }else{
                                mine3.setBackground(bomb_back);

                            }
                        }
                    });

                    mine4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            result = containsBomb(bombs,4);
                            if (!result){
                                mine4.setBackground(diamond_back);
                                mine4.setEnabled(false);
                                winningAmountField.setText(String.valueOf(winningAmount));
                            }else{
                                mine4.setBackground(bomb_back);

                            }
                        }
                    });

                    mine5.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            result = containsBomb(bombs,5);
                            if (!result){
                                mine5.setBackground(diamond_back);
                                mine5.setEnabled(false);
                                winningAmountField.setText(String.valueOf(winningAmount));
                            }else{
                                mine5.setBackground(bomb_back);

                            }
                        }
                    });

                    mine6.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            result = containsBomb(bombs,6);
                            if (!result){
                                mine6.setBackground(diamond_back);
                                mine6.setEnabled(false);
                                winningAmountField.setText(String.valueOf(winningAmount));
                            }else{
                                mine6.setBackground(bomb_back);

                            }
                        }
                    });

                    mine7.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            result = containsBomb(bombs,7);
                            if (!result){
                                mine7.setBackground(diamond_back);
                                mine7.setEnabled(false);
                                winningAmountField.setText(String.valueOf(winningAmount));
                            }else{
                                mine7.setBackground(bomb_back);

                            }
                        }
                    });

                    mine8.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            result = containsBomb(bombs,8);
                            if (!result){
                                mine8.setBackground(diamond_back);
                                mine8.setEnabled(false);
                                winningAmountField.setText(String.valueOf(winningAmount));
                            }else{
                                mine8.setBackground(bomb_back);

                            }
                        }
                    });

                    mine9.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            result = containsBomb(bombs,9);
                            if (!result){
                                mine9.setBackground(diamond_back);
                                mine9.setEnabled(false);
                                winningAmountField.setText(String.valueOf(winningAmount));
                            }else{
                                mine9.setBackground(bomb_back);

                            }
                        }
                    });

                    mine10.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            result = containsBomb(bombs,10);
                            if (!result){
                                mine10.setBackground(diamond_back);
                                mine10.setEnabled(false);
                                winningAmountField.setText(String.valueOf(winningAmount));
                            }else{
                                mine10.setBackground(bomb_back);

                            }
                        }
                    });

                    mine11.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            result = containsBomb(bombs,11);
                            if (!result){
                                mine11.setBackground(diamond_back);
                                mine11.setEnabled(false);
                                winningAmountField.setText(String.valueOf(winningAmount));
                            }else{
                                mine11.setBackground(bomb_back);

                            }
                        }
                    });

                    mine12.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            result = containsBomb(bombs,12);
                            if (!result){
                                mine12.setBackground(diamond_back);
                                mine12.setEnabled(false);
                                winningAmountField.setText(String.valueOf(winningAmount));
                            }else{
                                mine12.setBackground(bomb_back);

                            }
                        }
                    });

                    mine13.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            result = containsBomb(bombs,13);
                            if (!result){
                                mine13.setBackground(diamond_back);
                                mine13.setEnabled(false);
                                winningAmountField.setText(String.valueOf(winningAmount));
                            }else{
                                mine13.setBackground(bomb_back);

                            }
                        }
                    });

                    mine14.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            result = containsBomb(bombs,14);
                            if (!result){
                                mine14.setBackground(diamond_back);
                                mine14.setEnabled(false);
                                winningAmountField.setText(String.valueOf(winningAmount));
                            }else{
                                mine14.setBackground(bomb_back);

                            }
                        }
                    });

                    mine15.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            result = containsBomb(bombs,15);
                            if (!result){
                                mine15.setBackground(diamond_back);
                                mine15.setEnabled(false);
                                winningAmountField.setText(String.valueOf(winningAmount));
                            }else{
                                mine15.setBackground(bomb_back);

                            }
                        }
                    });

                    mine16.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            result = containsBomb(bombs,16);
                            if (!result){
                                mine16.setBackground(diamond_back);
                                mine16.setEnabled(false);
                                winningAmountField.setText(String.valueOf(winningAmount));
                            }else{
                                mine16.setBackground(bomb_back);

                            }

                        }
                    });

                    stopBet.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            mediaPlayerUtil.playSound(MainActivity.this, R.raw.withdraw);
                            decisionPopUp(true);

                        }
                    });

                }
                else if(betAmount > walletAmount){

                    mediaPlayerUtil.playSound(MainActivity.this, R.raw.empty);
                    Toast.makeText(MainActivity.this,"Bet is higher than the Balance",Toast.LENGTH_LONG).show();

                }
                else{
                    mediaPlayerUtil.playSound(MainActivity.this, R.raw.empty);
                    Toast.makeText(MainActivity.this,"Not Sufficient Bet",Toast.LENGTH_LONG).show();
                }
            }
        });


    }

//--------------------------------------------------------------------------------------------------------

    public static int[] generateUniqueRandomNumbers(int n) {
        Random random = new Random();
        Set<Integer> uniqueNumbers = new HashSet<>();
        int[] result = new int[n];
        int index = 0;

        while (uniqueNumbers.size() < n) {
            int randomNumber = random.nextInt(16) + 1; // Generates a number between 1 and 16
            if (!uniqueNumbers.contains(randomNumber)) {
                uniqueNumbers.add(randomNumber);
                result[index++] = randomNumber;
            }
        }
        return result;
    }

    @SuppressLint("SetTextI18n")
    private void decisionPopUp(boolean decision) {

        Dialog dialog = new Dialog(MainActivity.this, R.style.DialogStyle);
        dialog.setContentView(R.layout.popup);
        dialog.setCancelable(false);

        TextView greet = dialog.findViewById(R.id.greetText);
        TextView result = dialog.findViewById(R.id.resultText);
        TextView value = dialog.findViewById(R.id.winText);
        LottieAnimationView animation = dialog.findViewById(R.id.anim);

        if (!decision){//for loss condition
            if (walletAmount - betAmount >= 1){
                walletAmount = walletAmount - betAmount;
            }else{
                rechargePopUp();
                walletAmount = 100;
            }


            animation.setAnimation(R.raw.game_over);
            animation.setRepeatCount(LottieDrawable.INFINITE);
            greet.setText("Got Mine!");
            result.setText("You Lose");
            value.setTextColor(ContextCompat.getColor(MainActivity.this,R.color.red));
            value.setText(String.valueOf(betAmount));

        }else{
            walletAmount = walletAmount + winningAmount;
            // for win condition
            animation.setAnimation(R.raw.treasure);
            greet.setText("Well Played!");
            result.setText("You Won");
            value.setText(String.valueOf(winningAmount));
        }


        Button playAgain = dialog.findViewById(R.id.play_again);
        playAgain.setOnClickListener(view -> {
            reset();
            mediaPlayerUtil.playSound(MainActivity.this, R.raw.start);
            dialog.cancel();
        });
        dialog.show();
    }

    public boolean containsBomb(int[] array, int number) {   // Loop through each number in the array
        for (int currentNumber : array) {
            if (currentNumber == number) {
                mediaPlayerUtil.playSound(MainActivity.this, R.raw.bomb);
                decisionPopUp(false);
                return true;
            }
        }

        mediaPlayerUtil.playSound(MainActivity.this, R.raw.correct);
        diamond = diamond + 1;
        winningAmount = betAmount + (betAmount * (diamond * (temp / 3)));
        return false;
    }

    private void reset(){

        setUpCard.setVisibility(View.VISIBLE);
        runningCard.setVisibility(View.GONE);
        wallet.setText(String.valueOf(walletAmount));

        for (int i = 0; i < mineField.getChildCount(); i++) {
            View child = mineField.getChildAt(i);
            child.setClickable(false);
            child.setFocusable(false);
            child.setEnabled(false);
            child.setBackground(ContextCompat.getDrawable(MainActivity.this, R.drawable.butt_back));
        }

        betAmount = 0;
        diamond = 0;
        betAmountField.setText("0");

    }

    private void rechargePopUp() {

        Dialog dialog = new Dialog(MainActivity.this, R.style.DialogStyle);
        dialog.setContentView(R.layout.recharge);
        dialog.setCancelable(false);

        Button startAgain = dialog.findViewById(R.id.start_again);
        startAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayerUtil.playSound(MainActivity.this, R.raw.start);
                dialog.cancel();
            }
        });

        dialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayerUtil.release();
    }
}

