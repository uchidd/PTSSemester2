package id.uchidd.ptssemester2.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import id.uchidd.ptssemester2.R;

public class AdapterListRecyclerView extends RecyclerView.Adapter<AdapterListRecyclerView.ViewHolder> {

    private ArrayList<String> textForRecyclerView;
    private ArrayList<Integer> imageForRecyclerView;

    public AdapterListRecyclerView(ArrayList<String> textForRecyclerView, ArrayList<Integer> imageForRecyclerView){
        this.textForRecyclerView = textForRecyclerView;
        this.imageForRecyclerView = imageForRecyclerView;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_recycler_view, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.tvText.setText(textForRecyclerView.get(i));
        Picasso.get().load(imageForRecyclerView.get(i)).into(viewHolder.ivImage);
    }

    @Override
    public int getItemCount() {
        return textForRecyclerView.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvText;
        private ImageView ivImage;

        public ViewHolder(View itemView){
            super(itemView);
            tvText = (TextView)itemView.findViewById(R.id.tvRecyclerView);
            ivImage = (ImageView)itemView.findViewById(R.id.ivRecyclerView);
        }
    }

}
