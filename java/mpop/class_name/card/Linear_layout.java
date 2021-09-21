package mpop.class_name.card;

import android.widget.LinearLayout;
import android.content.Context;
import mpop.designs;
import android.graphics.Color;

public class Linear_layout extends LinearLayout
{
	public Linear_layout(Context a){
		super(a);
		setBackgroundDrawable(designs.bg.setup(5,Color.LTGRAY));
		setPadding(10,10,10,10);
	}
	public Linear_layout(Context a,int color){
		super(a);
		setBackgroundDrawable(designs.bg.setup(5,color));
		setPadding(10,10,10,10);
	}
}
