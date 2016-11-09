package com.titansmasher.taptitansoptimizer.UI;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;

import com.titansmasher.taptitansoptimizer.Model.Enums.World;
import com.titansmasher.taptitansoptimizer.R;
import com.titansmasher.taptitansoptimizer.UI.Abstracts.ActivityBase;

/**
 * Created by Danny on 07/11/2016.
 */

public class DonateActivity extends ActivityBase {
    @Override
    public boolean shouldShowBackButton(){
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        baseContent.addView(View.inflate(this, R.layout.donate_main, null));

        findTextView(baseContent, R.id.donate_desc).setText(Html.fromHtml(getString(R.string.donate_desc)));
        findTextView(baseContent, R.id.donate_desc).setMovementMethod(LinkMovementMethod.getInstance());
        baseContent.findViewById(R.id.donate_titansmasher).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.paypal.com/cgi-bin/webscr?cmd=_donations&business=FFWRUSJJS7HW6&alc=GB&item_name=Tap%20Titans%20Optimiser&currency_code=GBP&bn=PP%2dDonationsBF%3abtn_donateCC_LG%2egif%3aNonHosted")));
            }
        });
    }

    @Override
    public void saveChanged(){}

    @Override
    public void worldChanged(World world){}
}
