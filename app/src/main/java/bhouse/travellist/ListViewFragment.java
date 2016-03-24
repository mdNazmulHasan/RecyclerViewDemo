package bhouse.travellist;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListViewFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;
    private TravelAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        View inflatedView = inflater.inflate(R.layout.fragment_list, container, false);
        mRecyclerView = (RecyclerView) inflatedView.findViewById(R.id.listAnother);
        mRecyclerView.setLayoutManager(mStaggeredLayoutManager);
        mRecyclerView.setHasFixedSize(true); //Data size is fixed - improves performance
        mAdapter = new TravelAdapter(getActivity());
        mRecyclerView.setAdapter(mAdapter);
        return inflatedView;
    }

}
