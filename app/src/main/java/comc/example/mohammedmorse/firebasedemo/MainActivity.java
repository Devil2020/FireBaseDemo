package comc.example.mohammedmorse.firebasedemo;

import android.os.Bundle;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import comc.example.mohammedmorse.firebasedemo.Presenter.presenterImp;
import comc.example.mohammedmorse.firebasedemo.Presenter.presenterInterface;
import comc.example.mohammedmorse.firebasedemo.View.ChangeInMainActiView;
import comc.example.mohammedmorse.firebasedemo.View.RecyclerViewAdapter;

public class MainActivity extends AppCompatActivity implements ChangeInMainActiView {
    public presenterInterface presenterInterfacee;
    public ArrayList<comc.example.mohammedmorse.firebasedemo.Model.Message>messages;
    public EditText editText ;
        public FloatingActionButton button1 , buttonadd , buttonedit ,buttondelet ,buttonimage;
        public String UserName ;
        public RecyclerView  recyclerView ;
        public RecyclerViewAdapter adapter;
        public RecyclerView.LayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenterInterfacee=new presenterImp();
        button1=findViewById(R.id.showicons);
        buttonadd=findViewById(R.id.sendtext);
        buttondelet=findViewById(R.id.delettext);
        buttonedit=findViewById(R.id.updatetext);
        buttonimage=findViewById(R.id.sendimage);
        editText=findViewById(R.id.entremessage);
        recyclerView=findViewById(R.id.recyclerview);
        manager=new LinearLayoutManager(this);
        messages=new ArrayList<>();
        messages=presenterInterfacee.ReRe();
        adapter=new RecyclerViewAdapter(MainActivity.this ,messages);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        DefaultVisibuilty();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menubutton , menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Attach Auth
    }

    @Override
    protected void onPause() {
        super.onPause();
        //If the User Want to Return
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //SignOut and Delet the data from Adapter
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void PressFloatingButton(View view) {

        button1.setImageResource(R.drawable.down);
        buttonadd.setVisibility(View.VISIBLE);
        buttonedit.setVisibility(View.VISIBLE);
        buttondelet.setVisibility(View.VISIBLE);
        buttonimage.setVisibility(View.VISIBLE);

    }

    @Override
    public void DefaultVisibuilty() {
        buttonadd.setVisibility(View.INVISIBLE);
        buttonedit.setVisibility(View.INVISIBLE);
        buttondelet.setVisibility(View.INVISIBLE);
        buttonimage.setVisibility(View.INVISIBLE);
    }

    public void onClick(View view ) {
        Bundle bundle=new Bundle();
        bundle.putString("username" , UserName);
        if(editText.getText().toString()!=null) {
            bundle.putString("textmessage", editText.getText().toString());
        }
        else if(editText.getText().toString()==null){

        }
        presenterInterfacee.onItemClicked(view , bundle );
        adapter.notifyDataSetChanged();
    }

}
