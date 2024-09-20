package com.example.taskscheduler.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SearchFilterRow(
    modifier: Modifier = Modifier,
    filters: List<String> = emptyList(),
    selectedFilter: String
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(filters) { filter ->
            FilterChip(
                selected = filter == selectedFilter,
                onClick = { /*TODO*/ },
                label = {
                    Text(text = filter)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchFilterPrev() {
    SearchFilterRow(
        modifier = Modifier.fillMaxWidth(),
        filters = listOf(
            "Top",
            "Tasks",
            "Descriptions",
            "Folders",
            "wednesday"
        ),
        selectedFilter = "Top"
    )
}