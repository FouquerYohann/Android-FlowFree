package projet.flowfreeupmc;



import API.Case;
import API.FlowModel;
import API.PathUnderBuilding;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;




public class FlowGridView extends SurfaceView 
	implements SurfaceHolder.Callback {
	
	private FlowModelApp fma;
	private FlowGridThread gridThread;
	
	private Paint paint= new Paint();
	private int canvasWidth;
	private int canvasHeight;
	private int cellWidth;
	private int cellHeight;
	
	
	
	
	
	
	
	int getColumnFromPixel(int px){
		FlowModel fm=((FlowModelApp) getContext().getApplicationContext()).getFlowModel();
		int colonne=fm.getMonde().getNbColonne();
		int largeurColonne=this.getWidth()/colonne;
		return (px/largeurColonne);
	}

	int getLigneFromPixel(int px){
		FlowModel fm=((FlowModelApp) getContext().getApplicationContext()).getFlowModel();
		int ligne=fm.getMonde().getNbLigne();
		int largeurLigne=this.getHeight()/ligne;
		return (px/largeurLigne);
	}
public boolean onTouchEvent(MotionEvent event){
	int x = (int) event.getX();
	int y = (int) event.getY();
	
	int action = event.getAction();
	FlowModel app = fma.getFlowModel();
	
	if (x > this.getWidth() || x< 0 || y<0 || y>this.getHeight()){
		app.stop(getColumnFromPixel(x), getLigneFromPixel(y));	
		return false;
	}
	switch(action){
	case MotionEvent.ACTION_DOWN: {
        fma.incrementScore();
		return app.start(getColumnFromPixel(x), getLigneFromPixel(y));
	}
	case MotionEvent.ACTION_MOVE: {
		return app.extend(getColumnFromPixel(x), getLigneFromPixel(y));
	}
	case MotionEvent.ACTION_UP: {
		return app.stop(getColumnFromPixel(x), getLigneFromPixel(y));
	}
	default:
		return false;
	}

}
	
	
	public FlowGridView(Context context, AttributeSet attrs) {
		super(context, attrs);

		getHolder().addCallback(this);
		setFocusable(true);
		// TODO Auto-generated constructor stub
		this.getFlowModel(context);
	}

	public FlowGridView() {
		super(null);
		// TODO Auto-generated constructor stub
	}

	public void surfaceCreated(SurfaceHolder sh){
		gridThread = new FlowGridThread(getHolder(), this);
		gridThread.setRunning(true);
		gridThread.start();
		
		
	}

	@Override
	public void surfaceChanged(SurfaceHolder sh,int format, int width, int height){
		
		

		RelativeLayout.LayoutParams lp=new RelativeLayout.LayoutParams(fma.getScreen_width(),fma.getScreen_height()/2);
		this.setLayoutParams(lp);
		
		
		
	}
	public void surfaceDestroyed(SurfaceHolder sh){

		boolean retry=true;
		gridThread.setRunning(false);
		while(retry){
			try{
			    gridThread.join();
				retry=false;
			}catch (InterruptedException e){
                e.printStackTrace();
            }
        }

	}
	
	public void onDraw(Canvas canvas){
		
		canvas.drawARGB(255, 160, 160, 160);
		FlowModel fm=((FlowModelApp) getContext().getApplicationContext()).getFlowModel();
		canvasWidth=this.getWidth();
		int colonne=fm.getMonde().getNbColonne();
		int ligne=fm.getMonde().getNbLigne();
		cellWidth=canvasWidth/colonne;
		canvasHeight= this.getHeight()-60;
		cellHeight= canvasHeight/ligne;
		
		float x=0;
		float y=0;
		int radius;

			if (fma.getFlowModel().finJeu()== true){
				canvas.drawARGB((int)(Math.random()*255),(int)(Math.random()*255) , (int)(Math.random()*255), (int)(Math.random()*255));
				fma.saveScore();
				System.out.println(fma.readScore());
			}
			paint.setARGB(255, 0, 0, 0);
		
		
		for(int i=0; i<=colonne; i++){
				canvas.drawLine(x, 0, x, ligne*cellHeight, paint);
				x+=cellWidth;
		}
		for(int i=0; i<=ligne; i++){
			canvas.drawLine(0, y, colonne*cellWidth, y, paint);
			y+=cellHeight;
		}
		
		for (int i=0; i<fm.getGs().getListePath().size(); i++){
            PathUnderBuilding pub =fm.getGs().getListePath().get(i);
			for (int j = 0; j < pub.getListe().size(); j++) {
				Case c=pub.getListe().get(j);
				    x=c.getLigne()*cellWidth+(cellWidth/2);
					y=c.getColonne()*cellHeight+(cellHeight/2);
					if(pub.getColor().equals("bblue"))
						paint.setARGB(255, 0, 0, 255);
					if(pub.getColor().equals("red"))
						paint.setARGB(255, 255, 0, 0);
					if(pub.getColor().equals("green"))
						paint.setARGB(255, 0, 255, 0);
					if(pub.getColor().equals("yellow"))
						paint.setARGB(255, 255, 255, 0);
					if(pub.getColor().equals("orange"))
						paint.setARGB(255, 255, 129, 0);
					if(pub.getColor().equals("white"))
						paint.setARGB(255, 206, 206, 206);
					if(pub.getColor().equals("cyan"))
						paint.setARGB(255, 0, 255, 255);
					if(pub.getColor().equals("pink"))
						paint.setARGB(255, 255, 102, 255);
					if(pub.getColor().equals("brown"))
						paint.setARGB(255, 88, 64, 6);
					
					
					
					if (c.isEstUnePastille() == true) {
                        radius = Math.min(cellWidth / 2, cellHeight / 2)-1;
                        canvas.drawCircle(x, y, radius, paint);
                    }
                   else {
                    radius =Math.min(cellWidth/3,cellHeight/3)-1;
                    float x_prec = pub.getListe().get(j - 1).getLigne() * cellWidth + (cellWidth / 2);
                    float y_prec = pub.getListe().get(j - 1).getColonne() * cellHeight + (cellHeight / 2);
                    paint.setStrokeWidth(radius);
                    canvas.drawLine(x_prec, y_prec, x, y, paint);
                    paint.setStrokeWidth(1);
                    canvas.drawCircle(x, y, radius/2, paint);
                }
           }
	    }
		paint.setTextSize(55);
		paint.setARGB(255, 0, 0, 0);
		
		String Score="Score :" + fma.getScore();
		canvas.drawText(Score, 10, colonne*cellHeight+55, paint);
	}

	
	
	final void getFlowModel(Context context) {
	fma	= (FlowModelApp) (context.getApplicationContext());
	}

}
