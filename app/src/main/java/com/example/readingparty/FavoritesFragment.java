package com.example.readingparty;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class FavoritesFragment extends Fragment {

//    private RecyclerView recyclerView;
//    private FavDB favDB;
//    private List<FavItemRemove> favItemList = new ArrayList<>();
//    private FavAdapter favAdapter;
//
//    public View onCreateView(@NonNull LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//        View root = inflater.inflate(R.layout.favorites_layout, container, false);
//
//        favDB = new FavDB(getActivity());
//        recyclerView = root.findViewById(R.id.recycler_view_fav);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//
//        // add item touch helper
//        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
//        itemTouchHelper.attachToRecyclerView(recyclerView); // set swipe to recyclerview
//
//        loadData();
//
//        return root;
//    }
//
//    private void loadData() {
//        if (favItemList != null) {
//            favItemList.clear();
//        }
//        SQLiteDatabase db = favDB.getReadableDatabase();
//        Cursor cursor = favDB.select_all_favorite_list();
//        try {
//            while (cursor.moveToNext()) {
//                String title = cursor.getString(cursor.getColumnIndex(FavDB.ITEM_TITLE));
//                String id = cursor.getString(cursor.getColumnIndex(FavDB.KEY_ID));
//            String author=cursor.getString(cursor.getColumnIndex(FavDB.ITEM_AUTHOR));
//                String imageURL = cursor.getString(cursor.getColumnIndex(FavDB.ITEM_IMAGE));
//                String genre = cursor.getString(cursor.getColumnIndex(FavDB.ITEM_GENRE));
//                FavItemRemove favItem = new FavItemRemove(title,author, genre, imageURL,id);
//                favItemList.add(favItem);
//            }
//        } finally {
//            if (cursor != null && cursor.isClosed())
//                cursor.close();
//            db.close();
//        }
//
//        favAdapter = new FavAdapter(getActivity(), favItemList);
//
//        recyclerView.setAdapter(favAdapter);
//
//    }
//
//    // remove item after swipe
//    private ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
//        @Override
//        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
//            return false;
//        }
//
//        @Override
//        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
//            final int position = viewHolder.getAdapterPosition(); // get position which is swipe
//            final FavItemRemove favItem = favItemList.get(position);
//            if (direction == ItemTouchHelper.LEFT) { //if swipe left
//                favAdapter.notifyItemRemoved(position); // item removed from recyclerview
//                favItemList.remove(position); //then remove item
//                //favDB.remove_fav(favItem.get); // remove item from database
//            }
//        }
//    };

}