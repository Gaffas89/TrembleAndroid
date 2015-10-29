package com.techzonecs.tremble.utilities;

import android.app.ProgressDialog;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.techzonecs.tremble.model.Session;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Gaffas on 28/10/2015.
 */
public class SessionConnection {


    private String TAG;
    private static ArrayList<Session> sessionArrayList;

    public ArrayList<Session> getSessionArray1(){

        String url ="http://192.168.1.188:8080/TrembleBackend/GetSessions?id_trainee=1" ; // add the trainee id sent in parameters at the end

        String tag_json_obj = "json_obj_req";

        Log.d("testing","before the before");
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("testing","before");
                        try{
                            JSONArray jsonArray = new JSONArray(response.getString("result_data"));
                            Log.d("testing_array", jsonArray.toString());
                            for(int i = 0; i < jsonArray.length() ; i++)
                            {
                                JSONObject json = jsonArray.getJSONObject(i);
                                Session sess = new Session();
                                sess.setClassName(json.getString("class_name"));
                                sess.setCourseName(json.getString("course_name"));
                                sess.setDate(json.getString("wave_date"));
                                sess.setLocation(json.getString("location_name"));
                                sess.setLocationGps(json.getString("location_gps"));
                                sess.setTrainerName(json.getString("trainer_name"));
                                sess.setZone(json.getString("zone"));

                                sessionArrayList.add(sess);
                            }
                        }catch (Exception e){

                        }
                        Log.d("testing","after");
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());

            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
        return sessionArrayList;
    }

    public ArrayList<Session> getSessionArray(){
        String  tag_string_req = "string_req";

        String url = "http://192.168.1.188:8080/TrembleBackend/GetSessions?id_trainee=1";

        StringRequest strReq = new StringRequest(Request.Method.GET,
                url, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.d("test", "test");
                try{
                    JSONObject jsonResponse = new JSONObject(response);
                    JSONArray jsonArray = new JSONArray(jsonResponse.getString("result_data"));
                    Log.d("testing_array", jsonArray.toString());
                    for(int i = 0; i < jsonArray.length() ; i++)
                    {
                        JSONObject json = jsonArray.getJSONObject(i);
                        Session sess = new Session();
                        sess.setClassName(json.getString("class_name"));
                        sess.setCourseName(json.getString("course_name"));
                        sess.setDate(json.getString("wave_date"));
                        sess.setLocation(json.getString("location_name"));
                        sess.setLocationGps(json.getString("location_gps"));
                        sess.setTrainerName(json.getString("trainer_name"));
                        sess.setZone(json.getString("zone"));

                        sessionArrayList.add(sess);
                    }
                }catch (Exception e){

                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
              //  VolleyLog.d(TAG, "Error: " + error.getMessage());
                Log.d("error", "error");
            }
        });

// Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
        ArrayList<Session> array= new ArrayList<Session>();
        return array;
    }
}


