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

public class Level_3 extends Variables{


    MediaPlayer mp,mpp;
    public Level_3(Button b, Context context) {

        mp = MediaPlayer.create(context, R.raw.corect);
        mpp = MediaPlayer.create(context,R.raw.gresit);
        but = b;

        obj = new Functions(context);

        p1 = 2000;
        c1 = obj.random_nr(600,1200);
        p2 = obj.random_nr(300,700);
        c2 = obj.random_nr(700,1000);
        p3 = obj.random_nr(300,700);
        c3 = obj.random_nr(500,1000);
        p4 = 3100;
        c4 = obj.random_nr(500,1100);
        p5 = 3100;

        color_nr = new int[]{1, 1, 1, 1};

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

                    k[0] = (int) SystemClock.elapsedRealtime();

                    but.setBackgroundResource(obj.get_color(obj.get_k()));

                    if(obj.get_k()%5 == 3)
                        complete++;
                    else if(obj.get_k()%5 == 2) ;
                    else complete=-1;

                }


                else if(event.getAction()==MotionEvent.ACTION_UP){
                    try {
                        mpp.start();
                    }catch(Exception e){}
                    touched=false;
                    but.setBackgroundResource(obj.get_color(obj.get_k()));
                    k[1] = (int) SystemClock.elapsedRealtime();


                    if(obj.was_pressed(k)){
                        if (obj.verify_time(k,3000)) {complete++;should++;}
                        else complete=-1;
                    }

                    if (obj.get_k()%5 == 2)
                            complete++;

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
                    Thread.sleep(p5);
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
                    if(obj.dialog_message(complete,should,3,sw,GameActivity.class,3)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true,touched,0));
                    color_nr[obj.get_k()%5] = 0;
                    progress++;

                    if(obj.get_k()%5==2 || obj.get_k()%5==3)    should++;
                    break;

                case 1:
                    if(obj.dialog_message(complete,should,3,sw,GameActivity.class,3)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, false,touched,4));
                    progress++;

                    break;

                case 2:
                    if(obj.dialog_message(complete,should,3,sw,GameActivity.class,3)) {sw=5;break;}

                    if (touched) {aux=color_nr[2]; color_nr[2] = 0;
                        but.setBackgroundResource(obj.set_color(color_nr, true,touched,0));
                        color_nr[2]=aux;}

                    else but.setBackgroundResource(obj.set_color(color_nr, true,touched,0));

                    color_nr[obj.get_k()%5] = 0;
                    progress++;

                    if(obj.get_k()%5==2 || obj.get_k()%5==3)    should++;
                    break;

                case 3:
                    if(obj.dialog_message(complete,should,3,sw,GameActivity.class,3)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, false,touched,4));
                    progress++;

                    break;

                case 4:
                    if(obj.dialog_message(complete,should,3,sw,GameActivity.class,3)) {sw=5;break;}

                    if (touched) {aux=color_nr[2]; color_nr[2] = 0;
                        but.setBackgroundResource(obj.set_color(color_nr, true,touched,0));
                        color_nr[2]=aux;}

                    else but.setBackgroundResource(obj.set_color(color_nr, true,touched,0));

                    color_nr[obj.get_k()%5] = 0;
                    progress++;

                    if(obj.get_k()%5==2 || obj.get_k()%5==3)    should++;
                    break;

                case 5:
                    if(obj.dialog_message(complete,should,3,sw,GameActivity.class,3)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, false,touched,4));
                    progress++;

                    break;

                case 6:
                    if(obj.dialog_message(complete,should,3,sw,GameActivity.class,3)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true,touched,0));

                    color_nr[obj.get_k()%5] = 0;
                    progress++;

                    if(obj.get_k()%5==2 || obj.get_k()%5==3)    should++;
                    break;

                case 7:
                    if(obj.dialog_message(complete,should,3,sw,GameActivity.class,3)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, false,touched,4));
                    progress++;

                    break;

                default:
                    should=3;
                    if(obj.dialog_message(complete,should,3,sw,GameActivity.class,3)) {sw=5;break;}
                    break;
            }
        }
    }
}

