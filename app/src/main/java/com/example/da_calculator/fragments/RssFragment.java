package com.example.da_calculator.fragments;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.da_calculator.WebViewActivity;
import com.example.da_calculator.adapter.MyAdapter;
import com.example.da_calculator.databinding.FragmentRssBinding;
import com.example.da_calculator.interfaces.IRecyclerItemClickListener;
import com.example.da_calculator.viewmodel.MainViewModel;

public class RssFragment extends Fragment implements IRecyclerItemClickListener {
    private FragmentRssBinding binding;
    private MainViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewModel();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initBinding();
        initViews();
        observeData();
        return binding.getRoot();
    }

    private void initBinding() {
        binding = FragmentRssBinding.inflate(getLayoutInflater());
    }

    private void initViewModel() {
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
    }

    private void initViews() {
        binding.recyclerRss.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerRss.setHasFixedSize(true);
        binding.btnFetch.setOnClickListener(view -> {
            binding.recyclerRss.showShimmer();
            viewModel.getRss();
        });
    }

    private void observeData() {
        viewModel.getRss().observe(getViewLifecycleOwner(), rss -> {
            MyAdapter adapter = new MyAdapter(rss.channel.items, this);
            binding.recyclerRss.setAdapter(adapter);
            binding.recyclerRss.hideShimmer();
        });

        viewModel.getError().observe(getViewLifecycleOwner(), error ->
                Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show());
    }

    @Override
    public void onItemClick(String url) {
        Intent intent = new Intent(requireContext(), WebViewActivity.class);
        intent.putExtra("url", url);
        startActivity(intent);
    }
}