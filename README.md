# BroadCastsReceiver
* 因應 Android 8.0 以後新增的諸多限制所做的測試。

# 重點整理
* BroadCastsReveiver 註冊方式
  * AndroidManifest.xml 裡在 <application 中用 <receiver 註冊，或在 Activity 裡面 用 registerReceiver(YOUR_RECEIVER, IntentFilter) 註冊；
    * 8.0 注意事項：.xml裡註測時用 <intent-filter> 已經收不到大部分的 (implicit) 廣播，請寫在 Activity 裡。
    *              registerReceiver、unregisterReceiver時機。
    *              Permission。
    
* Permission 權限
  * 若發送端添加權限，則 AndroidManifest.xml 要有該 <uses-permission 權限 不然收不到。
  * 若發送端要添加權限，需在 AndroidManifest.xml 中在跟 <application 同層級的地方用 <permission android:name="YOUR_PERMISSION_NAME" 添加自訂權限，同時在sendBroadCast的時候要附帶 permission 名稱，例如 sendBroadCast(intent, "YOUR_PERMISSION_NAME")。
    * 缺一不可，少了任一項接收端就算有 user-permission 還是會收不到。
    
* 發送方式
  * sendBroadCast(Intent)、sendBroadCast(Intent, String)...
  * Intent附帶參數：
    * setAction(String) // String 為 broadCast的名稱，跟你在 IntentFilter裡設的一樣。
    * setComponent(ComponentName) // 指定要發給誰。

# 測試說明
* 在第一個頁面打字按送出會發出 broadcast
* 第二個頁面的 BroadcastReceiver 註冊並收到廣播後根據內容改變中間的文字內容。

# 參考資料
* Broadcasts overview - https://developer.android.com/guide/components/broadcasts#manifest-declared-receivers
* Android Broadcast 和 BroadcastReceiver的权限限制 - https://blog.csdn.net/javensun/article/details/7334230
