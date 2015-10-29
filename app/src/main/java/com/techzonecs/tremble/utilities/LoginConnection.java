package com.techzonecs.tremble.utilities;

import android.net.http.HttpResponseCache;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.techzonecs.tremble.controller.LoginPageActivity;

import com.techzonecs.tremble.model.Session;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpCookie;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Bouyabes on 10/28/2015.
 */
public class LoginConnection {

    String TAG = "TREMBLE";
    public LoginPageActivity lpa = null;
    boolean isLoggedIn = false;
    boolean logIn(final String sisid, final String password){

        String url = ConnectionURLString.url+"Login";
        String tag_json_obj = "json_obj_req";

//        Log.d("testing","before the before");
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
//                        Log.d("testing","before");
                        try{
                            JSONObject json = new JSONObject(response.getString("result_data"));
                            Log.d("testing_json", json.toString());

                            isLoggedIn = Boolean.parseBoolean(json.getString("flag"));


                            } catch (Exception e){

                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());

            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
        return isLoggedIn;

    }


//    public void logIn(final String sisid, final String password){
//        // Tag used to cancel the request
//        String tag_json_obj = "json_obj_req";
//
//        String url = ConnectionURLString.url+"Login?id_trainee="+sisid+"&password="+password;
//        Log.d(TAG, url);
//
//        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
//                url, null,
//                new Response.Listener<JSONObject>() {
//
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        Log.d(TAG, response.toString());
//                        responseHandling(response);
//
//                    }
//                }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.d(TAG, "Error: " + error.getMessage());
//
//            }
//        }) {
//
//            @Override
//            protected Map<String, String> getParams() {
//                Map<String, String> params = new HashMap<String, String>();
////                params.put("id_trainee", sisid);
////
////                params.put("password", password);
//
//                return params;
//            }
//
//        };
//
//// Adding request to request queue
//        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
//    }
//
//    void responseHandling(JSONObject response){
//        try {
//            JSONObject jsnobject = response;
//            JSONArray jsonArray = jsnobject.getJSONArray("result_data");
//
//            for (int i = 0; i < jsonArray.length(); i++) {
//                JSONObject tempObject = jsonArray.getJSONObject(i);
//                String logInFlag = tempObject.getString("flag");
//
//                Log.d("test:",logInFlag.toString());
//
//                boolean flag = Boolean.parseBoolean(logInFlag);
//                if (flag){
//                    Toast.makeText(lpa, "ture!", Toast.LENGTH_SHORT).show();
//                }else {
//                    Toast.makeText(lpa, "FALSE!", Toast.LENGTH_SHORT).show();
//                }
//            }
//        }catch (JSONException e){
//
//        }
//    }


}
