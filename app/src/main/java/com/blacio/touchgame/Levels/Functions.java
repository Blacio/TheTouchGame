package com.blacio.touchgame.Levels;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.blacio.touchgame.AudioPlay;
import com.blacio.touchgame.MenuActivity;
import com.blacio.touchgame.R;

import java.util.Random;


public class Functions {

    private int[] nou = new int[4];
    private int k;
    private int sw;
    int random;

    private Context con;
     private SharedPreferences sharedPrefr;


    public Functions(Context con) {
        this.con = con;
    }

    public int set_color(int v[], boolean b,boolean j,int nr) {

        if (b) {
            k = 0;
            nou[0] = -1;
            nou[1] = -1;
            nou[2] = -1;
            nou[3] = -1;

            for (int i = 0; i < 4; i++)
                if (v[i] != 0) {
                    nou[k] = i;
                    k++;
                }

            if(k!=0)
                sw = random_nr(0, k);
            else
                {sw=0;nou[sw]=4;}
        } else {
            sw = 0;
            nou[sw] = nr;
        }

        if(j) nou[sw]+=5;

        switch (nou[sw]) {
            case 0:
                return R.drawable.button_blue;
            case 1:
                return R.drawable.button_yellow;
            case 2:
                return R.drawable.button_red;
            case 3:
                return R.drawable.button_green;
            case 4:
                return R.drawable.button_white;
            case 5:
                return R.drawable.button_blue2;
            case 6:
                return R.drawable.button_yellow2;
            case 7:
                return R.drawable.button_red2;
            case 8:
                return R.drawable.button_green2;
            default:
                return R.drawable.button_white2;
        }

    }

    public int get_k() {
        return nou[sw];
    }

    public int random_nr(int start, int end) {

        if (start == end)
            random = start;
        else {
            Random rnd = new Random();
            random = start + rnd.nextInt(end - start);
        }
        return random;
    }


    public boolean was_pressed(int []v){

            if ((v[1] - v[0]) > 500)
                return true;
            else return false;
    }

    public boolean verify_time(int []v,int t){

        if ((v[1] - v[0] > t-400) && (v[1] - v[0] < t+400 ))
            return true;
        else return false;
    }


    public int get_color(int col){

        switch (col) {
            case 0:
                nou[sw]+=5;
                return R.drawable.button_blue2;
            case 1:
                nou[sw]+=5;
                return R.drawable.button_yellow2;
            case 2:
                nou[sw]+=5;
                return R.drawable.button_red2;
            case 3:
                nou[sw]+=5;
                return R.drawable.button_green2;
            case 4:
                nou[sw]+=5;
                return R.drawable.button_white2;
            case 5:
                nou[sw]-=5;
                return R.drawable.button_blue;
            case 6:
                nou[sw]-=5;
                return R.drawable.button_yellow;
            case 7:
                nou[sw]-=5;
                return R.drawable.button_red;
            case 8:
                nou[sw]-=5;
                return R.drawable.button_green;
            case 9:
                nou[sw]-=5;
                return R.drawable.button_white;
            default:
                nou[sw]+=5;
                return R.drawable.button_white2;
        }
    }


    public boolean dialog_message(final int complete, int prog,final int n, int sw, final Class cls, final int pos) {

        if(sw!=5){

            if (complete == prog && complete < n) return false;

            else {
                AlertDialog.Builder myDialog = new AlertDialog.Builder(con);
                myDialog.setCancelable(false);
                LayoutInflater inflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View myview = inflater.inflate(R.layout.dialog_box, null);

                Button yes = (Button) myview.findViewById(R.id.yes);
                Button no = (Button) myview.findViewById(R.id.no);
                TextView tv = (TextView) myview.findViewById(R.id.dialog_text);

                myDialog.setView(myview);
                final AlertDialog dialog = myDialog.create();
                dialog.show();


                AudioPlay.playAudio(con,R.raw.tg1);

                if (complete == n) {

                    sharedPrefr = con.getSharedPreferences("Pos", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor2 = sharedPrefr.edit();
                    editor2.putInt("Pos", pos+1);
                    editor2.apply();

                    if(pos==20)
                        tv.setText(R.string.good_dialog_game);
                    else
                        tv.setText(R.string.good_dialog);

                    yes.setText("NEXT");
                } else {
                    tv.setText(R.string.bad_dialog);
                    yes.setText("RETRY");
                }

                no.setText("Cancel");


                yes.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                        AudioPlay.stopAudio();
                        dialog.dismiss();
                        Intent i = new Intent(con, cls);

                        if(complete==n) {
                            i.putExtra("POSITION", pos + 1);
                            i.putExtra("bool_dialog",true);
                        }

                        else {
                            i.putExtra("POSITION",pos);
                            i.putExtra("bool_dialog",false);
                        }



                        con.startActivity(i);
                    }
                });

                no.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

                        AudioPlay.stopAudio();
                        dialog.dismiss();

                        Intent i = new Intent(con, MenuActivity.class);
                        con.startActivity(i);
                    }
                });
            }
            return true;
        }
        return true;}
    }
