package comc.example.mohammedmorse.firebasedemo.Model;

import android.os.Bundle;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by Mohammed Morse on 01/02/2018.
 */

public class FireBaseModel  {
    public Message message=new Message();
    public ArrayList<Message>messages=new ArrayList<Message>();
    public ChildEventListener childEventListener;
    public FirebaseDatabase database=FirebaseDatabase.getInstance();
    public DatabaseReference reference=database.getReference().child("Messages");

    public ArrayList<Message> SaveDatainRealTime(Bundle bundle){
        message.setUserName(bundle.getString("username"));
        if(bundle.getString("textmessage")!=null) {
            message.setMessageBody(bundle.getString("textmessage"));
            message.setUriOfImage(null);
        }
        else if(bundle.getString("textmessage")==null){
            message.setMessageBody(null);
        }
        reference.push().setValue(message);
        messages=ReturnAllDataFormRealTime();
        return messages;
    }
    public ArrayList<Message> ReturnAllDataFormRealTime(){
        childEventListener=new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                message =dataSnapshot.getValue(Message.class);
                messages.add(message);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        reference.addChildEventListener(childEventListener);
        return messages;
    }




}
