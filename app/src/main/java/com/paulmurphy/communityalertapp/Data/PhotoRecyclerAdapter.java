package com.paulmurphy.communityalertapp.Data;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.paulmurphy.communityalertapp.Model.Photo;
import com.paulmurphy.communityalertapp.R;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;



public class PhotoRecyclerAdapter extends RecyclerView.Adapter<PhotoRecyclerAdapter.ViewHolder> {

    private Context context;
    private List<Photo> photoList;

    public PhotoRecyclerAdapter(Context context, List<Photo> photoList) {
        this.context = context;
        this.photoList = photoList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_row, parent, false);

        return new ViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Photo photo = photoList.get(position);
        String imageUrl = null;

        holder.title.setText(photo.getTitle());
        holder.desc.setText(photo.getDesc());


        java.text.DateFormat dateFormat = java.text.DateFormat.getDateInstance();
        String formattedDate = dateFormat.format(new Date(Long.valueOf(photo.getTimestamp())).getTime());

        holder.timestamp.setText(formattedDate);

        imageUrl = photo.getImage();

        //TODO: Use Picasso library to load image
        Picasso.get().load(imageUrl).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public TextView desc;
        public TextView timestamp;
        public ImageView image;
        String userid;

        public ViewHolder(View view, Context ctx) {
            super(view);

            context = ctx;

            title = (TextView) view.findViewById(R.id.postTitleList);
            desc = (TextView) view.findViewById(R.id.postTextList);
            image = (ImageView) view.findViewById(R.id.postImageList);
            timestamp = (TextView) view.findViewById(R.id.timestampList);

            userid = null;

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Go to the next activity...
                }
            });
        }
    }
}
