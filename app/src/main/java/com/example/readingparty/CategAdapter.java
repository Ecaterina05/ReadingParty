package com.example.readingparty;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CategAdapter extends RecyclerView.Adapter<CategAdapter.CategViewHolder> {
    private List<CategModel> dataSet;
    public static OnItemClickListener2 itemClickListener;

    //constructor:
    public CategAdapter
    (List<CategModel> data,
     OnItemClickListener2 listener
    ){
        dataSet = data;
        itemClickListener = listener;
    }

    @NonNull
    @Override
    public CategAdapter.CategViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_categ, parent, false);
        return new CategAdapter.CategViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull CategAdapter.CategViewHolder holder, int position) {
        holder.bind(dataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class CategViewHolder extends RecyclerView.ViewHolder{


        private final TextView genre;
        private final LinearLayout container2;

        public CategViewHolder(View view){
            super(view);

            genre = view.findViewById(R.id.genre2);
            container2 = view.findViewById(R.id.container2);


        }

        public void bind(CategModel item){

            genre.setText(item.getGenre2());

//vrem sa anuntam prin Adapter Fragmentul ca s-a dat click pe un element
            container2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onItemClick2(item);

                }
            });
        }
    }
}
