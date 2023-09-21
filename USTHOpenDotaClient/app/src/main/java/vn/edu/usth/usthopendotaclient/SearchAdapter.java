package vn.edu.usth.usthopendotaclient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyHolder>{

    Context context;
    ArrayList<ModelClass> arrayList;
    LayoutInflater layoutInflater;

    public SearchAdapter(Context context, ArrayList<ModelClass> arrayList){
        this.context = context;
        this.arrayList = arrayList;
        layoutInflater = LayoutInflater.from(context);

    }
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_file,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.userName.setText(arrayList.get(position).getUserName());
        holder.userNum.setText(arrayList.get(position).getUserNum());
        holder.img.setImageResource(arrayList.get(position).getImg());

    }

    @Override
    public int getItemCount() {

        return arrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView userName,userNum;
        ImageView img;

        public MyHolder(@NonNull View itemView) {

            super(itemView);
            userName=itemView.findViewById(R.id.txt);
            userNum=itemView.findViewById(R.id.txt2);
            img=itemView.findViewById(R.id.img);

        }
    }
}
