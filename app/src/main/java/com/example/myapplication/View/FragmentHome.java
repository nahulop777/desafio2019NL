package com.example.myapplication.View;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.myapplication.Controller.Controller;
import com.example.myapplication.Dao.Dao;
import com.example.myapplication.R;
import com.example.myapplication.model.User;
import com.example.myapplication.model.UserContainer;
import com.example.myapplication.utils.ResultListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FragmentHome extends Fragment implements AdapterUser.UserAdapterListener {


        @BindView(R.id.recyclerViewHomeFragment)
        RecyclerView recyclerViewHomeFragment;
        @BindView(R.id.progressBar)
        ProgressBar progressBar;
        @BindView(R.id.swipeRefreshLayout)
        SwipeRefreshLayout swipeRefreshLayout;
        @BindView(R.id.searchView)
        SearchView searchView;
        @BindView(R.id.listView)
        ListView listView;


        private List<User> userList = new ArrayList<>();
        private ArrayAdapter<String> arrayAdapter;
        private Map<String, User> nickMap = new HashMap<>();
        private List<String> nickList = new ArrayList<>();
        private List<String> arrayItems = new ArrayList<>();
        private notificador unNotificador;

    public FragmentHome() {
        // Required empty public constructor
    }



    @Override
        public void onAttach(Context context) {
            super.onAttach(context);
            this.unNotificador = (notificador) context;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment_home, container, false);
            ButterKnife.bind(this, view);

            showProgressView();
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
            recyclerViewHomeFragment.setLayoutManager(layoutManager);

            Controller controller = new Controller();
            callAPI(controller);

            refresh(controller);


            arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, nickList);
            listView.setAdapter(arrayAdapter);

            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {

                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    arrayAdapter.getFilter().filter(newText);
                    listView.setVisibility(View.VISIBLE);
                    if (newText.equals("")) listView.setVisibility(View.GONE);
                    return false;
                }
            });


            return view;
        }

    public void callAPI(Controller peopleController) {
        peopleController.getList(new ResultListener<UserContainer>() {
            @Override
            public void onFinish(UserContainer result) {
                userList = result.getResults();
                hideProgressView();
                AdapterUser adapterUser = new AdapterUser(userList, FragmentHome.this);
                recyclerViewHomeFragment.setAdapter(adapterUser);
                swipeRefreshLayout.setRefreshing(false);
                Toast.makeText(getContext(), "Exito", Toast.LENGTH_SHORT).show();
                recyclerViewHomeFragment.setHasFixedSize(true);
                recyclerViewHomeFragment.setItemViewCacheSize(20);
                for (User person : userList) {
                    String nick = person.getLogin().getUsername();
                    nickMap.put(nick, person);
                    nickList.add(nick);
                }
                itemClick();

            }
        });
    }


        private void itemClick() {
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String listItem = (String) parent.getAdapter().getItem(position);
                    User user = nickMap.get(listItem);
                    Bundle bundle = new Bundle();
                    Intent intent = new Intent(getActivity(), DetalleActivity.class);
                    bundle.putSerializable(DetalleActivity.KEY_USER, user);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
        }



    @Override
    public void usuarioElegido(User user) {
        unNotificador.mandarNotificacion(user);
    }



    public interface notificador {
        public void mandarNotificacion(User user);
    }


    void showProgressView() {
        progressBar.setVisibility(View.VISIBLE);
    }

    void hideProgressView() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    public void refresh(final Controller controller) {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                userList.clear();
                FragmentHome.this.callAPI(controller);
            }
        });
    }


}
