package com.hufs.dev.yongjin.multimediapt;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {
    ArrayList<word> dic;
    int count = 0;
    int wordIdx = 0;
    int numCount = 0;
    boolean numShow;
    String RandNumString;
    TextToSpeech t1;
    LinearLayout mLinearLayout;
    TextView kText;
    TextView bText;
    Random mRandom;
    int dicSize;

    public ArrayList<word> getDic()
    {
        ArrayList<word> dic = new ArrayList<word>();
        dic.add(new word("브라질식 바비큐", "Churrasco"));
        dic.add(new word("소고기 안심", "filé-mignon"));
        dic.add(new word("등심", "picanha"));
        dic.add(new word("갈비", "costela"));
        dic.add(new word("살코기", "filé"));
        dic.add(new word("스테이크", "bife"));
        dic.add(new word("쇠고기", "carne de bovina"));
        dic.add(new word("쇠고기", "carne de vaca"));
        dic.add(new word("돼지고기", "carne de suína"));
        dic.add(new word("돼지고기", "carne de porco"));
        dic.add(new word("닭고기", "frango"));
        dic.add(new word("닭 심장", "coração"));
        dic.add(new word("양고기", "carneiro"));
        dic.add(new word("칠면조", "peru"));
        dic.add(new word("생선", "peixe"));
        dic.add(new word("새우", "camarão"));
        dic.add(new word("대구", "bacalhau"));
        dic.add(new word("게", "caranguejo"));
        dic.add(new word("연어", "salmão"));
        dic.add(new word("가재", "lagosta"));
        dic.add(new word("굴", "ostra"));
        dic.add(new word("쌀", "arroz"));
        dic.add(new word("콩", "feijão"));
        dic.add(new word("국수", "massa"));
        dic.add(new word("달걀", "ovo"));
        dic.add(new word("소시지", "salsicha"));
        dic.add(new word("옥수수", "milho"));
        dic.add(new word("참치", "atum"));
        dic.add(new word("빵", "pão"));
        dic.add(new word("햄", "presunto"));
        dic.add(new word("치즈", "queijo"));
        dic.add(new word("버터", "manteiga"));
        dic.add(new word("잼", "geleia"));
        dic.add(new word("감자", "batata"));
        dic.add(new word("양파", "cebola"));
        dic.add(new word("당근", "cenoura"));
        dic.add(new word("파", "cebolinha"));
        dic.add(new word("토마토", "tomate"));
        dic.add(new word("상추", "alface"));
        dic.add(new word("버섯", "cogumelo"));
        dic.add(new word("피망", "pimentão"));
        dic.add(new word("무", "nabo"));
        dic.add(new word("배추", "acelga"));
        dic.add(new word("양배추", "repolho"));
        dic.add(new word("설탕", "açúcar"));
        dic.add(new word("소금", "sal"));
        dic.add(new word("마늘", "alho"));
        dic.add(new word("식초", "vinagre"));
        dic.add(new word("겨자", "mostarda"));
        dic.add(new word("기름", "óleo"));
        dic.add(new word("오렌지", "laranja"));
        dic.add(new word("파인애플", "abacaxi"));
        dic.add(new word("사과", "maçã"));
        dic.add(new word("배", "pera"));
        dic.add(new word("복숭아", "pêssego"));
        dic.add(new word("레몬", "limão"));
        dic.add(new word("딸기", "morango"));
        dic.add(new word("포도", "uva"));
        dic.add(new word("수박", "melancia"));
        dic.add(new word("파파야", "mamão"));
        dic.add(new word("망고", "manga"));
        dic.add(new word("메론", "melão"));
        dic.add(new word("바나나", "banana"));
        dic.add(new word("귤", "tangerina"));
        dic.add(new word("코코넛", "coco"));
        dic.add(new word("무화과", "figo"));
        dic.add(new word("자두", "ameixa"));
        dic.add(new word("체리", "cereja"));
        dic.add(new word("감", "caqui"));
        dic.add(new word("아보카도", "abacate"));
        dic.add(new word("생수", "água mineral"));
        dic.add(new word("토닉워터", "água tônica"));
        dic.add(new word("가스 없는 물", "água sem gás"));
        dic.add(new word("가스 있는 물", "água com gás"));
        dic.add(new word("작은 잔의 커피", "cafezinho"));
        dic.add(new word("카페라떼", "café com leite"));
        dic.add(new word("홍차", "chá preto"));
        dic.add(new word("녹차", "chá verde"));
        dic.add(new word("레몬차", "chá com limão"));
        dic.add(new word("오렌지 주스", "suco de laranja"));
        dic.add(new word("파인애플 쥬스", "suco de abacaxi"));
        dic.add(new word("주스", "suco de maracujá"));
        dic.add(new word("망고 쥬스", "suco de manga"));
        dic.add(new word("파파야 주스", "suco de mamão"));
        dic.add(new word("포도주스", "suco de uva"));
        dic.add(new word("우유", "leite"));
        dic.add(new word("핫초코", "chocolate"));
        dic.add(new word("탄산음료", "refrigerante"));
        dic.add(new word("과라나", "Guaraná"));
        dic.add(new word("콜라", "coca-cola"));
        dic.add(new word("스프라이트", "sprite"));
        dic.add(new word("맥주", "cerveja"));
        dic.add(new word("생맥주", "chope"));
        dic.add(new word("포도주", "vinho"));
        dic.add(new word("위스키", "uísque"));
        dic.add(new word("칵테일", "coquetel"));
        dic.add(new word("까샤싸", "cachaça"));
        dic.add(new word("까이삐링야", "caiprinha"));
        dic.add(new word("보드카", "vodka"));
        dic.add(new word("까이삐로스까", "caipirosca"));
        dic.add(new word("메뉴판", "cardápio"));
        dic.add(new word("메뉴판", "menu"));
        dic.add(new word("전채요리", "entrada"));
        dic.add(new word("애피타이저", "aperitivo"));
        dic.add(new word("식사", "refeição"));
        dic.add(new word("일품요리", "prato à la carte"));
        dic.add(new word("뷔페", "bufê"));
        dic.add(new word("수프", "sopa"));
        dic.add(new word("샐러드", "salada"));
        dic.add(new word("피자", "pizza"));
        dic.add(new word("스파게티", "espaguete"));
        dic.add(new word("파스텔", "pastel"));
        dic.add(new word("초밥", "Sushi"));
        dic.add(new word("식시세트", "talher"));
        dic.add(new word("숟가락", "colher"));
        dic.add(new word("포크", "garfo"));
        dic.add(new word("칼", "faca"));
        dic.add(new word("축구", "futebol"));
        dic.add(new word("야구", "beisebol"));
        dic.add(new word("농구", "basquete"));
        dic.add(new word("배구", "voleibol"));
        dic.add(new word("핸드볼", "handebol"));
        dic.add(new word("골프", "golfe"));
        dic.add(new word("테니스", "tênis"));
        dic.add(new word("탁구", "pingue-pongue"));
        dic.add(new word("볼링", "boliche"));
        dic.add(new word("당구", "bilhar"));
        dic.add(new word("사냥", "caça"));
        dic.add(new word("낚시", "pesca"));
        dic.add(new word("스키", "esqui"));
        dic.add(new word("스케이팅", "patinação"));
        dic.add(new word("수영", "natação"));
        dic.add(new word("경마", "turfe"));
        dic.add(new word("하이킹", "caminhada"));
        dic.add(new word("싸이클링", "ciclismo"));
        dic.add(new word("소풍", "piquenique"));
        dic.add(new word("체스", "xadrez"));
        dic.add(new word("카드놀이", "jogo de cartas"));
        dic.add(new word("숨바꼭질", "Esconde-esconde"));
        dic.add(new word("장난", "brincadeira"));
        dic.add(new word("접시", "prato"));
        dic.add(new word("컵", "copo"));
        dic.add(new word("잔", "xícara"));
        dic.add(new word("냅킨", "guardanapo"));
        dic.add(new word("웨이터", "garçom"));
        dic.add(new word("웨이트리스", "garçonete"));
        dic.add(new word("계산서", "contador"));
        dic.add(new word("계산대", "caixa"));
        dic.add(new word("요금", "preço"));
        dic.add(new word("팁", "gorjeta"));
        dic.add(new word("영수증", "recibo"));



        return dic;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        mLinearLayout = (LinearLayout)findViewById(R.id.touch);
        kText = (TextView)findViewById(R.id.kText);
        bText = (TextView)findViewById(R.id.bText);
        dic = getDic();
        dicSize =  dic.size();
        mRandom = new Random();

        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.KOREA);
                }
            }
        });


        mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //t1.speak("안녕하세요", TextToSpeech.QUEUE_FLUSH, null);
                if (count==0)
                {
                    t1.setLanguage(Locale.KOREA);
                    count++;
                    bText.setText("");

                        wordIdx = mRandom.nextInt(dicSize);
                        String kor = dic.get(wordIdx).getKor();
                        kText.setText(kor);
                        t1.speak(kor, TextToSpeech.QUEUE_FLUSH, null);

                }
                else
                {
                    count=0;
                    t1.setLanguage(new Locale("pt_BR"));

                        String br = dic.get(wordIdx).getPt();
                        bText.setText(br);
                        t1.speak(br, TextToSpeech.QUEUE_FLUSH, null);
                        numCount++;



                }
            }
        });


    }

}
