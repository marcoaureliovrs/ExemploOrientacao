package br.com.marcogorak.exemploorientacao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Declarando atributos da classe
    EditText edt;
    ArrayList<String> nomes;
    ArrayAdapter<String> adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState !=null) {
            nomes = savedInstanceState.getStringArrayList("nomes");
        } else {
            nomes = new ArrayList<String>();
        }

        //Associando os elementos da tela com os atributos da classe
        edt = (EditText)findViewById(R.id.editText);
        listView = (ListView)findViewById(R.id.listView);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nomes);
        listView.setAdapter(adapter);
    }

    public void meuBotaoClick (View v) {
        nomes.add(edt.getText().toString());
        edt.setText(" ");
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("nomes", nomes);
    }
}
