package ro.example.readingparty;

import android.os.Parcel;
import android.os.Parcelable;

public class BookModel implements Parcelable {

    private String title;
    private String author;
    private String genre;
    private Integer imageId;

    public BookModel(String title, String author, String genre, int ImageId){
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.imageId = ImageId;
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

    public Integer getImageId() {
        return imageId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] {this.title, this.author, this.genre, this.imageId.toString()});
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
        String[] data = new String[4];

        in.readStringArray(data);
        // the order needs to be the same as in writeToParcel() method
        this.title = data[0];
        this.author = data[1];
        this.genre = data[2];
        this.imageId = Integer.valueOf(data[3]);
    }

}
