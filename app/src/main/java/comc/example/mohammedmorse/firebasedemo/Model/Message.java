package comc.example.mohammedmorse.firebasedemo.Model;

/**
 * Created by Mohammed Morse on 31/01/2018.
 */

public class Message {

    public String UserName;
    public String UriOfImage;
    public String MessageBody;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUriOfImage() {
        return UriOfImage;
    }

    public void setUriOfImage(String uriOfImage) {
        UriOfImage = uriOfImage;
    }

    public String getMessageBody() {
        return MessageBody;
    }

    public void setMessageBody(String messageBody) {
        MessageBody = messageBody;
    }


}
