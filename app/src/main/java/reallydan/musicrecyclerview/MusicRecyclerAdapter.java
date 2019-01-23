package reallydan.musicrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MusicRecyclerAdapter extends RecyclerView.Adapter<MusicRecyclerAdapter.ViewHolder>{

    private static final String TAG = "MusicRecyclerAdapter";

    private ArrayList<String> mSongNames = new ArrayList<>();
    private ArrayList<String> mArtistNames = new ArrayList<>();
    private Context mContext;
    private OnArtistClickListener onArtistClickListener;

    public MusicRecyclerAdapter(Context mContext, ArrayList<String> mSongNames, ArrayList<String> mArtistNames, OnArtistClickListener onArtistClickListener) {
        this.mSongNames = mSongNames;
        this.mArtistNames = mArtistNames;
        this.mContext = mContext;
        this.onArtistClickListener = onArtistClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.music_list_item, viewGroup, false);
        return new ViewHolder(view, onArtistClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Log.d(TAG, "onBindViewHolder: called");

        viewHolder.tvSongName.setText(mSongNames.get(i));
        viewHolder.tvArtistName.setText(mArtistNames.get(i));
    }

    @Override
    public int getItemCount() {
        return mSongNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvSongName, tvArtistName;
        ConstraintLayout mParentLayout;
        OnArtistClickListener onArtistClickListener;

        public ViewHolder(@NonNull View itemView, OnArtistClickListener onArtistClickListener) {
            super(itemView);

            tvSongName = itemView.findViewById(R.id.tvSongName);
            tvArtistName = itemView.findViewById(R.id.tvArtistName);
            mParentLayout = itemView.findViewById(R.id.mParentLayout);
            this.onArtistClickListener = onArtistClickListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onArtistClickListener.onArtistClick(getAdapterPosition());
        }
    }

    public interface OnArtistClickListener {
        void onArtistClick(int position);
    }
}
