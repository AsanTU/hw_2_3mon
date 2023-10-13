package com.example.hw_2_3mon;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FirstFragment extends Fragment {

    private TextView tvZero;
    private Button btnMinus, btnPlus, btnNext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findId();
        onClick();
    }

    private void findId() {
        tvZero = requireActivity().findViewById(R.id.zero);
        btnPlus = requireActivity().findViewById(R.id.btn_plus);
        btnMinus = requireActivity().findViewById(R.id.btn_minus);
        btnNext = requireActivity().findViewById(R.id.btn_next);
    }

    private void onClick() {
        btnPlus.setOnClickListener(view -> {
            operationPlus();
        });
        btnMinus.setOnClickListener(view -> {
            operationMinus();
        });
        btnNext.setOnClickListener(view -> {
            navigateSec();
        });
    }

    private void operationPlus() {
        int currentValue = Integer.parseInt(tvZero.getText().toString());
        if (currentValue < 10) {
            currentValue++;
            tvZero.setText(String.valueOf(currentValue));
        } else if (currentValue == 10) {
            btnNext.setVisibility(View.VISIBLE);
        }
    }

    private void operationMinus() {
        int currentValue = Integer.parseInt(tvZero.getText().toString());
        if (currentValue >= 0) {
            currentValue--;
            tvZero.setText(String.valueOf(currentValue));
        }
    }

    private void navigateSec(){
        String value = tvZero.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString("num", value);
        SecondFragment secondFragment = new SecondFragment();
        secondFragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, secondFragment).addToBackStack(null).commit();
    }
}