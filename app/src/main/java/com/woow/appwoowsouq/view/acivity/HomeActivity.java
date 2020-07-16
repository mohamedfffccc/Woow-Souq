package com.woow.appwoowsouq.view.acivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.woow.appwoowsouq.R;
import com.woow.appwoowsouq.adapter.DepartmentAdapter;
import com.woow.appwoowsouq.adapter.MenuAdapter;
import com.woow.appwoowsouq.adapter.ProductAdapter;
import com.woow.appwoowsouq.adapter.SlideAdapter;
import com.woow.appwoowsouq.data.model.DepartmentItem;
import com.woow.appwoowsouq.data.model.MenuModel;
import com.woow.appwoowsouq.data.model.ProductItem;
import com.woow.appwoowsouq.view.acivity.auth.LoginActivity;
import com.woow.appwoowsouq.view.acivity.auth.Registratoin;
import com.woow.appwoowsouq.view.acivity.slied_bar.About_AppActivity;
import com.woow.appwoowsouq.view.acivity.slied_bar.AddProductActivity;
import com.woow.appwoowsouq.view.acivity.slied_bar.FavoriteActivity;
import com.woow.appwoowsouq.view.acivity.slied_bar.MyPurchasesActivity;
import com.woow.appwoowsouq.view.acivity.slied_bar.OffersActivity;
import com.woow.appwoowsouq.view.acivity.slied_bar.ProfileActivity;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.activity_home_iv_img_profile)
    CircleImageView activityHomeIvImgProfile;
    @BindView(R.id.activity_home_tv_name)
    TextView activityHomeTvName;
    @BindView(R.id.activity_home_tv_email)
    TextView activityHomeTvEmail;
    @BindView(R.id.activity_home_rl)
    RelativeLayout activityHomeRl;
    @BindView(R.id.activity_home_tv_department)
    TextView activityHomeTvDepartment;
    @BindView(R.id.activity_home_ln_1)
    LinearLayout activityHomeLn1;

    LinearLayout activityHomeLn8;
    @BindView(R.id.activity_home_btn_login)
    Button activityHomeBtnLogin;
    @BindView(R.id.activity_home_btn_register)
    Button activityHomeBtnRegister;
    @BindView(R.id.nav_view)
    NavigationView navView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.app_bar_hom_iv_navigation_view)
    ImageView appBarHomIvNavigationView;
    @BindView(R.id.app_bar_home_tv)
    TextView appBarHomeTv;
    @BindView(R.id.app_bar_hom_iv_view_list)
    ImageView appBarHomIvViewList;
    @BindView(R.id.app_bar_hom_iv_view_apps)
    ImageView appBarHomIvViewApps;
    @BindView(R.id.activity_home_lv_departments)
    ListView activityHomeLvDepartments;
    @BindView(R.id.activity_home_btn_show_department)
    ImageView activityHomeBtnShowDepartment;
    @BindView(R.id.app_bar_home_rv_product)
    RecyclerView appBarHomeRvProduct;
    @BindView(R.id.app_bar_home_vp_slider)
    ViewPager appBarHomeVpSlider;
    @BindView(R.id.activity_home_lv_menu)
    ListView activityHomeLvMenu;

    @BindView(R.id.app_bar_hom_iv_search)
    ImageView appBarHomIvSearch;


    ArrayList<DepartmentItem> department_list;
    DepartmentAdapter departmentAdapter;
    ProductAdapter product_adapter;
    GridLayoutManager product_layout_manger;
    ArrayList<ProductItem> products_list;
    ArrayList<Integer> slider_list;
    SlideAdapter slider_adapter;
    int current_position;
    private Timer timer;
    //menu
    ArrayList<MenuModel> menu_items;
    MenuAdapter menuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);


        setSupportActionBar(toolbar);
        addDepartment();

