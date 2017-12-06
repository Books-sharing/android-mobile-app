package marwor.ninja_book.SearchBook;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Marcin_stacjonarny on 2017-10-03.
 */

public class SearchBookBookClass implements Parcelable {
    private String author;
    private String title;
    private String isbn;
    private String status;
    private String description;

    public SearchBookBookClass(String author,String title,String isbn,String status,String description){
        this.author=author;
        this.isbn=isbn;
        this.status=status;
        this.title=title;
        this.description=description;
    }

    protected SearchBookBookClass(Parcel in) {
        author = in.readString();
        title = in.readString();
        isbn = in.readString();
        status = in.readString();
        description = in.readString();
    }

    public static final Creator<SearchBookBookClass> CREATOR = new Creator<SearchBookBookClass>() {
        @Override
        public SearchBookBookClass createFromParcel(Parcel in) {
            return new SearchBookBookClass(in);
        }

        @Override
        public SearchBookBookClass[] newArray(int size) {
            return new SearchBookBookClass[size];
        }
    };

    public String getDescription() { return description; }
    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getStatus() {
        return status;
    }

    /**
     * Describe the kinds of special objects contained in this Parcelable
     * instance's marshaled representation. For example, if the object will
     * include a file descriptor in the output of {@link #writeToParcel(Parcel, int)},
     * the return value of this method must include the
     * {@link #CONTENTS_FILE_DESCRIPTOR} bit.
     *
     * @return a bitmask indicating the set of special object types marshaled
     * by this Parcelable object instance.
     * @see #CONTENTS_FILE_DESCRIPTOR
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(author);
        dest.writeString(title);
        dest.writeString(isbn);
        dest.writeString(status);
        dest.writeString(description);
    }
}
