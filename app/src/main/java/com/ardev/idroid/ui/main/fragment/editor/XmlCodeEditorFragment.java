package com.ardev.idroid.ui.main.fragment.editor;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import com.ardev.idroid.base.BaseCodeEditorFragment;
import com.ardev.idroid.ext.ProjectUtils;
import com.ardev.idroid.ui.main.model.Editable;
import io.github.rosemoe.sora.langs.textmate.TextMateColorScheme;
import java.io.File;
import com.ardev.idroid.app.MainViewModelProvider;
import org.eclipse.tm4e.core.registry.IGrammarSource;
import org.eclipse.tm4e.core.registry.IThemeSource;
import io.github.rosemoe.sora.lang.Language;
import io.github.rosemoe.sora.langs.textmate.TextMateLanguage;
import io.github.rosemoe.sora.widget.schemes.EditorColorScheme;
import java.io.InputStreamReader;
import com.ardev.idroid.R; 

public class XmlCodeEditorFragment extends BaseCodeEditorFragment {
File file;
boolean isPreview;

	public XmlCodeEditorFragment(String path) {
		super(path);
		}
		
		
		 @Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
}


	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
   		 super.onViewCreated(view, savedInstanceState);
		file = new File(getPath());
	

}

	 @Override 
   protected void setMenu(Menu menu) {
   super.setMenu(menu);
   	if((ProjectUtils.isLayoutXMLFile(file) || ProjectUtils.isValuesXMLFile(file)  || ProjectUtils.isDrawableXMLFile(file))) {

   menu.add("Preview").setOnMenuItemClickListener(item -> {
	saveText();
	mainViewModel.addEditor(new Editable(file, true));
							 
					 
	return true;
	});
	}
	
	}

	@Override
	protected String[] getSymbolsName() {
//	super.getSymbolsName();
		String arr[] = { "->",  "<",  ">", "/",  "=",  "\"",  ":",  "@",  "+",   "(",  ")",  ";",  ",", ".", "?", "|", "\\", "&", "!", "[", "]", "{", "}", "_", "-" };
	
		return arr;
	}

	@Override
	protected String[] getSymbols() {
		//super.getSymbols();
		String arr2[] = { "\t",  "<",  ">", "/",  "=",  "\"",  ":",  "@",  "+",   "(",  ")",  ";",  ",", ".", "?", "|", "\\", "&", "!", "[", "]", "{", "}", "_", "-" };
	
		return arr2;
	}


	@Override
	protected Language getLanguage(EditorColorScheme scheme) {
		
		try {
		
		Language language = TextMateLanguage.create(IGrammarSource.fromInputStream(requireContext().getAssets().open("textmate/xml/syntaxes/xml.tmLanguage.json"), "xml.tmLanguage.json", null),
					new InputStreamReader(requireContext().getAssets().open("textmate/xml/language-configuration.json")), getColorScheme().getThemeSource());
		return language;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
//	super.getLanguage(scheme);
	    return null;
	}

}