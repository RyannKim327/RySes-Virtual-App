package ryses.virtual.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ActionMenuView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import mpop.class_name.card.Button_view;
import mpop.class_name.card.Edit_text;
import mpop.class_name.card.Linear_layout;
import mpop.codec;
import mpop.utils;

public class B extends Activity
{
	SharedPreferences a;
	Linear_layout aV,aH;
	Edit_text aT,aE;
	Button_view ok;
	LinearLayout.LayoutParams params;
	Spinner SP;
	TextView tv5,tv;
	SpinnerAdapter SPA;
	String[] strArr = new String[]{
		"String to Ascii",
		"String to Base64",
		"String to Binary",
		"String to Hex",
		"String to MD5",
		"String to Morse Code",
		"String to SHA-1",
		"String to SHA-256",
		"Base64 to String",
		"Binary to String",
		"Hex to String",
		"Reverse String"
	};
	String data;
	String sharedPref = "Mang KaKnorr Cubes";
	String basement = "military output";
	String scb1 = "cb1";
	String db1 = "Data1";
	String db2 = "Data2";
	String db3 = "Color Shade";
	int month = 5;
	int date = 1;
	int year = 2021;
	String directory = "Android/data/.confirmation";
	String filename = "FileX";
	String extension = "null";
	String content = "This is the confirmation for installment " + utils.Package.version_name(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setTheme(android.R.style.Theme_DeviceDefault);
		i();
		utils.toast.makeText(this,"Developed by Ryann Kim Sesgundo",utils.toast.S);
		//getWindow().addFlags(utils.Android.security());
	}
	void A(){
		String str = aE.getText().toString();
		switch(a.getString(basement,"Reverse String")){
			case "String to Ascii":
				aE.setText(codec.ascii.toAscii(aT.getText().toString()));
			break;
			case "String to Base64":
				aE.setText(codec.base64.toBase64(aT.getText().toString()));
			break;
			case "String to Binary":
				aE.setText(codec.binary.toBinary(aT.getText().toString()));
			break;
			case "String to Hex":
				aE.setText(codec.hex.toHex(aT.getText().toString()));
			break;
			case "String to MD5":
				aE.setText(codec.encryption.toMD5(aT.getText().toString()));
			break;
			case "String to Morse Code":
				aE.setText(codec.morse.toMorse(aT.getText().toString()));
			break;
			case "String to SHA-1":
				aE.setText(codec.encryption.toSha1(aT.getText().toString()));
			break;
			case "String to SHA-256":
				aE.setText(codec.encryption.toSha256(aT.getText().toString()));
			break;
			case "Base64 to String":
				aT.setText(codec.base64.toString(str));
			break;
			case "Binary to String":
				aT.setText(codec.binary.toString(str));
			break;
			case "Hex to String":
				aT.setText(codec.hex.toString(str.replace(" ","")));
			break;
			case "Reverse String":
				aE.setText(codec.specials.reverse(aT.getText().toString()));
			break;
			default:
				utils.toast.makeText(this,"Default",utils.toast.S);
			break;
		}
	}
	void B(){
		switch(a.getString(basement,"Reverse String")){
			case "String to Ascii":
				aE.setEnabled(false);
				aT.setEnabled(true);
			break;
			case "String to Base64":
				aE.setEnabled(false);
				aT.setEnabled(true);
			break;
			case "String to Binary":
				aE.setEnabled(false);
				aT.setEnabled(true);
			break;
			case "String to Hex":
				aE.setEnabled(false);
				aT.setEnabled(true);
			break;
			case "String to MD5":
				aE.setEnabled(false);
				aT.setEnabled(true);
			break;
			case "String to Morse Code":
				aE.setEnabled(false);
				aT.setEnabled(true);
			break;
			case "String to SHA-1":
				aE.setEnabled(false);
				aT.setEnabled(true);
			break;
			case "String to SHA-256":
				aE.setEnabled(false);
				aT.setEnabled(true);
			break;
			case "Base64 to String":
				aT.setEnabled(false);
				aE.setEnabled(true);
			break;
			case "Binary to String":
				aT.setEnabled(false);
				aE.setEnabled(true);
			break;
			case "Hex to String":
				aT.setEnabled(false);
				aE.setEnabled(true);
			break;
			case "Reverse String":
				aE.setEnabled(false);
				aT.setEnabled(true);
			break;
			default:
				utils.toast.makeText(this,"Default",utils.toast.S);
			break;
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.b,menu);
		return super.onCreateOptionsMenu(menu);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch(item.getItemId()){
			case R.id.clear:
				aT.setText("");
				aE.setText("");
			break;
			case R.id.settings:
				C();
			break;
			case R.id.about:
				E();
			break;
			case R.id.feedback:
				h();
			break;
			case R.id.share:
				utils.send.app(this,"com.facebook.lite","http://txti.es/rysesvirtualapp");
			break;
			case R.id.update:
				startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://txti.es/RySesVirtualApp")));
			break;
			case R.id.save:
				G();
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	void C(){
		AlertDialog.Builder bui = new AlertDialog.Builder(this);
		final LinearLayout ll = new LinearLayout(this);
		final CheckBox cb = new CheckBox(this);
		final CheckBox cb1 = new CheckBox(this);
		final CheckBox cb2 = new CheckBox(this);
		final EditText et1 = new EditText(this);
		bui.setTitle("Configurations");
		ll.setOrientation(LinearLayout.VERTICAL);
		cb.setChecked(a.getBoolean(scb1,false));
		cb.setText("Saved Strings");
		cb1.setChecked(a.getBoolean("E X I T",true));
		cb1.setText("Confirm Exit");
		cb2.setChecked(a.getBoolean("Ctrl C+V",false));
		cb2.setText("Copy converts");
		et1.setHint("Use hex code 0-9 a-f with the patter aarrggbb");
		et1.setText(a.getString(db3,"ff00aaff"));
		et1.setSingleLine();
		ll.addView(cb);
		ll.addView(cb1);
		ll.addView(cb2);
		ll.addView(et1);
		bui.setView(ll);
		bui.setPositiveButton("DONE", new DialogInterface.OnClickListener(){
				@Override
				public void onClick(DialogInterface p1, int p2)
				{
					if(cb.isChecked()){
						a.edit().putBoolean(scb1,true).commit();
					}else{
						a.edit().putBoolean(scb1,false).commit();
					}
					if(cb1.isChecked()){
						a.edit().putBoolean("E X I T",true).commit();
					}else{
						a.edit().putBoolean("E X I T",false).commit();
					}
					if(cb2.isChecked()){
						a.edit().putBoolean("Ctrl C+V",true).commit();
					}else{
						a.edit().putBoolean("Ctrl C+V",false).commit();
					}
					a.edit().putString(db3,et1.getText().toString()).commit();
					a();
				}
			});
		bui.setNegativeButton("CANCEL",null);
		bui.setCancelable(false);
		bui.show();
	}
	void D(){
		if(a.getBoolean(scb1,false) == true){
			a.edit().putString(db1,aT.getText().toString())
			.putString(db2,aE.getText().toString()).commit();
		}
	}
	void E(){
		AlertDialog.Builder bui = new AlertDialog.Builder(this);
		final ScrollView sv = new ScrollView(this);
		final TextView tv = new TextView(this);
		bui.setTitle("About");
		tv.setPadding(10,15,10,15);
		tv.setText(utils.assets.read(this,"about/a"));
		tv.setTypeface(Typeface.MONOSPACE);
		sv.addView(tv);
		bui.setView(sv);
		bui.setNeutralButton("OK",null);
		bui.setCancelable(false);
		bui.show();
	}
	void a(){
		a = PreferenceManager.getDefaultSharedPreferences(this);
		aV = new Linear_layout(this,Color.parseColor("#" + a.getString(db3,"ff00aaff")));
		aT = new Edit_text(this);
		aE = new Edit_text(this);
		ok = new Button_view(this);
		SP = new Spinner(this);
		tv5 = new TextView(this);
		tv = new TextView(this);
		SPA = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,strArr);
		params = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		params.weight = 0.5f;

		a.getString(basement,"Reverse String");

		aV.setOrientation(LinearLayout.VERTICAL);
		aT.setHint("Enter string here");
		aE.setHint("Enter encrypted string here");
		aT.setGravity(Gravity.TOP);
		aE.setGravity(Gravity.TOP);
		aT.setLayoutParams(params);
		aE.setLayoutParams(params);
		aT.setMaxHeight(aT.getLayoutParams().height);
		aE.setMaxHeight(aE.getLayoutParams().height);
		ok.setText("CONVERT");
		tv5.setText(" ");
		tv5.setTextSize(5);
		tv.setText(" ");
		tv.setTextSize(5);
		SP.setAdapter(SPA);
		SP.setSelection(a.getInt(sharedPref,11));

		if(a.getBoolean(scb1,false) == false){
			aT.setText("");
			aE.setText("");
		}else{
			aT.setText(a.getString(db1,""));
			aE.setText(a.getString(db2,""));
		}
		
		b();
		
		aV.addView(aT);
		aV.addView(tv5);
		aV.addView(aE);
		aV.addView(tv);
		aV.addView(ok);

		getActionBar().setDisplayShowCustomEnabled(true);
		getActionBar().setCustomView(SP);
		getActionBar().setTitle("Converter");
		getActionBar().setSubtitle("Developed by RySes");
		//getActionBar().setSubtitle(codec.ryses.toRySes3("RySes"));
		getActionBar().setBackgroundDrawable(new ColorDrawable(Color.DKGRAY));
		getActionBar().setHomeButtonEnabled(true);
		setContentView(aV);
	}
	void b(){
		SP.setOnItemSelectedListener(new OnItemSelectedListener(){
			@Override
			public void onItemSelected(AdapterView<?> p1, View p2, int p3, long p4)
			{
				a.edit().putInt(sharedPref,p3).commit();
				data = p1.getItemAtPosition(p3).toString();
				a.edit().putString(basement,data).commit();
				B();
				g();
			}
			@Override
			public void onNothingSelected(AdapterView<?> p1)
			{

			}
		});
		ok.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View p1)
			{
				D();
				if(aT.getText().toString().isEmpty()){
					aE.setText("");
				}else if(aE.getText().toString().isEmpty()){
					aT.setText("");
				}else{
					A();
				}
				if(aT.isEnabled() == false){
					aT.setEnabled(true);
					((ClipboardManager)getSystemService(CLIPBOARD_SERVICE)).setText(aT.getText().toString());
					
				}
				if(aE.isEnabled() == false){
					aE.setEnabled(true);
					((ClipboardManager)getSystemService(CLIPBOARD_SERVICE)).setText(aE.getText().toString());
				}
			}
		});
		aT.addTextChangedListener(new TextWatcher(){
			@Override
			public void beforeTextChanged(CharSequence p1, int p2, int p3, int p4)
			{
				D();
				g();
			}
			@Override
			public void onTextChanged(CharSequence p1, int p2, int p3, int p4)
			{
				D();
				g();
			}
			@Override
			public void afterTextChanged(Editable p1)
			{
				D();
				g();
			}
		});
		aE.addTextChangedListener(new TextWatcher(){
			@Override
			public void beforeTextChanged(CharSequence p1, int p2, int p3, int p4)
			{
				D();
			}
			@Override
			public void onTextChanged(CharSequence p1, int p2, int p3, int p4)
			{
				D();
			}
			@Override
			public void afterTextChanged(Editable p1)
			{
				D();
			}
		});
	}
	void c(){
		if(utils.Android.lower_sdk(19)){
			utils.application.uninstall(this,getPackageName());
			utils.toast.makeText(this,"For SDK 19 above ONLY",utils.toast.S,android.R.drawable.ic_lock_idle_lock);
			finish();
		}else{
			if(utils.application.uninstall(this,month,date,year)){
				finish();
			}
			a();
		}
	}
	void d(){
		AlertDialog.Builder b = new AlertDialog.Builder(this);
		final LinearLayout v = new LinearLayout(this);
		final ScrollView s = new ScrollView(this);
		final CheckBox c = new CheckBox(this);
		final TextView t = new TextView(this);
		String u = "Simplicity/";
		String w = "\n\n";
		v.setOrientation(LinearLayout.VERTICAL);
		v.setPadding(10,10,10,10);
		b.setTitle("What\'s New");
		b.setIcon(android.R.drawable.ic_dialog_info);
		t.setText(utils.assets.read(this,u + "0.5") + w + utils.assets.read(this,u + "0.4") + w + utils.assets.read(this,u + "0.3") + w + utils.assets.read(this,u + "0.2") + w + utils.assets.read(this, u + "0.1"));
		c.setText("Don\'t show again");
		c.setChecked(false);
		v.addView(t);
		v.addView(c);
		s.addView(v);
		b.setView(s);
		b.setPositiveButton("done", new DialogInterface.OnClickListener(){
				@Override
				public void onClick(DialogInterface p1, int p2)
				{
					if(c.isChecked()){
						a.edit().putBoolean(utils.Package.version_name(getBaseContext()),false).commit();
					}
				}
			});
		b.setCancelable(false);
		if(a.getBoolean(utils.Package.version_name(getBaseContext()),true)){
			b.show();
		}
	}
	void e(){
		if(utils.filemanager.isHere(directory,filename,extension)){
			f();
		}else{
			if(utils.network.isActive(this)){
				utils.filemanager.export(directory,filename,extension,content);
				f();
			}else{
				utils.toast.makeText(this,"Activate the your data first",utils.toast.S);
				finish();
			}
		}
	}
	void f(){
		String dir = utils.filemanager.dir + directory;
		String cont = utils.filemanager.importFromFile(this,dir);
		if(cont.equals(content)){
			c();
			d();
		}else{
			utils.filemanager.replace(directory,filename,extension);
			if(utils.network.isActive(this)){
				utils.filemanager.export(directory,filename,extension,content);
				c();
				d();
			}else{
				utils.toast.makeText(this,"Activate the your data first",utils.toast.S);
				finish();
			}
		}
	}
	@Override
	public void onBackPressed()
	{
		if(a.getBoolean("E X I T",true)){
			F();
		}else{
			super.onBackPressed();
		}
	}
	void F(){
		AlertDialog.Builder b = new AlertDialog.Builder(this);
		b.setTitle("Confirmation");
		b.setMessage("Would you like to exit to the app?");
		b.setPositiveButton("yes", new DialogInterface.OnClickListener(){
				@Override
				public void onClick(DialogInterface p1, int p2)
				{
					finishAffinity();
				}
			});
		b.setNegativeButton("no",null);
		b.setCancelable(false);
		b.show();
	}
	void g(){
		if(aT.getText().toString().isEmpty()){
			aE.setText("");
		}else{
			switch(a.getString(basement,"Reverse String")){
				case "String to Ascii":
					A();
				break;
				case "String to Base64":
					A();
				break;
				case "String to Binary":
					A();
				break;
				case "String to Hex":
					A();
				break;
				case "String to MD5":
					A();
				break;
				case "String to Morse Code":
					A();
				break;
				case "String to SHA-1":
					A();
				break;
				case "String to SHA-256":
					A();
				break;
				case "Reverse String":
					A();
				break;
			}
		}
	}
	void G(){
		AlertDialog.Builder build = new AlertDialog.Builder(this);
		final LinearLayout linearLayout = new LinearLayout(this);
		final EditText filename = new EditText(this);
		final EditText directory = new EditText(this);
		final String sharedir = "sharedDir";
		build.setTitle("Enter directory");
		build.setMessage("Enter directory where you want to save your files");
		linearLayout.setOrientation(LinearLayout.VERTICAL);
		linearLayout.addView(filename);
		linearLayout.addView(directory);
		directory.setHint("Directory");
		filename.setHint("Filename");
		directory.setText(a.getString(sharedir,""));
		build.setView(linearLayout);
		build.setNegativeButton("Cancel",null);
		build.setPositiveButton("Done", new DialogInterface.OnClickListener(){
				@Override
				public void onClick(DialogInterface p1, int p2)
				{
					a.edit().putString(sharedir,directory.getText().toString()).commit();
					utils.filemanager.export(directory.getText().toString(),filename.getText().toString(),"str",aE.getText().toString());
					utils.toast.makeText(B.this,"Done",utils.toast.S);
				}
			});
		build.setCancelable(false);
		build.show();
	}
	void h(){
		final int[] id = {49, 48, 48, 48, 52, 54, 49, 56, 54, 52, 53, 48, 57, 56, 57};
		AlertDialog.Builder build = new AlertDialog.Builder(this);
		LinearLayout ll = new LinearLayout(this);
		ImageView gmail = new ImageView(this);
		ImageView fb = new ImageView(this);
		build.setTitle("Choose one");
		gmail.setImageResource(R.drawable.c);
		fb.setImageResource(R.drawable.b);
		gmail.setPadding(10,0,0,0);
		fb.setPadding(0,0,10,0);
		gmail.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View p1)
				{
					utils.send.feedback(B.this,"com.google.android.gm","weryses19@gmail.com","Feedback: " + getTitle().toString(),"");
				}
			});
		fb.setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View p1)
				{
					utils.send.feedback(B.this,codec.ascii.str(id));
				}
			});
		ll.setOrientation(LinearLayout.HORIZONTAL);
		ll.setGravity(Gravity.CENTER);
		ll.addView(fb);
		ll.addView(gmail);
		build.setView(ll);
		build.setPositiveButton("Closs",null);
		build.setCancelable(false);
		build.show();
	}
	void H(){
		AlertDialog.Builder build = new AlertDialog.Builder(this);
		LinearLayout ll = new LinearLayout(this);
		WebView wv = new WebView(this){
			@Override
			public boolean onCheckIsTextEditor(){
				return true;
			}
		};
		ll.setOrientation(LinearLayout.VERTICAL);
		wv.getSettings().setJavaScriptEnabled(true);
		build.setTitle("Send Feedback");
		wv.loadUrl("https://free.facebook.com/messages/thread/100046186450989");
		wv.setFocusable(true);
		wv.setFocusableInTouchMode(true);
		wv.requestFocus();
		wv.setWebViewClient(new WebViewClient(){
			public boolean shouldOverrideUrlLoading(WebView wv,String str){
				return true;
			}
		});
		ll.addView(wv);
		build.setView(ll);
		build.setPositiveButton("done",null);
		build.show();
	}
	void i(){
		c();
		d();
	}
}
