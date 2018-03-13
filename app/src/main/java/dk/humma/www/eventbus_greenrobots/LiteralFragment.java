package dk.humma.www.eventbus_greenrobots;

import android.app.Fragment;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by Waseem on 13/03/2018.
 */

public class LiteralFragment extends Fragment {

    private static final String [] items = {"Afrikaans","Albanian","Amharic","Azerbaijani","Basque",
    "Belarusian","Bengali","Bosnian","Bulgarian","Chinese","Croatian","Czech","Danish","Dutch",
    "English","Esperanto","Estonian","Filipino","Finnish","French","Galician","Georgian",
    "German","Greek","Gujarati","Haitian Creole","Hebrew","Hindi","Hungarian","Icelandic",
    "Indonesian","Irish","Italian","Japanese","Javanese","Kannada","Kazakh","Khmer","Korean",
    "Kurdish","Kyrgyz","Latin","Latvian","Lithuania","Macedonian","Malay","Malayalam","Maltese",
    "Marathi","Nepali","Norwegian","Persian","Polish","Portuguese","Romanian","Russian","Serbian","Sinhala","Slovene",
    "Spanish","Swahili","Swedish","Tajik","Tamil","Telugu","Thai","Turkish","Ukrainian","Urdu","Uzbek",
    "Vietnamese","Welsh"
    };
    private List<String> model=
            Collections.synchronizedList(new ArrayList<String>());
    private boolean isStarted = false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
        if (!isStarted){
            isStarted=true;
            new upLoadLiteralThread().start();
        }
    }

    public ArrayList<String> getModel() {
        return(new ArrayList<String>(model));
    }

    private class upLoadLiteralThread extends Thread{
        @Override
        public void run() {
            for (String item: items){
                if (!isInterrupted()){
                    model.add(item);
                    EventBus.getDefault().post(new LiteralEvent(item)); //Posting an event on EventBus
                    SystemClock.sleep(400);
                }
            }
        }
    }
}
