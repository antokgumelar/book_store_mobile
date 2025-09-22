package com.example.renbistore;

public class Sender {

    private long _id;
    private String _namasender;
    private String _telpsender;
    private String _alamatsender;
    private String _bukusender;

    //Constructor untuk class barang
    public Sender() {

    }
    //Method untuk set ID Sender
    public void setID(long id) {
        this._id = id;
    }

    //Method untuk mendapatkan ID sender
    public long getID(){
        return this._id;
    }

    //Method untuk set Nama Barang
    public void setNamaSender(String namaSender){
        this._namasender = namaSender;
    }

    //Method untk mendapatkan Nama Sender
    public String getNamaSender(){
        return this._namasender;
    }

    //Method untuk set Telp Sender
    public void setTelpSender(String telpSender){ this._telpsender = telpSender; }

    //Method untuk mendapatkan Telp Sender
    public String getTelpSender(){
        return this._telpsender;
    }

    //Method untuk set Alamat Sender
    public void setAlamatSender(String alamatSender){
        this._alamatsender = alamatSender;
    }

    //Method untuk mendapatkan Alamat Sender
    public String getAlamatSender(){
        return this._alamatsender;
    }

    //Method untuk set Buku Sender
    public void setBukuSender(String bukuSender){
        this._bukusender = bukuSender;
    }

    //Method untuk mendapatkan Buku Sender
    public String getBukuSender(){
        return this._bukusender;
    }

    //method override yang dipakai untuk mengubah objek Barang menjadi ing
    @Override
    public String toString(){
        return "Name Sender\t\t\t\t: " + _namasender + "\nTelp Sender\t\t\t\t\t: "
                + _telpsender + "\nAddress Sender\t: " + _alamatsender + "\nBook\t\t\t\t\t\t\t\t\t\t\t\t: " + _bukusender;
    }

}
