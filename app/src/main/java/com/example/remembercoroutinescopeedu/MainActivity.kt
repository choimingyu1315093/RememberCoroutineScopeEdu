package com.example.remembercoroutinescopeedu

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.remembercoroutinescopeedu.ui.theme.RememberCoroutineScopeEduTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scope = rememberCoroutineScope()
//            var text by remember { mutableStateOf("Hello, Jetpack Compose!") }

            var text1 by remember { mutableStateOf("1번 준비") }
            var text2 by remember { mutableStateOf("2번 준비") }
            var text3 by remember { mutableStateOf("3번 준비") }

            RememberCoroutineScopeEduTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(
                        modifier = Modifier
                            .padding(innerPadding)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = text1, style = MaterialTheme.typography.bodyLarge)
                            Text(text = text2, style = MaterialTheme.typography.bodyLarge)
                            Text(text = text3, style = MaterialTheme.typography.bodyLarge)
                            Spacer(modifier = Modifier.height(16.dp))
                            Button(onClick = {
//                                scope.launch {
//                                    text = "로딩..."
//                                    delay(20000)
//                                    text = "데이터 로드 완료!!"
//                                }
                                scope.launch {
                                    launch {
                                        delay(2000)
                                        text1 = "1번 완료"
                                    }
                                    launch {
                                        delay(2000)
                                        text2 = "2번 완료"
                                    }
                                    launch {
                                        delay(2000)
                                        text3 = "3번 완료"
                                    }
                                }
                            }) {
                                Text("코루틴 시작하기")
                            }
                            Button(onClick = {
                                Toast.makeText(applicationContext, "메시지입니다.", Toast.LENGTH_SHORT).show()
                            }) {
                                Text("메세지 호출")
                            }

                        }
                    }
                }
            }
        }
    }
}
