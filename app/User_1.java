
public class User_1 {
    private String user_id;
    private String user_name;
    private String user_email;
    private String user_password;
    private String user_address;

    public User_1() {

    }
    //Method untuk set ID Sender
    public void setUser_id(String id) {
        this.user_id = id;
    }

    //Method untuk mendapatkan ID sender
    public String getUser_id(){return this.user_id;}

    public void setUser_name(String name){ this.user_name = name;}
    public String getUser_name(){return this.user_name;}
    public void setUser_email(String email){this.user_email = email;}
    public String getUser_email(){return this.user_email;}

    public void setUser_password(String password){this.user_password = password;}
    public String getUser_password(){return this.user_password;}
    public void setUser_address(String address){this.user_address = address;}
    public String getUser_address(){return this.user_address;}

}
