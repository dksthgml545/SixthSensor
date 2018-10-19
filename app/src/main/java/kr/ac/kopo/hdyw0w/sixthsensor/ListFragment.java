package kr.ac.kopo.hdyw0w.sixthsensor;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Objects;

import kr.ac.kopo.hdyw0w.sixthsensor.item.PlaceListItem;

public class ListFragment extends Fragment implements NavActivity.onKeyBackPressedListener {

    private RecyclerView placeListView;

    FloatingActionButton fil_fab, fil_fab1, fil_fab2;
    LinearLayout fabLayout1, fabLayout2;
    View fabBGLayout;
    private boolean isFABOpen = false;

    public static ListFragment newInstance() {
        ListFragment fragment = new ListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((NavActivity) Objects.requireNonNull(getActivity())).setOnKeyBackPressedListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        placeListView = view.findViewById(R.id.fil_rcv);
        placeListView.setHasFixedSize(true);
        placeListView.setLayoutManager(new LinearLayoutManager(getContext()));

        ArrayList<PlaceListItem> placeListItemArrayList = new ArrayList<>();
        placeListItemArrayList.add(new PlaceListItem(R.drawable.ic_trash_can, "우리나라공원 쓰레기통", 99, 50));
        placeListItemArrayList.add(new PlaceListItem(R.drawable.ic_trash_can, "만세공원 쓰레기통", 30, 10));
        placeListItemArrayList.add(new PlaceListItem(R.drawable.ic_trash_can, "폴리텍공원 쓰레기통", 50, 30));
        placeListItemArrayList.add(new PlaceListItem(R.drawable.ic_trash_can, "안성공원 쓰레기통", 20, 5));
        placeListItemArrayList.add(new PlaceListItem(R.drawable.ic_trash_can, "하늘나라공원 쓰레기통", 10, 6));

        PlaceListAdapter placeListAdapter = new PlaceListAdapter(placeListItemArrayList);

        placeListView.setAdapter(placeListAdapter);

        fabLayout1 = view.findViewById(R.id.fabLayout1);
        fabLayout2 = view.findViewById(R.id.fabLayout2);
        fil_fab = view.findViewById(R.id.fil_fab);
        fil_fab1 = view.findViewById(R.id.fil_fab1);
        fil_fab2 = view.findViewById(R.id.fil_fab2);
        fabBGLayout = view.findViewById(R.id.fabBGLayout);

        fil_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isFABOpen) {
                    showFABMenu();
                } else {
                    closeFABMenu();
                }
            }
        });

        fabBGLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeFABMenu();
            }
        });

        fil_fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent_act = new Intent(getContext(), AddPlaceActivity.class);
                startActivity(intent_act);

            }
        });

        fil_fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });

        return view;
    }

    private void showFABMenu() {

        isFABOpen = true;
        fabLayout1.setVisibility(View.VISIBLE);
        fabLayout2.setVisibility(View.VISIBLE);
        fabBGLayout.setVisibility(View.VISIBLE);

        fil_fab.animate().rotationBy(45);
        fabLayout1.animate().translationY(-getResources().getDimension(R.dimen.standard_55));
        fabLayout2.animate().translationY(-getResources().getDimension(R.dimen.standard_120));

    }

    private void closeFABMenu(){

            isFABOpen = false;
            fabBGLayout.setVisibility(View.GONE);
            fil_fab.animate().rotationBy(-45);
            fabLayout1.animate().translationY(0);
            fabLayout2.animate().translationY(0).setListener(new Animator.AnimatorListener() {

                @Override
                public void onAnimationStart(Animator animator) {

                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    if (!isFABOpen) {
                        fabLayout1.setVisibility(View.GONE);
                        fabLayout2.setVisibility(View.GONE);
                    }

                }

                @Override
                public void onAnimationCancel(Animator animator) {

                }

                @Override
                public void onAnimationRepeat(Animator animator) {

                }
            });
        }

    @Override
    public void onBack() {
        if (isFABOpen) {
            closeFABMenu();
        } else {
            NavActivity activity = (NavActivity) getActivity();
            Objects.requireNonNull(activity).setOnKeyBackPressedListener(null);
            activity.onBackPressed();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("ListFragment", "onDestroy");
        isFABOpen = false;
        ((NavActivity) Objects.requireNonNull(getActivity())).setOnKeyBackPressedListener(null);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("ListFragment", "onResume()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("ListFragment", "onStart()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("ListFragment", "onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("ListFragment", "onStop()");
    }
}

