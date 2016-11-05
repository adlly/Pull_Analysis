package lly.ad.pull_analysis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Xml;
import android.view.View;
//import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Weather> weatherList;
    Weather weather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        InputStream inputStream = null;

//            inputStream = getAssets().open("weather.xml");
             inputStream = getResources().openRawResource(R.raw.weather);

//        InputStream  inputStream =  getClassLoader().getResourceAsStream("asserts/weather.xml");
        XmlPullParser xmlPullParser = Xml.newPullParser();


        try {
            xmlPullParser.setInput(inputStream, "utf-8");
            int type = xmlPullParser.getEventType();

            while (type != XmlPullParser.END_DOCUMENT) {
//                String.valueOf()  Integer.toString(type)

                Log.e(MainActivity.class.getSimpleName(), Integer.toString(type));
                switch (type) {
                    case XmlPullParser.START_TAG:
                        if ("weather".equals(xmlPullParser.getName())) {
                            weatherList = new ArrayList<>();
                            /** 如果遇到weather */

                        } else if ("city".equals(xmlPullParser.getName())) {
                            weather = new Weather();
                        } else if ("name".equals(xmlPullParser.getName())) {
                            String name = xmlPullParser.nextText();
                            weather.setName(name);
                        } else if ("temp".equals(xmlPullParser.getName())) {
                            String temp = xmlPullParser.nextText();
                            weather.setTemp(temp);
                        } else if ("pm".equals(xmlPullParser.getName())) {
                            String pm = xmlPullParser.nextText();
                            weather.setPm(pm);
                        }

                        break;


                    case XmlPullParser.END_TAG:
                        if ("city".equals(xmlPullParser.getName())) {
                            weatherList.add(weather);
                        }

                        break;
                }
                type = xmlPullParser.next();
            }
//            Toast.makeText(this, "!!!", Toast.LENGTH_LONG).show();
            for (Weather wea : weatherList) {
                System.out.println(wea.toString());
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