//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_app_bar_open_drawer_description,
//                R.string.navigation_drawer_close);
//        drawerLayout.setDrawerListener(toggle);
//        toggle.syncState();
        addProducts();
        addSlides();
        createSlideShow();
        addMenuItems();
        activityHomeLvMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                switch (position) {
                    case 0:
                        startActivity(new Intent(HomeActivity.this, OffersActivity.class));
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 1:
                        startActivity(new Intent(HomeActivity.this, MyPurchasesActivity.class));
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 2:
                        startActivity(new Intent(HomeActivity.this, FavoriteActivity.class));
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 3:
                        startActivity(new Intent(HomeActivity.this, ProfileActivity.class));
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 4:
                        startActivity(new Intent(HomeActivity.this, AddProductActivity.class));
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 5:
                        startActivity(new Intent(HomeActivity.this, About_AppActivity.class));
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 6:
                        break;
                }

            }
        });
        activityHomeLvDepartments.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                activityHomeLvDepartments.setVisibility(View.GONE);
                activityHomeBtnShowDepartment.setImageResource(R.drawable.ic_arrow_drop_down_black_24dp);
                drawerLayout.closeDrawer(GravityCompat.START);

            }
        });

    }

    private void addMenuItems() {
        menu_items = new ArrayList<>();
        menu_items.add(new MenuModel(this.getString(R.string.offers), R.drawable.ic_shopping));
        menu_items.add(new MenuModel(this.getString(R.string.my_purchases), R.drawable.ic_shopping));
        menu_items.add(new MenuModel(this.getString(R.string.favorite), R.drawable.ic_favorite));
        menu_items.add(new MenuModel(this.getString(R.string.profile), R.drawable.ic_person));
        menu_items.add(new MenuModel(this.getString(R.string.add_product), R.drawable.ic_add));
        menu_items.add(new MenuModel(this.getString(R.string.about_app), R.drawable.ic_about));
        menu_items.add(new MenuModel(this.getString(R.string.loguot), R.drawable.ic_loguot));
        menuAdapter = new MenuAdapter(menu_items, HomeActivity.this, HomeActivity.this);
        activityHomeLvMenu.setAdapter(menuAdapter);

    }

    private void addProducts() {
        product_layout_manger = new GridLayoutManager(this, 2);
        appBarHomeRvProduct.setLayoutManager(product_layout_manger);
        products_list = new ArrayList<>();
        products_list.add(new ProductItem(R.drawable.logo, "i phone X MAX", "i phone X MAX",
                4, 10000));
        products_list.add(new ProductItem(R.drawable.logo, "i phone X MAX", "i phone X MAX",
                4, 10000));
        products_list.add(new ProductItem(R.drawable.logo, "i phone X MAX", "i phone X MAX",
                4, 10000));
        products_list.add(new ProductItem(R.drawable.logo, "i phone X MAX", "i phone X MAX",
                4, 10000));
        products_list.add(new ProductItem(R.drawable.logo, "i phone X MAX", "i phone X MAX",
                4, 10000));
        products_list.add(new ProductItem(R.drawable.logo, "i phone X MAX", "i phone X MAX",
                4, 10000));
        products_list.add(new ProductItem(R.drawable.logo, "i phone X MAX", "i phone X MAX",
                4, 10000));
        products_list.add(new ProductItem(R.drawable.logo, "i phone X MAX", "i phone X MAX",
                4, 10000));
        products_list.add(new ProductItem(R.drawable.logo, "i phone X MAX", "i phone X MAX",
                4, 10000));
        products_list.add(new ProductItem(R.drawable.logo, "i phone X MAX", "i phone X MAX",
                4, 10000));
        products_list.add(new ProductItem(R.drawable.logo, "i phone X MAX", "i phone X MAX",
                4, 10000));
        products_list.add(new ProductItem(R.drawable.logo, "i phone X MAX", "i phone X MAX",
                4, 10000));
        products_list.add(new ProductItem(R.drawable.logo, "i phone X MAX", "i phone X MAX",
                4, 10000));
        products_list.add(new ProductItem(R.drawable.logo, "i phone X MAX", "i phone X MAX",
                4, 10000));
        products_list.add(new ProductItem(R.drawable.logo, "i phone X MAX", "i phone X MAX",
                4, 10000));
        products_list.add(new ProductItem(R.drawable.logo, "i phone X MAX", "i phone X MAX",
                4, 10000));
        products_list.add(new ProductItem(R.drawable.logo, "i phone X MAX", "i phone X MAX",
                4, 10000));
        products_list.add(new ProductItem(R.drawable.logo, "i phone X MAX", "i phone X MAX",
                4, 10000));
        products_list.add(new ProductItem(R.drawable.logo, "i phone X MAX", "i phone X MAX",
                4, 10000));

        product_adapter = new ProductAdapter(products_list, this, HomeActivity.this);
        appBarHomeRvProduct.setAdapter(product_adapter);

    }


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();

        }
    }

    @OnClick({R.id.activity_home_tv_department,R.id.app_bar_hom_iv_cart,R.id.app_bar_hom_iv_search,
            R.id.activity_home_btn_login, R.id.activity_home_btn_register, R.id.app_bar_hom_iv_navigation_view,
            R.id.app_bar_hom_iv_view_list, R.id.app_bar_hom_iv_view_apps})

    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.activity_home_tv_department:
