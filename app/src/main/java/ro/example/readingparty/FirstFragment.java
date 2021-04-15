package ro.example.readingparty;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ro.example.readingparty.R;

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

        initializeBookList();

//        RecyclerView este un container in care se adauga o lista si Adaptarul va sti ce sa faca pe acea lista
        BookAdapter adapter = new BookAdapter(bookList, this);
        RecyclerView rv = view.findViewById(R.id.recycler_view);
        rv.setAdapter(adapter);

    }


    private void initializeBookList(){
        bookList.removeAll(bookList);
        bookList.add(new BookModel(
                "The Great Gatsby",
                "F. Scott Fitzgerald",
                "Tragedy",
                R.drawable.book
        ));

        bookList.add(new BookModel(
                "Wuthering Heights",
                "Emily Bronte",
                "Tragedy",
                R.drawable.book
        ));

        bookList.add(new BookModel(
                "Murder on the Orient Express",
                "Agatha Christie",
                "Crime novel",
                R.drawable.book
        ));

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
