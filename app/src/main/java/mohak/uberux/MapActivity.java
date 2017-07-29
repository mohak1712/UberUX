package mohak.uberux;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MapActivity extends AppCompatActivity {

    @BindView(R.id.rootFrame)
    FrameLayout rootFrame;

    @BindView(R.id.rootll)
    LinearLayout rootll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        ButterKnife.bind(this);

        rootFrame.post(new Runnable() {
            @Override
            public void run() {

                startRevealAnimation();
            }
        });
    }

    void startRevealAnimation() {

        int cx = rootFrame.getMeasuredWidth() / 2;
        int cy = rootFrame.getMeasuredHeight() / 2;


        Animator anim =
                ViewAnimationUtils.createCircularReveal(rootll, cx, cy, 50, rootFrame.getWidth());

        anim.setDuration(1000);
        anim.setInterpolator(new DecelerateInterpolator());
        anim.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);

            }
        });

        anim.start();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}
