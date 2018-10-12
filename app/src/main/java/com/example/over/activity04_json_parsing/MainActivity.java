package com.example.over.activity04_json_parsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvData = findViewById(R.id.tvData);
        String strJson="{\"Employee\":[{\"id\":\"01\",\"name\":\"Laila Ali\",\"salary\":30000},{\"id\":\"02\",\"name\":\"Sara Said\",\"salary\":40000}]}";
        String data = "";
        try {
            // Get the root object
            JSONObject jRootObject = new JSONObject(strJson);

            // Get the JSONArray (Employee) that contains JSONObjects
            JSONArray jArray = jRootObject.getJSONArray("Employee");

            for (int i = 0; i < jArray.length(); i++) {
                // Get the JSONObject from the array at position i
                JSONObject jObject = jArray.getJSONObject(i);

                // get the id from the jsonObject
                String strId = jObject.getString("id");
                int id = Integer.parseInt(strId);

                // get the name from the jsonObject
                String name = jObject.getString("name");

                // get the salary from the jsonObject
                // String strSalary = jsonObject.getString("salary").toString();
                // Double salary = Double.parseDouble(strSalary);

                Double salary = jObject.getDouble("salary");
                data += "Node" + i + " : \n id= " + id + " \n Name= " + name + " \n Salary= " + salary + " \n ";
                tvData.setText(data);// display data in the the textview
            }//end for
        } //end try
        catch (JSONException e) {
            e.printStackTrace();
        }//end catch
    }
}
