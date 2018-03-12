package comc.example.mohammedmorse.firebasedemo.Presenter;

import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.util.MarkEnforcingInputStream;

import java.util.ArrayList;

import comc.example.mohammedmorse.firebasedemo.Model.FireBaseModel;
import comc.example.mohammedmorse.firebasedemo.Model.Message;
import comc.example.mohammedmorse.firebasedemo.R;

/**
 * Created by Mohammed Morse on 01/02/2018.
 */

public class presenterImp implements presenterInterface {
    public FireBaseModel fireBaseModel ;
    ArrayList<Message> messages=new ArrayList<Message>();
    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onItemClicked(View view , Bundle bundle) {
        int id =view.getId();
        if(id== R.id.sendtext){
            messages=fireBaseModel.SaveDatainRealTime(bundle);


        }
        else if(id==R.id.imagetext){}
        else if(id==R.id.updatetext){}
        else if(id==R.id.delettext){}
    }

    @Override
    public ArrayList<Message> ReRe() {
        messages=fireBaseModel.ReturnAllDataFormRealTime();
        return messages;
    }

}
