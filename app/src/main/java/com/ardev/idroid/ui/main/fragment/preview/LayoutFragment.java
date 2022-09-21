package com.ardev.idroid.ui.main.fragment.preview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ardev.component.view.OutlineView;
import com.ardev.tools.parser.AndroidXmlParser;
import com.ardev.tools.parser.ReadOnlyParser;
import com.ardev.idroid.base.BaseFragment;
import com.bumptech.glide.Glide;
import com.ardev.idroid.R;

import java.io.File;

public class LayoutFragment extends BaseFragment {

private OutlineView outlineView;
private AndroidXmlParser androidXmlParser;
   
   
   	public LayoutFragment(String path) {
		super(path);
		}
		
		
   @Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 
}


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
                             
                            	View view = inflater.inflate(R.layout.fragment_layout_preview, container, false);
                             
                            outlineView = view.findViewById(R.id.outline_view);
                             
                             
                           return view;  
                     }
                     
            
            
     


		@Override
	public void onViewCreated(View view, Bundle bundle) {
		super.onViewCreated(view, bundle);
		outlineView.setDisplayType(OutlineView.DISPLAY_VIEW);
		
		
                     initParser();
        
        }
        
        @Override
	public void onResume() {
		super.onResume();
       try {
       
        initParser();
          //androidXmlParser.parse(new File(getPath()));

            
        } catch (Exception e) {
            e.printStackTrace();
        }

	}
        
        	
   @Override 
   protected void setMenu(Menu menu) {
   
   menu.add("Modo: diseño").setOnMenuItemClickListener(item -> {
    outlineView.setDisplayType(OutlineView.DISPLAY_DESIGN);
	return true;
    });
    menu.add("Modo: visualización ").setOnMenuItemClickListener(item -> {
    outlineView.setDisplayType(OutlineView.DISPLAY_VIEW);
	return true;
    });
   }
        
        private void initParser() {
        try {

           androidXmlParser = AndroidXmlParser.with(outlineView);
           
            androidXmlParser.setOnParseListener(new AndroidXmlParser.OnParseListener() {
                        @Override
                        public void onAddChildView(View v, ReadOnlyParser parser) {
                           
                        }

                        @Override
                        public void onJoin(ViewGroup viewGroup, ReadOnlyParser parser) {
                            
                        }
						

                        @Override
                        public void onRevert(ViewGroup viewGroup, ReadOnlyParser parser) {
                            

                        }

                        @Override
                        public void onFinish() {
                        }

                        @Override
                        public void onStart() {
							}
					 
                        
                    });
                    
                    androidXmlParser.parse(new File(getPath()));

            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        }
        
        
        
   }
                     