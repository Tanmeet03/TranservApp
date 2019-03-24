package in.poc.transerv.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import in.poc.transerv.R;
import in.poc.transerv.data.MovieContent;

/**
 * This class <i>MovieAdapter</i> is adapter class to inflate views to item rows of recycler view
 * <p>
 *
 * @author Tanmeet Singh Bhalla
 * @version %1%, %24/03/19%
 * @since 1.0
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private final List<MovieContent> movieContentList;
    private Context context;
    private MovieViewAdapterDelegate movieViewAdapterDelegate;

    /**
     * MovieAdapter Constructor
     *
     * @param context-                  tells newly created object whats being going on
     * @param movieContentList-         List of movies
     * @param movieViewAdapterDelegate- interface of registering movie click event
     */
    public MovieAdapter(Context context, List<MovieContent> movieContentList, MovieViewAdapterDelegate movieViewAdapterDelegate) {
        this.movieContentList = movieContentList;
        this.movieViewAdapterDelegate = movieViewAdapterDelegate;
        this.context = context;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_movie_row, viewGroup, false);
        return new MovieAdapter.MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder movieViewHolder, int position) {
        final MovieContent movieContent = movieContentList.get(position);
        String moviePoster = movieContent.getPoster();
        Picasso.with(context).load(moviePoster).placeholder(R.drawable.placeholder).into(movieViewHolder.movieThumbnail);
        movieViewHolder.movieTitle.setText(movieContent.getTitle());
        movieViewHolder.movieThumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movieViewAdapterDelegate.onMovieClick(movieContent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieContentList.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView movieThumbnail;
        TextView movieTitle;

        MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            movieThumbnail = itemView.findViewById(R.id.movie_img);
            movieTitle = itemView.findViewById(R.id.movie_title);
        }
    }

    /**
     * Interface for on click of movie
     */
    public interface MovieViewAdapterDelegate {
        void onMovieClick(MovieContent movieContent);
    }
}
