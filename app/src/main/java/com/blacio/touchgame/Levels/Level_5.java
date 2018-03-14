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

public class Level_5 extends Variables{


    MediaPlayer mp,mpp;
    public Level_5(Button b, Context context) {

        mp = MediaPlayer.create(context, R.raw.corect);
        mpp = MediaPlayer.create(context,R.raw.gresit);
        but = b;

        obj = new Functions(context);

        p1 = 3000;
        c1 = 1000;
        p2 = 300;
        c2 = 700;
        p3 = 1400;
        c3 = 1000;
        p4 = 2600;

        color_nr = new int[]{1, 0, 1, 1};

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

                    if ( obj.verify_time(k,2000)) {
                        if (aux == 0) {
                            complete++;
                            should++;
                            aux = 1;
                        }
                        else if (obj.get_k() % 5 == 3)  complete++;
                    }
                    else if (obj.get_k() % 5 == 3)  complete++;

                    else complete=-1;
                }


                else if(event.getAction()==MotionEvent.ACTION_UP) {
                    try {
                        mpp.start();
                    }catch(Exception e){}
                    touched = false;
                    but.setBackgroundResource(obj.get_color(obj.get_k()));

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
                    if(obj.dialog_message(complete,should,3,sw,GameActivity.class,5)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true,touched,0));
                    color_nr[obj.get_k()%5] = 0;
                    progress++;

                    if(obj.get_k()%5==3) should+=2;
                    break;

                case 1:
                    if(obj.dialog_message(complete,should,3,sw,GameActivity.class,5)) {sw=5;break;}

                    if(obj.get_k()%5==2)  k[0] = (int) SystemClock.elapsedRealtime();

                    but.setBackgroundResource(obj.set_color(color_nr, false,touched,4));
                    progress++;

                    break;

                case 2:
                    if(obj.dialog_message(complete,should,3,sw,GameActivity.class,5)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true,touched,0));
                    color_nr[obj.get_k()%5] = 0;
                    progress++;

                    if(obj.get_k()%5==3) should+=2;
                    break;


                case 3:
                    if(obj.dialog_message(complete,should,3,sw,GameActivity.class,5)) {sw=5;break;}

                    if(obj.get_k()%5==2)  k[0] = (int) SystemClock.elapsedRealtime();

                    but.setBackgroundResource(obj.set_color(color_nr, false,touched,4));
                    progress++;

                    break;


                case 4:
                    if(obj.dialog_message(complete,should,3,sw,GameActivity.class,5)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true,touched,0));
                    color_nr[obj.get_k()%5] = 0;
                    progress++;

                    if(obj.get_k()%5==3) should+=2;
                    break;

                case 5:
                    if(obj.dialog_message(complete,should,3,sw,GameActivity.class,5)) {sw=5;break;}

                    if(obj.get_k()%5==2)  k[0] = (int) SystemClock.elapsedRealtime();

                    but.setBackgroundResource(obj.set_color(color_nr, false,touched,4));
                    progress++;

                    break;


                default:
                    should=3;
                    if(obj.dialog_message(complete,should,3,sw,GameActivity.class,5)) {sw=5;break;}
                    break;
            }
        }
    }
}

