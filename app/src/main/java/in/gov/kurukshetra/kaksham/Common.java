package in.gov.kurukshetra.kaksham;

import android.view.View;

import java.lang.reflect.Field;

public class Common {

    public static void setOnClick(View.OnClickListener listener, View...views){
        for(View v: views){
            v.setOnClickListener(listener);
        }
    }

    public static int getResId(String resName, Class<?> c) {

        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

}
