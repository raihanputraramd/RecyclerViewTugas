package com.example.recyclerviewtugas;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Random;

public class MailAdapter extends RecyclerView.Adapter<MailAdapter.ViewHolder> {

    private List <EmailData> mEmailData;
    private Context mContext;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView icon;
        TextView sender;
        TextView email;
        TextView caption;
        TextView time;
        ImageView fav;
        public ViewHolder(View itemView) {
            super(itemView);

            icon = itemView.findViewById(R.id.txtIcon);
            sender = (TextView) itemView.findViewById(R.id.txtSender);
            email = (TextView) itemView.findViewById(R.id.txtEmail);
            caption = (TextView) itemView.findViewById(R.id.txtCaption);
            time = (TextView) itemView.findViewById(R.id.txtTime);
            fav = (ImageView) itemView.findViewById(R.id.imgFav);
        }
    }
    public MailAdapter (List<EmailData> mEmailData, MainActivity mContext) {
        this.mEmailData = mEmailData;
        this.mContext = mContext;
    }


    @Override
    public MailAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_mail_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( final MailAdapter.ViewHolder holder, int position) {
        Random random = new Random();
        int color = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        ((GradientDrawable) holder.icon.getBackground()).setColor(color);

        EmailData email = mEmailData.get(position);
        holder.sender.setText(email.getSender());
        holder.email.setText(email.getEmail());
        holder.caption.setText(email.getCaption());
        holder.time.setText(email.getTime());
        holder.fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.fav.getColorFilter() != null) {
                    holder.fav.clearColorFilter();
                }else{
                    holder.fav.setColorFilter(ContextCompat.getColor(mContext, R.color.colorAccent));
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return mEmailData.size();
    }
}