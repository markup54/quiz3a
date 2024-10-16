package pl.zabrze.zs10.quiz3a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private  ArrayList<Pytanie> listaPytan = new ArrayList<>();
    private TextView textView;
    private int aktualnePytanie;
    private Button buttonNastepne;
    private Button buttonTak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wypelnijPytania();
        textView = findViewById(R.id.textViewTrescPytania);
        aktualnePytanie = 0;
        wstawPytanie(aktualnePytanie);

        buttonTak = findViewById(R.id.button);
        buttonTak.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sprawdzToPytanie(true);
                    }
                }
        );
        buttonNastepne = findViewById(R.id.button4);
        buttonNastepne.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        aktualnePytanie++;
                        if(aktualnePytanie == listaPytan.size()){
                            buttonNastepne.setVisibility(View.INVISIBLE);
                        }
                        else {
                            wstawPytanie(aktualnePytanie);
                        }
                    }
                }
        );
    }

    private void sprawdzToPytanie(boolean odpowiedzUzytkownika){
        if(listaPytan.get(aktualnePytanie).isPoprawna() == odpowiedzUzytkownika){
            listaPytan.get(aktualnePytanie).setUdzielonoPoprawnaOdpowiedz(true);
        }
    }

    private void wstawPytanie(int i){
        Pytanie pytanie = listaPytan.get(i);
        textView.setText(pytanie.getTresc());
    }


    private void wypelnijPytania(){
        listaPytan.add(new Pytanie(
                "Czy sekwoja może mieć 100 metrów wysokości?",
                "Sekwoje są bardzo wysokie",
                true));
        listaPytan.add(new Pytanie(
                "Czy najgrubsze drzewo ma obwód 10 metrów?",
                "Obwód pnia najgrubszego drzewa świata ma 44 metry.",
                false
        ));
        listaPytan.add(new Pytanie(
                "Czy drzewa są pochłaniaczem tlenu?",
                "Zastanów się na czym polega fotosynteza",
                false
        ));

    }

}