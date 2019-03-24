package in.poc.transerv.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import in.poc.transerv.R;
import in.poc.transerv.adapter.MovieAdapter;
import in.poc.transerv.data.Movie;
import in.poc.transerv.data.MovieContent;
import in.poc.transerv.provider.MovieProvider;
import in.poc.transerv.proxy.MovieApiProvider;
import in.poc.transerv.utility.Constants;
import in.poc.transerv.utility.GridSpacingItemDecoration;

/**
 * This class <i>MainActivity</i> is root activity.
 * <p>
 * This activity shows list of movies in grid of 3 with movie poster and title
 *
 * @author Tanmeet Singh Bhalla
 * @version %1%, %24/03/19%
 * @since 1.0
 */
public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter = null;
    private List<MovieContent> movieList;
    private TextView noDataText;
    private Button retryBtn;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadControls();
        initListener();
        initLayoutManager();
        initAdapter();
        fetchMovieList();
    }

    /**
     * Initialize listener
     */
    private void initListener() {
        retryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableView();
                fetchMovieList();
            }
        });
    }

    /**
     * fetch list of movies from server @see {@link MovieApiProvider#getMovieList()}
     */
    private void fetchMovieList() {
        showProgressBar();
        MovieProvider.getMovieData(this);
    }

    /**
     * initialize movie adapter
     */
    private void initAdapter() {
        movieList = new ArrayList<>();

        //click listener for movie items
        MovieAdapter.MovieViewAdapterDelegate movieViewAdapterDelegate = new MovieAdapter.MovieViewAdapterDelegate() {
            @Override
            public void onMovieClick(MovieContent movieContent) {
                if (null != movieContent) {
                    Intent startMovieContentActivity = new Intent(MainActivity.this, MovieContentActivity.class);
                    startMovieContentActivity.putExtra(Constants.MOVIE_CONTENT, movieContent);
                    startActivity(startMovieContentActivity);
                }
            }
        };
        movieAdapter = new MovieAdapter(this, movieList, movieViewAdapterDelegate);
        recyclerView.setAdapter(movieAdapter);
    }

    /**
     * initialize views
     */
    private void loadControls() {
        recyclerView = findViewById(R.id.movie_recycler_view);
        noDataText = findViewById(R.id.no_data_view);
        retryBtn = findViewById(R.id.retry_btn);
        progressBar = findViewById(R.id.progress_bar);
    }

    /**
     * Set Layout manager
     */
    private void initLayoutManager() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, Constants.GRID_COL_COUNT_THREE);
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.margin_8);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(Constants.GRID_COL_COUNT_THREE, spacingInPixels, true, 0));
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    /**
     * on success of @see {@link MovieApiProvider#getMovieList()}
     */
    public void getMovieSuccess(Movie movie) {
        enableView();
        if (null != movie) {
            movieList.addAll(movie.getMovies());
            //notifies adapter on change of data
            movieAdapter.notifyDataSetChanged();
        }
    }

    /**
     * on failure of @see {@link MovieApiProvider#getMovieList()}
     */
    public void getMovieFailure(int status) {
        if (status == 0) {
            noDataText.setText(R.string.internet_failure_msg);
        }
        disableView();
    }

    /**
     * Shows movie list items
     */
    public void enableView() {
        hideProgressBar();
        retryBtn.setVisibility(View.GONE);
        noDataText.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    /**
     * hides movie list items and shows retry button and error msg
     */
    public void disableView() {
        hideProgressBar();
        retryBtn.setVisibility(View.VISIBLE);
        noDataText.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    /**
     * show progress bar
     */
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    /**
     * hide progress bar
     */
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }
}
