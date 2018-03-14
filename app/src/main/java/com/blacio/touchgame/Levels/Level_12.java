package com.blacio.touchgame.Levels;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.blacio.touchgame.GameActivity;
import com.blacio.touchgame.R;

public class Level_12 extends Variables{

    MediaPlayer mp,mpp;
    public Level_12(Button b, Context context) {
        mp = MediaPlayer.create(context, R.raw.corect);
        mpp = MediaPlayer.create(context,R.raw.gresit);
        but = b;

        obj = new Functions(context);

        p1 = 3000;
        c1 = obj.random_nr(800,1200);
        p2 = obj.random_nr(300,700);
        c2 = obj.random_nr(800,1300);
        p3 = obj.random_nr(300,700);
        c3 = obj.random_nr(800,1200);
        p4 = obj.random_nr(300,700);
        c4 = obj.random_nr(800,1300);

        color_nr = new int[]{1,2,2,1};

        but.setBackgroundResource(obj.set_color(color_nr, false,touched,4));

        new Operation().execute();


        but.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    try {
                        mp.start();
                    }catch(Exception e){}
                    touched = true;
                    but.setBackgroundResource(obj.get_color(obj.get_k()));

                    k[0] = (int) SystemClock.elapsedRealtime();

                }


                else if (event.getAction() == MotionEvent.ACTION_UP) {
                    try {
                        mpp.start();
                    }catch(Exception e){}
                    touched = false;
                    but.setBackgroundResource(obj.get_color(obj.get_k()));
                    k[1] = (int) SystemClock.elapsedRealtime();

                    if(obj.was_pressed(k)) complete=-1;
                    else complete++;

                }

                return false;
            }
        });
    }

    private class Operation extends AsyncTask<String, Void, String> {


        @Override
        protected String doInBackground(String... params) {

            try {

                Thread.sleep(p1);
                publishProgress();
                if(sw!=5){
                    Thread.sleep(c1);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(p2);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(c2);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(p3);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(c3);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(p4);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(c4);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(p4);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(c1);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(p3);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(c2);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(p3);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(c3);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(p2);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(c4);
                    publishProgress();}


            } catch (InterruptedException e) {
                Thread.interrupted();
            }

            return "1";
        }

        @Override
        protected void onPostExecute(String result) {
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onProgressUpdate(Void... values) {

            switch (progress) {
                case 0:
                    if(obj.dialog_message(complete,should,6,sw,GameActivity.class,12)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[obj.get_k()%5]--;

                    if(obj.get_k()%5==2 && color_nr[2]==1){
                        should+=2;
                    }
                    else if(obj.get_k()%5==2 && color_nr[2]==0){
                        should++;

                        if(color_nr[0]==0)
                            aux=1;
                        else aux=2;

                        color_nr[0]=2;

                    }
                    else if(obj.get_k()%5==0){
                        if(aux==0) {
                            should++;
                        }
                        else if (aux==1 && color_nr[0]==0)
                            should+=2;
                        else if(aux==2)
                        {
                            if (color_nr[0]==1) should++;
                            else should+=2;
                        }

                    }


                    progress=1;

                    break;

                case 1:
                    if(obj.dialog_message(complete,should,6,sw,GameActivity.class,12)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, false, touched, 4));
                    progress=0;

                    break;


                default:
                    should=6;
                    if(obj.dialog_message(complete,should,4,sw,GameActivity.class,12)) {sw=5;break;}
                    break;
            }
        }
    }
}

