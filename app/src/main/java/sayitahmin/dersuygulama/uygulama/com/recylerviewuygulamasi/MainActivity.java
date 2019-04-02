package sayitahmin.dersuygulama.uygulama.com.recylerviewuygulamasi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Filmler> filmler;
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true); //ekran yatay olsa bile tasarım bozulmasın

        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

       filmler=new ArrayList<>();
        filmler.add(new Filmler("Anadoluda",15.99,"birzamanlaranadoluda"));
        filmler.add(new Filmler("Django",19.99,"django"));
        filmler.add(new Filmler("Inception",24.99,"inception"));
        filmler.add(new Filmler("Interstellar",15.99,"interstellar"));
        filmler.add(new Filmler("The Hateful Eight",12.99,"thehatefuleight"));
        filmler.add(new Filmler("The Pianist",4.99,"thepianist"));
        adapter=new MyAdapter(this,filmler);
        recyclerView.setAdapter(adapter);
    }
}