//                startActivity(new Intent(HomeActivity.this, DepartmentActivity.class));
//                drawerLayout.closeDrawer(GravityCompat.START);
                if (activityHomeLvDepartments.getVisibility() == View.GONE) {
                    activityHomeBtnShowDepartment.setImageResource(R.drawable.ic_arrow_drop_up_black_24dp);
                    activityHomeLvDepartments.setVisibility(View.VISIBLE);
                } else if (activityHomeLvDepartments.getVisibility() == View.VISIBLE) {
                    activityHomeBtnShowDepartment.setImageResource(R.drawable.ic_arrow_drop_down_black_24dp);

                    activityHomeLvDepartments.setVisibility(View.GONE);
                }

                break;

//            case R.id.activity_home_tv_offers:
//                startActivity(new Intent(HomeActivity.this, OffersActivity.class));
//                drawerLayout.closeDrawer(GravityCompat.START);
//                break;

            case R.id.app_bar_hom_iv_navigation_view:

                drawerLayout.openDrawer(GravityCompat.START);

                break;


            case R.id.activity_home_btn_login:
                startActivity(new Intent(HomeActivity.this, LoginActivity.class));
                drawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.activity_home_btn_register:
                startActivity(new Intent(HomeActivity.this, Registratoin.class));
                drawerLayout.closeDrawer(GravityCompat.START);

                break;

            case R.id.app_bar_hom_iv_view_list:
                appBarHomIvViewList.setImageResource(R.drawable.ic_view_list_orang);
                appBarHomIvViewApps.setImageResource(R.drawable.ic_apps);

                break;

            case R.id.app_bar_hom_iv_view_apps:
                appBarHomIvViewApps.setImageResource(R.drawable.ic_apps_orang);
                appBarHomIvViewList.setImageResource(R.drawable.ic_view_list);

                break;
            case R.id.app_bar_hom_iv_cart:
                startActivity(new Intent(HomeActivity.this , CartActivity.class));
        }
    }

    //TODO add department
    public void addDepartment() {
        department_list = new ArrayList<>();
        department_list.add(new DepartmentItem("موبايلات"));
        department_list.add(new DepartmentItem("موبايلات"));
        department_list.add(new DepartmentItem("موبايلات"));
        department_list.add(new DepartmentItem("موبايلات"));
        department_list.add(new DepartmentItem("موبايلات"));
        department_list.add(new DepartmentItem("موبايلات"));
        department_list.add(new DepartmentItem("موبايلات"));
        department_list.add(new DepartmentItem("موبايلات"));
        department_list.add(new DepartmentItem("موبايلات"));
        department_list.add(new DepartmentItem("موبايلات"));
        department_list.add(new DepartmentItem("موبايلات"));
        department_list.add(new DepartmentItem("موبايلات"));
        department_list.add(new DepartmentItem("موبايلات"));
        department_list.add(new DepartmentItem("موبايلات"));
        department_list.add(new DepartmentItem("موبايلات"));
        department_list.add(new DepartmentItem("موبايلات"));
        department_list.add(new DepartmentItem("موبايلات"));
        department_list.add(new DepartmentItem("موبايلات"));

        departmentAdapter = new DepartmentAdapter(department_list, this, HomeActivity.this);
        activityHomeLvDepartments.setAdapter(departmentAdapter);


    }

    //add data to slider
    public void addSlides() {
        slider_adapter = new SlideAdapter(this);
        appBarHomeVpSlider.setAdapter(slider_adapter);
    }

    //Create Slide Show
    public void createSlideShow() {
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (current_position == slider_adapter.getCount())
                    current_position = 0;
                appBarHomeVpSlider.setCurrentItem(current_position++, true);

            }
        };
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);

            }
        }, 1000, 2500);

    }


}
