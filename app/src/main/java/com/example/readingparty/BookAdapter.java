package com.example.readingparty;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private List<BookModel> dataSet;
    public static OnItemClickListener itemClickListener;

    //constructor:
    public BookAdapter
    (List<BookModel> data,
     OnItemClickListener listener
    ){
        dataSet = data;
        itemClickListener = listener;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_book, parent, false);
        return new BookViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        holder.bind(dataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class BookViewHolder extends RecyclerView.ViewHolder{

        private final TextView title;
        private final TextView author;
        private final TextView genre;
        private final ImageView bookImage;
        private final ConstraintLayout container;


        public BookViewHolder(View view){
            super(view);

            title = view.findViewById(R.id.title);
            author = view.findViewById(R.id.author);
            genre = view.findViewById(R.id.genre);
            bookImage = view.findViewById(R.id.image);
            container = view.findViewById(R.id.container);

        }

        public void bind(BookModel item){
            title.setText(item.getTitle());
            author.setText(item.getAuthor());
            genre.setText(item.getGenre());
            Picasso.get().load(item.getImageURL()).into(bookImage);


//vrem sa anuntam prin Adapter Fragmentul ca s-a dat click pe un element
            container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onItemClick(item);

                }
            });
        }
    }
}
