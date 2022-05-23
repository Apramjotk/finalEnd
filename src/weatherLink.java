import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;


public class weatherLink
{

   private String APIkey;
   private String basicUrl;

   public weatherLink()
   {
       APIkey= "aa8b02a6f79143a6a21181234222205";
       basicUrl= "http://api.weatherapi.com/v1/current.json?key=";

   }

   public ArrayList<weather> forecast()
   {

       String urlink= "http://api.weatherapi.com/v1/forecast.json?key=aa8b02a6f79143a6a21181234222205&q=California&days=5&aqi=yes&alerts=no";
       String response = makeAPICall(urlink);
       ArrayList<weather> forecast=  parseNowPlayingJSON(response);
       return forecast;

   }
    private String makeAPICall(String url)
    {
        try {
            URI myUri = URI.create(url); // creates a URI object from the url string
            HttpRequest request = HttpRequest.newBuilder().uri(myUri).build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    private ArrayList<weather> parseNowPlayingJSON(String json)
    {
        ArrayList<weather> movies = new ArrayList<weather>();

        JSONObject jsonObj = new JSONObject(json);
        JSONArray movieList = jsonObj.getJSONArray("results");

        for (int i = 0; i < movieList.length(); i++)
        {
            JSONObject movieObj = movieList.getJSONObject(i);
            String movieTitle = movieObj.getString("title");
            int movieID = movieObj.getInt("id");
            weather movie = new weather(movieTitle, movieID);
            movies.add(movie);
        }
        return movies;
    }


}
