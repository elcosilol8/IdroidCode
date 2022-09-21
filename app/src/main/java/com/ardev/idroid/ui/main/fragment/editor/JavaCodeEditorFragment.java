package com.ardev.idroid.ui.main.fragment.editor;

import android.os.Bundle;

import android.view.Menu;
import com.ardev.idroid.base.BaseCodeEditorFragment;
import io.github.rosemoe.sora.lang.Language;
import io.github.rosemoe.sora.langs.textmate.TextMateColorScheme;
import io.github.rosemoe.sora.langs.textmate.TextMateLanguage;
import com.ardev.idroid.R;
import io.github.rosemoe.sora.widget.schemes.EditorColorScheme;
import java.io.InputStreamReader;
import com.ardev.idroid.ext.CoroutineUtil;
import com.ardev.tools.formatter.GoogleJavaFormatter;
import org.eclipse.tm4e.core.registry.IGrammarSource;
import org.eclipse.tm4e.core.registry.IThemeSource;


public class JavaCodeEditorFragment extends BaseCodeEditorFragment {
String _format;

		public JavaCodeEditorFragment(String path) {
		super(path);
		}
			@Override
			 protected void setMenu(Menu menu) {
			 super.setMenu(menu);
			 menu.add("Formato").setOnMenuItemClickListener(item -> {
 
	
			 
			 
			 CoroutineUtil.execute(() -> {
 GoogleJavaFormatter formatter = new GoogleJavaFormatter(editor.getText().toString());
        _format = formatter.format();
                            });
			 saveText(_format);
			 readText();
			 return true;
    });
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
			Language language = TextMateLanguage.create(IGrammarSource.fromInputStream(requireContext().getAssets().open("textmate/java/syntaxes/java.tmLanguage.json"), "java.tmLanguage.json", null),
					new InputStreamReader(requireContext().getAssets().open("textmate/java/language-configuration.json")), getColorScheme().getThemeSource());
					
		return language;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	
	    return null;
	}

}