package pl.zabrze.zs10.quiz3a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private  ArrayList<Pytanie> listaPytan = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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