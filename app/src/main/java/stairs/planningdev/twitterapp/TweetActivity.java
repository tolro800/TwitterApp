package stairs.planningdev.twitterapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TweetActivity extends AppCompatActivity {

    //ツイート文入力用のEditText宣言
    private EditText mTweetEdit;
    //ツイートボタン宣言
    private Button mTweetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet);

        //いつも通りidと紐付け
        mTweetEdit = (EditText) findViewById(R.id.tweet_edit);
        mTweetButton = (Button) findViewById(R.id.send_button);

        //ツイートボタンをクリックしたときの処理
        mTweetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                //intentに元のアクティビティへ返す値を渡しておく
                intent.putExtra("TWEET_RESULT",mTweetEdit.getText().toString());
                //元のアクティビティに結果を返す
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
