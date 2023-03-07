package se.pubq.sunmiprinting;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

import com.sunmi.extprinterservice.ExtPrinterService;

import java.nio.charset.StandardCharsets;

public class SunmiPrinter {
  Context myContext;
  ExtPrinterService ext;
  public SunmiPrinter(Context applicationContext) {
    myContext = applicationContext;
    Intent intent = new Intent();
    intent.setPackage("com.sunmi.extprinterservice");
    intent.setAction("com.sunmi.extprinterservice.PrinterService");
    var serviceConnection = new ServiceConnection() {
      @Override
      public void onServiceConnected(ComponentName componentName, IBinder service) {
        ext = ExtPrinterService.Stub.asInterface(service);
      }
      public void disconnectService(){
        myContext.unbindService(this);
      }
      @Override
      public void onServiceDisconnected(ComponentName componentName) {

      }
    };
    myContext.bindService(intent,serviceConnection,Context.BIND_AUTO_CREATE);
  }
  public boolean printString(String content) {
    try {
      ext.startTransBuffer();
      setFontZoom(1,1);

      ext.printText(content);
      ext.lineWrap(2);
      ext.cutPaper(1,2);
      ext.endTransBuffer();

    } catch (RemoteException e) {
      e.printStackTrace();
    }


    return true;
  }
  public void sendRawData(String content){
    try {
      ext.sendRawData(content.getBytes(StandardCharsets.UTF_8));
    } catch (RemoteException e) {
      e.printStackTrace();
    }
  }
  public void printText(String content){
    try {
      ext.printText(content);
    } catch (RemoteException e) {
      e.printStackTrace();
    }
  }
  public void startTransaction(){
    try {
      ext.startTransBuffer();
    } catch (RemoteException e) {
      e.printStackTrace();
    }
  }
  public void endTransaction(){
    try {
      ext.endTransBuffer();
    } catch (RemoteException e) {
      e.printStackTrace();
    }
  }
  public void setFontZoom(int hori,int veri){
    try {
      ext.setFontZoom(hori,veri);
    } catch (RemoteException e) {
      e.printStackTrace();
    }
  }
  public void cutPaper(int style, int rows){
    try {
      ext.cutPaper(style,rows);
    } catch (RemoteException e) {
      e.printStackTrace();
    }
  }
}

