package in.poc.transerv.proxy;

import in.poc.transerv.utility.Constants;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * This class <i>MovieApi</i> is api class to get service using retrofit
 * <p>
 *
 * @author Tanmeet Singh Bhalla
 * @version %1%, %24/03/19%
 * @since 1.0
 */
public class MovieApi {

    /**
     * This function will return the service class for MovieApi
     */
    private static <S> S createService(Class<S> serviceClass) {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        OkHttpClient okHttpClient = httpClientBuilder.build();
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl(Constants.API_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = retrofitBuilder.client(okHttpClient).build();
        return retrofit.create(serviceClass);
    }

    public static MovieApiProvider createService() {
        return createService(MovieApiProvider.class);
    }
}
