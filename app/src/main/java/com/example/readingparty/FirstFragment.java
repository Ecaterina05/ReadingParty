package com.example.readingparty;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.example.readingparty.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class FirstFragment extends Fragment implements OnItemClickListener {

    public static List<BookModel> bookList = new ArrayList<>();
    public static String BOOK_TITLE = "movie title";
    public static String BOOK = "movie";

    public FirstFragment() {
        super(R.layout.fragment_first);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        DatabaseReference booksRef = FirebaseDatabase.getInstance().getReference("books");

        booksRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    bookList.clear();
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        String book_title = snapshot.child("title").getValue().toString();
                        String book_author = snapshot.child("author").getValue().toString();
                        String book_genre = snapshot.child("genre").getValue().toString();

                        String book_link = snapshot.child("image").getValue().toString();

                        bookList.add(new BookModel(
                                book_title,
                                book_author,
                                book_genre,
                                book_link
                        ));

                    }
                }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

//        RecyclerView este un container in care se adauga o lista si Adaptarul va sti ce sa faca pe acea lista
        BookAdapter adapter = new BookAdapter(bookList, this);
        RecyclerView rv = view.findViewById(R.id.recycler_view);
        rv.setAdapter(adapter);

    }




    @Override
    public void onItemClick(BookModel item) {
        //      Toast.makeText(getContext(), item.getTitle(), Toast.LENGTH_LONG).show();

        Bundle bundle = new Bundle();
        bundle.putString(BOOK_TITLE, item.getTitle());
        bundle.putParcelable(BOOK,  item);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        SecondFragment fragment = new SecondFragment();
        fragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.fragment_container, fragment)
                .addToBackStack(null);

        fragmentTransaction.commit();
    }
}
