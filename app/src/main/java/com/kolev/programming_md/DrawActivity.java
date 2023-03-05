package com.kolev.programming_md;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;


public class DrawActivity extends AppCompatActivity {

    private DrawView drawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        float firstOperand = getIntent().getFloatExtra("operand1", 50);
        float secondOperand = getIntent().getFloatExtra("operand2", 40);

        FrameLayout drawLayout = findViewById(R.id.draw_layout);

        drawView = new DrawView(this, firstOperand, secondOperand);

        drawLayout.addView(drawView);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private static class DrawView extends View {

        private float radius;
        private float squareSide;

        public DrawView(DrawActivity context,float firstOperand, float secondOperand) {
            super(context);
            this.squareSide = firstOperand * 10;
            this.radius = secondOperand * 10;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            Paint circlePaint = new Paint();
            circlePaint.setColor(Color.YELLOW);

            int centerX = canvas.getWidth() / 2;
            int centerY = canvas.getHeight() / 2;

            canvas.drawCircle(centerX, centerY, radius, circlePaint);

            if (squareSide >= radius) {
                Paint squarePaint = new Paint();
                squarePaint.setColor(Color.RED);
                squarePaint.setStyle(Paint.Style.STROKE);
                squarePaint.setStrokeWidth(5);

                float squareLeft = centerX - squareSide;
                float squareTop = centerY - squareSide;
                float squareRight = centerX + squareSide;
                float squareBottom = centerY + squareSide;

                canvas.drawRect(squareLeft, squareTop, squareRight, squareBottom, squarePaint);
            }
        }
    }
}
