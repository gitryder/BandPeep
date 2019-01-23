package reallydan.bandpeep;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MusicRecyclerAdapter.OnArtistClickListener {

    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<String> mSongNames = new ArrayList<>();
    private ArrayList<String> mArtistNames = new ArrayList<>();

    //ui components
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started");

        mToolbar = findViewById(R.id.mToolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Artists");

        setupLists();
    }

    public void setupLists(){
        Log.d(TAG, "setupLists: setting up lists");

        mSongNames.add("November Rain");
        mArtistNames.add("Guns & Roses");

        mSongNames.add("Thunderstruck");
        mArtistNames.add("AC/DC");

        mSongNames.add("Bohemian Rhapsody");
        mArtistNames.add("Queen");

        mSongNames.add("Smells like teen spirit");
        mArtistNames.add("Nirvana");

        mSongNames.add("Sweet Child O' Mine");
        mArtistNames.add("Guns & Roses");

        mSongNames.add("Hotel California");
        mArtistNames.add("Eagles");

        mSongNames.add("We will rock you");
        mArtistNames.add("Queen");

        mSongNames.add("Johnny B. Goode");
        mArtistNames.add("Chuck Berry");

        mSongNames.add("Wonderwall");
        mArtistNames.add("Oasis");

        mSongNames.add("Back in Black");
        mArtistNames.add("AC/DC");

        mSongNames.add("The White Stripes");
        mArtistNames.add("Seven Nation Army");

        mSongNames.add("Smoke on the water");
        mArtistNames.add("Deep Purple");

        setupRecyclerView();
    }

    public void setupRecyclerView(){
        Log.d(TAG, "setupRecyclerView: setting up recyclerview");
        RecyclerView mRecyclerView = findViewById(R.id.mRecyclerView);
        MusicRecyclerAdapter adapter = new MusicRecyclerAdapter(this, mSongNames, mArtistNames, this);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onArtistClick(int position) {
        Log.d(TAG, "onArtistClick: clicked an item");

        Toast.makeText(this, mSongNames.get(position), Toast.LENGTH_LONG).show();
    }
}
