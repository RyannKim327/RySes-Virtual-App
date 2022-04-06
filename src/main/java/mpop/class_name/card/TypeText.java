package mpop.class_name.card;
import android.widget.TextView;
import android.content.Context;
import android.os.Handler;
public class TypeText extends TextView
{
	public TypeText(Context a,final String b){
		super(a);
		for(int c = 0; c <= b.length(); c++){
			String d = "";
			d += b.charAt(c);
			setText(d);
		}
	}
}
