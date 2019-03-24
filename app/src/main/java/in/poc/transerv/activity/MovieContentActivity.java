package in.poc.transerv.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import in.poc.transerv.R;
import in.poc.transerv.data.MovieContent;
import in.poc.transerv.utility.Constants;

/**
 * This class <i>MovieContentActivity</i> is showing details of selected movie
 * <p>
 *
 * @author Tanmeet Singh Bhalla
 * @version %1%, %24/03/19%
 * @since 1.0
 */
public class MovieContentActivity extends AppCompatActivity {
    private MovieContent movieContent;
    private LinearLayout movieContentTable;
    private TextView movieTitle;
    private ImageView moviePoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_content);
        loadControls();
        getExtras();
        populateView();
    }

    /**
     * Fill movie details page view
     */
    private void populateView() {
        if (null != movieContent) {
            Picasso.with(this).load(movieContent.getPoster()).placeholder(R.drawable.placeholder).into(moviePoster);
            if (null != movieContent.getTitle()) {
                movieTitle.setText(movieContent.getTitle());
                Typeface tf = Typeface.createFromAsset(this.getAssets(), "amaranth-bold.ttf");
                movieTitle.setTypeface(tf);
            }
            if (null != movieContent.getPlot()) {
                createTableRow(movieContent.getPlot(), getString(R.string.desc));
            }
            if (null != movieContent.getRated()) {
                createTableRow(movieContent.getRated(), getString(R.string.year));
            }
            if (null != movieContent.getReleased()) {
                createTableRow(movieContent.getReleased(), getString(R.string.released));
            }
            if (null != movieContent.getRuntime()) {
                createTableRow(movieContent.getRuntime(), getString(R.string.runtime));
            }
            if (null != movieContent.getGenre()) {
                createTableRow(movieContent.getGenre(), getString(R.string.genre));
            }
            if (null != movieContent.getDirector()) {
                createTableRow(movieContent.getDirector(), getString(R.string.director));
            }
            if (null != movieContent.getWriter()) {
                createTableRow(movieContent.getWriter(), getString(R.string.writer));
            }
            if (null != movieContent.getActors()) {
                createTableRow(movieContent.getActors(), getString(R.string.actors));
            }
            if (null != movieContent.getLanguage()) {
                createTableRow(movieContent.getLanguage(), getString(R.string.language));
            }
            if (null != movieContent.getCountry()) {
                createTableRow(movieContent.getCountry(), getString(R.string.country));
            }
            if (null != movieContent.getAwards()) {
                createTableRow(movieContent.getAwards(), getString(R.string.awards));
            }
            if (null != movieContent.getRatings()) {
                createTableRow(movieContent.getRatings(), getString(R.string.rating));
            }
            if (null != movieContent.getMetascore()) {
                createTableRow(movieContent.getMetascore(), getString(R.string.metascore));
            }
            if (null != movieContent.getImdbRating()) {
                createTableRow(movieContent.getImdbRating(), getString(R.string.imdbrating));
            }
            if (null != movieContent.getImdbVotes()) {
                createTableRow(movieContent.getImdbVotes(), getString(R.string.imdbVotes));
            }
            if (null != movieContent.getImdbID()) {
                createTableRow(movieContent.getImdbID(), getString(R.string.imdbId));
            }
            if (null != movieContent.getType()) {
                createTableRow(movieContent.getType(), getString(R.string.type));
            }
            if (null != movieContent.getMovieDvd()) {
                createTableRow(movieContent.getMovieDvd(), getString(R.string.dvd));
            }
            if (null != movieContent.getBoxOffice()) {
                createTableRow(movieContent.getBoxOffice(), getString(R.string.box_office));
            }
            if (null != movieContent.getProduction()) {
                createTableRow(movieContent.getProduction(), getString(R.string.production));
            }
            if (null != movieContent.getWebsite()) {
                createTableRow(movieContent.getWebsite(), getString(R.string.website));
            }
            if (null != movieContent.getResponse()) {
                createTableRow(movieContent.getResponse(), getString(R.string.response));
            }
        }
    }

    /**
     * Create row of movie data
     *
     * @param title- Title of movie node type
     * @param value- Description to movie node type
     */
    public void createTableRow(String value, String title) {
        //create linear layout
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);

        //set textview in linear layout which is basically movie node title
        TextView tableTitle = new TextView(this);
        tableTitle.setText(title);
        Typeface tf = Typeface.createFromAsset(this.getAssets(), "amaranth-bold.ttf");
        tableTitle.setTypeface(tf);
        tableTitle.setTextSize(16);
        tableTitle.setPadding(8, 8, 8, 8);

        //set textview in linear layout which is basically description to movie node title
        TextView tableValue = new TextView(this);
        tableValue.setText(value);
        Typeface tf1 = Typeface.createFromAsset(this.getAssets(), "amaranth-regular.ttf");
        tableValue.setTypeface(tf1);
        tableValue.setSingleLine(false);
        tableValue.setPadding(8, 8, 8, 8);

        //add both views to linear layout
        linearLayout.addView(tableTitle);
        linearLayout.addView(tableValue);

        //add linear layout to main layout
        movieContentTable.addView(linearLayout);
    }

    /**
     * initialize views
     */
    private void loadControls() {
        movieContentTable = findViewById(R.id.movie_table);
        movieTitle = findViewById(R.id.movie_name);
        moviePoster = findViewById(R.id.movie_image);
    }

    /**
     * get data passed from main activity @see {@link MainActivity}
     */
    private void getExtras() {
        Bundle bundle = getIntent().getExtras();
        if (null != bundle) {
            movieContent = (MovieContent) bundle.get(Constants.MOVIE_CONTENT);
        }
    }
}
