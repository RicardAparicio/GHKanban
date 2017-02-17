package inqbarna.com.ghkanban;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

/**
 * @author Ricard Aparicio <ricard.aparicio@inqbarna.com>
 * @version 1.0 17/02/17
 */

public class ProjectDetail extends AppCompatActivity {

    public static Intent getCallingIntent(Context context) {
        Intent i = new Intent(context, ProjectDetail.class);
        return i;
    }
}
