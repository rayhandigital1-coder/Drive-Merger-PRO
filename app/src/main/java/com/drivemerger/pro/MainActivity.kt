package com.drivemerger.pro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Blue = Color(0xFF4285F4)
private val Dark = Color(0xFF10131A)
private val CardColor = Color(0xFF1B2230)
private val Green = Color(0xFF22C55E)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DriveMergerApp()
        }
    }
}

@Composable
fun DriveMergerApp() {
    var syncing by remember { mutableStateOf(false) }
    var message by remember { mutableStateOf("") }

    MaterialTheme(
        colorScheme = darkColorScheme(
            primary = Blue,
            background = Dark,
            surface = CardColor
        )
    ) {
        Scaffold(
            containerColor = Dark
        ) { padding ->

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                item {
                    Column {
                        Text(
                            "Drive Merger PRO",
                            fontSize = 26.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )

                        Text(
                            "Multi-account Cloud Storage",
                            color = Color.LightGray
                        )
                    }
                }

                item {
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = CardColor
                        ),
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(20.dp)
                        ) {
                            Text(
                                "Total Cloud Storage",
                                color = Color.LightGray
                            )

                            Spacer(
                                modifier = Modifier.height(8.dp)
                            )

                            Text(
                                "150 GB",
                                fontSize = 34.sp,
                                fontWeight = FontWeight.Bold,
                                color = Blue
                            )

                            Text(
                                "10 Google Accounts",
                                color = Color.LightGray
                            )

                            Spacer(
                                modifier = Modifier.height(16.dp)
                            )

                            LinearProgressIndicator(
                                progress = { 0.35f },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(8.dp),
                                color = Blue,
                                trackColor = Color.DarkGray
                            )

                            Spacer(
                                modifier = Modifier.height(8.dp)
                            )

                            Text(
                                "35% Used • 65% Available",
                                color = Color.LightGray,
                                fontSize = 12.sp
                            )
                        }
                    }
                }

                item {
                    Text(
                        "Connected Accounts",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }

                items(3) { index ->
                    AccountCard(
                        accountName = "Google Account ${index + 1}",
                        storage = listOf(
                            "12.4 GB available",
                            "14.2 GB available",
                            "10.8 GB available"
                        )[index]
                    )
                }

                item {
                    OutlinedButton(
                        onClick = {
                            message =
                                "Google account connection will be added next."
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("+ Add Google Account")
                    }
                }

                item {
                    Text(
                        "Folder Synchronization",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }

                item {
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = CardColor
                        ),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                "Auto Backup Folder",
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )

                            Spacer(
                                modifier = Modifier.height(6.dp)
                            )

                            Text(
                                "Select a folder to synchronize",
                                color = Color.LightGray,
                                fontSize = 13.sp
                            )

                            Spacer(
                                modifier = Modifier.height(16.dp)
                            )

                            Button(
                                onClick = {
                                    message =
                                        "Folder selection will be added next."
                                },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("Select Folder")
                            }
                        }
                    }
                }

                item {
                    Text(
                        "Upload Manager",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }

                item {
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = CardColor
                        ),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement =
                                    Arrangement.SpaceBetween
                            ) {
                                Text(
                                    "Upload Progress",
                                    color = Color.White
                                )

                                Text(
                                    "0%",
                                    color = Blue,
                                    fontWeight = FontWeight.Bold
                                )
                            }

                            Spacer(
                                modifier = Modifier.height(12.dp)
                            )

                            LinearProgressIndicator(
                                progress = { 0f },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(8.dp),
                                color = Blue,
                                trackColor = Color.DarkGray
                            )

                            Spacer(
                                modifier = Modifier.height(16.dp)
                            )

                            Button(
                                onClick = {
                                    syncing = !syncing
                                    message =
                                        if (syncing) {
                                            "Sync paused"
                                        } else {
                                            "Sync interface activated"
                                        }
                                },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    if (syncing) "Pause Sync"
                                    else "Start Sync"
                                )
                            }
                        }
                    }
                }

                item {
                    if (message.isNotEmpty()) {
                        Text(
                            message,
                            color = Green,
                            fontSize = 13.sp
                        )
                    }
                }

                item {
                    Text(
                        "Drive Merger PRO • Version 1.0",
                        color = Color.Gray,
                        fontSize = 12.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 12.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun AccountCard(
    accountName: String,
    storage: String
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = CardColor
        ),
        shape = RoundedCornerShape(14.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .background(
                        Blue,
                        RoundedCornerShape(12.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "G",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }

            Spacer(
                modifier = Modifier.width(12.dp)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    accountName,
                    color = Color.White,
                    fontWeight = FontWeight.Medium
                )

                Text(
                    storage,
                    color = Color.LightGray,
                    fontSize = 12.sp
                )
            }

            Text(
                "●",
                color = Green
            )
        }
    }
}
