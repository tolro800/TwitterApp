package stairs.planningdev.twitterapp;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    /*
    // タイムラインを表示するリストビュー
    private ListView mTLList;
    // タイムラインのリストビュー用アダプター
    private TweetAdapter mTweetAdapter;
    // ツイート情報を格納するリスト
    private ArrayList<TweetList> mTweetList;
    private ArrayAdapter<String> mTLAdapter;
    // ツイート入力画面へ遷移するボタン
    private ImageButton mTweetButton;
    private TextView mTestText;
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TweetFragment fragment = new TweetFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container,fragment);
        transaction.commit();
        /*mTLList = (ListView) findViewById(R.id.timeline);
        mTweetButton = (ImageButton) findViewById(R.id.tweet);*/

        /*mTLAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        mTLList.setAdapter(mTLAdapter);*/
        /*mTweetAdapter = new TweetAdapter(this);
        mTweetList = new ArrayList<>();
        mTweetAdapter.setTweetList(mTweetList);
        mTLList.setAdapter(mTweetAdapter);

        mTweetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),TweetActivity.class);
                startActivityForResult(intent,0);
            }
        });*/
    }

    /*@Override
    protected void onActivityResult(int requestCode,int resultCode, Intent intent){
        String strTweet;
        super.onActivityResult(requestCode,resultCode,intent);

        // リストビュー(カスタムレイアウト)時の処理
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
        // リストビュー時の処理
        /*if(resultCode == RESULT_OK) {
            strTweet = intent.getStringExtra("TWEET_RESULT");
            // アダプターにツイート文追加
            mTLAdapter.add(strTweet);
            // アダプターへデータ変更を通知
            mTLAdapter.notifyDataSetChanged();
        }*/
        // テスト用テキストビュー時の処理
        /*if(resultCode == RESULT_OK) {
            strTweet = intent.getStringExtra("TWEET_RESULT");
            mTestText.setText(strTweet);
        }
    }*/
}
