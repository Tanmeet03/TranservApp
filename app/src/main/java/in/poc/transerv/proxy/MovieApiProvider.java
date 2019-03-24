package in.poc.transerv.proxy;

import in.poc.transerv.data.Movie;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * This interface <i>MovieApiProvider</i> is to implement REST calls
 * <p>
 *
 * @author Tanmeet Singh Bhalla
 * @version %1%, %24/03/19%
 * @since 1.0
 */
public interface MovieApiProvider {
    /**
     * get list of album from server
     */
    @GET("/bins/itzx2")
    Call<Movie> getMovieList();
}
