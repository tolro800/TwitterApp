package stairs.planningdev.twitterapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

import static android.app.Activity.RESULT_OK;

public class TweetFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // タイムラインを表示するリストビュー
    private ListView mTLList;
    // タイムラインのリストビュー用アダプター
    private TweetAdapter mTweetAdapter;
    // ツイート情報を格納するリスト
    private ArrayList<TweetList> mTweetList;
    // ツイート入力画面へ遷移するボタン
    private ImageButton mTweetButton;
    // Realm用の変数とPrimaryKey用のID変数(ツイート追加するごとにインクリメント)
    private Realm realm;
    private int id;

    public TweetFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TweetFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TweetFragment newInstance(String param1, String param2) {
        TweetFragment fragment = new TweetFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        realm = Realm.getDefaultInstance();
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tweet, container, false);

        mTLList = (ListView) v.findViewById(R.id.timeline);
        mTweetButton = (ImageButton) v.findViewById(R.id.tweet);

        mTweetAdapter = new TweetAdapter(getContext());
        mTweetList = new ArrayList<>();
        //Realmからツイートデータ取得
        RealmResults<TweetList> results = realm.where(TweetList.class).findAll();
        for(int i=0;i<results.size();i++) mTweetList.add(results.get(i));
        id = results.size();
        mTweetAdapter.setTweetList(mTweetList);
        mTLList.setAdapter(mTweetAdapter);

        mTweetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(),TweetActivity.class);
                startActivityForResult(intent,0);
            }
        });

        // Inflate the layout for this fragment
        return v;
    }

    @Override
    public void onActivityResult(int requestCode,int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        String strTweet;

        // リストビュー(カスタムレイアウト)時の処理
        if (resultCode == RESULT_OK) {
            strTweet = intent.getStringExtra("TWEET_RESULT");
            //tweetをrealmへ書き込むトランザクション実行
            realm.beginTransaction();
            //RealmObjectとしてTweetListをインスタンス化
            TweetList tweet = realm.createObject(TweetList.class,id++);
            tweet.setIconResId(R.drawable.tweet);
            tweet.setUserName("HogeHogeo");
            tweet.setUserId("hoge_hoge");
            tweet.setTweet(strTweet);
            realm.commitTransaction();

            mTweetList.add(tweet);
            mTweetAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        realm.close();
    }
}
