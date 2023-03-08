package org.headroyce.lucast2021.reutlingervolunteeringapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;
import android.widget.TextView;
import android.view.View;

public class ActivityMain extends AppCompatActivity {


    private LinearLayout layout;
    private String nameofuser;
    private int thisDay;

    private Applogic logic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent myIntent = getIntent(); //going to later launch board

        nameofuser = myIntent.getStringExtra("username"); //getting values from a different class

        logic = new Applogic(); //used to get inputted values from hashmap



        layout = findViewById(R.id.mainlayout);

        Date fun = new Date();


        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fun);

         thisDay = calendar.get(Calendar.DAY_OF_MONTH);

        int daysleft = YearMonth.now().lengthOfMonth() - thisDay;






        String Month = "nomonth";

        if (calendar.get(Calendar.MONTH) == 0){
            Month = "January";
        }
        if (calendar.get(Calendar.MONTH) == 1){
            Month = "February";
        }
        if (calendar.get(Calendar.MONTH) == 2){
            Month = "March";
        }
        if (calendar.get(Calendar.MONTH) == 3){
            Month = "April";
        }
        if (calendar.get(Calendar.MONTH) == 4){
            Month = "May";
        }
        if (calendar.get(Calendar.MONTH) == 5){
            Month = "June";
        }
        if (calendar.get(Calendar.MONTH) == 6){
            Month = "July";
        }
        if (calendar.get(Calendar.MONTH) == 7){
            Month = "August";
        }
        if (calendar.get(Calendar.MONTH) == 8){
            Month = "September";
        }
        if (calendar.get(Calendar.MONTH) == 9){
            Month = "October";
        }
        if (calendar.get(Calendar.MONTH) == 10){
            Month = "November";
        }
        if (calendar.get(Calendar.MONTH) == 11){
            Month = "December";
        }


        for (int i = 0; i <= daysleft; i++) {

            Button b = new Button(this.getBaseContext());
            layout.addView(b);

            b.setText("Day" + " " + (thisDay + i) + "                           " + logic.numAssignees(thisDay + i) + " / " + "3  Assignees"); //display current days of month on buttons


            b.setTag(R.string.day, i + "");

            final int x = thisDay + i; // this way I can access day in onclick listener



            b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                   Button clicked = (Button) v;


                   int day = Integer.parseInt((String)clicked.getTag(R.string.day));

                    if (logic.numAssignees(day) > 1) {
                        v.setEnabled(false);
                        clicked.setText("this day is full");
                    }
                        logic.printday(day);

                    if (logic.numAssignees(day) <= 1) {
                        logic.addassignee(nameofuser, day);
                        clicked.setText("Day" + " " + (x) + "                           " + logic.numAssignees(day) + " / " + "3  Assignees");

                    }
                }
            });



        }

        TextView t = (TextView) findViewById(R.id.username);
        t.setText("Logged in as:" + " " + nameofuser);

        TextView w = (TextView) findViewById(R.id.monthname);
        w.setText("" + Month);




    }
}
