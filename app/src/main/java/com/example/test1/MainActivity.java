package com.example.test1;

import android.os.Bundle;
import android.os.Handler;
import android.widget.GridView;

import com.example.test1.adapter.anime_adapter;
import com.example.test1.adapter.photo_adapter;
import com.example.test1.object.anime;
import com.example.test1.object.photo;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.test1.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {

    anime_adapter apdapter;
    anime_adapter apdapter1;
    ArrayList<anime> truyentranhArrayList;
    ArrayList<anime> truyendammyArrayList;
    ArrayList<Integer> images;
    GridView gdv1, gdv2;
    RecyclerView gdvdstruyen, gdv3, gdv4;

    ViewPager viewPager;
    CircleIndicator mcircleindicator;
    List<photo> listphoto;

    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (viewPager.getCurrentItem() == listphoto.size() - 1) {
                viewPager.setCurrentItem(0);
            } else {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.ViewPager);
        mcircleindicator = findViewById(R.id.circle_indicator);

        listphoto = getlistphoto();
        photo_adapter adapter = new photo_adapter(listphoto);
        viewPager.setAdapter(adapter);

        mcircleindicator.setViewPager(viewPager);

        handler.postDelayed(runnable, 4000);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable, 3000);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        init();
        anhXa();
        setUp();
        setClick();
    }

    private void replaceFrg(Fragment frg) {
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.main, frg).commit();
    }

    //listphoto add anh
    private List<photo> getlistphoto() {
        List<photo> list = new ArrayList<>();
        list.add(new photo(R.drawable.logo));
        list.add(new photo(R.drawable.logo));
        list.add(new photo(R.drawable.logo));
        return list;
    }

    private void init() {
        truyentranhArrayList = new ArrayList<>();
        truyentranhArrayList.add(new anime("Shinju No Nectar", "Chapter 3", "https://i.hinhhinh.com/ebook/190x247/le-cau-hon-cua-shinsengumi_1720002887.png?gt=hdfgdfg&mobile=2"));
        truyentranhArrayList.add(new anime("Elf Ngực Bự Và Kho Báu Hầm Ngục", "Chapter 8.1", "https://i.hinhhinh.com/ebook/190x247/elf-nguc-bu-va-kho-bau-ham-nguc_1720346135.png?gt=hdfgdfg&mobile=2"));
        truyentranhArrayList.add(new anime("Đại Chu Tiên Lại", "Chapter 4.5", "https://truyenqqviet.com/truyen-tranh/dai-chu-tien-lai-11796"));
        truyentranhArrayList.add(new anime("Unmei No Makimodoshi", "Chapter 5.2", "https://i.hinhhinh.com/ebook/190x247/unmei-no-makimodoshi_1718336336.jpg?gt=hdfgdfg&mobile=2"));
        truyentranhArrayList.add(new anime("Unmei No Makimodoshi", "Chapter 5.2", "https://i.hinhhinh.com/ebook/190x247/unmei-no-makimodoshi_1718336336.jpg?gt=hdfgdfg&mobile=2"));
        truyentranhArrayList.add(new anime("Unmei No Makimodoshi", "Chapter 5.2", "https://i.hinhhinh.com/ebook/190x247/unmei-no-makimodoshi_1718336336.jpg?gt=hdfgdfg&mobile=2"));
        apdapter = new anime_adapter(this, 0, truyentranhArrayList);

        truyendammyArrayList = new ArrayList<>();
        truyendammyArrayList.add(new anime("Unmei No Makimodoshi", "Chapter 5.2", "https://i.hinhhinh.com/ebook/190x247/unmei-no-makimodoshi_1718336336.jpg?gt=hdfgdfg&mobile=2"));
        truyendammyArrayList.add(new anime("1001 Cách Chinh Phục Chồng Yêu", "Chapter 632", "https://i.hinhhinh.com/ebook/190x247/1001-cach-chinh-phuc-chong-yeu_1669708202.jpg?gt=hdfgdfg&mobile=2"));
        truyendammyArrayList.add(new anime("Ca Ca Gần Đây Có Chút Gay", "Chapter 5.2", "https://i.hinhhinh.com/ebook/190x247/ca-ca-gan-day-co-chut-gay_1490360484.jpg?gt=hdfgdfg&mobile=2"));
        apdapter1 = new anime_adapter(this, 0, truyendammyArrayList);
    }

    private void anhXa() {
        gdvdstruyen = findViewById(R.id.gdvdstruyen);
        gdv1 = findViewById(R.id.gdv1);
        gdv2 = findViewById(R.id.gdv2);
        gdv3 = findViewById(R.id.gdv3);
        gdv4 = findViewById(R.id.gdv4);
    }

    private void setUp() {
//        gdvdstruyen.setAdapter(apdapter);
        gdv1.setAdapter(apdapter1);
        gdv2.setAdapter(apdapter1);
//        gdv3.setAdapter(apdapter1);
//        gdv4.setAdapter(apdapter1);

    }

    private void setClick() {
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(runnable, 3000);
    }
}