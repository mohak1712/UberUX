package mohak.uberux;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public class CarsPagerAdapter extends PagerAdapter {
    private List<Integer> dataList;

    CarsPagerAdapter(List<Integer> dataList) {
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
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
