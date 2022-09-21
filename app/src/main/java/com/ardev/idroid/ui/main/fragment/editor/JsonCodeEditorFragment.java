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


public class JsonCodeEditorFragment extends BaseCodeEditorFragment {

	public JsonCodeEditorFragment(String path) {
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
		Language language = TextMateLanguage.create(IGrammarSource.fromInputStream(requireContext().getAssets().open("textmate/json/syntaxes/json.tmLanguage.json"), "json.tmLanguage.json", null),
					new InputStreamReader(requireContext().getAssets().open("textmate/json/language-configuration.json")), getColorScheme().getThemeSource());
		return language;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	
	    return null;
	}

}