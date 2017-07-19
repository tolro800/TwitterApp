package stairs.planningdev.twitterapp;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{
    private TabLayout tab;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TabLayout,ViewPagerの取得
        tab  = (TabLayout) findViewById(R.id.tabs);
        pager = (ViewPager) findViewById(R.id.pager);
        //ページタイトル
        final String[] pageTitle = {"ホーム","通知","メッセージ"};

        //ViewPagerのアダプター
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            //ページ内容としてフラグメントを取得
            @Override
            public Fragment getItem(int position) {
                return TweetFragment.newInstance("","");
            }
            //タブに表示するページ名を取得
            @Override
            public CharSequence getPageTitle(int position) {
                return pageTitle[position];
            }
            //ページ数を取得
            @Override
            public int getCount() {
                return pageTitle.length;
            }
        };

        //ViewPagerにアダプターを設定
        pager.setAdapter(adapter);
        //リスナー使わないならいらないかもしれない、使わないならimplementsもしなくていい
        pager.addOnPageChangeListener(this);
        //TabLayoutとViewPagerを紐付け
        tab.setupWithViewPager(pager);


        //Realmの設定
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(config);

        //Fragment突っ込むだけの場合
        /*TweetFragment fragment = new TweetFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // トランザクションに表示先指定して追加
        transaction.add(R.id.container,fragment);
        // トランザクション実行
        transaction.commit();*/
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
