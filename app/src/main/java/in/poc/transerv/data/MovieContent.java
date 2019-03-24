package in.poc.transerv.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * This class <i>MovieContent</i> is Pojo class to give details of movie
 * <p>
 *
 * @author Tanmeet Singh Bhalla
 * @version %1%, %24/03/19%
 * @since 1.0
 */
public class MovieContent implements Serializable {

    @SerializedName("Title")
    @Expose
    private String title;
    @SerializedName("Year")
    @Expose
    private String year;
    @SerializedName("Rated")
    @Expose
    private String rated;
    @SerializedName("Genre")
    @Expose
    private String genre;
    @SerializedName("Actors")
    @Expose
    private String actors;
    @SerializedName("Plot")
    @Expose
    private String plot;
    @SerializedName("Language")
    @Expose
    private String language;
    @SerializedName("Country")
    @Expose
    private String country;
    @SerializedName("Poster ")
    @Expose
    private String poster;

    @SerializedName("Poster")
    @Expose
    private String posterNew;

    @SerializedName("Released")
    @Expose
    private String released;
    @SerializedName("Runtime")
    @Expose
    private String runtime;
    @SerializedName("Director")
    @Expose
    private String director;
    @SerializedName("Writer")
    @Expose
    private String writer;
    @SerializedName("Awards")
    @Expose
    private String awards;

    @SerializedName("Metascore ")
    @Expose
    private String metascore;
    @SerializedName("imdbRating ")
    @Expose
    private String imdbRating;
    @SerializedName("imdbVotes ")
    @Expose
    private String imdbVotes;
    @SerializedName("imdbID ")
    @Expose
    private String imdbID;
    @SerializedName("Type ")
    @Expose
    private String type;

    @SerializedName("DVD ")
    @Expose
    private String movieDvd;

    @SerializedName("BoxOffice ")
    @Expose
    private String boxOffice;

    @SerializedName("Production ")
    @Expose
    private String production;

    @SerializedName("Website ")
    @Expose
    private String website;

    @SerializedName("Response ")
    @Expose
    private String response;

    @SerializedName("Ratings ")
    @Expose
    private String ratings;

    public String getRatings() {
        return ratings;
    }

    public String getTitle() {
        return title;
    }


    public String getRated() {
        return rated;
    }

    public String getGenre() {
        return genre;
    }

    public String getActors() {
        return actors;
    }

    public String getPlot() {
        return plot;
    }

    public String getLanguage() {
        return language;
    }

    public String getCountry() {
        return country;
    }

    public String getPoster() {
        return poster != null ? poster : posterNew;
    }

    public String getReleased() {
        return released;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getDirector() {
        return director;
    }

    public String getWriter() {
        return writer;
    }

    public String getAwards() {
        return awards;
    }

    public String getMetascore() {
        return metascore;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public String getImdbID() {
        return imdbID;
    }

    public String getType() {
        return type;
    }

    public String getMovieDvd() {
        return movieDvd;
    }

    public String getBoxOffice() {
        return boxOffice;
    }

    public String getProduction() {
        return production;
    }

    public String getWebsite() {
        return website;
    }

    public String getResponse() {
        return response;
    }
}
