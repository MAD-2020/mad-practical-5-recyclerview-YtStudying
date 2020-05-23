package sg.edu.np.mad.mad_recyclerview;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder{
    TextView txt;
    CheckBox cb;
    View v;

    public ViewHolder(View itemView){
        super(itemView);

        v = itemView;
        txt = itemView.findViewById(R.id.textView1);
        cb = itemView.findViewById(R.id.checkBox);
    }

}
