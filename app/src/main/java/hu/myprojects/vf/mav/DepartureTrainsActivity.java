package hu.myprojects.vf.mav;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import hu.myprojects.vf.mav.databinding.ActivityDepartureTrainsBinding;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;


public class DepartureTrainsActivity extends AppCompatActivity {
    private final String baseUrl = "https://apiv2.oroszi.net/elvira?";
    private ActivityDepartureTrainsBinding binding;
    private OkHttpClient client;
    private String Url;
    private Train trains;
    private String startCity;
    private String destinationCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDepartureTrainsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.rvDepeartureTrains.setLayoutManager(new LinearLayoutManager(this));

        client = new OkHttpClient();
        startCity = getIntent().getStringExtra(getString(R.string.from));
        destinationCity = getIntent().getStringExtra(getString(R.string.to));

        Map<String, String> parameters = new HashMap<String, String>() {{
            put(getString(R.string.from), startCity);
            put(getString(R.string.to), destinationCity);
        }};

        Url = buildUrl(parameters);
        getDepartureTrains();
    }

    private String buildUrl(Map<String, String> parameters) {
        String fkey = parameters.entrySet().stream().findFirst().get().getKey();
        String fvalue = parameters.entrySet().stream().findFirst().get().getValue();
        Url = fkey + "=" + fvalue;

        StringBuilder sb = new StringBuilder(Url);
        parameters.entrySet().stream().skip(1).forEach(e -> {
            sb.append("&" + e.getKey() + "=" + e.getValue());
        });

        return baseUrl + sb;
    }

    private void getDepartureTrains() {
        Request request = new Request.Builder().url(this.Url).build();

        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (response.isSuccessful()) {
                        String responseStr = responseBody.string();
                        Gson gson = new Gson();
                        trains = gson.fromJson(responseStr, Train.class);
                        runOnUiThread(() -> {
                            binding.rvDepeartureTrains.setAdapter(new RecyclerViewAdapter(trains));
                            binding.tvRoute.setText(trains.getRoute());
                            binding.tvDate.setText(trains.getDate());
                        });
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }
        });
    }

    public void openMap(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra(getString(R.string.to), destinationCity);
        intent.putExtra(getString(R.string.from), startCity);
        startActivity(intent);
    }
}