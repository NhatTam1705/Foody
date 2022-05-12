package hcmute.nguyennhattam.mssv19110283.foodyapplication.activity;

import androidx.fragment.app.Fragment;

public interface IMainAdminActivity {
    void loadFragment(Fragment fragment);
    void sendSms(String toPhoneNumber, String message);
}
