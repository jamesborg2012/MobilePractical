package com.example.james.mobilepractical;

import android.content.ClipData;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.activeandroid.query.Select;

import org.w3c.dom.Text;

import java.util.List;


public class Example extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;

    public static Example newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        Example fragment = new Example();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_example, container, false);
        TextView textView = (TextView) view;
        textView.setText("Fragment No." + mPage);
        return view;
    }
}
