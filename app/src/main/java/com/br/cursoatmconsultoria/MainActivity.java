package com.br.cursoatmconsultoria;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               enviarEmail();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_principal, R.id.nav_servicos, R.id.nav_clientes, R.id.nav_contato, R.id.nav_sobre)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }


    public void enviarEmail(){

        //String celular = "41995452640";
        //ACTION_DIAL - mostra a tela já com o numero na tela e é so presionar pra ligar
        //ACTON_CAll - mostra a tela com o numéro e liga automaticamente.
        //Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(celular));
        //startActivity(intent);

        /*
        String imagem = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ_vrwmAEGzdU_lPQ9_MZSvLtXzNtKkxO7ubDCd-2ZnfJ1RexhlpW9vXLWff9ieO84s_fY&usqp=CAU";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(imagem));
        startActivity(intent);
        */

        /*
        String endereco = "https://www.google.com/maps/place/R.+Jo%C3%A3o+Henrique+Gon%C3%A7alves,+126+-+Lagoa+da+Concei%C3%A7%C3%A3o,+Florian%C3%B3polis+-+SC,+88062-300/@-27.585987,-48.4634787,17z/data=!3m1!4b1!4m5!3m4!1s0x95273edce1e9e7fb:0x7f5b4e9521a634e2!8m2!3d-27.585987!4d-48.46129";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(endereco));
        startActivity(intent);
        */

        //abrir e exibir e-mail
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"atendimento@atmconsultoria.com.br"} );
        intent.putExtra(Intent.EXTRA_SUBJECT, "Contato pelo App");
        intent.putExtra(Intent.EXTRA_TEXT, "Mensagem automática");

        //Da pra escolher o tipo de mime-type específico
        intent.setType("message/rfc822");
        //intent.setType("text/plain");
        //intent.setType("imagem/*");
        //intent.setType("application/pdf");

        startActivity(Intent.createChooser(intent, "Escolha um App de e-mail:"));
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}