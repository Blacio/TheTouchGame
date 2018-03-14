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

public class Level_19 extends Variables{
    MediaPlayer mp,mpp;

    public Level_19(Button b, Context context) {
        mp = MediaPlayer.create(context, R.raw.corect);
        mpp = MediaPlayer.create(context,R.raw.gresit);
        but = b;

        obj = new Functions(context);

        c1 = 600;
        p1 = obj.random_nr(900,2100);

        c2 = obj.random_nr(700,1700);
        p2 = obj.random_nr(600,1000);

        c3 = obj.random_nr(500,1300);
        p3 = 400;

        c4 = obj.random_nr(500,1500);
        p4 = 2000;

        p5 = 250;

        color_nr = new int[]{0,1,0,1};

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

                    if(complete==2 && obj.get_k()%5==2) complete++;
                    else if (complete==4 && aux==2){
                        k3[1] = (int) SystemClock.elapsedRealtime();

                        if(obj.verify_time(k3,1000))
                            complete++;
                        else complete=-1;
                    }
                    else if(complete<2 && obj.get_k()%5==1) ;
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
                        k2[1] = (int) SystemClock.elapsedRealtime();
                        if(obj.verify_time(k2,3000)) {
                            complete++;
                            should++;
                            k3[0] = k2[1];
                        }
                        else complete=-1;
                    }
                    else{
                        if (obj.get_k()%5==1) {
                            if (complete < 2)
                                complete++;
                            else complete = -1;
                        }
                        else if (complete==5)  ;
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

                Thread.sleep(3000);
                publishProgress();
                if(sw!=5){
                    Thread.sleep(c1);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(p1);
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
                    Thread.sleep(p4);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(c2);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(p4);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(c3);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(p4);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(p5);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(p5);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(p5);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(p5);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(p5);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(p5);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(p5);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(p5);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(p5);
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
                    if(obj.dialog_message(complete,should,5,sw,GameActivity.class,19)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[obj.get_k()%5]--;

                    if(obj.get_k()%5==1)    {color_nr[2]=1;should=+2;k3[0]=(int)SystemClock.elapsedRealtime();}

                    progress++;

                    break;

                case 1:
                    if(obj.dialog_message(complete,should,5,sw,GameActivity.class,19)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, false, touched, 4));

                    progress++;

                    break;

                case 2:
                    if(obj.dialog_message(complete,should,5,sw,GameActivity.class,19)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[obj.get_k()%5]--;

                    if(obj.get_k()%5==1)    {color_nr[2]=1;should=+2;k3[0]=(int)SystemClock.elapsedRealtime();}
                    else if(obj.get_k()%5==2)   {should++;k3[1]=(int)SystemClock.elapsedRealtime();}

                    progress++;

                    break;

                case 3:
                    if(obj.dialog_message(complete,should,5,sw,GameActivity.class,19)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, false, touched, 4));

                    progress++;

                    break;

                case 4:
                    if(obj.dialog_message(complete,should,5,sw,GameActivity.class,19)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[obj.get_k()%5]--;

                    if(obj.get_k()%5==2)   {should++;k3[1]=(int)SystemClock.elapsedRealtime();}

                    progress++;

                    break;

                case 5:
                    if(obj.dialog_message(complete,should,5,sw,GameActivity.class,19)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, false, touched, 4));

                    if (k3[1]-k3[0]<2000)
                        aux=1;
                    else aux=2;

                    k3[0]=0;k3[1]=0;

                    progress++;

                    break;

                case 6:
                    if(obj.dialog_message(complete,should,5,sw,GameActivity.class,19)) {sw=5;break;}

                    color_nr = new int[]{0,1,1,1};

                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[obj.get_k()%5]--;

                    progress++;

                    break;

                case 7:
                    if(obj.dialog_message(complete,should,5,sw,GameActivity.class,19)) {sw=5;break;}

                    if(obj.get_k()%5==1)    k2[0] = (int)SystemClock.elapsedRealtime();

                    but.setBackgroundResource(obj.set_color(color_nr, false, touched, 4));

                    progress++;

                    break;


                case 8:
                    if(obj.dialog_message(complete,should,5,sw,GameActivity.class,19)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[obj.get_k()%5]--;

                    progress++;

                    break;

                case 9:
                    if(obj.dialog_message(complete,should,5,sw,GameActivity.class,19)) {sw=5;break;}

                    if(obj.get_k()%5==1)    k2[0] = (int)SystemClock.elapsedRealtime();

                    but.setBackgroundResource(obj.set_color(color_nr, false, touched, 4));

                    progress++;

                    break;

                case 10:
                    if(obj.dialog_message(complete,should,5,sw,GameActivity.class,19)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[obj.get_k()%5]--;

                    progress++;

                    break;

                case 11:
                    if(obj.dialog_message(complete,should,5,sw,GameActivity.class,19)) {sw=5;break;}

                    if(obj.get_k()%5==1)    k2[0] = (int)SystemClock.elapsedRealtime();

                    but.setBackgroundResource(obj.set_color(color_nr, false, touched, 4));

                    progress++;

                    break;

                case 12:
                    if(obj.dialog_message(complete,should,5,sw,GameActivity.class,19)) {sw=5;break;}

                    color_nr = new int[]{3,2,2,1};

                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[obj.get_k()%5]--;

                    if(aux==1){
                        complete++;should++;
                    }
                    else should++;

                    progress++;

                    break;

                case 13:
                    but.setBackgroundResource(obj.set_color(color_nr, false, touched, 4));
                    progress++;

                    break;

                case 14:
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[obj.get_k()%5]--;

                    progress++;

                    break;

                case 15:
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[obj.get_k()%5]--;

                    progress++;

                    break;

                case 16:
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[obj.get_k()%5]--;

                    progress++;

                    break;

                case 17:
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[obj.get_k()%5]--;

                    progress++;

                    break;

                case 18:
                    but.setBackgroundResource(obj.set_color(color_nr, false, touched, 4));
                    progress++;

                    break;

                case 19:
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[obj.get_k()%5]--;

                    progress++;

                    break;

                case 20:
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[obj.get_k()%5]--;

                    progress++;

                    break;

                case 21:
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[obj.get_k()%5]--;

                    progress++;

                    break;



                default:
                    should=5;
                    if(obj.dialog_message(complete,should,5,sw,GameActivity.class,19)) {sw=5;break;}
                    break;
            }
        }
    }
}

