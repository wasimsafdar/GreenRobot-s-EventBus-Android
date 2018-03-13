package dk.humma.www.eventbus_greenrobots;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import de.greenrobot.event.EventBus;

/**
 * Created by Waseem on 13/03/2018.
 */

public class LiteralListFragment extends ListFragment{

    private ArrayAdapter<String> adapter = null;
    private ArrayList<String> model = null;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,model);
        getListView().setScrollbarFadingEnabled(false);
        setListAdapter(adapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        EventBus.getDefault().register(this); //Register an event
    }

    @Override
    public void onDetach() {
        super.onDetach();
        EventBus.getDefault().unregister(this); //Unregister an event
    }

    //GreenBot Event thread
    public void onEventMainThread(LiteralEvent event)
    {
        adapter.add(event.getLiteral());
    }

    public void setModel(ArrayList<String> model) {
        this.model=model;
    }
}
