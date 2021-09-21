package mpop;
import android.content.Context;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.net.Uri;
import android.os.Environment;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class designs
{
	public static class typeface{
		public static final Typeface font(Context ctx,String assets){
			return Typeface.createFromAsset(ctx.getAssets(),assets);
		}
		public static final Typeface font(String uri){
			return Typeface.createFromFile(Uri.parse(uri).toString());
		}
		public static final Typeface font(String folderDirectory,String filename,String filetype){
			return Typeface.createFromFile("file:///" + Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + folderDirectory + "/" + filename + ".");
		}
	}
	public static class Animations{
		public static final int ABSOLUTE = Animation.ABSOLUTE;
		public static final int INFINITE = Animation.INFINITE;
		public static final int RELATIVE_TO_PARENT = Animation.RELATIVE_TO_PARENT;
		public static final int RELTIVE_TO_SELF = Animation.RELATIVE_TO_SELF;
		public static final int RESTART = Animation.RESTART;
		public static final int REVERSE = Animation.REVERSE;
		public static final int START_ON_FIRST_FRAME = Animation.START_ON_FIRST_FRAME;
		public static final int ZORRDER_BOTOM = Animation.ZORDER_BOTTOM;
		public static final int ZORDER_NORMAL = Animation.ZORDER_NORMAL;
		public static final int ZORDER_TOP = Animation.ZORDER_TOP;

		public static final Animation fade(float oppacityFrom,float oppacityTo,long duration,long offset,int repeatCount,int repeatMode){
			Animation anim = null;
			anim = new AlphaAnimation(oppacityFrom,oppacityTo);
			anim.setDuration(duration);
			anim.setStartOffset(offset);
			anim.setRepeatCount(repeatCount);
			anim.setRepeatMode(repeatMode);
			anim.start();
			return anim;
		}
	}
	public static class Gradient{
		public static final TileMode CLAMP = TileMode.CLAMP;
		public static final TileMode MIRROR = TileMode.MIRROR;
		public static final TileMode REPEAT = TileMode.REPEAT;
		public static final Shader gradient(TextView ui,String hexColor1,String hexColor2, TileMode type){
			return new LinearGradient((float)0,(float)0,(float)0,ui.getTextSize(),Color.parseColor(hexColor1),Color.parseColor(hexColor2),type);
		}
		public static final Shader gradient(EditText ui,String hexColor1,String hexColor2,TileMode type){
			return new LinearGradient((float)0,(float)0,(float)0,ui.getTextSize(),Color.parseColor(hexColor1),Color.parseColor(hexColor2),type);
		}
		public static final Shader gradient(Button ui,String hextColor1,String hextColor2,TileMode type){
			return new LinearGradient((float)0,(float)0,(float)0,ui.getTextSize(),Color.parseColor(hextColor1),Color.parseColor(hextColor2),type);
		}
	}
	public static class bg{
		public static final Drawable setup(float num,int color){
			RoundRectShape a = new RoundRectShape(new float[]{num,num,num,num,num,num,num,num},null,null);
			ShapeDrawable b = new ShapeDrawable(a);
			b.getPaint().setColor(color);
			return b;
		}
	}
}

