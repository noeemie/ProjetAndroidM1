package com.example.coloraddict;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class BluetoothActivity extends AppCompatActivity {
    private static final String TAG = "BluetoothActivity";

    CheckBox enable_bt, visible_bt;
    ImageView search_bt;
    //TextView name_bt;
    ListView listView;



    private BluetoothAdapter BA;
    private Set<BluetoothDevice> pairedDevices;

    public ArrayList<BluetoothDevice> mBTDevices = new ArrayList<>();

    BluetoothAdapter mBluetoothAdapter;
    Button btnEnableDisable_Discoverable;

    ArrayAdapter adapterName;
    ArrayAdapter adapterAddress;
    ArrayList listName= new ArrayList();
    ArrayList listAddress = new ArrayList();

    ListView lvNameNewDevices;
    ListView lvAddressNewDevices;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);

        enable_bt = findViewById(R.id.enable_bt);
        visible_bt = findViewById(R.id.visible_bt);
        search_bt = findViewById(R.id.search_bt);
        //name_bt = findViewById(R.id.name_bt);
        listView = findViewById(R.id.list_bt);
        lvNameNewDevices = findViewById(R.id.lvNameNewDevices);
        lvAddressNewDevices = findViewById(R.id.lvAddressNewDevices);

        //name_bt.setText(getLocalBluetoothName());

        BA = BluetoothAdapter.getDefaultAdapter();

        mBTDevices = new ArrayList<>();

        if (BA == null){
            Toast.makeText(this, "Bluetooth not supported", Toast.LENGTH_SHORT).show();
            finish();
        }

        if (BA.isEnabled()){
            enable_bt.setChecked(true);
        }

        /*
        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
        registerReceiver(mBroadcastReceiver1, filter); */

        enable_bt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked){
                    BA.disable();
                    Toast.makeText(BluetoothActivity.this, "Eteint", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intentOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(intentOn, 0);
                    Toast.makeText(BluetoothActivity.this, "Allumé", Toast.LENGTH_SHORT).show();
                }
            }
        });

        visible_bt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Intent getVisible = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                    startActivityForResult(getVisible, 0);
                    Toast.makeText(BluetoothActivity.this, "Visible pendant 2 min", Toast.LENGTH_SHORT).show();
                }
            }
        });

        search_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list();
            }
        });
    }

    @Override
    protected void onDestroy() {
        Log.d("BluetoothActivity", "onDestroy: called.");
        super.onDestroy();
        unregisterReceiver(receiver);
        mBluetoothAdapter.cancelDiscovery();
        //unregisterReceiver(mBroadcastReceiver3);
        //mBluetoothAdapter.cancelDiscovery();
    }

    /**
     *Create a BroadcastReceiver for ACTION_FOUND.
     */
    private final BroadcastReceiver receiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {

                //listNom = new ArrayList();

                // Discovery has found a device. Get the BluetoothDevice
                // object and its info from the Intent.
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                String deviceName = device.getName();
                String deviceHardwareAddress = device.getAddress(); // MAC address

                listName.add(deviceName);
                listAddress.add(deviceHardwareAddress);
                adapterName = new ArrayAdapter(context, android.R.layout.simple_list_item_1, listName);
                adapterAddress = new ArrayAdapter(context, android.R.layout.simple_list_item_1, listAddress);
                lvNameNewDevices.setAdapter(adapterName);
                lvAddressNewDevices.setAdapter(adapterAddress);
            }
        }
    };




    /*
    /**
     * Broadcast Receiver for listing devices that are not yet paired
     * -Executed by btnDiscover() method.
     */ /*
    private BroadcastReceiver mBroadcastReceiver3 = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Log.d(TAG, "onReceive: ACTION FOUND.");

            if (action.equals(BluetoothDevice.ACTION_FOUND)){
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                mBTDevices.add(device);
                Log.d(TAG, "onReceive: " + device.getName() + ": " + device.getAddress());
                mDeviceListAdapter = new DeviceListAdapter(context, R.layout.device_adapter_view, mBTDevices);
                lvNewDevices.setAdapter(mDeviceListAdapter);
            }
        }
    }; */


    /*
    private final BroadcastReceiver mBroadcastReceiver1 = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            final String action = intent.getAction();

            if(action.equals(BluetoothDevice.ACTION_BOND_STATE_CHANGED)){
                BluetoothDevice mDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                mBTDevices.add(mDevice);
                // 3 cas
                // cas 1: dejabond
                if(mDevice.getBondState() == BluetoothDevice.BOND_BONDED){
                    Log.d("BluetoothActivity", "BroadcastReceiver: BOND_BONDED.");
                }
                // cas 2 : creer un bond
                if(mDevice.getBondState() == BluetoothDevice.BOND_BONDING){
                    Log.d("BluetoothActivity", "BroadcastReceiver: BOND_BONDING.");
                }
                // cas 3 : detruire un bond
                if(mDevice.getBondState() == BluetoothDevice.BOND_NONE){
                    Log.d("BluetoothActivity", "BroadcastReceiver: BOND_NONE.");
                }
            }
        }
    }; */


    /**
     * Is used for displaying already bonded devices
     */
    private void list() {
        pairedDevices = BA.getBondedDevices();

        ArrayList list = new ArrayList();

        for (BluetoothDevice bt : pairedDevices){
            list.add(bt.getName());
        }

        Toast.makeText(this, "Affichage des appareils", Toast.LENGTH_SHORT).show();

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
    }




    /*
    public String getLocalBluetoothName(){
        if (BA == null){
            BA = BluetoothAdapter.getDefaultAdapter();
        }
        String name = BA.getName();
        if (name == null){
            name = BA.getAddress();
        }

        return name;
    }
    */
    /*
    @Override
    public void onItemClick(AdapterView<?> adapteurView, View view, int i, long l) {
        BA.cancelDiscovery();

        Log.d("BluetoothActivity", "onItemClick: appuyé sur un appareil");
        String deviceName =mBTDevices.get(i).getName();
        String deviceAddress = mBTDevices.get(i).getAddress();

        Log.d("BluetoothActivity", "onItemClick: deviceName = " + deviceName );
        Log.d("BluetoothActivity", "onItemClick: deviceAdress = " + deviceAddress );

        //creer le bond
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.JELLY_BEAN_MR2){
            Log.d("BluetoothActivity", "Tentative de pairage avec " + deviceName);
            mBTDevices.get(i).createBond();
        }
    }
    */

    /**
     * Function called when the "Discover" button is pressed.
     * Display nearby discoverable devices' names and addresses
     */
    public void btnDiscover(View view) {
        Log.d(TAG, "btnDiscover: Looking for unpaired devices.");

        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if(mBluetoothAdapter.isDiscovering()) {
            mBluetoothAdapter.cancelDiscovery();
            Log.d(TAG, "btnDiscover: Canceling discovery.");
        }

        listName = new ArrayList();
        listAddress = new ArrayList();

        //check BT permissions in manifest
        checkBTPermissions();

        mBluetoothAdapter.startDiscovery();
        IntentFilter discoverDevicesIntent = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(receiver, discoverDevicesIntent);
        mBluetoothAdapter.cancelDiscovery();
    }

    /**
     * This method is required for all devices running API23+
     * Android must programmatically check the permissions for bluetooth. Putting the proper permissions
     * in the manifest is not enough.
     *
     * NOTE: This will only execute on versions > LOLLIPOP because it is not needed otherwise.
     */
    private void checkBTPermissions() {
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP){
            int permissionCheck = this.checkSelfPermission("Manifest.permission.ACCESS_FINE_LOCATION");
            permissionCheck += this.checkSelfPermission("Manifest.permission.ACCESS_COARSE_LOCATION");
            if (permissionCheck != 0) {

                this.requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 1001); //Any number
            }
        }else{
            Log.d("BluetoothActivity", "checkBTPermissions: No need to check permissions. SDK version < LOLLIPOP.");
        }
    }
}