package ryses.virtual.app;

import android.app.*;
import mpop.utils.toast;
import mpop.*;
public class A extends Application
{

	@Override
	public void onCreate()
	{
		super.onCreate();
		if(utils.application.uninstall(this,"com.gmail.heagoo.apkeditor.pro")){
		}else{
			toast.makeText(this,"Simply Developed by RySes",toast.S);
		}
		
	}
	
}
