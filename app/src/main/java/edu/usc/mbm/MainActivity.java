package edu.usc.mbm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import edu.usc.mbm.TestCaseActivities.TestCase1;
import edu.usc.mbm.TestCaseActivities.TestCase10;
import edu.usc.mbm.TestCaseActivities.TestCase11;
import edu.usc.mbm.TestCaseActivities.TestCase12;
import edu.usc.mbm.TestCaseActivities.TestCase13;
import edu.usc.mbm.TestCaseActivities.TestCase14;
import edu.usc.mbm.TestCaseActivities.TestCase15;
import edu.usc.mbm.TestCaseActivities.TestCase16;
import edu.usc.mbm.TestCaseActivities.TestCase17;
import edu.usc.mbm.TestCaseActivities.TestCase18;
import edu.usc.mbm.TestCaseActivities.TestCase19;
import edu.usc.mbm.TestCaseActivities.TestCase2;
import edu.usc.mbm.TestCaseActivities.TestCase20;
import edu.usc.mbm.TestCaseActivities.TestCase21;
import edu.usc.mbm.TestCaseActivities.TestCase22;
import edu.usc.mbm.TestCaseActivities.TestCase23;
import edu.usc.mbm.TestCaseActivities.TestCase24;
import edu.usc.mbm.TestCaseActivities.TestCase25;
import edu.usc.mbm.TestCaseActivities.TestCase3;
import edu.usc.mbm.TestCaseActivities.TestCase4;
import edu.usc.mbm.TestCaseActivities.TestCase5;
import edu.usc.mbm.TestCaseActivities.TestCase6;
import edu.usc.mbm.TestCaseActivities.TestCase7;
import edu.usc.mbm.TestCaseActivities.TestCase8;
import edu.usc.mbm.TestCaseActivities.TestCase9;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //<editor-fold desc="Defining the attributes">
    Class chose;
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    //</editor-fold>


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //<editor-fold desc="Setting up the attributes">

        spinner = (Spinner) findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.testcases_array, android.R.layout.simple_spinner_item);


        //</editor-fold>
        spinner.setOnItemSelectedListener(this);


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        //String item = parent.getItemAtPosition(position).toString();

        if (position > 0) {
            switch (position) {

                case 1:
                    chose = TestCase1.class;
                    break;
                case 2:
                    chose = TestCase2.class;
                    break;
                case 3:
                    chose = TestCase3.class;
                    break;
                case 4:
                    chose = TestCase4.class;
                    break;
                case 5:
                    chose = TestCase5.class;
                    break;
                case 6:
                    chose = TestCase6.class;
                    break;
                case 7:
                    chose = TestCase7.class;
                    break;
                case 8:
                    chose = TestCase8.class;
                    break;
                case 9:
                    chose = TestCase9.class;
                    break;
                case 10:
                    chose = TestCase10.class;
                    break;
                case 11:
                    chose = TestCase11.class;
                    break;
                case 12:
                    chose = TestCase12.class;
                    break;
                case 13:
                    chose = TestCase13.class;
                    break;
                case 14:
                    chose = TestCase14.class;
                    break;
                case 15:
                    chose = TestCase15.class;
                    break;
                case 16:
                    chose = TestCase16.class;
                    break;
                case 17:
                    chose = TestCase17.class;
                    break;
                case 18:
                    chose = TestCase18.class;
                    break;
                case 19:
                    chose = TestCase19.class;
                    break;
                case 20:
                    chose = TestCase20.class;
                    break;
                case 21:
                    chose = TestCase21.class;
                    break;
                case 22:
                    chose = TestCase22.class;
                    break;
                case 23:
                    chose = TestCase23.class;
                    break;
                case 24:
                    chose = TestCase24.class;
                    break;
                case 25:
                    chose = TestCase25.class;
                    break;

                default:

            }

            startActivity(new Intent(MainActivity.this, chose));
            finish();

        }

    }
    public void onNothingSelected(AdapterView<?> arg0) {
    }
}
