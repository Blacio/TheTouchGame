package com.blacio.touchgame;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.blacio.touchgame.Levels.*;

public class GameActivity extends Activity {

    Button but;
    TextView text;
    Context cont;
    boolean index;

    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);



        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        } else{
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

        cont = this;

        but = (Button) findViewById(R.id.button_game);
        text = (TextView) findViewById(R.id.task);

        Bundle extras = getIntent().getExtras();
        pos = extras.getInt("POSITION");
        index = extras.getBoolean("bool_dialog");


        if(index) {
            AlertDialog.Builder myDialog = new AlertDialog.Builder(GameActivity.this);
            myDialog.setCancelable(false);
            View myview = getLayoutInflater().inflate(R.layout.dialog_box, null);

                AudioPlay.playAudio(this,R.raw.tg1);

            Button yes = (Button) myview.findViewById(R.id.yes);
            Button no = (Button) myview.findViewById(R.id.no);
            TextView dialog_text = (TextView) myview.findViewById(R.id.dialog_text);


            switch (pos) {
                case 1:
                    dialog_text.setText(R.string.task_1);
                    text.setText(R.string.task_1);
                    break;
                case 2:
                    dialog_text.setText(R.string.task_2);
                    text.setText(R.string.task_2);
                    break;
                case 3:
                    dialog_text.setText(R.string.task_3);
                    text.setText(R.string.task_3);
                    break;
                case 4:
                    dialog_text.setText(R.string.task_4);
                    text.setText(R.string.task_4);
                    break;
                case 5:
                    dialog_text.setText(R.string.task_5);
                    text.setText(R.string.task_5);
                    break;
                case 6:
                    dialog_text.setText(R.string.task_6);
                    text.setText(R.string.task_6);
                    break;
                case 7:
                    dialog_text.setText(R.string.task_7);
                    text.setText(R.string.task_7);
                    break;
                case 8:
                    dialog_text.setText(R.string.task_8);
                    text.setText(R.string.task_8);
                    break;
                case 9:
                    dialog_text.setText(R.string.task_9);
                    text.setText(R.string.task_9);
                    break;
                case 10:
                    dialog_text.setText(R.string.task_10);
                    text.setText(R.string.task_10);
                    break;
                case 11:
                    dialog_text.setText(R.string.task_11);
                    text.setText(R.string.task_11);
                    break;
                case 12:
                    dialog_text.setText(R.string.task_12);
                    text.setText(R.string.task_12);
                    break;
                case 13:
                    dialog_text.setText(R.string.task_13);
                    text.setText(R.string.task_13);
                    break;
                case 14:
                    dialog_text.setText(R.string.task_14);
                    text.setText(R.string.task_14);
                    break;
                case 15:
                    dialog_text.setText(R.string.task_15);
                    text.setText(R.string.task_15);
                    break;
                case 16:
                    dialog_text.setText(R.string.task_16);
                    text.setText(R.string.task_16);
                    break;
                case 17:
                    dialog_text.setText(R.string.task_17);
                    text.setText(R.string.task_17);
                    break;
                case 18:
                    dialog_text.setText(R.string.task_18);
                    text.setText(R.string.task_18);
                    break;
                case 19:
                    dialog_text.setText(R.string.task_19);
                    text.setText(R.string.task_19);
                    break;
                case 20:
                    dialog_text.setText(R.string.task_20);
                    text.setText(R.string.task_20);
                    break;
                default:
                    startIntent();
                    break;
            }


            myDialog.setView(myview);
            final AlertDialog dialog = myDialog.create();
            dialog.show();

            yes.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    AudioPlay.stopAudio();

                    dialog.dismiss();

                    switch (pos) {
                        case 1:
                            new Level_1(but, cont);
                            break;
                        case 2:
                            new Level_2(but, cont);
                            break;
                        case 3:
                            new Level_3(but, cont);
                            break;
                        case 4:
                            new Level_4(but, cont);
                            break;
                        case 5:
                            new Level_5(but, cont);
                            break;
                        case 6:
                            new Level_6(but, cont);
                            break;
                        case 7:
                            new Level_7(but, cont);
                            break;
                        case 8:
                            new Level_8(but, cont);
                            break;
                        case 9:
                            new Level_9(but, cont);
                            break;
                        case 10:
                            new Level_10(but, cont);
                            break;
                        case 11:
                            new Level_11(but, cont);
                            break;
                        case 12:
                            new Level_12(but, cont);
                            break;
                        case 13:
                            new Level_13(but, cont);
                            break;
                        case 14:
                            new Level_14(but, cont);
                            break;
                        case 15:
                            new Level_15(but, cont);
                            break;
                        case 16:
                            new Level_16(but, cont);
                            break;
                        case 17:
                            new Level_17(but, cont);
                            break;
                        case 18:
                            new Level_18(but, cont);
                            break;
                        case 19:
                            new Level_19(but, cont);
                            break;
                        case 20:
                            new Level_20(but, cont);
                            break;
                        default:
                            startIntent();
                            break;
                    }
                }
            });

            no.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    startIntent();
                }
            });
        }

        else{
            switch (pos) {
                case 1:
                    text.setText(R.string.task_1);
                    new Level_1(but, cont);
                    break;
                case 2:
                    text.setText(R.string.task_2);
                    new Level_2(but, cont);
                    break;
                case 3:
                    text.setText(R.string.task_3);
                    new Level_3(but, cont);
                    break;
                case 4:
                    text.setText(R.string.task_4);
                    new Level_4(but, cont);
                    break;
                case 5:
                    text.setText(R.string.task_5);
                    new Level_5(but, cont);
                    break;
                case 6:
                    text.setText(R.string.task_6);
                    new Level_6(but, cont);
                    break;
                case 7:
                    text.setText(R.string.task_7);
                    new Level_7(but, cont);
                    break;
                case 8:
                    text.setText(R.string.task_8);
                    new Level_8(but, cont);
                    break;
                case 9:
                    text.setText(R.string.task_9);
                    new Level_9(but, cont);
                    break;
                case 10:
                    text.setText(R.string.task_10);
                    new Level_10(but, cont);
                    break;
                case 11:
                    text.setText(R.string.task_11);
                    new Level_11(but, cont);
                    break;
                case 12:
                    text.setText(R.string.task_12);
                    new Level_12(but, cont);
                    break;
                case 13:
                    text.setText(R.string.task_13);
                    new Level_13(but, cont);
                    break;
                case 14:
                    text.setText(R.string.task_14);
                    new Level_14(but, cont);
                    break;
                case 15:
                    text.setText(R.string.task_15);
                    new Level_15(but, cont);
                    break;
                case 16:
                    text.setText(R.string.task_16);
                    new Level_16(but, cont);
                    break;
                case 17:
                    text.setText(R.string.task_17);
                    new Level_17(but, cont);
                    break;
                case 18:
                    text.setText(R.string.task_18);
                    new Level_18(but, cont);
                    break;
                case 19:
                    text.setText(R.string.task_19);
                    new Level_19(but, cont);
                    break;
                case 20:
                    text.setText(R.string.task_20);
                    new Level_20(but, cont);
                    break;
                default:
                    startIntent();
                    break;
            }
        }

    }

    private void startIntent() {

        Intent i = new Intent(this, MenuActivity.class);
        i.putExtra("POSITION", pos);
        startActivity(i);
    }


    @Override
    public void onBackPressed() {
    }

    @Override
    protected void onPause() {
        super.onPause();

        AudioPlay.stopAudio();
    }
}