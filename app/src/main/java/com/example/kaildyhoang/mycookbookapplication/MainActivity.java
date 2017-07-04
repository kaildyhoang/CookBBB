package com.example.kaildyhoang.mycookbookapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.firebase.client.Firebase;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DatabaseReference databaseRef,postDatabaseRef;
    private ProgressDialog progressDialog;
    private FirebaseRecyclerAdapter<Post, PostViewHolder> mPostAdapter;
    private String TAG = "PostAdapter";

    private FirebaseAuth mAuth;
    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialiseScreen();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Opening...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                startActivity(new Intent(getApplicationContext(),AddNewPostActivity.class));
            }
        });
    }

    private void initialiseScreen(){
        databaseRef = FirebaseDatabase.getInstance().getReference();
        postDatabaseRef = FirebaseDatabase.getInstance().getReference().child("posts");

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewShow);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        Toast.makeText(MainActivity.this,"Wait! Fetching list...", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStart() {
        super.onStart();

        mPostAdapter = new FirebaseRecyclerAdapter<Post, PostViewHolder>(
                Post.class,
                R.layout.activity_post_items,
                PostViewHolder.class,
                postDatabaseRef)
        {

            @Override
            protected void populateViewHolder(final PostViewHolder viewHolder, Post model,final int position) {
                String postById = model.getPostBy();
                System.out.println(postById);
                databaseRef.child("users/").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        System.out.println(dataSnapshot.getChildrenCount());
                        for (DataSnapshot userSnapshot: dataSnapshot.getChildren()) {
                            User user = userSnapshot.getValue(User.class);
                            viewHolder.postBy(user.getName());
                            viewHolder.avatarPicture(user.getAvatar());
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        System.out.println("The read failed: " + databaseError.getMessage());
                    }
                });
                viewHolder.postTitle(model.getTitle());
                viewHolder.countOfLikes(String.valueOf(model.getCountOfLikes()));
                viewHolder.illustrationPicture(model.getIllustrationPicture());

//                Item Click
                viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("Do you want to delete this data?").setCancelable(false)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        int selectedItem = position;

                                        Log.d(TAG, "Dy:onClick " + "position:" + selectedItem);

                                        mPostAdapter.getRef(selectedItem).removeValue();
                                        mPostAdapter.notifyItemRemoved(selectedItem);
                                        recyclerView.invalidate();
                                        onStart();
                                    }
                                })
                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog dialog = builder.create();
                        dialog.setTitle("Confirm");
                        dialog.show();
                    }
                });
            }
        };
        recyclerView.setAdapter(mPostAdapter);
    }
    //    View holder for recycler view
    public static class PostViewHolder extends RecyclerView.ViewHolder{

        private final TextView _txtVUserName, _txtVCountLikes, _txtVTitle;
        private final ImageView _imgVCover, _imgVAvatar;

        public PostViewHolder(final View itemView) {
            super(itemView);

            //TextView
            _txtVUserName = (TextView) itemView.findViewById(R.id.textViewUserName);
            _txtVCountLikes = (TextView) itemView.findViewById(R.id.textViewCountLikes);
            _txtVTitle = (TextView) itemView.findViewById(R.id.textViewTitle);

            //ImageView
            _imgVCover = (ImageView) itemView.findViewById(R.id.imageViewCover);
            _imgVAvatar = (ImageView) itemView.findViewById(R.id.imageViewAvatar);


        }

        private void postBy(String title){
            _txtVUserName.setText(title);
        }
        private void countOfLikes(String title){
            _txtVCountLikes.setText(String.valueOf(title));
        }
        private void postTitle(String title){
            _txtVTitle.setText(title);
        }
        private void illustrationPicture(String title){
            Glide.with(itemView.getContext())
                    .load(title)
                    .crossFade()
                    .placeholder(R.drawable.load_icon)
                    .thumbnail(0.1f)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(_imgVCover);
        }
        private void avatarPicture(String title){
            Glide.with(itemView.getContext())
                    .load(title)
                    .crossFade()
                    .placeholder(R.drawable.load_icon)
                    .thumbnail(0.1f)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(_imgVAvatar);
        }
    }

    private void showProgressDialog(){
        progressDialog.setMessage("Waiting...");
        progressDialog.show();
    }
    private void hideProgressDialog(){
        progressDialog.dismiss();
    }
}
