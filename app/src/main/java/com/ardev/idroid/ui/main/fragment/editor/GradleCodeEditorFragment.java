package com.ardev.idroid.ui.main.fragment.editor;

import android.os.Bundle;

import com.ardev.idroid.base.BaseCodeEditorFragment;
import io.github.rosemoe.sora.lang.Language;
import io.github.rosemoe.sora.langs.textmate.TextMateColorScheme;
import io.github.rosemoe.sora.langs.textmate.TextMateLanguage;
import com.ardev.idroid.R;
import io.github.rosemoe.sora.widget.schemes.EditorColorScheme;
import java.io.InputStreamReader;
import org.eclipse.tm4e.core.registry.IGrammarSource;
import org.eclipse.tm4e.core.registry.IThemeSource;

public class GradleCodeEditorFragment extends BaseCodeEditorFragment {

		public GradleCodeEditorFragment(String path) {
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
		Language language = TextMateLanguage.create(IGrammarSource.fromInputStream(requireContext().getAssets().open("textmate/groovy/syntaxes/groovy.tmLanguage"), "groovy.tmLanguage", null),
					new InputStreamReader(requireContext().getAssets().open("textmate/groovy/language-configuration.json")), ((TextMateColorScheme) scheme).getThemeSource());
		return language;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	
	    return null;
	}

}