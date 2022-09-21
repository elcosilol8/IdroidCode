package com.ardev.tools.formatter

import com.google.googlejavaformat.java.Formatter
import com.google.googlejavaformat.java.JavaFormatterOptions

class GoogleJavaFormatter(input: String) {

    private val source: String

    init {
        source = input
    }

    fun format(): String {
        val options =
            JavaFormatterOptions.builder()
                .style(JavaFormatterOptions.Style.AOSP) // Use 4 spaces for tab
                .formatJavadoc(true) // Format Javadoc
                .build()
        val formatter = Formatter(options)
        try {
            return formatter.formatSource(source)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return source
    }
}

