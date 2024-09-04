package com.example.taskscheduler.ui.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.taskscheduler.data.Task
import com.example.taskscheduler.ui.components.BottomNavigationBar
import com.example.taskscheduler.ui.components.TaskView
import com.example.taskscheduler.ui.components.TopAppNavBar
import com.example.taskscheduler.ui.components.dynamicGradient
import com.example.taskscheduler.utils.Routes
import com.kizitonwose.calendar.compose.HorizontalCalendar
import com.kizitonwose.calendar.compose.rememberCalendarState
import com.kizitonwose.calendar.core.firstDayOfWeekFromLocale
import kotlinx.coroutines.launch
import java.time.YearMonth

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onNavItemClick: (Routes) -> Unit
) {
    val tasks = remember {
        mutableListOf(
            Task(
                title = "Task 1",
                description = "Description 1"
            ),
            Task(
                title = "Task 2",
                description = "Description 2 alsh flaksdh fklasjdhf lkasdh fkljasd flkjahsdlkfjalsdkjf"
            )
        )
    }

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppNavBar(
                route = Routes.Home.route
            )
        },
        bottomBar = {
            BottomNavigationBar(
                modifier = Modifier
                    .fillMaxWidth(),
                selectedItem = Routes.Home,
                onNavItemClick = {route ->
                    onNavItemClick(route)
                }
            )
        }
    ) {innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ) {
            LazyColumn {
                items(tasks) { task ->
                    TaskView(
                        modifier = Modifier.fillMaxWidth(),
                        task = task,
                        onTaskViewClick = {

                        }
                    )

                    Spacer(modifier = Modifier.height(2.dp))
                }
            }
        }
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