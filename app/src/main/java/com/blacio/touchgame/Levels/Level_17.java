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

public class Level_17 extends Variables{
    MediaPlayer mp,mpp;

    public Level_17(Button b, Context context) {
        mp = MediaPlayer.create(context, R.raw.corect);
        mpp = MediaPlayer.create(context,R.raw.gresit);
        but = b;

        obj = new Functions(context);

        p1 = 3000;
        p2 = obj.random_nr(300,1000);
        p3 = obj.random_nr(500,1000);
        p4 = obj.random_nr(500,1000);

        c1 = obj.random_nr(1000,2000);
        c2 = obj.random_nr(300,2000);
        c3 = obj.random_nr(400,900);
        c4 = obj.random_nr(900,1600);


        color_nr = new int[]{3,0,1,4};

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

                    if (obj.get_k()%5==4 && aux1==1)
                        complete++;
                    else if (obj.get_k()%5==2 && color_nr[0]<2) ;
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
                        k2[1]=(int)SystemClock.elapsedRealtime();

                        if(obj.verify_time(k2,3000)){
                            complete++;
                            should++;
                            aux++;
                        }
                        else complete=-1;
                    }

                    else if (obj.get_k()%5==2 && color_nr[0]<2)
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
                    Thread.sleep(p2);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(c4);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(p1);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(c3);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(350);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(c2);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(350);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(c3);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(350);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(c4);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(350);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(c2);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(p1);
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
                    Thread.sleep(p3);
                    publishProgress();}
                if(sw!=5){
                    Thread.sleep(c1);
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
                    if(obj.dialog_message(complete,should,4,sw,GameActivity.class,17)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[obj.get_k()%5]--;

                    if (obj.get_k()%5==2)   color_nr[1]=1;

                    if(obj.get_k()%5==2 && color_nr[0]<2)
                        should+=2;

                    progress++;

                    break;

                case 1:
                    if(obj.dialog_message(complete,should,4,sw,GameActivity.class,17)) {sw=5;break;}

                    if(obj.get_k()%5==2) {should++;aux1=1;}

                    but.setBackgroundResource(obj.set_color(color_nr, false, touched, 4));

                    progress++;

                    break;

                case 2:
                    aux1=0;
                    if(obj.dialog_message(complete,should,4,sw,GameActivity.class,17)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[obj.get_k()%5]--;

                    if (obj.get_k()%5==2)   color_nr[1]=1;
                    else if(obj.get_k()%5==1) {aux++;k2[0]=(int)SystemClock.elapsedRealtime();}

                    if(obj.get_k()%5==2 && color_nr[0]<2)
                        should+=2;

                    progress++;

                    break;

                case 3:
                    if(obj.dialog_message(complete,should,4,sw,GameActivity.class,17)) {sw=5;break;}

                    if(obj.get_k()%5==2) {should++;aux1=1;}

                    but.setBackgroundResource(obj.set_color(color_nr, false, touched, 4));

                    progress++;

                    break;

                case 4:
                    aux1=0;
                    if(obj.dialog_message(complete,should,4,sw,GameActivity.class,17)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[obj.get_k()%5]--;

                    if (obj.get_k()%5==2)   color_nr[1]=1;
                    else if(obj.get_k()%5==1) {aux++;k2[0]=(int)SystemClock.elapsedRealtime();}

                    if(obj.get_k()%5==2 && color_nr[0]<2)
                        should+=2;

                    progress++;

                    break;

                case 5:
                    if(obj.dialog_message(complete,should,4,sw,GameActivity.class,17)) {sw=5;break;}

                    if(obj.get_k()%5==2 && aux<2) {should++;aux1=1;}

                    but.setBackgroundResource(obj.set_color(color_nr, false, touched, 4));

                    progress++;

                    break;

                case 6:
                    aux1=0;
                    if(obj.dialog_message(complete,should,4,sw,GameActivity.class,17)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[obj.get_k()%5]--;

                    if (obj.get_k()%5==2)   color_nr[1]=1;
                    else if(obj.get_k()%5==1) {aux++;k2[0]=(int)SystemClock.elapsedRealtime();}
                    else if(aux==2) {color_nr[2]++;aux=5;}

                    if(obj.get_k()%5==2 && color_nr[0]<2)
                        should+=2;

                    progress++;

                    break;

                case 7:
                    if(obj.dialog_message(complete,should,4,sw,GameActivity.class,17)) {sw=5;break;}

                    if(obj.get_k()%5==2 && aux<2) {should++;aux1=1;}

                    but.setBackgroundResource(obj.set_color(color_nr, false, touched, 4));

                    progress++;

                    break;



                case 8:
                    aux1=0;
                    if(obj.dialog_message(complete,should,4,sw,GameActivity.class,17)) {sw=5;break;}

                    if(color_nr[2]==1)
                        but.setBackgroundResource(obj.set_color(color_nr, false, touched, 2));
                    else
                        but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));

                    color_nr[obj.get_k()%5]--;

                    if (obj.get_k()%5==2)   color_nr[1]=1;
                    else if(obj.get_k()%5==1) {aux++;k2[0]=(int)SystemClock.elapsedRealtime();}
                    else if(aux==2) {color_nr[2]++;aux=5;}

                    if(obj.get_k()%5==2 && color_nr[0]<2)
                        should+=2;

                    progress++;

                    break;

                case 9:
                    if(obj.dialog_message(complete,should,4,sw,GameActivity.class,17)) {sw=5;break;}

                    if(obj.get_k()%5==2 && aux<2) {should++;aux1=1;}

                    but.setBackgroundResource(obj.set_color(color_nr, false, touched, 4));

                    progress++;

                    break;

                case 10:
                    aux1=0;
                    if(obj.dialog_message(complete,should,4,sw,GameActivity.class,17)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[obj.get_k()%5]--;

                    if(obj.get_k()%5==1) {aux++;k2[0]=(int)SystemClock.elapsedRealtime();}
                    else if(aux==2) {color_nr[2]++;aux=5;}

                    if(obj.get_k()%5==2 && color_nr[0]<2)
                        should+=2;

                    progress++;

                    break;

                case 11:
                    if(obj.dialog_message(complete,should,4,sw,GameActivity.class,17)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, false, touched, 4));

                    progress++;

                    break;

                case 12:
                    if(obj.dialog_message(complete,should,4,sw,GameActivity.class,17)) {sw=5;break;}

                    if(color_nr[1]==1)
                        but.setBackgroundResource(obj.set_color(color_nr, false, touched, 1));
                    else
                        but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));

                    color_nr[obj.get_k()%5]--;

                    if(obj.get_k()%5==1) {aux++;k2[0]=(int)SystemClock.elapsedRealtime();}
                    else if(aux==2) {color_nr[2]++;aux=5;}

                    if(obj.get_k()%5==2 && color_nr[0]<2)
                        should+=2;

                    progress++;

                    break;

                case 13:
                    if(obj.dialog_message(complete,should,4,sw,GameActivity.class,17)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, false, touched, 4));

                    progress++;

                    break;

                case 14:
                    if(aux!=5) aux=2;

                    if(obj.dialog_message(complete,should,4,sw,GameActivity.class,17)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[obj.get_k()%5]--;

                    if(aux==2) {color_nr[2]++;aux=5;}

                    if(obj.get_k()%5==2 && color_nr[0]<2)
                        should+=2;

                    progress++;

                    break;

                case 15:
                    if(obj.dialog_message(complete,should,4,sw,GameActivity.class,17)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, false, touched, 4));

                    progress++;

                    break;

                case 16:
                    if(obj.dialog_message(complete,should,4,sw,GameActivity.class,17)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[obj.get_k()%5]--;

                    if(obj.get_k()%5==2 && color_nr[0]<2)
                        should+=2;

                    progress++;

                    break;

                case 17:
                    if(obj.dialog_message(complete,should,4,sw,GameActivity.class,17)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, false, touched, 4));

                    progress++;

                    break;



                case 18:
                    if(obj.dialog_message(complete,should,4,sw,GameActivity.class,17)) {sw=5;break;}
                    but.setBackgroundResource(obj.set_color(color_nr, true, touched, 0));
                    color_nr[obj.get_k()%5]--;

                    if(obj.get_k()%5==2 && color_nr[0]<2)
                        should+=2;

                    progress++;

                    break;



                default:
                    should=4;
                    if(obj.dialog_message(complete,should,4,sw,GameActivity.class,17)) {sw=5;break;}
                    break;
            }
        }
    }
}

