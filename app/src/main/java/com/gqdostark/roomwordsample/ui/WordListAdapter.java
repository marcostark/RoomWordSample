package com.gqdostark.roomwordsample.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gqdostark.roomwordsample.R;
import com.gqdostark.roomwordsample.model.Word;

import java.util.Collections;
import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    public class WordViewHolder extends RecyclerView.ViewHolder {

        private final TextView wordItemView;

        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textView);
        }
    }

    private final LayoutInflater mInflater;
    private List<Word> mWords = Collections.emptyList(); // Cached copy of words

    public WordListAdapter(Context context) { mInflater = LayoutInflater.from(context);}



    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, viewGroup, false);
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
//        if(mWords != null) {
//            Word current = mWords.get(position);
//            holder.wordItemView.setText(current.getWord());
//        } else {
//            holder.wordItemView.setText("Sem palavras");
//        }

        Word current = mWords.get(position);
        holder.wordItemView.setText(current.getWord());
    }

    public void setWords(List<Word> words){
        mWords = words;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
//        if(mWords != null)
//            return mWords.size();
//        else return 0;

        return mWords.size();
    }

}
