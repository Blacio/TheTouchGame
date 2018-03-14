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

public class Level_6 extends Variables{


    MediaPlayer mp,mpp;
    public Level_6(Button b, Context context) {
        mp = MediaPlayer.create(context, R.raw.corect);
        mpp = MediaPlayer.create(context,R.raw.gresit);
        but = b;

        obj = new Functions(context);

        p1 = 3000;
        c1 = obj.random_nr(600,1000);
        c2 = obj.random_nr(1000,1400);
        c3 = obj.random_nr(600,1000);
        p4 = obj.random_nr(600,1000);
        c4 = obj.random_nr(900,1200);
        p5 = 3000;

        color_nr = new int[]{1, 1, 1, 1};

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

                    if(k[0]==0)
                        if (obj.get_k()%5==2) complete++;
                        else complete=-1;

                    else
                        if(complete==0){
                            k[1] = (int) SystemClock.elapsedRealtime();

                            if (obj.verify_time(k,3000) || obj.get_k()%5==2){
                                complete++;

                                if (obj.verify_time(k,3000)){
                                    should++;
                                    k2[0]=k[1];
                                }
                                else if(obj.get_k()%5==2)   ;
                                else complete=-1;
                            }
                            else complete=-1;
                        }

                        else if (complete==1){
                            k[1] = (int) SystemClock.elapsedRealtime();

                            if (obj.verify_time(k,3000))    {
                                complete++;
                                should++;
                                k2[0]=k[1];
                            }
                            else complete=-1;
                        }

                        else if(complete==2){
                            if (obj.get_k()%5==2) complete++;
                            else complete=-1;
                        }
                        else complete=-1;


                }


                else if (event.getAction() == MotionEvent.ACTION_UP) {
                    try {
                        mpp.start();
                    }catch(Exception e){}
                    touched = false;
                    but.setBackgroundResource(obj.get_color(obj.get_k()));

                    k2[1] = (int) SystemClock.elapsedRealtime();

                    if(obj.get_k()%5==2){
                        if (complete==1 && k2[0]==k[1] && k[1]!=0 && k2[1]-k[1]>0 && k2[1]-k[1]<300)
                            should--;
                    }
                    else{
                        if ((obj.verify_time(k2,1000)) && k2[0]!=0){
                            complete++;
                            should++;
                        }

                        else complete=-1;
                    }

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
                    Thread.sleep(c2);
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
                    if(obj.dialog_message(complete,should,3,sw,GameActivity.class,6)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true,touched,0));
                    color_nr[obj.get_k()%5] = 0;
                    progress++;

                    if(obj.get_k()%5==2) should++;
                    else if(obj.get_k()%5==0) {k[0] = (int) SystemClock.elapsedRealtime();}
                    break;

                case 1:
                    if(obj.dialog_message(complete,should,3,sw,GameActivity.class,6)) {sw=5;break;}

                    if (touched) {
                        aux = color_nr[2];
                        color_nr[2] = 0;
                        but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    }
                    else but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));

                    color_nr[obj.get_k()%5] = 0;
                    progress++;

                    if(obj.get_k()%5==2) should++;
                    else if(obj.get_k()%5==0) {k[0] = (int) SystemClock.elapsedRealtime();}
                    break;

                case 2:
                    if(obj.dialog_message(complete,should,3,sw,GameActivity.class,6)) {sw=5;break;}

                    if (touched) {
                        aux = color_nr[2];
                        color_nr[2] = 0;
                        but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    }

                    else if(color_nr[0]!=0)
                        but.setBackgroundResource(obj.set_color(color_nr, false, touched, 0));
                    else
                        but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));

                    color_nr[obj.get_k()%5] = 0;
                    progress++;

                    if(obj.get_k()%5==2) should++;
                    else if(obj.get_k()%5==0) {k[0] = (int) SystemClock.elapsedRealtime();}
                    break;


                case 3:
                    if(obj.dialog_message(complete,should,3,sw,GameActivity.class,6)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, false,touched,4));
                    progress++;

                    break;


                case 4:
                    if(obj.dialog_message(complete,should,3,sw,GameActivity.class,6)) {sw=5;break;}
                     but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));

                    color_nr[obj.get_k()%5] = 0;
                    progress++;

                    if(obj.get_k()%5==2) should++;
                    else if(obj.get_k()%5==0) {k[0] = (int) SystemClock.elapsedRealtime();}
                    break;

                case 5:
                    if(obj.dialog_message(complete,should,3,sw,GameActivity.class,6)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, false,touched,4));
                    progress++;

                    break;

                default:
                    should=3;
                    if(obj.dialog_message(complete,should,3,sw,GameActivity.class,6)) {sw=5;break;}
                    break;
            }
        }
    }
}

