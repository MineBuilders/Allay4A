package vip.cdms.allay4a.ui.utils

import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.graphics.Color as ComposeColor
import android.graphics.Color as ViewColor
import com.fox2code.androidansi.AnsiConstants

fun interface AnsiPalette {
    fun attach()

    // just for supporting color preview ide plugin :)
    data class ColorScheme(
        val black: ComposeColor,
        val red: ComposeColor,
        val green: ComposeColor,
        val yellow: ComposeColor,
        val blue: ComposeColor,
        val magenta: ComposeColor,
        val cyan: ComposeColor,
        val white: ComposeColor,
        val brightBlack: ComposeColor = black,
        val brightRed: ComposeColor = red,
        val brightGreen: ComposeColor = green,
        val brightYellow: ComposeColor = yellow,
        val brightBlue: ComposeColor = blue,
        val brightMagenta: ComposeColor = magenta,
        val brightCyan: ComposeColor = cyan,
        val brightWhite: ComposeColor = white,
        val content: ComposeColor,
        val background: ComposeColor,
    ) : AnsiPalette {
        override fun attach() {
            "COLOR_BLACK" edit black.toArgb()
            "COLOR_RED" edit red.toArgb()
            "COLOR_GREEN" edit green.toArgb()
            "COLOR_YELLOW" edit yellow.toArgb()
            "COLOR_BLUE" edit blue.toArgb()
            "COLOR_MAGENTA" edit magenta.toArgb()
            "COLOR_CYAN" edit cyan.toArgb()
            "COLOR_WHITE" edit white.toArgb()
            "COLOR_BRIGHT_BLACK" edit brightBlack.toArgb()
            "COLOR_BRIGHT_RED" edit brightRed.toArgb()
            "COLOR_BRIGHT_GREEN" edit brightGreen.toArgb()
            "COLOR_BRIGHT_YELLOW" edit brightYellow.toArgb()
            "COLOR_BRIGHT_BLUE" edit brightBlue.toArgb()
            "COLOR_BRIGHT_MAGENTA" edit brightMagenta.toArgb()
            "COLOR_BRIGHT_CYAN" edit brightCyan.toArgb()
            "COLOR_BRIGHT_WHITE" edit brightWhite.toArgb()
            Content = content.toArgb()
            Background = background.toArgb()
        }
    }

    companion object {
        private var Content = ViewColor.WHITE
        private var Background = ViewColor.BLACK
        // use fun to split palette instance
        fun getContentColor() = Content
        fun getBackgroundColor() = Background

        val Default = AnsiPalette {
            "COLOR_BLACK" edit ViewColor.rgb(0, 0, 0)
            "COLOR_RED" edit ViewColor.rgb(205, 0, 0)
            "COLOR_GREEN" edit ViewColor.rgb(0, 205, 0)
            "COLOR_YELLOW" edit ViewColor.rgb(205, 205, 0)
            "COLOR_BLUE" edit ViewColor.rgb(0, 0, 205)
            "COLOR_MAGENTA" edit ViewColor.rgb(205, 0, 205)
            "COLOR_CYAN" edit ViewColor.rgb(0, 205, 205)
            "COLOR_WHITE" edit ViewColor.rgb(229, 229, 229)
            "COLOR_BRIGHT_BLACK" edit ViewColor.rgb(127, 127, 127)
            "COLOR_BRIGHT_RED" edit ViewColor.rgb(255, 0, 0)
            "COLOR_BRIGHT_GREEN" edit ViewColor.rgb(0, 255, 0)
            "COLOR_BRIGHT_YELLOW" edit ViewColor.rgb(255, 255, 0)
            "COLOR_BRIGHT_BLUE" edit ViewColor.rgb(0, 0, 255)
            "COLOR_BRIGHT_MAGENTA" edit ViewColor.rgb(255, 0, 255)
            "COLOR_BRIGHT_CYAN" edit ViewColor.rgb(0, 255, 255)
            "COLOR_BRIGHT_WHITE" edit ViewColor.rgb(255, 255, 255)
            Content = ViewColor.WHITE
            Background = ViewColor.BLACK
        }

        // from Windows Terminal :P

        val OneHalfDark = ColorScheme(
            black = ComposeColor(0xFF282c34),
            red = ComposeColor(0xFFe06c75),
            green = ComposeColor(0xFF98c379),
            yellow = ComposeColor(0xFFe5c07b),
            blue = ComposeColor(0xFF61afef),
            magenta = ComposeColor(0xFFc678dd),
            cyan = ComposeColor(0xFF56b6c2),
            white = ComposeColor(0xFFdcdfe4),
            brightBlack = ComposeColor(0xFF5a6374),
            content = ComposeColor(0xFFdcdfe4),
            background = ComposeColor(0xFF282c34),
        )

        val OneHalfLight = ColorScheme(
            black = ComposeColor(0xFF383a42),
            red = ComposeColor(0xFFe45649),
            green = ComposeColor(0xFF50a14f),
            yellow = ComposeColor(0xFFc18301),
            blue = ComposeColor(0xFF0184bc),
            magenta = ComposeColor(0xFFa626a4),
            cyan = ComposeColor(0xFF0997b3),
            white = ComposeColor(0xFFfafafa),
            brightBlack = ComposeColor(0xFF4f525d),
            brightRed = ComposeColor(0xFFdf6c75),
            brightGreen = ComposeColor(0xFF98c379),
            brightYellow = ComposeColor(0xFFe4c07a),
            brightBlue = ComposeColor(0xFF61afef),
            brightMagenta = ComposeColor(0xFFc577dd),
            brightCyan = ComposeColor(0xFF56b5c1),
            brightWhite = ComposeColor(0xFFffffff),
            content = ComposeColor(0xFF383a42),
            background = ComposeColor(0xFFfafafa),
        )

        val SolarizedDark = ColorScheme(
            black = ComposeColor(0xFF002b36),
            red = ComposeColor(0xFFdc322f),
            green = ComposeColor(0xFF859900),
            yellow = ComposeColor(0xFFb58900),
            blue = ComposeColor(0xFF268bd2),
            magenta = ComposeColor(0xFFd33682),
            cyan = ComposeColor(0xFF2aa198),
            white = ComposeColor(0xFFeee8d5),
            brightBlack = ComposeColor(0xFF073642),
            brightRed = ComposeColor(0xFFcb4b16),
            brightGreen = ComposeColor(0xFF586e75),
            brightYellow = ComposeColor(0xFF657b83),
            brightBlue = ComposeColor(0xFF839496),
            brightMagenta = ComposeColor(0xFF6c71c4),
            brightCyan = ComposeColor(0xFF93a1a1),
            brightWhite = ComposeColor(0xFFfdf6e3),
            content = ComposeColor(0xFF839496),
            background = ComposeColor(0xFF002b36),
        )

        val SolarizedLight = ColorScheme(
            black = ComposeColor(0xFF002b36),
            red = ComposeColor(0xFFdc322f),
            green = ComposeColor(0xFF859900),
            yellow = ComposeColor(0xFFb58900),
            blue = ComposeColor(0xFF268bd2),
            magenta = ComposeColor(0xFFd33682),
            cyan = ComposeColor(0xFF2aa198),
            white = ComposeColor(0xFFeee8d5),
            brightBlack = ComposeColor(0xFF073642),
            brightRed = ComposeColor(0xFFcb4b16),
            brightGreen = ComposeColor(0xFF586e75),
            brightYellow = ComposeColor(0xFF657b83),
            brightBlue = ComposeColor(0xFF839496),
            brightMagenta = ComposeColor(0xFF6c71c4),
            brightCyan = ComposeColor(0xFF93a1a1),
            brightWhite = ComposeColor(0xFFfdf6e3),
            content = ComposeColor(0xFF657b83),
            background = ComposeColor(0xFFfdf6e3),
        )

        val Ubuntu = ColorScheme(
            black = ComposeColor(0xFF171421),
            red = ComposeColor(0xFFc21a23),
            green = ComposeColor(0xFF26a269),
            yellow = ComposeColor(0xFFa2734c),
            blue = ComposeColor(0xFF0037da),
            magenta = ComposeColor(0xFF881798),
            cyan = ComposeColor(0xFF3a96dd),
            white = ComposeColor(0xFFcccccc),
            brightBlack = ComposeColor(0xFF767676),
            brightRed = ComposeColor(0xFFc01c28),
            brightBlue = ComposeColor(0xFF08458f),
            brightMagenta = ComposeColor(0xFFa347ba),
            brightCyan = ComposeColor(0xFF2c9fb3),
            brightWhite = ComposeColor(0xFFf2f2f2),
            content = ComposeColor(0xFFffffff),
            background = ComposeColor(0xFF300a24),
        )

//        val Template = ColorScheme(
//            black = ComposeColor(0xFF),
//            red = ComposeColor(0xFF),
//            green = ComposeColor(0xFF),
//            yellow = ComposeColor(0xFF),
//            blue = ComposeColor(0xFF),
//            magenta = ComposeColor(0xFF),
//            cyan = ComposeColor(0xFF),
//            white = ComposeColor(0xFF),
//            brightBlack = ComposeColor(0xFF),
//            brightRed = ComposeColor(0xFF),
//            brightGreen = ComposeColor(0xFF),
//            brightYellow = ComposeColor(0xFF),
//            brightBlue = ComposeColor(0xFF),
//            brightMagenta = ComposeColor(0xFF),
//            brightCyan = ComposeColor(0xFF),
//            brightWhite = ComposeColor(0xFF),
//            content = ComposeColor(0xFF),
//            background = ComposeColor(0xFF),
//        )
    }
}

private infix fun String.edit(color: Int) = AnsiConstants::class.java
    .getDeclaredField(this)
    .apply { isAccessible = true }
    .set(null, color)
