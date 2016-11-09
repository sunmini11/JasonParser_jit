package com.egco428.jsonparser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private String url1 = "http://api.openweathermap.org/data/2.5/weather?q=";
    private String url2 = "&appid=a21221acd1aef50e41c78a401bba2413";
    private EditText location,country,temperature,humidity,pressure;
    private JsonParser obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        location = (EditText)findViewById(R.id.editTextLocation);
        country = (EditText)findViewById(R.id.editTextCountry);
        temperature = (EditText)findViewById(R.id.editTextTemp);
        humidity = (EditText)findViewById(R.id.editTextHumidity);
        pressure = (EditText)findViewById(R.id.editTextPressure);

    }

    public void openWeathereMethod(View view){
        String url = location.getText().toString();
        String finalUrl = url1 + url + url2;

        obj = new JsonParser(finalUrl);
        obj.fetchJSON();
        while (obj.parsingComplete);
        country.setText(obj.getCountry());
        Float celsius = Float.parseFloat(obj.getTemperature()) - 273;
        DecimalFormat format = new DecimalFormat("0.00");
        temperature.setText(format.format(celsius)+" Celsius");
        humidity.setText(obj.getHumidity());
        pressure.setText(obj.getPressure());

    }

}
