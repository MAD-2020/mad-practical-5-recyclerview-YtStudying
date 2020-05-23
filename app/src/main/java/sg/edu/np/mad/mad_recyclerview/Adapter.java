package sg.edu.np.mad.mad_recyclerview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {

    private ArrayList<myListData> listdata;
    Context context;

    public Adapter(ArrayList<myListData> arrayList, Context con) {
        this.context = con;
        this.listdata = arrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_view_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        myListData list_items = listdata.get(position);
        holder.txt.setText(list_items.getDescription());
        final String itemName = holder.txt.getText().toString();

        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = LayoutInflater.from(v.getContext());
                View alert = layoutInflater.inflate(R.layout.alert_dialog, null, false);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setView(alert);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        listdata.remove(position);
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.cancel();
                    }
                });

                TextView displayItem = alert.findViewById(R.id.textView2);
                displayItem.setText(itemName + "?");
                AlertDialog alertDialog = builder.create();
                alertDialog.setTitle("Delete");
                alertDialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }
}
