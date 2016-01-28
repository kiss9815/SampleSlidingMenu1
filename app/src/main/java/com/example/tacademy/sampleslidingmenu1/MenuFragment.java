package com.example.tacademy.sampleslidingmenu1;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {

    public static final int MENU_MAIN = 0;
    public static final int MENU_FIRST = 1;
    public static final int MENU_SECOND = 2;

    public interface OnMenuItemSelectListener{ // 메뉴가 눌렸는지 액티비티에게 알려주는 수단
        public void onMenuItemSelected(int menuId);
    }

    OnMenuItemSelectListener mCallback;

    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        View menu = view.findViewById(R.id.text_main);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCallback != null){
                    mCallback.onMenuItemSelected(MENU_MAIN);
                }
            }
        });

        menu = view.findViewById(R.id.text_first);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCallback != null){
                    mCallback.onMenuItemSelected(MENU_FIRST);
                }
            }
        });

        menu = view.findViewById(R.id.text_second);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCallback != null){
                    mCallback.onMenuItemSelected(MENU_SECOND);
                }
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) { // 넘어오는 context가 메인액티비티임
        super.onAttach(context);
        if(context instanceof OnMenuItemSelectListener){ // 프래그먼트가 액티비티에 값을 전달하는 방법 , 이걸 쓰면 사용하는 액티비티에서 implement를 해야함
            mCallback = (OnMenuItemSelectListener)context; // context가 mCallback이 됨 mCallback이 메인이 됨
        }

    }
}
