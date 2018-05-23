package com.example.asus1.helloworld.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.dou361.dialogui.DialogUIUtils;
import com.dou361.dialogui.listener.DialogUIItemListener;
import com.example.asus1.helloworld.CircleTransform;
import com.example.asus1.helloworld.Constants;
import com.example.asus1.helloworld.ForthActivity;
import com.example.asus1.helloworld.MainActivity;
import com.example.asus1.helloworld.MyIntentService;
import com.example.asus1.helloworld.R;
import com.example.asus1.helloworld.SecondActivity;
import com.leon.lib.settingview.LSettingItem;
import com.squareup.picasso.Picasso;


public class FragmentThree extends Fragment {
    private LSettingItem mSettingItemOne;
    private LSettingItem mSettingItemTwo;
    private LSettingItem mSettingItemThree;
    private LSettingItem mSettingItemFour;
    private ImageView mIvHead;
    private Button button5;
    private Integer times = 5;

    Activity mActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_set,container,false);

        mSettingItemOne = (LSettingItem) view.findViewById(R.id.item_one);
        mSettingItemTwo = (LSettingItem) view.findViewById(R.id.item_two);
        mSettingItemThree = (LSettingItem) view.findViewById(R.id.item_three);
        mSettingItemFour = (LSettingItem) view.findViewById(R.id.item_four);
        button5 = (Button) view.findViewById(R.id.button5);
        mIvHead = (ImageView) view.findViewById(R.id.headimage);

        DialogUIUtils.init(view.getContext());
        mActivity = this.getActivity();

        mSettingItemOne.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click(boolean isChecked) {
                Intent intent = new Intent(view.getContext(), ForthActivity.class);
                startActivity(intent);
            }
        });
        mSettingItemTwo.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click(boolean isChecked) {

                //left to be continued
                String[] words2 = new String[]{"5秒", "10秒", "30秒", "60秒"};
                int current = 0;
                if(times == 10) current = 1;
                else if(times == 30) current = 2;
                else if(times == 60) current = 3;
                DialogUIUtils.showSingleChoose(mActivity, "请选择时间间隔", current, words2, new DialogUIItemListener() {
                    @Override
                    public void onItemClick(CharSequence text, int position) {
                        if(position == 0) {
                            times = 5;
                        } else if(position == 1) {
                            times = 10;
                        } else if(position == 2) {
                            times = 30;
                        } else if(position == 3) {
                            times = 60;
                        }
                    }
                }).show();
            }
        });
        mSettingItemThree.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click(boolean isChecked) {
                if(isChecked) {
                    MyIntentService.startActionFoo(view.getContext(), times.toString());
                    Toast.makeText(view.getContext(), "开启同步", Toast.LENGTH_SHORT).show();
                } else {

                    //left to be continued

                    Toast.makeText(view.getContext(), "关闭同步", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mSettingItemFour.setmOnLSettingItemClick(new LSettingItem.OnLSettingItemClick() {
            @Override
            public void click(boolean isChecked) {

            }
        });
        Picasso.with(view.getContext()).load(R.drawable.girl).transform(new CircleTransform()).into(mIvHead);

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    public static FragmentThree newInstance(String s){
        Bundle bundle = new Bundle();
        bundle.putString(Constants.KEY_ARGS,s);
        FragmentThree fragment = new FragmentThree();
        fragment.setArguments(bundle);
        return fragment;
    }
}
