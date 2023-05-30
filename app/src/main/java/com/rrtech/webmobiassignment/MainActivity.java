package com.rrtech.webmobiassignment;


import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.rrtech.webmobiassignment.API.APIInterface;
import com.rrtech.webmobiassignment.Database.WeatherDb;
import com.rrtech.webmobiassignment.Database.WeatherDataDb;
import com.rrtech.webmobiassignment.Models.WeatherData;
import com.rrtech.webmobiassignment.Models.condition;
import com.rrtech.webmobiassignment.Models.current;
import com.rrtech.webmobiassignment.Models.location;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText userCity;
    ImageButton searchButton;
    ImageView weatherIcon;

    TextView cityTemperature, cityName, clouds;
    ProgressDialog progressDialog;

    LinearLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        layout = findViewById(R.id.layout_weather);
        userCity = findViewById(R.id.user_city);
        searchButton = findViewById(R.id.search_btn);
        cityTemperature = findViewById(R.id.cityTemperature);
        cityName = findViewById(R.id.cityName);
        weatherIcon = findViewById(R.id.weather_icon);
        clouds = findViewById(R.id.clouds);
        progressDialog = new ProgressDialog(MainActivity.this);


        WeatherDb weatherDB = new WeatherDb(this);


        if (weatherDB.isDatabaseEmpty()) {

            layout.setVisibility(View.INVISIBLE);

            Toast.makeText(this, "Empty Database", Toast.LENGTH_SHORT).show();

        } else {
            String[] data = weatherDB.getData();

            String DBcityName = data[1];
            String DBtemperature = data[2];
            String DBcloudPercent = data[3];
            String DBtemperatureIcon = data[4];

            cityName.setText(DBcityName);
            cityTemperature.setText(DBtemperature);
            clouds.setText(DBcloudPercent + " %");

            Picasso.get().load(Uri.parse(DBtemperatureIcon)).fit().centerCrop().into(weatherIcon);


        }


        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (TextUtils.isEmpty(userCity.getText().toString())) {
                    userCity.setError("Enter City");
                    return;
                }

                progressDialog.setMessage("Loading....");
                progressDialog.setTitle("Getting Data");
                progressDialog.show();


                FetchData(userCity.getText().toString());


            }
        });


    }


    private void FetchData(String City) {




        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.weatherapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIInterface apiInterface = retrofit.create(APIInterface.class);

        Call<WeatherData> call = apiInterface.getData("379cc97c919b49d79ee182817232805", City, "no");

        call.enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {

                progressDialog.dismiss();





                if (response.isSuccessful()) {

                    WeatherDb weatherDB = new WeatherDb(MainActivity.this);

                    WeatherData weatherData = response.body();
                    current current = weatherData.getCurrent();
                    location location = weatherData.getLocation();
                    condition condition = weatherData.current.getCondition();



                    cityTemperature.setText(String.valueOf(current.getTemp_c()) + " \u2103");
                    String temp = String.valueOf(current.getTemp_c()) + "\u2103";
                    cityName.setText(location.getName());
                    clouds.setText(String.valueOf(current.getCloud()) + " %");
                    String image = "https:" + condition.getIcon();

                    Picasso.get().load(Uri.parse(image)).fit().centerCrop().into(weatherIcon);

                    layout.setVisibility( View.VISIBLE);

                    if (weatherDB.isDatabaseEmpty()) {

                        weatherDB.addCityDetails(location.getName(), temp, String.valueOf(current.getCloud()), image);

                    } else {
                        WeatherDataDb weatherDetails = new WeatherDataDb();
                        weatherDetails.id = 1;
                        weatherDetails.city_Name = location.getName();
                        weatherDetails.temperature = temp;
                        weatherDetails.cloud_percent = String.valueOf(current.getCloud());
                        weatherDetails.temperatureIcon = image;

                        weatherDB.updateCityDetails(weatherDetails);
                    }


                }

            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }


}