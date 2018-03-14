package com.blacio.touchgame.Levels;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.blacio.touchgame.GameActivity;
import com.blacio.touchgame.MenuActivity;
import com.blacio.touchgame.R;

public class Level_20 extends Variables{
    MediaPlayer mp,mpp;

    public Level_20(Button b, Context context) {
        mp = MediaPlayer.create(context, R.raw.corect);
        mpp = MediaPlayer.create(context,R.raw.gresit);
        but = b;

        obj = new Functions(context);

        p1 = 3500;
        c1 = obj.random_nr(700,1300);
        c2 = obj.random_nr(800,1200);

        p2 = 400;

        color_nr = new int[]{1,2,0,0};

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

                    if(complete==0){
                        k2[1]=(int)SystemClock.elapsedRealtime();

                        if(obj.verify_time(k2,2000)){
                            should++;
                            complete++;
                        }
                        else complete=-1;
                    }
                    else if(complete==2){
                        k4[1]=(int)SystemClock.elapsedRealtime();

                        if(obj.verify_time(k4,3000)){
                            should++;
                            complete++;
                        }
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
                    k[1] = (int) SystemClock.elapsedRealtime();

                    if(obj.was_pressed(k)){
                        if(complete==1){
                            k3[1]=(int)SystemClock.elapsedRealtime();

                            if(obj.verify_time(k3,2000)){
                                complete++;
                                should++;
                            }
                            else complete=-1;
                        }
                        else complete=-1;
                    }

                    else if(complete==3)    ;
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
                    Thread.sleep(c2);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(p2);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(c2);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(c2);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(c1);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(p1);
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
                    if(obj.dialog_message(complete,should,3,sw,MenuActivity.class,20)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[obj.get_k()%5]--;

                    if(obj.get_k()%5==1 && color_nr[1]==1) {
                        color_nr[3]++;
                        k2[0] = (int) SystemClock.elapsedRealtime();
                    }

                    progress++;

                    break;

                case 1:
                    if(obj.dialog_message(complete,should,3,sw,MenuActivity.class,20)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[obj.get_k()%5]--;

                    if(obj.get_k()%5==1 && color_nr[1]==1) {
                        color_nr[3]++;
                        k2[0] = (int) SystemClock.elapsedRealtime();
                    }

                    progress++;

                    break;

                case 2:
                    if(obj.dialog_message(complete,should,3,sw,MenuActivity.class,20)) {sw=5;break;}

                    if (obj.get_k()%5==3) {k3[0]=(int)SystemClock.elapsedRealtime();color_nr[2]=1;}

                    but.setBackgroundResource(obj.set_color(color_nr, false, touched, 4));

                    progress++;

                    break;

                case 3:
                    if(obj.dialog_message(complete,should,3,sw,MenuActivity.class,20)) {sw=5;break;}


                    if(color_nr[1]==2) {
                        but.setBackgroundResource(obj.set_color(color_nr, false, touched, 1));
                        color_nr[obj.get_k()%5]--;
                    }
                    else {
                        but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                        color_nr[obj.get_k()%5]--;
                    }

                    if(obj.get_k()%5==1 && color_nr[1]==1) {
                        color_nr[3]++;
                        k2[0] = (int) SystemClock.elapsedRealtime();
                    }

                    else if(obj.get_k()%5==3) {
                        k3[0] = (int) SystemClock.elapsedRealtime();
                        color_nr[2] = 1;
                    }

                    progress++;

                    break;

                case 4:
                    if(obj.dialog_message(complete,should,3,sw,MenuActivity.class,20)) {sw=5;break;}

                    if(obj.get_k()%5==2) k4[0]=(int)SystemClock.elapsedRealtime();

                    if(color_nr[3]==1) {
                        but.setBackgroundResource(obj.set_color(color_nr, false, touched, 3));
                        color_nr[obj.get_k() % 5]--;
                    }
                    else {
                        but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                        color_nr[obj.get_k() % 5]--;
                    }

                    progress++;

                    break;

                case 5:
                    if(obj.dialog_message(complete,should,3,sw,MenuActivity.class,20)) {sw=5;break;}

                    if(obj.get_k()%5==2) k4[0]=(int)SystemClock.elapsedRealtime();

                    else if(obj.get_k()%5==3) {
                        k3[0] = (int) SystemClock.elapsedRealtime();
                        color_nr[2] = 1;
                    }


                        but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                        color_nr[obj.get_k() % 5]--;


                    progress++;

                    break;

                case 6:
                    if(obj.dialog_message(complete,should,3,sw,MenuActivity.class,20)) {sw=5;break;}

                    if(obj.get_k()%5==2) k4[0]=(int)SystemClock.elapsedRealtime();

                    but.setBackgroundResource(obj.set_color(color_nr, false, touched, 4));

                    progress++;

                    break;


                default:
                    should=3;
                    if(obj.dialog_message(complete,should,3,sw,MenuActivity.class,20)) {sw=5;break;}
                    break;
            }
        }
    }
}

