package models;

public class Keys {
    private int keyID;
    private String userID;
    private String publicKey;
    private String date_time;
    private int status;

    public Keys(int keyID, String userID, String publicKey, String date_time, int status) {
        this.keyID = keyID;
        this.userID = userID;
        this.publicKey = publicKey;
        this.date_time = date_time;
        this.status = status;
    }

    public Keys(String userID, String publicKey, String date_time, int status){
        this.userID = userID;
        this.publicKey = publicKey;
        this.date_time = date_time;
        this.status = status;
    }

    public int getKeyID() {
        return keyID;
    }

    public void setKeyID(int keyID) {
        this.keyID = keyID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Keys{" +
                "keyID=" + keyID +
                ", userID='" + userID + '\'' +
                ", publicKey='" + publicKey + '\'' +
                ", date_time='" + date_time + '\'' +
                ", status=" + status +
                '}';
    }
}
