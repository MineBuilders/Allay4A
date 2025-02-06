package vip.cdms.allay4a.ui.components

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.ScrollView
import android.widget.TextView
import com.fox2code.androidansi.AnsiParser
import vip.cdms.allay4a.ui.utils.AnsiPalette


class ConsoleView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ScrollView(context, attrs) {
    val textView: TextView = TextView(context).apply {
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        textSize = 16f
        typeface = Typeface.MONOSPACE
        setTextIsSelectable(true)
        setLineSpacing(0f, 1.2f)
    }

    init {
        addView(textView)
        textView.setTextColor(AnsiPalette.getContentColor())
        setBackgroundColor(AnsiPalette.getBackgroundColor())
    }

    private var isFirstLine = true
    fun writeLine(data: String) {
        if (!isFirstLine) textView.append("\n")
        isFirstLine = false
        textView.append(AnsiParser.parseAsSpannable(data))
        post { fullScroll(FOCUS_DOWN) }
    }
}
