package projet.flowfreeupmc;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class FlowGridThread extends Thread {

	 private final SurfaceHolder _surfaceHolder;
	    private FlowGridView _panel; 
	    private boolean _run = false;

	    public FlowGridThread(SurfaceHolder surfaceHolder, FlowGridView panel) 
	    {
	        _surfaceHolder = surfaceHolder;
	        _panel = panel;
	    }

	    public void setRunning(boolean run)
	    {
	        _run = run;
	    }

	    @Override
	    public void run() 
	    {
	        long previousTime, currentTime, refresh_rate; 
	        refresh_rate = 100 ;
	        previousTime = System.currentTimeMillis(); 
	        
	        Canvas c;
	        while (_run) 
	        {
	            currentTime=System.currentTimeMillis();  
	            while ((currentTime-previousTime)<refresh_rate){  
	                 currentTime=System.currentTimeMillis();  
	            }  
	            previousTime=currentTime;  
	            try
	            {
	                c = _surfaceHolder.lockCanvas(null);
	                try 
	                {
	                    synchronized (_surfaceHolder) 
	                    {
	                        if (_run) {
	                            _panel.onDraw(c);
	                        }
	                    }
	                } 
	                finally 
	                {
	                    // do this in a finally so that if an exception is thrown
	                    // during the above, we don't leave the Surface in an
	                    // inconsistent state
	                    if (c != null) 
	                    {
	                        _surfaceHolder.unlockCanvasAndPost(c);
	                    }
	                }
	            }
	            catch(Exception e)
	            {
	                
	            }
	            try {  
	                Thread.sleep(refresh_rate-5); // Wait some time till I need to display again  
	           } catch (InterruptedException e) {  
	                // TODO Auto-generated catch block  
	                e.printStackTrace();  
	           }  
	        }
	    }

}
