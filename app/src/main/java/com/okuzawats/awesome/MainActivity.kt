package com.okuzawats.awesome

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Scaffold(
                    bottomBar = {
                        // FIXME BottomAppBarの引数にActionとFABを渡すように修正する。
                        //  現在、上記のコードがビルドエラーとってしまうため、自力で配置する。
                        BottomAppBar {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 12.dp, end = 16.dp, bottom = 12.dp),
                            ) {
                                Spacer(
                                    modifier = Modifier
                                        .weight(1f)
                                        .fillMaxHeight(),
                                )
                                FloatingActionButton(
                                    onClick = {
                                        /*TODO*/
                                    },
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.baseline_add_24),
                                        contentDescription = "add", // TODO contentDescriptionの設定
                                        modifier = Modifier
                                            .width(24.dp)
                                            .height(24.dp),
                                    )

                                }
                            }
                        }
                    },
                ) { padding ->
                    Text(
                        text = "text",
                        modifier = Modifier
                            .padding(padding),
                    )
                }
            }
        }
    }
}
