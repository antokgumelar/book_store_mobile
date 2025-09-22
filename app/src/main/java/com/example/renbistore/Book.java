package com.example.renbistore;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Book extends ListActivity implements AdapterView.OnItemLongClickListener {
    private MyDBHandler dbHandler;
    private ArrayList<Sender> values;

    private Button btnDelete;
    private ListView list;

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        Button btnHome = (Button) findViewById(R.id.btnHome);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Home.class);
                startActivity(i);
            }
        });

        Button btnStore = (Button) findViewById(R.id.btnStore);
        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Store.class);
                startActivity(i);
            }
        });

        Button btnProfil = (Button) findViewById(R.id.btnProfil);
        btnProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Profile.class);
                startActivity(i);
            }
        });

        //Buat objek untuk Class MyDBHandler
        dbHandler = new MyDBHandler(this);

        //Membuka koneksi database
        try {
            dbHandler.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        values = dbHandler.getAllSender();

        ArrayAdapter<Sender> adapter = new ArrayAdapter<Sender>(this,
                android.R.layout.simple_list_item_1, values);

        setListAdapter(adapter);

        list = (ListView) findViewById(android.R.id.list);
        list.setOnItemLongClickListener(this);
    }

        //method yang digunakan jika ListView ditekan agak lama
        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
            final Dialog dialog = new Dialog(this);
            dialog.setContentView(R.layout.dialog);
            dialog.setTitle("Pilih Aksi");
            dialog.show();

            final Sender sender = (Sender) getListAdapter().getItem(i);
            final long id = sender.getID();

            btnDelete = dialog.findViewById(R.id.btnDelete);
            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AlertDialog.Builder konfirm = new AlertDialog.Builder(context);
                    konfirm.setTitle("Delete Book");
                    konfirm.setMessage("Sure to delete the book?");
                    konfirm.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // Delete the item from the database
                            dbHandler.deleteSender(id);

                            // Remove the item from the adapter
                            ArrayAdapter<Sender> adapter = (ArrayAdapter<Sender>) getListAdapter();
                            adapter.remove(sender);
                            adapter.notifyDataSetChanged();

                            Toast.makeText(Book.this, "Book successfully deleted", Toast.LENGTH_LONG).show();
                        }
                    });
                    konfirm.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // Do nothing or handle accordingly
                            Toast.makeText(Book.this, "Book unsuccessfully deleted", Toast.LENGTH_LONG).show();
                        }
                    });
                    konfirm.show();
                    dialog.dismiss();
                }
            });

            return true;
        }

}

