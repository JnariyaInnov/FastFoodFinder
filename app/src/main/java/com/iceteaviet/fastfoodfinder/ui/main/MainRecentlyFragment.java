package com.iceteaviet.fastfoodfinder.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.iceteaviet.fastfoodfinder.activity.StoreDetailActivity;
import com.iceteaviet.fastfoodfinder.utils.Constant;
import com.iceteaviet.fastfoodfinder.R;
import com.iceteaviet.fastfoodfinder.adapter.RecentlyStoreAdapter;
import com.iceteaviet.fastfoodfinder.helper.DividerItemDecoration;
import com.iceteaviet.fastfoodfinder.helper.OnStartDragListener;
import com.iceteaviet.fastfoodfinder.helper.SimpleItemTouchHelperCallback;
import com.iceteaviet.fastfoodfinder.model.Store.Store;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by MyPC on 11/20/2016.
 */
public class MainRecentlyFragment extends Fragment implements OnStartDragListener {
    private static boolean isFABChangeClicked = false;
    @BindView(R.id.rv_recently_stores) RecyclerView recyclerView;
    @BindView(R.id.fl_container) FrameLayout containerLayout;
    private RecentlyStoreAdapter mRecentlyAdapter;
    private LinearLayoutManager mLayoutManager;
    private ItemTouchHelper mItemTouchHelper;

    public MainRecentlyFragment() {
    }

    public static MainRecentlyFragment newInstance() {
        Bundle args = new Bundle();
        MainRecentlyFragment fragment = new MainRecentlyFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_recently, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        setupRecyclerView(recyclerView);
        loadData();
    }

    private void setupRecyclerView(RecyclerView rv) {
        mRecentlyAdapter = new RecentlyStoreAdapter(this, containerLayout);

        mRecentlyAdapter.setOnItemClickListener(new RecentlyStoreAdapter.OnItemClickListener() {
            @Override
            public void onClick(Store store) {
                getActivity().startActivity(StoreDetailActivity.getIntent(getContext(), store));
            }
        });

        mLayoutManager = new LinearLayoutManager(getContext());
        rv.setLayoutManager(mLayoutManager);
        rv.setAdapter(mRecentlyAdapter);
        RecyclerView.ItemDecoration decoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL_LIST);

        rv.addItemDecoration(decoration);
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mRecentlyAdapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(rv);
    }


    private void loadData() {
        ArrayList<Store> stores = new ArrayList<>();
        stores.add(new Store(1, "Circle K Le Thi Rieng", "148 Le Thi Rieng, Ben Thanh Ward, District 1, Ho Chi Minh, Vietnam", "10.770379", "106.68912279999995", "3925 6620", Constant.TYPE_CIRCLE_K));
        stores.add(new Store(2, "Shop & Go - Phan Đình Phùng", "180 Phan Đình Phùng, P. 2, Quận Phú Nhuận, TP. HCM", "10.7955070000000", "106.6825610000000", "38 353 193", Constant.TYPE_SHOP_N_GO));
        stores.add(new Store(3, "Circle K Ly Tu Trong", "238 Ly Tu Trong, Ben Thanh Ward, District 1, Ho Chi Minh, Vietnam", "10.7721924", "106.69433409999999", "3822 7403", Constant.TYPE_CIRCLE_K));
        stores.add(new Store(4, "Familymart - Đường D2", "39 Đường D2, P. 25, Quận Bình Thạnh, TP. HCM", "10.80252", "106.715622", "35 126 283", Constant.TYPE_FAMILY_MART));
        mRecentlyAdapter.setStores(stores);
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        if (isFABChangeClicked)
            mItemTouchHelper.startDrag(viewHolder);
    }
}