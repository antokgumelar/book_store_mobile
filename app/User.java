public class User {
    private String _id;
    private String _name;
    private String _email;
    private String _password;
    private String _address;

    public User(){

    }
    public void setID(String id) {
        this._id = id;
    }

    //Method untuk mendapatkan ID sender
    public String getID(){
        return this._id;
    }

    public void setName(String name) {
        this._name = name;
    }

    //Method untuk mendapatkan ID sender
    public String getName(){return this._name; }

    public void setEmail(String email) { this._email = email;}

    public String getEmail(){ return this._email;}

    public void setPassword(String password){ this._password = password; }

    public String getPassword(){ return  this._password;}

    public void setAddress(String address){ this._address = address;}

    public String getAddress(){ return this._address;}
}

