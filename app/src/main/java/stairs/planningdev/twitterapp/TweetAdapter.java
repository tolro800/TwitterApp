package stairs.planningdev.twitterapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by nato on 2017/06/27.
 */

public class TweetAdapter extends BaseAdapter {
    Context mcontext;
    LayoutInflater mlayoutInflater = null;
    ArrayList<TweetList> mtweetList;

    public TweetAdapter(Context context){
        mcontext = context;
        mlayoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    public void setTweetList(ArrayList<TweetList> tweetList){
        mtweetList = tweetList;
    }

    @Override
    public int getCount() {
        return mtweetList.size();
    }

    @Override
    public Object getItem(int index) {
        return mtweetList.get(index);
    }

    @Override
    public long getItemId(int index) {
        return mtweetList.get(index).getId();
    }

    @Override
    public View getView(int index, View convertView, ViewGroup parent) {
        // LayoutInflater:レイアウトファイルを参照してビューを作る
        convertView = mlayoutInflater.inflate(R.layout.row_tweet,parent,false);
        // アイコン画像のリソースIDセット
        ((ImageView)convertView.findViewById(R.id.icon_user)).setImageResource(mtweetList.get(index).getIconResId());
        // ユーザー名,ユーザーIDセット
        ((TextView)convertView.findViewById(R.id.tweet_user)).setText(  mtweetList.get(index).getUserName() + " @"
                                                                        + mtweetList.get(index).getUserId());
        // ツイート内容セット
        ((TextView)convertView.findViewById(R.id.tweet_text)).setText(mtweetList.get(index).getTweet());

        // 一行分のレイアウトをListViewに送る
        return convertView;
    }
}
