package com.blacio.touchgame;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class GridListAdapter extends RecyclerView.Adapter<Holder> {

    private final int mSpanCount;
    private List<GridItem> mItemList;
    private Context context;
    private int pos;
    private int p;


    public GridListAdapter(List<GridItem> myItemList, GridLayoutManager gridLayoutManager, int i,Context context,int p){
        this.context = context;
        mItemList = myItemList;
        mSpanCount = i;
        pos=0;this.p=p;
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return 1;
            }
        });
    }



    @Override
    public Holder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view;
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_item,viewGroup,false);

        return new Holder(view);
    }


    @Override
    public void onBindViewHolder(Holder holder, int position) {
            bindGridItem(holder,position);
    }

    private void bindGridItem(Holder holder, final int position) {

        View container =  holder.itemView;

        TextView title1 = (TextView) container.findViewById(R.id.levelNumber);
        TextView title2 = (TextView) container.findViewById(R.id.levelCompleted);
        final CardView myCardView = (CardView) container.findViewById(R.id.levelCard);

        title1.setText(mItemList.get(position).getmTitle());
        myCardView.setCardElevation(35);


        if(position<p-1){
                myCardView.setCardBackgroundColor(Color.parseColor("#4DFFFFFF"));
                title2.setText("DONE");
                title2.setTextColor(Color.GREEN);}
        else if(position == p-1) {
            myCardView.setCardBackgroundColor(Color.parseColor("#4D33B5E5"));
            title2.setText("GO!");
            title2.setTextColor(Color.WHITE);
        }
        else{
                myCardView.setCardBackgroundColor(Color.parseColor("#1AFFFFFF"));
                title2.setText("X");
                title2.setTextColor(Color.WHITE);
            }



        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(position<=p-1) {
                    AudioPlay.stopAudio();
                    pos = position + 1;
                    startIntent();
                }
                else    ;

            }
        });
    }


    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return 1;
    }

    public void addItem (GridItem item){
        mItemList.add(item);
        notifyDataSetChanged();
    }

    private void startIntent(){
                Intent i = new Intent(context,GameActivity.class);
                    i.putExtra("POSITION",pos);
                    i.putExtra("bool_dialog",true);
                context.startActivity(i);
    }
}
