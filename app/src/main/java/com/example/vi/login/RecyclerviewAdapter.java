package com.example.vi.login;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLTransactionRollbackException;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by taufiqotulfaidah on 8/22/16.
 */
public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.ItemHolder>{

    private Context context;
    private LayoutInflater layoutInflater;
    private List<String> itemName;
    private List<String> itemPhone;
    private List<String> itemEmail;

    public RecyclerviewAdapter(Context context){
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        itemName = new ArrayList<>();
        itemPhone = new ArrayList<>();
        itemEmail = new ArrayList<>();
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView itemCard = (CardView)layoutInflater.inflate(R.layout.cardview,parent,false);
        return new ItemHolder(itemCard);
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {

        holder.setItemText(itemName.get(position));
        holder.setItemPhone(itemPhone.get(position));
        holder.setItemEmail(itemEmail.get(position));
    }

    @Override
    public int getItemCount() {
        return itemName.size();
    }

    public void addItem(int location,String iName, String iPhone, String iEmail){
        itemName.add(location,iName);
        itemPhone.add(location,iPhone);
        itemEmail.add(location,iEmail);
        notifyItemInserted(location);
    }

    public void clearAllItem(){
        itemName.clear();
        itemPhone.clear();
        itemEmail.clear();
        notifyDataSetChanged();
    }


    public class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private CardView card_1;

        @BindView(R.id.imageView2)ImageView img_cv;
        @BindView(R.id.textView2)TextView tv_cv;
        @BindView(R.id.cv_tv_phone)TextView cv_tv_phone;
        @BindView(R.id.cv_tv_email)TextView cv_tv_email;

        public ItemHolder(CardView itemView) {
            super(itemView);
            card_1 = itemView;

            ButterKnife.bind(this,itemView);

            card_1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view,"You Click ~ " + tv_cv.getText().toString(),Snackbar.LENGTH_SHORT).setAction("action",null).show();
                    Intent intent = new Intent(context,CollapseActivity.class);
                    context.startActivity(intent);
                }
            });
        }

        @Override
        public void onClick(View view) {

        }

        public void setItemImage(String imagePath){

        }

        public void setItemText(String value){
            tv_cv.setText(value);
        }

        public void setItemPhone(String value){
            cv_tv_phone.setText(value);
        }

        public void setItemEmail(String value){
            cv_tv_email.setText(value);
        }
    }
}
