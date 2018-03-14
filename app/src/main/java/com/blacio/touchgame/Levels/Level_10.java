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

public class Level_10 extends Variables{
    MediaPlayer mp,mpp;

    public Level_10(Button b, Context context) {
        mp = MediaPlayer.create(context, R.raw.corect);
        mpp = MediaPlayer.create(context,R.raw.gresit);
        but = b;

        obj = new Functions(context);

        p1 = 3000;
        c1 = obj.random_nr(800,1200);
        c2 = obj.random_nr(800,1200);
        c3 = obj.random_nr(800,1200);
        c4 = obj.random_nr(800,1200);
        p2 = 400;

        color_nr = new int[]{2,2,2,2};

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
                    Thread.sleep(c2);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(c3);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(c4);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(c4);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(c3);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(c2);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(p2);
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
                    if(obj.dialog_message(complete,should,4,sw,GameActivity.class,10)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[obj.get_k()%5]--;

                    if(obj.get_k()%5==1 && color_nr[1]==1)
                        should++;
                    else if(obj.get_k()%5==2 && color_nr[2]==0)
                        should++;

                    progress++;

                    break;

                case 1:
                    if(obj.dialog_message(complete,should,4,sw,GameActivity.class,10)) {sw=5;break;}

                    if(obj.get_k()%5==3 && color_nr[3]==0)
                        should+=2;

                    k[0]=obj.get_k()%5;
                    aux = color_nr[k[0]];
                    color_nr[k[0]]=0;
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[k[0]] = aux;
                    color_nr[obj.get_k()%5]--;

                    if(obj.get_k()%5==1 && color_nr[1]==1)
                        should++;
                    else if(obj.get_k()%5==2 && color_nr[2]==0)
                        should++;

                    progress++;

                    break;

                case 2:
                    if(obj.dialog_message(complete,should,4,sw,GameActivity.class,10)) {sw=5;break;}

                    if(obj.get_k()%5==3 && color_nr[3]==0)
                        should+=2;

                    k[0]=obj.get_k()%5;
                    aux = color_nr[k[0]];
                    color_nr[k[0]]=0;
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[k[0]] = aux;
                    color_nr[obj.get_k()%5]--;

                    if(obj.get_k()%5==1 && color_nr[1]==1)
                        should++;
                    else if(obj.get_k()%5==2 && color_nr[2]==0)
                        should++;

                    progress++;

                    break;

                case 3:
                    if(obj.dialog_message(complete,should,4,sw,GameActivity.class,10)) {sw=5;break;}

                    if(obj.get_k()%5==3 && color_nr[3]==0)
                        should+=2;

                    k[0]=obj.get_k()%5;
                    aux = color_nr[k[0]];
                    color_nr[k[0]]=0;
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[k[0]] = aux;
                    color_nr[obj.get_k()%5]--;

                    if(obj.get_k()%5==1 && color_nr[1]==1)
                        should++;
                    else if(obj.get_k()%5==2 && color_nr[2]==0)
                        should++;

                    progress++;

                    break;

                case 4:
                    if(obj.dialog_message(complete,should,4,sw,GameActivity.class,10)) {sw=5;break;}

                    if(obj.get_k()%5==3 && color_nr[3]==0)
                        should+=2;

                    k[0]=obj.get_k()%5;
                    aux = color_nr[k[0]];
                    color_nr[k[0]]=0;
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[k[0]] = aux;
                    color_nr[obj.get_k()%5]--;

                    if(obj.get_k()%5==1 && color_nr[1]==1)
                        should++;
                    else if(obj.get_k()%5==2 && color_nr[2]==0)
                        should++;

                    progress++;

                    break;

                case 5:
                    if(obj.dialog_message(complete,should,4,sw,GameActivity.class,10)) {sw=5;break;}

                    if(obj.get_k()%5==3 && color_nr[3]==0)
                        should+=2;

                    k[0]=obj.get_k()%5;
                    aux = color_nr[k[0]];
                    color_nr[k[0]]=0;
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[k[0]] = aux;
                    color_nr[obj.get_k()%5]--;

                    if(obj.get_k()%5==1 && color_nr[1]==1)
                        should++;
                    else if(obj.get_k()%5==2 && color_nr[2]==0)
                        should++;

                    progress++;

                    break;

                case 6:
                    if(obj.dialog_message(complete,should,4,sw,GameActivity.class,10)) {sw=5;break;}

                    if(obj.get_k()%5==3 && color_nr[3]==0)
                        should+=2;

                    k[0]=obj.get_k()%5;
                    aux = color_nr[k[0]];
                    color_nr[k[0]]=0;
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[k[0]] = aux;
                    color_nr[obj.get_k()%5]--;

                    if(obj.get_k()%5==1 && color_nr[1]==1)
                        should++;
                    else if(obj.get_k()%5==2 && color_nr[2]==0)
                        should++;

                    progress++;

                    break;

                case 7:
                    if(obj.dialog_message(complete,should,4,sw,GameActivity.class,10)) {sw=5;break;}

                    if(obj.get_k()%5==3 && color_nr[3]==0)
                        should+=2;

                    but.setBackgroundResource(obj.set_color(color_nr, false, touched, 4));

                    progress++;

                    break;



                case 8:
                    if(obj.dialog_message(complete,should,4,sw,GameActivity.class,10)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[obj.get_k()%5]--;

                    if(obj.get_k()%5==1 && color_nr[1]==1)
                        should++;
                    else if(obj.get_k()%5==2 && color_nr[2]==0)
                        should++;

                    progress++;

                    break;

                case 9:
                    if(obj.dialog_message(complete,should,4,sw,GameActivity.class,10)) {sw=5;break;}

                    if(obj.get_k()%5==3 && color_nr[3]==0)
                        should+=2;

                    but.setBackgroundResource(obj.set_color(color_nr, false, touched, 4));

                    progress++;

                    break;


                default:
                    should=4;
                    if(obj.dialog_message(complete,should,4,sw,GameActivity.class,10)) {sw=5;break;}
                    break;
            }
        }
    }
}

