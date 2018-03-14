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

public class Level_11 extends Variables{

    MediaPlayer mp,mpp;
    public Level_11(Button b, Context context) {
        mp = MediaPlayer.create(context, R.raw.corect);
        mpp = MediaPlayer.create(context,R.raw.gresit);
        but = b;

        obj = new Functions(context);

        p1 = 3000;
        c1 = 500;
        p4 = 1200;
        c2 = obj.random_nr(900,1300);
        c3 = obj.random_nr(900,1300);
        c4 = obj.random_nr(900,1300);
        p5 = 3500;

        color_nr = new int[]{2,2,1,0};

        but.setBackgroundResource(obj.set_color(color_nr, false,touched,4));

        new Operation().execute();


        but.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    k3[0] = (int) SystemClock.elapsedRealtime();
                    try {
                        mp.start();
                    }catch(Exception e){}
                    touched = true;
                    but.setBackgroundResource(obj.get_color(obj.get_k()));

                }


                else if (event.getAction() == MotionEvent.ACTION_UP) {

                    k3[1] = (int) SystemClock.elapsedRealtime();
                    try {
                        mpp.start();
                    }catch(Exception e){}
                    touched = false;
                    but.setBackgroundResource(obj.get_color(obj.get_k()));

                    k[1] = (int) SystemClock.elapsedRealtime();
                    k2[1] = (int) SystemClock.elapsedRealtime();

                        if(obj.was_pressed(k3)) complete=-1;

                        else if(obj.verify_time(k,2000)){
                            complete++;
                            should++;
                            k[0]=0;
                        }
                        else if (obj.verify_time(k2,3000)){
                            complete++;
                            should++;
                            k2[0]=0;
                        }
                        else  if(obj.get_k()%5==1)
                            complete++;

                    else complete=-1;
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
                    Thread.sleep(c1);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(c1);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(p4);
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
                    if(obj.dialog_message(complete,should,4,sw,GameActivity.class,11)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[obj.get_k()%5]--;

                    if(obj.get_k()%5==1 && color_nr[1]==0)
                        should+=2;
                    else if(obj.get_k()%5==2)
                        k[0] = (int) SystemClock.elapsedRealtime();

                    progress++;

                    break;

                case 1:
                    if(obj.dialog_message(complete,should,4,sw,GameActivity.class,11)) {sw=5;break;}

                    if (obj.get_k()%5==1){
                        aux = color_nr[1];
                        color_nr[1]=0;
                        but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                        color_nr[1]=aux;
                    }

                    else
                        but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));

                    color_nr[obj.get_k()%5]--;

                    if(obj.get_k()%5==1 && color_nr[1]==0)
                        should+=2;
                    else if(obj.get_k()%5==2)
                        k[0] = (int) SystemClock.elapsedRealtime();

                    progress++;

                    break;

                case 2:
                    if(obj.dialog_message(complete,should,4,sw,GameActivity.class,11)) {sw=5;break;}

                    color_nr[3]=1;

                    if (obj.get_k()%5==1){
                        aux = color_nr[1];
                        color_nr[1]=0;
                        but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                        color_nr[1]=aux;
                    }

                    else
                        but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));

                    color_nr[obj.get_k()%5]--;

                    if(obj.get_k()%5==1 && color_nr[1]==0)
                        should+=2;
                    else if(obj.get_k()%5==2)
                        k[0] = (int) SystemClock.elapsedRealtime();

                    progress++;

                    break;

                case 3:
                    if(obj.dialog_message(complete,should,4,sw,GameActivity.class,11)) {sw=5;break;}

                    if(obj.get_k()%5==3) k2[0] = (int) SystemClock.elapsedRealtime();

                    but.setBackgroundResource(obj.set_color(color_nr, false, touched, 4));
                    progress++;

                    break;

                case 4:
                    if(obj.dialog_message(complete,should,4,sw,GameActivity.class,11)) {sw=5;break;}

                    if(color_nr[1]==2)
                        but.setBackgroundResource(obj.set_color(color_nr, false, touched, 1));
                    else
                        but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));

                    color_nr[obj.get_k()%5]--;

                    if(obj.get_k()%5==1 && color_nr[1]==0)
                        should+=2;
                    else if(obj.get_k()%5==2)
                        k[0] = (int) SystemClock.elapsedRealtime();

                    progress++;

                    break;

                case 5:
                    if(obj.dialog_message(complete,should,4,sw,GameActivity.class,11)) {sw=5;break;}

                    if(obj.get_k()%5==3) k2[0] = (int) SystemClock.elapsedRealtime();

                    if (obj.get_k()%5==1){
                        aux = color_nr[1];
                        color_nr[1]=0;
                        but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                        color_nr[1]=aux;
                    }

                    else
                        but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));


                    color_nr[obj.get_k()%5]--;


                    if(obj.get_k()%5==1 && color_nr[1]==0)
                        should+=2;
                    else if(obj.get_k()%5==2)
                        k[0] = (int) SystemClock.elapsedRealtime();

                    progress++;

                    break;

                case 6:
                    if(obj.dialog_message(complete,should,4,sw,GameActivity.class,11)) {sw=5;break;}

                    if(obj.get_k()%5==3) k2[0] = (int) SystemClock.elapsedRealtime();

                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[obj.get_k()%5]--;

                    if(obj.get_k()%5==1 && color_nr[1]==0)
                        should+=2;
                    else if(obj.get_k()%5==2)
                        k[0] = (int) SystemClock.elapsedRealtime();

                    progress++;

                    break;

                case 7:
                    if(obj.dialog_message(complete,should,4,sw,GameActivity.class,11)) {sw=5;break;}

                    if(obj.get_k()%5==3) k2[0] = (int) SystemClock.elapsedRealtime();

                    but.setBackgroundResource(obj.set_color(color_nr, false, touched, 4));
                    progress++;

                    break;


                default:
                    should=4;
                    if(obj.dialog_message(complete,should,4,sw,GameActivity.class,11)) {sw=5;break;}
                    break;
            }
        }
    }
}

