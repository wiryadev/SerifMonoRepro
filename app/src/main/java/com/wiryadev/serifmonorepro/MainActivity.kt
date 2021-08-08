package com.wiryadev.serifmonorepro

import android.graphics.Typeface
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.material.composethemeadapter.MdcTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MdcTheme {
                SerifMonoRepo()
            }
        }
    }
}

@Composable
fun SerifMonoRepo() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = "Sans Serif Black", style = MaterialTheme.typography.h6, fontSize = 24.sp)
            Text(text = "Monospace", style = MaterialTheme.typography.subtitle2, fontSize = 24.sp)
            Text(text = "Serif Monospace", style = MaterialTheme.typography.body2, fontSize = 24.sp)
        }
        Divider(
            Modifier.padding(vertical = 24.dp)
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = "Serif Monospace Compose", style = MaterialTheme.typography.body2, fontSize = 24.sp)
            AndroidView(
                factory = { context ->
                    TextView(context).apply {
                        layoutParams = LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
                        text = "Serif Monospace XML"
                        typeface = Typeface.create("serif-monospace", Typeface.NORMAL)
                        textSize = 24.dp.value
                    }
                },
            )
        }
    }
}