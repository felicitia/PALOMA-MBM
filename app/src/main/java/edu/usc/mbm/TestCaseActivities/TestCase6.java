package edu.usc.mbm.TestCaseActivities;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import edu.usc.mbm.R;
import edu.usc.mbm.ResultActivity;

public class TestCase6 extends AppCompatActivity {

    //<editor-fold desc="Defining the attributes">
    EditText field3;
    EditText field4;
    Button buttonLockIn1;
    Button buttonSearchId4;

    String id;
    String idURL;
    String urlJson;
    Intent intent;
    Search search;
    URL url;
    //</editor-fold>


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_case6);

        //<editor-fold desc="Setting up the attributes">
        intent = new Intent(this, ResultActivity.class);

        idURL = "https://radiant-gorge-51458.herokuapp.com/restaurants/";


        field3 = (EditText) findViewById(R.id.id_fieldID);
        field4 = (EditText) findViewById(R.id.id_fieldID2);
        buttonSearchId4 = (Button) findViewById(R.id.id_button_search);

        //</editor-fold>

        buttonSearchId4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Random rand = new Random();
                int choice = rand.nextInt(2);

                if(choice == 0)
                {
                    id = field3.getText().toString();
                    if(id.equals(""))
                        id = field4.getText().toString();
                }


                if(choice == 1)
                {
                    id = field4.getText().toString();
                    if(id.equals(""))
                        id = field3.getText().toString();
                }

                urlJson = idURL + id;

                try {
                    url = new URL(urlJson);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                search = new Search();
                search.execute(url);
            }
        });
    }

    //<editor-fold desc="Method to send the request">
    private class Search extends AsyncTask<URL, Void, Map<String, String>> {
        @Override
        protected Map<String, String> doInBackground(URL... urlPar){
            Map<String, String> result = new HashMap<String, String>();
            URL url = urlPar[0];
            if(url != null){
                Log.e("url", url.toString());
                try {
                    URLConnection urlConnection = url.openConnection();
                    InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder outString = new StringBuilder();
                    String line;
                    while((line = bufferedReader.readLine()) != null){
                        outString.append(line);
                    }
                    inputStream.close();

                    result.put("json", outString.toString().trim());
                    Log.e("json", result.get("json"));



                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            return result;
        }

        @Override
        protected void onPostExecute(Map<String, String> result){
            try {
                if(result.containsKey("json")){
                    //insere o JSON na INTENT
                    intent.putExtra("json", result.get("json"));
                }

                //inicia uma nova intent e fecha a atual
                startActivity(intent);
                finish();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    //</editor-fold>
}
