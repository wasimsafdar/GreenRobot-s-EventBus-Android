package dk.humma.www.eventbus_greenrobots;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class EventBus_MainActivity extends AppCompatActivity {

    private static final String MODEL_TAG="model";
    private LiteralFragment modelFrag=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentManager mgr=getFragmentManager();
        FragmentTransaction transMgr=mgr.beginTransaction();

        modelFrag=(LiteralFragment)mgr.findFragmentByTag(MODEL_TAG);

        if (modelFrag == null) {

            modelFrag=new LiteralFragment();
            transMgr.add(modelFrag, MODEL_TAG);
        }
        LiteralListFragment listFrag=
                (LiteralListFragment)mgr.findFragmentById(android.R.id.content);

        if (listFrag == null) {

            listFrag=new LiteralListFragment();
            transMgr.add(android.R.id.content, listFrag);
        }

        listFrag.setModel(modelFrag.getModel());

        if (!transMgr.isEmpty()) {
            transMgr.commit();
        }
    }
}
