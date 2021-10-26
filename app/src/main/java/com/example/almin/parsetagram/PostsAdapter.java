package com.example.almin.parsetagram;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private Context context;
    private List<Post> posts;

    public PostsAdapter(Context context, List<Post> posts) {
        this.context=context;
        this.posts=posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.bind(post);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void clear() {
        posts.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<Post> postList) {
        posts.addAll(postList);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvUsername;
        private ImageView ivImage;
        private TextView tvDescription;
        private TextView tvCreated;
        private TextView tvName;
        private TextView tvLikes;
        private ImageButton btnLike;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUsername=itemView.findViewById(R.id.tvUsername);
            ivImage=itemView.findViewById(R.id.ivImage);
            tvDescription=itemView.findViewById(R.id.tvDescription);
            tvCreated=itemView.findViewById(R.id.tvCreated);
            tvName=itemView.findViewById(R.id.tvName);
            tvLikes=itemView.findViewById(R.id.tvLikes);
            btnLike=itemView.findViewById(R.id.btnLike);
        }

        public void bind(Post post) {
            tvCreated.setText(TimeFormatter.getTimeDifference(post.getCreatedAt().toString())+" ago");
            tvDescription.setText(post.getDescription());
            tvUsername.setText(post.getUser().getUsername());
            tvName.setText(post.getUser().getUsername()+":");
            tvLikes.setText(post.getLikes().toString());
            ParseFile image = post.getImage();
            if (image!=null) {
                Glide.with(context).load(post.getImage().getUrl()).into(ivImage);
            }

            btnLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Integer total = post.getLikes().intValue()+1;
                    Number total1 = total;
                    post.setLikes(total1);
                    tvLikes.setText(post.getLikes().toString());
                }
            });

            ivImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context,DetailActivity.class);
                    i.putExtra("description",post.getDescription());
                    i.putExtra("time",TimeFormatter.getTimeDifference(post.getCreatedAt().toString()));
                    i.putExtra("image",post.getImage());
                    context.startActivity(i);
                }
            });
        }
    }
}
