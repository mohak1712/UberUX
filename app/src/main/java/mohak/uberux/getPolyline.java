package mohak.uberux;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface getPolyline {
    @GET("json")
    Call<JsonObject> getPolylineData(@Query("origin") String origin, @Query("destination") String destination,
            @Query("key") String key);
}
