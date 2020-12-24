package com.example.wechatapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;

import java.util.ArrayList;
import java.util.List;

/*  步骤要点：
 * 第一步，注册开发者账号并获取API Key
 * 第二步，下载SDK并在应用中完成相关配置
 *  1. 解压下载的SDK包，将libs文件夹中所有文件拷贝到项目app->libs目录中
 *  2. 配置build.gradle文件，在android项中添加sourceSets设置
 *  3. 配置AndroidManifest.xml文件：设置API Key；声明定位service；声明权限（运行时权限申请）
 * 第三步，功能调用及实现
 *  功能一：获取定位信息
 *     1. 初始化LocationClient类
 *     2. 实现BDAbstractLocationListener接口
 *     3. 注册监听函数
 *     4. 利用LocationClientOption类配置定位SDK参数
 *     5. 调用LocationClient类的start()方法启动定位
 *     6. 在定位监听类的onReceiveLocation（）方法中获取定位信息并显示
 * */

public class LocateMainActivity extends AppCompatActivity {
    public LocationClient mLocationClient;
    private TextView positionText;
    private MapView mapView;
    private BaiduMap baiduMap;
    private boolean isFirstLocate = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*百度SDK的初始化操作必须在setContentView方法调用之前执行*/
        mLocationClient = new LocationClient(getApplicationContext());
        mLocationClient.registerLocationListener(new MyLocationListener());    /*注册监听函数*/

        SDKInitializer.initialize(getApplicationContext());

        setContentView(R.layout.locateactivity_main);
        positionText = findViewById(R.id.position_view);

        /*显示地图信息*/
        mapView = findViewById(R.id.bdMapView);
        baiduMap = mapView.getMap();
        baiduMap.setMyLocationEnabled(true);    /*开启设备位置显示功能*/

        List<String> permissionList = new ArrayList<>();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_WIFI_STATE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.ACCESS_WIFI_STATE);
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_NETWORK_STATE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.ACCESS_NETWORK_STATE);
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CHANGE_WIFI_STATE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.CHANGE_WIFI_STATE);
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (!permissionList.isEmpty()) {
            String[] permissions = permissionList.toArray(new String[permissionList.size()]);
            ActivityCompat.requestPermissions(this, permissions, 1);
        }else {
            requestLocation();
        }

    }

    private void requestLocation() {
        initLocation();
        mLocationClient.start();
    }

    private void initLocation() {
        LocationClientOption option = new LocationClientOption();
        option.setScanSpan(5000);
        option.setIsNeedAddress(true);   /*获取当前位置详细的地址信息*/
        /*设置定位模式，默认高精度:Hight_Accuracy；Battery_Saving：低功耗；Device_Sensors：仅使用设备*/
        option.setLocationMode(LocationClientOption.LocationMode.Battery_Saving);
        mLocationClient.setLocOption(option);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 1:
                if (grantResults.length > 0){
                    for (int result : grantResults){
                        if (result != PackageManager.PERMISSION_GRANTED){
                            Toast.makeText(this, "必须同意所有权限才能使用本程序", Toast.LENGTH_SHORT).show();
                            finish();
                            return;
                        }
                    }
                    requestLocation();
                }else {
                    Toast.makeText(this, "获取权限时发生未知错误", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
                break;
        }
    }

    public class MyLocationListener extends BDAbstractLocationListener {
        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            StringBuilder currentPosition = new StringBuilder();
            currentPosition.append("纬度： ").append(bdLocation.getLatitude()).append("\n");   //getLatitude()返回值为double类型
            currentPosition.append("经线： ").append(bdLocation.getLongitude()).append("\n");    //getLongitude()返回值为double类型
            currentPosition.append("国家： ").append(bdLocation.getCountry()).append("\n");
            currentPosition.append("省份： ").append( bdLocation.getProvince()).append("\n");
            currentPosition.append("城市： ").append(bdLocation.getCity()).append("\n");
            currentPosition.append("详细地址： ").append(bdLocation.getAddrStr()).append("\n");
            positionText.setText(currentPosition);

            /*将定位信息显示到地图上*/
            if (bdLocation.getLocType()  == BDLocation.TypeGpsLocation || bdLocation.getLocType() == BDLocation.TypeNetWorkLocation) {
                navigateTo(bdLocation);
            }
        }
    }

    private void navigateTo(BDLocation location) {
        if (isFirstLocate) {
            LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
            MapStatusUpdate mapStatusUpdate = MapStatusUpdateFactory.newLatLng(latLng);
            baiduMap.animateMapStatus(mapStatusUpdate);
            mapStatusUpdate = MapStatusUpdateFactory.zoomTo(16f);    /*设置缩放级别*/
            baiduMap.animateMapStatus(mapStatusUpdate);
            isFirstLocate = false;
        }
        /*将“我”显示在地图上*/
        MyLocationData.Builder locationBuilder = new MyLocationData.Builder();
        locationBuilder.latitude(location.getLatitude());
        locationBuilder.longitude(location.getLongitude());
        MyLocationData locationData = locationBuilder.build();
        baiduMap.setMyLocationData(locationData);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLocationClient.stop();
        mapView.onDestroy();
        baiduMap.setMyLocationEnabled(false);
    }
}
