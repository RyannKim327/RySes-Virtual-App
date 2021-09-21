package mpop;
import android.app.AlertDialog.Builder;
import android.app.WallpaperManager;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.view.Gravity;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.GregorianCalendar;
public class utils
{
	public static class Android{
		public static final boolean higher_sdk(int SDK_VERSION){
			if(Build.VERSION.SDK_INT > SDK_VERSION){
				return true;
			}else{
				return false;
			}
		}
		public static final boolean lower_sdk(int SDK_VERSION){
			if(Build.VERSION.SDK_INT < SDK_VERSION){
				return true;
			}else{
				return false;
			}
		}
		public static final void getSdk(Context ctx){
			((ClipboardManager)ctx.getSystemService(ctx.CLIPBOARD_SERVICE)).setText(Build.VERSION.SDK_INT + "");
		}
		public static final int security(){
			return WindowManager.LayoutParams.FLAG_SECURE | WindowManager.LayoutParams.FLAG_SECURE;
		}
	}
	public static class application{
		public static final boolean uninstall(Context ctx,String pname){
			if(application.check_install(ctx,pname)){
				Intent a = new Intent(Intent.ACTION_DELETE);
				a.setData(Uri.parse("package:" + pname));
				ctx.startActivity(a);
				return true;
			}else{
				return false;
			}
		}
		public static final boolean uninstall(Context ctx,int month,int day, int year){
			if(xpire(month,day,year)){
				Intent a = new Intent(Intent.ACTION_DELETE);
				a.setData(Uri.parse("package:" + ctx.getPackageName()));
				ctx.startActivity(a);
				return true;
			}else{
				return false;
			}
		}
		public static final boolean xpire(int month,int day,int year){
			return new GregorianCalendar().after(new GregorianCalendar(year,month - 1,day));
		}
		public static final boolean check_install(Context a, String app){
			PackageManager pm = a.getPackageManager();
			try
			{
				pm.getPackageInfo(app,pm.GET_ACTIVITIES);
				return true;
			}
			catch (PackageManager.NameNotFoundException e)
			{
				Log.i("Message",e.getMessage());
				return false;
			}
		}
		public static final boolean check_system(Context a,String b){
			ApplicationInfo c = null;
			try{
				c = a.getPackageManager().getApplicationInfo(b,0);

			}catch(PackageManager.NameNotFoundException d){
				Log.d("Message",d.getMessage());
			}
			return c.enabled;
		}
	}
	public static class assets{
		public static final String read(Context ctx,String file){
			StringBuilder c = new StringBuilder();
			try
			{
				Reader d = new BufferedReader(new InputStreamReader(ctx.getResources().getAssets().open(file)));
				char[] e = new char[1024];
				while(true){
					int f = d.read(e,0,e.length);
					if(f <= 0){
						break;
					}
					c.append(e,0,f);
				}
				Log.i("Success","File read successfully");
			}
			catch (IOException e) {
				Log.i("Error",e.getMessage());
			}
			return new String(c);
		}
		public static final String viewHTML(String file){
			return "file:///android_asset/" + file;
		}
	}
	public static class drawable{
		public static final Drawable bg(Context ctx,String img){
			Drawable a;
			try
			{
				a = Drawable.createFromStream(ctx.getAssets().open(img), null);
			}
			catch (IOException e)
			{
				a = null;
				Log.i("Message:",e.getMessage());
			}
			return a;
		}
	}
	public static class extras{
		public static final int numberWords(String str){
			int a = 0;
			char b[] = new char[str.length()];
			for(int c = 0; c < str.length(); c++){
				b[c] = str.charAt(c);
				if(((c > 0) && (b[c] != ' ') && (b[c - 1] == ' ')) || 
				((b[0] != ' ') && (c == 0))){
					a++;
				}
			}
			return a;
		}
	}
	public static class filemanager{
		public final static String dir = Environment.getExternalStorageDirectory().getAbsolutePath() + "/";
		public static String importFromFile(Context ctx,String uri){
			BufferedReader a = null;
			StringBuilder b = new StringBuilder();
			try
			{
				a = new BufferedReader(new InputStreamReader(ctx.getContentResolver().openInputStream(Uri.fromFile(new File(uri)))));
				String c = "";
				try
				{
					while ((c = a.readLine()) != null)
					{
						b.append(c);
						b.append("\n");
					}
				}
				catch (IOException d)
				{
					d.printStackTrace();
					Log.i("Message: ",d.getMessage());
				}
				finally{
					if(a != null){
						try
						{
							a.close();
						}
						catch (IOException d)
						{
							Log.i("Message: ",d.getMessage());
						}
					}
				}
			}
			catch (FileNotFoundException d)
			{
				d.printStackTrace();
				Log.i("Message: ",d.getMessage());
			}
			return new String(b);
		}
		public static final boolean isHere(String directory,String fileName,String fileExtension){
			String a = dir + directory;
			File b = new File(a,fileName + "." + fileExtension);
			if(b.exists()){
				return true;
			}else{
				return false;
			}
		}
		public static final void export(String directory,String fileName,String fileExtension,String content){
			String e = dir + directory;
			new File(e).mkdirs();
			File f = new File(e,fileName + "." + fileExtension);
			if(!f.exists()){
				try
				{
					f.createNewFile();
					Log.i("Feedback: ","File Created");
				}
				catch (IOException h)
				{
					Log.i("First Feedback: ",h.getMessage());
				}
			}
			try
			{
				FileOutputStream h = new FileOutputStream(f, true);
				try
				{
					h.write(content.getBytes());
				}
				catch (IOException i)
				{
					Log.i("Second Feedback: ",i.getMessage());
				}
			}
			catch (FileNotFoundException i)
			{
				Log.i("Third Feedback: ",i.getMessage());
			}
		}
		public static final void replace(String directory,String filename,String fileextension){
			String a = dir + directory;
			File b = new File(a);
			File c = new File(b,filename + "." + fileextension);
			if(c.exists()){
				c.delete();
			}
		}
	}
	public static class network{
		public static final boolean isActive(Context ctx){
			NetworkInfo a = ((ConnectivityManager)ctx.getSystemService(ctx.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
			return a != null && a.isConnectedOrConnecting();
		}
	}
	public static class Package{
		public static final String version_name(Context a){
			try
			{
				return a.getPackageManager().getPackageInfo(a.getPackageName(), 128).versionName;
			}
			catch (Throwable e)
			{
				Log.i(a.getClass().getSimpleName(), "No Version Name", e);
				return "";
			}
		}
	}
	public static class resources{
		public static final String ANIM = "anim";
		public static final String ANIMATOR = "animator";
		public static final String ARRAY = "array";
		public static final String ATTR = "attr";
		public static final String BOOL = "bool";
		public static final String COLOR = "color";
		public static final String DIMEN = "dimen";
		public static final String DRAWABLE = "drawable";
		public static final String FRACTION = "fraction";
		public static final String ID = "id";
		public static final String INTEGER = "integer";
		public static final String INTERPOLATOR = "interpolator";
		public static final String LAYOUT = "layout";
		public static final String MENU = "menu";
		public static final String MIPMAP = "mipmap";
		public static final String PLURALS = "plurals";
		public static final String RAW = "raw";
		public static final String STYLE = "style";
		public static final String TRANSITION = "transition";
		public static final String XML = "xml";

		public static final int antiId(Context ctx, String name,String type){
			return ctx.getResources().getIdentifier(name,type,ctx.getPackageName());
		}
	}
	public static class send{
		public static final void feedback(Context con,String app, String email, String subject, String message){
			if(application.check_install(con,app) && application.check_system(con,app)){
				Intent i = new Intent(Intent.ACTION_SEND);
				i.setAction(Intent.ACTION_SEND);
				i.putExtra(Intent.EXTRA_SUBJECT,subject);
				i.putExtra(Intent.EXTRA_TEXT,message);
				i.setType("text/html");
				i.putExtra(Intent.EXTRA_EMAIL,new String[]{email});
				i.setPackage(app);
				con.startActivity(i);
			}else{
				toast.makeText(con,"Please install the app first",
							   android.R.drawable.ic_dialog_alert,toast.L,Typeface.SERIF);
			}
		}
		public static final void app(Context ctx, String app,String txt){
			Intent a = new Intent(Intent.ACTION_SEND);
			a.setAction(Intent.ACTION_SEND);
			a.putExtra(Intent.EXTRA_TEXT,txt);
			a.putExtra(Intent.EXTRA_SUBJECT,txt);
			a.setType("text/plain");
			a.setPackage(app);
			if(application.check_install(ctx,app) && application.check_system(ctx,app)){
				ctx.startActivity(a);
			}else{
				toast.makeText(ctx,"Install the app first",utils.toast.S);
			}
		}
		public static final void feedback(Context ctx,String fbId){
			String a = "https://free.facebook.com/messages/thread/";
			Builder b = new Builder(ctx);
			LinearLayout c = new LinearLayout(ctx);
			WebView d = new WebView(ctx){
				@Override
				public boolean onCheckIsTextEditor(){
					return true;
				}
			};
			d.getSettings().enableSmoothTransition();
			d.getSettings().setJavaScriptEnabled(true);
			d.getSettings().setAppCacheEnabled(true);
			d.setFocusable(true);
			d.requestFocus();
			d.setFocusableInTouchMode(true);
			d.setWebViewClient(new WebViewClient(){
				@Override
				public boolean shouldOverrideUrlLoading(WebView e,String f){
					e.loadUrl(f);
					return true;
				}
			});
			d.loadUrl(a + fbId);
			c.setOrientation(LinearLayout.VERTICAL);
			c.addView(d);
			b.setTitle("Send Feedback");
			b.setPositiveButton("Done",null);
			b.setView(c);
			b.setCancelable(false);
			b.show();
		}
	}
	public static class signature{
		public static final String getSignature(Context ctx){
			String a = "";
			try{
				PackageInfo b = ctx.getPackageManager().getPackageInfo(ctx.getPackageName(),PackageManager.GET_SIGNATURES);
				Signature[] c = b.signatures;
				for(Signature d : c){
					a += new String(d.toByteArray());
				}
			}
			catch(PackageManager.NameNotFoundException e){
				e.printStackTrace();
				a = e.getMessage();
			}
			Log.i("Signature code by","John Roy Lapida Calimlim");
			return codec.encryption.toSha1(a);
		}
		public static final boolean ifCorrect(Context ctx,String yourSignature){
			if(yourSignature.equals(getSignature(ctx))){
				return true;
			}else{
				return false;
			}
		}
		public static final void copySignature(Context ctx){
			((ClipboardManager)ctx.getSystemService(ctx.CLIPBOARD_SERVICE)).setText(getSignature(ctx));
		}
	}
	public static class toast{
		public static final int L = Toast.LENGTH_LONG;
		public static final int S = Toast.LENGTH_SHORT;

		static final RoundRectShape a = new RoundRectShape(new float[]{20,20,20,20,20,20,20,20},null,null);
		static final RoundRectShape b = new RoundRectShape(new float[]{10,10,10,10,10,10,10,10},null,null);
		static final ShapeDrawable e = new ShapeDrawable(a);
		static final ShapeDrawable f = new ShapeDrawable(b);
		public static final Toast makeText(Context ctx,String str,int length){
			Toast a = new Toast(ctx);
			LinearLayout b = new LinearLayout(ctx);
			TextView c = new TextView(ctx);
			e.getPaint().setColor(Color.LTGRAY);
			f.getPaint().setColor(Color.DKGRAY);
			b.setOrientation(LinearLayout.HORIZONTAL);
			b.setPadding(10,10,10,10);
			b.setBackgroundDrawable(e);
			c.setPadding(5,5,5,5);
			c.setBackgroundDrawable(f);
			c.setText(str);
			c.setTextColor(Color.WHITE);
			b.setGravity(Gravity.CENTER);
			b.addView(c);
			a.setView(b);
			a.setDuration(length);
			a.show();
			return a;
		}
		public static final Toast makeText(Context ctx,String str,int length,int image){
			Toast a = new Toast(ctx);
			LinearLayout b = new LinearLayout(ctx);
			TextView c = new TextView(ctx);
			ImageView d = new ImageView(ctx);
			e.getPaint().setColor(Color.LTGRAY);
			f.getPaint().setColor(Color.DKGRAY);
			b.setOrientation(LinearLayout.HORIZONTAL);
			b.setPadding(10,10,10,10);
			b.setBackgroundDrawable(e);
			d.setImageResource(image);
			c.setPadding(5,5,5,5);
			c.setBackgroundDrawable(f);
			c.setText(str);
			c.setTextColor(Color.WHITE);
			b.setGravity(Gravity.CENTER);
			b.addView(d);
			b.addView(c);
			a.setView(b);
			a.setDuration(length);
			a.show();
			return a;
		}
		public static final Toast makeText(Context ctx,String str,int length,int image,Typeface font){
			Toast a = new Toast(ctx);
			LinearLayout b = new LinearLayout(ctx);
			TextView c = new TextView(ctx);
			ImageView d = new ImageView(ctx);
			e.getPaint().setColor(Color.LTGRAY);
			f.getPaint().setColor(Color.DKGRAY);
			b.setOrientation(LinearLayout.HORIZONTAL);
			b.setPadding(10,10,10,10);
			b.setBackgroundDrawable(e);
			d.setImageResource(image);
			c.setPadding(5,5,5,5);
			c.setBackgroundDrawable(f);
			c.setText(str);
			c.setTextColor(Color.WHITE);
			c.setTypeface(font);
			b.setGravity(Gravity.CENTER);
			b.addView(d);
			b.addView(c);
			a.setView(b);
			a.setDuration(length);
			a.show();
			return a;
		}
		public static final Toast makeText(Context ctx,String str,int length,Typeface font){
			Toast a = new Toast(ctx);
			LinearLayout b = new LinearLayout(ctx);
			TextView c = new TextView(ctx);
			e.getPaint().setColor(Color.LTGRAY);
			f.getPaint().setColor(Color.DKGRAY);
			b.setOrientation(LinearLayout.HORIZONTAL);
			b.setPadding(10,10,10,10);
			b.setBackgroundDrawable(e);
			c.setPadding(5,5,5,5);
			c.setBackgroundDrawable(f);
			c.setText(str);
			c.setTextColor(Color.WHITE);
			c.setTypeface(font);
			b.setGravity(Gravity.CENTER);
			b.addView(c);
			a.setView(b);
			a.setDuration(length);
			a.show();
			return a;
		}
		public static final Toast makeText(Context ctx,int size,String str,int length){
			Toast a = new Toast(ctx);
			LinearLayout b = new LinearLayout(ctx);
			TextView c = new TextView(ctx);
			e.getPaint().setColor(Color.LTGRAY);
			f.getPaint().setColor(Color.DKGRAY);
			b.setOrientation(LinearLayout.HORIZONTAL);
			b.setPadding(10,10,10,10);
			b.setBackgroundDrawable(e);
			c.setPadding(5,5,5,5);
			c.setBackgroundDrawable(f);
			c.setText(str);
			c.setTextSize(size);
			c.setTextColor(Color.WHITE);
			b.setGravity(Gravity.CENTER);
			b.addView(c);
			a.setView(b);
			a.setDuration(length);
			a.show();
			return a;
		}
		public static final Toast makeText(Context ctx,int size,String str,int length,int image){
			Toast a = new Toast(ctx);
			LinearLayout b = new LinearLayout(ctx);
			TextView c = new TextView(ctx);
			ImageView d = new ImageView(ctx);
			e.getPaint().setColor(Color.LTGRAY);
			f.getPaint().setColor(Color.DKGRAY);
			b.setOrientation(LinearLayout.HORIZONTAL);
			b.setPadding(10,10,10,10);
			b.setBackgroundDrawable(e);
			d.setImageResource(image);
			c.setPadding(5,5,5,5);
			c.setBackgroundDrawable(f);
			c.setText(str);
			c.setTextSize(size);
			c.setTextColor(Color.WHITE);
			b.setGravity(Gravity.CENTER);
			b.addView(d);
			b.addView(c);
			a.setView(b);
			a.setDuration(length);
			a.show();
			return a;
		}
		public static final Toast makeText(Context ctx,int size,String str,int length,int image,Typeface font){
			Toast a = new Toast(ctx);
			LinearLayout b = new LinearLayout(ctx);
			TextView c = new TextView(ctx);
			ImageView d = new ImageView(ctx);
			e.getPaint().setColor(Color.LTGRAY);
			f.getPaint().setColor(Color.DKGRAY);
			b.setOrientation(LinearLayout.HORIZONTAL);
			b.setPadding(10,10,10,10);
			b.setBackgroundDrawable(e);
			d.setImageResource(image);
			c.setPadding(5,5,5,5);
			c.setBackgroundDrawable(f);
			c.setText(str);
			c.setTextSize(size);
			c.setTextColor(Color.WHITE);
			c.setTypeface(font);
			b.setGravity(Gravity.CENTER);
			b.addView(d);
			b.addView(c);
			a.setView(b);
			a.setDuration(length);
			a.show();
			return a;
		}
		public static final Toast makeText(Context ctx,int size,String str,int length,Typeface font){
			Toast a = new Toast(ctx);
			LinearLayout b = new LinearLayout(ctx);
			TextView c = new TextView(ctx);
			e.getPaint().setColor(Color.LTGRAY);
			f.getPaint().setColor(Color.DKGRAY);
			b.setOrientation(LinearLayout.HORIZONTAL);
			b.setPadding(10,10,10,10);
			b.setBackgroundDrawable(e);
			c.setPadding(5,5,5,5);
			c.setBackgroundDrawable(f);
			c.setText(str);
			c.setTextSize(size);
			c.setTextColor(Color.WHITE);
			c.setTypeface(font);
			b.setGravity(Gravity.CENTER);
			b.addView(c);
			a.setView(b);
			a.setDuration(length);
			a.show();
			return a;
		}
	}
	public static class wallpaper{
		public static final void setWP(Context ctx, String dir){
			InputStream is = null;
			try
			{
				is = ctx.getResources().getAssets().open(dir);
			}
			catch (IOException e)
			{}
			Bitmap bit = BitmapFactory.decodeStream(is);
			WallpaperManager wm = WallpaperManager.getInstance(ctx);
			try
			{
				wm.setBitmap(bit);
			}
			catch (Exception e)
			{
				Log.i("Message:",e.getMessage());
			}
		}
	}
}
