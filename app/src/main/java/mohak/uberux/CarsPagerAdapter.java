package mohak.uberux;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

/**
 * Created by mohak on 29/7/17.
 */

public class CarsPagerAdapter extends PagerAdapter {

    List<Integer> dataList;

    public CarsPagerAdapter(List<Integer> dataList) {
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view;

        if (dataList.get(position) == 0) {
            view = LayoutInflater.from(container.getContext()).inflate(R.layout.uber_economy, container, false);
        } else {
            view = LayoutInflater.from(container.getContext()).inflate(R.layout.uber_premium, container, false);
        }

        container.addView(view);
        return view;
    }


}
