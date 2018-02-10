package com.example.ss16173.atmlocator.findatm.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ss16173.atmlocator.R;
import com.example.ss16173.atmlocator.branchlist.BranchListActivity;
import com.example.ss16173.atmlocator.findatm.FindATMContract;
import com.example.ss16173.atmlocator.findatm.presenter.ATMPresenterImpl;
import com.example.ss16173.atmlocator.model.ATMLocatorResponseDTO;

public class FindATMActivity extends AppCompatActivity implements FindATMContract.ATMView {

    private ProgressBar progressBar;

    private FindATMContract.ATMPresenter atmPresenter;
    private ATMLocatorResponseDTO atmLocatorResponseDTO;
    //LocationUtil locationService = new LocationUtil(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        atmPresenter = new ATMPresenterImpl();
        atmPresenter.setView(this);
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
    }

    @Override
    public void showSuccess() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showLoader() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoader() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showATMList(ATMLocatorResponseDTO atmLocatorResponseDTO) {
       // String json = "{\"errors\":[],\"locations\":[{\"state\":\"OH\",\"locType\":\"branch\",\"label\":\"Polaris\",\"address\":\"1121 Polaris Pkwy\",\"city\":\"Columbus\",\"zip\":\"43240\",\"name\":\"Polaris\",\"lat\":\"40.1439281\",\"lng\":\"-82.9912278\",\"bank\":\"Chase\",\"type\":\"Freestanding\",\"lobbyHrs\":[\"\",\"8:00-7:00\",\"8:00-7:00\",\"8:00-7:00\",\"8:00-7:00\",\"8:00-7:00\",\"9:00-2:00\"],\"driveUpHrs\":[\"\",\"8:00-7:00\",\"8:00-7:00\",\"8:00-7:00\",\"8:00-7:00\",\"8:00-7:00\",\"9:00-2:00\"],\"atms\":32,\"services\":[],\"phone\":\"6142176284\",\"distance\":0.27},{\"state\":\"OH\",\"locType\":\"atm\",\"label\":\"23 & HIGHBLUFFS\",\"address\":\"8211 N HIGH ST\",\"city\":\"COLUMBUS\",\"zip\":\"43235\",\"name\":\"23 & HIGHBLUFFS\",\"lat\":\"40.132308\",\"lng\":\"-83.016702\",\"bank\":\"Chase\",\"access\":\"DRIVE UP\",\"services\":[\"Open 24 hours\",\"Deposit ATM\",\"Audio-assisted ATM\",\"Deposit-friendly\"],\"languages\":[\"C\",\"E\",\"F\",\"G\",\"H\",\"I\",\"J\",\"K\",\"P\",\"Q\",\"R\",\"S\",\"T\",\"V\"],\"distance\":1.73},{\"state\":\"OH\",\"locType\":\"branch\",\"label\":\"Lewis Center\",\"address\":\"8681 Columbus Pike\",\"city\":\"Lewis Center\",\"zip\":\"43035\",\"name\":\"Lewis Center\",\"lat\":\"40.16614\",\"lng\":\"-83.02012\",\"bank\":\"Chase\",\"type\":\"Freestanding\",\"lobbyHrs\":[\"\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-2:00\"],\"driveUpHrs\":[\"\",\"8:00-6:00\",\"8:00-6:00\",\"8:00-6:00\",\"8:00-6:00\",\"8:00-6:00\",\"9:00-2:00\"],\"atms\":16,\"services\":[],\"phone\":\"7406578906\",\"distance\":1.99},{\"state\":\"OH\",\"locType\":\"atm\",\"label\":\"WORTHINGTON HILLS DU\",\"address\":\"7806 OLENTANGY RIVER RD\",\"city\":\"WORTHINGTON\",\"zip\":\"43085\",\"name\":\"WORTHINGTON HILLS DU\",\"lat\":\"40.123789\",\"lng\":\"-83.036119\",\"bank\":\"Chase\",\"access\":\"DRIVE UP\",\"services\":[\"Open 24 hours\",\"Deposit ATM\",\"Audio-assisted ATM\",\"Deposit-friendly\"],\"languages\":[\"C\",\"E\",\"F\",\"G\",\"H\",\"I\",\"J\",\"K\",\"P\",\"Q\",\"R\",\"S\",\"T\",\"V\"],\"distance\":2.91},{\"state\":\"OH\",\"locType\":\"branch\",\"label\":\"Worthington Square\",\"address\":\"50 W Wilson Bridge Rd\",\"city\":\"Worthington\",\"zip\":\"43085\",\"name\":\"Worthington Square\",\"lat\":\"40.1073\",\"lng\":\"-83.01737\",\"bank\":\"Chase\",\"type\":\"Freestanding\",\"lobbyHrs\":[\"\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-2:00\"],\"driveUpHrs\":[\"\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-2:00\"],\"atms\":16,\"services\":[],\"phone\":\"6142482660\",\"distance\":3.13},{\"state\":\"OH\",\"locType\":\"branch\",\"label\":\"Maxtown\",\"address\":\"875 N State St\",\"city\":\"Westerville\",\"zip\":\"43082\",\"name\":\"Maxtown\",\"lat\":\"40.149734\",\"lng\":\"-82.92326\",\"bank\":\"Chase\",\"type\":\"Freestanding\",\"lobbyHrs\":[\"\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-2:00\"],\"driveUpHrs\":[\"\",\"8:00-6:00\",\"8:00-6:00\",\"8:00-6:00\",\"8:00-6:00\",\"8:00-6:00\",\"9:00-2:00\"],\"atms\":16,\"services\":[],\"phone\":\"6142482640\",\"distance\":3.58},{\"state\":\"OH\",\"locType\":\"branch\",\"label\":\"Forest Park\",\"address\":\"1325 E Dublin-Granville Rd\",\"city\":\"Columbus\",\"zip\":\"43229\",\"name\":\"Forest Park\",\"lat\":\"40.08727\",\"lng\":\"-82.98163\",\"bank\":\"Chase\",\"type\":\"Freestanding\",\"lobbyHrs\":[\"\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-2:00\"],\"driveUpHrs\":[\"\",\"8:00-6:00\",\"8:00-6:00\",\"8:00-6:00\",\"8:00-6:00\",\"8:00-6:00\",\"9:00-2:00\"],\"atms\":16,\"services\":[],\"phone\":\"6142482610\",\"distance\":4.22},{\"state\":\"OH\",\"locType\":\"branch\",\"label\":\"Lewis Center Kroger\",\"address\":\"6417 Columbus Pike\",\"city\":\"Lewis Center\",\"zip\":\"43035\",\"name\":\"Lewis Center Kroger\",\"lat\":\"40.201696\",\"lng\":\"-83.029291\",\"bank\":\"Chase\",\"type\":\"In-Store\",\"lobbyHrs\":[\"\",\"10:00-7:00\",\"10:00-7:00\",\"10:00-7:00\",\"10:00-7:00\",\"10:00-7:00\",\"10:00-2:00\"],\"driveUpHrs\":[\"\",\"\",\"\",\"\",\"\",\"\",\"\"],\"atms\":0,\"services\":[],\"phone\":\"7405485080\",\"distance\":4.23},{\"state\":\"OH\",\"locType\":\"branch\",\"label\":\"Westerville South\",\"address\":\"77 Huber Village Blvd\",\"city\":\"Westerville\",\"zip\":\"43081\",\"name\":\"Westerville South\",\"lat\":\"40.10471\",\"lng\":\"-82.92303\",\"bank\":\"Chase\",\"type\":\"Freestanding\",\"lobbyHrs\":[\"\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-2:00\"],\"driveUpHrs\":[\"\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-2:00\"],\"atms\":24,\"services\":[],\"phone\":\"6142482650\",\"distance\":4.67},{\"state\":\"OH\",\"locType\":\"branch\",\"label\":\"Columbus Square\",\"address\":\"5681 Cleveland Ave\",\"city\":\"Columbus\",\"zip\":\"43231\",\"name\":\"Columbus Square\",\"lat\":\"40.08598\",\"lng\":\"-82.95138\",\"bank\":\"Chase\",\"type\":\"Freestanding\",\"lobbyHrs\":[\"\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-2:00\"],\"driveUpHrs\":[\"\",\"\",\"\",\"\",\"\",\"\",\"\"],\"atms\":24,\"services\":[],\"phone\":\"6142482430\",\"distance\":4.76},{\"state\":\"OH\",\"locType\":\"branch\",\"label\":\"Sawmill and Emerald Parkway\",\"address\":\"7675 Sawmill Rd\",\"city\":\"Dublin\",\"zip\":\"43016\",\"name\":\"Sawmill and Emerald Parkway\",\"lat\":\"40.12309\",\"lng\":\"-83.09011\",\"bank\":\"Chase\",\"type\":\"Freestanding\",\"lobbyHrs\":[\"\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-2:00\"],\"driveUpHrs\":[\"\",\"8:00-6:00\",\"8:00-6:00\",\"8:00-6:00\",\"8:00-6:00\",\"8:00-6:00\",\"9:00-2:00\"],\"atms\":16,\"services\":[],\"phone\":\"6147912025\",\"distance\":5.51},{\"state\":\"OH\",\"locType\":\"branch\",\"label\":\"Powell Rd\",\"address\":\"4066 W Powell Rd\",\"city\":\"Powell\",\"zip\":\"43065\",\"name\":\"Powell Rd\",\"lat\":\"40.158562\",\"lng\":\"-83.098113\",\"bank\":\"Chase\",\"type\":\"Freestanding\",\"lobbyHrs\":[\"\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-2:00\"],\"driveUpHrs\":[\"\",\"8:00-6:00\",\"8:00-6:00\",\"8:00-6:00\",\"8:00-6:00\",\"8:00-6:00\",\"9:00-2:00\"],\"atms\":16,\"services\":[],\"phone\":\"6142483315\",\"distance\":5.71},{\"state\":\"OH\",\"locType\":\"branch\",\"label\":\"Graceland\",\"address\":\"186 Graceland Blvd\",\"city\":\"Columbus\",\"zip\":\"43214\",\"name\":\"Graceland\",\"lat\":\"40.06592\",\"lng\":\"-83.02422\",\"bank\":\"Chase\",\"type\":\"In-Line\",\"lobbyHrs\":[\"\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-6:00\",\"\"],\"driveUpHrs\":[\"\",\"\",\"\",\"\",\"\",\"\",\"\"],\"atms\":8,\"services\":[],\"phone\":\"6142178310\",\"distance\":5.93},{\"state\":\"OH\",\"locType\":\"branch\",\"label\":\"Sawmill\",\"address\":\"3800 Tuller Rd\",\"city\":\"Dublin\",\"zip\":\"43017\",\"name\":\"Sawmill\",\"lat\":\"40.1054\",\"lng\":\"-83.09122\",\"bank\":\"Chase\",\"type\":\"Freestanding\",\"lobbyHrs\":[\"\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-2:00\"],\"driveUpHrs\":[\"\",\"8:00-6:00\",\"8:00-6:00\",\"8:00-6:00\",\"8:00-6:00\",\"8:00-6:00\",\"9:00-2:00\"],\"atms\":24,\"services\":[],\"phone\":\"6142482700\",\"distance\":6.06},{\"state\":\"OH\",\"locType\":\"branch\",\"label\":\"Morse Rd\",\"address\":\"1551 Morse Rd\",\"city\":\"Columbus\",\"zip\":\"43229\",\"name\":\"Morse Rd\",\"lat\":\"40.06048\",\"lng\":\"-82.9779\",\"bank\":\"Chase\",\"type\":\"Freestanding\",\"lobbyHrs\":[\"\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-6:00\",\"9:00-2:00\"],\"driveUpHrs\":[\"\",\"\",\"\",\"\",\"\",\"\",\"\"],\"atms\":24,\"services\":[],\"phone\":\"6142482550\",\"distance\":6.08}]}";
        Intent intent = new Intent(this, BranchListActivity.class);
        intent.putExtra("atmLocatorResponse", atmLocatorResponseDTO);
        startActivity(intent);
    }

    public void onClickBtn(View view) {
        String lat = getLat();
        String lng = getLong();
        atmPresenter.loadATMBranchesList(lat, lng);
    }

    public String getLat() {
        // return String.valueOf(locationService.getLatitude());
        return "32.891677";
    }


    public String getLong() {
        return "-96.947753";
        //return String.valueOf(locationService.getLongitude());
    }
}