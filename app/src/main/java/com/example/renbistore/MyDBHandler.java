package com.example.renbistore;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDBHandler extends SQLiteOpenHelper {

    //Deklarasi variabel konstanta untuk pembuatan database, tabel dan kolom yang diperlukan
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "datasender.db";
    private static final String TABLE_NAME = "sender";

    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAMASENDER = "namasender";
    private static final String COLUMN_TELPSENDER = "telpsender";
    private static final String COLUMN_ALAMATSENDER = "alamatsender";

    private static final String COLUMN_BUKUSENDER = "bukusender";

    //constructor untuk class MyDBHandler
    public MyDBHandler (Context context) {

        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    //method untuk Create Database
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE_SENDER = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAMASENDER + " VARCHAR (50) NOT NULL, " +
                COLUMN_TELPSENDER + " VARCHAR(50) NOT NULL, " +
                COLUMN_ALAMATSENDER + " VARCHAR(50) NOT NULL," +
                COLUMN_BUKUSENDER + " VARCHAR(50) NOT NULL)";

        sqLiteDatabase.execSQL(CREATE_TABLE_SENDER);
    }

    //method yang dipakai untuk upgrade tabel
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    /*-----Insert, Select, Update, Delete --------*/

    private SQLiteDatabase database;

    //method untuk open database connection
    public void open() throws SQLException {
        database = this.getWritableDatabase();
    }

    //inisialisasi semua kolom di tabel database
    private String[] allColumns =
            {COLUMN_ID, COLUMN_NAMASENDER,COLUMN_TELPSENDER,COLUMN_ALAMATSENDER,COLUMN_BUKUSENDER};

    //method untuk memidahkan isi cursor ke objek sender
    private Sender cursorToSender(Cursor cursor) {
        Sender sender = new Sender();

        sender.setID(cursor.getLong(0));
        sender.setNamaSender(cursor.getString(1));
        sender.setTelpSender(cursor.getString(2));
        sender.setAlamatSender(cursor.getString(3));
        sender.setBukuSender(cursor.getString(4));

        return sender;
    }

    //method untuk menambahkan barang baru
    public void createSender(String nama, String telp, String alamat, String buku) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAMASENDER, nama);
        values.put(COLUMN_TELPSENDER, telp);
        values.put(COLUMN_ALAMATSENDER, alamat);
        values.put(COLUMN_BUKUSENDER, buku);

        database.insert(TABLE_NAME, null, values);
    }

    //method untuk mendapatkan detail per barang
    public Sender getSender (long id){
        Sender sender = new Sender();

        Cursor cursor = database.query(TABLE_NAME,allColumns,"_id=",null,null,null,null);
        cursor.moveToFirst();
        sender = cursorToSender(cursor);
        cursor.close();

        return sender;
    }

    //method untuk mendapatkan data semua barang di tabel barang
    public ArrayList<Sender> getAllSender(){
        ArrayList<Sender> daftarSender = new ArrayList<Sender>();

        Cursor cursor = database.query(TABLE_NAME,allColumns,null,null,null,null,null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            Sender sender = cursorToSender(cursor);
            daftarSender.add(sender);
            cursor.moveToNext();
        }

        cursor.close();
        return daftarSender;
    }

    //method untuk mengupdate data barang
    public void updateSender(Sender sender){
        String filter = "_id="+sender.getID();
        ContentValues args = new ContentValues();
        args.put(COLUMN_NAMASENDER, sender.getNamaSender());
        args.put(COLUMN_TELPSENDER, sender.getTelpSender());
        args.put(COLUMN_ALAMATSENDER, sender.getAlamatSender());
        args.put(COLUMN_BUKUSENDER, sender.getBukuSender());

        database.update(TABLE_NAME, args, filter, null);
    }

    //method untuk menghapus data barang
    public void deleteSender(long id){
        String filter = "_id="+id;

        database.delete(TABLE_NAME, filter, null);
    }


}
