package sayitahmin.dersuygulama.uygulama.com.recylerviewuygulamasi;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.tasarimiTut>{
    private Context mContext;
    private List<Filmler> disaridanGelenFilmler;

    public MyAdapter(Context mContext, List<Filmler> disaridanGelenFilmler) {
        this.mContext = mContext;
        this.disaridanGelenFilmler = disaridanGelenFilmler;
    }


    @Override
    public tasarimiTut onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView=LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewtasarim,parent,false);
        // tasarımı buraya baglıyoruz
        return new tasarimiTut(itemView);
    }

    @Override
    public void onBindViewHolder(final tasarimiTut holder , int position ) {
        final Filmler filmler=disaridanGelenFilmler.get(position); //filmler sınıfından nesne üretim listeye bagladık
       holder.filmAdiText.setText(String.valueOf(filmler.getFilmAdi())); //film adını alıp textView yazdırdık
       holder.filmFiyatText.setText(String.valueOf(filmler.getFilmFiyat())); //film fiyatı alıp yazdırdık
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"Seçtiginiz film:"+filmler.getFilmAdi(),Toast.LENGTH_SHORT).show();
            }
        });
       holder.sepeteEkle.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(mContext,"Sepete Eklendi",Toast.LENGTH_SHORT).show();
           }
       });

       holder.filmResim.setImageResource(mContext.getResources().getIdentifier(disaridanGelenFilmler.get(position).getFilmResim()
               ,"drawable", mContext.getPackageName())); //bu kod resimin ismine göre drawablenden çekmeye yarıyor sıra sıra card view ekliyor


        holder.menuAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(mContext, holder.menuAc); //popup menu oluşturuyoruz
                MenuInflater inflater = popupMenu.getMenuInflater();
                inflater.inflate(R.menu.menu, popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.detayGöster:

                                Intent intent=new Intent(mContext,filmDetayi.class);
                                intent.putExtra("film",filmler); //detayi göstermek için filmleri farklı sınıfa yolluyoyoruz
                                mContext.startActivity(intent);


                                return true;
                            default:
                        }
                        return false;
                    }
                });
            }
        });



    }

    @Override
    public int getItemCount() {
        return disaridanGelenFilmler.size();
    }

    public class tasarimiTut extends RecyclerView.ViewHolder{
        public TextView filmAdiText;
        public TextView filmFiyatText;
        public ImageView filmResim;
        public ImageView menuAc;
        public Button sepeteEkle;
        public CardView cardView;

        public tasarimiTut(View view) {
            super(view);
            filmAdiText=view.findViewById(R.id.filmAdiText);
            filmFiyatText=view.findViewById(R.id.filmFiyatText);
            filmResim=view.findViewById(R.id.filmResim);
            menuAc=view.findViewById(R.id.menuAc);
            sepeteEkle=view.findViewById(R.id.sepeteEkle);
            cardView=view.findViewById(R.id.cardView);

        }
    }
}
