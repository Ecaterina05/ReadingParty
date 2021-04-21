package com.example.readingparty;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

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

public class CategoriesFragment extends Fragment implements OnItemClickListener2 {

    public static List<CategModel> categList = new ArrayList<>();
    public static String GENUL= "genul";


    public CategoriesFragment() {
        super(R.layout.categories_layout);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initializeCategList();

//        RecyclerView este un container in care se adauga o lista si Adaptarul va sti ce sa faca pe acea lista
        CategAdapter adapter = new CategAdapter(categList, this);
        RecyclerView rv = view.findViewById(R.id.recycler_view2);
        rv.setAdapter(adapter);

    }

    private void initializeCategList(){
        categList.clear();
        categList.add(new CategModel("dystopian"));
        categList.add(new CategModel("historical"));
        categList.add(new CategModel("horror"));
        categList.add(new CategModel("sci-fi"));
        categList.add(new CategModel("romance"));
        categList.add(new CategModel("crime"));
        categList.add(new CategModel("fantasy"));

    }




    @Override
    public void onItemClick2(CategModel item) {
           // Toast.makeText(getContext(), item.getGenre2(), Toast.LENGTH_LONG).show();

        Bundle bundle = new Bundle();

        bundle.putString(GENUL, item.getGenre2());

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        CategoryFragment fragment = new CategoryFragment();
        fragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.categories, fragment)
               .addToBackStack(null);

       fragmentTransaction.commit();

    }


}