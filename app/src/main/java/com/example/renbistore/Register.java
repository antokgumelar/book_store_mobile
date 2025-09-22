package com.example.renbistore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    EditText edtID;
    EditText edtName;
    EditText edtEmail;
    EditText edtPassword;
    EditText edtAddress;
    Button btnRegister;

    String user_id,user_name, user_email, user_password,user_address;

    String url_tambah_akun = "https://renbi.my.id/addUser.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtID = findViewById(R.id.edtID);
        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        edtAddress = findViewById(R.id.edtAddress);
        btnRegister = findViewById(R.id.btnEditAcc);

        btnRegister.setOnClickListener((view) -> {
            Intent i  = new Intent(getApplicationContext(), Login.class);
            startActivity(i);
            user_id = edtID.getText().toString();
            user_name = edtName.getText().toString();
            user_email = edtEmail.getText().toString();
            user_password = edtPassword.getText().toString();
            user_address = edtAddress.getText().toString();

            RequestQueue queue = Volley.newRequestQueue(Register.this);

            StringRequest stringRequest = new StringRequest(Request.Method.POST,
                    url_tambah_akun, new Response.Listener<String>() {

                @Override
                public void onResponse(String response) {
                    // Tampilkan respons sebagai String
                    Log.d("Response", "Server Response: " + response);

                    // Ubah respons string menjadi sesuatu yang sesuai dengan kebutuhan Anda
                    // Misalnya, jika respons adalah "Connected", lakukan sesuatu seperti:
                    if (response.trim().equalsIgnoreCase("Connected")) {
                        Toast.makeText(Register.this, "Data User Disimpan", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {

                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("Error: ", error.getMessage());
                    Toast.makeText(Register.this, "Silahkan cek koneksi internet Anda!", Toast.LENGTH_SHORT).show();
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

// Bersihkan cache dan tambahkan permintaan ke antrian
            queue.getCache().clear();
            queue.add(stringRequest);

        });
    }
}