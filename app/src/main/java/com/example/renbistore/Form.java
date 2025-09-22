package com.example.renbistore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;

public class Form extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinBuku;
    private String [] listBook = {"Choose your Book", "Mantappu Jiwa","Quarter Life","You Do You","Filosofi Teras"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        final EditText edtNamaSender = (EditText)findViewById(R.id.edtNamaSender);
        final EditText edtTelpSender = (EditText)findViewById(R.id.edtTelpSender);
        final EditText edtAlamatSender = (EditText)findViewById(R.id.edtAlamatSender);
        spinBuku = findViewById(R.id.spinBuku);


        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listBook);
        spinBuku.setOnItemSelectedListener(this);
        spinBuku.setAdapter(adapter);

        //buat objek untuk class MyDBHandler
        final MyDBHandler dbHandler = new MyDBHandler(this);

        //membuka koneksi database
        try{
            dbHandler.open();
        } catch (SQLException e){
            e.printStackTrace();
        }

        Button btnComplete = (Button)findViewById(R.id.btnComplete);
        btnComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sender sender = new Sender();
                String namaSender = edtNamaSender.getText().toString();
                String telpSender = edtTelpSender.getText().toString();
                String alamatSender = edtAlamatSender.getText().toString();
                String spinBukuValue = spinBuku.getSelectedItem().toString();
                dbHandler.createSender(namaSender, telpSender, alamatSender, spinBukuValue);

                Toast.makeText(Form.this, "Silahkan melanjutkan pembayaran", Toast.LENGTH_LONG).show();
                edtNamaSender.setText("");
                edtAlamatSender.setText("");
                edtTelpSender.setText("");
                spinBuku.requestFocus();

                Intent i = new Intent(Form.this, Payment.class);
                startActivity(i);
                Form.this.finish();
                dbHandler.close();
            }
        });


    }

@Override
public void onItemSelected(AdapterView<?> parent, View view, int position, long id){

}
@Override
public void onNothingSelected(AdapterView<?> parent){

}
}