package com.example.recyclerviewtugas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    private List<EmailData> mEmailData;
    private MailAdapter mailAdapter;

    String[] sender = {"Suwarko", "Suherman", "Munir", "Toto", "Tedy", "Tono", "Monike","Deni","Raja","Toto", "Tedy", "Tono", "Monike","Deni","Raja"};
    String[] email = {"Musick Jam", "Last Fight", " War Of zeus", "IDK WHAT TO TYPE", "help", "dont", "ASAP","jualan Baso","Senjata api", "IDK WHAT TO TYPE", "help", "dont", "ASAP","jualan Baso","Senjata api"};
    String[] caption = {"Ba-banana ba-ba-banana-nana Ba-banana ba-ba-banana-nana", "Oh 아무것도 안 했는데 왜","태양은 우릴 놀리고", "반짝인 그 ocean 위로", "Oh 좋아하는 걸 원해 봐요","떠나요 오늘 밤 짜릿함을 찾으러 레벨업","들뜬 맘의 background music 봐 벌써 날아","봐 벌써 날아","반짝인 그","태양은 우릴 놀리고", "반짝인 그 ocean 위로", "Oh 좋아하는 걸 원해 봐요","떠나요 오늘 밤 짜릿함을 찾으러 레벨업","들뜬 맘의 background music 봐 벌써 날아","봐 벌써 날아","반짝인 그"};
    String[] time = {"10:20", "04:20", "05:10", "12:00", "21:30", "20:12", "20:20","21:54","21:50", "12:00", "21:30", "20:12", "20:20","21:54","21:50"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this,DividerItemDecoration.VERTICAL));

        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
        }
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        mEmailData = new ArrayList<>();

        for (int i = 0 ; i<sender.length; i++) {
            EmailData emailData = new EmailData(sender[i],email[i],caption[i],time[i]);

            mEmailData.add(emailData);
        }

        mailAdapter = new MailAdapter(mEmailData, MainActivity.this);

        recyclerView.setAdapter(mailAdapter);
        mailAdapter.notifyDataSetChanged();

    }
}
