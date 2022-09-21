package com.ardev.idroid.ui.main.fragment.editor;


class CodeEditorFragment : BaseFragment() {

  private lateinit var currentFile: File

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        currentFile = File(getPath())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       
       
       
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    configureEditor(editor)
    
    
     if (currentFile.exists()) {
            try {
                binding.editor.setText(FileUtil.readFile(currentFile))
                
            } catch (e: IOException) { }
              
            if (currentFile.getPath().endsWith(".kt")) {
                setEditorLanguage(LANGUAGE_KOTLIN)
            } else if (currentFile.getPath().endsWith(".java")) {
                setEditorLanguage(LANGUAGE_JAVA)
            }
           
        }
        
        
        
    }

    override fun onDestroy() {
        super.onDestroy()
       editor.release()
    }
    
    private fun configureEditor(editor: CodeEditor) {
        editor.setTypefaceText(ResourcesCompat.getFont(requireContext(), R.font.jetbrains_mono_regular))
        editor.setTextSize(12F)
        editor.setEdgeEffectColor(Color.TRANSPARENT)
        editor.setImportantForAutofill(View.IMPORTANT_FOR_AUTOFILL_NO)

        var props = editor.getProps().apply {
            overScrollEnabled = false
            allowFullscreen = false
            deleteEmptyLineFast = false
        }
    }

    fun undo() {
        if (editor.canUndo()) editor.undo()
    }

    fun redo() {
        if (editor.canRedo()) editor.redo()
    }

    private fun setEditorLanguage(lang: Int) {
        when (lang) {
            LANGUAGE_JAVA -> editor.setEditorLanguage(getJavaLanguage())
            LANGUAGE_KOTLIN -> editor.setEditorLanguage(getKotlinLanguage())
            else -> editor.setEditorLanguage(EmptyLanguage())
        }
        editor.setColorScheme(getColorScheme())
    }
    
    private fun getColorScheme(): TextMateColorScheme {
        try {
            var themeSource: IThemeSource
            if (ApplicationLoader.isDarkMode(requireContext())) {
                themeSource =
                    IThemeSource.fromInputStream(
                        requireContext().getAssets().open("textmate/darcula.json"),
                        "darcula.json",
                        null
                    )
            } else {
                themeSource =
                    IThemeSource.fromInputStream(
                        requireContext().assets.open("textmate/light.tmTheme"),
                        "light.tmTheme",
                        null
                    )
            }
            return TextMateColorScheme.create(themeSource)
        } catch (e: Exception) {
            throw IllegalStateException(e)
        }
    }

    private fun getJavaLanguage(): Language {
        try {
            return TextMateLanguage.create(
                IGrammarSource.fromInputStream(
                    requireContext().assets.open("textmate/java/syntaxes/java.tmLanguage.json"),
                    "java.tmLanguage.json",
                    null
                ),
                InputStreamReader(
                    requireContext().assets.open("textmate/java/language-configuration.json")
                ),
                getColorScheme().themeSource
            )
        } catch (e: IOException) {
            return EmptyLanguage()
        }
    }

    private fun getKotlinLanguage(): Language {
        try {
            return TextMateLanguage.create(
                IGrammarSource.fromInputStream(
                    requireContext().assets.open("textmate/kotlin/syntaxes/kotlin.tmLanguage"),
                    "kotlin.tmLanguage",
                    null
                ), 
                InputStreamReader(
                    requireContext().assets.open("textmate/kotlin/language-configuration.json")
                ),
                getColorScheme().themeSource
            )
        } catch (e: IOException) {
            return EmptyLanguage()
        }
    }
    
    companion object {
        const val LANGUAGE_JAVA = 0
        const val LANGUAGE_KOTLIN = 1
        const val TAG = "CodeEditorFragment"

        fun newInstance(file: File): CodeEditorFragment {
            val args: Bundle = Bundle()
            args.putString("path", file.getAbsolutePath())
            val fragment = CodeEditorFragment()
            fragment.arguments = args
            return fragment
        }
    }
    
    
    }