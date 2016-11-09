package com.titansmasher.taptitansoptimizer.UI.Abstracts;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

import com.titansmasher.taptitansoptimizer.Model.Enums.Page;
import com.titansmasher.taptitansoptimizer.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Danny on 29/10/2016.
 */

public abstract class PagedActivityBase extends ActivityBase{

    Map<Page, View> pages = new HashMap<>();
    Map<TabLayout.Tab, Page> tabs = new HashMap<>();
    private Page currentPage;
    TabLayout tabLayout;
    ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        baseContent.addView(View.inflate(this, R.layout.paged_activity_layout, null));
        baseContent = (LinearLayout) findViewById(R.id.paged_activity_contentview);
        tabLayout = (TabLayout) findViewById(R.id.paged_activity_tabs);

        pager = new ViewPager(this);
        tabLayout.setupWithViewPager(pager);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                changePage(tabs.get(tab));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    protected void addPage(Page page, View pageContent, String pageName){
        addPage(page, pageContent, pageName, true);
    }

    protected void addPage(Page page, View pageContent, String pageName, boolean visible){
        pages.put(page, pageContent);
        TabLayout.Tab tab = tabLayout.newTab().setText(pageName);
        tabs.put(tab, page);

        tabLayout.addTab(tab);
    }

    protected View getPage(Page page){
        return pages.get(page);
    }

    protected Page getCurrentPage(){
        return currentPage;
    }

    private void changePage(Page page){
        for (TabLayout.Tab tab :
                tabs.keySet()) {
            if (tabs.get(tab) == page){
                tab.select();
                break;
            }
        }
        baseContent.removeAllViews();

        baseContent.addView(pages.get(page));
        currentPage = page;
        pageChanged();
    }

    @Override
    public boolean shouldShowBackButton(){
        return true;
    }

    protected void pageChanged(){}
}
