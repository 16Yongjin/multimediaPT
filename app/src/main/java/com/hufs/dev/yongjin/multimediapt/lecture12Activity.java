package com.hufs.dev.yongjin.multimediapt;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class lecture12Activity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture12);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


    }



    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_lecture, container, false);
            final TextView title = (TextView) rootView.findViewById(R.id.lectitle);
            final TextView transTitle = (TextView)rootView.findViewById(R.id.transTitle);
            title.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));

            final LinearLayout cont = (LinearLayout)rootView.findViewById(R.id.content);
            final LinearLayout transView = (LinearLayout)rootView.findViewById(R.id.transView);

            final ScrollView scroll = (ScrollView)rootView.findViewById(R.id.scriptScroll);
            final ScrollView transScroll = (ScrollView)rootView.findViewById(R.id.transScroll);


            final Button playBtn = (Button)rootView.findViewById(R.id.playbtn);
            final Button transBtn = (Button)rootView.findViewById(R.id.trans);

            final String packName = getActivity().getPackageName();
            String t;



            switch (getArguments().getInt(ARG_SECTION_NUMBER)) {
                case 1:
                    t = "1. 뷔페식당에서 음료만 주문할 때";
                    title.setText(t);
                    transTitle.setText(t);
                    for(int i=87; i<=96; i++) {
                        TextView script = new TextView(getActivity());
                        script.setTextSize(15);
                        script.setTextColor(Color.parseColor("#000000"));
                        String scriptName = "@raw/script" + i;
                        int scriptID = getResources().getIdentifier(scriptName, "raw", packName);
                        String soundName = "@raw/sound" + i;
                        final int soundID = getResources().getIdentifier(soundName, "raw", packName);
                        script.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Player.getInstance().play(getActivity(), soundID);
                            }
                        });

                        script.setText(readString(getActivity(),scriptID));
                        cont.addView(script);

                        TextView s = new TextView(getActivity());
                        s.setTextSize(15);
                        s.setTextColor(Color.parseColor("#000000"));
                        String transName = "@raw/trans" + i;
                        int transID = getResources().getIdentifier(transName, "raw", packName);
                        s.setText(readHanString(getActivity(), transID));
                        transView.addView(s);
                    }
                    //해석 버튼
                    transScroll.setVisibility(View.INVISIBLE);
                    transBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(transScroll.getVisibility() == View.INVISIBLE) {
                                transScroll.setVisibility(View.VISIBLE);
                                scroll.setVisibility(View.INVISIBLE);

                            }
                            else {
                                transScroll.setVisibility(View.INVISIBLE);
                                scroll.setVisibility(View.VISIBLE);
                            }
                        }
                    });
                    // 전체 재생 버튼
                    playBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String steamName = "@raw/streamsound" + "14";
                            final int streamID = getResources().getIdentifier(steamName, "raw", packName);
                            Player.getInstance().play(getActivity(), streamID);
                        }
                    });


                    break;

                case 2:
                    t = "2. 식당에서 주문할 때";
                    title.setText(t);
                    transTitle.setText(t);

                    for(int i=97; i<=106; i++) {
                        TextView script = new TextView(getActivity());
                        script.setTextSize(15);
                        script.setTextColor(Color.parseColor("#000000"));
                        String scriptName = "@raw/script" + i;
                        int scriptID = getResources().getIdentifier(scriptName, "raw", packName);
                        String soundName = "@raw/sound" + i;
                        final int soundID = getResources().getIdentifier(soundName, "raw", packName);
                        script.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Player.getInstance().play(getActivity(), soundID);
                            }
                        });
                        script.setText(readString(getActivity(),scriptID));
                        cont.addView(script);

                        TextView s = new TextView(getActivity());
                        s.setTextSize(15);
                        s.setTextColor(Color.parseColor("#000000"));
                        String transName = "@raw/trans" + i;
                        int transID = getResources().getIdentifier(transName, "raw", packName);
                        s.setText(readHanString(getActivity(), transID));
                        transView.addView(s);
                    }

                    transScroll.setVisibility(View.INVISIBLE);
                    transBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(transScroll.getVisibility() == View.INVISIBLE) {
                                transScroll.setVisibility(View.VISIBLE);
                                scroll.setVisibility(View.INVISIBLE);

                            }
                            else {
                                transScroll.setVisibility(View.INVISIBLE);
                                scroll.setVisibility(View.VISIBLE);
                            }
                        }
                    });
                    playBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String steamName = "@raw/streamsound" + "15";
                            final int streamID = getResources().getIdentifier(steamName, "raw", packName);
                            Player.getInstance().play(getActivity(), streamID);
                        }
                    });
                    break;

                case 3:
                    t = "3. 식당에서 계산할 때";
                    title.setText(t);
                    transTitle.setText(t);
                    for(int i=107; i<=114; i++) {
                        TextView script = new TextView(getActivity());
                        script.setTextSize(15);
                        script.setTextColor(Color.parseColor("#000000"));
                        String scriptName = "@raw/script" + i;
                        int scriptID = getResources().getIdentifier(scriptName, "raw", packName);
                        String soundName = "@raw/sound" + i;
                        final int soundID = getResources().getIdentifier(soundName, "raw", packName);
                        script.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Player.getInstance().play(getActivity(), soundID);
                            }
                        });
                        script.setText(readString(getActivity(),scriptID));
                        cont.addView(script);

                        TextView s = new TextView(getActivity());
                        s.setTextSize(15);
                        s.setTextColor(Color.parseColor("#000000"));
                        String transName = "@raw/trans" + i;
                        int transID = getResources().getIdentifier(transName, "raw", packName);
                        s.setText(readHanString(getActivity(), transID));
                        transView.addView(s);
                    }

                    transScroll.setVisibility(View.INVISIBLE);
                    transBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(transScroll.getVisibility() == View.INVISIBLE) {
                                transScroll.setVisibility(View.VISIBLE);
                                scroll.setVisibility(View.INVISIBLE);

                            }
                            else {
                                transScroll.setVisibility(View.INVISIBLE);
                                scroll.setVisibility(View.VISIBLE);
                            }
                        }
                    });
                    playBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String steamName = "@raw/streamsound" + "16";
                            final int streamID = getResources().getIdentifier(steamName, "raw", packName);
                            Player.getInstance().play(getActivity(), streamID);
                        }
                    });
                    break;

            }



            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }

    public static String readString(Context ctx, int ID) {

        String data = null;
        InputStream inputStream = ctx.getResources().openRawResource(ID);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray());
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    public static String readHanString(Context ctx, int ID) {

        String data = null;
        InputStream inputStream = ctx.getResources().openRawResource(ID);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }

            data = new String(byteArrayOutputStream.toByteArray(), "MS949");
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
