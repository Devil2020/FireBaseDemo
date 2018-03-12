package comc.example.mohammedmorse.firebasedemo.View;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import comc.example.mohammedmorse.firebasedemo.Model.Message;
import comc.example.mohammedmorse.firebasedemo.R;

/**
 * Created by Mohammed Morse on 31/01/2018.
 */

public class RecyclerViewAdapter  extends RecyclerView.Adapter<RecyclerViewAdapter.HoldViewsOfRecyclerView>{
             Context context;
             ArrayList<Message>messages;
           public RecyclerViewAdapter(Context context , ArrayList<Message> messages){
               this.context=context;
               this.messages=messages;
           }
    @Override
    public HoldViewsOfRecyclerView onCreateViewHolder(ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(context).inflate(R.layout.iteminrecyclerview ,parent ,false);
       HoldViewsOfRecyclerView holdViewsOfRecyclerView=new HoldViewsOfRecyclerView(view);
        return holdViewsOfRecyclerView;
    }

    @Override
    public void onBindViewHolder(HoldViewsOfRecyclerView holder, int position) {
             holder.mUserName.setText(messages.get(position).getUserName());
             if(messages.get(position).getUriOfImage()==null){
                  holder.mImageMessage.setVisibility(View.INVISIBLE);
                  holder.mBodyText.setText(messages.get(position).MessageBody);
             }
             else if(messages.get(position).getUriOfImage()!=null)
                 holder.mBodyText.setVisibility(View.INVISIBLE);
                 Glide.with(context).load(Uri.parse(messages.get(position).getUriOfImage())).into(holder.mImageMessage);
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    class HoldViewsOfRecyclerView extends RecyclerView.ViewHolder{
       TextView mUserName , mBodyText ;
       ImageView mImageMessage;
        public HoldViewsOfRecyclerView(View itemView) {
            super(itemView);
        mUserName=itemView.findViewById(R.id.username);
        mBodyText=itemView.findViewById(R.id.messagetext);
        mImageMessage=itemView.findViewById(R.id.imagetext);
        }
    }
}
