package com.ardev.idroid.ui.main.fragment.editor;

import com.ardev.idroid.base.BaseCodeEditorFragment;
import io.github.rosemoe.sora.lang.EmptyLanguage;
import android.os.Bundle;
import org.eclipse.tm4e.core.registry.IGrammarSource;
import org.eclipse.tm4e.core.registry.IThemeSource;
import io.github.rosemoe.sora.lang.Language;
import io.github.rosemoe.sora.widget.schemes.EditorColorScheme;
import com.ardev.idroid.R;

public class EmptyCodeEditorFragment extends BaseCodeEditorFragment {

	 
	public EmptyCodeEditorFragment(String path) {
		super(path);
		}
		
	 
		
		
 

	@Override
	protected String[] getSymbolsName() {
	
		String arr[] = { "->", "{", "}", "(", ")", ",", ".", ";", "\"", "?", "+", "-", "*", "/" };
		return arr;
	}

	@Override
	protected String[] getSymbols() {
		String arr2[] = { "\t", "{}", "}", "()", ")", ",", ".", ";", "\"", "?", "+", "-", "*", "/" };
		return arr2;
	}

	

	@Override
	protected Language getLanguage(EditorColorScheme scheme) {
		try {
		
		return new EmptyLanguage();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	
	    return null;
	}
	
}