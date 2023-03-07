package se.pubq.sunmiprinting;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "SunmiPrinter")
public class SunmiPrinterPlugin extends Plugin {
  private SunmiPrinter implementation;


    @Override
    public void load(){
      implementation = new SunmiPrinter(this.getActivity().getApplicationContext());
    }
    @PluginMethod
    public void printString(PluginCall call){
      String content = call.getString("contents");
      JSObject ret = new JSObject();
      ret.put("value",implementation.printString(content));
      call.resolve(ret);
    }
    @PluginMethod
    public void startTransaction(PluginCall call){
      implementation.startTransaction();
      call.resolve();
    }
    @PluginMethod
    public void endTransaction(PluginCall call){
      implementation.endTransaction();
      call.resolve();
    }
    @PluginMethod
    public void sendRawData(PluginCall call){
      String content = call.getString("content");
      implementation.sendRawData(content);
      call.resolve();
    }
    @PluginMethod
    public void printText(PluginCall call){
      String content = call.getString("content");
      implementation.printText(content);
      call.resolve();
    }
    @PluginMethod
    public void setFontZoom(PluginCall call){
      var hori = call.getInt("hori");
      var veri = call.getInt("veri");
      implementation.setFontZoom(hori,veri);
      call.resolve();
    }
    @PluginMethod
    public void cutPaper(PluginCall call){
      var style = call.getInt("style");
      var rows = call.getInt("rows");
      implementation.cutPaper(style,rows);
      call.resolve();
    }

}
