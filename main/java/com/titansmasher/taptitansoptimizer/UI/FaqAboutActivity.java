package com.titansmasher.taptitansoptimizer.UI;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.titansmasher.taptitansoptimizer.Model.Enums.Page;
import com.titansmasher.taptitansoptimizer.Model.Enums.World;
import com.titansmasher.taptitansoptimizer.R;
import com.titansmasher.taptitansoptimizer.UI.Abstracts.PagedActivityBase;

/**
 * Created by Danny on 02/11/2016.
 */

public class FaqAboutActivity extends PagedActivityBase {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView aboutText = new TextView(this);
        TextView faqText = new TextView(this);
        final TextView creditsText = new TextView(this);

        aboutText.setText(Html.fromHtml(getString(R.string.faqabout_about)));
        faqText.setText(Html.fromHtml(getString(R.string.faqabout_faq)));
        creditsText.setText(Html.fromHtml(getString(R.string.faqabout_credits)));

        aboutText.setMovementMethod(LinkMovementMethod.getInstance());
        faqText.setMovementMethod(LinkMovementMethod.getInstance());
        creditsText.setMovementMethod(LinkMovementMethod.getInstance());

        this.addPage(Page.FAQABOUT_ABOUT, aboutText, getString(R.string.tab_faqabout_about));
        this.addPage(Page.FAQABOUT_FAQ, faqText, getString(R.string.tab_faqabout_faq));
        this.addPage(Page.FAQABOUT_CREDITS, creditsText, getString(R.string.tab_faqabout_credits));
    }

    @Override
    public void worldChanged(World world) {

    }

    @Override
    public void saveChanged() {

    }
}
