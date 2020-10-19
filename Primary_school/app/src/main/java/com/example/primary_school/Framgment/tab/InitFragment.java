package com.example.primary_school.Framgment.tab;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.example.primary_school.R;
import java.util.ArrayList;
import java.util.List;

public class InitFragment extends FragmentActivity {
    private List<Fragment> fragmentList;
    private List<String> tabtitles;
    private TabViewpager_fragment_Adapter tabViewpager_fragment_adapter;

    public  List<Fragment> list_Fragment() {
        fragmentList = new ArrayList<>();
        tabtitles = new ArrayList<>();
        int[] fragment_layouts = new int[]{R.layout.tab_tuijie_fragment, R.layout.tab_2_fragment,
                R.layout.tab_3_fragment, R.layout.tab_4_fragment, R.layout.tab_5_fragment,R.layout.tab_6_fragment};

//        for (int i = 0; i < fragment_layouts.length; i++) {
//            Tab_fragment tab_fragment = new Tab_fragment(fragment_layouts[i]);
//            fragmentList.add(tab_fragment);
//        }
        Fragment_tuijian fragment_tuijian = new Fragment_tuijian();
        Fragment_mzbk fragment_mzbk = new Fragment_mzbk();
        Fragment_yuwen fragment_yuwen = new Fragment_yuwen();
        Fragment_shuxue fragment_shuxue = new Fragment_shuxue();
        Fragment_english fragment_english = new Fragment_english();
        Fragment_gushihui fragment_gushihui = new Fragment_gushihui();
        fragmentList.add(fragment_tuijian);
        fragmentList.add(fragment_mzbk);
        fragmentList.add(fragment_yuwen);
        fragmentList.add(fragment_shuxue);
        fragmentList.add(fragment_english);
        fragmentList.add(fragment_gushihui);

        return fragmentList;
    }
    public  List<String> list_titles() {
        tabtitles = new ArrayList<>();
        String[] titles = new String[]{"推荐", "每周必看", "语文", "数学", "英语","故事汇"};
        for (int i = 0; i < titles.length; i++) {
            tabtitles.add(titles[i]);
        }
        return tabtitles;
    }
}
