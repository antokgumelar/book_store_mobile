package com.example.renbistore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Edit extends AppCompatActivity {

    EditText edtID;
    EditText edtName;
    EditText edtEmail;
    EditText edtPassword;
    EditText edtAddress;
    Button btnEditAcc;
    Button btnDeleteAcc;
    Button btnBack_1;

    private static final String TAG_USER = "user";
    private static final String TAG_ID = "user_id";
    private static final String TAG_NAME = "user_name";
    private static final String TAG_EMAIL = "user_email";
    private static final String TAG_PASSWORD = "user_password";
    private static final String TAG_ADDRESS = "user_address";

    private static final String TAG = Edit.class.getSimpleName();
    String user_id,user_name, user_email, user_password, user_address;
    String url_edit_user = "https://renbi.my.id/updateUser.php";
    String url_hapus_user = "https://renbi.my.id/deleteUser.php";
    String url_get_user = "https://renbi.my.id/getUser.php";

Button Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        edtID = findViewById(R.id.edtID);
        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        edtAddress = findViewById(R.id.edtAddress);

        Back = findViewById(R.id.btnBack_1);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), EditProfile.class);
                startActivity(i);
            }
        });

        btnEditAcc = findViewById(R.id.btnEditAcc);
        btnDeleteAcc = findViewById(R.id.btnDeleteAcc);

        btnEditAcc.setOnClickListener(view -> {
            updateUser();
        });

        btnDeleteAcc.setOnClickListener(view -> {
            deleteUser();
        });
    }


    private void updateUser() {
        user_id = edtID.getText().toString();
        user_name = edtName.getText().toString();
        user_email = edtEmail.getText().toString();
        user_password = edtPassword.getText().toString();
        user_address = edtAddress.getText().toString();

        RequestQueue queue = Volley.newRequestQueue(Edit.this);

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                url_edit_user, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    if (response.startsWith("{")) {
                        // Response is a JSON object
                        JSONObject jObj = new JSONObject(response);
                        int success = jObj.getInt("success");

                        if (success == 1) {
                            Toast.makeText(Edit.this, "Data Mahasiswa Berhasil Diedit", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(Edit.this, "Data Mahasiswa Gagal Diedit, Silahkan Coba Lagi", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        // Response is a plain string
                        // Handle it according to your requirements
                        Log.d("Response", "Plain String Response: " + response);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.e("Error", "JSON parsing error: " + e.getMessage());
                    Toast.makeText(Edit.this, "An error occurred while processing the response", Toast.LENGTH_SHORT).show();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Log.e("Error", "Exception: " + ex.getMessage());
                    Toast.makeText(Edit.this, "An unexpected error occurred", Toast.LENGTH_SHORT).show();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error: ", error.getMessage());
                Toast.makeText(Edit.this, "Silahkan cek koneksi" + " internet Anda!", Toast.LENGTH_SHORT).show();
            }
            }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("user_id", user_id);
                params.put("user_name", user_name);
                params.put("user_email", user_email);
                params.put("user_password", user_password);
                params.put("user_address", user_address);

                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/x-www-form-urlencoded");
                return headers;
            }
        };

        queue.getCache().clear();
        queue.add(stringRequest);
    }

    private void deleteUser() {
        user_id = edtID.getText().toString();
        user_name = edtName.getText().toString();
        user_email = edtEmail.getText().toString();
        user_password = edtPassword.getText().toString();
        user_address = edtAddress.getText().toString();

        RequestQueue queue = Volley.newRequestQueue(Edit.this);

        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                url_hapus_user, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    if (response.startsWith("{")) {
                        // Response is a JSON object
                        JSONObject jObj = new JSONObject(response);
                        int success = jObj.getInt("success");

                        if (success == 1) {
                            Toast.makeText(Edit.this, "Data Mahasiswa Berhasil Diedit", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(Edit.this, "Data Mahasiswa Gagal Diedit, Silahkan Coba Lagi", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        // Response is a plain string
                        // Handle it according to your requirements
                        Log.d("Response", "Plain String Response: " + response);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.e("Error", "JSON parsing error: " + e.getMessage());
                    Toast.makeText(Edit.this, "An error occurred while processing the response", Toast.LENGTH_SHORT).show();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Log.e("Error", "Exception: " + ex.getMessage());
                    Toast.makeText(Edit.this, "An unexpected error occurred", Toast.LENGTH_SHORT).show();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error: ", error.getMessage());
                Toast.makeText(Edit.this, "Silahkan cek koneksi" + " internet Anda!", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("user_id", user_id);
                params.put("user_name", user_name);
                params.put("user_email", user_email);
                params.put("user_password", user_password);
                params.put("user_address", user_address);

                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/x-www-form-urlencoded");
                return headers;
            }
        };

        queue.getCache().clear();
        queue.add(stringRequest);
    }
    }
