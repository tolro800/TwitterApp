package stairs.planningdev.twitterapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // タイムラインを表示するリストビュー
    private ListView mTLList;
    // ↑のリストビュー用のアダプター
    private TweetAdapter mTweetAdapter;
    // ツイート情報を格納するリスト
    private ArrayList<TweetList> mTweetList;
    // ツイート入力画面へ遷移するボタン
    private ImageButton mTweetButton;
    private TextView mTestText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTLList = (ListView) findViewById(R.id.timeline);
        mTweetButton = (ImageButton) findViewById(R.id.tweet);
        mTestText = (TextView) findViewById(R.id.text_test);

        mTweetAdapter = new TweetAdapter(this);
        mTweetList = new ArrayList<>();
        mTweetAdapter.setTweetList(mTweetList);
        mTLList.setAdapter(mTweetAdapter);

        mTweetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),TweetActivity.class);
                startActivityForResult(intent,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent intent){
        String strTweet;
        super.onActivityResult(requestCode,resultCode,intent);

        if(resultCode == RESULT_OK) {
            strTweet = intent.getStringExtra("TWEET_RESULT");
            TweetList tweet = new TweetList();
            tweet.setIconResId(R.drawable.tweet);
            tweet.setUserName("HogeHogeo");
            tweet.setUserId("hoge_hoge");
            tweet.setTweet(strTweet);
            mTweetList.add(tweet);
            mTweetAdapter.notifyDataSetChanged();
        }
        /*if(resultCode == RESULT_OK) {
            strTweet = intent.getStringExtra("TWEET_RESULT");
            mTestText.setText(strTweet);
        }*/
    }
}
