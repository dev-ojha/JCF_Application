package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;

import java.util.ArrayList;

import Models.Exercise_Model;

public class Exercise_Adapter extends RecyclerView.Adapter<Exercise_Adapter.viewHolder>{

    ArrayList<Exercise_Model> datalist;
    Context context ;

    public Exercise_Adapter(ArrayList<Exercise_Model> lists, Context context) {
        this.datalist = lists;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_item_view, parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        Exercise_Model model = datalist.get(position) ;
       // holder.rv_imageView.setImageResource(model.getPic());
        holder.rv_textView.setText(model.getText());
        Glide.with(holder.rv_imageView.getContext())
                .load(model.getPic())
                //.placeholder(R.drawable.chest1)
                .circleCrop()
                .error(R.drawable.chest1)
                .into(holder.rv_imageView);
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView rv_imageView ;
        TextView rv_textView ;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            rv_imageView =  itemView.findViewById(R.id.rv_imageView);
            rv_textView = itemView.findViewById(R.id.rv_textView);
        }
    }
}
