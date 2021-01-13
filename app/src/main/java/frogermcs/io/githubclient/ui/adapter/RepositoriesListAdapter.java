package frogermcs.io.githubclient.ui.adapter;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import frogermcs.io.githubclient.ui.adapter.viewholder.RepositoryViewHolderNormal;
import java.util.ArrayList;
import java.util.List;

import frogermcs.io.githubclient.data.model.Repository;
import frogermcs.io.githubclient.ui.activity.RepositoriesListActivity;
import frogermcs.io.githubclient.ui.adapter.viewholder.RepositoryViewHolder;

/**
 * Created by Miroslaw Stanek on 24.04.15.
 */
public class RepositoriesListAdapter extends RecyclerView.Adapter {

    private RepositoriesListActivity repositoriesListActivity;

    private final List<Repository> repositories = new ArrayList<>();

    public RepositoriesListAdapter(RepositoriesListActivity repositoriesListActivity) {
        this.repositoriesListActivity = repositoriesListActivity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        final RecyclerView.ViewHolder viewHolder = new RepositoryViewHolderNormal(parent);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRepositoryItemClicked(viewHolder.getAdapterPosition());
            }
        });
        return viewHolder;
    }

    private void onRepositoryItemClicked(int adapterPosition) {
        repositoriesListActivity.onRepositoryClick(repositories.get(adapterPosition));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((RepositoryViewHolder) holder).bind(repositories.get(position));
    }

    @Override
    public int getItemCount() {
        return repositories.size();
    }

    @Override
    public int getItemViewType(int position) {
        Repository repository = repositories.get(position);
        return Repository.TYPE_NORMAL;
    }

    public void updateRepositoriesList(List<Repository> repositories) {
        this.repositories.clear();
        this.repositories.addAll(repositories);
        notifyDataSetChanged();
    }
}
