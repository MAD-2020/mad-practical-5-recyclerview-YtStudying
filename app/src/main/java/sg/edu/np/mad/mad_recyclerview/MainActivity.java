package sg.edu.np.mad.mad_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<myListData> listData = new ArrayList<>();
    Adapter lAdapter;
    RecyclerView recyclerviewList;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = MainActivity.this;

        recyclerviewList = (RecyclerView) findViewById(R.id.recyclerView);
        lAdapter = new Adapter(listData, context);
        LinearLayoutManager lLayoutManager = new LinearLayoutManager(this);
        recyclerviewList.setLayoutManager(lLayoutManager);
        recyclerviewList.setItemAnimator(new DefaultItemAnimator());
        recyclerviewList.setAdapter(lAdapter);

        prepareData();
    }

    private void prepareData() {
        myListData data = new myListData("Get milk");
        listData.add(data);
        data = new myListData("Send postage");
        listData.add(data);
        data = new myListData("Buy android development book");
        listData.add(data);

        Button add = (Button) findViewById(R.id.addButton);
        final TextView addText = (TextView) findViewById(R.id.addItem);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myListData data = new myListData(addText.getText().toString());
                listData.add(data);
                lAdapter.notifyDataSetChanged();
            }
        });
    }

    /**
     * Upon calling this method, the keyboard will retract
     * and the recyclerview will scroll to the last item
     *
     * @param rv RecyclerView for scrolling to
     * @param data ArrayList that was passed into RecyclerView
     */
    private void showNewEntry(RecyclerView rv, ArrayList data){
        //scroll to the last item of the recyclerview
        rv.scrollToPosition(data.size() - 1);

        //auto hide keyboard after entry
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(rv.getWindowToken(), 0);
    }
}
