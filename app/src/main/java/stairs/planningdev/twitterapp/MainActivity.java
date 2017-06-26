package stairs.planningdev.twitterapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // タイムラインを表示するリストビュー
    private ListView mTLList;
    // ツイート内容を保持するためのアダプター
    private ArrayAdapter<String> mTLAdapter;
    private ArrayList<String> mTweetList;
    // ツイート入力画面へ遷移するボタン
    private ImageButton mTweetButton;
    private TextView mTestText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTweetButton = (ImageButton) findViewById(R.id.tweet);
        mTestText = (TextView) findViewById(R.id.text_test);
        mTLList = (ListView) findViewById(R.id.timeline);

        mTLAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        mTLList.setAdapter(mTLAdapter);

        mTweetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),TweetActivity.class);
                startActivityForResult(intent,0);
            }
        });
    }

    //startActivityForResult で起動したアクティビティが finish() で破棄されたとき呼び出される
    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent intent) {
        String strTweet;
        super.onActivityResult(requestCode, resultCode, intent);
        //RESULT_OKが返ってきたらintentから値取得
        /*if (resultCode == RESULT_OK) {
            //intentから返ってきた値取得
            strTweet = intent.getStringExtra("TWEET_RESULT");
            mTestText.setText(strTweet);
        }
    }*/
        if(resultCode == RESULT_OK) {
            strTweet = intent.getStringExtra("TWEET_RESULT");
            mTestText.setText(strTweet);
            mTLAdapter.add(strTweet);
            mTLAdapter.notifyDataSetChanged();
        }
    }
}
