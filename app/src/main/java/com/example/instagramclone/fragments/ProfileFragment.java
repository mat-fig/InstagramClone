package com.example.instagramclone.fragments;

import android.util.Log;

import com.example.instagramclone.Post;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class ProfileFragment extends PostsFragment{

    @Override
    protected void queryPosts() {
            ParseQuery<Post> query = ParseQuery.getQuery(Post.class);
            query.include(Post.KEY_USER);
            query.whereEqualTo(Post.KEY_USER, ParseUser.getCurrentUser());
            query.setLimit(20);
            query.addDescendingOrder(Post.KEY_CREATED_KEY);
            query.findInBackground(new FindCallback<Post>() {
                @Override
                public void done(List<Post> posts, ParseException e) {
                    // If parse exception e is nonnull, something has gone wrong
                    if ( e!= null){
                        Log.e(TAG,"Issue with getting posts", e);
                        //Toast.makeText(MainActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    for (Post post : posts){
                        Log.i(TAG, "Post: "+post.getDescription()+", username: "+post.getUser().getUsername() );
                        //Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    }
                    allPosts.addAll(posts);
                    adapter.notifyDataSetChanged();
                }
            });
        }
}


