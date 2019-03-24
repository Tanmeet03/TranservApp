package in.poc.transerv.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * This class <i>Movie</i> is Pojo class to give list of movies
 * <p>
 *
 * @author Tanmeet Singh Bhalla
 * @version %1%, %24/03/19%
 * @since 1.0
 */
public class Movie {
    @SerializedName("movies")
    @Expose
    private List<MovieContent> movies;

    public List<MovieContent> getMovies() {
        return movies;
    }
}
