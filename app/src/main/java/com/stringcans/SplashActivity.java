package com.stringcans;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if (TextUtils.isEmpty(SharedPrefsManager.getToken(this))){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    openLoginScreen();
                }
            },2000);
        }else{
            try {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("token", SharedPrefsManager.getToken(this));
                sessionAPI(jsonObject);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    private void openLoginScreen(){
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    private void openDashboardScreen(){
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }


    private void sessionAPI(JSONObject jsonObject) {

        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, Constants.BASE_URL + Constants.MOBILE_SESSION,
                jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    if (response.getBoolean(Constants.API_RESPONSE_SUCCESS)) {
                        openDashboardScreen();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                openLoginScreen();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("user-agent", "ul");

                return params;
            }
        };

        queue.add(jsonObjectRequest);
    }
}