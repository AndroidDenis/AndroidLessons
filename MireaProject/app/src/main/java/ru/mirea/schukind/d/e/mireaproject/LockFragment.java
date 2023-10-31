package ru.mirea.schukind.d.e.mireaproject;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.List;

import ru.mirea.schukind.d.e.mireaproject.databinding.FragmentLockBinding;

public class LockFragment extends Fragment {

    FragmentLockBinding binding;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private RecyclerView recyclerView;
    private List<ApplicationInfo> appList;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private Context mContext;


    public LockFragment() {
        // Required empty public constructor
    }

    public static LockFragment newInstance(String param1, String param2) {
        LockFragment fragment = new LockFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentLockBinding.inflate(inflater, container, false);
        View v = binding.getRoot();
        mContext = inflater.getContext();
        PackageManager packageManager = mContext.getPackageManager();
        List<ApplicationInfo> installedApplications = packageManager.getInstalledApplications(0);

        for (ApplicationInfo applicationInfo : installedApplications) {
            String packageName = applicationInfo.packageName;
            Log.d("Package Name", "Package Name: " + packageName);
        }
        //
        PackageManager packageManager2 = mContext.getPackageManager();
        try {
            packageManager2.getPackageInfo("com.anydesk.anydeskandroid", PackageManager.GET_ACTIVITIES);
            Log.d("AnyDesk", "AnyDesk установлен на устройстве");
        } catch (PackageManager.NameNotFoundException e) {
            Log.d("AnyDesk", "AnyDesk не установлен на устройстве");
        }
        return v;
    }
}
