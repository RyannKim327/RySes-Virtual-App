package mpop.class_name;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

public class Edit_text extends EditText {
    boolean aa = true;
    Matrix ab;
    LinearGradient ac;
    Paint ad;
    int ae = 0;
    int af = 0;

    public Edit_text(Context context) {
        super(context);
        
    }

    public Edit_text(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.aa && this.ab != null) {
            this.ae += this.af / 10;
            if (this.ae > this.af * 2) {
                this.ae = -this.af;
            }
            this.ab.setTranslate((float) this.ae, 0.0f);
            this.ac.setLocalMatrix(this.ab);
            postInvalidateDelayed(50);
        }
    }

    @Override
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.af == 0) {
            this.af = getMeasuredWidth();
            if (this.af > 0) {
                this.ad = getPaint();
                this.ac = new LinearGradient((float) (-this.af), 0.0f, 0.0f, 0.0f, new int[]{-12887656, -1, -12887656}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP);
                this.ad.setShader(this.ac);
                this.ab = new Matrix();
            }
        }
    }
}
