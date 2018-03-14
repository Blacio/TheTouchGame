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

public class Level_13 extends Variables{

    MediaPlayer mp,mpp;
    public Level_13(Button b, Context context) {
        mp = MediaPlayer.create(context, R.raw.corect);
        mpp = MediaPlayer.create(context,R.raw.gresit);
        but = b;

        obj = new Functions(context);

        p1 = 3000;
        c1 = obj.random_nr(1000,1500);
        c2 = obj.random_nr(700,1000);
        c3 = obj.random_nr(800,1200);
        c4 = obj.random_nr(700,1500);
        p2 = obj.random_nr(300,500);
        p3 = obj.random_nr(500,1300);
        p4 = obj.random_nr(600,1300);

        color_nr = new int[]{2,0,0,3};

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

                    if (obj.get_k()%5==0 && color_nr[0]==0 && progress<11)
                        complete++;

                }


                else if (event.getAction() == MotionEvent.ACTION_UP) {
                    try {
                        mpp.start();
                    }catch(Exception e){}
                    touched = false;
                    but.setBackgroundResource(obj.get_color(obj.get_k()));
                    k[1] = (int) SystemClock.elapsedRealtime();

                    if(obj.was_pressed(k)) {
                        if (obj.get_k()%5==2) complete++;
                    }
                    else if(obj.get_k()%5==3 && color_nr[3]==0 && progress<11)
                        complete++;
                    else if (obj.get_k()%5==1) complete++;
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
                    Thread.sleep(p3);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(c2);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(p2);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(c3);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(p3);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(c4);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(p2);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(c2);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(p4);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(c2);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(c4);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(p4);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(c2);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(p4);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(c2);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(c1);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(c2);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(c4);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(c3);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(p4);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(c2);
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
                    if(obj.dialog_message(complete,should,7,sw,GameActivity.class,13)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[obj.get_k()%5]--;
                    progress++;

                    break;


                case 1:
                    if(obj.dialog_message(complete,should,7,sw,GameActivity.class,13)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, false, touched, 4));
                    progress++;

                    break;

                case 2:
                    if(obj.dialog_message(complete,should,7,sw,GameActivity.class,13)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[obj.get_k()%5]--;
                    progress++;

                    if (obj.get_k()%5==0 && color_nr[0]==0)                         {
                        should++;
                        color_nr[2]=1;
                    }

                    break;



                case 3:
                    if(obj.dialog_message(complete,should,7,sw,GameActivity.class,13)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, false, touched, 4));
                    progress++;

                    break;

                case 4:
                    if(obj.dialog_message(complete,should,7,sw,GameActivity.class,13)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[obj.get_k()%5]--;
                    progress++;

                    if(obj.get_k()%5==2)should++;
                    else if(obj.get_k()%5==3 && color_nr[3]==0) should+=2;
                    else if (obj.get_k()%5==0 && color_nr[0]==0)                         {
                        should++;
                        color_nr[2]=1;
                    }

                    break;


                case 5:
                    if(obj.dialog_message(complete,should,7,sw,GameActivity.class,13)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, false, touched, 4));
                    progress++;

                    break;

                case 6:
                    if(obj.dialog_message(complete,should,7,sw,GameActivity.class,13)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[obj.get_k()%5]--;
                    progress++;

                    if(obj.get_k()%5==2)should++;
                    else if(obj.get_k()%5==3 && color_nr[3]==0) should+=2;
                    else if (obj.get_k()%5==0 && color_nr[0]==0)                         {
                        should++;
                        color_nr[2]=1;
                    }

                    break;


                case 7:
                    if(obj.dialog_message(complete,should,7,sw,GameActivity.class,13)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, false, touched, 4));
                    progress++;

                    break;

                case 8:
                    if(obj.dialog_message(complete,should,7,sw,GameActivity.class,13)) {sw=5;break;}

                    if(touched && color_nr[2]==1 && color_nr[3]==1)
                        but.setBackgroundResource(obj.set_color(color_nr, false, touched, 2));
                    else
                        but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));

                    color_nr[obj.get_k()%5]--;
                    progress++;

                    if(obj.get_k()%5==2)should++;
                    else if(obj.get_k()%5==3 && color_nr[3]==0) should+=2;
                    else if (obj.get_k()%5==0 && color_nr[0]==0)                         {
                        should++;
                        color_nr[2]=1;
                    }

                    break;


                case 9:
                    if(obj.dialog_message(complete,should,7,sw,GameActivity.class,13)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, false, touched, 4));
                    progress++;

                    break;

                case 10:
                    if(obj.dialog_message(complete,should,7,sw,GameActivity.class,13)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[obj.get_k()%5]--;
                    progress++;

                    if(obj.get_k()%5==2)should++;
                    else if(obj.get_k()%5==3 && color_nr[3]==0) should+=2;
                    else if (obj.get_k()%5==0 && color_nr[0]==0)                         {
                        should++;
                        color_nr[2]=1;
                    }

                    break;


                case 11:

                    if(obj.dialog_message(complete,should,7,sw,GameActivity.class,13)) {sw=5;break;}

                    color_nr = new int[]{3,0,0,2};
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    progress++;

                    if(obj.get_k()%5==0) {should++;complete++;}

                    break;

                case 12:
                    if(obj.dialog_message(complete,should,7,sw,GameActivity.class,13)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, false, touched, 4));
                    progress++;

                    break;

                case 13:
                    if(obj.dialog_message(complete,should,7,sw,GameActivity.class,13)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, false, touched, 1));
                    progress++;

                    break;

                case 14:
                    if(obj.dialog_message(complete,should,7,sw,GameActivity.class,13)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    progress++;

                    break;

                case 15:
                    if(obj.dialog_message(complete,should,7,sw,GameActivity.class,13)) {sw=5;break;}

                    if (obj.get_k()%5==0) should++;

                    but.setBackgroundResource(obj.set_color(color_nr, false, touched, 1));
                    progress++;

                    break;

                case 16:
                    if(obj.dialog_message(complete,should,7,sw,GameActivity.class,13)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    progress++;

                    break;

                case 17:
                    if(obj.dialog_message(complete,should,7,sw,GameActivity.class,13)) {sw=5;break;}

                    if (obj.get_k()%5==0) should++;

                    but.setBackgroundResource(obj.set_color(color_nr, false, touched, 1));
                    progress++;

                    break;

                case 18:
                    if(obj.dialog_message(complete,should,7,sw,GameActivity.class,13)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    progress++;

                    break;

                case 19:
                    if(obj.dialog_message(complete,should,7,sw,GameActivity.class,13)) {sw=5;break;}

                    if (obj.get_k()%5==0) should++;

                    but.setBackgroundResource(obj.set_color(color_nr, false, touched, 1));
                    progress++;

                    break;

                case 20:
                    if(obj.dialog_message(complete,should,7,sw,GameActivity.class,13)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, false, touched, 4));
                    progress++;

                    break;

                case 21:
                    if(obj.dialog_message(complete,should,7,sw,GameActivity.class,13)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, false, touched, 1));
                    progress++;

                    break;

                case 22:
                    if(obj.dialog_message(complete,should,7,sw,GameActivity.class,13)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    progress++;

                    break;

                case 23:
                    if(obj.dialog_message(complete,should,7,sw,GameActivity.class,13)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, false, touched, 1));
                    progress++;

                    break;


                default:
                    should=7;
                    if(obj.dialog_message(complete,should,7,sw,GameActivity.class,13)) {sw=5;break;}
                    break;
            }
        }
    }
}

