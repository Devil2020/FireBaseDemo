package comc.example.mohammedmorse.firebasedemo.Presenter;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import comc.example.mohammedmorse.firebasedemo.Model.Message;

/**
 * Created by Mohammed Morse on 01/02/2018.
 */

public interface presenterInterface {
   void onPause();
   void onResume();
   void onItemClicked(View view , Bundle bundle);
   ArrayList<Message>ReRe();
}
