package dev.jadscode.projetcloud;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import dev.jadscode.projetcloud.ViewCanvas.CanvasView;
import dev.jadscode.projetcloud.ViewCanvas.DrawListener;

public class MainActivity extends AppCompatActivity {


    private CanvasView customCanvas;
    private CanvasView customCanvas2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customCanvas = (CanvasView) findViewById(R.id.signature_canvas);
        customCanvas2 = (CanvasView) findViewById(R.id.signature_canvas2);

        customCanvas.setListener(new DrawListener() {
            @Override
            public void onAction(MotionEvent evt) {

                Message msg = new Message(evt.getX(), evt.getY(), evt.getAction());
                customCanvas2.applyEvent(msg);
            }
        });
    }

    public void clearCanvas(View v) {
        customCanvas.clearCanvas();

    }


}
