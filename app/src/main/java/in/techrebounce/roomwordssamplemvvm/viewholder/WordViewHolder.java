package in.techrebounce.roomwordssamplemvvm.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import in.techrebounce.roomwordssamplemvvm.R;

public class WordViewHolder extends RecyclerView.ViewHolder {
    private TextView textViewWordItem;

    public WordViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewWordItem = itemView.findViewById(R.id.textView);
    }

    public void bind(String text) {
        textViewWordItem.setText(text);
    }

    public static WordViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new WordViewHolder(view);
    }
}
