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

public class Level_4 extends Variables{


    MediaPlayer mp,mpp;
    public Level_4(Button b, Context context) {

        mp = MediaPlayer.create(context, R.raw.corect);
        mpp = MediaPlayer.create(context,R.raw.gresit);
        but = b;

        obj = new Functions(context);

        p1 = 2000;
        c1 = obj.random_nr(400,700);
        p2 = obj.random_nr(700,1200);
        c2 = obj.random_nr(700,1000);
        c3 = obj.random_nr(600,1000);
        c4 = 700;

        color_nr = new int[]{1, 1, 1, 0};

        but.setBackgroundResource(obj.set_color(color_nr, false,touched,4));

        new Operation().execute();


        but.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction()==MotionEvent.ACTION_DOWN) {
                    try {
                        mp.start();
                    }catch(Exception e){}
                    touched=true;

                    k[1] = (int) SystemClock.elapsedRealtime();

                    but.setBackgroundResource(obj.get_color(obj.get_k()));

                    if ( obj.verify_time(k,1000)) {
                        if (aux==0) {
                            complete++;
                            should++;
                            aux = 1;
                        }
                        else complete=-1;
                    }
                    else complete=-1;
                }


                else if(event.getAction()==MotionEvent.ACTION_UP) {
                    try {
                        mpp.start();
                    }catch(Exception e){}
                    touched = false;
                    but.setBackgroundResource(obj.get_color(obj.get_k()));


                    if (obj.get_k() % 5 == 3) complete++;
                    else complete = -1;
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
                    Thread.sleep(c3);
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
                    if(obj.dialog_message(complete,should,2,sw,GameActivity.class,4)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true,touched,0));
                    color_nr[obj.get_k()%5] = 0;
                    progress++;

                    if(obj.get_k()%5==1) {k[0] = (int) SystemClock.elapsedRealtime(); color_nr[3]=1;}
                    else if(obj.get_k()%5==3) should++;
                    break;

                case 1:
                    if(obj.dialog_message(complete,should,2,sw,GameActivity.class,4)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, false,touched,4));
                    progress++;

                    break;

                case 2:
                    if(obj.dialog_message(complete,should,2,sw,GameActivity.class,4)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true,touched,0));
                    color_nr[obj.get_k()%5] = 0;
                    progress++;

                    if(obj.get_k()%5==1) {k[0] = (int) SystemClock.elapsedRealtime(); color_nr[3]=1;}
                    else if(obj.get_k()%5==3) should++;
                    break;


                case 3:
                    if(obj.dialog_message(complete,should,2,sw,GameActivity.class,4)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true,touched,0));
                    color_nr[obj.get_k()%5] = 0;
                    progress++;

                    if(obj.get_k()%5==1) {k[0] = (int) SystemClock.elapsedRealtime(); color_nr[3]=1;}
                    else if(obj.get_k()%5==3) should++;
                    break;


                case 4:
                    if(obj.dialog_message(complete,should,2,sw,GameActivity.class,4)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true,touched,0));
                    color_nr[obj.get_k()%5] = 0;
                    progress++;

                    if(obj.get_k()%5==3) should++;
                    break;


                default:
                    should=2;
                    if(obj.dialog_message(complete,should,2,sw,GameActivity.class,4)) {sw=5;break;}
                    break;
            }
        }
    }
}

