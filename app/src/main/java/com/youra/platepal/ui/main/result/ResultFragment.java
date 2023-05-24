package com.youra.platepal.ui.main.result;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.ViewModelProvider;

import com.youra.platepal.api.Api;
import com.youra.platepal.base.BaseFragment;
import com.youra.platepal.databinding.FragmentResultBinding;
import com.youra.platepal.util.PrefService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ResultFragment  extends BaseFragment {

    private FragmentResultBinding binding;
    private PrefService pref;
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    public OkHttpClient client = new OkHttpClient();
    private ResultViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentResultBinding.inflate(inflater, container, false);
        pref = new PrefService(getContext());
        getParentFragmentManager().setFragmentResultListener("request", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                String userRequest = result.getString("message");
                callAPI(userRequest);
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    private void init() {
        viewModel = new ViewModelProvider(this).get(ResultViewModel.class);
        initListeners();
    }
    private void initListeners() {

    }

    public void callAPI(String userRequest) {
        Log.d("GPTTEST", "REQUEST " + userRequest);
        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("model", "text-davinci-003");
            jsonBody.put("prompt", userRequest);
            jsonBody.put("max_tokens", 4055);
            jsonBody.put("temperature", 0);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        RequestBody body = RequestBody.create(jsonBody.toString(), JSON);
        Request request = new Request.Builder()
                .url(Api.API_URL)
                .header("Authorization", "Bearer " + Api.API_KEY)
                .post(body)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Toast.makeText(getActivity(), "Failed to load data", Toast.LENGTH_SHORT).show();
                getMainActivity().openIngredientsAndWishesFragment();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                if (response.isSuccessful()) {
                    JSONObject jsonObject;
                    try {
                        jsonObject = new JSONObject(response.body().string());
                        JSONArray jsonArray = jsonObject.getJSONArray("choices");
                        String answerGPT = jsonArray.getJSONObject(0).getString("text");
                        Log.d("GPTTEST", "SUCCESSFUL " + answerGPT);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }

                } else {
                    Log.d("GPTTEST", "FAIL " + response.body().string());
                    getMainActivity().openIngredientsAndWishesFragment();
                }
            }
        });
    }

}
