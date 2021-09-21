package mpop.class_name.card;

import android.widget.EditText;
import android.content.Context;
import mpop.designs.bg;
import android.graphics.Color;

public class Edit_text extends EditText
{
	public Edit_text(Context a){
		super(a);
		setBackgroundDrawable(bg.setup(7,Color.DKGRAY));
		setPadding(10,10,10,10);
	}
	public Edit_text(Context a,int color){
		super(a);
		setBackgroundDrawable(bg.setup(7,color));
		setPadding(10,10,10,10);
	}
}
