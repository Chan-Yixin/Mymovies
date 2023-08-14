package sg.edu.rp.c346.id22038283.mymovies;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etTitle, etGenre, etYear;
    Spinner spinnerRating;
    Button btnInsert, btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitle = findViewById(R.id.etTitle);
        etGenre = findViewById(R.id.etGenre);
        etYear = findViewById(R.id.etYear);
        spinnerRating = findViewById(R.id.spinner);
        btnInsert = findViewById(R.id.buttonInsert);
        btnShow = findViewById(R.id.buttonShow);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                String selectedItem = spinnerRating.getSelectedItem().toString();
                db.insertMovie(etTitle.getText().toString(), etGenre.getText().toString(), Integer.parseInt(etYear.getText().toString()), selectedItem);
                Toast.makeText(MainActivity.this, "Movie Added", Toast.LENGTH_SHORT).show();
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                startActivity(intent);
            }
        });
    }
}