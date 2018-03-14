package com.blacio.touchgame;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;


public class MenuActivity extends Activity {

    SharedPreferences sharedPrefr;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


            sharedPrefr = getSharedPreferences("Pos", Context.MODE_PRIVATE);
            pos = sharedPrefr.getInt("Pos", 1);

            AudioPlay.playAudio(this,R.raw.tg3);

    }

    public void onLevels(View view) {

        Intent i = new Intent(this, LevelsActivity.class);
        i.putExtra("Pos", pos);
        startActivity(i);
    }

    public void onInstruction(View view) {
        Intent i = new Intent(this, InstructionsActivity.class);
        startActivity(i);
    }

    public void onNew(View view) {

        AlertDialog.Builder myDialog = new AlertDialog.Builder(MenuActivity.this);
        View myview = getLayoutInflater().inflate(R.layout.dialog_box, null);

        Button yes = (Button) myview.findViewById(R.id.yes);
        Button no = (Button) myview.findViewById(R.id.no);

        myDialog.setView(myview);
        final AlertDialog dialog = myDialog.create();
        dialog.show();

        yes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                stopPlaying();

                dialog.dismiss();

                pos = 1;

                SharedPreferences.Editor editor2 = sharedPrefr.edit();
                editor2.putInt("Pos", pos);
                editor2.apply();

                startIntent();
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }


    public void onContinue(View view) {

        stopPlaying();
        startIntent();

    }

    private void startIntent() {

        Intent i = new Intent(this, GameActivity.class);
        i.putExtra("POSITION", pos);
        i.putExtra("bool_dialog",true);
        startActivity(i);

    }

    @Override
    protected void onPause() {
        AudioPlay.pauseAudio();
        super.onPause();
    }


    @Override
    protected void onResume() {
        super.onResume();
        AudioPlay.resumeAudio();
    }

    @Override
    public void onBackPressed() {
    }

    public void stopPlaying(){
        AudioPlay.stopAudio();
    }


}