package bhouse.travellist;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by Nazmul on 3/24/2016.
 */
public class StartFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;
    private TravelListAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        View inflatedView = inflater.inflate(R.layout.start_fragment, container, false);
        mRecyclerView = (RecyclerView) inflatedView.findViewById(R.id.list);
        mRecyclerView.setLayoutManager(mStaggeredLayoutManager);
        mRecyclerView.setHasFixedSize(true); //Data size is fixed - improves performance
        mAdapter = new TravelListAdapter(getActivity());
        mRecyclerView.setAdapter(mAdapter);
        try {
            int span = getArguments().getInt("grid", 0);
            mStaggeredLayoutManager.setSpanCount(span);
           /* FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.detach(this).attach(this).commit();*/
            Toast.makeText(getActivity(), String.valueOf(span), Toast.LENGTH_SHORT).show();
        } catch (Exception e) {

        }
        return inflatedView;
    }

}
