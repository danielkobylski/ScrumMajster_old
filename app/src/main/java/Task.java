import android.os.Parcel;
import android.os.Parcelable;

public class Task implements Parcelable {
    private String mStory;
    private int mWeight;
    private int mTime;

    Task(String story, int weight, int time) {
        mStory = story;
        mWeight = weight;
        mTime = time;
    }


    protected Task(Parcel in) {
        mStory = in.readString();
        mWeight = in.readInt();
        mTime = in.readInt();
    }

    public static final Creator<Task> CREATOR = new Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };

    public String getStory() {
        return mStory;
    }

    public void setStory(String story) {
        mStory = story;
    }

    public int getWeight() {
        return mWeight;
    }

    public void setWeight(int weight) {
        mWeight = weight;
    }

    public int getTime() {
        return mTime;
    }

    public void setTime(int time) {
        mTime = time;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mStory);
        parcel.writeInt(mWeight);
        parcel.writeInt(mTime);
    }
}
