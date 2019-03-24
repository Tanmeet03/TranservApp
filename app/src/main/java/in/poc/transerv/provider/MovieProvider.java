package in.poc.transerv.provider;

import in.poc.transerv.activity.MainActivity;
import in.poc.transerv.data.Movie;
import in.poc.transerv.proxy.MovieApi;
import in.poc.transerv.proxy.MovieApiProvider;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * This class <i>MovieProvider</i> is provider class which gives response data from api
 * <p>
 *
 * @author Tanmeet Singh Bhalla
 * @version %1%, %24/03/19%
 * @since 1.0
 */
public class MovieProvider {

    /**
     * This method makes a call to fetch list of movies
     *
     * @see in.poc.transerv.proxy.MovieApiProvider#getMovieList()
     */
    public static void getMovieData(final MainActivity mainActivity) {
        MovieApiProvider service = MovieApi.createService();
        if (null == service) {
            return;
        }
        Call<Movie> call = service.getMovieList();
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if (response.isSuccessful()) {
                    Movie movie = response.body();
                    mainActivity.getMovieSuccess(movie);
                } else {
                    //HTTP Status 4xx and 5xx
                    int status = response.code();
                    mainActivity.getMovieFailure(status);
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                //Network Error or Unexpected Error
                mainActivity.getMovieFailure(0);
            }
        });
    }
}
