package com.example.renbistore;

import static com.android.volley.VolleyLog.TAG;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<String> {

    private Context context;
    private ArrayList<String> dataList;

    public CustomAdapter(Context context, ArrayList<String> dataList) {
        super(context, R.layout.list_item, dataList);
        this.context = context;
        this.dataList = dataList;
    }

    // Metode addAll yang disesuaikan
    public void addAll(ArrayList<String> users) {
        dataList.addAll(users);
        notifyDataSetChanged();
    }

    public static class ViewHolder {
        TextView txtId;
        TextView txtName;
        TextView txtEmail;
        TextView txtPassword;
        TextView txtAddress;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.list_item, parent, false);
        }

        TextView txtID = convertView.findViewById(R.id.txtID);
        TextView txtName = convertView.findViewById(R.id.txtName);
        TextView txtEmail = convertView.findViewById(R.id.txtEmail);
        TextView txtPassword = convertView.findViewById(R.id.txtPassword);
        TextView txtAddress = convertView.findViewById(R.id.txtAddress);


        String userData = dataList.get(position);
        txtID.setText(userData);
        txtName.setText(userData);
        txtEmail.setText(userData);
        txtPassword.setText(userData);
        txtAddress.setText(userData);

        return convertView;
    }

}
