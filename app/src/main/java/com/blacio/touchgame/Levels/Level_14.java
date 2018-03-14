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


public class Level_14 extends Variables{

    MediaPlayer mp,mpp;
    public Level_14(Button b, final Context context) {
        mp = MediaPlayer.create(context, R.raw.corect);
        mpp = MediaPlayer.create(context,R.raw.gresit);
        but = b;

        obj = new Functions(context);

        p1 = 3000;
        c1 = obj.random_nr(800,1600);
        c2 = obj.random_nr(700,1200);
        c3 = obj.random_nr(800,1600);
        c4 = obj.random_nr(700,1200);

        color_nr = new int[]{0,2,1,0};

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


                    if((complete==0 || complete==1)&& obj.get_k()%5==2)
                        complete++;
                    else if(complete==3 && obj.get_k()%5==0)
                        complete++;
                    else if(complete==5 && obj.get_k()%5==3)
                        complete++;
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
                        if (complete==2 && obj.get_k()%5==0)
                            complete++;
                        else if(complete==4 && obj.get_k()%5==3)
                            complete++;
                        else complete=-1;
                    }
                    else{
                           if (complete==1 && obj.get_k()%5==2)     ;
                            else if(complete==6 && obj.get_k()%5==3)    ;
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
                    Thread.sleep(c4);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(c2);
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
                    if(obj.dialog_message(complete,should,6,sw,GameActivity.class,14)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[obj.get_k()%5]--;

                    progress++;


                    if(obj.get_k()%5==2) {
                        color_nr[0] = 1;
                        should += 2;
                    }

                    break;

                case 1:
                    if(obj.dialog_message(complete,should,6,sw,GameActivity.class,14)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[obj.get_k()%5]--;

                    progress++;

                    if(obj.get_k()%5==2){
                        color_nr[0]=1;
                        should+=2;
                        }
                    else if(obj.get_k()%5==0) {
                        color_nr[3] = 1;
                        should += 2;
                        }

                    break;

                case 2:
                    if(obj.dialog_message(complete,should,6,sw,GameActivity.class,14)) {sw=5;break;}

                    if(color_nr[2]!=0)
                        but.setBackgroundResource(obj.set_color(color_nr, false, touched, 2));
                    else
                        but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));

                    color_nr[obj.get_k()%5]--;

                    progress++;

                    if(obj.get_k()%5==2){
                        color_nr[0]=1;
                        should+=2;
                    }
                    else if(obj.get_k()%5==0) {
                        color_nr[3] = 1;
                        should += 2;
                    }
                    else if (obj.get_k()%5==3)
                        should+=2;


                    break;

                case 3:
                    if(obj.dialog_message(complete,should,6,sw,GameActivity.class,14)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[obj.get_k()%5]--;

                    progress++;

                    if(obj.get_k()%5==0) {
                        color_nr[3] = 1;
                        should += 2;
                    }
                    else if (obj.get_k()%5==3)
                        should+=2;

                    break;

                case 4:
                    if(obj.dialog_message(complete,should,6,sw,GameActivity.class,14)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[obj.get_k()%5]--;

                    progress++;

                    if (obj.get_k()%5==3)
                        should+=2;

                    break;


                default:
                    should=7;
                    if(obj.dialog_message(complete,should,6,sw,GameActivity.class,14)) {sw=5;break;}
                    break;
            }
        }
    }
}

