package cursoandroid.pruebarest1;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    private EditText inputPelicula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputPelicula = (EditText) findViewById(R.id.input_pelicula);
    }

    public void buscarPelicula(View view) {
        String titulo = inputPelicula.getText().toString();
        if (!TextUtils.isEmpty(titulo)) {

        }

    }
    public static final String TAG = "com.amatellanes.pelicularest";

    private class LoadFilmTask extends AsyncTask<String, Long, String> {
        protected String doInBackground(String... urls) {
            try {
                return HttpRequest.get(urls[0]).accept("application/json").body();
            }
            catch (HttpRequestException exception) {
                return null;
            }
        }

        protected void onPostExecute(String response) {
            Log.i(TAG, response);
        }
    }

}
