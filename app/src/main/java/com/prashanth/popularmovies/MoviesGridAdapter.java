package com.prashanth.popularmovies;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class MoviesGridAdapter extends RecyclerView.Adapter<MoviesGridAdapter.MoviesGridViewHolder> {

    private static final String POSTER_PATH = "poster_path";
    private ArrayList<HashMap<String, String>> moviesList = new ArrayList<>();
    private LayoutInflater mInflater;
    private ArrayList<String> moviePosters = new ArrayList<>();
    private Context mContext;

    private final MoviesGridAdapterOnClickHandler mClickHandler;

    public interface MoviesGridAdapterOnClickHandler {
        void onListItemClick(int clickedItemIndex);
    }


    public MoviesGridAdapter(Context context, MoviesGridAdapterOnClickHandler listener) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mClickHandler = listener;
    }


    public void setMovieData(ArrayList<HashMap<String,String>> data){
        moviesList = data;
        if(moviesList != null) {
            moviePosters.clear();
            for (HashMap<String, String> movie : moviesList) {
                moviePosters.add(movie.get(POSTER_PATH));
            }
        }
        else if (moviesList == null){
            moviePosters = null;
        }
        notifyDataSetChanged();
    }


    public class MoviesGridViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView mMoviePoster;
        public MoviesGridViewHolder(View item){
            super(item);
            mMoviePoster = (ImageView) item.findViewById(R.id.iv_movie_poster);
            item.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int clickedItem = getAdapterPosition();
            mClickHandler.onListItemClick(clickedItem);
        }
    }


    @Override
    public MoviesGridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.movies_grid_item, parent, false);
        return new MoviesGridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MoviesGridViewHolder holder, int position) {
        String moviePosterPath = moviePosters.get(position);
        final String BASE_URL = "http://image.tmdb.org/t/p/";
        final String IMAGE_SIZE = "w500";
        Uri posterPath = Uri.parse(BASE_URL).buildUpon().appendPath(IMAGE_SIZE).appendEncodedPath(moviePosterPath).build();
        Picasso.with(mContext).load(posterPath.toString()).into(holder.mMoviePoster);

    }

    @Override
    public int getItemCount() {
        if(moviePosters!= null) {
            return moviePosters.size();
        }
        else
            return 0;
    }

}
