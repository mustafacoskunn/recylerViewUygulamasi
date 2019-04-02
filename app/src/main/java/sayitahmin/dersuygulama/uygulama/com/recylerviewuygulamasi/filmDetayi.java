package sayitahmin.dersuygulama.uygulama.com.recylerviewuygulamasi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class filmDetayi extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    Filmler film;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_detayi);
        imageView=findViewById(R.id.imageView);
        textView=findViewById(R.id.textView);

        film= (Filmler) getIntent().getSerializableExtra("film");
        textView.setText(film.getFilmAdi());
        imageView.setImageResource(getResources().getIdentifier(film.getFilmResim(),"drawable", getPackageName())); //bu kod resimin ismine göre drawablenden çekmeye yarıyor



    }
}
