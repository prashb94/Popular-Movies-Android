package com.prashanth.popularmovies;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class MoviesDetailActivity extends AppCompatActivity {

    private ImageView mPosterPath;
    private TextView mTitle;
    private TextView mVoteCount;
    private TextView mVoteAverage;
    private TextView mOverview;
    private TextView mReleaseDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_details);

        mPosterPath = (ImageView) findViewById(R.id.iv_posterPath);
        mTitle = (TextView) findViewById(R.id.tv_title);
        mVoteCount = (TextView) findViewById(R.id.tv_voteCount);
        mVoteAverage = (TextView) findViewById(R.id.tv_voteAverage);
        mOverview = (TextView) findViewById(R.id.tv_overview);
        mReleaseDate = (TextView) findViewById(R.id.tv_releaseDate);
        Intent parentActivity = getIntent();
        Bundle extras = parentActivity.getExtras();

        if(parentActivity.hasExtra("Poster_Path")){
            String posterPath = extras.getString("Poster_Path");
            final String BASE_URL = "http://image.tmdb.org/t/p/";
            final String IMAGE_SIZE = "w500";
            Uri posterImage = Uri.parse(BASE_URL).buildUpon().appendPath(IMAGE_SIZE).appendEncodedPath(posterPath).build();
            Picasso.with(this).load(posterImage.toString()).into(mPosterPath);
        }
        if(parentActivity.hasExtra("Title")){
            String title = extras.getString("Title");
            mTitle.setText(title);
            Log.v("ReceivedArrayData", title);
        }
        if(parentActivity.hasExtra("Vote_Count")){
            String voteCount = extras.getString("Vote_Count");
            mVoteCount.setText(voteCount);
        }
        if(parentActivity.hasExtra("Vote_Average")){
            String voteAverage = extras.getString("Vote_Average");
            mVoteAverage.setText(voteAverage);
        }
        if(parentActivity.hasExtra("Overview")){
            String overview = extras.getString("Overview");
            mOverview.setText(overview);
        }
        if(parentActivity.hasExtra("Release_Date")){
            String releaseDate = extras.getString("Release_Date");
            mReleaseDate.setText(releaseDate);
       }

    }

}
