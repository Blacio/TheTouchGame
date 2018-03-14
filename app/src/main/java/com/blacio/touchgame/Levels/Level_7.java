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

public class Level_7 extends Variables{
    MediaPlayer mp,mpp;

    public Level_7(Button b, Context context) {
        mp = MediaPlayer.create(context, R.raw.corect);
        mpp = MediaPlayer.create(context,R.raw.gresit);
        but = b;

        obj = new Functions(context);

        p1 = 3000;
        c1 = obj.random_nr(1000,1500);
        p2 = 1500;
        c2 = 400;
        c3 = obj.random_nr(600,1400);
        p4 = obj.random_nr(500,1000);
        c4 = obj.random_nr(900,1200);
        p5 = 3000;

        color_nr = new int[]{1, 0, 1, 1};

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


                    if(aux==1 && complete==0) complete++;

                    else if(complete==2){

                        k2[1]= (int) SystemClock.elapsedRealtime();

                        if ((obj.verify_time(k2,2000)))
                        {complete++;should++;}
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

                    if(complete==1){
                        k[1] = (int) SystemClock.elapsedRealtime();

                        if(obj.verify_time(k,2000))
                        {
                            complete++;
                            should++;
                            k2[0]=k[1];
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
                    Thread.sleep(p2);
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
                    if(obj.dialog_message(complete,should,3,sw,GameActivity.class,7)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true,touched,0));
                    color_nr[obj.get_k()%5] = 0;
                    progress++;

                    if(obj.get_k()%5==3) color_nr[1]=1;
                    break;

                case 1:
                    if(obj.dialog_message(complete,should,3,sw,GameActivity.class,7)) {sw=5;break;}

                    if (obj.get_k()%5==3) {should++;aux=1;}

                    but.setBackgroundResource(obj.set_color(color_nr, false,touched,4));
                    progress++;

                    break;


                case 2:
                    aux=0;
                    if(obj.dialog_message(complete,should,3,sw,GameActivity.class,7)) {sw=5;break;}

                    if(color_nr[3]!=0)
                        but.setBackgroundResource(obj.set_color(color_nr, false, touched, 3));
                    else
                        but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));

                    color_nr[obj.get_k()%5] = 0;
                    progress++;

                    if(obj.get_k()%5==3) color_nr[1]=1;
                    break;


                case 3:
                    if(obj.dialog_message(complete,should,3,sw,GameActivity.class,7)) {sw=5;break;}

                    if(obj.get_k()%5==1) k[0] = (int) SystemClock.elapsedRealtime();
                    if (obj.get_k()%5==3) {should++;aux=1;}

                    if(color_nr[1]!=0)
                        but.setBackgroundResource(obj.set_color(color_nr, false, touched, 1));
                    else
                        but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));

                    color_nr[obj.get_k()%5] = 0;
                    progress++;

                    break;


                case 4:
                    aux=0;
                    if(obj.dialog_message(complete,should,3,sw,GameActivity.class,7)) {sw=5;break;}

                    if(obj.get_k()%5==1) k[0] = (int) SystemClock.elapsedRealtime();

                    but.setBackgroundResource(obj.set_color(color_nr, false,touched,4));
                    progress++;

                    break;

                case 5:
                    if(obj.dialog_message(complete,should,3,sw,GameActivity.class,7)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[obj.get_k()%5] = 0;
                    progress++;

                    break;

                case 6:
                    if(obj.dialog_message(complete,should,3,sw,GameActivity.class,7)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, false,touched,4));
                    progress++;

                    break;

                default:
                    should=3;
                    if(obj.dialog_message(complete,should,3,sw,GameActivity.class,7)) {sw=5;break;}
                    break;
            }
        }
    }
}

