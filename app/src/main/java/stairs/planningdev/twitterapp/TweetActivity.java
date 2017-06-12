package stairs.planningdev.twitterapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TweetActivity extends AppCompatActivity {
    private EditText mTweetEdit;
    private Button mTweetButton;

    private String mTweetText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet);

        mTweetEdit = (EditText) findViewById(R.id.tweet_edit);
        mTweetButton = (Button) findViewById(R.id.send_button);

        mTweetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTweetText = mTweetEdit.getText().toString();
                Intent intent = getIntent();
                intent.putExtra("TWEET_RESULT",mTweetText);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
