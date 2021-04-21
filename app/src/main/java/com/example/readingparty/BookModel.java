package com.example.readingparty;

import android.os.Parcel;
import android.os.Parcelable;

public class BookModel implements Parcelable {

    private String title;
    private String author;
    private String genre;
    private String imageURL;
    private String desc;

    public BookModel(String title, String author, String genre, String imageURL, String desc){
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.imageURL = imageURL;
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre(){
        return genre;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] {this.title, this.author, this.genre, this.imageURL});
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public BookModel createFromParcel(Parcel in) {
            return new BookModel(in);
        }

        public BookModel[] newArray(int size) {
            return new BookModel[size];
        }
    };

    public BookModel(Parcel in){
        String[] data = new String[5];

        in.readStringArray(data);
        // the order needs to be the same as in writeToParcel() method
        this.title = data[0];
        this.author = data[1];
        this.genre = data[2];
        this.imageURL = data[3];
        this.desc = data[4];
    }

}
