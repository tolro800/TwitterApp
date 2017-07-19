package stairs.planningdev.twitterapp;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by nato on 2017/06/26.
 */

public class TweetList extends RealmObject{
    // リスト自体のID(Adapterで必須)
    @PrimaryKey
    private long id;
    private String userName;
    private String userId;
    // アイコン画像のリソースID
    private int iconResId;
    private String tweet;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getIconResId() {
        return iconResId;
    }

    public void setIconResId(int iconResId) {
        this.iconResId = iconResId;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }
}
