package com.example.taskscheduler.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.taskscheduler.ui.components.dynamicGradient
import com.kizitonwose.calendar.compose.HorizontalCalendar
import com.kizitonwose.calendar.compose.rememberCalendarState
import com.kizitonwose.calendar.core.firstDayOfWeekFromLocale
import kotlinx.coroutines.launch
import java.time.YearMonth

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
//fun HomeScreen(
//    modifier: Modifier = Modifier
//) {
//    // TODO change to the theme color after
//    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
//    val datePickerState = rememberDatePickerState()
//    val scope = rememberCoroutineScope()
//
//    val currentMonth = remember { YearMonth.now() }
//    val startMonth = remember { currentMonth.minusMonths(100) }
//    val endMonth = remember { currentMonth.plusMonths(100) }
//    val firstDayOfWeek = remember { firstDayOfWeekFromLocale() }
//    val calendarState = rememberCalendarState(
//        startMonth = startMonth,
//        endMonth = endMonth,
//        firstVisibleMonth = currentMonth,
//        firstDayOfWeek = firstDayOfWeek
//    )
//
//    ModalNavigationDrawer(
//        drawerState = drawerState,
//        drawerContent = {
//            TaskScreen(
//                modifier = Modifier.fillMaxWidth(0.9f)
//            )
//        }
//    ) {
//        Scaffold(
//            topBar = {
//                HomeTopBar(
//                    onMenuClick = {
//                        scope.launch {
//                            drawerState.open()
//                        }
//                    }
//                )
//            },
//            floatingActionButton = {
//                IconButton(onClick = { /*TODO*/ }) {
//
//                }
//            },
//            bottomBar = { }
//        ) { padding ->
//            Column(
//                modifier = modifier
//                    .background(
//                        MaterialTheme.colorScheme.surface
//                    )
//                    .padding(padding)
//            ) {
//                DatePicker(
//                    modifier = Modifier.fillMaxWidth(),
//                    state = datePickerState
//                )
//
////                HorizontalCalendar(
////                    state = calendarState,
////                    dayContent = {
////                        Text(text = it.date.dayOfMonth.toString())
////                    }
////                )
//            }
//        }
//    }
//}

fun HomeScreen(
    modifier: Modifier = Modifier
) {
    val datePickerState = rememberDatePickerState()

    Column(
        modifier = modifier
            .background(
                MaterialTheme.colorScheme.surface
            )
    ) {

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeTopBar(
    modifier: Modifier = Modifier,
    onMenuClick: () -> Unit
) {
    TopAppBar(
        modifier = modifier,
        navigationIcon = {
            IconButton(onClick = onMenuClick) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = null
                )
            }
        },
        title = { Text(text = "Home") }
    )
}